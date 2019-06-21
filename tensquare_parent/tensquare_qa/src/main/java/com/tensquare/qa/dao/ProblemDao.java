package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    @Query(value = "SELECT * FROM tb_problem tp  JOIN  tb_pl ON id = problemid AND labelid = ?1 ORDER BY tp.createtime DESC",nativeQuery = true)
    public Page<Problem> newList(String labelId, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem tp  JOIN  tb_pl ON id = problemid AND labelid = ?1  ORDER BY tp.reply DESC",nativeQuery = true)
    public Page<Problem> hotList(String labelId, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem tp  JOIN  tb_pl ON id = problemid AND labelid = ?1 AND tp.reply = 0  ORDER BY tp.createtime DESC",nativeQuery = true)
    public Page<Problem> waitList(String labelId, Pageable pageable);
}
