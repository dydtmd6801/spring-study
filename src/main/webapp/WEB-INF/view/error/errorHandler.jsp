<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-09(009)
  Time: 오후 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<div class="content ml-2">
    <h2>Error Number : <c:out value="${errorNo}"/></h2>
    <p>please, push go-back button</p>
    <a href="javascript:history.back()" class="button is-primary">Go Back</a>
</div>
</body>
</html>
