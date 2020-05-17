package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprice")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;
    @RequestMapping(value = "/search/hotList",method = RequestMethod.GET)
    public Result hotList(){
        List<Enterprise> list =enterpriseService.hotList("1");
        return new Result(true, StatusCode.OK,"查询成功",list);
    }
}
