<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<a href="main.jsp"><h1>내기의 神</h1></a>
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


							<div class="post-summary" align="center">
								<ul id="nav">
									<li><a href="mypage.jsp">회원수정</a></li>
									<li><a href="betStateList.do?userId=${userId }&state=대기">내기목록</a></li>
									<li><a href="pointList.do">포인트내역</a></li>
									<li><a href="userDeletepassword.jsp">회원탈퇴</a></li>
									<li class="active"><a href="inviteList.do">초대목록</a></li>
								</ul>
							</div>
						</div>
						<div class="table-responsive">
							<form action="pwok.do" method="post">
								<table class="table table-striped table-bordered table-hover">
									<colgroup align="center">
										<col width="100" />
										<col width="100" />
										<col width="200" />
										<col width="120" />
									</colgroup>
									<tr>
										<td align="center">번호</td>
										<td align="center">내기번호</td>
										<td align="center">내기제목</td>
										<td align="center">내기장</td>
									</tr>
									<c:forEach items="${list }" var="p" varStatus="sts">
									<tr>
										<td align="center">${sts.count }</td>
										<td align="center">${p.betId }</td>
										<td align="center"><a
											href="BetDetail.do?betId=${p.betId}"
											class="list-group-item hidden-xs">${p.title }</a></td>
										<td align="center">${p.betOwner }</td>
									</tr>
									</c:forEach>									
								</table>
							</form>
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