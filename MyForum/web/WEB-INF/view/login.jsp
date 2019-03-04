<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 27.02.19
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <h1>Login</h1>
    <form method = "POST" action ="j_security_check">
        <table>
            <tr>
                <td>Login</td>
                <td><input type = "text" name="j_username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type = "password" name="j_password"></td>
            </tr>
        </table>
        <input type = "submit" value = "Login!">

    </form>
    <a href="register">Registration</a>
</body>
</html>