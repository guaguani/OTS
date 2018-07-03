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
  <title>罗汉豆</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="../css/index_css.css" rel="stylesheet" type="text/css" media="all">
  <script src="./js/jquery-3.2.1.js"></script>
  <script src="./js/Act.js"></script>
  <script src="./js/User.js"></script>
  <script>
      setInterval(function () {
          //alert("in");
          var oUl = document.getElementById('slide_window');
          var t=parseInt($("#counter").attr("name"));
          var left=parseInt($("#left").attr("name"));

          if(t==2198){
              t=0;
              if(left==4000){
                  left=40;
                  t=199;
                  $("#sp1").attr("style","background-color: #ff7919;");
                  $("#sp1").siblings().attr("style","");
              }
          }
          else{
              if(t<198){
                  left=left+5;
                  oUl.style.left = -(left)+'px';
              }
              else{
                  var s=(left-40)/990+1;
                  $("#sp"+s).attr("style","background-color: #ff7919;");
                  $("#sp"+s).siblings().attr("style","");
              }
              t=t+1;
          }
          $("#counter").attr("name",t+"");
          $("#left").attr("name",left+"");
      }, 1);

      $(document).ready(function(){
          $("body").on('click','.city-name',function(){
              $(this).parent().parent().find(".city_box").toggle();
          });
          $("body").on('click','.city-item',function(){
              var name=$(this).html();
              $(this).parent().parent().parent().parent().find(".city-name").html(name);
              search_by_city(name);
          });
          $("body").on('click','.btn-submit',function(){
              var user_input=$(this).prev().value();
              search_by_input(user_input);
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
              var res = login(name, pass);
              if (res == "1") {
                  $(".log_pane").hide();
                  $(".item-login").hide();
                  $(".item-user").show();
              }
              else{
                  $("#wrong_tip").show();
              }
          });

          $("body").on('click','.spi',function(){
              var id=parseInt($(this).attr("name"));
              $("#sp"+id).attr("style","background-color: #ff7919;");
              $("#sp"+id).siblings().attr("style","");
              var t=99;
              var left=40+((id-1)*990)-495;
              var oUl = document.getElementById('slide_window');
              oUl.style.left = -(left)+'px';
              $("#counter").attr("name",t+"");
              $("#left").attr("name",left+"");
          });

          $("body").on('click', '.search_type', function () {
              search_by_type($(this.attr("name")));
          });

          $("body").on('click', '.activity_box', function () {
              var id=$(this).attr("data-aid");
              get_act_detail(id);
          });

          $("body").on('click', '.more', function () {
              var type=$(this).attr("data-type");
              search_by_type(type);
          });
      });

  </script>
</head>
<body class="home">
<a id="counter" style="display: none;" name="0"></a>
<a id="left" style="display: none;" name="40"></a>
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


<div style="min-height: 360px;min-width: 1200px;">
  <div class="box" style="min-height: 360px;overflow: hidden;">
    <ul class="left_cate" style="padding: 0;">
      <li class="item-1">
        <a class="search_type" name="con">演唱会</a>
      </li>
      <li class="item-2">
        <a class="search_type" name="ope">话剧歌剧</a>
      </li>
      <li class="item-5">
        <a class="search_type" name="ent">休闲展览</a>
      </li>
      <li class="item-8">
        <a class="search_type" name="spo">体育赛事</a>
      </li>
      <li class="item-3">
        <a class="search_type" name="mus">音乐会</a>
      </li>
      <li class="item-4">
        <a class="search_type" name="chi">儿童亲子</a>
      </li>
      <li class="item-6">
        <a class="search_type" name="dan">舞蹈芭蕾</a>
      </li>
      <li class="item-7">
        <a class="search_type" name="bei">戏曲综艺</a>
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
        <div id="slide_window" class="slide-container" style="left: -40px;">
          <ul id="slide_ul" style="width: 7920px;margin-top: 0px;">
            <li data-aid="" class="item activity_box">
              <a>
                <div style="background-image:url(./img/ad1.jpg)" class="img"></div>
              </a>
            </li>
            <li data-aid="" class="item activity_box">
              <a>
                <div style="background-image:url(./img/ad1.jpg)" class="img"></div>
              </a>
            </li>
            <li data-aid="" class="item activity_box">
              <a>
                <div style="background-image:url(./img/ad1.jpg)" class="img"></div>
              </a>
            </li>
            <li data-aid="" class="item activity_box">
              <a>
                <div style="background-image:url(./img/ad1.jpg)" class="img"></div>
              </a>
            </li>
            <li data-aid="" class="item activity_box">
              <a>
                <div style="background-image:url(./img/ad1.jpg)" class="img"></div>
              </a>
            </li>
          </ul>
        </div>

        <ul class="spots">
          <li class="item spi" id="sp1" name="1" style="background-color: #ff7919;"></li>
          <li class="item spi" id="sp2" name="2"></li>
          <li class="item spi" id="sp3" name="3"></li>
          <li class="item spi" id="sp4" name="4"></li>
          <li class="item spi" id="sp5" name="5"></li>
        </ul>
      </div>
    </div>
  </div>
