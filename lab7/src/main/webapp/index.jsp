<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="authServlet">
    <label>
        email
        <input type="text" name="email">
    </label><br/>
    <label>
        Пароль
        <input type="password" name="password">
    </label><br/>
    <input type="submit">
</form>
</body>
</html>