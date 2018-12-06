package com.ssm.service;

import com.ssm.pojo.AllTable;
import com.ssm.pojo.Params;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AllTableService {

    /**
     * 分页查询所有的表名
     * @return
     */
    List<HashMap<String,Object>> getAllTable(Params params);

    /**
     * 求总记录数
     */
    int count();

    /**
     * 验证表名是否存在
     * @param table_name
     * @return
     */
    AllTable searchtablenameIsExists(@Param("table_name") String table_name);



}
