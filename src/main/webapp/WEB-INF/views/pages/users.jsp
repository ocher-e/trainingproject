<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
    <table>
        <caption>All users</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Delete<br>user</th>
        </tr>
        <c:forEach var = "user" items="${userList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.name}</td>
            <td><a href="<c:url value="/delete-user/${user.userId}"/>"> del </a></td>
        </tr>
        </c:forEach>
    </table>
</div>

