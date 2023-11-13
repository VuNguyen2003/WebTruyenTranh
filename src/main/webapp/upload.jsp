<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<%@include file="header.jsp" %>
<div id="content">
            <div class="row mt-32 upload">
                <div class="col-4">
                    <div class="card upload-img ">
                        <img src="Resource/img/images/img-onepiece.jpg" class="card-img-top" alt="...">
                    </div>
                </div>
                <form action="#" method="post" enctype="multipart/form-data">
                <div class="col-8">
                    <div class="mb-1 align-items-center row ">
                        <div class="col-3">
                            <label for="inputStoryname" class="intro-sn col-form-label">Tên truyện</label>
                        </div>
                        <div class="col-9 col-sm-9">
                          <input name="name_story" type="text" class="form-control" id="inputStoryname">
                        </div>
                    </div>
                    <div class=" mb-1 align-items-center row">
                        <div class="col-3">
                            <label for="inputAuthor" class="col-form-label">Tác giả</label>
                        </div>
                        <div class="col-9 col-sm-9">
                            <input name="author" type="text" class="form-control" id="inputAuthor">
                        </div>
                    </div>
                    <div class="mb-1">
                        <label for="inputTag" class="form-label">Tag</label>
                        <input name="tag_name" type="text" class="form-control" id="inputTag" placeholder="Action - Fantasy - Manhua - Shounen">
                    </div>
                    <div class="mb-1">
                        <p>Nội dung</p>
                        <textarea class="form-control mt-8" id="exampleFormControlTextarea1" rows="5"></textarea>
                    </div>
                </div>
                </form>
            </div>
            <div class="upload-chapter">
                <div class="list-chapter" id="nt_listchapter">
                    <h2 class="list-title clearfix mt-16">
                        <i class="fa-solid fa-list"></i>
                        Danh sách chương
                    </h2>
                    <div class="row heading">
                        <a class="col-4 no-wrap" href="upload-chapter.html">
                            <i class="fa-solid fa-plus"></i>
                            Thêm chương</a>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
</body>
</html>