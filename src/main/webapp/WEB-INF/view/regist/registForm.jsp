<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-05-23(023)
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="regist"/></title>
    <style>
        .field {
            width: 60%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<jsp:include page="../../../header.jsp"/>

<form:form modelAttribute="register">
    <div class="field">
        <label class="label">ID</label>
        <div class="control">
            <form:input path="userId" class="input" placeholder="ID"/>
        </div>
        <form:errors path="userId" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">Password</label>
        <div class="control">
            <form:password path="password" class="input" placeholder="password"/>
        </div>
        <form:errors path="password" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">ConfirmPassword</label>
        <div class="control">
            <form:password path="confirmPassword" class="input" placeholder="confirmPassword"/>
        </div>
        <form:errors path="confirmPassword" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">Name</label>
        <div class="control">
            <form:input path="name" class="input" placeholder="name"/>
        </div>
        <form:errors path="name" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">NickName</label>
        <div class="control">
            <form:input path="nickName" class="input" placeholder="NickName"/>
        </div>
        <form:errors path="nickName" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">Email</label>
        <div class="control">
            <form:input path="email" class="input" placeholder="email"/>
        </div>
        <form:errors path="email" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">PhoneNumber</label>
        <div class="control">
            <form:input path="phoneNumber" class="input" placeholder="PhoneNumber"/>
        </div>
        <form:errors path="phoneNumber" class="help is-danger"/>
    </div>

    <div class="field">
        <input type="submit" class="button is-primary" value="Submit"/>
        <input type="button" onclick="javascript:history.back()" class="button is-primary" value="Cancel"/>
    </div>
</form:form>
</body>
</html>
