<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/12/19
  Time: 3:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <h3>当前的用户</h3>
    <%--<p>用户名：${user.name}</p>--%>
    <%--<p>密码：${user.password}</p>--%>


    <c:forEach items="${user}" var="u">
        <div>
            <ul>
                <li>用户名：${u.name}</li>
                <li>用户名：${u.password}</li>
            </ul>
        </div>
    </c:forEach>


</head>
<body>

</body>
</html>
