<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>내기의신</title>
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
				<h1 class="page-title">회원 탈퇴</h1>
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
									<li class="active"><a href="userDeletepassword.jsp">회원탈퇴</a></li>
									<li><a href="inviteList.do">초대목록</a></li>
								</ul>
							</div>
						</div>
						<div class="table-responsive">
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
									<form action="userdelete.do" method="post">
										<div align="center">
											<h1 class="page-title">탈퇴하기</h1> 
											<button type="submit" class="btn btn btn-warning">확인</button>
											<button type="reset" class="btn btn btn-warning">취소</button>
										</div>
									</form>
								</tbody>
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