package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/like/{friend}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friend,@PathVariable String type){
        Claims user_claims = (Claims) request.getAttribute("user_claims");
        if(user_claims == null){
            return new Result(false, StatusCode.ACCESSERROR,"无权限访问");
        }
        if(type.equals("1")){
            if(friendService.addFriend(user_claims.getId(),friend)==0){
                return new Result(false,StatusCode.ERROR,"已添加此好友");
            }else {
                //不喜欢
            }
        }
        return new Result(true,StatusCode.OK,"操作成功");
    }
}
