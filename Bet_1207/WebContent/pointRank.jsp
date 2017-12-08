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
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">
					<a href="main.do"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">Ranking</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-content clearfix">
							<div class="post-thumb"></div>


							<div class="post-summary" align="center">
								<ul id="nav">
									<li><a href="rateRank.do">승률 랭킹</a></li>
									<li><a href="totalRank.do">참여 랭킹</a></li>
									<li><a href="winRank.do">승 랭킹</a></li>
									<li><a href="loseRank.do">패 랭킹</a></li>
									<li class="active"><a href="pointRank.do">포인트 랭킹</a></li>
								</ul>
							</div>
						</div>
						<div class="table-responsive">
						<table border="1">
									<colgroup>
										<col width="100" />
										<col width="200" />
										<col width="100" />
										<col width="150" />
										<col width="100" />
									</colgroup>
									<thead>
										<tr>
											<th class="text-center">랭킹</th>
											<th class="text-center">회원 아이디</th>
											<th class="text-center">이름</th>
											<th class="text-center">포인트</th>
										</tr>
										
									<c:forEach var="pointList" items="${pointList }" varStatus="status">
										<tr>
											<td align="center">${status.count }</td> 
											<td align="center">${pointList.userId }</td>
											<td align="center">${pointList.name }</td>
											<td align="center">${pointList.point } 포인트</td>
										</tr>
									</c:forEach> 
								</table>
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