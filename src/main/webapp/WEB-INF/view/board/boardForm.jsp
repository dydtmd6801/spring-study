<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-05-30(030)
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h2>게시글 작성</h2>
<form:form modelAttribute="board">
    <table>
        <tr>
            <td>제목</td>
            <td><form:input path="boardTitle"/></td>
        </tr>
        <tr>
            <td>글쓴이</td>
            <td><form:input path="boardWriter"/></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><form:input path="boardContent"/></td>
        </tr>
    </table>
    <input type="submit" value="작성완료"><input type="button" value="취소" onclick="javascript:history.back()">
</form:form>
</body>
</html>
