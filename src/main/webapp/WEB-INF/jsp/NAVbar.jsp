<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>네비게이션 바</title>
<link href="../../resources/css/navbar-top-fixed.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">

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

</head>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-warning">
	<div class="container-fluid">
		<a class="navbar-brand"  href="/"><img
			src="../../resources/image/restaurant_icon2.png" width="64" height="60" border="0"> </a>

		<button class="navbar-toggler	" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
			aria-controls="navbarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link" href="/reservations/new"
					style="color: #FFFFFF; font-weight: bold;">예약</a></li>

				<li class="nav-item"><a class="nav-link" href="/manager"
					style="color: #FFFFFF; font-weight: bold;">관리</a></li>
			</ul>

			<ul class="navbar-nav navbar-right">
			<li class="nav-item">
                                             <%
                                        String Id = (String)session.getAttribute("userID"); %>
                                                  <% if(Id!=null){
                                                  %>
                                                  <!--<a class="nav-link" href="/waitList" style="color: #FFFFFF; font-weight: bold;">마이페이지</a>-->
                                                  <a class="nav-link" href="/reservations/cancel" style="color: #FFFFFF; font-weight: bold;">마이페이지</a>
                                                  <%
                                                  }
                                        else { %>
                                             <a class="nav-link" href="/customers/login" style="color: #FFFFFF; font-weight: bold;">마이페이지</a>
                                        <% } %>
                                        </li>
				<li class="nav-item">
					<%
				String ID = (String)session.getAttribute("userID");


				if(ID!=null){
					%> <a class="nav-link" href="/customers/logout"
					style="color: #FFFFFF; font-weight: bold;">로그아웃</a> <%
					}
				else{
					%> <a class="nav-link" href="/customers/login"
					style="color: #FFFFFF; font-weight: bold;">로그인</a> <%
				}
				%>
				</li>
			</ul>
		</div>
	</div>
</nav>

<script src="../../resources/js/bootstrap.bundle.min.js"></script>