package com.tensquare.problem.dao;

import com.tensquare.problem.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemDao extends JpaRepository<Problem,String> , JpaSpecificationExecutor<Problem> {
    @Query(value = "SELECT * FROM `tb_problem` tb,tb_pl tp WHERE tb.id = tp.problemid AND tp.labelid = ? order by replytime DESC",nativeQuery = true)
    public Page<Problem> newList(String labelId, Pageable pageable);
    @Query(value = "SELECT * FROM `tb_problem` tb,tb_pl tp WHERE tb.id = tp.problemid AND tp.labelid = ? order by reply DESC",nativeQuery = true)
    public Page<Problem> hotList(String labelId, Pageable pageable);
    @Query(value = "SELECT * FROM `tb_problem` tb,tb_pl tp WHERE tb.id = tp.problemid AND tp.labelid = ? and reply = 0 order by createtime DESC",nativeQuery = true)
    public Page<Problem> waitList(String labelId, Pageable pageable);

}
