<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<nav>
    <ul id="menu">
        <!--Visibility is not limited-->
        <li><a href="<c:url value="/professors" />" > All professors </a></li>
        <li><a href="<c:url value="/requests" />" > All requests </a></li>
                
        <!--Visible to professors only-->
        <sec:authorize access="hasRole('ROLE_USER')">
           <li><a href="<c:url value="/addrequest" />" > Add request </a></li> 
           <li><a href="<c:url value="/show-prof/${pageContext.request.userPrincipal.name}" />" > Show personal timetable </a></li>
        </sec:authorize>
           
        <!--Visible to admin only--> 
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="<c:url value="/users" />" > All users </a></li>
            <li><a href="<c:url value="/timetable" />" > University settings </a></li>
            <li><a href="<c:url value="/settimetable" />" > Set university properties </a></li>
            <li><a href="<c:url value="/addprofessor" />" > Add professor </a></li>
            <li><a href="<c:url value="/show-gr-1" />" > Show timetable for group 1 </a></li>   
            <li><a href="<c:url value="/show-gr-2" />" > Show timetable for group 2 </a></li> 
        </sec:authorize>
    </ul>
</nav>