</div>


<div class="list-block box new-block">
  <div class="block-title">
    <a class="title">
      <img src="../img/hot.png" class="title-icon">
      <span class="title-text">近期热门</span>
    </a>
    <a class="more" data-type="all">更多 &gt;</a>
  </div>
  <div style="border-top-color:#ffcca6;border-top-width:2px" class="items">
    <ul style="padding: 0;">
      <li class="item activity_box" data-aid="">
        <a class="inner">
          <div style="background-image:url(./img/example_act.jpg)" class="poster"></div>
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
      <li class="item activity_box" data-aid="">
        <a class="inner">
          <div style="background-image:url(./img/example_act.jpg)" class="poster"></div>
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
      <li class="item activity_box" data-aid="">
        <a class="inner">
          <div style="background-image:url(./img/example_act.jpg)" class="poster"></div>
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
      <li class="item activity_box" data-aid="">
        <a class="inner">
          <div style="background-image:url(./img/example_act.jpg)" class="poster"></div>
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
      <li class="item activity_box" data-aid="">
        <a class="inner">
          <div style="background-image:url(./img/example_act.jpg)" class="poster"></div>
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
      <li class="item activity_box" data-aid="">
        <a class="inner">
          <div style="background-image:url(./img/example_act.jpg)" class="poster"></div>
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
      <a class="title">
        <img src="../img/hot.png" class="title-icon">
        <span class="title-text1">演唱会</span>
      </a>
      <a class="more" data-type="con">更多 &gt;</a>
    </div>
    <div class="items">
      <ul style="margin-top: 0px;padding: 0;">
        <li class="item main-item activity_box" data-aid="">
          <a>
            <img alt="JJ林俊杰【圣所】世界巡回演唱会 济南站" src="../img/example_big_act.jpg" class="poster">
          </a>
          <div class="info">
            <div class="bg" style="background-color:#ff7919"></div>
            <a>
              <div class="title">[济南] JJ林俊杰【圣所】世界巡回演唱会 济南站</div>
            </a>
            <div class="price">暂时售空</div>
          </div>
        </li>
        <li class="item activity_box" data-aid="">
          <a>
            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
          </a>
          <div class="info other-info">
            <a>
              <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
            </a>

            <div style="color:#999;">2018.08.11</div>
            <a>
              <div style="color:#999;">国家体育场（鸟巢）</div>
            </a>
            <div class="price" style="margin-top: 20px;">
              <span class="unit">¥</span>
              <span class="amount">354</span>
              起
            </div>
          </div>
        </li>
        <li class="item activity_box" data-aid="">
          <a>
            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
          </a>
          <div class="info other-info">
            <a>
              <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
            </a>

            <div style="color:#999;">2018.08.11</div>
            <a>
              <div style="color:#999;">国家体育场（鸟巢）</div>
            </a>
            <div class="price" style="margin-top: 20px;">
              <span class="unit">¥</span>
              <span class="amount">354</span>
              起
            </div>
          </div>
        </li>
        <li class="item activity_box" data-aid="">
          <a>
            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
          </a>
          <div class="info other-info">
            <a>
              <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
            </a>

            <div style="color:#999;">2018.08.11</div>
            <a>
              <div style="color:#999;">国家体育场（鸟巢）</div>
            </a>
            <div class="price" style="margin-top: 20px;">
              <span class="unit">¥</span>
              <span class="amount">354</span>
              起
            </div>
          </div>
        </li>
        <li class="item activity_box" data-aid="">
          <a>
            <img alt="张杰2018“未·LIVE”巡回演唱会-北京站" src="../img/example_poster.jpg" class="poster">
          </a>
          <div class="info other-info">
            <a>
              <div class="title">[北京] 张杰2018“未·LIVE”巡回演唱会-北京站</div>
            </a>

            <div style="color:#999;">2018.08.11</div>
            <a>
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


<div class="log_pane" style="display: none;">
  <div class="log_back"></div>
  <div class="pop_login">
    <ul class="pop_login_title">
      <span onclick="$('.log_pane').hide()" class="icon-modal-close"></span>
      <div class="icon icon-login-popup-logo"></div>
    </ul>
    <div style="color: red;margin-left: 100px;display: none;" id="wrong_tip">用户名或密码错误，请重试</div>
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
