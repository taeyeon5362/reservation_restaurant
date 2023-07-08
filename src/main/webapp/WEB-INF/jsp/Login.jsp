<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>로그인</title>


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
</style>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/carousel/">
<!-- Custom styles for this template -->
<link href="../../resources/css/signin.css" rel="stylesheet">
</head>


<body class="bg-white" style="padding-top: 90px;">

	<main class="text-center form-signin">
		<form action="/customers/login" method="POST">
			<img class="mb-4" src="../../resources/image/restaurant.jpg" alt="" width="520"
				height="374">

			<div>

				<div style="margin-bottom: 10px;">
					<label for="userID" class="visually-hidden">아이디</label> <input
						type="text" id="userID" name="userID"
						class="form-control input-lg" placeholder="아이디" required autofocus>
				</div>

				<div style="margin-bottom: 10px;">
					<label for="userPW" class="visually-hidden">비밀번호</label> <input
						type="password" id="userPW" name="userPW"
						class="form-control input-lg" placeholder="비밀번호" required>
				</div>
			</div>

			<button class="w-100 btn btn-warning btn-success"
				style= "padding: 20px;" type="submit">로그인 </button>

			<script type="text/javascript">
                        function FindID(){
                            window.open("<%= request.getContextPath() %>/customers/findID", "id", "width=768, height=470")
                        }
                        function FindPW(){
                            window.open("<%= request.getContextPath() %>/customers/findPW", "pw", "width=768, height=525")
                        }
            </script>

			<ul class="list-inline" style= "padding: 20px;">
				<li class="list-inline-item"><a href="javascript:FindID()"
					style="text-decoration: none; color: #0078FF">아이디 찾기</a></li>
				<li class="list-inline-item"><a href="javascript:FindPW()"
					style="text-decoration: none; color: #0078FF">비밀번호 찾기</a></li>
				<li class="list-inline-item"><a href="/customers/new"
					style="text-decoration: none; color: #0078FF">회원가입</a></li>
			</ul>

			<%@ include file="Footer.jsp"%>

		</form>

	</main>

</body>

</html>