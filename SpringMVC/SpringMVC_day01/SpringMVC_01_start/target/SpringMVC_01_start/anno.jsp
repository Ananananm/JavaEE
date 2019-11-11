<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2019-11-05
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%-- 测试常用的注解   --%>
        <a href="anno/testRequestParam?username=haha">testRequestParam</a>

        <br>

        <form action="anno/testRequestBody" method="post">
            用户名：<input type="text" value="" name="username"> <br>
            密码：<input type="password" value="" name="password"><br>
            <input type="submit" value="提交">
        </form>

        <br>

        <a href="anno/testPathVariable/10?username=haha">testPathVariable</a>

        <br>

        <a href="anno/testRequestHeader/20">testRequestHeader</a>

        <br>

        <a href="anno/testCookieValue">testCookieValue</a>

        <br>

        <form action="anno/testModelAttribute" method="post">
            用户名：<input type="text" value="" name="username"> <br>
            <input type="submit" value="提交">
        </form>

        <br>

        <a href="anno/testSessionAttributes">testCookieValue</a>
        <a href="anno/getSessionAttributes">getSessionAttributes</a>
        <a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>


</body>
</html>
