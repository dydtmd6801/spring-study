<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-05(005)
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Board</title>
    <style>
        .table {
            width: 80%;
            height: 60%;
            border: 1px solid black;
            text-align: center;
            vertical-align: center;
        }
        table > tbody > tr:not(tr:last-child) {
            height: 20%;
        }
        table > tbody > tr:last-child {
            height: 60%;
        }
        table > tbody > tr > td:first-child {
            width: 10%;
        }
    </style>
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<table class="table is-narrow">
    <tr>
        <td>제목</td>
        <td>${board.boardTitle}</td>
    </tr>
    <tr>
        <td>글쓴이</td>
        <td>${board.boardWriter}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td>${board.boardContent}</td>
    </tr>
</table>
</body>
</html>
