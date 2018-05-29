<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/2/21
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content=""/>
    <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/snow.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript">
        window.onload = function () {
            var serialnumber = "${serialNumber}";
            $("#Username").val(serialnumber);
        };
    </script>
    <script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar(){
            window.scrollTo(0,1);
        };
    </script>
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
    <a href="../jsp/VenueLogin.jsp">登录</a><a href="../jsp/VenueRegister.jsp" class="active">注册</a>
</div>
<h1>Tickets</h1>
<div class="main-agileits">
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">注册</h2>
        <form action="addVenue.action" method="post">
            <input type="text" id="Username" name="Username" class="Username"/>
            <input type="password" name="Password" placeholder="Password" required=""/>
            <input type="password" name="Password" placeholder="Confirm Password" required=""/>
            <input type="text" id="address" name="address" class="address" placeholder="address"/>
            <input type="text" id="totalseats" name="totalseats" class="totalseats" placeholder="totalseats"/>
            <input type="text" id="rows" name="rows" class="rows" placeholder="rows"/>
            <input type="text" id="seatsEachRow" name="seatsEachRow" class="seatsEachRow" placeholder="seatsEachRow"/>
            <div class="submit-w3l">
                <input type="submit" value="Sign up">
            </div>
        </form>
    </div>
</div>
<!--//form-ends-here-->
<!-- copyright -->
<div class="copyright w3-agile">
    <p> © 2018</p>
</div>
<!-- //copyright -->
</body>
</html>
