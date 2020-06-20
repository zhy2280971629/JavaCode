<%--
  Created by IntelliJ IDEA.
  User: 星空
  Date: 2020/5/8
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="static/css/app.css" rel="stylesheet">
    <!-- jQuery -->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            //alert("jsp文件加载完成");
            $.ajax({
                url:"login",//请求的路径
                type:"post",//请求的方法
                contentType:"application/json",//请求的数据格式
                data:{username:"abc", password:"123"},//请求的数据
                dataType:"json",//响应的数据格式
                success: function(data){//返回的状态码是200时，调用这个函数

                }
            });
            var json = {username:"abc",password:"123"};
            alert(json.username)
            $("#btn").click(function(){
                //alert("点击按钮");
                //也可以写按钮点击，请求服务的代码
            });
        });
    </script>
</head>
<body>
<!-- 假如，提交到后台的url是http://localhost:8080/blog/login-->
<!-- action为login，访问到的是http://localhost:8080/blog/jsp/login,是以当前页面作为相对路径-->
<!-- action为/login，访问到的是http://localhost:8080/login-->
<!-- 添加jsp变量及base标签，可以解决路径问题，action为login，访问的是正确路径-->
<form action="login">
    <input type="text" name="username" placeholder="请输入用户名">
    <input type="password" name="password" placeholder="请输入密码">
    <input type="submit" value="提交">
</form>
<input id="btn" type="button" value="点击观看事件">
</body>
</html>
