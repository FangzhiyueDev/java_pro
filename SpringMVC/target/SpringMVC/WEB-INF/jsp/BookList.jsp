<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/12/19
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <title>Title</title>
    <style type="text/css">@import url("<c:url value='../../css/main.css'/>");</style>
</head>
<body>

<div id="global">
    <h1>Book List</h1>
    <a href="<c:url value="/book_input"/>">Add Book</a>
    <table>
        <tr>
            <th>Category</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td><a href="book_edit/${book.id}">Edit</a></td>
                <td><a href="book_del/${book.id}">Del</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
