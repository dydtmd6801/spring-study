<%--
  Created by IntelliJ IDEA.
  User: dydtm
  Date: 2023-06-01(001)
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Page</title>
</head>
<body>
<jsp:include page="../../../header.jsp"/>

<div class="columns">
    <div class="column"></div>
    <div class="column is-three-fifths">
        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">ID</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <p class="control is-expanded">
                        <input class="input" type="text" value="${authInfo.userId}">
                    </p>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Name</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <p class="control is-expanded">
                        <input class="input" type="text" value="${authInfo.name}">
                    </p>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">PhoneNumber</label>
            </div>
            <div class="field-body">
                <div class="field is-expanded">
                    <div class="field has-addons">
                        <p class="control">
                            <a class="button is-static">
                                +82
                            </a>
                        </p>
                        <p class="control is-expanded">
                            <input class="input" type="tel" value="${authInfo.phoneNumber}">
                        </p>
                    </div>
                    <p class="help">Do not enter the first zero</p>
                </div>
            </div>
        </div>

        <div class="field">
            <input type="submit" class="button is-primary" value="Complete"/>
        </div>

    </div>
    <div class="column"></div>
</div>

</body>
</html>
