<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>내기의 신</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style3.css" rel="stylesheet" type="text/css" />
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
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<div id="slider">
					<ul>
						<li><img src="resources/images/banners/banner-1.jpg"
							alt="Banner Image 1" />
							<div class="caption">
								<h1>Title Here</h1>
								<p>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									Aenean commodo ligula eget dolor. Aenean massa. <a href="#">Readmore
										></a>
								</p>
							</div></li>
						<li><img src="resources/images/banners/banner-2.jpg"
							alt="Banner Image 2" />
							<div class="caption">
								<h1>Title Here</h1>
								<p>
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									Aenean commodo ligula eget dolor. Aenean massa. <a href="#">Readmore
										></a>
								</p>
							</div></li>
					</ul>
				</div>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="BetOfOnelist.do?betWay=all" title="Welcome to Dkntemplates">Welcome to
									BetOfAll</a>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb">
								<img src="resources/images/betofall.jpg" alt="" />
							</div>
							<div class="post-summary">
								<table border="1">
									<colgroup>
										<col width="100" />
										<col width="120" />
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
									<tr>
										<td align="center">1</td>
										<td align="center">LG VS SK</td>
										<td align="center">구창환</td>
										<td align="center">진행중</td>
									</tr>
									<tr>
										<td align="center">2</td>
										<td align="center">두산 VS 기아</td>
										<td align="center">허준호</td>
										<td align="center">진행중</td>
									</tr>
								</table>
								<p>
									<a href="BetOfOnelist.do?betWay=all">Readmore ...</a>
								</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="BetOfOnelist.do?betWay=one" title="Another Post Title">Welcome to BetOfOne</a>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb">
								<img src="resources/images/betofone.jpg" alt="" />
							</div>
							<div class="post-summary">
								<table border="1">
									<colgroup>
										<col width="100" />
										<col width="120" />
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
									<tr>
										<td align="center">1</td>
										<td align="center">LG VS SK</td>
										<td align="center">구창환</td>
										<td align="center">진행중</td>
									</tr>
									<tr>
										<td align="center">2</td>
										<td align="center">두산 VS 기아</td>
										<td align="center">허준호</td>
										<td align="center">진행중</td>
									</tr>
								</table>
								<p>
									<a href="BetOfOnelist.do?betWay=one">Readmore ...</a>
								</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="BetOfOnelist.do?betWay=team" title="Another Post Title">Welcome to BetOfTeam</a>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb">
								<img src="resources/images/betofteam.jpg" alt="Image" />
							</div>
							<div class="post-summary">
								<table border="1">
									<colgroup>
										<col width="100" />
										<col width="120" />
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
									<tr>
										<td align="center">1</td>
										<td align="center">LG VS SK</td>
										<td align="center">구창환</td>
										<td align="center">진행중</td>
									</tr>
									<tr>
										<td align="center">2</td>
										<td align="center">두산 VS 기아</td>
										<td align="center">허준호</td>
										<td align="center">진행중</td>
									</tr>
								</table>
								<p>
									<a href="BetOfOnelist.do?betWay=team">Readmore ...</a>
								</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
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
											placeholder="아이디 " size="12"></input><br /> PW : <input
											type="password" name="password" placeholder="패스워드" size="12"></input><br></br>
										<button type="submit" class="btn btn btn-warning">로그인</button>
										<a href="signUp.jsp"><button type="button"
												class="btn btn btn-warning">회원 가입</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${loginUser.userId eq 'admin'}">
					<div id="sidebar">
							<div class="widget widget-search">
								<h2>회원</h2>
								<div class="contentarea" align="center">
									<form action="logout.do" method="post">
										<label>${loginUser.name }님 환영합니다.</label><br>
										<br> <label>포인트 : ${loginUser.point }p</label> <br></br>
										<button type="submit" class="btn btn btn-warning">logout</button>
										<a href="adminpage.jsp"><button type="button"
												class="btn btn btn-warning">admin Page</button></a>

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
										<label>${loginUser.name }님 환영합니다.</label><br>
										<br> <label>포인트 : ${loginUser.point }p</label> <br></br>
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


</body>
</html>