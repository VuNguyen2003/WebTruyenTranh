<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
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
    <!--Owl carousel css & js-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
    <link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div id="new-comics">
		<div class="comic-grid col-md-12 mx-auto">
			<div class="row">
				<c:forEach var="i" items ="${listStory}" >
					<div class="grid-item col-3">
						<div class="caption">
							<a href="viewintro?id=${i.getStoryId()}">
							<img src="${i.cover}" alt="">
							<div class="caption-content">
								<h3>${i.title}</h3>
								<p>favorite: ${i.getFavorite()}</p>
							</div>
							</a>
						</div>
					</div>   
				</c:forEach>
			</div>
		</div>
	</div>
		<ul class="pagination mt-32">
                <li class="pagination-item">
                    <a href="advancesearch?index=${indexPage > 1?indexPage-1:"1"}&${tags}" class="pagination-item_link">
                        <i class="pagination-item_icon fa-solid fa-angle-left"></i>
                    </a>
                </li>
                <c:forEach var="i" begin="1" end="${endPage}">
	                <li class="pagination-item ${indexPage == i?"pagination-item--active":" "}">
	                    <a href="advancesearch?index=${i}&${tags}" class="pagination-item_link">${i}</a>
	                </li>
               	</c:forEach>

                <li class="pagination-item">
                    <a href="advancesearch?index=${indexPage + 1 > endPage ? indexPage : indexPage + 1}&${tags}" class="pagination-item_link">
                        <i class="pagination-item_icon fa-solid fa-angle-right"></i>
                    </a>
                </li>
         </ul>
	
	
	<%@include file="footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
    <!-- owlcarousel.js to run carousel -->
    <script src="Resource/js/owlcarousel.js"></script>
</body>
</html>