<%--
  Created by IntelliJ IDEA.
  User: 曹畅
  Date: 2018/6/9
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="OPB" type="com.bean.OrderPageBean" scope="session"></jsp:useBean>
<jsp:useBean id="userbean" type="com.bean.UserBean" scope="session"></jsp:useBean>
<html>
<head>
    <title>支付</title>
    <link href="../css/index_css.css" rel="stylesheet"  type="text/css">
    <link href="../css/third.css" rel="stylesheet"  type="text/css">
    <script src="../js/jquery-3.2.1.js"></script>
    <script src="../js/Order.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

            $("body").on('click','#pay',function(){
                var v1=$("#counter");
                var v2=document.getElementById("account").value;
                var v3=document.getElementById("pwd").value

                var can=true;
                if(v2==null||v2=="") {
                    alert("请输入账号");
                    can=false;
                }
                else{
                    if(v3==null||v3=="") {
                        alert("请输入密码");
                        can=false;
                    }
                }
                if(can){
                    var state=parseInt(v1.attr("data-state"));

                    if(state==0){

                        pay_money(v2,v3);
                    }

                }

            });

        });

        setInterval(function () {
            //alert("in");
            var v1=$("#counter");
            var sec=parseInt(v1.attr("data-sec"));
            var min=parseInt(v1.attr("data-min"));
            var oid=v1.attr("data-oid");
            var state=parseInt(v1.attr("data-state"));
            //alert(min);
            if(state==0){
                if(sec==0){
                    if(min==0){
                        $("#counter").attr("data-state","1");
                        $("#loading").fadeIn(500);
                        time_out_cancel(oid);
                        $("#loading").fadeOut(500);
                    }
                    else{
                        min=min-1;
                        sec=59;
                    }
                }
                else{
                    sec=sec-1;
                }

                v1.attr("data-sec",sec+"");
                v1.attr("data-min",min+"");

            }
            else{
                clearInterval();
            }
        }, 1000);
    </script>
</head>
<body>
<a data-sec=<%=OPB.getBeans().get(0).getTime().get(1)+OPB.getBeans().get(0).getTime().get(1)*60 %> data-state="0" id="counter"></a>

<div class="pay_header">
    <div style="width: 950px;zoom:1;">
        <div class="header-title">
            <div class="alipay-logo"></div>
            <span class="logo-title">我的收银台</span>
        </div>
    </div>
</div>
<div style="width: 800px;margin-left:350px;overflow: hidden;">
    <div>
        <div class="order-area">
            <div id="order">
                <div class="orderDetail-base">
                    <div style="min-height: 30px;">
                        <span style="cursor: auto;float: left;">
                            <span>正在使用即时到账交易</span>
                        </span>
                        <span style="float: left;margin-left: 15px;">
                            <span>交易将在59分钟后关闭，请及时付款！</span>
                        </span>
                    </div>
                    <div class="commodity-message-row">
                        <span class="first"><%="罗汉豆订单："+OPB.getBeans().get(0).getId() %></span>
                        <span class="second">收款方：罗汉豆票务</span>
                    </div>
                    <span class="payAmount-area">
                        <strong><%=OPB.getSum() %></strong> 元
                    </span>
                </div>
            </div>
        </div>
        <div class="d6">
            <div class="d7">
                <div class="d8">
                    <form>
                        <div class="d9">
                            <div class="d10">
                                <div style="width:100%">
                                    <div class="d11">
                                        <p class="p1">登录支付平台付账</p>
                                    </div>
                                </div>
                            </div>
                            <div style="padding: 0;margin-top: 10px;">
                                <div>
                                    <div class="d12">
                                        <label class="d15">帐户名：</label>
                                        <%if(!userbean.getPayID().equals("")){%>
                                        <input class="i1" id="account" value=<%=userbean.getPayID() %>>
                                        <%}else{%>
                                        <input class="i1" id="account">
                                        <%}%>
                                    </div>
                                    <div class="d13">
                                        <label class="d15">支付密码：</label>
                                        <span class="s6">
												<input type="password" class="i2" id="pwd">
											</span>
                                    </div>
                                    <div class="d14">
                                        <div class="d16">
                                            <a class="a1">
                                                <span class="s7" id="pay">支付</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal-container" style="display:none;" id="time_out_cancel_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">支付超时，该订单已失效，请重新购买</p>
    </div>
</div>

<div class="modal-container" style="display:none;" id="wrong_pay_info_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">用户名或密码错误，请重试</p>
    </div>
</div>

<div class="modal-container" style="display:none;" id="pay_success_board">
    <div class="modal">
        <span class="icon"></span>
        <p class="tip">支付成功</p>
    </div>
</div>
</body>
</html>
