<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Child</title>
<style>
    .col-lg-10 {
        height: 70px;
        width: 220px;
    }
</style>
    <script type="text/javascript">
        function setParentText(){
            //opener.document.getElementById("pInput").value = document.getElementById("cInput").value

            var checked = document.getElementsByClassName("cInput")
            var chkList = "";

            for (var i = 0; i < checked.length; i++) {
                if (checked[i].checked == true) {
                    chkList += checked[i].value + ",";
                }
            }
            opener.document.getElementById("pInput").value = chkList;

            alert(chkList);
 //           var arr = Array.prototype.slice.call( tags )
 //          alert(arr);
 //           var aaa=[];
 //           for(var i=0; i<$("input[type='checkbox']").is(':checked').length; i++){
 //               $('cInput', opener.document).html($("input[type='checkbox']").is(':checked').val()+'<br>');
 //           }
        }


    </script>
</head>
<body>

<br>
<b><font size="5" color="gray">자식창</font></b>
<br><br>

<div class="form-group" style="margin-bottom: 15px;" >
    <label class="col-lg-2 control-label">좌석 선택
    </label>

    <div class="col-lg-10" >
        <c:if test="${!empty tableList}" >
            <c:forEach var="tableList" items="${tableList}" varStatus="i">
                <label><input style="zoom:2.0;" type="checkbox" class="cInput" name="tableNo" value="${tableList.tableNumber}">
                        ${tableList.tableNumber}</label>
            </c:forEach>
        </c:if>
    </div>
    <div>
        <input type="button" value="전달하기" onclick="setParentText()">
</div><div>
    <input type="button" value="창닫기" onclick="window.close()"></div>
</div>
<div id="Work_Type"></div>
</body>
</html>