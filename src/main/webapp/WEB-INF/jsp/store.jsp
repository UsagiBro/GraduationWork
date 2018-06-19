<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>

<div class="container">
      <div class="row">
<!--
        <div class="col-lg-3">
          <h1 class="my-4">Glasses list</h1>
          <div class="list-group">
            <a href="#" class="list-group-item">Category 1</a>
            <a href="#" class="list-group-item">Category 2</a>
            <a href="#" class="list-group-item">Category 3</a>
          </div>
        </div>
-->
          <div class="col-md-4">
            <!-- Search Widget -->
              <div class="card my-4">
                <h5 class="card-header">Search</h5>
                <div class="card-body">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-secondary" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
              <!-- Categories Widget -->
              <div class="card my-4">
                <h5 class="card-header">Categories</h5>
                <div class="card-body">
                  <div class="row">
                    <div class="col-lg-6">
                      <ul class="list-unstyled mb-0">
                        <li>
                          <a href="#">Sunglasses</a>
                        </li>
                        <li>
                          <a href="#">Round</a>
                        </li>
                        <li>
                          <a href="#">Plastic</a>
                        </li>
                      </ul>
                    </div>
                    <div class="col-lg-6">
                      <ul class="list-unstyled mb-0">
                        <li>
                          <a href="#">Eyglasses</a>
                        </li>
                        <li>
                          <a href="#">Rectangle</a>
                        </li>
                        <li>
                          <a href="#">Metal</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <!-- Side Widget -->
              <div class="card my-4">
                <h5 class="card-header">Info</h5>
                <div class="card-body">
                  Any of this models can be tried on using recognition function. You can upload your photo in cabinet to start. For more info about glasses view model page.
                </div>
              </div>
        </div>
        <div class="col-md-8">
            <h1 class="my-4">
                <small class="col-md-offset-3 ">Top choices</small>
            </h1>
          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="assets/images/glasses/Airdrop.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="assets/images/glasses/Eliot.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="assets/images/glasses/Otto.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
          <div class="row">
                <c:forEach items="${requestScope.glassesList}" var="glasses">
                    <div class="col-lg-4 col-md-6 mb-4">
                      <div class="card">
                        <a href="#"><img class="card-img-top" src="assets/images/glasses/${glasses.path}" alt=""></a>
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="/item/${glasses.id}/">${glasses.name}</a>
                          </h4>
                          <h5>${glasses.type}</h5>
                          <p class="card-text">${glasses.color}</p>
                        </div>
                      </div>
                    </div>
              </c:forEach>    
          </div>
          <!-- /.row -->
        </div>
        <!-- /.col-lg-9 -->
      </div>
    </div>  
        
    <!-- /.container -->

<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>