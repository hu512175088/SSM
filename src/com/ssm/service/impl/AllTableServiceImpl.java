package com.ssm.service.impl;

import com.ssm.dao.AllTableMapper;
import com.ssm.pojo.AllTable;
import com.ssm.service.AllTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AllTableServiceImpl implements AllTableService {

    @Resource
    private AllTableMapper mapper;

    @Override
    public List<AllTable> getAllTable() {
        return mapper.getAllTable();
    }

    @Override
    public int count(AllTable allTable) {
        // TODO Auto-generated method stub
        return mapper.count(allTable);
    }

    @Override
    public AllTable searchtablenameIsExists(String table_name) {
        return mapper.searchtablenameIsExists(table_name);
    }
}
