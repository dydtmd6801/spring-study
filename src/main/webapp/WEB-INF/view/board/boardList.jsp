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
        <table border="1">
            <thead>
            <tr>
                <td>No.</td>
                <td>제목</td>
                <td>내용</td>
                <td>날짜</td>
                <td>글쓴이</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${boardList}" var="list" varStatus="status">
                <tr>
                    <td><c:out value="${status.count}"/></td>
                    <td><c:out value="${list.boardTitle}"/></td>
                    <td><c:out value="${list.boardContent}"/></td>
                    <td><c:out value="${list.writeDate}"/></td>
                    <td><c:out value="${list.boardWriter}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
