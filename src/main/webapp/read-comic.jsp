<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Giới thiệu truyện</title>
        <link rel="stylesheet" href="Resource/css/style.css">
        <link rel="icon" href="https://flyclipart.com/favicon.png" type="image/x-icon/png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css" integrity="sha512-IJEbgDEF7OeKJRa0MY2PApnyJHRIsgzCveek4ec8VWQ+7KG3ZSKVNYa5xP/Gh0hVP0Mwb+gBsk+GwR3JQGhQNg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link rel="stylesheet" href="./assets/fonts/themify-icons-font/themify-icons/themify-icons.css">
</head>
<body>
<%@include file="header.jsp" %>
<div id="content">
            <div class="container">
                <div class="row">
                    <div id="ct100_divCenter" class="ful-width col-sm-12">
                        <div class="reading">
                            <div class="head-reading">
                                <div class="alert alert-info mrb-8 hidden-xs hidden-sm">
                                    <i class="fa-solid fa-circle-info fa-beat"></i>
                                    <em>Sử dụng mũi tên trái (←) hoặc phải (→) để chuyển chapter</em>
                                </div>
                                <div class="chapter-nav" id="chapterNav" style="z-index: auto; position: static; top: auto;">
                                    <a class="home" href="index.html" title="Trang chủ">
                                        <i class="fa-solid fa-home"></i>
                                    </a>
                                    <a class="home backward" href="intro-comic.html" title="Đảo Hải Tặc">
                                        <i class="fa-solid fa-list"></i>
                                    </a>
                                    <a href="#" class="prev a_prev">
                                        <i class="fa-solid fa-chevron-left"></i>
                                    </a>
                                    <select name="ct100$mainContent$ddlSelectChapter" id="ct100_mainContent_ddlSelectChapter" class="select-chapter">
                                        <option value="">Chapter 1</option>
                                        <option value="">Chapter 2</option>
                                        <option value="">Chapter 3</option>
                                    </select>
                                    <a href="#" class="next a_next">
                                        <i class="fa-solid fa-chevron-right"></i>
                                    </a>
                                    
                                </div>
                            </div>
                            <div class="reading-detail box_doc mt-16">
                            	<c:forEach var="i" items ="${pageList}" >
	                                <div class="page-chapter" id="page_1">
	                                    <img src="${i.getPageContent()}" alt="Đảo Hải Tặc chap 1045 - Trang 1" data-index = "1">
	                                </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@include file="footer.jsp" %>
</body>
</html>