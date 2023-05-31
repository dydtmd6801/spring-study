<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <style>
        table {
            width: 80%;
            margin: 0 auto;
        }
        table > tr {
            text-align: center;
        }
        table > thead > tr > td:nth-child(1),
        table > thead > tr > td:nth-child(3),
        table > thead > tr > td:nth-child(4) {
            width: 13%;
        }
        table > thead > tr > td:nth-child(2) {
            width: 61%;
        }
        .content {
            text-align: center;
        }
        #writeBtn {
            width: 100%;
            text-align: right;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<div class="content">
    <h2>BOARD LIST</h2>
</div>
<c:choose>
    <c:when test="${boardList eq 'empty'}">
        <p>게시글이 없습니다.</p>
    </c:when>
    <c:otherwise>
        <table class="table is-fullwidth">
            <thead>
            <tr>
                <td>No.</td>
                <td>제목</td>
                <td>글쓴이</td>
                <td>날짜</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${boardList}" var="list" varStatus="status">
                <tr>
                    <td><c:out value="${status.count}"/></td>
                    <td><c:out value="${list.boardTitle}"/></td>
                    <td><c:out value="${list.boardWriter}"/></td>
                    <fmt:parseDate value="${list.writeDate}" pattern="yyyy-MM-dd" var="parseDate" type="both" />
                    <td><fmt:formatDate value="${parseDate}" pattern="yyyy.MM.dd"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
<div id="writeBtn">
    <input type="button" class="button is-primary" onclick="location.href='/board/insert'" value="글쓰기"/>
</div>
</body>
</html>
