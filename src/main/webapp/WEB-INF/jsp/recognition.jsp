<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>

    <!-- Page Content -->
    <div class="container">

      <!-- Heading Row -->
      <div class="row my-4">
        <div class="col-lg-8">
          <img class="img-fluid rounded" src="/loadRecognisedPhoto" alt="">
        </div>
        <!-- /.col-lg-8 -->
        <div class="col-lg-4">
          <h1>${glasses.name}</h1>
          <p>${glasses.type}</p>
          <p>Lens height: ${glasses.lensHeight} cm</p>
          <p>Lens width: ${glasses.lensWidth} cm</p>
          <p>Bridge width: ${glasses.bridgeWidth} cm</p>
          <a class="btn btn-primary btn-lg" href="#">Show another model</a>
        </div>
        <!-- /.col-md-4 -->
      </div>
      <!-- /.row -->

      <!-- Call to Action Well -->
      <div class="card text-white bg-secondary my-4 text-center">
        <div class="card-body">
          <p class="text-white m-0">For more precise glasses selection, please upload photo side-on</p>
        </div>
      </div>

      <!-- Content Row -->
      <div class="row">
        <div class="col-md-4 mb-4">
          <div class="card h-100">
            <div class="card-body">
              <h2 class="card-title">The most appropriate</h2>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="/item/${glasses.id}/">${glasses.name}</a>
                </h4>
                <h5>${glasses.type}</h5>
                <p class="card-text">${glasses.color}</p>
              </div>
            </div>
          </div>
        </div>
        <!-- /.col-md-4 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>