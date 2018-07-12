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
    window.location.href="../cancelOrder";
}

function close_board(id){
    var tar = document.getElementById(id);
    tar.setAttribute("style","display:none");
}

function pay_money(v2,v3){
    alert("in method pay_money acc is "+v2);
    window.location.href="../Pay?ac="+v2+"&pw="+v3;
}

function get_order(type){
    alert("in method get_order type is "+type);
    window.location.href="../getOrder?type="+type;
}

function change_cur_order(oid){
    alert("in method change_cur_order id is "+oid);
    window.location.href="../changeCurOrder?oid="+oid;
}

function search_order_up(){
    alert("IN SEARCH ORDER UP");
    window.location.href="../OrderPageChange?dir=up";
}

function search_order_down(){
    alert("IN SEARCH ORDER DOWN");
    window.location.href="../OrderPageChange?dir=down";
}