<%--
  Created by IntelliJ IDEA.
  User: 曹畅
  Date: 2018/6/6
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <script>
        function openLogin() {
            document.getElementById("front").style.display="";
            document.getElementById("back").style.display="";
            document.getElementById("username").value="";
            document.getElementById("password").value="";
        }
        function closeLogin() {
            document.getElementById("front").style.display="none";
            document.getElementById("back").style.display="none";
        }
    </script>
</head>
<body class="home">
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


    <div style="min-height: 360px;min-width: 1200px;">
        <div class="box" style="min-height: 360px;overflow: hidden;">
            <ul class="left_cate" style="padding: 0;">
                <li class="item-1">
                    <a href="">演唱会</a>
                </li>
                <li class="item-2">
                    <a href="">话剧歌剧</a>
                </li>
                <li class="item-5">
                    <a href="">休闲展览</a>
                </li>
                <li class="item-8">
                    <a href="">体育赛事</a>
                </li>
                <li class="item-3">
                    <a href="">音乐会</a>
                </li>
                <li class="item-4">
                    <a href="">儿童亲子</a>
                </li>
                <li class="item-6">
                    <a href="">舞蹈芭蕾</a>
                </li>
                <li class="item-7">
                    <a href="">戏曲综艺</a>
                </li>
            </ul>
            <div class="ad_pos" style="margin-top: 16px;">
                <div class="slide">
                    <div class="prev">
                        <i class="fa fa-angle-left"></i>
                    </div>
                    <div class="next">
                        <i class="fa fa-angle-right"></i>
                    </div>
                    <div class="slide-container" style="left: -40px;">
                        <ul style="width: 7920px;margin-top: 0px;">
                            <li data-color="#050100" class="item">
                                <a href="" target="_blank">
                                    <div style="background-image:url(../img/ad1.jpg)" class="img"></div>
                                </a>
                            </li>
                            <li data-color="#050100" class="item">
                                <a href="" target="_blank">
                                    <div style="background-image:url(../img/ad1.jpg)" class="img"></div>
                                </a>
                            </li>
                            <li data-color="#050100" class="item">
                                <a href="" target="_blank">
                                    <div style="background-image:url(../img/ad1.jpg)" class="img"></div>
                                </a>
                            </li>
                            <li data-color="#050100" class="item">
                                <a href="" target="_blank">
                                    <div style="background-image:url(../img/ad1.jpg)" class="img"></div>
                                </a>
                            </li>
                            <li data-color="#050100" class="item">
                                <a href="" target="_blank">
                                    <div style="background-image:url(../img/ad1.jpg)" class="img"></div>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <ul class="spots">
                        <li class="item"></li>
                        <li class="item"></li>
                        <li class="item"></li>
                        <li class="item"></li>
                        <li class="item" style="background-color: #ff7919;"></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


    <div class="list-block box new-block">
        <div class="block-title">
            <a href="" class="title">
                <img src="../img/hot.png" class="title-icon">
                <span class="title-text">近期热门</span>
            </a>
            <a href="" class="more">更多 &gt;</a>
        </div>
        <div style="border-top-color:#ffcca6;border-top-width:2px" class="items">
            <ul style="padding: 0;">
                <li class="item">
                    <a target="_blank" href="" class="inner">
                        <div style="background-image:url(../img/example_act.jpg)" class="poster"></div>
                        <div class="info">
                            <div class="title">[北京] 【限时特惠】经典影像盛宴</div>
                            <div class="price">
                                <span class="unit">¥</span>
                                <span class="amount">61</span>
                                起
                            </div>
                        </div>
                    </a>
                </li>
                <li class="item">
                    <a target="_blank" href="" class="inner">
                        <div style="background-image:url(../img/example_act.jpg)" class="poster"></div>
                        <div class="info">
                            <div class="title">[北京] 【限时特惠】经典影像盛宴</div>
                            <div class="price">
                                <span class="unit">¥</span>
                                <span class="amount">61</span>
                                起
                            </div>
                        </div>
                    </a>
                </li>
                <li class="item">
                    <a target="_blank" href="" class="inner">
                        <div style="background-image:url(../img/example_act.jpg)" class="poster"></div>
                        <div class="info">
                            <div class="title">[北京] 【限时特惠】经典影像盛宴</div>
                            <div class="price">
                                <span class="unit">¥</span>
                                <span class="amount">61</span>
                                起
                            </div>
                        </div>
                    </a>
                </li>
                <li class="item">
                    <a target="_blank" href="" class="inner">
                        <div style="background-image:url(../img/example_act.jpg)" class="poster"></div>
                        <div class="info">
                            <div class="title">[北京] 【限时特惠】经典影像盛宴</div>
                            <div class="price">
                                <span class="unit">¥</span>
                                <span class="amount">61</span>
                                起
                            </div>
                        </div>
                    </a>
                </li>
                <li class="item">
                    <a target="_blank" href="" class="inner">
                        <div style="background-image:url(../img/example_act.jpg)" class="poster"></div>
                        <div class="info">
                            <div class="title">[北京] 【限时特惠】经典影像盛宴</div>
                            <div class="price">
                                <span class="unit">¥</span>
                                <span class="amount">61</span>
                                起
                            </div>
                        </div>
                    </a>
                </li>
                <li class="item">
                    <a target="_blank" href="" class="inner">
                        <div style="background-image:url(../img/example_act.jpg)" class="poster"></div>
                        <div class="info">
                            <div class="title">[北京] 【限时特惠】经典影像盛宴</div>
                            <div class="price">
                                <span class="unit">¥</span>
                                <span class="amount">61</span>
                                起
                            </div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="box">
        <div class="list-block category-block">
            <div class="block-title">
                <a href="" class="title">
                    <img src="../img/hot.png" class="title-icon">
                    <span class="title-text1">演唱会</span>
                </a>
                <a href="" class="more">更多 &gt;</a>
            </div>
            <div class="items">
                <ul style="margin-top: 0px;padding: 0;">
                    <li class="item main-item">
                        <a href="">
                            <img alt="JJ林俊杰【圣所】世界巡回演唱会 济南站" src="../img/example_big_act.jpg" class="poster">
                        </a>
                        <div class="info">
                            <div class="bg" style="background-color:#ff7919"></div>
                            <a href="">
                                <div class="title">[济南] JJ林俊杰【圣所】世界巡回演唱会 济南站</div>
                            </a>
                            <div class="price">暂时售空</div>
                        </div>
                    </li>
                    <li style="" class="item">
                        <a href="">
                            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                        </a>
                        <div class="info other-info">
                            <a href="">
                                <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
                            </a>

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
                    <li style="" class="item">
                        <a href="">
                            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                        </a>
                        <div class="info other-info">
                            <a href="">
                                <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
                            </a>

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
                    <li style="" class="item">
                        <a href="">
                            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                        </a>
                        <div class="info other-info">
                            <a href="">
                                <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
                            </a>

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
                    <li style="" class="item">
                        <a href="">
                            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
                        </a>
                        <div class="info other-info">
                            <a href="">
                                <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
                            </a>

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
        </div>
    </div>
    <div class="footer bottom-bar">
        <div class="box">
            <div class="links-and-brand">
                <img src="../img/logo.png" class="footer-logo">
            </div>
        </div>
    </div>
    <div id=back style="display:none; POSITION:absolute; left:0; top:0; width:100%; height:100%;
    background-color:#ededed; filter:alpha(opacity=60)"></div>
    <div id=front style="display:none; POSITION:absolute; left:50%; top:50%; width:400px; height:450px;
    margin-left:-200px; margin-top:-225px; border:1px solid #ffffff; background-color:#ffffff; text-align:center">
        <div style="margin-top:50px;margin-bottom:30px">
            <label style="font-size: 20px;text-align: center;margin-top: 50px;">登录</label>
        </div>
        <div style="text-align: center">
            <label style="text-align: right;width: 80px;">用户</label>
            <input type="text" id="username" name="username" value=""/>
        </div>
        <div style="text-align: center;margin-top:30px;margin-bottom:30px">
            <label style="text-align: right;width: 80px;">  密码</label>
            <input type="password" id="password" name="password" value=""/>
        </div>
        <div style="margin-top:30px">
            <input type="button" id="cancelLogin" value="退出" onclick="closeLogin()"/>
            <input type="button" id="submit" class="submit" value="登录"/>
        </div>
    </div>
</body>
</html>
