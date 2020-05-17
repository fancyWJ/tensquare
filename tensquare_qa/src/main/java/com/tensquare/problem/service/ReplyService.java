package com.tensquare.problem.service;


import com.tensquare.problem.dao.ReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReplyService {
    @Autowired
    private ReplyDao replyDao;
}
