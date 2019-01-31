<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>   
    <h2>Timetable for ${pageContext.request.userPrincipal.name}</h2>
    <c:choose>
        <c:when test="${shedule1IsNotFormed}">
            <h3>Timetable for group 1 is not formed yet</h3>
        </c:when>
        <c:otherwise>
            <c:if test="${professorIsInThisShedule1}">
                <table>
                    <caption>In group 1 </caption>
                    <tr>
                        <th>Pair</th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thurthday</th><th>Friday</th>
                    </tr>
                    <c:forEach var = "week" items="${week4Group1}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <c:forEach var = "req" items="${week}">
                            <c:choose>
                                <c:when test="${req.requester.login == pageContext.request.userPrincipal.name}">
                                    <td> ${req.discipline}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>-</td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                    </c:forEach>
                </table>
            </c:if>
        </c:otherwise>
    </c:choose>

    <br>
    <c:choose>
        <c:when test="${shedule2IsNotFormed}">
            <h3>Timetable for group 2 is not formed yet</h3>
        </c:when>
        <c:otherwise>
            <c:if test="${professorIsInThisShedule2}">
                <table>
                    <caption>In group 2 </caption>
                    <tr>
                        <th>Pair</th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thurthday</th><th>Friday</th>
                    </tr>
                    <c:forEach var = "week" items="${week4Group2}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <c:forEach var = "req" items="${week}">
                            <c:choose>
                                <c:when test="${req.requester.login == pageContext.request.userPrincipal.name}">
                                    <td>${req.discipline}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>-</td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                    </c:forEach>
                </table>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>
