function login(username,password){
    //alert("in method login username is "+username);
    window.location.href="../login?id="+username+"&pwd="+password;
}

function logout(){
    //alert("in method logout");
    window.location.href="../logout";
}
