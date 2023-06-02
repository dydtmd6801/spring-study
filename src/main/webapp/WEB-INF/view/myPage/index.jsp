<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-01(001)
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Page</title>
    <style>
        .field {
            width: 50%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<jsp:include page="../../../header.jsp"/>

<form:form action="/myPage?state=modify">
    <div class="field">
        <label class="label">ID</label>
        <div class="control">
            <c:if test="${state ne 'modify'}">
                ${authInfo.userId}
            </c:if>
            <c:if test="${state eq 'modify'}">
                <input class="input" type="text" placeholder="Text input">
            </c:if>
        </div>
    </div>

    <div class="field">
        <label class="label">Name</label>
        <c:if test="${state ne 'modify'}">
            ${authInfo.name}
        </c:if>
        <c:if test="${state eq 'modify'}">
            <input class="input" type="text" placeholder="Text input">
        </c:if>
    </div>

    <div class="field">
        <label class="label">PhoneNumber</label>
        <c:if test="${state ne 'modify'}">
            ${authInfo.phoneNumber}
        </c:if>
        <c:if test="${state eq 'modify'}">
            <input class="input" type="text" placeholder="Text input">
        </c:if>
    </div>

    <c:if test="${state ne 'modify'}">
        <div class="field is-horizontal is-justify-content-center">
            <a href="/myPage?state=modify" class="button is-primary mt-6 mr-3">Modify</a>
            <a href="/logout" class="button is-light mt-6 ml-3">Log out</a>
        </div>
    </c:if>

    <c:if test="${state eq 'modify'}">
        <div class="field is-horizontal is-justify-content-center">
            <input type="submit" class="button is-primary" value="Complete"/>
            <input type="submit" class="button is-light" value="Cancel"/>
        </div>
    </c:if>
</form:form>

</body>
</html>