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
    <title><spring:message code="regist" /></title>
</head>
<body>
<div>
    <c:if test="${check eq 2}">
        <script>
            window.alert(<spring:message code="regist.duplicate" />);
        </script>
    </c:if>
    <c:if test="${check eq -1}">
        <script>
            window.alert("<spring:message code="regist.notMatch" />");
        </script>
    </c:if>
    <form:form modelAttribute="register">
        <div>
            <span><spring:message code="id" /></span><form:input path="userId" />
        </div>
        <div>
            <span><spring:message code="password" /></span><form:password path="password" />
        </div>
        <div>
            <span><spring:message code="confirmPassword" /></span><form:password path="confirmPassword" />
        </div>
        <div>
            <span><spring:message code="name" /></span><form:input path="name" />
        </div>
        <div>
            <span><spring:message code="nickName" /></span><form:input path="nickName" />
        </div>
        <div>
            <span><spring:message code="email" /></span><form:input path="email" />
        </div>
        <div>
            <span><spring:message code="phoneNumber" /></span><form:input path="phoneNumber" />
        </div>
        <div><input type="submit" value="<spring:message code="regist.submit" />"><input type="button" value="<spring:message code="regist.cancel" />"></div>
    </form:form>
</div>
</body>
</html>
