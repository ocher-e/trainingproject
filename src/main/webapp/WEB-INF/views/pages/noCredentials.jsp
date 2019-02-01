<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
    <h2> 
        You entered as <sec:authentication property="principal.username"/> 
        and  you have no credential for this action
    </h2>
</div>
