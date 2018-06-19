<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<br>
<br>
<br>
    <div class="container">
    <div class="col-xs-10">
        <div id="tb-testimonial" class="testimonial testimonial-danger">
        <div class="testimonial-section">
            ${exception.errorMsg}
        </div>
        <div class="testimonial-desc">
            <img src="assets/images/error_symbol.png">
            <div class="testimonial-writer">
                <div class="testimonial-writer-name">Invalid request</div>
            </div>
        </div>
        </div>
    </div>  
    </div>

</body>