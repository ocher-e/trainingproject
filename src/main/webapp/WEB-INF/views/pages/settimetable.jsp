<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="form-container">

    <h1>
        <spring:message code="settimetable.form_heading"/>
    </h1>

    <form:form method="POST"
               modelAttribute="timetableData"
               class="form-horizontal">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="countOfRooms">
                    <spring:message code="settimetable.count_of_rooms"/>
                </label>
                <div class="col-md-7">
                    <form:input type="text" path="countOfRooms" id="countOfRooms" class="form-control input-sm"/>
                    <div class="has-error">
                            <form:errors path="countOfRooms" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="pairsInDay">
                    <spring:message code="settimetable.pairs_a_day"/>
                </label>
                <div class="col-md-7">
                        <form:input type="text" path="pairsInDay" id="pairsInDay" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="pairsInDay" class="help-inline"/>
                        </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="workDaysInWeek">
                    <spring:message code="settimetable.workdays_a_week"/>
                </label>
                <div class="col-md-7">
                        <form:input type="text" path="workDaysInWeek" id="workDaysInWeek" class="form-control input-sm"/>
                        <div class="has-error">
                                <form:errors path="workDaysInWeek" class="help-inline"/>
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