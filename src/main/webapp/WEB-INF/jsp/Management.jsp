<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <html>
        <head>
            <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                    <meta name="description" content="">
                        <meta
                            name="author"
                            content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
                            <meta name="generator" content="Hugo 0.79.0">
                                <title>관리</title>

                                <link
                                    rel="canonical"
                                    href="https://getbootstrap.com/docs/5.0/examples/carousel/">

                                    <link href=".\\css\\bootstrap.min.css" rel="stylesheet">

                                        <%@ include file="NAVbar.jsp"%>

                                            <style>
                                                .bd-placeholder-img {
                                                    font-size: 1.125rem;
                                                    text-anchor: middle;
                                                    -webkit-user-select: none;
                                                    -moz-user-select: none;
                                                    user-select: none;
                                                }

                                                @media (min-width : 768px) {
                                                    .bd-placeholder-img-lg {
                                                        font-size: 3.5rem;
                                                    }
                                                }
                                            </style>
                                            <link href="../../resources/css/carousel.css" rel="stylesheet">

                                                <script
                                                    src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                                                    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
                                                    crossorigin="anonymous"></script>
                                                <script
                                                    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
                                                    integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
                                                    crossorigin="anonymous"></script>
                                            </head>
                                        </head>
                                        <body style="padding-top: 250px;">
                                            <main>
                                                <div class="container marketing">
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <div style="cursor: pointer;" onclick="location.href='/waitList'">
                                                                <img
                                                                    class="d-block mx-auto mb-4"
                                                                    src="../../resources/image/WaitList.jpg"
                                                                    alt=""
                                                                    width="252"
                                                                    height="252"></div>
                                                                <h2 style="text-align:center">
                                                                    대기리스트</h2>
                                                            </div>

                                                            <div class="col-lg-3">

                                                                <div style="cursor: pointer;" onclick="location.href='/manager/Income'">
                                                                    <img
                                                                        class="d-block mx-auto mb-4"
                                                                        src="../../resources/image/Statistics.jpg"
                                                                        alt=""
                                                                        width="252"
                                                                        height="252"></div>

                                                                    <h2 style="text-align:center">통계</h2>

                                                                </div>

                                                                <div class="col-lg-3">
                                                                    <div style="cursor: pointer;" onclick="location.href='manager/tableManage'">
                                                                        <img
                                                                            class="d-block mx-auto mb-4"
                                                                            src="../../resources/image/Table.jpg"
                                                                            alt=""
                                                                            width="252"
                                                                            height="252"></div>

                                                                        <h2 style="text-align:center">테이블 관리</h2>
                                                                    </div>
                                                                    <div class="col-lg-3">
                                                                        <div style="cursor: pointer;" onclick="location.href='/manager/stock'">
                                                                            <img
                                                                                class="d-block mx-auto mb-4"
                                                                                src="../../resources/image/Stock.jpg"
                                                                                alt=""
                                                                                width="252"
                                                                                height="252"></div>

                                                                            <h2 style="text-align:center">재고관리</h2>
                                                                        </div>
                                                                    </div>
																	<div class="col-lg-3">
                                                                        <div style="cursor: pointer;" onclick="location.href='/walkIn/new'">
                                                                            <img
                                                                                class="d-block mx-auto mb-4"
                                                                                src="../../resources/image/walkIn.jpg"
                                                                                alt=""
                                                                                width="252"
                                                                                height="252"></div>

                                                                            <h2 style="text-align:center">워크인 등록</h2>
                                                                        </div>
                                                                </div>
                                                            </main>
                                                            <%@ include file="Footer.jsp"%>
                                                            </body>
                                                        </html>