<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Request entering</title>
	<!--<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>-->
	<!--<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>-->
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Request entering form</h1>
 	
	<form:form method="POST" modelAttribute="newRequest" class="form-horizontal">
            
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="discipline">Discipline</label>
                    <div class="col-md-7">
                        <form:input type="text" path="discipline" id="discipline" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="discipline" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="studgroup">Group</label>
                    <div class="col-md-7">
                        <form:input type="text" path="studgroup" id="studgroup" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="studgroup" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="pairsinweek">Pairs in week</label>
                    <div class="col-md-7">
                        <form:input type="text" path="pairsinweek" id="pairsinweek" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="pairsinweek" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Register" class="btn btn-primary btn-sm">
                </div>
            </div>
	</form:form>
	</div>
</body>