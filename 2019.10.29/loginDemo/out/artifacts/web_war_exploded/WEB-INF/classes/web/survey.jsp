<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Survey Questionnaire Form by Tooplate</title>
	<!--
    Template 2105 Input
	http://www.tooplate.com/view/2105-input
	-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
    <link rel="stylesheet" href="css/tooplate.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/materialize.min.css">
    <link rel="stylesheet" href="css/tooplate.css">

</head>

<body id="survey" class="font-weight-light">
    <div class="container tm-container-max-800">
        <div class="row">
            <div class="col-12">
                <header class="mt-5 mb-5 text-center">
                    <h1 class="font-weight-light tm-form-title"><%= request.getAttribute("msg")%></h1>
                    <p class="tm-form-description"> <%= request.getAttribute("scoreMsg")%></p>
                </header>
                <form action="traffic" method="post">


                    <div class="tm-bg-black tm-form-block">
                        <p class="mb-4">违章处理：</p>
                        <div class="row mb-4">
                            <div class="col-xl-6">
                                <div class="input-field">
                                    <select name="score">
                                        <option value="3">违停</option>
                                        <option value="6">闯红灯</option>
                                        <option value="12">酒驾</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-12">
                                <textarea class="p-3" name="message" id="message" cols="30" rows="3" placeholder="可填写详细描述..."></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="text-center mt-5">
                        <input type="submit" class="waves-effect btn-large" value="提交">
                    </div>
                </form>
            </div>
        </div>
        <footer class="row tm-mt-big mb-3">
            <div class="col-xl-12">
                <p class="text-center grey-text text-lighten-2 tm-footer-text-small">
                    安全行车，和谐中国！
                </p>
            </div>
        </footer>
    </div>

    <script src="js/aa.js"></script>
    <script src="js/bb.js"></script>
    <script>
        $(document).ready(function () {
            $('select').formSelect();
        });
    </script>
</body>

</html>