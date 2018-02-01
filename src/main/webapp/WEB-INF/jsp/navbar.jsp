<!-- Header -->
<header id="header">
    <h1><a href="/cabinet">Glasses</a></h1>
    <nav id="nav">
        <ul>
            <li><a href="/cabinet">Cabinet</a></li>
            <li><a href="/store">Glasses</a></li>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <a href="logout" class="button special">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="authorization" class="button special">Sign In</a>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>
