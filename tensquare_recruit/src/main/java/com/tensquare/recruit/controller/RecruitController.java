package com.tensquare.recruit.controller;

import com.tensquare.recruit.service.RecuirService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecuirService recuirService;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",recuirService.findAll());
    }

    @RequestMapping(value = "/recuitId",method = RequestMethod.GET)
    public Result findById(@PathVariable("recuitId") String recuitId){
        return new Result(true,StatusCode.OK,"查询成功",recuirService.findById(recuitId));
    }


    @RequestMapping(value = "/search/recommand",method = RequestMethod.GET)
    public Result recommand(){
        return new Result(true,StatusCode.OK,"查询成功",recuirService.recommand1());
    }
    @RequestMapping(value = "/search/newList",method = RequestMethod.GET)
    public Result newList(){
        return new Result(true,StatusCode.OK,"查询成功",recuirService.recommand2());
    }

}
