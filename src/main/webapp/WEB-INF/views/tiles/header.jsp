<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid" id="header">
        <div class="navbar-header" style="margin-left: 10px">
            <a class="navbar-brand" href="/">HOME PAGE</a>
        </div>
        <ul class="nav navbar-nav navbar-right" style="margin-right: 5px">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group has-feedback">
                    <form:form>
                        <input type="text" class="form-control" placeholder="Search">
                        <i class="glyphicon glyphicon-search form-control-feedback"></i>
                    </form:form>
                </div>
            </form>

            <sec:authorize access="!isAuthenticated()">
                <li class=>
                    <a href="<c:url value="/login"/>" role="button">Login</a>
                </li>
                <li class>
                    <a href="<c:url value="/user/signup"/>" role="button">Sign Up</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                
                <li class>
                    <a href="user/${pageContext.request.userPrincipal.name}" role="button">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        &nbsp;
                        <sec:authentication property="principal.username"/>
                    </a>
                </li>
                <li class>
                    <a href="<c:url value="/logout"/>" role="button">Logout</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>