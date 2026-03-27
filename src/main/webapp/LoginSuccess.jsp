<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
    <h3>Hi <%= request.getAttribute("user") %>, Login Successful!</h3>
    <a href="login.html">Go Back to Login Page</a>
</body>
</html>