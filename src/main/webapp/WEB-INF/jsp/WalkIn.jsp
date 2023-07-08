<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>워크인 등록</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/carousel/">

<!-- Bootstrap core CSS -->
<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Favicons -->
<%@ include file="NAVbar.jsp"%>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

#login_wrapper {
	width: 100%;
	max-width: 1500px;
	padding-left: 380px;
	margin: auto;
}
</style>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<link
	href="${pageContext.servletContext.contextPath}/resources/jquery/jquery-ui.css?version=1.3"
	rel="stylesheet" type="text/css" media="screen">
<script
	src="${pageContext.servletContext.contextPath}/resources/js//jquery-1.8.3.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/jquery/jquery-ui.js?version=1.3"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<script src="../../resources/js/walkIn.js"></script>
</head>

<div class="py-5 text-center" style="user-select: auto;">
	<img class="d-block mx-auto mb-4"
		src="../../resources/image/Reservation2.jpg" alt="" width="800" height="400"
		style="user-select: auto;">
	<h2 style="user-select: auto;">워크인 등록</h2>
</div>
<body class="bg-light">
	<div class="container" style="user-select: auto;" id="login_wrapper">
		<main style="user-select: auto;">
			<div class="col-md-7 col-lg-8" style="user-select: auto;">
				<h4 style="user-select: auto;">인원 선택
                	<span style="margin-left: 455px">
                		<input class="btn btn-success btn-default btn-sm" type="button" onclick="add_People()" value="테이블 +" st>
                		<input class="btn btn-danger btn-default btn-sm" type="button" onclick="remove_People(this)" value="테이블 -">
                	</span>
                </h4>
					<div id="addPeople" style="user-select: auto;">
						<div class="row g-3" style="padding-top:10px; user-select: auto;">
							<div class="col-md-5" style="user-select: auto;">
								<label for="numberOfPeople" class="form-label" style="padding-left: 3px; user-select: auto;">인원 수</label> <select
									class="form-select" name="numberOfPeople" id="numberOfPeople"
									required="" style="user-select: auto;">
									<option value="" style="user-select: auto;">선택</option>
									<option style="user-select: auto;">1</option>
									<option style="user-select: auto;">2</option>
									<option style="user-select: auto;">3</option>
									<option style="user-select: auto;">4</option>
								</select>
								<div class="invalid-feedback" style="user-select: auto;"></div>
							</div>
						</div>
					</div>
					<div id="addResv"></div>
					<script type="text/javascript">
                    		function add_People(){
                                var div = document.createElement('div');
                                div.innerHTML = document.getElementById('addPeople').innerHTML;
                                document.getElementById('addResv').appendChild(div);
                            }
                            function remove_People(){
                                const div = document.getElementById('addResv');
                                $("#addResv *").remove();
                            }
                    </script>
					<button class="my-4 w-100 btn btn-warning btn-primary btn-lg" style="user-select: auto;" id="chooseTable">테이블 선택</button>
                    <div class="tableSelect">
                    	<div class="tableImage"></div>
                    	<div class="tableSelector"></div>
                    </div>
			</div>
		</main>
	</div>

	<%@ include file="Footer.jsp"%>

	<script src="form-validation.js" style="user-select: auto;"></script>
	<div class="liner-scroll-points-container" style="user-select: auto;"></div>
</body>
</html>