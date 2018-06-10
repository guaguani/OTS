<%--
  Created by IntelliJ IDEA.
  User: 曹畅
  Date: 2018/6/9
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/index_css.css" rel="stylesheet"  type="text/css">
</head>
<body>
<div class="pay_header">
    <div style="width: 950px;zoom:1;">
        <div class="header-title">
            <a href="myOrder.jsp"><div class="alipay-logo"></div></a>
            <span class="logo-title">我的收银台</span>
        </div>
    </div>
</div>
<div style="width: 800px;margin-left:275px;overflow: hidden;">
    <div>
        <div class="order-area">
            <div id="order">
                <div class="orderDetail-base">
                    <div style="min-height: 30px;">
                        <span style="cursor: auto;float: left;">
                            <span>正在使用即时到账交易</span>
                        </span>
                        <span style="float: left;margin-left: 15px;">
                            <span>交易将在59分钟后关闭，请及时付款！</span>
                        </span>
                    </div>
                    <div class="commodity-message-row">
                        <span class="first">美团订单-250317588842701528541568</span>
                        <span class="second">收款方：美团点评</span>
                    </div>
                    <span class="payAmount-area">
                        <strong>33.00</strong> 元
                    </span>
                </div>
            </div>
        </div>
        <div class="cashier-center-container">
            <div>
                <div class="cashier-center-view">
                    <div class="qrcode-area">
                        <div class="qrcode-header">
                            <div style="text-align: center;">扫一扫付款（元）</div>
                            <div class="qrcode-header-money">33.00</div>
                        </div>
                        <div class="qrcode-img-wrapper">
                            <div class="qrcode-img-area">
                                <div style="position: relative;display: inline-block;">
                                    <canvas width="168" height="168" style="float: left;"></canvas>
                                    <img src="../img/alicenter_icon.png" style="position: absolute;top: 50%;left: 50%;width:42px;height:42px;margin-left: -21px;margin-top: -21px">
                                </div>
                            </div>

                            <div style="padding: 10px 0 6px;margin: 0;zoom: 1;min-height: 52px;">
                                <div style="margin-left: 35px;float: left;">打开手机支付宝<br>扫一扫继续付款</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
