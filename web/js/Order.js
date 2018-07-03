function cancel(id){
    var tar = document.getElementById("canceled_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board(\"canceled_board\")",2000);
    cancel_order(id);
    window.location.href='../jsp/myOrder.jsp';
}

function time_out_cancel(id){
    var tar = document.getElementById("time_out_cancel_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board(\"time_out_cancel_board\")",2000);
    cancel_order(id);
    window.location.href='../jsp/myOrder.jsp';
}

function cancel_order(id){
    alert("in method cancel_order id is "+id);
}

function close_board(id){
    var tar = document.getElementById(id);
    tar.setAttribute("style","display:none");
}

function pay_money(par){
    //oid:account:password:sum
    alert("in method pay_money info is "+par);
    var result=1;
    if(result==1){
        var tar = document.getElementById("pay_success_board");
        tar.setAttribute("style","display:block");
        setTimeout("close_board(\"pay_success_board\")",2000);
        window.location.href='../jsp/myOrder.jsp';
    }
    else{
        var tar1 = document.getElementById("wrong_pay_info_board");
        tar1.setAttribute("style","display:block");
        setTimeout("close_board(\"wrong_pay_info_board\")",2000);
    }

}

function get_order(type){
    alert("in method get_order type is "+type);
    window.location.href='../jsp/myOrder.jsp';
}

function change_cur_order(oid){
    alert("in method change_cur_order id is "+oid);
    window.location.href='../jsp/pay.jsp';
}

function more_order(){
    var tar = document.getElementById("no_more_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board(\"no_more_board\")",2000);
}