<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="css/login.css">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/login.js"></script>
    <title></title>
</head>
<body>
<div class="z_bj" style="background:url(img/timg.jpeg); background-size: cover;"><i></i></div>

<div class="z_uer">

    <div class="z_user_center">

        <h1>
            <c:choose>
                <c:when test="${msg!=null}">
                    ${msg}
                </c:when>
                <c:otherwise>用户登陆</c:otherwise>
            </c:choose>
            </h1>
        <form action="login" method="post">


            <div class="z_uer_name">
                <input type="text" required name="userName" value="" placeholder="用户名">
            </div>

           <div class="z_uer_passd">
                <input type="password" required name="password" value="" placeholder="密码">
           </div>
            <div class="z_uer_other">
                <input type="submit" value="登陆">
            </div>
        </form>
    </div>

</div>


</body>
</html>