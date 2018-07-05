function login(username,password){
    alert("in method login username is "+username);
    $.ajax({
        type: "post",
        async: false,
        url: "/User",
        dataType: "json",
        data: {"func": "in",
            "id":id,
            "pwd":password},
        success: function (result) {
            if (result[0].answer == "FAIL") {
                return "0";
            }
            else{
                return "1";
            }
            //alert("JUDGE WRONG");
        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
    return "1";
}

function logout(){
    $.ajax({
        type: "post",
        async: false,
        url: "/User",
        dataType: "json",
        data: {"func": "out"},
        success: function (result) {

        },error:function (XMLHttpRequest, textStatus, errorThrown) {
            //alert(XMLHttpRequest.status);
            //alert(XMLHttpRequest.readyState);
            //alert(textStatus);
        }
    });
    window.location.href='../index.jsp';
}
