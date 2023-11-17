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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%@include file="header.jsp" %>
<div class="padding-top-login-form">
                <!-- Begin: RE-USE padding-top-login-form -->

            </div>
            <!-- End: RE-USE padding-top-login-form -->
            <div class="sign-up rounded">
                <!-- Begin: sign-up -->
                <form action="signup" method="post" class="sign-up-form">
                    <h2 class="sign-up-title">
                        Đăng kí
                    </h2>
                    <%
                    if(request.getAttribute("msg")!=null){
                    String m = request.getAttribute("msg").toString();
                    if(m.equals("fail")){ %>
	             	<div class="alert alert-danger">
					    <strong>Mật khẩu xác nhận không khớp!</strong> Vui lòng nhập lại.
					</div>
	             	<%}
                    else if(m.equals("success")){ %>
                    <div class="alert alert-success">
					    <strong>Chúc mừng!</strong> Bạn đã đăng ký thành công <3
					</div>
					<%}} %>
	             	
                    <label class="form-Username mt-16" for="Username">Tài khoản</label>
                    <input name="username" type="text" class="form-control mt-8" id="Username" required>
                    <label class="form-E-mail mt-16" for="E-mail">E-mail</label>
                    <input name="email" type="email" class="form-control mt-8" id="E-mail" required>
                    <label class="form-Password mt-16" for="Password">Mật khẩu</label>
                    <input name="password" type="password" class="form-control mt-8" id="Password" required>
                    <label class="form-Re-enter-password mt-16" for="Re-enter-password">Nhập lại mật khẩu</label>
                    <input name="password-confirm" type="password" class="form-control mt-8" id="Re-enter-password" required>
                    <div class="sign-up-button text-center">
                        <!-- Begin-sign-up-button -->
                        <button type="submit" class="btn btn-primary">Đăng kí</button>
                    </div>
                    <!-- End-login-button -->
                </form>
            </div>
            <!-- End: sign-up -->
<%@include file="footer.jsp" %>
	
</body>
</html>