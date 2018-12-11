<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
<head>
    <link href="../css/allTable.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/jquery.circliful.css"/>

    <title>分页</title>
    <style>
        /*body{background:url("../css/images/bg-01.jpg");background-size:cover;}*/

    </style>
</head>

<body>
<div class="ke_tabbox">
    <h2 style="font-size: 38px;" align="center">欢迎来到数据表和视图分页展示页面</h2>
    <p style="text-align: center;">
        总计:${count }张视图
    </p>
    <div>
        输入需要导出的表名:<input id="table_name" type="text" >
        <input id="export" type="button" value="导出"><span id="TiShi"></span>
    </div>
    <table class="ke_table">
        <thead>
        <tr>
            <th style="width:25%">序号</th>
            <th style="width:25%">表名</th>
        </tr>
        </thead>

        <tbody id="tbody" data-itemcount="${count}">
        <c:forEach var="all" items="${allTables }">
            <tr>
                <td ><a class="t_avbiaoq" title="${all.ID}">${all.ID}</td>
                <td ><a class="t_avbiaoq" title="${all.TABLE_NAME}">${all.TABLE_NAME}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="krryPage"></div>
</div>

<!-- Mask是遮罩，Progress是进度条 -->
<div>
    <div id="Mask"></div>
    <div id="Progress" data-dimension="200" data-text="0%" data-info="导出进度" data-width="15" data-fontsize="30" data-percent="0" data-fgcolor="#22eeee" data-bgcolor="#6633CC"></div>
</div>




<script src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/krry_page.js"></script>
<script src="js/AllTable.js"></script>
<script type="text/javascript">


    var krryAdminBlog = {
        initPage:function(itemCount){
            $("#krryPage").tzPage(itemCount, {
                num_display_entries : 5, //主体页数
                num_edge_entries : 4,//边缘页数
                current_page : 0,//指明选中页码
                items_per_page : 25, //每页显示多少条
                prev_text : "上一页",
                next_text : "下一页",
                showGo:true,//显示
                showSelect:false,
                callback : function(pageNo, psize) {//会回传两个参数，第一个是当前页数，第二个是每页要显示的数量
                    krryAdminBlog.loadData(pageNo,psize);
                }
            });
        },
        //设置data参数：pageNo（下一页）：就是当前页数 * 下一页要显示的数量
        //            pageSize（下一页）：已经查询出来的数量（pageNo）  + 每页要显示的数量
        //在数据库中是  WN <= pageSize and WN > pageNo 来查询分页数据
        loadData:function(pageNo,pageSize){
            pageNo = pageNo * pageSize;
            pageSize = pageNo + 25;
            $.ajax({
                type:"post",
                url:"/loadData",
                data:{pageNo:pageNo,pageSize:pageSize},
                success:function(data){
                    if(data){
                        var html = "";
                        var allTableArr = data.allTables;
                        for(var i=0,len=allTableArr.length;i < len;i++){
                            var json =allTableArr[i];
                            html+= "<tr>"+
                                "    <td><a class='t_avbiaoq' title='"+json.ID+"'>"+json.ID+"</a></td>"+
                                "    <td><a class='t_avbiaoq' title='"+json.TABLE_NAME+"'>"+json.TABLE_NAME+"</a></td>"+
                                "</tr>";
                        }
                        $("#tbody").html(html);
                    }
                }
            });
        }
    };

    krryAdminBlog.initPage($("#tbody").data("itemcount"));

</script>
<script type="text/javascript" src="js/jquery.circliful.min.js"></script>
</body>
</html>