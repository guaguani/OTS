<%@ page import="com.bean.UserBean" %>
<%@ page import="com.bean.IndexBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="activitybean" type="com.bean.ActivityBean" scope="session"></jsp:useBean>
<jsp:useBean id="userbean" class="com.bean.UserBean" scope="session"></jsp:useBean>
<html>
<head>
    <title>演出详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/activity.css" rel="stylesheet" type="text/css" media="all">
    <script src="./js/jquery-3.2.1.js"></script>
    <script src="./js/Act.js"></script>
    <script src="./js/User.js"></script>
    <script>

        $(document).ready(function(){
            $("body").on('click','.city-name',function(){
                $(this).parent().parent().find(".city_box").toggle();
            });
            $("body").on('click','.city-item',function(){
                var name=$(this).attr("data-name");
                $(this).parent().parent().parent().parent().find(".city-name").html(name);
                search_by_city(name);
            });
            $("body").on('click','#pos',function(){
                var name=$(this).attr("data-name");
                $(this).parent().parent().parent().parent().find(".city-name").html(name);
                search_by_city(name);
            });

            $("body").on('click','.item-login',function(){
                $(".log_pane").show();
            });
            $("body").on('click', '.item-user', function () {
                window.location.href='./information.jsp';
            });
            $("body").on('click', '#login', function () {
                var name = $("#log_username").val();
                var pass = $("#log_password").val();
                login(name, pass);
            });

            $("body").on('click', '#type', function () {
                var name=$(this).attr("data-name");
                search_by_type(name);
            });

            $("body").on('click', '.tic_date', function () {
                var log=$("#log").attr("name");
                if(log==""){
                    $(".log_pane").show();
                    $("#log_tip").show();
                }
                else{
                    var date=$(this).html();
                    $(this).attr("style","color: #ff7919;");
                    $(this).siblings().attr("style","color: #000000");
                    $("#info").attr("data-date",date);
                }
            });
            $("body").on('click', '.tic_price', function () {
                var log=$("#log").attr("name");
                if(log==""){
                    $(".log_pane").show();
                    $("#log_tip").show();
                }
                else{
                    var price=$(this).attr("data-price");
                    var date= $("#info").attr("data-date");
                    var arrUl = jQuery(".ex");
                    var add=1;
                    jQuery.each(arrUl, function(){
                        if(jQuery(this).attr("data-price")==price){
                            if(jQuery(this).attr("data-date")==date){
                                add=0;
                            }
                        }
                    });

                    if(add==1){

                        $(this).attr("style","color: #ff7919;");
                        $(this).siblings().attr("style","");
                        $(".y_choose").show();
                        var list=document.getElementById("my-list");
                        var li=document.createElement("li");
                        li.setAttribute("class","itm ex");
                        li.setAttribute("data-price",""+price);
                        li.setAttribute("data-date",""+date);
                        var span1=document.createElement("span");
                        span1.setAttribute("class","price");
                        span1.innerHTML=price+"元:"+date.slice(5,10);
                        li.appendChild(span1);
                        var mnums=document.createElement("span");
                        mnums.setAttribute("class","m-nums");
                        var ul=document.createElement("ul");
                        ul.setAttribute("class","btn-numbox");
                        var li1=document.createElement("li");
                        li1.setAttribute("class","itm");
                        var span2=document.createElement("span");
                        span2.setAttribute("class","number");
                        span2.setAttribute("style","font-size: 16px;");
                        span2.innerHTML="数量";
                        li1.appendChild(span2);
                        ul.appendChild(li1);
                        var li2=document.createElement("li");
                        var ul1=document.createElement("ul");
                        ul1.setAttribute("class","count");
                        var li3=document.createElement("li");
                        var span3=document.createElement("span");
                        span3.setAttribute("class","num-jian");
                        span3.innerHTML="-";
                        li3.appendChild(span3);
                        ul1.appendChild(li3);
                        var li4=document.createElement("li");
                        var in1=document.createElement("input");
                        in1.setAttribute("type","text");
                        in1.setAttribute("class","input-num");
                        in1.setAttribute("value","1");
                        li4.appendChild(in1);
                        ul1.appendChild(li4);
                        var li5=document.createElement("li");
                        var span4=document.createElement("span");
                        span4.setAttribute("class","num-jia");
                        span4.innerHTML="+";
                        li5.appendChild(span4);
                        ul1.appendChild(li5);
                        li2.appendChild(ul1);
                        ul.appendChild(li2);
                        mnums.appendChild(ul);
                        li.appendChild(mnums);
                        list.appendChild(li);
                    }
                }

            });


            $("body").on('click', '.num-jian', function () {
                var num=$(this).parent().next().find(".input-num").val();
                var n=parseInt(num);
                if(n==1){
                    $(this).parent().parent().parent().parent().parent().parent().attr("class","itm");
                    $(this).parent().parent().parent().parent().parent().parent().hide();
                }
                else{
                    n=n-1;
                    $(this).parent().next().find(".input-num").val(""+n);
                }
            });


            $("body").on('click', '.num-jia', function () {
                var num=$(this).parent().prev().find(".input-num").val();
                var n=parseInt(num);
                var sum=$("#info").attr("data-num");
                var t_num=parseInt(sum);
                if(t_num>=20){
                    too_much();
                }
                else{
                    n=n+1;
                    t_num=t_num+1;
                    $("#info").attr("data-num",""+t_num);
                    $(this).parent().prev().find(".input-num").val(""+n);
                }

            });


            $("body").on('click', '.u-btn-buynow', function () {
                var log=$("#log").attr("name");
                if(log==""){
                    $(".log_pane").show();
                    $("#log_tip").show();
                }
                else{
                    var arrUl = jQuery(".ex");
                    var add=0;
                    var info="";
                    jQuery.each(arrUl, function(){
                        add=add+1;
                        info=info+jQuery(this).attr("data-date")+"a"+jQuery(this).attr("data-price")+"a"+jQuery(this).find(".input-num").val()+"l";
                    });
                    if(add==0){
                        pick_mention();
                    }
                    else{
                        info=info.substr(0,info.length-1);
                        lock_seat(info);
                    }
                }

            });
        });

    </script>
