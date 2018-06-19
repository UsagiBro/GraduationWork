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
        <div class="col-md-7">
          <img class="img-fluid" src="/loadPhoto" alt="">
        </div>
        <div class="col-md-5">
            <h5 class="card-header">Here you can start choosing glasses.</h5>
            <div class="card-body">
              It is simple, just follow this steps:
            <ul>
                <li>Click "Choose files" button and select your photo</li>
                <li>Click "Upload" button and your photo will appear in your profile</li>
                <li>Press "Choose glasses for me"</li>
                <li>All glasses suitable for you will be shown here</li>
            </ul>
                <form method="POST" action="/uploadPhoto" enctype="multipart/form-data">
                    <div class="form-inline">
                            <input class="file-input-btn" type="file" name="file" multiple>
                        <input class="row upload-btn" type="submit" value="Upload">
                    </div>
                </form>
                <form method="GET" action="/recognition">
                    <div class="form-inline">
                        <input class="btn btn-block btn-success-input" type="submit" value="Start recognition">
                    </div>
                </form>
            </div>
        </div>
      </div>
      <!-- /.row -->
        
      <!-- Related Projects Row -->
      <h3 class="my-4">Another photos</h3>
      <div class="row">
            <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="upload/ivan@gmail.com.jpg" alt="">
            </a>
          </div>
          <div class="col-md-3 col-sm-6 mb-4">
            <a href="#">
                <img class="img-fluid" src="upload/dmytro@gmail.com.jpg" alt="">
            </a>
          </div>
          <div class="col-md-3 col-sm-6 mb-4">
              <a href="#">
                <img class="img-fluid" src="upload/ivan2@gmail.com.jpg" alt="">
              </a>
          </div>
        </div>
      <!-- /.row -->
    </div>
    <!-- /.container -->


<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>