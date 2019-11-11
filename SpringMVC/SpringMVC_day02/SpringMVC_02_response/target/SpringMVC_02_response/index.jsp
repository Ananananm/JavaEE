<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2019-11-11
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载绑定单击事件
        $(function () {

            $("#btn").click(function () {
                //发送Ajax请求
                $.ajax({
                    // 配置请求参数
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    dataType: "json",
                    type: "post",
                    // 请求的json数据
                    data: '{"name":"myname","password":"mypassowrd","age":30}',
                    // 回调函数,处理服务器返回的数据returnData
                    success: function (data) {
                        console.log(data);
                    }
                });

            });
        });

    </script>
</head>
<body>
    <a href="user/testString">testString</a><br>
    <a href="user/testVoid">testVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

    <button id="btn">测试btn</button>
</body>
</html>
