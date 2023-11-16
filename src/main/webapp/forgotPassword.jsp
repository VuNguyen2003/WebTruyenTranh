<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="preconnect" href="https://fonts.googleapis.com"> -->
    <title>Đọc truyện tranh online</title>
    <link rel="stylesheet" href="Resource/css/style.css">
    <link rel="icon" href="https://flyclipart.com/favicon.png" type="image/x-icon/png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css" integrity="sha512-IJEbgDEF7OeKJRa0MY2PApnyJHRIsgzCveek4ec8VWQ+7KG3ZSKVNYa5xP/Gh0hVP0Mwb+gBsk+GwR3JQGhQNg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./assets/fonts/themify-icons-font/themify-icons/themify-icons.css">
    <script src="script.js" defer></script>
</head>
<body>

<%@include file="header.jsp" %>
<div class="padding-top-login-form">
<!-- Begin: RE-USE padding-top-login-form -->
</div>
<!-- End: RE-USE padding-top-login-form -->
<div class="forgotPassword rounded">
    <!-- Begin: sign-up -->
    <h2 class="forgotPassword-title">
        Quên mật khẩu ?
    </h2>
    <div class="guid-container">
    	<img class="guid-img" src="https://cdn4.iconfinder.com/data/icons/business-vol-4-2/100/Artboard_15-4096.png">
	    <div class="guid-paragraph">
	    <p class="mb-2">Thực hiện các bước sau để thay đổi mật khẩu</p>
	    <ol>
	    	<li>1. Nhập email vào bên dưới</li>
	    	<li>2. Hệ thống sẽ gửi mã OTP đến email của bạn </li>
	    	<li>3. Nhập mã OTP ở trang kế tiếp</li>
	    </ol>
	    </div>
	</div>
    <form action="forgotPassword" method="post" class="forgotPassword-form">
       	<input name="email" type="email" placeholder="Vui lòng nhập email" class="email-input" required></input>
        <button type="submit" class="btn-sendotp"><i class="fa-solid fa-paper-plane"></i></button>
    </form>
</div>
<!-- End: sign-up -->
<%@include file="footer.jsp" %>
	
</body>
</html>