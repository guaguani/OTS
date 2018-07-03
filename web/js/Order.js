function cancel(id){
    alert("in method cancel id is "+id);
    window.location.href='../jsp/myOrder.jsp';
}

function pay_money(oid){

}

function get_order(type){
    alert("in method get_order type is "+type);
    window.location.href='../jsp/myOrder.jsp';
}

function change_cur_order(oid){
    alert("in method change_cur_order id is "+oid);
    window.location.href='../jsp/pay.jsp';
}