<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<spring:url value="/"/>" class="navbar-brand">Amir's web blog</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="<spring:url value="/topic/"/>">Topics</a></li>
            <li><a href="<spring:url value="/publish/"/>">publish</a></li>
            <li><a href="<spring:url value="/stats/"/>">Stats</a></li>

            <sec:authorize access="authenticated" var="authenticated"/>
            <c:choose>
                <c:when test="${authenticated}">
                    <li>
                        <p class="navbar-text">
                            <a id="logout" href="#">Logout</a>
                            Welcome
                            <sec:authentication property="name"/>

                        </p>
                        <form id="logout-form" action="<c:url value="/logout"/>" method="post">
                            <sec:csrfInput/>
                        </form>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="<spring:url value="/login/"/>">Sign In</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
