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

<div>
    <div class="field">
        <label class="label">ID</label>
        ${authInfo.userId}
    </div>

    <div class="field">
        <label class="label">Name</label>
        ${authInfo.name}
    </div>

    <div class="field">
        <label class="label">PhoneNumber</label>
        ${authInfo.phoneNumber}
    </div>

    <div class="field is-horizontal is-justify-content-center">
        <a href="/myPage/changeInfo" class="button is-primary mt-6 mr-3">Modify</a>
        <a href="/logout" class="button is-light mt-6 ml-3">Log out</a>
    </div>
</div>

</body>
</html>
