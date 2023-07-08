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
<title>오시는 길</title>
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
</style>

<link href="../../resources/css/carousel.css" rel="stylesheet">

<body>
   <div class="text-center form-signin" style="margin-bottom:100px;">
      <h1 style="text-align:center; margin-top:80px;">오시는 길</h1>

       <iframe style="padding-top:50px" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3173.774202157145!2d127.0332580756801!3d37.30048497210873!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b5c9c1e337b5b%3A0x437f7735e290ec4d!2z6rK96riw64yA7ZWZ6rWQ!5e0!3m2!1sko!2skr!4v1688803350657!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>

      <div style="padding-top:50px;">경기대학교 경기도 수원시 영통구 광교산로 154-42</div>
      <div style="padding-top:5px;">영업시간: 09:00 ~ 16:50</div>
      <div style="padding-top:5px;">break time : 11:50 ~ 14:00</div>
   </div>

   <%@ include file="Footer.jsp"%>
</body>
</html>