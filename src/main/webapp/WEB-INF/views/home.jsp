<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container" id="body">
    <div class="row">
        <c:forEach var="something" items="#">
            <div class="col-sm-3">
                <div class="panel panel-primary">
                   <p>Put something interesting here</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>