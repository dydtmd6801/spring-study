<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-05-26(026)
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <style>
        .box{
            width: 40%;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -75%);
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<form:form modelAttribute="login" class="box content">
    <h2>SIGN IN</h2>
    <div class="field">
        <label class="label">ID</label>
        <div class="control">
            <form:input path="id" class="input" placeholder="ID"/>
        </div>
    </div>

    <div class="field">
        <label class="label">Password</label>
        <div class="control">
            <form:password path="password" class="input" placeholder="password"/>
        </div>
    </div>

    <div class="field">
        <input type="submit" class="button is-primary" value="Sign In"/>
    </div>
</form:form>
</body>
</html>
