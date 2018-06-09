<%--
  Created by IntelliJ IDEA.
  User: 曹畅
  Date: 2018/6/9
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-2.1.4.min.js"></script>
    <link href="../css/index_css.css" rel="stylesheet"  type="text/css">
    <script>
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
                    //time_out_cancle(oid);
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
        //clearInterval();
        }
        }, 1000);
    </script>
</head>
<body>
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
        <div class="step done">
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
        <div class="count-down" data-sec="59" data-min="14" data-oid="" data-state="0" id="counter" style="margin-top: -20px;">
            <p class="time-left">
                请在
                <span class="minute" id="m_place">14</span>
                分钟
                <span class="second" id="s_place">59</span>
                秒内完成支付
            </p>
            <p class="tip">超时订单会自动取消，请尽快支付</p>
        </div>
    </div>

    <p class="warning">请仔细核对场次信息，<span class="attention">出票后退票和改签将扣取一定费用</span></p>

    <table class="order-table">
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
            <td class="movie-name">######</td>
            <td class="showtime">######</td>
            <td class="cinema-name">######</td>
            <td>
                <span class="halll">######</span>
                <div class="seats">
                    <div>
                        <span class="">######</span>
                    </div>
                    <div>
                    </div>
                </div>
            </td>
            <td class="showtime">######</td>
        </tr>
        </tbody>
    </table>


    <div class="right" style="float: left;">
        <span style="float: left;margin-bottom: 20px;margin-left: 18px;">选择付款方式 :</span>
        <div class="box-main">
            <ul style="min-height: 100%;padding: 0;">
                <li class="pay-money-img"><a class="icon icon-pay-weixin"></a></li>
                <li class="pay-money-img"><a class="icon icon-pay-alibaba"></a></li>
            </ul>
        </div>
    </div>
</div>



<div class="modal-container" style="display:none;" id="little_board1">
    <div class="modal">
        <span class="icon"></span>

        <p class="tip">支付超时，该订单已失效，请重新购买</p>

        <div class="ok-btn btn" id="i_know">我知道了</div>
    </div>
</div>
<div class="modal-container" style="display:none;" id="little_board">
    <div class="modal">
        <span class="icon"></span>

        <p class="tip">请重新尝试</p>

    </div>
</div>
</body>
</html>
