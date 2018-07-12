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
            $("body").on('click','.city-item',function(){
                var name=$(this).attr("data-name");
                $(this).parent().parent().parent().parent().find(".city-name").html(name);
                search_by_city(name);
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

            $("body").on('click', '.page_up', function () {
                search_order_up();
            });
            $("body").on('click', '.page_down', function () {
                search_order_down();
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
                <input placeholder="输入场馆、演出名称查询" autocomplete="off" name="keyword"  class="input" value=<%=userbean.getCurInput() %>>
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
                <div class="user-profile-nav" style="cursor: pointer;">
                    <a href="/jsp/information.jsp">个人信息</a>
                    <a class="active">我的订单</a>
                    <a class="logout">退出登录</a>
                 </div>
                <div class="orders-container" id="order_box">
                    <div class="search_city" style="background-color: #fff;width: 300px;margin: 0;">
                        <dl id="category_filter_id" class="search_city_line">
                            <dd class="search_city_num" style="margin-left: 21px;">
                                <ul class="clear" style="font-size: 18px;padding-left: 0px;">
                                    <%for(int i=0;i<orderPagebean.getTypes().size();i++){%>
                                    <li>
                                        <%if(orderPagebean.getStyle().get(i).equals("color:#ff7919;")){%>
                                        <a class="order_type"  style="color:#ff7919;" name=<%=orderPagebean.getTypese().get(i)%>>
                                            <%}else{%>
                                                <a class="order_type"  name=<%=orderPagebean.getTypese().get(i)%>>
                                                    <%}%>
                                            <%=orderPagebean.getTypes().get(i)%>
                                        </a>
                                    </li>
                                    <%}%>
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
                                <div class="activity-name" style="min-width: 280px;"><%=orderPagebean.getBeans().get(i).getActName() %></div>
                                <div class="venue-name" style="margin-top: 15px;min-width: 280px;"><%=orderPagebean.getBeans().get(i).getVenueName() %></div>
                                <div class="order-time" style="margin-left: 0px;min-width: 280px;"><%=orderPagebean.getBeans().get(i).getActTime() %></div>
                            </div>
                            <div class="order-price" style="margin-left: 90px;"><%="￥"+orderPagebean.getBeans().get(i).getSum() %></div>
                            <div class="order-status"><%=orderPagebean.getBeans().get(i).getState() %></div>
                            <div class="actions">
                                <div>
                                    <%if(orderPagebean.getBeans().get(i).getState().equals("未支付")){%>
                                    <a class="order-pay" style="cursor: pointer;color: lawngreen;" name=<%=orderPagebean.getBeans().get(i).getId() %>>立即支付</a>
                                    <%}else if(orderPagebean.getBeans().get(i).getState().equals("待使用")){%>
                                    <a class="order-cancel" style="cursor: pointer;" style="color: #333;" name=<%=orderPagebean.getBeans().get(i).getId() %>>取消订单</a>
                                    <%}else{%>
                                    <a class="order-detail" style="cursor: pointer;color: #ff7919;" name=<%=orderPagebean.getBeans().get(i).getActid() %>>活动详情</a>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                    <div style="float: left;width: 1200px;margin-left: 10px;margin-top: 20px;margin-bottom: 20px;">
                        <%if(orderPagebean.getOffset()>8){%>
                        <a class="page_but page_up" style="float: left;margin-left: 210px;margin-bottom: 10px;cursor: pointer;">上一页</a>
                        <%}%>
                        <%if(!orderPagebean.isLast()){%>
                        <a class="page_but page_down" style="float: right;margin-right: 210px;margin-bottom: 10px;cursor: pointer;">下一页</a>
                        <%}%>
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
