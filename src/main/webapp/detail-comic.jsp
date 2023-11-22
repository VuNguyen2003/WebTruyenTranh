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
<h1 style="margin-left: 12px 22px; font-size: 30px;">Thông tin truyện</h1>
<form action="detailController" method="post" enctype="multipart/form-data">
	<div id="content">
	            <div class="row mt-32 upload">
	                <div class="col-4">
	                    <div class="card upload-img ">
	                        <%
			                     String imgPath = "";
			                     ImageDAO dao = new ImageDAO();
			                     
			                     HttpSession storySessionGet = request.getSession();
			             		  int storyId = (Integer) storySessionGet.getAttribute("storyId");
			                     try {
			                         imgPath = dao.getImagePath(storyId);
			                     } catch (Exception e){
			             			e.printStackTrace();
			             		}
							%>
							<img src="<%= request.getContextPath() + "/" + imgPath %>" alt="Image">
			            </div>
			        </div>
	        
	        	<div class="col-8">
		            <div class="mb-1 align-items-center row">
		                <div class="col-3">
		                    <label for="inputStoryname" class="intro-sn col-form-label">Tên truyện</label>
		                </div>
		                <div class="col-9 col-sm-9">
		                  <p>${name_story}</p>
		                </div>
		            </div>
		            <div class=" mb-1 align-items-center row">
		                <div class="col-3">
		                    <label for="inputAuthor" class="col-form-label">Tác giả</label>
		                </div>
		                <div class="col-9 col-sm-9">
		                	<p>${author}</p>
		                </div>
		            </div>
		            
	        </div>
	        

	    </div>
	</div>
	<div class="text-center mt-16">
	    <form action="uploadChapterController" method="post">
	        <input type="submit" value="Thêm chương" class="btn btn-primary">
	    </form>
	    <!-- <form action="updateStory" method="post">
	        <input type="submit" value="Cập nhật thông tin truyện" class="btn btn-secondary">
	    </form>
	    <form action="deleteStory" method="post">
	        <input type="submit" value="Xóa truyện" class="btn btn-danger">
	    </form> -->
	</div>
	</form>    
	  
        
    <%@include file="footer.jsp" %>
</body>
</html>