<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>   
    <table>
        <caption>University settings</caption>
        <tr>
            <th>Property</th><th>Value</th>
        </tr>
        <tr>
            <th>Count<br>of rooms</th><td>${myTimetable.countOfRooms}</td>
        </tr>
        <tr>
            <th>Pairs<br>a day</th><td>${myTimetable.pairsInDay}</td>
        </tr>
        <tr>
            <th>Workdays<br>a week</th><td>${myTimetable.workDaysInWeek}</td>
        </tr>
    </table>
</div>
