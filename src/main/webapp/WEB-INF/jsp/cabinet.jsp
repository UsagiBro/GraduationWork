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
        <form action="uploadPhoto" method="post" enctype="multipart/form-data">
            <input class="btn btn-success" type="submit"
             id="avatar" name="avatar" accept="image/*" value="Upload photo">
        </form>
    </c:otherwise>
</c:choose>
</body>