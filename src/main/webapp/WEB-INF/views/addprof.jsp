<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pfofessor entering</title>
	<!--<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>-->
	<!--<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>-->
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Professor entering form</h1>
 	
	<form:form method="POST" modelAttribute="newProfessor" class="form-horizontal">
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="login">Login</label>
                    <div class="col-md-7">
                        <form:input type="text" path="login" id="login" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="login" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Password</label>
                    <div class="col-md-7">
                        <form:input type="text" path="password" id="password" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="password" class="help-inline"/>
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
</html>