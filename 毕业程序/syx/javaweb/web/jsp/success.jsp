<%--
  Created by IntelliJ IDEA.
  User: hyc
  Date: 2019/2/22
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>教师用户界面</title>
</head>
<body>

<div>
    <strong> welcome! </strong>
    <h4 id="h1"></h4>
</div>

</body>
<script type="text/javascript">
    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return unescape(r[2]); return null;
    }
    if(GetQueryString("userName")!=null){
        document.getElementById("h1").innerText = "Your name:" +GetQueryString("userName");
    }
    </script>
</html>
