<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@include file="navbar.jsp" %>
<div class="container col-md-4">
    <form id="registrationForm" action="registration" method="post">
        <h3 class="validation-above">
             <strong>${sessionScope.user_exists}</strong>
        </h3>
        <div class="form-group">
            <label for="name">Name</label>
            <input  class="form-control" id="name" name="firstName" value="${sessionScope.firstName}"
             placeholder="Enter your name" required>
            <p id="nameErr" class="validation-message">
                <strong>Name can contain only letters and be longer than 1 symbol</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.name}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label>
            <input  class="form-control" id="surname" name="lastName" value="${sessionScope.lastName}"
            placeholder="Enter your surname" required>
            <p id="surnameErr" class="validation-message">
                <strong>Surname can contain only letters and be longer than 1 symbol</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.name}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input  class="form-control" id="email" name="email" value="${sessionScope.email}"
             aria-describedby="emailHelp"
                    placeholder="Enter email" required>
            <p id="emailErr" class="validation-message">
                <strong>Type valid email</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.email}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"
             placeholder="Enter password" required>
            <p id="passwordErr" class="validation-message">
                <strong>Password can consist of letters and numbers and must be longer than 4 symbols</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.password}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="password">Repeat password</label>
            <input type="password" class="form-control" name="repeatPassword"
             id="repeatPassword" placeholder="Repeat password" required>
            <p id="passwordRepeatErr" class="validation-message">
                <strong>Passwords dont match</strong>
            </p>
            <p class="validation-message-s">
                <strong>${sessionScope.errors.passwordRepeat}</strong>
            </p>
        </div>

        <%--<div class="g-recaptcha" data-sitekey="6Ldhx0MUAAAAAOfsrS8dFv48VCFbQypMbVLLs5jT"></div>--%>

        <div class="row submit-row">
            <button type="submit" class="btn btn-block">
                Submit
            </button>
        </div>
    </form>
</div>
</body>