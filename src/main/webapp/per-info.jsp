<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Personal Information</title>
    <link rel="stylesheet" href="Resource/css/style.css">
    <link rel="stylesheet" href="Resource/css/sections/per-info.css">
    <link rel="icon" href="https://flyclipart.com/favicon.png" type="image/x-icon/png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css" integrity="sha512-IJEbgDEF7OeKJRa0MY2PApnyJHRIsgzCveek4ec8VWQ+7KG3ZSKVNYa5xP/Gh0hVP0Mwb+gBsk+GwR3JQGhQNg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- <link rel="stylesheet" href="./assets/fonts/themify-icons-font/themify-icons/themify-icons.css"> -->
</head>
<body>
<%@include file="header.jsp" %>
<div id="content">
	<form action="updateUser" method="post"  enctype="multipart/form-data" >
	   <div class=" account mt-32">
	       <div class="row PersonalIn4">
	           <div class="col-sm-3 mt-16">
	               <div class="personal-img">
	                   <img src="images/${mem.getFileName()}" class="card-img-top" alt="..." style="width: 8.25rem;">
	                   <input type="file" name="image">
	                   ${mem.getFileName()}
	               </div>	
	           </div>
	           <div class="col-sm-9 mt-16">
	               <div class="form-floating mb-2">
	                   <input name="username" type="text" class="form-control" id="floatingInput" placeholder=""  value="${mem.getUsername()}">
	                   <label for="floatingInput">Username</label>
	               </div>
	               <div class="form-floating mb-2">
	                   <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" value="${mem.getEmail()}">
	                   <label for="floatingInput">Email address</label>
	               </div>
	               <div class="form-floating mb-2">
	                   <input name="fullname" type="text" class="form-control" id="floatingInput" placeholder="" value="${mem.getFullname()}">
	                   <label for="floatingInput">Full name</label>
	               </div>
	               <div class="form-floating mb-2">
	                   <input name="birthdate" type="date" class="form-control" id="floatingInput" placeholder="" value="${mem.getBirthdate()}">
	                   <label for="floatingInput">Birthdate</label>
	               </div>
	               <div class="form-floating mb-2">
	                   <input name="phonenumber" type="text" class="form-control" id="floatingPassword" placeholder="" value="${mem.getPhoneNumber()}">
	                   <label for="floatingPassword">Phone number</label>
	               </div>
	               <div class="form-floating">
	                   <input name="homeaddress" type="text" class="form-control" id="floatingPassword" placeholder="" value="${mem.getHomeAddress()}">
	                    <label for="floatingPassword">Home address</label>
	                </div>
	            </div>
	        </div>
	        <div class="row change-pass">
	            <div class="mb-1 mt-8">
	                <label for="inputOldpass" class="form-label">Old Password</label>
	                <input name="oldpass" required type="password" class="form-control" id="inputOldpass" required>
	            </div>
	            <div class="mb-1">
	                <label for="inputNewpass" class="form-label">New Password</label>
	                <input name="newpass" type="password" class="form-control" id="inputNewpass">
	            </div>
	            <div class="mb-1">
	                <label for="inputConfirmpass" class="form-label">Confirm new password</label>
	                <input name="newpasscf" type="password" class="form-control" id="inputConfirmpass">
	            </div>
	            <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-16 ">
	                <!-- <button class="btn btn-primary me-md-2 btn-change" type="button">Confirm password</button> -->
	                <button class="btn btn-primary btn-update" type="submit">Update account</button>
	            </div>
	        </div>
	    </div>
	</form>
</div>	
  <%@include file="footer.jsp" %>
</body>
</html>