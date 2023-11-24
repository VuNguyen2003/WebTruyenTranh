<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.text.*" %>
<%@ page import = "javax.servlet.http.*"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "DAO.*"%>
<%@ page import = "DTO.*"%>
<%@ page import = "java.awt.event.ActionEvent"%>
<%@ page import = "java.awt.event.ActionListener"%>
<%@ page import = "javax.swing.JButton"%>
<%@ page import = "javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        <!-- End: header -->

        <div id="content">
            <div class="row mt-32 intro">
                <div class="col-4 intro-img">
                    <div class="card upload-img ">
                        <img src="${listStory.getCover()}" class="card-img-top" alt="...">
                    </div>
                </div>
                <div class="col-8 info">
                    <div class="mb-1 align-items-center row ">
                        <div class="col-3">
                            <label for="inputStoryname" class="intro-sn col-form-label">Tên truyện</label>
                        </div>
                        <div class="col-9 col-sm-9">
                          <input type="text" class="form-control" id="inputStoryname" value = "${listStory.getTitle()}" disabled>
                        </div>
                    </div>
                    <div class=" mb-1 align-items-center row">
                        <div class="col-3">
                            <label for="inputAuthor" class="col-form-label">Tác giả</label>
                        </div>
                        <div class="col-9 col-sm-9">
                            <input type="text" class="form-control" id="inputAuthor" value = "${listStory.getAuthor()}" disabled>
                        </div>
                    </div>
                    <div class="mb-1">
                        <label for="inputTag" class="form-label">Tag</label>
                        <input type="text" class="form-control" id="inputTag" placeholder="${tags}" disabled>
                    </div>
                    <div class="row g-2 align-items-center">
                        <div class="col-3">
                            <label for="inputPassword6" class="col-form-label">Tình trạng</label>
                        </div>
                        <div class="col-9">
                            <p> ${listStory.getStatus()}</p>
                        </div>
                    </div>
                    
                    <div class="rating-box">
                        <div class="stars">
                            <div class="col-6 five-stars">
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                                <i class="fa-solid fa-star"></i>
                            </div>
                            <form action="favorite" method="post" class="col-6 btn-next-star">
                                <input name="id" value="${listStory.getStoryId()}" style="display:none">
                                   <input name="userId" value="${mem.getUserID()}" style="display:none">
                                <button type="submit" class="btn btn-primary btn-sm btn-fav">Yêu thích</button>
                            </form>
                            
                        </div>
                    </div>
                    <div class="btn-read mt-16">
                        <a class="btn btn-warning" href="readstory?ID=${listStory.getStoryId()}">Đọc từ đầu</a>
                    </div>
                </div>
            </div>

            <div class="all-detail-content">
                <div class="detail-content">
                    <h3 class="list-title">
                        <i class="fa-regular fa-file-lines"></i>
                        Nội dung
                    </h3>
                    <p>
                        ${listStory.getSummary()}
                    </p>
                    <a class="morelink less" href="#">
                        <i class="fa-solid fa-angle-left"></i>
                        Thu gọn
                    </a>
                </div>
                <div class="list-chapter" id="nt_listchapter">
                    <h2 class="list-title clearfix mt-16">
                        <i class="fa-solid fa-list"></i>
                        Danh sách chương
                    </h2>
                    <div class="row heading">
                        <div class="col text-center no-wrap">Số chương</div>
                        
                    </div>
                    <c:forEach var="i" items="${listChapter}">
                    <nav>
                        <ul>
                            <li class="row">
                                <div class="col no-wrap text-center chapter-list">
                                    <a href="readstory?ID=${i.getStoryId()}&index=${i.getChapterNumber()}">
                                        Chapter ${i.getChapterNumber()}
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </nav>
                    </c:forEach>
                </div>
                <div class="tab-content mt-16">
                    <div id="aw_comments" class="tab-pane  in active">
                    <form action="comment" method="post">
                        <div class="comment-wrapper">
                            <div class="form-floating">
                                <textarea name="comment" class="form-control" placeholder="Leave a comment here" id="floatingTextarea" style="height: 70px"></textarea>
                                <label for="floatingTextarea">Mời các bạn thảo luận, vui lòng không spam</label>
                            </div>
                            <div class="btn-send-cmt row mt-8">
                                <div class="col-12">
                                    <button type="submit" class="btn btn-primary send-btn pull-right">Gửi</button>
                                </div>
                            </div>
                            <input name="strId" value = "${listStory.getStoryId()}" style="display:none">
                            <%commentDAO cdao = new commentDAO();
                            ArrayList<Comment> cmts = cdao.listComments();
                            %>
                            <c:forEach var="cmt" items="<%=cmts%>" end="9">
        						<div class="comment-list">
                                <div class="item ">
                                    <div class="summary">
                                        <i class="fa-solid fa-angle-left fa-arrow"></i>
                                        <div class="info">
                                            <div class="comment-header">
                                                <span class="authorname">${cmt.getUsername()}</span>
                                            </div>
                                            <div class="comment-content">
                                                ${cmt.getComment()}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
    						</c:forEach>
                        </div>
                    </form>
                    </div>
                </div>
            </div>
        </div>
		
        <%@include file="footer.jsp" %>
    <script src="Resource/js/script.js"></script>s
    <script>
	  var myButton = document.getElementById("myButton");
	  myButton.addEventListener("click", function() {
	    alert("Bạn đã nhấp vào nút Yêu thích!");
	  });
	</script>
    
</body>
</html>