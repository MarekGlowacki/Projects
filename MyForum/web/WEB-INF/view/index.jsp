<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 27.02.19
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Forum</title>
</head>
<body>
    <h1>Forum</h1>
    <table>
        <tr>
            <th>Subject</th>
            <th>Date</th>
            <th>Author</th>
        </tr>
        <c:forEach var="subject" items="${subjects}">
            <tr>
                <td>
                    <c:url var="url" scope="page" value="/subject">
                        <c:param name="id" value="${subject.id}" />
                    </c:url>
                    <a href="${url}">${subject.title}</a>
                </td>
                <td><fmt:formatDate value="${subject.date}" dateStyle="short" timeStyle="short" type="both" /></td>
                <td>${subject.user.login}</td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/newSubject" var="urlNewSubject" scope="page" />
    <form action="${urlNewSubject}">
        <input type="submit" value="New Subject" />
    </form>
    <br />
    <a href="logout">Log out</a>
</body>
</html>