<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Login</title>
	<style type="text/css">
		<%@ include file="style.css" %>
	</style>
</head>
<body class="login">
    <form action="${pageContext.servletContext.contextPath}/Home" method="doGet">
        <h1 class="log_header">Login</h1>
        <input type="text" name="" placeholder="Username" />
        <input type="password" name="" placeholder="Password" />
        <input type="submit" name="" value="Login" />
    </form>

</body>
</html>