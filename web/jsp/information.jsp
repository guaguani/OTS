<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>罗汉豆</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/search_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/myorder_css.css" rel="stylesheet" type="text/css" media="all">
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
                    <div class="user_icon"></div>
                    个人中心
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="profile-title">个人信息</div>
    <div class="content">
        <div class="main">
            <div class="info-content clearfix">
                <div class="user-profile-nav">
                    <a href="./information.jsp" class="Allorders active">个人信息</a>
                    <a href="./signup.jsp" class="Unpayorders">我的订单</a>
                </div>
                <div style="background-color: #ffffff;float: left;width: 900px;height:450px;border: 1px solid #ffffff;margin-top: 35px;margin-left: 220px;">
                    <div class="info-main" style="margin-left: 50px;">
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
        </div>
    </div>
</div>

</body>
</html>

