<%--
  Created by IntelliJ IDEA.
  User: 曹畅
  Date: 2018/6/9
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="OPB" type="com.bean.OrderPageBean" scope="session"></jsp:useBean>
<jsp:useBean id="userbean" type="com.bean.UserBean" scope="session"></jsp:useBean>
<html>
<head>
    <title>订单确认</title>
    <script src="../js/jquery-2.1.4.min.js"></script>
    <link href="../css/index_css.css" rel="stylesheet"  type="text/css">
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/Act.js"></script>
    <script src="../js/Order.js"></script>
    <script>
        $(document).ready(function() {
            $("body").on('click', '.city-name', function () {
                $(this).parent().parent().find(".city_box").toggle();
            });
            $("body").on('click', '.city-item', function () {
                var name=$(this).attr("data-name");
                $(this).parent().parent().parent().parent().find(".city-name").html(name);
                search_by_city(name);
            });

            $("body").on('click', '.item-user', function () {
                window.location.href='./information.jsp';
            });


            $("body").on('click', '.handcan', function () {
                var v1=$("#counter");
                var oid=v1.attr("data-oid");
                time_out_cancel(oid,"n");
            });
        });
        setInterval(function () {
        //alert("in");
        var v1=$("#counter");
        var sec=parseInt(v1.attr("data-sec"));
        var min=parseInt(v1.attr("data-min"));
        var oid=v1.attr("data-oid");
        var state=parseInt(v1.attr("data-state"));
        //alert(min);
        if(state==0){
            if(sec==0){
                if(min==0){
                    $("#counter").attr("data-state","1");
                    time_out_cancel(oid,"y");
                }
                else{
                    min=min-1;
                    sec=59;
                }
            }
            else{
                sec=sec-1;
            }

            v1.attr("data-sec",sec+"");
            v1.attr("data-min",min+"");

            var v2=document.getElementById("m_place");
            v2.innerHTML=min+"";

            var v3=document.getElementById("s_place");
            v3.innerHTML=sec+"";
        }
        else{
            clearInterval();
        }
        }, 1000);
    </script>
</head>
<body>
<div class="header">
    <div class="box1">
        <a href="/" class="logo_box">
            <img src="../img/logo.png" class="logo">
        </a>

        <div class="menu">
            <a href="/" class="menu-item">首页</a>
            <a class="menu-item city-name">
                <%=userbean.getCurPos() %>
            </a>
            <div class="city_box" style="display: none;">
                <div>
                    <ul>
                        <li class="city-item" data-name="country">全国</li>
                        <li class="city-item" data-name="shanghai">上海</li>
                        <li class="city-item" data-name="beijing">北京</li>
                        <li class="city-item" data-name="guangzhou">广州</li>
                        <li class="city-item" data-name="shenzhen">深圳</li>
                        <li class="city-item" data-name="chengdu">成都</li>
                        <li class="city-item" data-name="chongqing">重庆</li>
                        <li class="city-item" data-name="tianjin">天津</li>
                        <li class="city-item" data-name="hangzhou">杭州</li>
                        <li class="city-item" data-name="nanjing">南京</li>
                        <li class="city-item" data-name="wuhan">武汉</li>
                        <li class="city-item" data-name="xian">西安</li>
                        <li class="city-item" data-name="changsha">长沙</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="search-bar">
            <form action="SearchByInp" style="overflow: hidden;">
                <input placeholder="输入场馆、演出名称查询" autocomplete="off" name="keyword" value="" class="input">
                <input type="submit" value="搜索" class="btn-submit">
            </form>
        </div>
        <div class="right">
            <div style="" class="item-user item1">
                <div class="text1" style="color:#ff7919;font-size: 18px;margin-top: 23px;">
                    个人中心
                </div>
            </div>
        </div>
    </div>
</div>

<div class="s_container">
    <div class="order-progress-bar">
        <div class="step first done">
            <span class="step-num">1</span>
            <div class="bar"></div>
            <span class="step-text">选择活动</span>
        </div>
        <div class="step done">
            <span class="step-num">2</span>
            <div class="bar"></div>
            <span class="step-text">购票</span>
        </div>
        <div class="step">
            <span class="step-num done">3</span>
            <div class="bar"></div>
            <span class="step-text">15分钟内付款</span>
        </div>
        <div class="step last ">
            <span class="step-num">4</span>
            <div class="bar"></div>
            <span class="step-text">现场检票</span>
        </div>
    </div>

    <div class="count-down-wrapper">
        <div class="count-down" data-sec=<%=OPB.getBeans().get(0).getTime().get(1) %> data-min=<%=OPB.getBeans().get(0).getTime().get(0) %> data-oid=<%=OPB.getBeans().get(0).getId()%> data-state="0" data-count="0" id="counter" style="margin-top: -20px;">
            <p class="time-left">
                <span>请在</span>
                <span class="minute" id="m_place"><%=OPB.getBeans().get(0).getTime().get(0)%></span>
                <span>分钟</span>
                <span class="minute" id="s_place"><%=OPB.getBeans().get(0).getTime().get(1)%></span>
                <span>秒内完成支付</span>
            </p>
            <p class="tip">超时订单会自动取消，请尽快支付</p>
        </div>
    </div>

    <p class="warning">请仔细核对场次信息，<span class="attention">出票后退票和改签将扣取一定费用</span></p>

    <%for(int i=0;i<OPB.getBeans().size();i++){%>
    <table class="order-table" data-oid=<%=OPB.getBeans().get(i).getId()%>>
        <thead>
        <tr>
            <th style="min-width:160px;">名称</th>
            <th style="min-width:160px;">时间</th>
            <th style="min-width:160px;">地点</th>
            <th style="min-width:160px;">座位</th>
            <th style="min-width:160px;">总额</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="movie-name"><%=OPB.getBeans().get(i).getActName() %></td>
            <td class="showtime"><%=OPB.getBeans().get(i).getActTime() %></td>
            <td class="cinema-name"><%=OPB.getBeans().get(i).getVenueName() %></td>
            <td>
                <span class="hall"><%=OPB.getBeans().get(i).getRoom() %></span>
                <div class="seats" style="margin-top: -5px;">
                    <div>
                        <%if(OPB.getBeans().get(i).getSeatX().size()>1){%>
                        <span class="" style="margin-top: -5px;"><%=OPB.getBeans().get(i).getSeatX().get(0)+"排"+OPB.getBeans().get(i).getSeatY().get(0)+"座等" %></span>
                        <%}else{%>
                        <span class="" style="margin-top: -5px;"><%=OPB.getBeans().get(i).getSeatX().get(0)+"排"+OPB.getBeans().get(i).getSeatY().get(0)+"座" %></span>
                        <%}%>
                    </div>
                    <div>
                    </div>
                </div>
            </td>
            <td class="showtime"><%=OPB.getBeans().get(i).getSum()+"元" %></td>
        </tr>
        </tbody>
    </table>
    <%}%>

    <div class="right" style="float: left;margin-bottom: 20px;">
        <div class="box-main">
            <div style="float: left;width: 500px;margin-left: 650px;margin-top: 25px;">
                <a class="ensure_btn handcan" style="background-color: #676d70;float: left;cursor: pointer;">取消订单</a>
                <a class="ensure_btn" href="./jsp/pay.jsp" target="_blank" style="margin-left: 230px;cursor: pointer;">确认支付</a>
            </div>

        </div>
    </div>
</div>


<div class="modal-container" style="display:none;" id="time_out_cancel_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">支付超时，该订单已失效，请重新购买</p>
    </div>
</div>

</body>
</html>
