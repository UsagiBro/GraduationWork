<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="col-md-6">
    
</div>
    <!-- Page Content -->
    <div class="container">

      <!-- Portfolio Item Heading -->
      <h1 class="my-4">Your cabinet
      </h1>

      <!-- Portfolio Item Row -->
      <div class="row">
        <div class="col-md-8">
          <img class="img-fluid" src="assets/images/cat_surprise_look.jpg" alt="">
        </div>
        <div class="col-md-4">
          <h3 class="my-3">Project Description</h3>
          <form method="POST" action="/uploadPhoto" enctype="multipart/form-data">
            <div class="form-inline">
                <span class="btn btn-success fileinput-button">
                    <input type="file" name="file" multiple>
                </span>
                <input class="row" type="submit" value="Upload">
            </div>
          </form>
          <h3 class="my-3">Project Details</h3>
          <ul>
            <li>Lorem Ipsum</li>
            <li>Dolor Sit Amet</li>
            <li>Consectetur</li>
            <li>Adipiscing Elit</li>
          </ul>
        </div>
      </div>
      <!-- /.row -->
        
      <!-- Related Projects Row -->
      <h3 class="my-4">Related Projects</h3>
      <div class="row">
        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="assets/images/cat_surprise_look.jpg" alt="">
          </a>
        </div>
      </div>
      <!-- /.row -->
    </div>
    <!-- /.container -->


<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>