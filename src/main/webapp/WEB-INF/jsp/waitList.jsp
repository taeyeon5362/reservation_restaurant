<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="Team2.youngcha.hellospring.domain.Reservation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../../resources/js/waitList.js"></script>
    <title>boardList</title>
</head>

<body>
<div class="page-wrapper">
    <div class="container-fluid">
        <div class="col-lg-8"><!--게시판 넓이 -->
            <div class="col-lg-12">
                <h1 class="page-header">공지사항 관리</h1>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <button type="button" class="btn btn-outline btn-primary pull-right">
                        <i class="fa fa-edit fa-fw"></i> 공지사항 작성
                    </button>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">공지사항 </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>아이디</th>
                            <th>테이블 번호</th>
                            <th>인원수</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th>자차여부</th>
                            <th>예약 시간</th>
                            <th>도착 기록</th>
                        </tr>
                        </thead>
                        <tbody id="tableBody">
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>