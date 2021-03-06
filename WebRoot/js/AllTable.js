$().ready(function(){
    $("#export").click(function () {
        var table_name=$("#table_name").val();
        var TiShi = $("#TiShi");
        //alert(table_name);
        if (table_name == "") {
            TiShi.text("表名不能为空哦").css({"color":"red"});
        } else {
            TiShi.text("");
            $.post(
                "validatetable_name",
                {"table_name": table_name},
                function (data) {
                    var result = eval("(" + data + ")");
                    if (result.outMessage == true) {
                        // 验证成功 导出文件
                        TiShi.text("正在导出,数据表较大需耐心等待");
                        $.post(
                            "goDowFile",
                            {"table_name": table_name},
                            function (result) {
                                var outdow = eval("(" + result + ")");
                                if(outdow.Export == true){
                                    location="goFileDow";
                                }else{
                                    alert("系统错误");
                                }
                            }
                        ), "json";

                    }else {
                        TiShi.text("表名错误不要搞事").css({"color":"red"});
                    }
                }
            ), "json";
        }
    });

    var isFirstExport=true;
    function showProgress(){
        $("#Mask").css("height",$(document).height());
        $("#Mask").css("width",$(document).width());
        $("#Mask").show();
        if(isFirstExport){
            $("#Progress").circliful();
        }else{
            $("#Progress .circle-text").text("0%");
            $("#Progress .circle-info").text("导出进度");
            $("#Progress").show();
        }
    }
    //隐藏进度条
    function hideProgress(){
        $("#Mask").hide();
        $("#Progress").hide();
    }


});