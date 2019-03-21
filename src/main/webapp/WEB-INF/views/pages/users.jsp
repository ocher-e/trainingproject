<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
    <table>
        <caption><spring:message code="users.all_users"/></caption>
        <tr>
            <th><spring:message code="users.id"/></th>
            <th><spring:message code="users.name"/></th>
            <th><spring:message code="users.delete_user"/></th>
        </tr>
        <c:forEach var = "user" items="${userList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.name}</td>
            <td><a href="<c:url value="/delete-user/${user.userId}"/>"> <spring:message code="users.del"/> </a></td>
        </tr>
        </c:forEach>
    </table>
</div>

