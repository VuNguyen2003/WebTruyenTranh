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
	<form action="uploadChapterController" method="post" enctype="multipart/form-data">
		<div id="content">
		            <div class="row mt-32 upload">
		                <div class="col-4">
		                    <div class="card upload-img ">
		                        <img id="story-image" src="Resource/img/upload-default.png" class="card-img-top" alt="...">
			                <input name="content[]" type="file" multiple/>
				            </div>
				        </div>
		        
		        		<div class="col-8">
				            <div class="mb-1 align-items-center row">
				                <div class="col-3">
				                    <label for="inputChaptername" class="intro-sn col-form-label">Tên chương</label>
				                </div>
				                <div class="col-9 col-sm-9">
				                  <input name="name_chapter" type="text" class="form-control" id="inputChaptername">
				                </div>
				            </div>
			            
		            	</div>
		            </div>
		    <div class="upload-chapter">
		        <div class="list-chapter" id="nt_listchapter">
		            <h2 class="list-title clearfix mt-16">
		                <i class="fa-solid fa-list"></i>
		                Danh sách chương
		            </h2>
		        </div>
		    </div>
		    <div class="text-center">
		    	<button class="btn btn-primary">Thêm chương</button>
		    </div>
		</div>
	</form>        
        
    <%@include file="footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/gh/habibmhamadi/multi-select-tag@2.0.0/dist/js/multi-select-tag.js"></script>
    <script>
    	new MultiSelectTag('tag')  // id
	</script>
</body>
</html>