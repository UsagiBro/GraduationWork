<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<form action="uploadPhoto" method="post">
    <input class="btn btn-success" type="file" id="avatar" name="avatar" accept="image/*" value="Upload photo">
</form>

</body>