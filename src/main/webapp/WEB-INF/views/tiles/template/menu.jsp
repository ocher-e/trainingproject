<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav>
    <ul id="menu">
        <!--Visibility is not limited-->
        <li><a href="<c:url value="/requests" />" > <spring:message code="menu.all_requests"/> </a></li>
                
        <!--Visible to professors only-->
        <sec:authorize access="hasRole('ROLE_USER')">
           <li><a href="<c:url value="/professors" />" > <spring:message code="menu.all_prof"/> </a></li>            
           <li><a href="<c:url value="/addrequest" />" > <spring:message code="menu.add_req"/> </a></li> 
           <li><a href="<c:url value="/show-prof" />" > <spring:message code="menu.show_pers_ttable"/> </a></li>
        </sec:authorize>
           
        <!--Visible to admin only--> 
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="<c:url value="/users" />" > <spring:message code="menu.all_users"/> </a></li>
            <li><a href="<c:url value="/timetable" />" > <spring:message code="menu.univer_settings"/> </a></li>
            <li><a href="<c:url value="/settimetable" />" > <spring:message code="menu.set_properties"/> </a></li>
            <li><a href="<c:url value="/addprofessor" />" > <spring:message code="menu.add_prof"/> </a></li>
            <li><a href="<c:url value="/show-gr-1" />" > <spring:message code="menu.ttable_gr_1"/> </a></li>   
            <li><a href="<c:url value="/show-gr-2" />" > <spring:message code="menu.ttable_gr_2"/> </a></li> 
        </sec:authorize>
    </ul>
</nav>
