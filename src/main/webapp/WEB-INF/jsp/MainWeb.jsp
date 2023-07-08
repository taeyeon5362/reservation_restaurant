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
<title>메인 페이지</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/">

<!-- Bootstrap core CSS -->
<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Favicons -->
<%@ include file="NAVbar.jsp"%>

<style>
body{
    background-image : url("../../resources/image/Background.png");
    background-repeat : no-repeat;
    background-size : cover;
}
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

<link href="../../resources/css/carousel.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>

<body>
	<main>
		<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
			<ol class="carousel-indicators">
				<li data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"></li>
				<li data-bs-target="#myCarousel" data-bs-slide-to="1"></li>
				<li data-bs-target="#myCarousel" data-bs-slide-to="2"></li>
			</ol>

			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../../resources/image/food.jpg" style="margin-top: 2rem;">
					<div class="container">
						<div class="carousel-caption text-start" style="margin-bottom: -2rem;">
							<h1 style="color:">Restaurant</h1>
							<p>저희 레스토랑에 오신 것을 환영합니다.</p>
						</div>
					</div>
				</div>

				<div class="carousel-item">
					<img src="../../resources/image/food4.jpg" style="margin-top: 2rem;">
					<div class="container">
						<div class="carousel-caption" style="margin-bottom: -2rem; user-select: auto;">
                             <h1 style="user-select: auto;">Restaurant</h1>
                             <p style="user-select: auto;">항상 신선한 식재료로 대접합니다.</p>
                        </div>
					</div>
				</div>

				<div class="carousel-item">
					<img src="../../resources/image/food5.jpg" style="margin-top: 2rem;">
					<div class="container">
						<div class="carousel-caption text-end" style="margin-bottom: -2rem;">
							<h1>Restaurant</h1>
							<p>최고의 맛으로 최고의 서비스를 제공합니다.</p>
						</div>
					</div>
				</div>
			</div>

			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-bs-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-bs-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="visually-hidden">Next</span>
			</a>
		</div>

		<div class="container marketing">
		<script>
        var bgm = new Audio('');
        	var bgm_url = "../../resources/image/music2.mp3";
        	bgm = new Audio(bgm_url);
        	bgm.volume = 0.2;
        	bgm.play();
        </script>
			<div class="row featurette" style="user-select: auto;">
				<div class="col-md-7" style="user-select: auto;">
					<h2 class="featurette-heading" style="user-select: auto;"> 오시는 길</h2>
					<p class="lead" style="padding-top:50px; user-select: auto;">지도와 주소를 오시는 길 찾기 편하시도록 표기 해두었습니다.</p>
				</div>
				<div class="col-md-5" style="cursor: pointer; user-select: auto;" onclick="location.href='/Route'">
                	<img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
                	src="../../resources/image/map2.png" alt="" width="500" height="500">
                </div>
			</div>
			<div class="row featurette" style="user-select: auto;">
				<div class="col-md-7 order-md-2" style="user-select: auto;">
					<h2 class="featurette-heading" style="margin-left:50px; user-select: auto;">인기 메뉴
					<span class="text-muted" style="user-select: auto;">★Hot★</span>
					</h2>
					<p class="lead" style="padding-top:50px; margin-left:50px; user-select: auto;">고객님들께 한주간 인기 있었던 메뉴들을 소개합니다.</p>
				</div>
				<div class="col-md-5 order-md-1" style="cursor: pointer; user-select: auto;" onclick="location.href='/Menu'">
				    <img  class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
                        src="../../resources/image/BestMenu.png" alt="" width="500" height="500">
                </div>
				</div>
			</div>
		</div>

	</main>
	<%@ include file="Footer.jsp"%>
</body>
</html>