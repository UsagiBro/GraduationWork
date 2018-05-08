<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="col-md-6">
    <form method="POST" action="/uploadPhoto" enctype="multipart/form-data">
    <div class="form-inline">
            <span class="btn btn-success fileinput-button">
                <i class="glyphicon glyphicon-plus"></i>
                <span>Add files</span>
                <input type="file" name="file" multiple>
            </span>
        <input type="submit" value="Upload"> Press here to upload your photo
    </form>
</div>
</body>