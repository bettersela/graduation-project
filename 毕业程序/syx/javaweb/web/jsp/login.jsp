<%--
  Created by IntelliJ IDEA.
  User: hyc
  Date: 2019/2/22
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>

</head>
<body>
<p>用户名</p><input type="text" id="username"><br>
<p>密码</p><input type="password" id="password"><br>
<input type="button" value="提交" onclick="go()">
</body>
<script type="text/javascript">

    function go(){
        var username=$('#username').val();
        var password=$('#password').val();
        $.ajax({
            cache : true,
            type:"post",
            datatype : "json",
            url:"user/checkLogin.html",
            contentType:"application/x-www-form-urlencoded;charset=utf-8",
            data : {"userName":username,"password":password},
            success:function(data){
                if(data=="null")
                    alert("用户名或密码错误");
                else{
                    var jsonstr = JSON.parse(data);
                        alert("登录成功，欢迎"+jsonstr.userName);
                        if(jsonstr.userType=="1")
                            window.location.href = "http://localhost:8080/javaweb_war_exploded/user/s.html?userName="+jsonstr.userName;
                        else if(jsonstr.userType=="2")
                            window.location.href = "http://localhost:8080/javaweb_war_exploded/user/s1.html?userName="+jsonstr.userName;
                        else
                            window.location.href = "http://localhost:8080/javaweb_war_exploded/user/s2.html?userName="+jsonstr.userName;
                }


            },
            error:function(){
                alert("失败");
            }
        });
    }
</script>
</html>
