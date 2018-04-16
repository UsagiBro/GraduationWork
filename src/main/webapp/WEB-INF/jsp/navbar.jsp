<!-- Header -->
<header id="header">
    <h1><a href="/cabinet">Web-Glasses</a></h1>
    <nav id="nav">
        <ul>
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <li><a href="/cabinet">Cabinet</a></li>
                    <li><a href="/profile">Profile</a></li>
                </c:when>
            </c:choose>
            <li><a href="/store">Store</a></li>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="/logout" class="button special">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="/authorization" class="button special">Sign In</a>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>
