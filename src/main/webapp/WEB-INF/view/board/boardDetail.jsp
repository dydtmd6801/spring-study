<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<jsp:include page="../../../header.jsp"/>
<div class="columns">
    <div class="column"></div>
    <div class="column is-three-fifths">
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
                        <c:out value="${board.boardContent}"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal is-justify-content-center">
            <button class="button is-primary mr-3" type="submit"><strong>Edit</strong></button>
            <a class="button is-light ml-3" href="/board">To List</a>
        </div>
    </div>
    <div class="column"></div>
</div>
</body>
</html>
