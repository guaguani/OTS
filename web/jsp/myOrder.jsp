<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/10
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyOrder</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/myorder_css.css" rel="stylesheet" type="text/css" media="all">
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
                全国
            </a>
            <div class="city_box" style="display: none;">
                <div>
                    <ul>
                        <li class="selected" data-name="beijing">北京</li>
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
            <form action="" style="overflow: hidden;">
                <input placeholder="输入场馆、演出名称查询" autocomplete="off" name="keyword" value="" class="input">
                <input type="submit" value="搜索" class="btn-submit">
            </form>
        </div>
        <div class="right">
            <div style="display: block" class="item-login item1" onclick="openLogin()">
                <div class="text1" style="color:#ff7919;" >
                    <div class="login_icon"></div>
                    登录
                </div>
            </div>
            <div style="display: none" class="item-user item1">
                <div class="text1" style="color:#ff7919;">
                    <div class="user_icon"></div>
                    个人中心
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="content">
        <div class="main">
            <div class="info-content clearfix">
                <div class="user-profile-nav">
                    <a href="" class="Allorders active">全部订单</a>
                    <a href="" class="Unpayorders ">未支付</a>
                    <a href="" class="Unuseorders ">未使用</a>
                    <a href="" class="Doneorders ">已完成</a>
                </div>
                <div class="orders-container">
                    <div class="profile-title">我的订单</div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>
                            <span class="del-order" data-orderid="3149336059"></span>
                        </div>
                        <div class="order-body" style="height: 220px">
                            <div class="poster">
                                <img src="../img/example_poster.jpg">
                            </div>
                            <div class="order-content">
                                <div class="activity-name">张杰2018“未·LIVE”巡回演唱会-北京站</div>
                                <div class="venue-name">国家体育场（鸟巢）</div>
                                <div class="order-time">5月19日 13：45</div>
                            </div>
                            <div class="order-price">¥62.8</div>
                            <div class="order-status">已完成</div>
                            <div class="actions">
                                <div>
                                    <a href="" class="order-detail">查看详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>
                            <span class="del-order" data-orderid="3149336059"></span>
                        </div>
                        <div class="order-body" style="height: 220px">
                            <div class="poster">
                                <img src="../img/example_poster.jpg">
                            </div>
                            <div class="order-content">
                                <div class="activity-name">张杰2018“未·LIVE”巡回演唱会-北京站</div>
                                <div class="venue-name">国家体育场（鸟巢）</div>
                                <div class="order-time">5月19日 13：45</div>
                            </div>
                            <div class="order-price">¥62.8</div>
                            <div class="order-status">已完成</div>
                            <div class="actions">
                                <div>
                                    <a href="" class="order-detail">查看详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>
                            <span class="del-order" data-orderid="3149336059"></span>
                        </div>
                        <div class="order-body" style="height: 220px">
                            <div class="poster">
                                <img src="../img/example_poster.jpg">
                            </div>
                            <div class="order-content">
                                <div class="activity-name">张杰2018“未·LIVE”巡回演唱会-北京站</div>
                                <div class="venue-name">国家体育场（鸟巢）</div>
                                <div class="order-time">5月19日 13：45</div>
                            </div>
                            <div class="order-price">¥62.8</div>
                            <div class="order-status">已完成</div>
                            <div class="actions">
                                <div>
                                    <a href="" class="order-detail">查看详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>
                            <span class="del-order" data-orderid="3149336059"></span>
                        </div>
                        <div class="order-body" style="height: 220px">
                            <div class="poster">
                                <img src="../img/example_poster.jpg">
                            </div>
                            <div class="order-content">
                                <div class="activity-name">张杰2018“未·LIVE”巡回演唱会-北京站</div>
                                <div class="venue-name">国家体育场（鸟巢）</div>
                                <div class="order-time">5月19日 13：45</div>
                            </div>
                            <div class="order-price">¥62.8</div>
                            <div class="order-status">已完成</div>
                            <div class="actions">
                                <div>
                                    <a href="" class="order-detail">查看详情</a>
                                </div>
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
