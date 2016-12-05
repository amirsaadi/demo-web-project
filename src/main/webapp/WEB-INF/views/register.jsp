<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>register</title>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" href="<c:url value="/resource/css/register.css"/>">
    <link rel="stylesheet" href="<c:url value="/resource/css/styles.css"/>">
    <script src="<c:url value="/resource/js/global.js"/>"></script>
</head>
<body>

<jsp:include page="header.jsp"/>

<c:url value="//register" var="registerUrl"/>
<div class="main-content">
    <form:form class="form-register" method="post" modelAttribute="blogger" action="${registerUrl}">
        <div class="form-register-with-email">
            <div class="form-white-background">
                <div class="form-title-row">
                    <h1>Create an account</h1>
                    <div class="validation">
                        <p ><form:errors path="password"></form:errors></p>

                    </div>

                </div>
                <div id="name" class="form-row">
                    <label>
                        <span>Name</span>
                        <form:input path="name" id="name" type="text" placeholder="Name"/>
                    </label>
                </div>
                <div id="email" class="form-row">
                    <label>
                        <span>Email</span>
                        <form:input path="email" id="email" type="email" placeholder="Email"/>
                    </label>
                </div>
                <div id="password"class="form-row">
                    <label>
                        <span>Password</span>
                        <form:input path="password" id="password" placeholder="Password" type="password" />
                    </label>
                </div>
                <div id="passwordConfirm"class="form-row">
                    <label>
                        <span>Confirm</span>
                        <form:input path="passwordConfirm" id="passwordConfirm" placeholder="Confirm password" type="password" />
                    </label>
                </div>
                <sec:csrfInput/>
                <div class="form-row">
                    <button type="submit">Register</button>
                </div>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>
