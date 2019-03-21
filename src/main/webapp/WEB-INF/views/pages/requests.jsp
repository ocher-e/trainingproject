<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div>  
    <table>
        <caption><spring:message code="requests.requests"/></caption>
        <tr>
            <th><spring:message code="requests.requester"/></th>
            <th><spring:message code="requests.subject"/></th>
            <th><spring:message code="requests.group"/></th>
            <th><spring:message code="requests.pairs"/></th>
            <th><spring:message code="requests.delete.request"/></th>

        </tr>
        <c:forEach var = "request" items="${requestList}">
        <tr>
            <td>${request.requester.name}</td>
            <td>${request.discipline}</td>
            <td>${request.studgroup}</td>
            <td>${request.pairsinweek}</td>
            <td>
                <a href="<c:url value="/delete-request-${request.requestId}" />" >
                    <spring:message code="requests.del"/> 
                </a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
