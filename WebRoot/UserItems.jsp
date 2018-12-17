<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%--%>
<%--String path = request.getContextPath();--%>
<%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="css/userItems.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/userItems.js"></script>
</head>
<body>
<div id="userItemsFirstDiv">
    <h1 style="font-size: 38px;">欢迎来到用户管理页面</h1>
    <%--<form action="" method="post">--%>
    	<%--真实姓名:<input type="search" name="userName" placeholder="输入用户真实姓名进行搜索"><br>--%>
    	<%--性别:<select name="gender">--%>
    		<%--<option value="">-- 请选择性别 --</option>--%>
    		<%--<option value="0">男</option>--%>
    		<%--<option value="1">女</option>--%>
    	<%--</select><br>--%>
    	<%--开始日期:<input type="datetime-local" name="startCreateTime">--%>
    	<%--截止日期:<input type="datetime-local" name="endCreateTime">--%>
    	<%--<input type="submit" value="搜  索">--%>
    <%--</form>--%>
    <%--<p style="text-align: center;">--%>
    	<%--总计:${count }条数据--%>
    <%--</p>--%>
    <table>
        <tr>
            <td width="200">用户真实姓名</td>
            <td width="200">用户登录账号</td>
            <td width="200">用户出生日期</td>
            <td width="350">用户注册时间</td>
        </tr>
        <c:forEach items="${userList }" var="ul">
	        <tr>
	            <td>${ul.userName }</td>
	            <td>${ul.userCode }</td>
	            <td>${ul.password }</td>
	            <td>${ul.createTime }</td>
	        </tr>
        </c:forEach>
    </table>
    <div id="pages">
    	<c:if test="${cp != 1 }">
	        <div>
	            <a href="goUserItems?cp=${1 }">首页</a>
	        </div>
	        <div>
	            <a href="goUserItems?cp=${cp - 1 }">上一页</a>
	        </div>
        </c:if>
    	<c:if test="${cp == 1 }">
	        <div>
	            <a href="javascript:void(0)">首页</a>
	        </div>
	        <div>
	            <a href="javascript:void(0)">上一页</a>
	        </div>
        </c:if>
        <c:if test="${cp > 2 }">
	        <div>
	            <a href="goUserItems?cp=${cp - 2 }">${cp - 2 }</a>
	        </div>
	        <div>
	            <a href="goUserItems?cp=${cp - 1 }">${cp - 1 }</a>
	        </div>
        </c:if>
	        <div>
	            <a>${cp }</a>
	        </div>
        <c:if test="${cp < pageCount - 1 }">
	        <div>
	            <a href="goUserItems?cp=${cp + 1 }">${cp + 1 }</a>
	        </div>
	        <div>
	            <a href="goUserItems?cp=${cp + 2 }">${cp + 2 }</a>
	        </div>
        </c:if>
        <c:if test="${cp != pageCount }">
	        <div>
	            <a href="goUserItems?cp=${cp + 1 }">下一页</a>
	        </div>
	        <div>
	            <a href="goUserItems?cp=${pageCount }">最后一页</a>
	        </div>
        </c:if>
        <c:if test="${cp == pageCount }">
	        <div>
	            <a href="javascript:void(0)">下一页</a>
	        </div>
	        <div>
	            <a href="javascript:void(0)">最后一页</a>
	        </div>
        </c:if>
    </div>
</div>
</body>
</html>