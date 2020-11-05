package com.differ.zxl.jdbc.dao;

import com.differ.zxl.dto.ZxlModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ZxlDao {

    void insertData(@Param("i") int i);
}
