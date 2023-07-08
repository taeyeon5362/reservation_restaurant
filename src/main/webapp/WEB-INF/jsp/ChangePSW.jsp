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
<title>비밀번호 재설정</title>

<link rel="canonical"href="https://getbootstrap.com/docs/5.0/examples/checkout/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">

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

<link href="../../resources/css/form-validation.css" rel="stylesheet">
<script>function FindConfirm(m){confirm(m)}; </script>
</head>
<body class="bg-white">
	<div class="container">
		<main>
			<div class="row g-3" style="padding-top: 40px;">
				<div class="col-sm-6 center-block"
					style="float: none; margin: 0 auto;">
					<h4 class="py-1 text-center">아이디 찾기</h4>
					<form action="/customers/changePSW" method="POST" id="passwordForm">
                        <div class="newPSW">
                            <label for="password">새로운 비밀번호</label>
                            <input type="password" name="newPSW" id="password">
                        </div>
                        <div class="confirmPSW">
                            <label for="confirm">비밀번호 확인</label>
                            <input type="password" id="confirm">
                            <button onclick="confirm()">변경</button>
                        </div>
                    </form>
				</div>
			</div>
		</main>
        <script>
            
            
            function confirm(){
                var password = document.getElementById("password").textContent;
                var confirmpassword = document.getElementById("confirm");   
                if(password===confirmpassword){
                    console.log(password);
                    console.log(confirmpassword);
                    document.getElementById("passwordForm").submit();
                } else{
                    alert("안맞잖아");
                }
            }
        </script>
	</div>
</body>
</html>