package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class RecuirService {
    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    public List<Recruit> findAll(){
        return recruitDao.findAll();
    }
    public Recruit findById(String recruitId){
        return recruitDao.findById(recruitId).get();
    }


    public List<Recruit> recommand1(){
        return  recruitDao.findTop6ByStateOrderByCreatetimeDesc("2");
    }

    public List<Recruit> recommand2(){
        return  recruitDao.findTop6ByStateNotOrderByCreatetimeDesc("0");
    }
}
