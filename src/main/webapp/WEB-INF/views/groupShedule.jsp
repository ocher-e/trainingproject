<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shedule</title>
    </head>
    <body>   
        <h2> 
        You entered as <sec:authentication property="principal.username"/>
        <a href="<c:url value="/logout" />" > Logout</a> 
        </h2>
        <c:choose>
            <c:when test="${sheduleIsNotFormed}">
                <h2>The timetable for this gruoup is not formed yet</h2>
            </c:when>
            <c:otherwise>
                <table>
                    <caption>Timetable for group ${grnum} in auditory ${aud} </caption>
                    <tr>
                        <th>Pair</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thur</th><th>Fri</th>
                    </tr>
                    <c:forEach var = "week" items="${all}" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <c:forEach var = "req" items="${week}">
                            <td>${req.discipline} (${req.requester.name})</td>
                        </c:forEach>
                    </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>    
    </body>
</html>