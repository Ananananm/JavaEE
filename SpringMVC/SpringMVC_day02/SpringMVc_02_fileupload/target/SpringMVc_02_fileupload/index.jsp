<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2019-11-11
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload文件上传</title>
</head>
<body>
    <h3>传统方式文件上传</h3>
    <form action="/fileUpload/testFileUpLoad1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">

    </form>

    <h3>SpringMVC方式文件上传</h3>
    <form action="/fileUpload/testFileUpLoad2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">

    </form>

    <h3>SpringMVC方式跨服务器文件上传</h3>
    <form action="/fileUpload/testFileUpLoad3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">

    </form>
</body>
</html>
