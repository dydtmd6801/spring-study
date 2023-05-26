<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
</head>
<body>
<h2>로그인</h2>
<form:form modelAttribute="login">
    <spring:message code="id" /><form:input path="id" />
    <spring:message code="password" /><form:password path="password" />
    <input type="submit" value="로그인하기" /><input type="button" onclick="javascript:history.back()" value="취소" />
</form:form>
</body>
</html>
