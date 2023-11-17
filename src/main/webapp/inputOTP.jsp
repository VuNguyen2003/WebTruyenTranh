<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="preconnect" href="https://fonts.googleapis.com"> -->
    <title>Đọc truyện tranh online</title>
    <link rel="stylesheet" href="Resource/css/style.css">
    <link rel="icon" href="https://flyclipart.com/favicon.png" type="image/x-icon/png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css"integrity="sha512-IJEbgDEF7OeKJRa0MY2PApnyJHRIsgzCveek4ec8VWQ+7KG3ZSKVNYa5xP/Gh0hVP0Mwb+gBsk+GwR3JQGhQNg=="crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./assets/fonts/themify-icons-font/themify-icons/themify-icons.css">
</head>

<body>
    <%@include file="header.jsp" %>
     <!-- End: header -->
     <div class="padding-top-login-form">
         <!-- Begin: padding-top-login-form -->

     </div>
     <!-- End: padding-top-login-form -->
     <div class="login rounded">
         <!-- Begin: login -->
         
         <form action="inputOTP" method="post" class="login-form">
             <!-- Begin-login-form -->
             <h2 class="login-title">
                 Nhập OTP
             </h2>
             <% if(request.getSession().getAttribute("warning")!=null){ %>
             	<div>Mã OTP không đúng</div>
             <%}
             	
             %>
             <label class="form-Username " for="Username">OTP</label>
             <input name="otpcf" type="text" class="form-control mt-8" placeholder="Nhập mã OTP">
             
             <div class="login-button text-center">
                 <!-- Begin-login-button -->
                 <button type="submit" class="btn btn-primary">Submit</button>
             </div>
             <!-- End-login-button -->
         </form>
         <!-- End-login-form -->
         
         
     </div>
     <!-- End: login-->
        
        
        <%@include file="footer.jsp" %>
        
</body>
</html>