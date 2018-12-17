$().ready(function(){
    $("#btn_Login").click(function(){
        // 隐式迭代
        var userCode = $("input[name='userCode']").val();
        var password = $("input[name='password']").val();
        var loginTiShi1 = $("#loginTiShi1");
        var loginTiShi2 = $("#loginTiShi2");
        if (userCode == "") {
            loginTiShi1.text("登录账号不能为空").css({"color":"red"});
        } else if (password == "") {
            loginTiShi2.text("密码不能为空").css({"color":"red"});
        } else {
            loginTiShi1.text("");
            loginTiShi2.text("");
            $.post(
                "validateLoginUser",
                {"userCode":userCode,"password":password},
                function (data) {
                    var result = eval("(" + data + ")");
                    if (result.loginMessage == true) {
                        // 登录成功
                        location = "goAllTable";
                    } else {
                        loginTiShi1.text("登录账号或密码错误").css({"color":"red"});
                    }
                }
            ),"json";
        }
    });
});