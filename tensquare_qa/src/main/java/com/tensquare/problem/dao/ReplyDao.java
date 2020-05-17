package com.tensquare.problem.dao;

import com.tensquare.problem.pojo.Problem;
import com.tensquare.problem.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReplyDao extends JpaRepository<Reply,String> , JpaSpecificationExecutor<Reply> {
}
