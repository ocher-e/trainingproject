<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h2> 
        You entered as <sec:authentication property="principal.username"/>
        <a href="<c:url value="/logout" />" > Logout</a> 
        </h2>
        <table>
            <caption>All users</caption>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <c:forEach var = "user" items="${userList}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
