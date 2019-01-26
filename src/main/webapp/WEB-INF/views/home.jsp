<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<body>
    
    <h2> 
        <!--${pageContext.request.userPrincipal.name}-->
        You entered as <sec:authentication property="principal.username"/>
        <a href="<c:url value="/logout" />" > Logout</a> 
    </h2>
	<!--Visibility is not limited-->
        <h2><a href="<c:url value="/users" />" > All users </a></h2>
        <h2><a href="<c:url value="/professors" />" > All professors </a></h2>
        <h2><a href="<c:url value="/requests" />" > All requests </a></h2>
                
        <!--Visible to professors only-->
        <sec:authorize access="hasRole('ROLE_USER')">
           <h2><a href="<c:url value="/addrequest" />" > Add request </a></h2> 
           <h2><a href="<c:url value="/show-prof/${pageContext.request.userPrincipal.name}" />" > Show personal timetable </a></h2>
        </sec:authorize>
           
        <!--Visible to admin only--> 
        <sec:authorize access="hasRole('ROLE_ADMIN')">
                <h2><a href="<c:url value="/settimetable" />" > Set properties </a></h2>
                <h2><a href="<c:url value="/addprofessor" />" > Add professor </a></h2>
                <h2><a href="<c:url value="/show-gr-1" />" > Show timetable for group 1 </h2>   
                <h2><a href="<c:url value="/show-gr-2" />" > Show timetable for group 2 </h2> 
        </sec:authorize>
</body>
</html>