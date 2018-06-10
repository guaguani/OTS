<%--
  Created by IntelliJ IDEA.
  User: 金灵益
  Date: 2018/6/9
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/activity.css" rel="stylesheet" type="text/css" media="all">
    <script>
        function aClick() {
            var a = document.getElementById("a");
            var b = document.getElementById("b");
            var c = document.getElementById("c");
            var d = document.getElementById("d");
            var e = document.getElementById("e");
            a.onclick=function(){
                a.style.border = "5px solid #ed0a75;";
            }
            b.onclick=function(){

            }
            c.onclick=function(){

            }
            d.onclick=function(){

            }
        }
        
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

    <div style="width: 1200px; height: 800px;margin-left: 10%">
        <p style="background-color: #eaeaea;    padding: 12px 20px 14px 20px;">
            <a href="">罗汉豆</a>
            <span class="arrow">&gt;</span>
            <a href="" target="_blank">北京</a>
            <span class="arrow">&gt;</span>
            <a href="" target="_blank">演唱会</a>
            <span class="arrow">&gt;</span>
            <strong>张杰演唱会</strong>
        </p>


        <div style="background-color: #ffffff;float: left;width: 1200px;border: 1px solid #c1c3c2;">

            <div style="padding: 30px 20px 30px 30px;width: 300px;float: left">
                <div style="height: 372px;margin: 0 0 20px 0;">
                    <img width="277"
                         height="373"
                         src="../img/example_poster.jpg"
                         style="display: block;">
                </div>
            </div>

            <div style="background-color: rgba(110,255,211,0);width: 500px;padding: 30px 20px 30px 0;float: left">
                <h2>张杰演唱会</h2>
                <div>
                    <div>
                        <span class="tt">开始时间：</span>
                            <span style="color: #000000">2018-10-06 13:00:00</span>
                    </div>

                    <div>
                        <span class="tt">活动场馆：</span>
                            <span style="color: #000000">北京鸟巢</span>
                    </div>

                    <div class="m_choose" style="float: left;width: 600px">
                        <span class="tt">票价选择：</span>
                        <div style="float: left;width: 540px;margin-left: 5%;margin-top: -8%;">
                            <ul class="lst">
                                <li class="itm">
                                    <a id = "a" href="">
                                        <span class="price">2000元（B）</span>
                                    </a>
                                </li>
                                <li class="itm">
                                    <a id = "b" href="">
                                        <span class="price">2800元（A）</span>
                                    </a>
                                </li>
                                <li class="itm">
                                    <a id = "c"  href="">
                                        <span class="price">4500元（A+）</span>
                                    </a>
                                </li>
                                <li class="itm">
                                    <a id = "d" href="">
                                        <span class="price">乐享白银包厢  35000元</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>


                    <div class="y_choose">
                        <span class="tt">您选择了：</span>
                        <div class="ct" style="float: left;width: 450px;margin-left: 17%;margin-top: -9%;">
                            <ul class="lst">
                                <li class="itm">
                                    <span class="price">“2000元（B）”</span>
                                    <span class="m-nums">
                                        <ul class="btn-numbox">
                                            <li><span class="number">数量</span></li>
                                            <li>
                                                <ul class="count">
                                                    <li><span id="num-jian" class="num-jian">-</span></li>
                                                    <li><input type="text" class="input-num" id="input-num" value="0" /></li>
                                                    <li><span id="num-jia" class="num-jia">+</span></li>
                                                </ul>
                                            </li>
　　　                                   </ul>
                                    </span>
                                </li>
                            </ul>
                        </div>

                        <div style="float: left;width: 450px;margin-left: 17%;margin-top: 5%;">
                            <a class="u-btn-buynow" href="./order_check.jsp">立即预定</a>
                        </div>
                    </div>


                </div>
            </div>


        </div>
    </div>


</body>
</html>
