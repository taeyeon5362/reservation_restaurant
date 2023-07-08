<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
   content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>예약조회</title>

   <link rel="canonical"
        href="https://getbootstrap.com/docs/5.0/examples/carousel/">

   <!-- Bootstrap core CSS -->
   <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">

   <!-- Favicons -->
   <%@ include file="../NAVbar.jsp"%>

<style>
   @media ( min-width : 768px) {
      .bd-placeholder-img-lg {
         font-size: 3.5rem;
      }
   }
</style>

<link href="../../youngcha/src/main/webapp/resources/css/carousel.css" rel="stylesheet">
<head>
   <div class="py-5 text-center" style="user-select: auto;">
      <h2 style="user-select: auto;">예약조회</h2>
   </div>
</head>
<body>

<div class="table-responsive" style="margin-bottom: 40px; width: 1075px; margin-left:auto; margin-right: auto">
   <table class="table table-striped table-sm">
      <thead>
         <tr>
            <th>ID</th>
            <th>예약 시간</th>
            <th>테이블 위치</th>
            <th>자차 여부</th>
            <th>인원 수</th>
            <th>예약 취소</th>
         </tr>
    </thead>
      <tbody>
         <c:forEach items="${reservationList}" var="inq">
            <c:if test="${userID eq 'ad'}">
               <tr>
                  <th>${inq.customerID}</th>
                  <th>${inq.reservationDate}</th>
                  <th>${inq.tableNo}</th>
                  <th>${inq.hasCar}</th>
                  <th>${inq.numberOfPeople}</th>
               </tr>
            </c:if>
            <c:if test="${inq.customerID eq userID}">
               <tr>
                  <th>${inq.customerID}</th>
                  <th>${inq.reservationDate}</th>
                  <th>${inq.tableNo}</th>
                  <th>${inq.hasCar}</th>
                  <th>${inq.numberOfPeople}</th>
                  <td><a href="/reservations/cancel/my?cancelOid=${inq.oid}" onclick=alert("취소되었습니다.")>삭제</a></td>
               </tr>
            </c:if>
         </c:forEach>
      </tbody>
   </table>

</div>
</body>
</html>