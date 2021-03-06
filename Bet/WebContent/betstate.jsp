<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>내기의신</title>
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
					<a href="main.do"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">초대목록</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-content clearfix">
							<div class="post-thumb"></div>
							<div class="post-summary" align="left">
								<ul id="nav">
									<li><a href="mypage.jsp">회원수정</a></li>
									<li class="active"><a href="betStateList.do?userId=${userId }&state=대기">내기목록</a></li>
									<li><a href="pointList.do">포인트내역</a></li>
									<li><a href="userDeletepassword.jsp">회원탈퇴</a></li>
									<li><a href="inviteList.do">초대목록</a></li>
								</ul>
								<ul id="nav">
									<li><a href="betStateList.do?userId=${userId }&state=대기">시작 전</a></li>
									<li><a href="betStateList.do?userId=${userId }&state=진행">진행 중</a></li>
									<li><a href="betStateList.do?userId=${userId }&state=종료">종료</a></li>
								</ul>
							</div>
						</div>
						<br>
							<table border="1">
								<colgroup>
									<col width="100" />
									<col width="100" />
									<col width="300" />
									<col width="100" />
									<col width="100" />
									<col width="100" />
								</colgroup>
								<thead>
									<tr>
										<th class="text-center">번호</th>
										<th class="text-center">내기번호</th>
										<th class="text-center">내기제목</th>
										<th class="text-center">내기장</th>
										<th class="text-center">내기방식</th>
										<th class="text-center">상태</th>
									</tr>
								</thead>
								<c:forEach var="list" items="${list }" varStatus="sts">
									<tr>
									<td align="center">${sts.count }</td>
									<td align="center">${list.betId }</td>
									<td align="center">${list.title }</td>
									<td align="center">${list.betOwner }</td>
									<td align="center">BetOf${list.betWay }</td>
									<td align="center">${list.state }</td>
									</tr>
								</c:forEach>
							</table>
					</div>
				</div>
			</div>
			<!-- // end #content -->
			<div id="sidebar">
				<div class="widget widget-search"></div>
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
	<!-- // end #wrapper -->