<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/12/19
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="global">
    <form:form commandName="book" action="book_save" method="post">
        <fieldset>
            <legend>Add a Book</legend>
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
            <input type="submit" id="submit" tabindex="5" value="Add Book">
        </p>

    </form:form>


</div>

</body>
</html>
