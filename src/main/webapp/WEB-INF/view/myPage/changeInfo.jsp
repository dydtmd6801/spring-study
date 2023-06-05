<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-05(005)
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChangeInfo</title>
    <style>
        .field {
            width: 50%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<form:form modelAttribute="changeInfo">
    <div class="field">
        <label class="label">ID</label>
        ${authInfo.userId}
    </div>

    <div class="field">
        <label class="label">Name</label>
        <form:input path="name" placeholder="New Name" class="input"/>
        <form:errors path="name" class="help is-danger"/>
    </div>

    <div class="field">
        <label class="label">PhoneNumber</label>
        <form:input path="phoneNumber" placeholder="New PhoneNumber" class="input"/>
        <form:errors path="phoneNumber" class="help is-danger"/>
    </div>

    <div class="field is-horizontal is-justify-content-center">
        <button type="submit" class="button is-primary mt-6 mr-3">Complete</button>
        <a href="/myPage" class="button is-light mt-6 ml-3">Cancel</a>
    </div>
</form:form>

</body>
</html>
