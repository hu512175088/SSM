package com.ssm.service.impl;

import com.ssm.dao.AllTableMapper;
import com.ssm.pojo.AllTable;
import com.ssm.pojo.Params;
import com.ssm.service.AllTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class AllTableServiceImpl implements AllTableService {

    @Resource
    private AllTableMapper mapper;

    /**
     * 分页查询所有的表名
     * @return
     */
    @Override
    public List<HashMap<String, Object>> getAllTable(Params params) {

        return mapper.getAllTable(params);
    }


    @Override
    public int count( ) {
        // TODO Auto-generated method stub
        return mapper.count();
    }

    @Override
    public AllTable searchtablenameIsExists(String table_name) {
        return mapper.searchtablenameIsExists(table_name);
    }


}
