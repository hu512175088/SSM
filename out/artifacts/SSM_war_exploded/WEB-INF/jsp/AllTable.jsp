<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="css/allTable.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/AllTable.js"></script>

</head>
<body>
<div id="userItemsFirstDiv">
    <h1 style="font-size: 38px;">欢迎来到数据表和视图展示页面</h1>
    <p style="text-align: center;">
        总计:${count }张表和视图
    </p>
    <div>
        输入需要导出的表名:<input id="table_name" type="text" >
        <input id="export" type="button" value="导出"><span id="TiShi"></span>
    </div>
    <table border="0" width="100%" cellpadding="0" cellspacing="1" bgcolor="#ACDDEC">
        <tr>
            <td>序号</td>
            <td width="200">表名</td>
        </tr >
        <c:forEach items="${tablenameList }" var="all" varStatus="status">
            <tr id="v_m">
                <td >${status.index + 1}.</td>
                <td >${all.table_Name}</td>
            </tr>
        </c:forEach>
    </table>
    <%--<div id="pages">--%>
    <%--<c:if test="${cp != 1 }">--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${1 }">首页</a>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${cp - 1 }">上一页</a>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${cp == 1 }">--%>
    <%--<div>--%>
    <%--<a href="javascript:void(0)">首页</a>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<a href="javascript:void(0)">上一页</a>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${cp > 2 }">--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${cp - 2 }">${cp - 2 }</a>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${cp - 1 }">${cp - 1 }</a>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--<div>--%>
    <%--<a>${cp }</a>--%>
    <%--</div>--%>
    <%--<c:if test="${cp < pageCount - 1 }">--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${cp + 1 }">${cp + 1 }</a>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${cp + 2 }">${cp + 2 }</a>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${cp != pageCount }">--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${cp + 1 }">下一页</a>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<a href="goUserItems?cp=${pageCount }">最后一页</a>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${cp == pageCount }">--%>
    <%--<div>--%>
    <%--<a href="javascript:void(0)">下一页</a>--%>
    <%--</div>--%>
    <%--<div>--%>
    <%--<a href="javascript:void(0)">最后一页</a>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--</div>--%>
</div>
</body>
</html>