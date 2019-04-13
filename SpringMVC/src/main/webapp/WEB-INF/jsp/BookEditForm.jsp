<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/12/19
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">@import url("<c:url value='/css/main.css'/>");</style>
    <style></style>
</head>
<body>

<div class="global">
    <form:form commandName="book" action="../book_update" method="post">
        <fieldset>
            <legend>Edit a Book</legend>
            <form:hidden path="id"></form:hidden>
        </fieldset>
        <p>
            <label for="category">Category:</label>
            <form:select path="category.id" id="category" items="${categories}" itemLabel="name"
                         itemValue="id"></form:select>
        </p>
        <p>
            <label for="title">Title:</label>
            <form:input path="title" id="title"></form:input>
        </p>
        <p>
            <label for="author">Author:</label>
            <form:input path="author" id="author"></form:input>
        </p>
        <p>
            <label for="isbn">ISBN:</label>
            <form:input path="isbn" id="isbn"></form:input>
        </p>

        <p id="buttons">
            <input type="reset" id="reset" tabindex="4">
            <input type="submit" id="submit" tabindex="5" value="Update Book">
        </p>

    </form:form>


</div>

</body>
</html>
