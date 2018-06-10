<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/10
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/information.css" rel="stylesheet" type="text/css" media="all">
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
                    <div class="user_icon" align="center"></div>
                        <span>个人中心</span>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="background-color: #f5f5f5;float: left;width: 1200px;border: 1px solid #f5f5f5;margin-left: 10%;text-align:center">

    <div style="padding: 50px 20px 30px 30px;width: 300px;float: left">
        <div style="height: 170px;margin: 0 0 20px 0;width: 200px;background-color: #ffffff;margin-top: -10%;">
            <ul text-align="center" style="margin-left: -20%;">
                <li class="person active" style="border-bottom: 3px solid #fd6d37;color: #fd6d37;font-weight: bold;">
                        个人中心
                </li>
                <li class="person">
                    <ul style="padding-left: 0px;">
                        <li style="padding-top: 10px;"> <a href="" style="color: #fd6d37">修改信息</a></li>
                        <li style="padding-top: 10px"> <a href="">我的订单</a></li>
                        <li style="padding-top: 10px"> <a href="">个人统计</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>

    <div style="    background-color: #ffffff;
                     float: left;
                     width: 900px;
                     height:450px;
                     border: 1px solid #ffffff;
                     margin-top: 35px;
                     margin-left: -6%;">
        <div class="info-main" style="margin-left: -25%">
            <ul class="lst" style="padding-top: 30px">
                <li class="itm">
                    <label for="username" class="am-form-label">昵称</label>
                    <input type="text" id="username" placeholder="nickname"
                           style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px">
                </li>
            </ul>
            <ul class="lst" style="padding-top: 30px">
                <li class="itm">
                    <label for="user-phone" class="am-form-label">电话</label>
                    <input type="text" id="user-phone" placeholder="tel"
                           style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px">
                </li>
            </ul>
            <ul class="lst" style="padding-top: 30px">
                <li class="itm">
                    <label for="Email" class="am-form-label">邮箱</label>
                    <input type="text" id="Email" placeholder="email"
                           style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px">
                </li>
            </ul>
            <ul class="lst" style="padding-top: 30px">
                <li class="itm">
                    <label for="Address" class="am-form-label">地址</label>
                    <input type="text" id="Address" placeholder="address"
                           style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px">
                </li>
            </ul>
            <ul class="lst" style="padding-top: 30px">
                <li class="itm">
                    <div class="info-btn">
                        <div class="am-btn-danger">保存修改</div>
                    </div>
                </li>
            </ul>

            </form>
        </div>
    </div>
</div>
</body>
</html>
