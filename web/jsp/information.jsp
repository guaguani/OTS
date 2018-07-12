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
            $("body").on('click', '.l2',function () {
                window.location.href="./myOrder.jsp";
            });

            $("body").on('click', '#begin',function () {
                $(this).hide();
                $(this).prev().show();
                $("#account").hide();
                $("#pwd").show();
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
                    <a id="l1" href="./information.jsp"  class="active">个人信息</a>
                    <a id="l2" class="l2">我的订单</a>
                    <a id="l3" class="logout">退出登录</a>
                </div>
                <div id="maindiv" style="background-color: #ffffff;float:left;width: 900px;height:450px;border: 1px solid #ffffff;margin-left: 220px;">
                    <form action="modifyUser.action">
                        <div class="info-main" style="margin-left: 50px;">
                            <ul class="lst" style="padding-top: 30px" id="account">
                                <li class="itm">
                                    <label class="am-form-label" style="margin-left:100px;width:80px;display: inline-block">账号</label>
                                    <span style="margin-left: 35px;"><%=userbean.getId()%></span>
                                </li>
                            </ul>
                            <ul class="lst" style="padding-top: 30px">
                                <li class="itm">
                                    <label class="am-form-label" style="margin-left:100px;width:80px;display: inline-block">昵称</label>
                                    <input type="text" name="username" style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px;font-size:14px" value=<%=userbean.getName()%>>
                                </li>
                            </ul>
                            <ul class="lst" style="padding-top: 30px;display: none;" id="pwd">
                                <li class="itm">
                                    <label class="am-form-label" style="margin-left:100px;width:80px;display: inline-block">密码</label>
                                    <input type="password" name="password" class="password" style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px;font-size:14px" value=<%=userbean.getPwd()%>>
                                </li>
                            </ul>
                            <ul class="lst" style="padding-top: 30px">
                                <li class="itm">
                                    <label class="am-form-label" style="margin-left:100px;width:80px;display: inline-block">支付账号</label>
                                    <%if(userbean.getPayID()==null){%>
                                    <input type="text" name="payid"
                                           style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px;font-size:14px;" value="">
                                    <%}else{%>
                                    <input type="text" name="payid"
                                           style="border: 1px solid #E4EAEE;margin-left: 30px;height: 35px;width: 300px;font-size:14px;" value=<%=userbean.getPayID()%>>
                                    <%}%>
                                </li>
                            </ul>

                            <ul class="lst" style="padding-top: 30px;display: none;" id="sure">
                                <li class="itm">
                                    <div class="info-btn">
                                        <input type="submit" value="确认修改" style="display: block;height: 42px;background-color: #ff7919;text-align: center;text-decoration: none;color: #fff;font-size: 16px;line-height: 42px;width: 120px;margin-left: 35%;border: 0;cursor: pointer;"/>
                                    </div>
                                </li>
                            </ul>
                            <ul class="lst" style="padding-top: 30px" id="begin">
                                <li class="itm">
                                    <div class="info-btn">
                                        <a style="display: block;height: 42px;background-color: #ff7919;text-align: center;text-decoration: none;color: #fff;font-size: 16px;line-height: 42px;width: 120px;margin-left: 35%;cursor: pointer;">修改信息</a>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

