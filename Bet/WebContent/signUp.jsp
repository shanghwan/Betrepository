<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>회원가입</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style2.css" rel="stylesheet" type="text/css" />
<!--[if IE]><link href="resources/css/style-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">
					<h1>내기의 神</h1>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">회원가입</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="page" align="center">
					<br>
					<form action="Userregist.do" method="post">
						<table>
							<tr>
								<th>ID</th>
								<td><input id="loginId" name="userId" class="form-control"
									type="text" placeholder="ID를 입력해주세요." size="50"></td>
							</tr>
							<tr>
								<th>Password</th>
								<td><input id="password" name="password"
									class="form-control" type="password" 
									placeholder="비밀번호를 입력해주세요." size="50"></td>
							</tr>
							<tr>
								<th>Password 확인</th>
								<td><input id="passwordok" name="passwordok"
									class="form-control" type="password" 
									placeholder="비밀번호를 입력해주세요." size="50"></td>
							</tr>
							<tr>
								<th>Name</th>
								<td><input id="name" name="name" class="form-control"
									type="text"  placeholder="이름을 입력해주세요." size="50"></td>
							</tr>
						</table>
						<br>
						<div align="center">
							<input class="btn" type="reset" value="취소"> <input
								class="btn btn-success" type="submit" value="가입">
						</div>
					</form>
					<br>

				</div>
			</div>
			<!-- // end #main -->
			<div id="footer">
				<p>
					&copy; copyright 2012 <a href="htp://www.dkntemplates.com"
						title="Dkntemplates">www.dkntemplates.com</a> All right reserved
				</p>

				<!-- Please don't remove my backlink -->
				<p>
					Free Web Design Templates by <a href="http://www.dkntemplates.com"
						title="Dkntemplates">Dkntemplates.com</a>
				</p>
				<!-- Please don't remove my backlink -->
</div>
</div></div>

</body>

</html>