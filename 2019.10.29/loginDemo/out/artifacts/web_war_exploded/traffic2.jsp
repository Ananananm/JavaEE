<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2019-10-27
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            width: 100%;
            margin: auto;
            background: red;
        }

    </style>
</head>
<body>
<div>
    <h2>
        <%= request.getAttribute("msg")%>
    </h2>

    <p><%= request.getAttribute("scoreMsg")%>
    </p>
    <form method="post" action="traffic">
        违章处理：
        <select name="score">
            <option value="3">违停</option>
            <option value="6">闯红灯</option>
            <option value="12">酒驾</option>
        </select>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
