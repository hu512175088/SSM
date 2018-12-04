package com.ssm.service;

import com.ssm.pojo.AllTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllTableService {

    /**
     * 查询所有的表面视图名
     * @return
     */
    List<AllTable> getAllTable();

    /**
     * 求总记录数
     */
    int count(AllTable allTable);

    /**
     * 验证表名是否存在
     * @param table_name
     * @return
     */
    AllTable searchtablenameIsExists(@Param("table_name") String table_name);
}
