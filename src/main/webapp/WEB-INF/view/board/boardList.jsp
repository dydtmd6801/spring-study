<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-05-30(030)
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<h2>게시판</h2>
<p>게시판 내용</p>
<c:choose>
    <c:when test="${boardList eq 'empty'}">
        <p>게시글이 없습니다.</p>
    </c:when>
    <c:otherwise>
        <p>게시글이 있습니다.</p>
    </c:otherwise>
</c:choose>
</body>
</html>
