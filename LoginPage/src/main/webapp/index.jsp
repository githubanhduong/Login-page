<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<html>
<body>
<h1>TRANG CHU</h1>
<form action="http://localhost:8080/LoginPage/role" method="get">
    <button type="submit" formaction="http://localhost:8080/LoginPage/role">Role Page (admin)</button>
</form>
//
<form action="http://localhost:8080/LoginPage/user" method="get">
    <button type="submit" formaction="http://localhost:8080/LoginPage/user">User Page (admin)</button>
</form>
//
<form action="http://localhost:8080/LoginPage/servlet" method="get">
    <button type="submit" formaction="http://localhost:8080/LoginPage/servlet">Servlet Page (admin, user)</button>
</form>
//
<form action="http://localhost:8080/LoginPage/demo" method="get">
    <button type="submit" formaction="http://localhost:8080/LoginPage/demo">Demo Page (admin, user)</button>
</form>
//
<c:set var="userExist" scope="session" value="${user}"/>
<c:set var="adminExist" scope="session" value="${admin}"/>
<c:if test="${adminExist != null && userExist == null}" >
<form action="http://localhost:8080/LoginPage/login" method="post">
    <button type="submit" formaction="http://localhost:8080/LoginPage/login">Logout</button>
</form>
</c:if>
//
<c:if test="${userExist != null}" >
    <form action="http://localhost:8080/LoginPage/login" method="post">
        <button type="submit" formaction="http://localhost:8080/LoginPage/login">Logout</button>
    </form>
</c:if>
//

Note : mentor them contextPath() trong intellij la 'LoginPage' de vao link   va khi back lai page mentor an f5 load page de update session

</body>
</html>
