<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 27.02.19
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>My Forum - registration</title>
</head>
<body>
    <h1>Registration</h1>
    ${error}
    <form method="post">
        <p>Login:</p>
        <input type="text" name="login" maxlength="30" />
        <p>Enter password:</p>
        <input type="password" name="password" maxlength="40" />
        <p>Repeat password:</p>
        <input type="password" name="password2" maxlength="40" /><br />
        <input type="submit" value="Register" />
    </form>
</body>
</html>
