package com.tensquare.problem.controller;

import com.tensquare.problem.client.LableClient;
import com.tensquare.problem.pojo.Problem;
import com.tensquare.problem.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problem")
@CrossOrigin
public class ProblemController {
    @Autowired
    private ProblemService problemService;
    @Autowired
    private LableClient lableClient;
    @RequestMapping(value = "/newList/{lableId}/{page}/{size}")
    public Result newList(@PathVariable String lableId,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageData = problemService.newList(lableId,page,size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
    }

    @RequestMapping(value = "/hotList/{lableId}/{page}/{size}")
    public Result hotList(@PathVariable String lableId,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageData = problemService.hotList(lableId,page,size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
    }

    @RequestMapping(value = "/waitList/{lableId}/{page}/{size}")
    public Result waitList(@PathVariable String lableId,@PathVariable int page,@PathVariable int size){
        Page<Problem> pageData = problemService.waitList(lableId,page,size);
        return new Result(true, StatusCode.OK,"查询成功",new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
    }
    @RequestMapping(value = "/label/{labelId}")
    public Result findLabelById(@PathVariable String labelId){
        Result result = lableClient.findById(labelId);
        return result;
    }
}
