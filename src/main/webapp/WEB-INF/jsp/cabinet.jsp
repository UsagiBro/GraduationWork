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
    <div class="col-md-6">
        <form method="POST" action="/uploadPhoto" enctype="multipart/form-data">
        		File to upload: <input type="file" name="file">
        		Name: <input type="text" name="name">
        		<input type="submit" value="Upload"> Press here to upload your photo
        	</form>
    </div>
    </c:otherwise>
</c:choose>
</body>