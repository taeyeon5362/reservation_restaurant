<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>테이블 설정</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../../resources/js/tableCreater.js"></script>

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

#submit{
	background-color: white;
	font-size: large;
	border-radius: 10%;
}

.remove{
	background-color: white;
	font-size: large;
	border-radius: 10%;
}

.remove
</style>
</head>

<div class="py-5 text-center" style="user-select: auto;">
	<img class="d-block mx-auto mb-4"
		src="../../resources/image/Option.png" alt="" width="100" height="125"
		style="user-select: auto;">
	<h2 style="user-select: auto;">테이블 설정</h2>
</div>
<body class="bg-light">
	<div class="container" style="user-select: auto;" id="login_wrapper">
		<main style="user-select: auto;">
			<div class="col-md-7 col-lg-8" style="user-select: auto;">
				<h4 class="mb-3" style="user-select: auto;">
					Table 
				</h4>
				<div class="addResv"></div>
				<span style="margin-left: 520px"> <input
					class="btn btn-info btn-default btn-sm" id="addForm" type="button"
					value="테이블 추가">
				</span>
				<button id="submit" style="margin-left: 520px; margin-top: 10px;">적용</button>
			</div>
		</main>
	</div>

	<%@ include file="Footer.jsp"%>

	<script src="../../resources/js/form-validation.js" style="user-select: auto;"></script>
	<div class="liner-scroll-points-container" style="user-select: auto;"></div>
</body>
</html>