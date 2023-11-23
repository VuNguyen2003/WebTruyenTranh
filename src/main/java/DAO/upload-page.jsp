<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.*" %>
<%@ page import="DTO.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload comic</title>
    <link rel="stylesheet" href="Resource/css/style.css">
    <link rel="icon" href="https://flyclipart.com/favicon.png" type="image/x-icon/png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css" integrity="sha512-IJEbgDEF7OeKJRa0MY2PApnyJHRIsgzCveek4ec8VWQ+7KG3ZSKVNYa5xP/Gh0hVP0Mwb+gBsk+GwR3JQGhQNg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- <link rel="stylesheet" href="./assets/fonts/themify-icons-font/themify-icons/themify-icons.css"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag/dist/css/multi-select-tag.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<form action="uploadStoryPageController" method="post" enctype="multipart/form-data">
          <div class="row mt-32 upload">
              <div class="col-4">
                  <div class="card upload-img ">
                      <img id="story-image" src="Resource/img/upload-default.png" class="card-img-top" alt="...">
                      <input name="page[]" type="file" multiple/>
		           </div>
		       </div>
		       <div class="col-8">
		            <div class="mb-1 align-items-center row">
		                <div class="mt-8 col-8">
		                    <p>Thêm trang truyện tại đây</p>
		                </div>
		            </div>
				</div>
          </div>
          
	    <div class="text-center mt-8">
	    	<button class="btn btn-primary">Thêm trang</button>
	    </div>
	    
	</form>


	<%@include file="footer.jsp" %>
</body>