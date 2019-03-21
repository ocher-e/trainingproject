<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div>
    <table>
        <caption><spring:message code="professors.all_profs"/></caption>
        <tr>
            <th><spring:message code="professors.id"/></th>
            <th><spring:message code="professors.name"/></th>
        </tr>
        <c:forEach var = "professor" items="${professorList}">
            <tr>
                <td>${professor.userId}</td>
                <td>${professor.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
