package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.AllTable;
import com.ssm.service.AllTableService;
import com.ssm.service.impl.DownloadUtil;
import com.ssm.service.impl.Extport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DowloadController {

    @Resource
    private Extport extport;

    @Resource
    private AllTableService allTableService = null;

    @Resource
    private DownloadUtil downloadUtil;

    @RequestMapping("/goDowFile")
    @ResponseBody
    public String DowFile(
            @RequestParam("table_name") String table_name,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if (table_name != null) {
                extport.OuteXlsx(table_name, request, response);
                resultMap.put("Export", true);
            } else {
                resultMap.put("Export", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(resultMap);
    }


    /**
     * 处理输入表名
     */
    @RequestMapping("/validatetable_name")
    @ResponseBody
    public Object validatetable_name(
            HttpSession session,
            @RequestParam("table_name") String table_name
    ) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        AllTable resultTable = allTableService.searchtablenameIsExists(table_name);
        if (resultTable != null) {// 需导出表是否存在
            if (table_name.equals(resultTable.getTable_Name())) {
                session.setAttribute("AllTable", resultTable);
                resultMap.put("outMessage", true);
            } else {
                resultMap.put("outMessage", false);
            }
        } else {
            resultMap.put("outMessage", false);
        }
        return JSON.toJSONString(resultMap);
    }


    /**
     * 跳转到到文件页面
     */
    @RequestMapping("/goFileDow")
    public String goDowFile() {
        return "FileDow";
    }


    /**
     * 文件下载
     */
    @RequestMapping("/goDownload")
    @ResponseBody
    public void fileDownload(HttpServletResponse response,
                               HttpServletRequest request,
                               HttpSession session
    ) {
        AllTable allTable = (AllTable) session.getAttribute("AllTable");
        String table_name = allTable.getTable_Name();
        downloadUtil.fileDownload(response, request, table_name);

    }

}
