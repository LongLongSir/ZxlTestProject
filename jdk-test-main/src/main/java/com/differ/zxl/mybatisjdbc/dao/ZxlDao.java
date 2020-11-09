package com.differ.zxl.mybatisjdbc.dao;

import org.apache.ibatis.annotations.Param;

public interface ZxlDao {

    void insertData(@Param("i") int i);
}
