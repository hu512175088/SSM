<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head >
    <meta charset="UTF-8">
    <title></title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/Blog/css/floating-labels.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <link href="../css/userLogin.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="../js/userLogin.js"></script>
</head>
<body class="image">
<div class="container1 demo-1">
    <div id="userLoginFirstDiv">
        <div class="content">
        <h1>欢迎来到登录页面</h1>
        <table>
            <tr>
                <td style="font-size: 15px">
                    没有账号点击<a style="font-size: 15px" href="/goUserRegister">注册</a>
                </td>
            </tr>
        	<tr>
        		<td><span id="loginTiShi" style="color: red;">${illegalLogiin }</span></td>
        	</tr>
            <tr>
                <td>
                    <input type="text" name="userCode" placeholder="登录账号">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="password" name="password" placeholder="登录密码">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="登  录" id="btn_Login">
                </td>
            </tr>
        </table>
    </div>
        </div>
    </div>
</div>
</body>
</html>