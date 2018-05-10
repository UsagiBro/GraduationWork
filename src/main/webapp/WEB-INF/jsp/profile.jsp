<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<c:if test="${not empty sessionScope.user}">

<div class="col-md-8">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">
                <fmt:message key="page.lang.profile"/>
            </h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                    <strong>${sessionScope.user.firstName}</strong><br>
                    <table class="table table-user-information">
                        <tbody>
                        <tr>
                            <td><fmt:message key="page.lang.user.level"/>:</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><fmt:message key="page.lang.fullName"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><fmt:message key="page.lang.change.data"/></td>
                            <form action="/controller" method="post">
                                <input type="hidden" name="command" value="toUpdateUser">
                                <td>
                                    <button type="submit" class="btn btn-primary">
                                        <fmt:message key="page.lang.change.information"/>
                                    </button>
                                </td>
                            </form>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </c:if>
    <c:if test="${empty sessionScope.user}">
    <div class="bs-calltoaction bs-calltoaction-success">
        <div class="row">
            <div class="col-md-9 cta-contents">
                <h1 class="cta-title">You don't have an account yet?</h1>
                <div class="cta-desc">
                    <p>Register in our system to start you e-payments management!</p>
                </div>
            </div>
            <div class="col-md-3 cta-button">
                <a href="/html/registration.html">
                    <button type="submit" class="btn btn-success btn-block">Confirm</button>
                </a>
            </div>
        </div>
    </div>
    </c:if>

<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>