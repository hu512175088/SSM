<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        body{
            background-image: url("../css/images/bg-01.jpg");
            background-size: cover;
            text-align:center
            /*图片自适应整个页面*/
        }
        .mainbox{
            /*margin: auto;*/
            position:absolute;
            top:30%;
            left:40%;
        }
    </style>
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $().ready(function(){
            $("#down").click(function () {
                var table_name="${sessionScope.AllTable.table_Name}";
                if(table_name !=null) {
                    location="goDownload"
                }
            });
        });
    </script>
    <title>下载页面</title>
</head>
<body>
                <div class="mainbox">
                    <h2>下载页面</h2>
                    <p>导出文件成功 请点击下载,</p>
                    <p> 将导出的${sessionScope.AllTable.table_Name}下载到本地</p>
                    <p></p><input id="down" type="button" value="下载${sessionScope.AllTable.table_Name}"></p>
                </div>
</body>
</html>
