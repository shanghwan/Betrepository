<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>BetOfOne</title>
<link href="resources/css/style5.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style4.css" rel="stylesheet" type="text/css" />
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
					<a href="index.jsp"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<c:choose>
					<c:when test="${loginUser eq null }">
						<ul id="nav">
							<li><a href="BetOfOnelist.do?betWay=one">BetOfOne</a></li>
							<li><a href="BetOfOnelist.do?betWay=all">BetOfAll</a></li>
							<li><a href="BetOfOnelist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetOfOnelistByState.do?state=대기">preseason game</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul id="nav">
							<li><a href="BetOfOnelist.do?betWay=one">BetOfOne</a></li>
							<li><a href="BetOfOnelist.do?betWay=all">BetOfAll</a></li>
							<li><a href="BetOfOnelist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetOfOnelistByState.do?state=대기">preseason game</a></li>
							<li><a href="#">Rank</a></li>
							<li><a href="#">Attendance</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">My Page</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-content clearfix">
							<div class="post-thumb"></div>


							<div class="post-summary" align="center">
								<ul id="nav">
									<li class="active"><a href="mypage.jsp">회원수정</a></li>
									<li><a href="#">내기목록</a></li>
									<li><a href="#">포인트내역</a></li>
									<li><a href="userDeletepassword.jsp">회원탈퇴</a></li>
								</ul>
							</div>
						</div>
						<div class="table-responsive">
						<form action="pwok.do" method="post">
							<table class="table table-striped table-bordered table-hover">
								<colgroup>
									<col width="100" />
									<col width="*" />
									<col width="120" />
									<col width="70" />
									<col width="50" />
								</colgroup>
								<thead>
								</thead>
								<tbody>
										<div>
											<label>비밀번호 입력 : </label> 
											<input type="password" name="paw">&nbsp;&nbsp;
											<button type="submit" class="btn btn btn-warning">확인</button>
										</div>
									
								</tbody>
							</table>
							</form>
						</div>
					</div>
				</div>
				<!-- // end #content -->
				<div id="sidebar">
					<div class="widget widget-search">
						<h2>회원</h2>
						<div class="contentarea" align="center">
							<form action="logout.do" method="post">
								<label>${loginUser.name }님 환영합니다.</label><br> <br> <label>포인트
									: ${loginUser.point }p</label> <br></br>
								<button type="submit" class="btn btn btn-warning">logout</button>
								<a href="mypage.jsp"><button type="button"
										class="btn btn btn-warning">MyPage</button></a>
							</form>
						</div>
					</div>
				</div>

			</div>
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
			<!-- // end #footer -->
		</div>
		<!-- // end #container -->
	</div>
	<!-- // end #wrapper -->