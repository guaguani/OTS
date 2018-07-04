function search_by_city(city){
    alert("in method search_by_city city is "+city);
}

function search_by_input(input){
    alert("in method search_by_input input is "+input);
}

function search_by_type(type){
    alert("in method search_by_type type is "+type);
}

function get_act_detail(act_id){
    alert("in method get_act_id id is "+act_id);
}

function more_act(){
    var tar = document.getElementById("no_more_board");
    tar.setAttribute("style","display:block");
    setTimeout("close_board_in_act(\"no_more_board\")",2000);
}

function close_board_in_act(id){
    var tar = document.getElementById(id);
    tar.setAttribute("style","display:none");
}