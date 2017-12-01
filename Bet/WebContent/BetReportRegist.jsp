<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>친구초대</title>
<style>
.green_window {
	display: inline-block;
	width: 366px;
	height: 34px;
	border: 3px solid #2db400;
	background: white;
}

.input_text {
	width: 348px;
	height: 21px;
	margin: 6px 0 0 9px;
	border: 0;
	line-height: 21px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
}

.sch_smit {
	width: 54px;
	height: 40px;
	margin: 0;
	border: 0;
	vertical-align: top;
	background: #22B600;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}

.sch_smit:hover {
	background: #56C82C;
}
</style>


</head>
<body>

	<form action="createBetReport.do?userId=${userId }&target=${target}" method="post">
		 <span
			class="green_window"> <input type="text" class="input_text"
			name="reason" placeholder="신고 사유" />
		</span>
		<button type="submit" class="sch_smit">신고</button>
	</form>

	<br>

</body>
</html>