<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/2/17
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
    <script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){
            window.scrollTo(0,1);
        }
    </script>
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="snow-container">
    <div class="snow foreground"></div>
    <div class="snow foreground layered"></div>
    <div class="snow middleground"></div>
    <div class="snow middleground layered"></div>
    <div class="snow background"></div>
    <div class="snow background layered"></div>
</div>
<div class="top-buttons-agileinfo">
    <a href="index.jsp" class="active">登录</a><a href="../jsp/signup.jsp">注册</a>
</div>
<h1>Tickets</h1>
<div class="main-agileits">
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">登录</h2>
        <%--登录--%>
        <form action="queryUser.action" method="post">
            <input type="email" name="Email" placeholder="用户" required="" />
            <input type="password" name="Password" placeholder="密码" required="" />
            <a href="#" class="forgot-w3layouts">忘记密码 ?</a>
            <div class="submit-w3l">
                <input type="submit" value="登录">
            </div>
            <p class="p-bottom-w3ls" style="color: #000;"><a href="../jsp/signup.jsp">点击注册</a></p>
        </form>
    </div>
</div>
<div class="copyright w3-agile">
    <p> © 2018</p>
</div>
</body>
</html>

