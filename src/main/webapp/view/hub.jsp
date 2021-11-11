<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="ua.aleksandr.ciklumwebhw.service.Service" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        background-image: url(../images/bg.jpg);
        text-align: center;
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        margin-left: auto;
        margin-right: auto;
    }
</style>
<head>
    <title>♡</title>
</head>
<body>
<h2>ℭℑ𝔎𝔏𝔘𝔐 𝔴𝔢𝔟 𝔞𝔭𝔭</h2>
<form action="<%=request.getContextPath()%>/hub" method="post">
    <input type="radio" name="action" value="get" required="required">GET
    <input type="radio" name="action" value="give" required="required">GIVE
    <p>Enter your data:</p>
    <input type="text" name="input" placeholder="Anything..." required="required"/>
    <input type="submit" value="ok"/>
</form>

<c:choose>
<c:when test="${table == null}">
    Such table doesn't exist.
    <br>
</c:when>
<c:otherwise>
    <table>
        <c:forEach items = "${table}" var = "row">
            <tr>
                <c:forEach items = "${row}" var = "element">
                    <td>${element}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <br>
</c:otherwise>
</c:choose>
</body>
</html>