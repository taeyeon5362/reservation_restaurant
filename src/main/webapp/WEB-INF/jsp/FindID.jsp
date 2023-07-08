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
<title>아이디 찾기</title>

<link rel="canonical"href="https://getbootstrap.com/docs/5.0/examples/checkout/">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

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

<link href=".\css\form-validation.css" rel="stylesheet">
<script>function FindConfirm(m){confirm(m)}; </script>
</head>
<body class="bg-white">
	<div class="container">
		<main>
			<div class="row g-3" style="padding-top: 40px;">
				<div class="col-sm-6 center-block"
					style="float: none; margin: 0 auto;">
					<h4 class="py-1 text-center">아이디 찾기</h4>
					<form action="/customers/findID" method="POST">
						<div class="row g-3">
							<div class="col-sm-12">
								<label for="NAME" class="form-label">이름</label> <input
									type="text" class="form-control" id="findName" name="findName"
									placeholder="이름" value="" required>
								<div class="invalid-feedback">이름을 입력해주세요.</div>

							</div>
							<div>
								<div class=row style="margin-bottom: 2rem;">
									<label for="PHONE" class="form-Label">휴대전화</label>
									<div class="col-4">
										<select class="form-select" id="findPhone_1"
											name="findPhone_1" required>
											<option value="">선택</option>
											<option>010</option>
											<option>011</option>
											<option>016</option>
											<option>017</option>
											<option>018</option>
											<option>019</option>
										</select>
										<div class="invalid-feedback">번호가 올바르지 않습니다.</div>
									</div>
									<div class="col-md-4">
										<input type="text" class="form-control" id="findPhone_2"
											name="findPhone_2" placeholder="" required>
										<div class="invalid-feedback">번호가 올바르지 않습니다.</div>
									</div>
									<div class="col-md-4">
										<input type="text" class="form-control" id="findPhone_3"
											name="findPhone_3" placeholder="" required>
										<div class="invalid-feedback">번호가 올바르지 않습니다.</div>
									</div>
								</div>
							</div>
						</div>
						<div id="target">
                            
                        </div>
						<button class="w-100 btn btn-warning btn-lg btn-success"
							style="margin-bottom: 10px;" type="submit">아이디 찾기</button>
						<script>
							var customerID = "${cid}";
							console.log(customerID);
							const element = document.getElementById("target")
							if (customerID != ""){
								element.innerHTML = "<p>찾으시는 ID는 "+customerID+"입니다.</p>";
							} else if(customerID=="0"){
								alert('입력된 정보로 가입된 회원이 존재하지 않습니다.');
							}
						</script>
						<%@ include file="Footer.jsp"%>
					</form>
				</div>
			</div>
		</main>
	</div>
</body>
</html>