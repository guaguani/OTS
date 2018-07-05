function search_by_city(city){
    alert("in method search_by_city city is "+city);
    $.ajax({
        type: "post",
        async: false,
        url: "/Act",
        dataType: "json",
        data: {"func": "cond",
            "city":city,
            "type":""},
        success: function (result) {
            window.location.href='../jsp/search.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function search_by_input(input){
    alert("in method search_by_input input is "+input);
    $.ajax({
        type: "post",
        async: false,
        url: "/Act",
        dataType: "json",
        data: {"func": "inp",
            "inp":input},
        success: function (result) {
            window.location.href='../jsp/search.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function search_by_type(type){
    alert("in method search_by_type type is "+type);
    $.ajax({
        type: "post",
        async: false,
        url: "/Act",
        dataType: "json",
        data: {"func": "cond",
            "city":"",
            "type":type},
        success: function (result) {
            window.location.href='../jsp/search.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function get_act_detail(act_id){
    alert("in method get_act_id id is "+act_id);
    $.ajax({
        type: "post",
        async: false,
        url: "/Act",
        dataType: "json",
        data: {"func": "act",
            "id":act_id},
        success: function (result) {
            window.location.href='../jsp/activity.jsp';
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function more_act(){
    var id=[];
    var name=[];
    var s_time=[];
    var e_time=[];
    var vname=[];
    var city=[];
    var price=[];
    var path=[];
    $.ajax({
        type: "post",
        async: false,
        url: "/Act",
        dataType: "json",
        data: {"func": "more"},
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                id.push(result[i].id);
                name.push(result[i].name);
                s_time.push(result[i].s_time);
                e_time.push(result[i].e_time);
                vname.push(result[i].vname);
                city.push(result[i].city);
                price.push(result[i].price);
                path.push(result[i].path);
            }
            if(id.length==0){
                var tar = document.getElementById("no_more_board");
                tar.setAttribute("style","display:block");
                setTimeout("close_board_in_act(\"no_more_board\")",2000);
            }
            else{
                for(var i=0;i<id.length;i++){
                    var alist=document.createElement("li");
                    alist.setAttribute("class","activity_box");
                    alist.setAttribute("data-aid",id[i]);

                    var cct=document.createElement("div");
                    cct.setAttribute("class","search_img");

                    var a1=document.createElement("a");
                    a1.setAttribute("title",name[i]);

                    var i1=document.createElement("img");
                    i1.setAttribute("alt",name[i]);
                    i1.setAttribute("class","poster");
                    i1.setAttribute("src",path[i]);

                    a1.appendChild(i1);
                    cct.appendChild(a1);
                    alist.appendChild(cct);

                    var ld=document.createElement("div");
                    ld.setAttribute("class","search_txt");
                    var cct1=document.createElement("h3");
                    cct1.innerHTML="["+city[i]+"]  "+name[i];

                    ld.appendChild(cct1);

                    var lt=document.createElement("div");
                    lt.setAttribute("style","color:#999;");
                    lt.innerHTML=s_time[i];
                    ld.appendChild(lt);

                    var lc1=document.createElement("a");
                    var lc=document.createElement("div");
                    lc.setAttribute("style","color:#999;");
                    lc.innerHTML=vname[i];
                    lc1.appendChild(lc);
                    ld.appendChild(lc1);

                    var d1=document.createElement("div");
                    d1.setAttribute("class","price");
                    d1.setAttribute("style","margin-top: 20px;");
                    var s1=document.createElement("span");
                    s1.setAttribute("class","unit");
                    s1.innerHTML="￥";
                    d1.appendChild(s1);
                    var s2=document.createElement("span");
                    s2.setAttribute("class","amount");
                    s2.innerHTML=price[i];
                    d1.appendChild(s2);
                    var s3=document.createElement("span");
                    s3.setAttribute("class","unit");
                    s3.innerHTML="起";
                    d1.appendChild(s3);
                    ld.appendChild(d1);

                    alist.appendChild(ld);

                    var tar1 = document.getElementById("content_list");
                    tar1.appendChild(alist);
                }
            }


        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });

}

function close_board_in_act(id){
    var tar = document.getElementById(id);
    tar.setAttribute("style","display:none");
}