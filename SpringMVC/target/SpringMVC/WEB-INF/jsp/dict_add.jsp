<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/13/19
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <meta charset="UTF-8">
    <title>Title</title>
    <%--<script src="<c:url var='/'/>"></script>--%>
    <script src="${path}/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<form action="${path}/add" method="post">

    <input type="hidden" name="id" value="${model.id}">
    <table>
        <c:if test="${msg!=null}">
            <tr>
                <th colspan="2" style="color:red;max-width: 400px;">${msg}</th>
            </tr>
        </c:if>

        <tr>
            <th colspan="2">字典维护</th>
        </tr>

        <tr>
            <th>类别</th>
            <td><input type="text" name="code" value="${model.code}"></td>
        </tr>

        <tr>
            <th>字典名</th>
            <td><input type="text" name="name" value="${model.name}"></td>
        </tr>

        <tr>
            <th>字典值</th>
            <td><input type="text" name="value" value="${model.value}"></td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="保存">
                <input type="button" onclick="backToList()" value="取消">
            </td>
        </tr>


    </table>

</form>

<script>

    function backToList() {
        location.href = "${path}/dicts"
    }


</script>

</body>
</html>
