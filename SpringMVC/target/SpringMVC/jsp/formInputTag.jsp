<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/12/19
  Time: 7:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form commandName="user" action="../userInput">
    <form:input path="name" placeholder="输入用户名"></form:input>
    <form:input path="password" placeholder="密码"></form:input>
    <input type="submit" value="提交">
</form:form>

</body>
</html>
