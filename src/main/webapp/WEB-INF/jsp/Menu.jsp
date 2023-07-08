<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>메뉴</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/">

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
<style type="text/css">
table {font-size: 18pt;}
</style>

<link href="../../resources/css/carousel.css" rel="stylesheet">
<body>
	<div class="row featurette" style="margin: 80px 0px;">
	    <h1 style="text-align:center">★Best★</h1>
        <div style = "padding-top:50px; margin: 0 auto; width:500px; height: auto;">
            <table style= "text-align: center;">
                <thead>
                    <tr>
                        <th>Best Menu</th>
                        <th>판매량</th>
                    </tr>
                </thead>
                <c:if test="${!empty incomeList }" >
                   <c:forEach var="income" items="${incomeList}" varStatus="status">
                       <tr>
                           <td width="80%">${income.key}</td>
                           <td>${income.value}</td>
                       </tr>
                   </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
</body>
<%@ include file="Footer.jsp"%>
</html>