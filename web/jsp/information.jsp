<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userbean" type="com.bean.UserBean" scope="session"></jsp:useBean>
<html>
<head>
    <title>罗汉豆</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/search_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/myorder_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/information.css" rel="stylesheet" type="text/css" media="all">
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/Act.js"></script>
    <script src="../js/User.js"></script>
    <script src="../js/Order.js"></script>
    <script>
        $(document).ready(function() {
            $("body").on('click', '.city-name', function () {
                $(this).parent().parent().find(".city_box").toggle();
            });
            $("body").on('click', '.city-item', function () {
                var name = $(this).html();
                $(this).parent().parent().parent().parent().find(".city-name").html(name);
                search_by_city(name);
            });

            $("body").on('click', '.logout', function () {
                logout();
            });
            $("body").on('click', '.item-user', function () {
                window.location.href='./information.jsp';
            });

        });
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
                <input placeholder="输入场馆、演出名称查询" autocomplete="off" name="keyword" class="input" value=<%=userbean.getCurInput() %>>
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


<div class="container">
    <div class="profile-title">个人信息</div>
    <div class="content">
        <div class="main">
            <div class="info-content clearfix">
                <div class="user-profile-nav">
                    <a href="./information.jsp"  class="active">个人信息</a>
                    <a>我的订单</a>
                    <a class="logout">退出登录</a>
                </div>
                <div style="background-color: #ffffff;float: left;width: 900px;height:450px;border: 1px solid #ffffff;margin-top: 35px;margin-left: 220px;">
                    <div class="info-main" style="margin-left: 50px;">
                        <ul class="lst" style="padding-top: 30px">
                            <li class="itm">
                                <label for="username" class="am-form-label">昵称</label>
                                <input type="text" id="username" style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px" value=<%=userbean.getName()%>>
                            </li>
                        </ul>
                        <ul class="lst" style="padding-top: 30px">
                            <li class="itm">
                                <label for="user-phone" class="am-form-label">密码</label>
                                <input type="password" id="user-phone" style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px">
                            </li>
                        </ul>
                        <ul class="lst" style="padding-top: 30px">
                            <li class="itm">
                                <label for="Email" class="am-form-label">支付账号</label>
                                <input type="text" id="Email" placeholder="email"
                                       style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px" value=<%=userbean.getPayID()%>>
                            </li>
                        </ul>
                        <ul class="lst" style="padding-top: 30px">
                            <li class="itm">
                                <label for="Address" class="am-form-label">地址</label>
                                <input type="text" id="Address" placeholder="address"
                                       style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px" value=<%=userbean.getAddress().toString()%>>
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

