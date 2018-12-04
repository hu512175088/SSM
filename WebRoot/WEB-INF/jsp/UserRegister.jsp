<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link href="css/userRegister.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/userRegister.js"></script>
</head>
<body>
    <div id="userRegisterFirstDiv">
        <h1>欢迎来到注册页面</h1>

            <table>
                <tr>
                    <td style="font-size: 15px">
                        已有账号,直接<a style="font-size: 15px" href="/goUserLogin">登录</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span id="tiShiSpan"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" id="userCode" name="" placeholder="登录账号">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" id="password" name="" placeholder="登录密码">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" id="userName" name="" placeholder="真实姓名">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" value="注  册" id="btn_register">
                    </td>
                </tr>
            </table>

    </div>
</body>
</html>