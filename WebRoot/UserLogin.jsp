<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%--%>
	<%--String path = request.getContextPath();--%>
	<%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>登录页面</title>
	<%--<meta name="keywords" content="" />--%>
	<%--<meta name="description" content="" /> --%>

	<link rel="stylesheet" type="text/css" href="./css1/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="./css1/util.css">
	<link rel="stylesheet" type="text/css" href="./css1/main.css">
	<link rel="stylesheet" type="text/css" href="./css1/stylealert.css" >
	<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
 	<%--<script type="text/javascript" src="ReportServer?op=emb&resource=finereport.js"></script>--%>
 	<%--<script type="text/javascript" src="../js/ui.js"></script>--%>
	<script src="js/jquery-1.8.3.js"></script>
	<script src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="./js/userLogin.js"></script>

</head>

<body>

	<div class="limiter">
		<div class="container-login100" style="background-image: url('css/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<%--<form class="login100-form validate-form" name="login" method="POST">--%>
					<span id="loginTiShi" style="color: red;">${illegalLogiin }</span>
					<span class="login100-form-title p-b-49">KEER登录</span>
					<span id="loginTiShi" style="color: red;"></span>
					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100" id="loginTiShi1">用户名</span>
						<input id="username" class="input100" type="text" name="userCode" placeholder="请输入用户名" autocomplete="off" >
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100" >密码</span>
						<input id="password" class="input100" type="password" name="password" placeholder="请输入密码" >
						<span class="focus-input100" data-symbol="&#xf190;" ></span>
					</div>
					<span id="loginTiShi2"></span>

					<div class="text-right p-t-8 p-b-31">
						<a style="font-size: 15px" href="/goUserRegister">还没账号?点击注册</a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<!--<input type="button" value="登录" onclick="copyText();" class = "login100-form-btn"/>-->
							<%--<input type="button" class="login100-form-btn"value="登  录" id="btn_Login"></input>--%>
							<button type="button" class="login100-form-btn" id="btn_Login">登 录</button>
						</div>
					</div>

					<%--<div class="txt1 text-center p-t-54 p-b-20">--%>
						<%--<span>第三方登录</span>--%>
					<%--</div>--%>

					<%--<div class="flex-c-m">--%>
						<%--<a href="#" class="login100-social-item bg1">--%>
							<%--<i class="fa fa-wechat"></i>--%>
						<%--</a>--%>

						<%--<a href="#" class="login100-social-item bg2">--%>
							<%--<i class="fa fa-qq"></i>--%>
						<%--</a>--%>

						<%--<a href="#" class="login100-social-item bg3">--%>
							<%--<i class="fa fa-weibo"></i>--%>
						<%--</a>--%>
					<%--</div>--%>

					<%--<div class="flex-col-c p-t-25">--%>
						<%--<a href="javascript:" class="txt2">立即注册</a>--%>
					<%--</div>--%>
				<%--</form>--%>
			</div>
		</div>
	</div>

	<script src="js/main.js"></script>
</body>

</html>