<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
    <spring:message code="header.you_entered_as"/> <sec:authentication property="principal.username"/>
        <a href="<c:url value="/logout" />" > <spring:message code="header.logout"/></a>
        &nbsp;
        <a href="?languageVar=en">EN</a>
        <a href="?languageVar=ru">RU</a>
</div>