<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access denied</title>
    </head>
    <body>
        <h2> 
            You entered as <sec:authentication property="principal.username"/> 
            and  you have no credential for this action
        </h2>
        <a href="<c:url value="/logout" />" > Logout</a> 
        
    </body>
</html>