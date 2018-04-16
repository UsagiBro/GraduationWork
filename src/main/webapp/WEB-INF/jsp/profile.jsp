<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <h3>Please, register.</h3>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>
</body>