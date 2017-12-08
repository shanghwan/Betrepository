<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>관리자</title>
<link href="resources/css/style5.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style4.css" rel="stylesheet" type="text/css" />
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
						<ul id="nav">
							<li><a href="Betlist.do?betWay=one">BetOfOne</a></li>
							<li><a href="Betlist.do?betWay=all">BetOfAll</a></li>
							<li><a href="Betlist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetlistByState.do?state=대기">preseason game</a></li>
						</ul>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">${betOwner }님의 내기들 </h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-content clearfix">
							<div class="post-thumb"></div>


							<div class="post-summary" align="center">
								<ul id="nav">
									<li class="active"><a href="adminpage.do">회원신고</a></li>
									<li><a href="adminpageBet.do">내기신고</a></li>
								</ul>
							</div>
						</div>
						<div class="table-responsive">
							<table border="1">
									<colgroup>
										<col width="100" />
										<col width="250" />
										<col width="100" />
										<col width="100" />
										<col width="100" />
									</colgroup>
									<thead>
										<tr>
											<th class="text-center">내기번호</th>
											<th class="text-center">내기제목</th>
											<th class="text-center">내기방식</th>
											<th class="text-center">내기장</th>
											<th class="text-center">내기상태</th>
										</tr>
									</thead>
									<c:forEach var="list" items="${list }">
										<tr>
											<td align="center">${list.betId }</td>
											<td align="center"><a href="BetDetail.do?betId=${list.betId}">${list.title }</a></td>
											<td align="center">${list.betWay }</td>
											<td align="center">${list.betOwner }</td>
											<td align="center">${list.state }</td>
										</tr>
									</c:forEach>
								</table>
								<br><Br>
							<div align="right"><a href="pointReset.do?userId=${betOwner }"><button type="submit" class="btn btn btn-warning">포인트 초기화</button></a></div>
						</div>
					</div>
				</div>
				<!-- // end #content -->
				<div id="sidebar">
					<div class="widget widget-search">
						<%@ include file="usermenu.jsp"%>
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