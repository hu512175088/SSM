<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<link href="css/cron.css" rel="stylesheet" type="text/css">
<body>
<!-- 主页面 -->
<div class="content">
    <form action="goSetDynamicCronTask" method="post">
        <label>设置定时任务:</label>
        <input id="shopName" type="text" name="setCron" class="form-control" maxlength="20"/><br><br>
        <input class="submit" type="submit" value="提交"/>
    </form>
</div>
    <h1>常用表达式例子</h1>
    　　<p>（1）0 0 2 1 * ? *   表示在每月的1日的凌晨2点调整任务</p>
    　　<p>（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业</p>
    　　<p>（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作</p>
    　　<p>（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点</p>
    　　<p>（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时</p>
    　　<p>（6）0 0 12 ? * WED    表示每个星期三中午12点</p>
    　　<p>（7）0 0 12 * * ?   每天中午12点触发</p>
    　　<p>（8）0 15 10 ? * *    每天上午10:15触发</p>
    　　<p>（9）0 15 10 * * ?     每天上午10:15触发</p>
    　　<p>（10）0 15 10 * * ? *    每天上午10:15触发</p>
    　　<p>（11）0 15 10 * * ? 2005    2005年的每天上午10:15触发</p>
    　　<p>（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发</p>
    　　<p>（13）0 0/5 14 * * ?    在每天下午2点到下午2:55期间的每5分钟触发</p>
    　　<p>（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发</p>
    　　<p>（15）0 0-5 14 * * ?    在每天下午2点到下午2:05期间的每1分钟触发</p>
    　　<p>（16）0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发</p>
    　　<p>（17）0 15 10 ? * MON-FRI    周一至周五的上午10:15触发</p>
    　　<p>（18）0 15 10 15 * ?    每月15日上午10:15触发</p>
    　　<p>（19）0 15 10 L * ?    每月最后一日的上午10:15触发</p>
    　　<p>（20）0 15 10 ? * 6L    每月的最后一个星期五上午10:15触发</p>
    　　<p>（21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发</p>
    　　<p>（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发</p>

    <table class="gridtable" align="center">
        <h2>各字段的含义</h2>

        <tr>
            <th>字段</th>
            <th>允许值</th>
            <th>允许的特殊字符</th>
        </tr>
        <tr>
            <td>秒（Seconds)</td>
            <td>0~59的整数（Seconds</td>
            <td>, - * / 四个字符</td>
        </tr>
        <tr>
            <td>分（Minutes)</td>
            <td>0~59的整数</td>
            <td>, - * / 四个字符</td>
        </tr>
        <tr>
            <td>小时（Hours）</td>
            <td>0~23的整数</td>
            <td>, - * / 四个字符</td>
        </tr>
        <tr>
            <td>日期（DayofMonth)</td>
            <td>1~31的整数（但是你需要考虑你月的天数）</td>
            <td>,- * ? / L W C 八个字符</td>
        </tr>
        <tr>
            <td>月份（Month)</td>
            <td>1~31的整数（但是你需要考虑你月的天数）</td>
            <td>, - * / 四个字符</td>
        </tr>
        <tr>
            <td>星期（DayofWeek）</td>
            <td>1~7的整数或者 SUN-SAT （1=SUN）</td>
            <td>, - * ? / L C #     八个字符</td>
        </tr>
        <tr>
            <td>年(可选，留空)（Year）</td>
            <td>1970~2099</td>
            <td>, - * /    四个字符</td>
        </tr>
    </table>

</body>
<script type="text/javascript">
</script>
</html>
