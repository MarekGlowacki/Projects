<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 27.02.19
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>My Forum</title>
</head>
<body>
    <h1>Subject: ${subject.title}</h1>
    <table border="1">
        <tr>
            <th>Login</th>
            <th width="500">Content</th>
            <th>Date</th>
        </tr>
        <tr>
            <td>${subject.user.login}</td>
            <td>${subject.content}</td>
            <td>${subject.date}</td>
        </tr>
        <c:forEach var="post" items="${subject.posts}">
            <tr>
                <td>${post.user.login}</td>
                <td>${post.content}</td>
                <td>${post.date}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="post">
        <input type="hidden" name="id" value="${subject.id}" />
        <p>Type your answer:</p>
        <textarea name="content" rows="40" cols="8"></textarea><br />
        <input type="submit" value="OK" />
    </form>
</body>
</html>
