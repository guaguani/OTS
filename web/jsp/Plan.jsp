<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/3/30
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    window.onload=function () {
        var venueid = "${venueid}";
        var venueAdd = "${venueAdd}";
        var venueRows = "${venueRows}";
        var venueSeat = "${venueSeat}";
        var theme = "${theme}";
        var type = "${type}";
        var time = "${time}";
        var description = "${description}";
        var planid = "${planid}";
        $("#planid").val(planid);
        $("#address").val(venueAdd);
        $("#theme").val(theme);
        $("#type").val(type);
        $("#time").val(time);
        $("#description").val(description);
        $("#planid").val(planid);
        $("#venueid").val(venueid);

        var orderedseats = "${seatRs}";
        console.log(orderedseats.size);
        console.log(orderedseats);
        var tablebody = document.getElementById("tablebody");
        for(var i=0;i<venueRows;i++){
            var tr = document.createElement("tr");
            for(var j=0;j<venueSeat;j++){
                var td = document.createElement("td");
                var seat = document.createElement("input");
                seat.setAttribute("type","button");
                seat.setAttribute("value",i*venueSeat+j);
                seat.setAttribute("id","seat"+i+j);
//                if ((i * venueSeat + j) ==orderedseats) {
//                    seat.style.color="red";
//                }

                seat.onclick = function () {
                    this.style.color = "red";
                    if(this.style.color=="red"){
                        console.log("red");
                    }
                    if(this.style.color=="black"){
                        console.log("black");
                    }
                    console.log(this.style.color);
                };
                td.appendChild(seat);
                tr.appendChild(td);
            }
            tablebody.appendChild(tr);
        }
    };
    function selectSeat() {
        var point = 0;
        var seats = [];
        var venueRows = "${venueRows}";
        var venueSeat = "${venueSeat}";
        var seattable = document.getElementById("seatTable");
        for(var i=0;i<venueRows;i++){
            for(var j=0;j<venueSeat;j++){
                var seat = document.getElementById("seat"+i+j);
                if(seat.style.color=="red"){
                    seats[point]=seat.getAttribute("id");
                    point++;
                }
            }
        }
        if(point>6){
            alert("您选的票不得超过6张");
            for(var i=0;i<venueRows;i++){
                for(var j=0;j<venueSeat;j++){
                    var seat = document.getElementById("seat"+i+j);
                    seat.style.color="black";
                }
            }
        }
        else{
            var venueid = "${venueid}";
            var planid = "${planid}";
            var userid = "${userid}";
            console.log("xuanzuogoumai");
            window.location.href="../reserveTickets?seats="+seats+"&userid="+userid+"&venueid="+venueid+"&planid="+planid;
        }
    };
    function allocateSeat() {
        var venueid = "${venueid}";
        var planid = "${planid}";
        var userid = "${userid}";
        window.location.href="../allocateSeat?userid="+userid+"&venueid="+venueid+"&planid="+planid;
    };
    function cleanColor() {
        var venueRows = "${venueRows}";
        var venueSeat = "${venueSeat}";
        for(var i=0;i<venueRows;i++){
            for(var j=0;j<venueSeat;j++){
                var seat = document.getElementById("seat"+i+j);
                seat.style.color="black";
            }
        }
    };
</script>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
<div>
    <div id="seatdiv" style="float: left;display: inline">
        <table id="seattable">
            <tbody id="tablebody"></tbody>
        </table>
    </div>
    <div id="messagediv" style="float: left;display: inline">
        <table>
            <tbody>
            <tr>
                <td><label>计划：</label></td>
                <td><input type="text" id="planid" name="planid" style="width: 200px"/></td>
            </tr>
            <tr>
                <td><label>主题：</label></td>
                <td><input type="text" id="theme" name="theme" style="width: 200px"/></td>
            </tr>
            <tr>
                <td><label>类型：</label></td>
                <td><input type="text" id="type" name="type" style="width: 200px"/></td>
            </tr>
            <tr>
                <td><label>时间：</label></td>
                <td><input type="text" id="time" name="time" style="width: 200px"/></td>
            </tr>
            <tr>
                <td><label>场馆：</label></td>
                <td><input type="text" id="venueid" name="venueid" style="width: 200px"/></td>
            </tr>
            <tr>
                <td><label>地址：</label></td>
                <td><input type="text" id="address" name="address" style="width: 200px"/></td>
            </tr>
            <tr>
                <td><label>描述：</label></td>
                <td><input type="text" id="description" name="description" style="width: 200px"/></td>
            </tr>
            </tbody>
        </table>
        <input type="button" value="清空" onclick="cleanColor()"/>
        <input type="button" onclick="selectSeat()" value="选座购买"/>
        <input type="button" onclick="allocateSeat()" value="立即购买"/>
        <form action="queryUser.action">
            <input type="submit" value="返回"/>
        </form>
    </div>
</div>
</body>
</html>
