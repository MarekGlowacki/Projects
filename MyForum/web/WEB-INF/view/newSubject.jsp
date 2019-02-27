<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 27.02.19
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Forum - add new subject</title>
</head>
<body>
    <form method="post">
        <p>Type subject title:</p>
        <input type="text" name="title" maxlength="255" />
        <p>Type subject content:</p>
        <textarea name="content" rows="40" cols="9"></textarea><br />
        <input type="submit" value="Add" />
    </form>
</body>
</html>
