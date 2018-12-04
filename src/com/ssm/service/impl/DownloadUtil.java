package com.ssm.service.impl;

import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 下载文件工具
 */
@Service
public class DownloadUtil {

    public void fileDownload(HttpServletResponse response,
                             HttpServletRequest request,
                             String table_name

    ){
       // String table_name =request.getParameter("table_name");
        //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
        String path = request.getServletContext().getRealPath("/")+"/WEB-INF/file";
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫table_name.xlsx,这里是设置名称)
        response.setHeader("Content-Disposition", "attachment;fileName="+table_name+".xlsx");
        ServletOutputStream out=null;
        FileInputStream inputStream=null;
        //通过文件路径获得File对象
        File file = new File(path + "/" + table_name+".xlsx");
        try {
            inputStream  = new FileInputStream(file);
            //3.通过response获取ServletOutputStream对象(out)
            out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[512];
            while (b != -1){
                b = inputStream.read(buffer);
                if(b != -1){
                    out.write(buffer,0,b);//4.写到输出流(out)中
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(inputStream!=null){
                    inputStream.close();
                }
                if(out!=null){
                    out.close();

                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}