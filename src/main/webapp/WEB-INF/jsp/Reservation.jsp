<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>예약</title>

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

#login_wrapper {
	width: 100%;
	max-width: 1500px;
	padding-left: 380px;
	margin: auto;
}
</style>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<link
	href="${pageContext.servletContext.contextPath}/resources/jquery/jquery-ui.css?version=1.3"
	rel="stylesheet" type="text/css" media="screen">
<script
	src="${pageContext.servletContext.contextPath}/resources/js//jquery-1.8.3.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/jquery/jquery-ui.js?version=1.3"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<script src="../../resources/js/reservation.js"></script>
</head>

<div class="py-5 text-center" style="user-select: auto;">
	<img class="d-block mx-auto mb-4"
		src="../../resources/image/Reservation2.jpg" alt="" width="800" height="400"
		style="user-select: auto;">
	<h2 style="user-select: auto;">예약</h2>
</div>
<body class="bg-light">
	<div class="container" style="user-select: auto;" id="login_wrapper">
		<main style="user-select: auto;">
			<div class="col-md-7 col-lg-8" style="user-select: auto;">
				<h4 style="user-select: auto;">인원 선택
                	<span style="margin-left: 455px">
                		<input class="btn btn-success btn-default btn-sm" type="button" onclick="add_People()" value="예약 추가" st>
                		<input class="btn btn-danger btn-default btn-sm" type="button" onclick="remove_People(this)" value="예약 삭제">
                	</span>
                </h4>
					<div id="addPeople" style="user-select: auto;">
						<div class="row g-3" style="padding-top:10px; user-select: auto;">
							<div class="col-md-5" style="user-select: auto;">
								<label for="numberOfPeople" class="form-label" style="padding-left: 3px; user-select: auto;">인원 수</label> <select
									class="form-select" name="numberOfPeople" id="numberOfPeople"
									required="" style="user-select: auto;">
									<option value="" style="user-select: auto;">선택</option>
									<option style="user-select: auto;">1</option>
									<option style="user-select: auto;">2</option>
									<option style="user-select: auto;">3</option>
									<option style="user-select: auto;">4</option>
								</select>
								<div class="invalid-feedback" style="user-select: auto;"></div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
                    		function add_People(){
                                var div = document.createElement('div');
                                div.innerHTML = document.getElementById('addPeople').innerHTML;
                                document.getElementById('addResv').appendChild(div);
                            }
                            function remove_People(){
                                const div = document.getElementById('addResv');
                                $("#addResv *").remove();
                            }
                    </script>
					<div id="addResv"></div>
					<h4 style="padding-top:30px; user-select: auto;">메뉴 선택
                         <span style="margin-left: 455px">
                    	     <input class="btn btn-success btn-default btn-sm" type="button" id="addMenuButton" value="메뉴 추가">
                    	     <input class="btn btn-danger btn-default btn-sm" type="button" id="removeButton" value="메뉴 삭제">
                    	 </span>
                    </h4>
					<div id="addMenu" style="user-select: auto;">
					<div id="menuSection_0"class="row g-3" style="padding-top:10px; user-select: auto;">
						<div class="col-md-4" style="user-select: auto;" id="dishSection">
							<label for="numberOfPeople" class="form-label"
								style="padding-left: 3px; user-select: auto;">메뉴 선택</label>
							<div class="invalid-feedback" style="user-select: auto;"></div>
						</div>

						<div class="col-md-4" style="user-select: auto;" id="qntSection">
							<label for="numberOfdish" class="form-label" style="padding-left: 3px; user-select: auto;">수량</label>
							<div class="invalid-feedback" style="user-select: auto;"></div>
						</div>
					</div>
					</div>
					<div id="addResv2"></div>
					<script type="text/javascript">
                      $(document).ready(function () {
                        $.datepicker.setDefaults($.datepicker.regional['ko']);
                        $( "#startDate" ).datepicker({
                             changeMonth: true,
                             changeYear: true,
                             nextText: '다음 달',
                             prevText: '이전 달',
                             dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                             dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
                             monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                             monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                             dateFormat: "yy-mm-dd",
                             minDate: 0,
                             onClose: function( selectedDate ) {
                                      $("#endDate").datepicker( "option", "minDate", selectedDate );
                                      $("#endDate").datepicker( "option", "maxDate", selectedDate );
                              }

                        });

                      });
                     $(document).ready(function () {
                        $("#startTime").timepicker({
                            timeFormat: 'p h:mm',
                            interval: 60,
                            minTime: '09',
                            maxTime: '11:00pm',
                            defaultTime: '14',
                            startTime: '00:00',
                            dynamic: false,
                            dropdown: true,
                            scrollbar: true
                        });
                        $("#endTime").timepicker({
                            timeFormat: 'p h:mm',
                            interval: 60,
                            minTime: '09',
                            maxTime: '11:00pm',
                            defaultTime: '14',
                            startTime: '00:00',
                            dynamic: false,
                            dropdown: true,
                             scrollbar: true
                          });
                      });
                     </script>
                     <h4 style="padding-top:30px; user-select: auto;">날짜와 시간</h4>
                        <div class="row g-3" style="padding-top: 10px;  user-select: auto;">
                    		<div class="col-md-4" style="user-select: auto;">
                    		<label for="Date" class="form-label"style="padding-left: 3px; user-select: auto;">날짜</label>
                    			<input type="text" id="startDate" class="form-control" value="선택" name="startDate">
                    		</div>
                    		<div class="col-md-4" style="user-select: auto;">
                    		<label for="Time" class="form-label"style="padding-left: 3px; user-select: auto;">예약 시간</label>
                    			<input type="text" id="startTime" class="form-control" value="선택" name="startTime">
                    		</div>
                    		<div class="col-md-4" style="user-select: auto;">
                                <label for="Car" class="form-label"style="padding-left: 3px; user-select: auto;">자차 여부</label>
                                <select class="form-select" name="hasCar" id="hasCar" required="" style="user-select: auto;">
                                     <option value="" style="user-select: auto;">선택</option>
                                     <option style="user-select: auto;">O</option>
                                     <option style="user-select: auto;">X</option>
                                </select>
                                <div class="invalid-feedback" style="user-select: auto;"></div>
                            </div>
                        </div>

					<button class="my-4 w-100 btn btn-warning btn-primary btn-lg" style="user-select: auto;" id="chooseTable">테이블 선택</button>
                    <div class="tableSelect">
                    	<div class="tableImage"></div>
                    	<div class="tableSelector"></div>
                    </div>
			</div>
		</main>
	</div>

	<%@ include file="Footer.jsp"%>

	<script src="form-validation.js" style="user-select: auto;"></script>
	<div class="liner-scroll-points-container" style="user-select: auto;"></div>
</body>
</html>