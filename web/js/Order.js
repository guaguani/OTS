function cancel(id){
    var tar = document.getElementById("canceled_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board(\"canceled_board\")",2000);
    cancel_order(id);
}

function time_out_cancel(id){
    var tar = document.getElementById("time_out_cancel_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board(\"time_out_cancel_board\")",2000);
    cancel_order(id);
}

function cancel_order(id){
    alert("in method cancel_order id is "+id);
    $.ajax({
        type: "post",
        async: false,
        url: "/Order",
        dataType: "json",
        data: {"func": "can",
            "id":id},
        success: function (result) {
            window.location.href='../jsp/myOrder.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function close_board(id){
    var tar = document.getElementById(id);
    tar.setAttribute("style","display:none");
}

function pay_money(oid,v2,v3,sum){

    alert("in method pay_money info is "+oid);
    $.ajax({
        type: "post",
        async: false,
        url: "/Order",
        dataType: "json",
        data: {"func": "pay",
            "oid":oid,
            "account":v2,
        "password":v3,
        "sum":sum},
        success: function (result) {
            if (result[0].answer == "FAIL") {
                var tar1 = document.getElementById("wrong_pay_info_board");
                tar1.setAttribute("style","display:block");
                setTimeout("close_board(\"wrong_pay_info_board\")",2000);
            }
            else{
                var tar = document.getElementById("pay_success_board");
                tar.setAttribute("style","display:block");
                setTimeout("close_board(\"pay_success_board\")",2000);
                window.location.href='../jsp/myOrder.jsp';
            }

        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });

}

function get_order(type){
    alert("in method get_order type is "+type);
    $.ajax({
        type: "post",
        async: false,
        url: "/Order",
        dataType: "json",
        data: {"func": "cond",
            "type":type},
        success: function (result) {
            window.location.href='../jsp/myOrder.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function change_cur_order(oid){
    alert("in method change_cur_order id is "+oid);
    $.ajax({
        type: "post",
        async: false,
        url: "/Order",
        dataType: "json",
        data: {"func": "ord",
            "oid":oid},
        success: function (result) {
            window.location.href='../jsp/order_check.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function more_order(){
    var id=[];
    var state=[];
    var c_time=[];
    var aid=[];
    var path=[];
    var a_name=[];
    var a_time=[];
    var v_name=[];
    var sum=[]

    $.ajax({
        type: "post",
        async: false,
        url: "/Order",
        dataType: "json",
        data: {"func": "more"},
        success: function (result) {

            for (var i = 0; i < result.length; i++) {
                id.push(result[i].id);
                state.push(result[i].state);
                c_time.push(result[i].c_time);
                aid.push(result[i].aid);
                path.push(result[i].path);
                a_name.push(result[i].a_name);
                a_time.push(result[i].a_time);
                v_name.push(result[i].v_name);
                sum.push(result[i].sum);
            }
            if(id.length==0){
                var tar = document.getElementById("no_more_board");
                tar.setAttribute("style","display:block");
                setTimeout("close_board(\"no_more_board\")",2000);
            }
            else{
                for(var i=0;i<id.length;i++){
                    var lieb=document.createElement("div");
                    lieb.setAttribute("style","height: 300px");
                    lieb.setAttribute("class","order-box");
                    lieb.setAttribute("data-orderid",id[i]);

                    var top=document.createElement("div");
                    top.setAttribute("class","order-header");

                    var s1=document.createElement("span");
                    s1.setAttribute("class","order-date");
                    s1.innerHTML=c_time[i];
                    var s2=document.createElement("span");
                    s2.setAttribute("class","order-id");
                    s2.innerHTML="订单号";
                    var s3=document.createElement("span");
                    s3.setAttribute("class","order-id");
                    s3.innerHTML=id[i];

                    top.appendChild(s1);
                    top.appendChild(s2);
                    top.appendChild(s3);

                    lieb.appendChild(top);

                    var con=document.createElement("div");
                    con.setAttribute("class","order-body");
                    con.setAttribute("style","height: 220px");

                    var con1=document.createElement("div");
                    con1.setAttribute("class","poster");

                    var det=document.createElement("img");
                    det.setAttribute("src",path[i]);
                    con1.appendChild(det);
                    con.appendChild(con1);

                    var con2=document.createElement("div");
                    con2.setAttribute("class","order-content");
                    var d1=document.createElement("div");
                    d1.setAttribute("class","activity-name");
                    d1.innerHTML=a_name[i];

                    var d2=document.createElement("div");
                    d2.setAttribute("class","venue-name");
                    d2.innerHTML=v_name[i];

                    var d3=document.createElement("div");
                    d3.setAttribute("class","order-time");
                    d3.innerHTML=a_time[i];

                    con2.appendChild(d1);
                    con2.appendChild(d2);
                    con2.appendChild(d3);

                    con.appendChild(con2);

                    var d4=document.createElement("div");
                    d4.setAttribute("class","order-price");
                    d4.innerHTML=sum[i];

                    var d5=document.createElement("div");
                    d5.setAttribute("class","order-status");
                    d5.innerHTML=state[i];

                    con.appendChild(d4);
                    con.appendChild(d5);

                    var ac=document.createElement("div");
                    ac.setAttribute("class","actions");
                    var d6=document.createElement("div");


                    if(state[i]=="未支付"){
                        var a1=document.createElement("a");
                        a1.setAttribute("class","order-pay");
                        a1.setAttribute("name",id[i]);
                        a1.innerHTML="立即支付";
                        d6.appendChild(a1);
                    }
                    else if(state[i]=="待使用"){
                        var a2=document.createElement("a");
                        a2.setAttribute("class","order-cancel");
                        a2.setAttribute("name",id[i]);
                        a2.setAttribute("style","color: #333;");
                        a2.innerHTML="取消订单";
                        d6.appendChild(a2);
                    }
                    else{
                        var a3=document.createElement("a");
                        a3.setAttribute("class","order-detail");
                        a3.setAttribute("name",aid[i]);
                        a3.innerHTML="活动详情";
                        d6.appendChild(a3);
                    }
                    ac.appendChild(d6);
                    con.appendChild(ac);
                    lieb.appendChild(con);

                    var tar1 = document.getElementById("order_box");
                    tar1.appendChild(lieb);
                }
            }


        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });

}