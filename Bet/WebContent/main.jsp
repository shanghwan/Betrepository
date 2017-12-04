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
					<a href="main.jsp"><h1>내기의 神</h1></a>
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
								<a href="Betlist.do?betWay=all" title="Welcome to Dkntemplates">Welcome to
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
									<a href="Betlist.do?betWay=all">Readmore ...</a>
								</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="Betlist.do?betWay=one" title="Another Post Title">Welcome to BetOfOne</a>
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
									<a href="Betlist.do?betWay=one">Readmore ...</a>
								</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="Betlist.do?betWay=team" title="Another Post Title">Welcome to BetOfTeam</a>
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
									<a href="Betlist.do?betWay=team">Readmore ...</a>
								</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
				</div>
				<!-- // end #content -->
				<%@ include file="usermenu.jsp"%>
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