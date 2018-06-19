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
    <title>罗汉豆</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/search_css.css" rel="stylesheet" type="text/css" media="all">
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

    <div class="search_city">
        <dl id="category_filter_id" class="search_city_line">
            <dt>分 类：</dt>
            <dd class="search_city_num">
                <ul class="clear">
                    <li>
                        <a href="" onclick="">
                            全部
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            演唱会
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            话剧歌剧
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            休闲展览
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            体育赛事
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            音乐会
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            儿童亲子
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
                            舞蹈芭蕾
                        </a>
                    </li>
                    <li>
                        <a href="" onclick="">
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

</body>
</html>
