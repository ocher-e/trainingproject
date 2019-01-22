<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requests</title>
    </head>
    <body>  
        <h2> 
        You entered as <sec:authentication property="principal.username"/>
        <a href="<c:url value="/logout" />" > Logout</a> 
        </h2>
        <table>
            <caption>Requests</caption>
            <tr>
                <th>Requester</th>
                <th>Discipline</th>
                <th>Group</th>
                <th>Pairs<br>a week</th>
                <th>Delete<br>request</th>
                
            </tr>
            <c:forEach var = "request" items="${requestList}">
            <tr>
                <td>${request.requester.name}</td>
                <td>${request.discipline}</td>
                <td>${request.studgroup}</td>
                <td>${request.pairsinweek}</td>
                <td><a href="<c:url value="/delete-request-${request.requestId}" />" > del </a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>