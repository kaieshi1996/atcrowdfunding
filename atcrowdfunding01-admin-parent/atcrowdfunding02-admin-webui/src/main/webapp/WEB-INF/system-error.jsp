<%--
  Created by IntelliJ IDEA.
  User: 陈佳益
  Date: 2022/1/16
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错了....</title>
</head>
<body>

<h1>出错了！</h1>
<!-- 从请求域取出Exception对象，再进一步访问message属性就能显示错误消息 -->
${ requestScope.exception.message }
<p th></p>
</body>
</html>
