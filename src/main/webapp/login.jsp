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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
         
         <form action="login" method="post" class="login-form">
             <!-- Begin-login-form -->
             <h2 class="login-title">
                 Đăng nhập
             </h2>
             <% if(request.getSession().getAttribute("invalid")!=null){ %>
             	<div class="alert alert-danger">
				    <strong>Tài khoản không tồn tại!</strong> Vui lòng nhập lại.
				</div>
             <%} System.out.print(request.getSession().getAttribute("invalid")); %>
             
             <label class="form-Username " for="Username">Tài khoản</label>
             <input name="username" type="text" class="form-control mt-8" id="Username" required>
             <label class="form-Password mt-16" for="Password">Mật khẩu</label>
             <input name="password" type="password" class="form-control mt-8" id="Password" required>
             <div class="login-help mt-16">
                 <a href="forgotPassword.jsp">Quên mật khẩu</a> /
                 <a href="signup.jsp">Đăng kí</a>
             </div>
             <div class="login-button text-center">
                 <!-- Begin-login-button -->
                 <button type="submit" class="btn btn-primary">Đăng nhập</button>
             </div>
             <!-- End-login-button -->
         </form>
         <!-- End-login-form -->
         
         
     </div>
     <!-- End: login-->
        
        
        <%@include file="footer.jsp" %>
        
</body>
</html>