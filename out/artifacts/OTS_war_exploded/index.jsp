<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/2/21
  Time: 下午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Tickets</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="keywords" content="" />
  <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
      function memberLogin() {
          window.location.href="../jsp/index.jsp";
      };
      function venueLogin() {
          window.location.href="../jsp/VenueLogin.jsp";
      };
      function managerLogin() {
          window.location.href="../jsp/ManagerLogin.jsp";
      };
  </script>
  <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
  <link href="css/mainframe.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="frontdiv">
  <h1 class="title">Close Contact With Everything</h1>
</div>
<h1 class="maintitle">Tickets</h1>
<h2 class="sidetitle">Login Ways</h2>
<div class="buttondiv">
  <button class="memberb" onclick="memberLogin()">Member</button>
  <button class="venueb" onclick="venueLogin()">Venue</button>
  <button class="managerb" onclick="managerLogin()">Manager</button>
</div>
<%--<h2 class="sidetitle">Latest Tickets</h2>--%>
<%--<div class="ticketdiv">--%>
  <%--显示一些票--%>
<%--</div>--%>
</body>
</html>
