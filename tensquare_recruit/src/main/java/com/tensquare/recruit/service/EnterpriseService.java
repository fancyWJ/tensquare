package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;
    public List<Enterprise> hotList(String ishot){
        return enterpriseDao.findByIshot(ishot);
    }
}
