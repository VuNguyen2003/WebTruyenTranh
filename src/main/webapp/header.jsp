<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
	<div id="main">
            <div class="header-top">
                <div class="header-container">
                    <div class="header-logo">
                        <img src="Resource/img/Icon.png" alt="" class="header-logo-image">
                        <a href="home" class="header-logo-content">ANIMEWORLD</a>
                    </div>
                    <% 
                    HttpSession s = request.getSession();
                    Object user = s.getAttribute("mem");
                    Object msg = s.getAttribute("msg");
                    if (msg != null){ %>
	                    <ul class="header-account">
	                        <li class="account-item">
	                            <a class="mr-3" href= "per-info.jsp"><i class="fa-regular fa-id-card"></i>${ mem.getUsername()}</i></a>
	                        </li>
	                        <li class="account-item">
	                            <a id="Sign-up" class="account-item-link" href="logout">Log out</a>
	                        </li>
	                    </ul>
	                 <%} else { %>
	                 	<ul class="header-account">
	                        <li class="account-item">
	                            <a id="Login" class="account-item-link" href="login.jsp">Login</a>
	                        </li>
	                        <li class="account-item">
	                            <a id="Sign-up" class="account-item-link" href="signup.jsp">Sign up</a>
	                        </li>
	                    </ul>	                                	
	                 <%} %>
                </div>
            </div>
            <div id="header-bot">
                <div id="menu">
                    <div class="menu-left">
                        <li>
                            <a href="#">
                                GENRES
                                <i class="fa-solid fa-angle-down angle-icon"></i>
                            </a>
                            <ul class="sub-menu">
                                <li><a href="category">CATEGORY</a></li>
                                <li><a href="hastagsearch">ADVANCE SEARCH</a></li>
                                <li><a href="favorite">FAVORITE</a></li>
                            </ul>
                        </li>
                        <%-- <% if (user != null) { %>
						    <li><a href="upload.jsp">UPLOAD</a></li>
						<% } else { %>
						    <li><a href="login.jsp">UPLOAD</a></li>
						<% } %> --%>
						<li><a href="upload.jsp">UPLOAD</a></li>
                        <li><a href="Policy.html">POLICY</a></li>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="per-info.html">SETTING</a></li>
                    </div>
                    <div class="menu-right">
                        <form action="search" class="search-btn">
                            <i class="fa-sharp fa-regular fa-bell"></i>
                            <input type="text" name="id" placeholder="Search comics/authors">
                            <button class="fa-solid fa-magnifying-glass" onclick="submitForm()"></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<script>
	    // hàm để submit form khi click vào button
	    function submitForm() {
	      document.forms[0].submit();
	    }
  	</script>
</body>
</html>