<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-05-23(023)
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<div>
    <c:if test="${check eq 2}">
        <script>
            window.alert("중복된 아이디입니다.");
        </script>
    </c:if>
    <c:if test="${check eq -1}">
        <script>
            window.alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        </script>
    </c:if>
    <form:form modelAttribute="register">
        <div>
            <span>아이디</span><form:input path="userId" />
        </div>
        <div>
            <span>비밀번호</span><form:password path="password" />
        </div>
        <div>
            <span>비밀번호 확인</span><form:password path="confirmPassword" />
        </div>
        <div>
            <span>이름</span><form:input path="name" />
        </div>
        <div>
            <span>별명</span><form:input path="nickName" />
        </div>
        <div>
            <span>이메일</span><form:input path="email" />
        </div>
        <div>
            <span>전화번호</span><form:input path="phoneNumber" />
        </div>
        <div><input type="submit" value="회원가입"><input type="button" value="취소"></div>
    </form:form>
</div>
</body>
</html>
