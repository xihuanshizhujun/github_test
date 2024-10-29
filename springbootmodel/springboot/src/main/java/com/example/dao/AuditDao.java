package com.example.dao;

import com.example.entity.Audit;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface AuditDao extends Mapper<Audit> {

    List<Audit> findBySearch(@Param("params") Params params);
}