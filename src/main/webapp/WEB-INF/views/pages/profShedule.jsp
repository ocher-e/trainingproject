<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div>   
    <h2>
        <spring:message code="profShedule.timetable_for"/> ${pageContext.request.userPrincipal.name}
    </h2>
    <c:choose>
        <c:when test="${shedule1IsNotFormed}">
            <h3>
                <spring:message code="profShedule.timetable_not_formed_1"/>
            </h3>
        </c:when>
        <c:otherwise>
            <c:if test="${professorIsInThisShedule1}">
                <table>
                    <caption><spring:message code="profShedule.table_caption_1"/> </caption>
                    <tr>
                        <th><spring:message code="profShedule.pair"/></th>
                        <th><spring:message code="profShedule.mn"/></th>
                        <th><spring:message code="profShedule.tue"/></th>
                        <th><spring:message code="profShedule.wen"/></th>
                        <th><spring:message code="profShedule.th"/></th>
                        <th><spring:message code="profShedule.fr"/></th>
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
            <h3>
                <spring:message code="profShedule.timetable_not_formed_2"/>
            </h3>
        </c:when>
        <c:otherwise>
            <c:if test="${professorIsInThisShedule2}">
                <table>
                    <caption><spring:message code="profShedule.table_caption_2"/></caption>
                    <tr>
                        <th><spring:message code="profShedule.pair"/></th>
                        <th><spring:message code="profShedule.mn"/></th>
                        <th><spring:message code="profShedule.tue"/></th>
                        <th><spring:message code="profShedule.wen"/></th>
                        <th><spring:message code="profShedule.th"/></th>
                        <th><spring:message code="profShedule.fr"/></th>
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
