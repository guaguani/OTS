<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: guagua
  Date: 18/2/21
  Time: 下午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
    <style>
        body{font-size: 14px;font-family: 'helvetica neue',tahoma,arial,'hiragino sans gb','microsoft yahei','Simsun',sans-serif; background-color:#fff; color:#808080;}
        .wrap{margin:200px auto;width:510px;}
        td{text-align:left; padding:2px 10px;}
        td.header{font-size:22px; padding-bottom:10px; color:#000;}
        td.check-info{padding-top:20px;}
        a{color:#328ce5; text-decoration:none;}
        a:hover{text-decoration:underline;}
    </style>
</head>
<body>
<div class="wrap">
    <table>
        <tr>
            <td rowspan="5" style=""><img src="https://ws1.sinaimg.cn/large/a15b4afegy1fhsfdznep4j2020020web.jpg" alt="又一个极简的错误页面"></td>
            <td class="header">很抱歉！当前页面发生了错误</td>
        </tr>
        <tr>
            <td>
                <s:property value="#result"/>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
