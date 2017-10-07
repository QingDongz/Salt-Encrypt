<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/5
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
登录失败,请重新登录
<script>
    function jumpurl(){
        location='http://localhost:8080/task5/login';
    }
    setTimeout('jumpurl()',3000);
</script>
</body>
</html>
