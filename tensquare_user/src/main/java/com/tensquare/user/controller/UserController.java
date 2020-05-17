package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = "/register",method = RequestMethod.PUT)
    public Result register(@RequestBody Map<String,String> registerMap){
        User user = new User();
        user.setMobile(registerMap.get("mobile"));
        user.setPassword(registerMap.get("password"));
        userService.add(user);
        return new Result(true, StatusCode.OK,"注册成功");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(String mobile,String password){
        User user = userService.findByMobileAndPassword(mobile, password);
        if(user != null){
            //生成token
            String token = jwtUtil.createJWT(user.getId(), user.getMobile(), "user");
            Map map = new HashMap();
            map.put("token",token);
            map.put("name",user.getMobile());
            return new Result(true,StatusCode.OK,"登录成功",map);
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if(claims == null){
            return new Result(true,StatusCode.ACCESSERROR,"无权限访问");
        }
        userService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
