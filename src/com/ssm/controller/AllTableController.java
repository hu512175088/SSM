package com.ssm.controller;

import com.ssm.pojo.Params;
import com.ssm.service.AllTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class AllTableController {

    @Resource
    private AllTableService allTableService=null;

    /**
     * 跳转到所有表展示页
     */
    @RequestMapping("/goAllTable")
    public ModelAndView goUserItems(
            Params params
    ) {
        params.setPageNo(0);
        params.setPageSize(15);//查询20条

        //调用业务层
        List<HashMap<String, Object>> allTables = allTableService.getAllTable(params);

        //总条数
		int count = allTableService.count();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allTables",allTables);
        modelAndView.addObject("count", count);
        modelAndView.setViewName("AllTable");

        return modelAndView;
    }
    /**
     * ajax请求 的 分页查询
     * @param params
     * @return
     */

    @RequestMapping("/loadData")
    @ResponseBody
    public HashMap<String, Object> loadData(Params params){

        HashMap<String, Object> map = new HashMap<String, Object>();
        List<HashMap<String, Object>> allTables = allTableService.getAllTable(params);
        map.put("allTables",allTables);

        return map;
    }



}
