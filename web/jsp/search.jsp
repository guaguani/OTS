<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/8
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动搜索</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/search_css.css" rel="stylesheet" type="text/css" media="all">
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/Act.js"></script>
    <script src="../js/User.js"></script>
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
            $("body").on('click', '.btn-submit', function () {
                var user_input = $(this).prev().value();
                search_by_input(user_input);
            });
            $("body").on('click', '.item-login', function () {
                $(".log_pane").show();
            });
            $("body").on('click', '#login', function () {
                var name = $("#log_username").val();
                var pass = $("#log_password").val();
                var res = login(name, pass);
                if (res == "1") {
                    $(".item-login").hide();
                    $(".item-user").show();
                }
            });
            $("body").on('click', '.search_type', function () {
                search_by_type($(this.attr("name")));
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
                全国
            </a>
            <div class="city_box" style="display: none;">
                <div>
                    <ul>
                        <li class="selected city-item" data-name="beijing">全国</li>
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
            <div style="" class="item-login item1">
                <div class="text1" style="color:#ff7919;" >
                    <div class="login_icon"></div>
                    登录
                </div>
            </div>
            <div style="display: none;" class="item-user item1">
                <div class="text1" style="color:#ff7919;font-size: 18px;margin-top: 23px;">
                    个人中心
                </div>
            </div>
        </div>
    </div>
</div>

    <div class="search_city">
        <dl class="search_city_line">
            <dt>分 类：</dt>
            <dd class="search_city_num">
                <ul class="clear">
                    <li>
                        <a class="search_type" id="all" style="background-color: #ff7919;" name="1">
                            全部
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="con" name="2">
                            演唱会
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="ope" name="3">
                            话剧歌剧
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="ent" name="4">
                            休闲展览
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="spo" name="5">
                            体育赛事
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="mus" name="6">
                            音乐会
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="chi" name="7">
                            儿童亲子
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="dan" name="8">
                            舞蹈芭蕾
                        </a>
                    </li>
                    <li>
                        <a class="search_type" id="bei" name="9">
                            戏曲综艺
                        </a>
                    </li>
                </ul>
            </dd>

        </dl>
    </div>

    <!-- 搜索结果展示-->
    <div class="search_main">
        <ul class="search_list" id="content_list">
            <li>
                <div class="search_img">
                    <a href="./order_check.jsp" title="张杰2018“未·LIVE”巡回演唱会-北京站">
                        <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                    </a>
                </div>
                <div class="search_txt">
                    <h3>
                        "[北京] "
                        <a href="" onclick="">
                             张杰2018“未·LIVE”巡回演唱会-北京站
                        </a>
                    </h3>
                    <div style="color:#999;">2018.08.11</div>
                    <a href="">
                        <div style="color:#999;">国家体育场（鸟巢）</div>
                    </a>
                    <div class="price" style="margin-top: 20px;">
                        <span class="unit">¥</span>
                        <span class="amount">354</span>
                        起
                    </div>
                </div>
            </li>
            <li>
                <div class="search_img">
                    <a href="" title="张杰2018“未·LIVE”巡回演唱会-北京站">
                        <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                    </a>
                </div>
                <div class="search_txt">
                    <h3>
                        "[北京] "
                        <a href="" onclick="">
                            张杰2018“未·LIVE”巡回演唱会-北京站
                        </a>
                    </h3>
                    <div style="color:#999;">2018.08.11</div>
                    <a href="">
                        <div style="color:#999;">国家体育场（鸟巢）</div>
                    </a>
                    <div class="price" style="margin-top: 20px;">
                        <span class="unit">¥</span>
                        <span class="amount">354</span>
                        起
                    </div>
                </div>
            </li>
            <li>
                <div class="search_img">
                    <a href="" title="张杰2018“未·LIVE”巡回演唱会-北京站">
                        <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                    </a>
                </div>
                <div class="search_txt">
                    <h3>
                        "[北京] "
                        <a href="" onclick="">
                            张杰2018“未·LIVE”巡回演唱会-北京站
                        </a>
                    </h3>
                    <div style="color:#999;">2018.08.11</div>
                    <a href="">
                        <div style="color:#999;">国家体育场（鸟巢）</div>
                    </a>
                    <div class="price" style="margin-top: 20px;">
                        <span class="unit">¥</span>
                        <span class="amount">354</span>
                        起
                    </div>
                </div>
            </li>
            <li>
                <div class="search_img">
                    <a href="" title="张杰2018“未·LIVE”巡回演唱会-北京站">
                        <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                    </a>
                </div>
                <div class="search_txt">
                    <h3>
                        "[北京] "
                        <a href="" onclick="">
                            张杰2018“未·LIVE”巡回演唱会-北京站
                        </a>
                    </h3>
                    <div style="color:#999;">2018.08.11</div>
                    <a href="">
                        <div style="color:#999;">国家体育场（鸟巢）</div>
                    </a>
                    <div class="price" style="margin-top: 20px;">
                        <span class="unit">¥</span>
                        <span class="amount">354</span>
                        起
                    </div>
                </div>
            </li>
        </ul>
    </div>
<div class="log_pane" style="display: none;">
    <div class="log_back"></div>
    <div class="pop_login">
        <ul class="pop_login_title">
            <span onclick="$('.log_pane').hide()" class="icon-modal-close"></span>
            <div class="icon icon-login-popup-logo"></div>
        </ul>
        <ul class="pop_login_form">
            <li id="user_name"><input placeholder="用户名" id="log_username"></li>
            <li id="password"><input type="password" placeholder="密码" id="log_password"></li>
            <li id="li_login">
                <a id="login">登录</a>
                <a id="reg" style="margin-left: 40px;">注册</a>
            </li>
        </ul>
    </div>
</div>
<div class="modal-container" style="display:none;" id="little_board">
    <div class="modal">
        <span class="icon"></span>

        <p class="tip">没有更多了</p>

    </div>
</div>
</body>
</html>
