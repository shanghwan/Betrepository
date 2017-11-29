<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>BetOfOne</title>
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
					<a href="index.jsp"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<c:choose>
					<c:when test="${loginUser eq null }">
						<ul id="nav">
							<li><a href="BetOfOnelist.do?betWay=one">BetOfOne</a></li>
							<li class="active"><a href="BetOfOnelist.do?betWay=all">BetOfAll</a></li>
							<li><a href="BetOfOnelist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetOfOnelistByState.do?state=대기">preseason game</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul id="nav">
							<li><a href="BetOfOnelist.do?betWay=one">BetOfOne</a></li>
							<li class="active"><a href="BetOfOnelist.do?betWay=all">BetOfAll</a></li>
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
				<h1 class="page-title">BetOfAll</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-head">
							<h1>
								<form action="" method="post">
									<input size="50" type="text" name="categoryName"
										placeholder="내기제목을 입력하세요"> <input
										class="btn btn-xs btn-default" type="submit" value="검색">
								</form>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb"></div>
							<div class="post-summary">
								<table border="1">
									<colgroup>
										<col width="100" />
										<col width="300" />
										<col width="100" />
										<col width="100" />
										<col width="100" />
									</colgroup>
									<thead>
										<tr>
											<th class="text-center">내기번호</th>
											<th class="text-center">내기제목</th>
											<th class="text-center">내기장</th>
											<th class="text-center">상태</th>
										</tr>
									</thead>
									<c:forEach var="list" items="${BetList }">
										<tr>
											<td align="center">${list.betId }</td>
											<td align="center"><a
											href="BetOfOneDetail.do?betId=${list.betId}"
											class="list-group-item hidden-xs">${list.title }</a></td>
											<td align="center">${list.betOwner }</td>
											<td align="center">${list.state }</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
					<c:choose>
						<c:when test="${loginUser ne null }">
							<div align="right">
								<a href="BetCreate.jsp"><button type="button"
										class="btn btn btn-warning">내기생성</button></a>
							</div>
						</c:when>

					</c:choose>






				</div>
				<!-- // end #content -->
				<c:choose>
					<c:when test="${loginUser eq null }">
						<div id="sidebar">
							<div class="widget widget-search">
								<h2>Login</h2>
								<div class="contentarea" align="center">
									<form action="login.do" method="post">
										&nbsp;&nbsp;ID : <input type="text" name="userId"
											placeholder="아이디" size="12"></input><br /> PW : <input
											type="password" name="password" placeholder="패스워드" size="12"></input><br></br>
										<button type="submit" class="btn btn btn-warning">로그인</button>
										<a href="signUp.jsp"><button type="button"
												class="btn btn btn-warning">회원 가입</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
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
					</c:otherwise>
				</c:choose>
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