<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/13/19
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>产品录入</h3>
<form:form action="product_save" commandName="product">
    <div>
        <label>名称</label>
        <form:input path="name" type="text" name="name" placeholder="请输入名称"/>
    </div>
    <div>
        <label>描述</label>
        <form:input path="description" type="text" name="description" placeholder="请输入名称"/>
    </div>
    <div>
        <label>价格</label>
        <form:input path="price" type="text" name="price" placeholder="请输入名称"/>
    </div>
    <div>
        <label>生产日期</label>
        <form:input path="productionDate" type="text" name="productionDate" placeholder="请输入名称"/>
    </div>

    <div>
        <label>保存</label>
        <input type="submit" value="save">
    </div>

</form:form>


</body>
</html>
