
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员用户界面</title>
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
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
