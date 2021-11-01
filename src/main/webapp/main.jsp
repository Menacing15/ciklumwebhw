<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        text-align:center
    }
</style>
<head>
    <title>♡</title>
</head>
<body>
<h2>ℭℑ𝔎𝔏𝔘𝔐 𝔴𝔢𝔟 𝔞𝔭𝔭</h2>
<form action="<%=request.getContextPath()%>/" method="post">
    <input type="radio" name="action">GET
    <input type="radio" name="action">GIVE
    <p>Enter your data:</p>
    <input type="text" name="input" placeholder="Anything..."/>
    <input type="submit" value="ok"/>
</form>
</body>
</html>