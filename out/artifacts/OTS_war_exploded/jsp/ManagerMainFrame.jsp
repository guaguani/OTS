<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/2/21
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="../css/mainframe.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
    window.onload = function () {
        var userid = "${userid}";
        $("#Username").val(userid);
    };
    function approveVenue(o) {
        var id = document.getElementById("id"+o).innerText;
        alert("审批成功");
        window.location.href="../approveVenueRegister?id="+id;
    };
</script>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
<div class="frontdiv">
    <h1 class="title">Close Contact With Everything</h1>
</div>
<h1 class="maintitle">Tickets</h1>
<%--在jsp页面显示Action传来的参数--%>
<h3 class="thirdtitle">Welcome,<input type="text" id="Username" name="Username" class="Username" readonly="readonly"/></h3>
<div class="approvaldiv">
    <%--审批场馆注册和修改场馆信息--%>
        <s:iterator value="venues" id="id">
            <table>
                <tr>
                    <th align="center">场馆编号</th>
                    <th align="center" width="200px">地址</th>
                    <th align="center">座位行数</th>
                    <th align="center">每行座位数</th>
                    <th align="center">状态</th>
                </tr>
                <tr>
                    <td id="id<s:property value="id"/>" align="center"><s:property value="id"/></td>
                    <td align="center" width="200px"><s:property value="address"/></td>
                    <td align="center"><s:property value="rows"/></td>
                    <td align="center"><s:property value="seatsEachRow"/></td>
                    <td align="center"><input type="button" onclick="approveVenue(<s:property value="id"/>)" value="审批"/></td>
                </tr>
            </table>
            <h4></h4>
        </s:iterator>
</div>
<div class="staticsdiv">
    <%--查看统计信息--%>
</div>
</body>
</html>
