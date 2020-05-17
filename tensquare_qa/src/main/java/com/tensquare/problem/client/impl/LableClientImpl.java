package com.tensquare.problem.client.impl;

import com.tensquare.problem.client.LableClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class LableClientImpl implements LableClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
