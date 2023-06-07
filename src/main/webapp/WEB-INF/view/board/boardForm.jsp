<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="../../../header.jsp"/>
<div class="columns">
    <div class="column"></div>
    <form:form modelAttribute="board" class="column is-three-fifths">
        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Subject</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:input class="input" path="boardTitle" placeholder="Write Subject"/>
                    </div>
                        <%--                <p class="help is-danger">This field is required</p>--%>
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
                        <c:out value="${authInfo.name}"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Content</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:textarea class="textarea" path="boardContent" placeholder="Write Content"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal is-justify-content-center">
            <button class="button is-primary mr-3" type="submit"><strong>Complete</strong></button>
            <a class="button is-light ml-3" href="/board">Cancel</a>
        </div>
    </form:form>
    <div class="column"></div>
</div>
</body>
</html>