</head>
<body>
<%userbean.setPagePos("activity");%>
<a id="log" name=<%=userbean.getId()%>>
<a style="display:none;" id="info" data-date=<%=activitybean.getHalls().get(0).getShowTime()%> data-num="0"></a>
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
                <input placeholder="输入场馆、演出名称查询" autocomplete="off" name="keyword"  class="input" value=<%=userbean.getCurInput()%>>
                <input type="submit" value="搜索" class="btn-submit">
            </form>
        </div>
        <div class="right">
            <%if(userbean==null||userbean.getId()==null||userbean.getId().equals("")){ %>
            <div style="" class="item-login item1">
                <div class="text1" style="color:#ff7919;" >
                    <div class="login_icon"></div>
                    登录
                </div>
            </div>
            <%}else{%>
            <div style="display: none;" class="item-user item1">
                <div class="text1" style="color:#ff7919;font-size: 18px;margin-top: 23px;">
                    个人中心
                </div>
            </div>
            <%}%>
        </div>
    </div>
</div>
    <div style="width: 1200px; height: 800px;margin-left: 10%">
        <p style="background-color: #eaeaea;    padding: 12px 20px 14px 20px;">
            <a href="/">罗汉豆</a>
            <span class="arrow">&gt;</span>
            <a id="pos" style="cursor: pointer;" data-name=<%=activitybean.getEngc()%>><%=userbean.getCurPos()%></a>
            <span class="arrow">&gt;</span>
            <a id="type" style="cursor: pointer;" data-name=<%=activitybean.getEngt()%>><%=userbean.getCurType()%></a>
            <span class="arrow">&gt;</span>
            <strong><%=activitybean.getName()%></strong>
        </p>
        <div style="background-color: #ffffff;float: left;width: 1200px;border: 1px solid #c1c3c2;">
            <div style="padding: 30px 20px 30px 30px;width: 300px;float: left">
                <div style="height: 372px;margin: 0 0 20px 0;">
                    <img style="display: block;" width="277" height="373" src=<%=activitybean.getPath()%> >
                </div>
            </div>
            <div style="background-color: rgba(110,255,211,0);width: 500px;padding: 30px 20px 30px 0;float: left">
                <h2><%=activitybean.getName()%></h2>
                <div>
                    <div>
                        <span class="tt">时间：</span>
                        <%for(int i=0;i<activitybean.getHalls().size();i++){%>
                        <%if(i==0){%>
                            <span style="color: #ff7919;cursor: pointer;" class="tic_date"><%=activitybean.getHalls().get(i).getShowTime()%></span>
                        <%}else{%>
                        <span style="color: #000000;cursor: pointer;" class="tic_date"><%=activitybean.getHalls().get(i).getShowTime()%></span>
                        <%}%>
                        <%}%>
                    </div>
                    <div>
                        <span class="tt">活动场馆：</span>
                            <span style="color: #000000"><%=activitybean.getVname()%></span>
                    </div>
                    <div class="m_choose" style="float: left;width: 600px">
                        <span class="tt">票价选择：</span>
                        <div style="float: left;width: 540px;margin-left: 5%;margin-top: -8%;">
                            <ul class="lst">
                                <%for(int i=0;i<activitybean.getHalls().get(0).getPrices().size();i++){%>
                                <li class="itm tic_price" data-price=<%=activitybean.getHalls().get(0).getPrices().get(i)%> data-tip=<%=activitybean.getHalls().get(0).getTip().get(i)%>>
                                    <a>
                                        <%if(i==0){%>
                                        <span class="price" style="color:#ff7919;cursor: pointer;"><%=activitybean.getHalls().get(0).getTip().get(i)%></span>
                                        <%}else{%>
                                        <span class="price" style="cursor: pointer;"><%=activitybean.getHalls().get(0).getTip().get(i)%></span>
                                        <%}%>
                                    </a>
                                </li>
                                <%}%>
                            </ul>
                        </div>
                    </div>
                    <div class="y_choose" style="display: none;">
                        <span class="tt">您选择了：</span>
                        <div class="ct" style="float: left;width: 450px;margin-left: 17%;margin-top: -9%;">
                            <ul class="lst" id="my-list">

                            </ul>
                        </div>
                        <div style="float: left;width: 450px;margin-left: 17%;margin-top: 5%;">
                            <a class="u-btn-buynow">立即预定</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<div class="modal-container" style="display:none;" id="upline_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">每单最多购买20张票</p>
    </div>
</div>
<div class="modal-container" style="display:none;" id="pick_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">请选择您要购买的门票</p>
    </div>
</div>

<%if(userbean.isWrong()){%>
<div class="log_pane">
        <%}else{%>
    <div class="log_pane" style="display: none;">
        <%}%>
        <div class="log_back"></div>
        <div class="pop_login">
            <ul class="pop_login_title">
                <span onclick="$('.log_pane').hide()" class="icon-modal-close"></span>
                <div class="icon icon-login-popup-logo"></div>
            </ul>
            <%if(userbean.isWrong()){%>
            <div style="color: red;margin-left: 100px;" id="wrong_tip">用户名或密码错误，请重试</div>
            <%}else{%>
            <div style="color: red;margin-left: 100px;display: none;" id="wrong_tip">用户名或密码错误，请重试</div>
            <%}%>
            <div style="color: lawngreen;margin-left: 100px;display: none;" id="log_tip">请先登录</div>
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
</body>
</html>
