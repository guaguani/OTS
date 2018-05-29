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
        var level = "${level}";
        var cost = "${cost}";
        var integral = "${integral}";
        var password = "${password}";
        var username = "${Username}";
        var backTimes = "${backTimes}";
        var ordertimes = "${ordertimes}";
        $("#level").val(level);
        $("#cost").val(cost);
        $("#integral").val(integral);
        $("#password").val(password);
        $("#Username").val(username);
        $("#backtimes").val(backTimes);
        $("#ordertimes").val(ordertimes);
        var state = "${state}";
        if(state==0){
            document.getElementById("cancelMember").style.display = "none";
        }
    };
    function modifyInfor() {
        document.getElementById("password").readOnly=false;
    };
    function viewPlan(o) {
        var id = document.getElementById("planid"+o).innerText;
        var username = "${Username}";
        window.location.href="../showOnePlan?id="+id+"&Username="+username;
    };
    function payOrder(o) {
        var username = "${Username}";
        var id = document.getElementById("orderid"+o).innerText;
        console.log(id);
        alert("支付成功");
        window.location.href="../payOrder?id="+id+"&Username="+username;
    };
    function cancelOrder(o) {
        var username = "${Username}";
        var id = document.getElementById("orderid"+o).innerText;
        alert("退订成功");
        window.location.href="../cancelOrder?id="+id+"&Username="+username;
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
<h3 class="thirdtitle">information</h3>
<div class="infodiv">
    <form id="cancelMember" action="cancelMember.action" method="post">
        <label id="resignMembership">resign membership:</label><input type="submit" id="cancelMem" name="cancelMem" class="cancelMem"/>
    </form>
    <form action="modifyUserInfo.action" method="post">
        <input type="text" id="level" name="level" class="level" readonly="readonly"/>
        <label>cost:</label>
        <input type="text" id="cost" name="cost" class="cost" readonly="readonly"/>
        <label>integral:</label>
        <input type="text" id="integral" name="integral" class="integral" readonly="readonly"/>
        <label>password:</label>
        <input type="password" id="password" name="password" class="password" readonly="readonly"/>
        <input type="button" value="modify" onclick="modifyInfor()"/>
        <input type="submit" value="save" />
    </form>
</div>
<div class="ticketdiv">
    <p>查看所有计划</p>
    <%--显示所有仍然可预定的ticket--%>
    <%--按plan划分--%>
        <s:iterator value="plans" id="planid" status="st">
                <button onclick="viewPlan(<s:property value="planid"/>)">
                    <table>
                        <tr>
                            <th align="center">计划编号</th>
                            <th align="center" width="200px">主题</th>
                            <th align="center">类型</th>
                            <th align="center" width="120px">时间</th>
                            <th align="center" width="200px">描述</th>
                            <th align="center" width="100px">所属场馆</th>
                        </tr>
                        <tr>
                            <td id="planid<s:property value="planid"/>" align="center"><s:property value="planid"/></td>
                            <td align="center" width="200px"><s:property value="theme"/></td>
                            <td align="center"><s:property value="type"/></td>
                            <td align="center" width="120px"><s:property value="time"/></td>
                            <td align="center" width="200px"><s:property value="description"/></td>
                            <td align="center" width="100px">场馆<s:property value="id"/></td>
                        </tr>
                    </table>
                </button>
            <h4></h4>
        </s:iterator>
</div>
<div class="nulldiv" style="height: 50px;">
</div>
<div class="myorderdiv">
    <p>查看订单状态</p>
    <%--查看订单状态--%>
        <s:iterator value="orders" id="orderid">
            <table>
                <tr>
                    <th align="center">订单编号</th>
                    <th align="center" width="200px">座位号</th>
                    <th align="center">场馆号</th>
                    <th align="center" width="120px">价格</th>
                    <th align="center" width="200px">状态</th>
                </tr>
                <tr>
                    <td id="orderid<s:property value="orderid"/>" align="center"><s:property value="orderid"/></td>
                    <td align="center" width="200px"><s:property value="seatid"/></td>
                    <td align="center"><s:property value="venueid"/></td>
                    <td align="center" width="120px"><s:property value="price"/></td>
                    <td align="center" width="200px">
                        <s:if test='state=="0"'>
                            <input type="button" onclick="payOrder(<s:property value="orderid"/>)" value="去支付"/>
                        </s:if>
                        <s:if test='state=="1"'>
                            <input type="button" onclick="cancelOrder(<s:property value="orderid"/>)" value="退订"/>
                        </s:if>
                    </td>
                </tr>
            </table>
            <h4></h4>
        </s:iterator>
</div>
<div class="staticsdiv">
    <p>查看统计信息</p>
<%--查看本人统计信息--%>
    <label>预订次数：</label><input type="text" id="ordertimes" name="ordertimes" class="ordertimes" readonly="readonly"/>
    <label>退订次数：</label><input type="text" id="backtimes" name="backtimes" class="backtimes" readonly="readonly"/>

</div>
</body>
</html>
