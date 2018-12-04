package com.ssm.controller;

import com.ssm.pojo.AllTable;
import com.ssm.service.AllTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AllTableController {

    @Resource
    private AllTableService allTableService=null;

    /**
     * 跳转到所有表展示页
     */
    @RequestMapping("/goAllTable")
    public String goUserItems(
            HttpServletRequest request
            //@RequestParam(value="cp",required=false) String cp
    ) {

		// 获取用户所有数据
        AllTable allTable = new AllTable();
		int count = allTableService.count(allTable);
        List<AllTable> tablenameList = allTableService.getAllTable();
        request.setAttribute("tablenameList", tablenameList);
		request.setAttribute("count", count);
        return "AllTable";
    }
}
