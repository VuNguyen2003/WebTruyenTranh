<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Resource/css/style.css">
<link rel="icon" href="https://flyclipart.com/favicon.png" type="image/x-icon/png" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css" integrity="sha512-IJEbgDEF7OeKJRa0MY2PApnyJHRIsgzCveek4ec8VWQ+7KG3ZSKVNYa5xP/Gh0hVP0Mwb+gBsk+GwR3JQGhQNg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="./assets/fonts/themify-icons-font/themify-icons/themify-icons.css">
</head>
<script>
	// Hàm này sẽ được gọi khi người dùng nhấn vào button Tìm kiếm
	function getCheckboxValue() {
		// Lấy đối tượng form
		var form = document.getElementById("myForm");
		// Lấy danh sách các checkbox trong form
		var checkboxes = form.getElementsByTagName("tags");
		// Lặp qua các checkbox và kiểm tra xem có checkbox nào được chọn không
		var checked = false;
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].type == "checkbox" && checkboxes[i].checked) {
				checked = true;
				break;
			}
		}
		// Nếu có checkbox được chọn, thì gửi form đến trang xuly.jsp
		if (checked) {
			form.action = "advancesearch";
			form.submit();
		} else {
		// Nếu không có checkbox nào được chọn, thì hiển thị thông báo
		alert("Bạn phải chọn ít nhất một checkbox!");
		}
		
	}
	
</script>
<body>
<%@include file="header.jsp" %>
		<div id="content">
			
            <div class="container">
                <div class="show">
                    <h1 class="cate-title mt-16">
                        THỂ LOẠI
                    </h1>
                    <form action="advancesearch" method="get">
	                    <div id="myForm" class="clearfix  mt-16 row">
	                        <c:forEach var="i" items ="${listtag}" >
		                        <div class="col-3">
		                        	<a href="viewintro?id=${i.getStoryId()}">
		                            <div class="form-check">
		                                <input class="form-check-input" type="checkbox" name="tags" value="${i.tagId}" id="flexCheckDefault">
		                                <label class="form-check-label" for="flexCheckDefault">
		                                  ${i.tagName}
		                                </label>
		                            </div>
		                            </a>
		                        </div>
	                        </c:forEach>    
	                    </div>
	                    <div class="form-group clearfix mt-32">
	                        <div class="col-sm-4 col-sm-offset-2">
	                            <button type="submit" class="btn btn-outline-success search-cate">Tìm kiếm</button>
	                        </div>
	                    </div>
                    </form>
                </div>
            </div>
            
        </div>
        <%@include file="footer.jsp" %>
</body>
</html>