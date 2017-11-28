<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<li class="active"><a href="BetOfOne.jsp">BetOfOne</a></li>
							<li><a href="#">BetOfAll</a></li>
							<li><a href="#">BetOfTeam</a></li>
							<li><a href="#">preseason game</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul id="nav">
							<li class="active"><a href="BetOfOne.jsp">BetOfOne</a></li>
							<li><a href="#">BetOfAll</a></li>
							<li><a href="#">BetOfTeam</a></li>
							<li><a href="#">Preseason game</a></li>
							<li><a href="#">Rank</a></li>
							<li><a href="#">Attendance</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">내기생성</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-content clearfix">
							<div class="post-thumb"></div>
							<div class="post-summary">
									<form action="registBet.do" class="bs-example form-horizontal" enctype="multipart/form-data" method="POST">
									<table>
										<colgroup>
											<col width="90" />
											<col width="*" />
											<col width="100" />
											<col width="100" />
											<col width="100" />
										</colgroup>
									
										<thead>
										
											<tr>
												<th>제목</th>
												<td><input id="title" name="title" class="form-control"
													type="text" placeholder="제목을 입력하세요." size="60"></td>
											</tr>
											<tr>
												<th>내용</th>
												<td align="left"><input id="content" name="content"
													class="form-control" type="text" placeholder="내용을 입력하세요."
													size="60"><br> <br> <input id="loginId"
													name="userId" class="form-control" type="file"> <input
													id="loginId" name="userId" class="form-control" type="file"></td>
											</tr>
											<tr>
												<th>내기장</th>
												<td>${loginUser.name }</td>
											</tr>
											<tr>

												<th>포인트</th>
												<td><input name="point" class="form-control" type="text" placeholder="포인트을 입력해주세요." size="20"></td>
											<tr>

												<th>초대자</th>
												<td><input id="name" name="name" class="form-control"
													type="text" placeholder="아이디를 입력해주세요" size="50">&nbsp;<select
													name='fruits'>
														<option value='' selected>친구목록</option>
														<option value='apple'>사과</option>
														<option value='banana'>바나나</option>
														<option value='lemon'>레몬</option>
												</select></td>
											</tr>
											<tr>
												<th>종료날짜</th>
												<td><input id="endDate" name="endDate"
													class="form-control" type="text" placeholder="날짜를 입력해주세요."
													size="50"></td>
											</tr>
											<tr>
												<th>공개여부</th>
												<td><input type="radio" name="open" value="공개">공개
													<input type="radio" name="open" value="비공개">비공개
											</tr>
									</table>
							</div>
						</div>
					</div>
					<div align="right">
						<button type="submit" class="btn btn btn-warning">내기생성</button>
					</div>
					</form>

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
								<a href="#"><button type="button"
										class="btn btn btn-warning">MyPage</button></a>

							
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