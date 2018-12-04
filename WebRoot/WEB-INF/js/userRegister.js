$().ready(function(){
	$("#btn_register").click(function(){
		// 统一提示框
		var tiShiSpan = $("#tiShiSpan");
		// 获取登录账号
		var userCode = $("#userCode").val();
		// 获取登录密码
		var password = $("#password").val();
		// 获取真实姓名
		var userName = $("#userName").val();
		// 获取出生日期
		var birthday = $("#birthday").val();
		if (userCode == '') {
			tiShiSpan.text("登录账号不能为空").css({"color":"red"});
		} else if (password == '') {
			tiShiSpan.text("登录密码不能为空").css({"color":"red"});
		} else if (userName == '') {
			tiShiSpan.text("真实姓名不能为空").css({"color":"red"});
		}  else {
			tiShiSpan.text("");
			// 验证用户登录账号是否存在
			$.post(
				"validateUserCodeIsExists",
				{
					"userCode":userCode
				},
				function(data) {
					var result = eval("(" + data + ")");
					if (result.valiResult == true) {// 不存在
						tiShiSpan.text("")
						// 添加
	    				$.post(
	    					"addUserRegister",
	    					{
	    						"userCode":userCode,
	    						"password":password,
	    						"userName":userName,
	    					},
	    					function(result) {
	    						var addResule = eval("(" + result + ")");
	    						if (addResule.addResult == true) {
	    							alert("注册成功!");
	    							location = "goUserLogin";
	    						} else {
	    							alert("注册失败!");
	    						}
	    					}
	    				),"json";
					} else {
						tiShiSpan.text("登录账号已被注册!请重新输入").css({"color":"red"});
					}
				}
			),"json";
		}
	});
});