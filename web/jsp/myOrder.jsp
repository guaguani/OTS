<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="orderPagebean" type="com.bean.OrderPageBean" scope="session"></jsp:useBean>
<jsp:useBean id="userbean" type="com.bean.UserBean" scope="session"></jsp:useBean>
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

            $(window).scroll(function(){
                if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
                    $("#loading").fadeIn(500);
                    more_order();
                    $("#loading").fadeOut(500);
                }
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
                        <li class="city-item" data-name="beijing">全国</li>
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
                <input placeholder="输入场馆、演出名称查询" autocomplete="off" name="keyword" value=<%=userbean.getCurInput() %> class="input">
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
                <div class="orders-container" id="order_box">
                    <div class="search_city" style="background-color: #fff;width: 300px;margin: 0;">
                        <dl id="category_filter_id" class="search_city_line">
                            <dd class="search_city_num" style="margin-left: 21px;">
                                <ul class="clear" style="font-size: 18px;padding-left: 0px;">
                                    <li>
                                        <a class="order_type" name="all" style=<%=orderPagebean.getStyle().get(0) %>>
                                            全部订单
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="unpay" style=<%=orderPagebean.getStyle().get(1) %>>
                                            未支付
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="unuse" style=<%=orderPagebean.getStyle().get(2) %>>
                                            待使用
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="finish" style=<%=orderPagebean.getStyle().get(3) %>>
                                            已完成
                                        </a>
                                    </li>
                                    <li>
                                        <a class="order_type" name="cancel" style=<%=orderPagebean.getStyle().get(4) %>>
                                            已取消
                                        </a>
                                    </li>

                                </ul>
                            </dd>

                        </dl>
                    </div>
                    <%for(int i=0;i<orderPagebean.getBeans().size();i++){ %>
                    <div style="height: 300px" class="order-box" data-orderid=<%=orderPagebean.getBeans().get(i).getId() %> >
                        <div class="order-header">
                            <span class="order-date"><%=orderPagebean.getBeans().get(i).getCreateDate() %></span>
                            <span class="order-id"><%="订单号："+orderPagebean.getBeans().get(i).getId() %></span>
                        </div>
                        <div class="order-body" style="height: 220px">
                            <div class="poster">
                                <img src=<%=orderPagebean.getBeans().get(i).getPath() %>>
                            </div>
                            <div class="order-content">
                                <div class="activity-name"><%=orderPagebean.getBeans().get(i).getActName() %></div>
                                <div class="venue-name"><%=orderPagebean.getBeans().get(i).getVenueName() %></div>
                                <div class="order-time"><%=orderPagebean.getBeans().get(i).getTime() %></div>
                            </div>
                            <div class="order-price"><%="￥"+orderPagebean.getBeans().get(i).getSum() %></div>
                            <div class="order-status"><%=orderPagebean.getBeans().get(i).getState() %></div>
                            <div class="actions">
                                <div>
                                    <%if(orderPagebean.getBeans().get(i).getState().equals("未支付")){%>
                                    <a class="order-pay" name=<%=orderPagebean.getBeans().get(i).getId() %>>立即支付</a>
                                    <%}else if(orderPagebean.getBeans().get(i).getState().equals("待使用")){%>
                                    <a class="order-cancel" style="color: #333;" name=<%=orderPagebean.getBeans().get(i).getId() %>>取消订单</a>
                                    <%}else{%>
                                    <a class="order-detail" name=<%=orderPagebean.getBeans().get(i).getActid() %>>活动详情</a>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
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
