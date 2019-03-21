<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

 	<div class="form-container">
 	
            <h1>
                <spring:message code="addrequest.form_heading"/>
            </h1>
 	
	<form:form method="POST" modelAttribute="newRequest" class="form-horizontal">
            
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="discipline">
                        <spring:message code="addrequest.discipline"/>
                    </label>
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
                    <label class="col-md-3 control-lable" for="studgroup">
                        <spring:message code="addrequest.group"/>
                    </label>
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
                    <label class="col-md-3 control-lable" for="pairsinweek">
                        <spring:message code="addrequest.pairs"/>
                    </label>
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
</div>