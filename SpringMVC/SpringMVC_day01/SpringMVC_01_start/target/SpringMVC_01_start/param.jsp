<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2019-11-02
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <a href="param/testParam?username=haha">测试请求参数的绑定</a>--%>

<%-- 封存到AccountDo中       --%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        用户名：<input type="text" value="" name="username"> <br>--%>
<%--        密码：<input type="password" value="" name="password"><br>--%>
<%--        金额：<input type="text" value="" name="money"><br>--%>
<%--        姓名：<input type="text" value="" name="userDO.uname"><br>--%>
<%--        年龄：<input type="text" value="" name="userDO.age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--加入list，map--%>
        <form action="param/saveAccount" method="post">
            用户名：<input type="text" value="" name="username"> <br>
            密码：<input type="password" value="" name="password"><br>
            金额：<input type="text" value="" name="money"><br>
            姓名1：<input type="text" value="" name="list[0].uname"><br>
            年龄1：<input type="text" value="" name="list[0].age"><br>
            姓名2：<input type="text" value="" name="map['one'].uname"><br>
            年龄2：<input type="text" value="" name="map['one].age"><br>
            <input type="submit" value="提交">
        </form>

</body>
</html>
