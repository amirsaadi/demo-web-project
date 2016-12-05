<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
    <title>login</title>
    <!-- Latest Jquery -->
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" href="<c:url value="/resource/css/login.css"/>">
    <link rel="stylesheet" href="<c:url value="/resource/css/styles.css"/>">
    <script src="<c:url value="/resource/js/global.js"/>"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="main-content">
    <spring:url value="/login" var="loginUrl"/>

    <form class="form-login" method="post" action="${loginUrl}">
        <div class="form-log-in-with-email">
            <div class="form-white-background">
                <div class="form-title-row">
                    <h1>Log in ${param.error}</h1>
                </div>
                <div class="from-logout-message">
                    <c:if test="${param.logout != null}">
                        <p>You have successfully been logged out</p>
                    </c:if>
                </div>
                <div class="form-error-message">
                    <c:if test="${param.error != null}">
                        <p>Invalid username or password </p>
                    </c:if>
                </div>
                <div class="form-row">
                    <label>
                        <span>Email</span>
                        <input  name="email">
                    </label>
                </div>
                <div class="form-row">
                    <label>
                        <span>Password</span>
                        <input type="password" name="password">
                    </label>
                </div>
                <sec:csrfInput/>
                <div class="form-row">
                    <button type="submit">Log in</button>
                </div>
            </div>
            <a href="#" class="form-forgotten-password">Forgotten password </a>
            <a href="<spring:url value="/register/"/>" class="form-create-an-account">Create an account </a>
        </div>
    </form>
</div>
</body>
</html>
