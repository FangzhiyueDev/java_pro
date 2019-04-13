<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 4/13/19
  Time: 2:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="fileSave" enctype="multipart/form-data" method="post">
    文件名:<input name="name" placeholder="文件名"><br>
    文件 :<input name="multipartFile" type="file" placeholder="选择文件">
    <input type="submit" value="提交">
</form>

</body>
</html>
