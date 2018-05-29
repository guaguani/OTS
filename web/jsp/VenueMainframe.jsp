<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/2/21
  Time: 下午8:01
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
        //在页面初始化时加载场馆基本信息
        var Username = "${Username}";
        var address = "${venue_address}";
        var totalseats = "${totalSeats}";
        var rows = "${rows}";
        var seatsEachRow = "${seatsEachRow}";
        $("#Username").val(Username);
        $("#address").val(address);
        $("#totalseats").val(totalseats);
        $("#rows").val(rows);
        $("#seatsEachRow").val(seatsEachRow);
        $("#from_td").val(1);
        $("#to_td").val(rows);
    };
    function modifyInfo() {
        document.getElementById("address").disabled = "";
        document.getElementById("totalseats").disabled = "";
        document.getElementById("rows").disabled = "";
        document.getElementById("seatsEachRow").disabled = "";
    };
    function addPriceInterval() {
        var tbody = document.getElementById("tableBody");
        var tr = document.createElement("tr");
        var td1 = document.createElement("td");
        td1.width="100px";
        var from1 = document.createElement("input");
        from1.setAttribute("type","text");
        from1.setAttribute("name","from_td");
        from1.style.textAlign = "center";
        td1.appendChild(from1);
        var td2 = document.createElement("td");
        td2.width="100px";
        var to1 = document.createElement("input");
        to1.setAttribute("name","to_td");
        to1.setAttribute("type","text");
        to1.style.textAlign = "center";
        td2.appendChild(to1);
        var td3 = document.createElement("td");
        td3.width="100px";
        var price1 = document.createElement("input");
        price1.setAttribute("type","text");
        price1.setAttribute("name","price_td");
        price1.style.textAlign = "center";
        td3.appendChild(price1);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tbody.appendChild(tr);
    };
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="frontdiv">
    <h1 class="title">Close Contact With Everything</h1>
</div>
<h1 class="maintitle">Tickets</h1>
<%--在jsp页面显示Action传来的参数--%>
<h3 class="thirdtitle">Welcome,
    <%--<s:property value="#Username" />--%>
    <input type="text" name="Username" id="Username" class="Username" disabled="disabled"/>
</h3>
<h3 class="thirdtitle">information</h3>
<div class="infodiv">
    <form id="modifyVenueInfo" action="modifyVenueInfo.action" method="post">
        <label>Address:</label><input type="text" name="address" id="address" class="address" disabled="disabled" placeholder="Address" style="width: 200px"/>
        <p>Seats:</p>
        <label>total:</label><input type="text" name="totalseats" id="totalseats" disabled="disabled" class="totalseats"/>
        <label>row:</label><input type="text" id="rows" disabled="disabled" class="rows" name="rows"/>
        <label>seats each row:</label><input type="text" id="seatsEachRow" disabled="disabled" class="seatsEachRow" name="seatsEachRow">
        <div class="submit-w3l">
            <input type="button" id="modInfo" value="modify" onclick="modifyInfo()"/>
            <input type="submit" value="save"/>
        </div>
    </form>
</div>
<h3 class="thirdtitle">plan</h3>
<div class="plandiv">
    <form id="releasePlan" action="releasePlan.action" method="post">
        <label>Theme:</label><input type="text" id="plan_theme" name="plan_theme"/>
        <br>
        <label>Type:</label>
        <%--只要name相同就能保证是单选--%>
        <input type="radio" id="plan_type" name="plan_type" value="music"/>音乐会
        <input type="radio" id="plan_type" name="plan_type" value="drama"/>话剧
        <input type="radio" id="plan_type" name="plan_type" value="dance"/>舞蹈
        <br>
        <label>Time:</label><input type="date" id="plan_time" name="plan_time"/>
        <label>Description</label><input type="text" id="plan_des" name="plan_des" style="width: 200px"/>
        <br>
        <label>Price:</label>
        <table id="plantable">
            <thead>
            <tr>
                <th width="100px">From</th>
                <th width="100px">To</th>
                <th width="100px">Price</th>
            </tr>
            </thead>
            <tbody id="tableBody">
            <tr>
                <%--在页面初始化时加载值--%>
                    <td width="100px"><input type="text" id="from_td" class="from_td" name="from_td" style="text-align: center"/></td>
                    <td width="100px"><input type="text" id="to_td" class="to_td" name="to_td" style="text-align: center"/></td>
                    <td width="100px"><input type="text" id="price_td" class="price_td" name="price_td" style="text-align: center"/></td>
            </tr>
            <tr>
                <input type="button" id="addLineButton" value="+" onclick="addPriceInterval()"/>
                <label>请注意，你一共有<s:property value="#rows"></s:property>排座位。</label>
            </tr>
            </tbody>
        </table>
        <input type="submit" value="Release plan"/>
    </form>
</div>
<h3 class="thirdtitle">已经发布的计划</h3>
<div class="ticketdiv">
    <s:iterator value="plans" id="planid" status="st">
        <button >
            <table>
                <tr>
                    <th align="center">计划编号</th>
                    <th align="center" width="200px">主题</th>
                    <th align="center">类型</th>
                    <th align="center" width="120px">时间</th>
                    <th align="center" width="200px">描述</th>
                    <th align="center" width="200px">预订</th>
                    <th align="center" width="200px">退订</th>
                </tr>
                <tr>
                    <td id="planid<s:property value="planid"/>" align="center"><s:property value="planid"/></td>
                    <td align="center" width="200px"><s:property value="theme"/></td>
                    <td align="center"><s:property value="type"/></td>
                    <td align="center" width="120px"><s:property value="time"/></td>
                    <td align="center" width="200px"><s:property value="description"/></td>
                    <td align="center" width="200px"><s:property value="ordernum"/></td>
                    <td align="center" width="200px"><s:property value="backnum"/></td>
                </tr>
            </table>
        </button>
        <h4></h4>
    </s:iterator>
</div>
</body>
</html>
