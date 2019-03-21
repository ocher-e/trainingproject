<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>   
    <table>
        <caption><spring:message code="timetable.univer_settings"/></caption>
        <tr>
            <th><spring:message code="timetable.property"/></th>
            <th><spring:message code="timetable.value"/></th>
        </tr>
        <tr>
            <th><spring:message code="timetable.count_of_rooms"/></th><td>${myTimetable.countOfRooms}</td>
        </tr>
        <tr>
            <th><spring:message code="timetable.pairs_a_day"/></th><td>${myTimetable.pairsInDay}</td>
        </tr>
        <tr>
            <th><spring:message code="timetable.workdays_a_week"/></th><td>${myTimetable.workDaysInWeek}</td>
        </tr>
    </table>
</div>
