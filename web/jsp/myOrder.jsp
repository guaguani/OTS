<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/search_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/myorder_css.css" rel="stylesheet" type="text/css" media="all">
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
            $("body").on('click', '.btn-submit', function () {
                var user_input = $(this).prev().value();
                search_by_input(user_input);
            });
            $("body").on('click', '.logout', function () {
                logout();
            });
            $("body").on('click', '.item-user', function () {
                window.location.href='./information.jsp';
            });
            $("body").on('click', '.order_type', function () {
                var type=$(this).attr("name");
                get_order(type);
            });
            $("body").on('click', '.order-detail', function () {
                var act_id=$(this).attr("name");
                get_act_detail(act_id);
            });

            $("body").on('click', '.order-pay', function () {
                var order_id=$(this).attr("name");
                change_cur_order(order_id);
            });

            $("body").on('click', '.order-cancel', function () {
                var order_id=$(this).attr("name");
                cancel(order_id);
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
            <form style="overflow: hidden;">
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


<div class="container">
    <div class="profile-title">我的订单</div>
    <div class="content">
        <div class="main">
            <div class="info-content clearfix">
                <div class="user-profile-nav">
                    <a href="./information.jsp">个人信息</a>
                    <a class="active">我的订单</a>
                    <a class="logout">退出登录</a>
                 </div>
                <div class="orders-container">
                    <div class="search_city" style="background-color: #fff;width: 300px;margin: 0;">
                        <dl id="category_filter_id" class="search_city_line">
                            <dd class="search_city_num" style="margin-left: 21px;">
                                <ul class="clear" style="font-size: 18px;padding-left: 0px;">
                                    <li>
                                        <a class="order_type" name="all">
                                            全部订单
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="unpay">
                                            未支付
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="unuse">
                                            待使用
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="finish">
                                            已完成
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="cancel">
                                            已取消
                                        </a>
                                    </li>

                                </ul>
                            </dd>

                        </dl>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>

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
                                    <a class="order-detail" name="">活动详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>

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
                            <div class="order-status">已取消</div>
                            <div class="actions">
                                <div>
                                    <a href="" class="order-detail" name="">活动详情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>

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
                            <div class="order-status">未支付</div>
                            <div class="actions">
                                <div>
                                    <a class="order-pay" name="">立即支付</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="order-box" data-orderid="3149336059" style="height: 300px">
                        <div class="order-header">
                            <span class="order-date">2018-05-19</span>
                            <span class="order-id">订单号：3149336059</span>

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
                            <div class="order-status">待使用</div>
                            <div class="actions">
                                <div>
                                    <a class="order-cancel" style="color: #333;" name="">取消订单</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal-container" style="display:none;" id="no_more_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">没有更多了</p>
    </div>
</div>

<div class="modal-container" style="display:none;" id="canceled_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">已为您取消订单</p>
    </div>
</div>

<div id="loading" class="loading" style="position:absolute; left:49%; top:40%; width:20px; height:20px; z-index:30;display: none">
    <img src="../img/loading.gif"/>
</div>
</body>
</html>
