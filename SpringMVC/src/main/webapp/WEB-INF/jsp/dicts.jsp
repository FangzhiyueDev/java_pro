<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/13/19
  Time: 7:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${path}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<table>
    <tr>
        <th colspan="4">字典管理</th>
    </tr>
    <tr>
        <th>类别名</th>
        <th>字典名</th>
        <th>字典值</th>
        <th>操作 [<a href="${path}/add">新增</a>]</th>
    </tr>

    <c:forEach items="${dicts}" var="dict">
        <tr id="dict-${dict.id}">
            <td>${dict.code}</td>
            <td>${dict.name}</td>
            <td>${dict.value}</td>
            <td>
                [<a href="${path}/add?id=${dict.id}">编辑</a>]
                [<a href="javascript:;" onclick="deleteById(${dict.id},'${dict.name}')">删除</a>]
            </td>
        </tr>
    </c:forEach>
</table>

<script>

    function deleteById(id, lable) {

        var r = confirm("确实要删除" + lable + "吗?");

        if (r) {

            $.ajax({
                url: '${path}/delete',
                data: {
                    id: id,
                },
                dataType: "json",
                type: "POST",
                success: function (data) {
                    if (data.success) {
                        $("#dict-" + id).remove();
                    } else {
                        alert(data.msg);
                    }
                }
            })
        }
    }


</script>


</body>
</html>
