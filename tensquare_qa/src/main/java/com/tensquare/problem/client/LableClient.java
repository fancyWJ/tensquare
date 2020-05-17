package com.tensquare.problem.client;

import com.tensquare.problem.client.impl.LableClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "tensquare-base",fallback = LableClientImpl.class)
@Component
public interface LableClient {
    @RequestMapping(value = "/label/{id}",method = RequestMethod.GET)
    Result findById(@PathVariable("id") String labelId);
}
