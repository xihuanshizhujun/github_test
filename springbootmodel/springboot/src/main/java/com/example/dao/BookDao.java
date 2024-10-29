package com.example.dao;

import com.example.entity.Book;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BookDao extends Mapper<Book> {

    List<Book> findBySearch(@Param("params") Params params);
}