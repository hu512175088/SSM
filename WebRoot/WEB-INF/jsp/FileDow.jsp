<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Title</title>
</head>
<body>
    导出文件成功 请点击下载,将导出的${sessionScope.AllTable.table_Name}下载到本地
    <div>
    <input id="down" type="button" value="下载${sessionScope.AllTable.table_Name}">
    </div>
</body>
</html>
