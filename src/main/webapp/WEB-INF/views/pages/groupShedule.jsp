<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>   
    <c:choose>
        <c:when test="${sheduleIsNotFormed}">
            <h2>
                <spring:message code="groupShedule.not_formed_yet"/>
            </h2>
        </c:when>
        <c:otherwise>
            <table>
                <caption><spring:message code="groupShedule.for_group"/> ${grnum} <spring:message code="groupShedule.in_auditory"/> ${aud} </caption>
                <tr>
                    <th><spring:message code="groupShedule.pair"/></th>
                    <th><spring:message code="groupShedule.mn"/></th>
                    <th><spring:message code="groupShedule.tue"/></th>
                    <th><spring:message code="groupShedule.wed"/></th>
                    <th><spring:message code="groupShedule.th"/></th>
                    <th><spring:message code="groupShedule.fr"/></th>
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
</div>
