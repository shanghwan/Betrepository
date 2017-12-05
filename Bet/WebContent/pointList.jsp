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
					<a href="main.do"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">포인트내역</h1>
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
									<li><a href="betStateList.do?userId=${userId }&state=대기">내기목록</a></li>
									<li class="active"><a href="pointList.do">포인트내역</a></li>
									<li><a href="userDeletepassword.jsp">회원탈퇴</a></li>
									<li><a href="inviteList.do">초대목록</a></li>
								</ul>
							</div>
						</div>
						<div class="post">
							<div class="post-head">
								<h1>
									<form action="giftPoint.do?userId=${userId }" method="post">
										<label>${loginUser.name }님의 포인트는 ${loginUser.point }P</label>
										<br></br> 
										<input size="15" type="text" class="input_text" name="receiverId" placeholder="아이디" /> </span>							
										<a>에게</a>
											<input size="10" type="text" name="point" placeholder="포인트"> 
											<a>P 를</a>
											<input class="btn btn-xs btn-default" type="submit" value="선물하기♥">
									</form>
								</h1>
							</div>
						</div>

						<div class="table-responsive">
							<form action="pwok.do" method="post">
								<table class="table table-striped table-bordered table-hover">
									<colgroup align="center">
										<col width="100" />
										<col width="100" />
										<col width="100" />
										<col width="200" />
										<col width="120" />
									</colgroup>
									<tr>
										<td align="center">번호</td>
										<td align="center">일자</td>
										<td align="center">구분</td>
										<td align="center">포인트</td>
										<td align="center">선물받은회원</td>
									</tr>
									<c:forEach items="${pList }" var="point" varStatus="sts">
										<tr>
											<td align="center">${sts.count }</td>
											<td align="center">${point.pointDate }</td>
											<td align="center">${point.type }</td>
											<td align="center">${point.point }</td>
											<c:choose>
												<c:when test="${null eq point.receiverId}">
													<td align="center">-</td>
												</c:when>
												<c:otherwise>
													<td align="center">${point.receiverId }</td>
												</c:otherwise>
											</c:choose>
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