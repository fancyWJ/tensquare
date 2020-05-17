package com.tensquare.user.controller;

import com.tensquare.user.pojo.Admin;
import com.tensquare.user.service.AdminService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(String loginname,String password){
        Admin admin = adminService.findByLoginnameAndPassword(loginname,password);
        if(admin != null){
            //生成token
            String token = jwtUtil.createJWT(admin.getId(), admin.getLoginname(), "admin");
            Map map = new HashMap();
            map.put("token",token);
            map.put("name",admin.getLoginname());
            return new Result(true, StatusCode.OK,"登录成功",map);
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.PUT)
    public Result register(@RequestBody Map<String,String> registerMap){
        Admin admin = new Admin();
        admin.setLoginname(registerMap.get("loginname"));
        admin.setPassword(registerMap.get("password"));
        adminService.add(admin);
        return new Result(true, StatusCode.OK,"注册成功");
    }
}
