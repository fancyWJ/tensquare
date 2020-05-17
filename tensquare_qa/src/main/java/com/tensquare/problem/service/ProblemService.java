package com.tensquare.problem.service;

import com.tensquare.problem.dao.ProblemDao;
import com.tensquare.problem.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProblemService {
    @Autowired
    private ProblemDao problemDao;
    public Page<Problem> newList(String labelId,int page,int rows){
        Pageable pageable = PageRequest.of(page-1,rows);
        return problemDao.newList(labelId,pageable);
    }

    public Page<Problem> hotList(String labelId,int page,int rows){
        Pageable pageable = PageRequest.of(page-1,rows);
        return problemDao.hotList(labelId,pageable);
    }

    public Page<Problem> waitList(String labelId,int page,int rows){
        Pageable pageable = PageRequest.of(page-1,rows);
        return problemDao.waitList(labelId,pageable);
    }
}
