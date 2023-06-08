<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-08(008)
  Time: 오전 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditForm</title>
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<div class="columns">
    <div class="column"></div>
    <form:form modelAttribute="board" class="column is-three-fifths">
        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">Subject</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <c:out value="${board.boardTitle}"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">Writer</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <c:out value="${board.boardWriter}"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label">
                <label class="label">Content</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:textarea class="textarea" path="boardContent" placeholder="Write Content"/>
                    </div>
                    <form:errors path="boardTitle" class="help is-danger"/>
                </div>
            </div>
        </div>

        <form:input path="boardId" value="${board.boardId}" type="hidden"/>

        <div class="field is-horizontal is-justify-content-center">
            <button class="button is-primary mr-3" type="submit"><strong>Complete</strong></button>
            <a class="button is-light ml-3" href="/board/detail?id=${board.boardId}">Cancel</a>
        </div>
    </form:form>
    <div class="column"></div>
</div>
</body>
</html>
