<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
</head>
<body>
<nav class="navbar is-white" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="/index">
            <img src="/static/spring_logo.png" width="112" height="28">
        </a>
    </div>
    <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item" href="/board">
                Board
            </a>
            <a class="navbar-item">
                Preparing
            </a>
        </div>
        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <c:if test="${empty authInfo}">
                        <a class="button is-light" href="/login">
                            <strong>Sign In</strong>
                        </a>
                        <a class="button is-light" href="/regist">
                            Sign Up
                        </a>
                    </c:if>
                    <c:if test="${!empty authInfo}">
                        <p class="navbar-item">${authInfo.userId}님, 환영합니다!</p>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</nav>
</body>
</html>
