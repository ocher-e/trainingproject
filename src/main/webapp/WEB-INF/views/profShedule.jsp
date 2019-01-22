<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shedule</title>
    </head>
    <body>   
        <h2>Timetable for ${pageContext.request.userPrincipal.name}</h2>
        <table>
            
            <caption>In group 1 </caption>
            
            <tr>
                <th>Pair</th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thurthday</th><th>Friday</th>
            </tr>
            
            <c:forEach var = "week" items="${week4Group1}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <c:forEach var = "req" items="${week}">
                    <c:if test="${req.requester.login == pageContext.request.userPrincipal.name}">
                        <td> ${req.discipline}</td>
                    </c:if> 
                </c:forEach>
            </tr>
            </c:forEach>
            
        </table>
        
        <br>
        
        <table>
            <caption>In group 2 </caption>
            
            <tr>
                <th>Pair</th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thurthday</th><th>Friday</th>
            </tr>
            
            <c:forEach var = "week" items="${week4Group2}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <c:forEach var = "req" items="${week}">
                    <c:if test="${req.requester.name == pageContext.request.userPrincipal.name}">
                        <td>${req.discipline} (${req.requester.name}) </td>
                    </c:if> 
                </c:forEach>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>