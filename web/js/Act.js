function search_by_city(city){
    //alert("in method search_by_city city is "+city);
    window.location.href="../SearchByCond?type=1&city="+city;
}

function search_by_type(type){
    //alert("in method search_by_type type is "+type);
    window.location.href="../SearchByCond?city=1&type="+type;
}

function get_act_detail(act_id){
    //alert("in method get_act_id id is "+act_id);
    window.location.href="../getActDetail?id="+act_id;
}

function lock_seat(info){
    //alert("IN LOCK SEAT :"+info);
    window.location.href="../CreateOrder?info="+info;
}

function search_act_up(){
    //alert("IN SEARCH ACT UP");
    window.location.href="../ActPageChange?dir=up";
}

function search_act_down(){
    //alert("IN SEARCH ACT DOWN");
    window.location.href="../ActPageChange?dir=down";
}

function too_much(){
    var tar = document.getElementById("upline_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board_in_act(\"upline_board\")",2000);
}

function pick_mention(){
    var tar = document.getElementById("pick_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board_in_act(\"pick_board\")",2000);
}

function close_board_in_act(id){
    var tar = document.getElementById(id);
    tar.setAttribute("style","display:none");
}