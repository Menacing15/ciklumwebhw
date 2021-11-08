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
<table>
    <tr>
        <td>action</td>
        <td>data</td>
    </tr>
    <%
        try {
            String query = "select * from web";
            Connection conn = ((Service) request.getSession().getAttribute("service")).getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString("action")%></td>
        <td><%=rs.getString("data")%></td>
    </tr>
    <%
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {

        }
    %>
</table>
</body>
</html>