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
<link href="resources/css/style4.css" rel="stylesheet" type="text/css" />
<!--[if IE]><link href="resources/css/style-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
<SCRIPT>
	function change(style) {

		if (style == "selectBox01") {
			view1.style.display = "inline"
			view2.style.display = "none"
			view3.style.display = "none"
		}
		if (style == "selectBox02") {
			view1.style.display = "none"
			view2.style.display = "inline"
			view3.style.display = "none"
		}
		if (style == "selectBox03") {
			view1.style.display = "none"
			view2.style.display = "none"
			view3.style.display = "inline"
		}
	}
</SCRIPT>
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
				<h1 class="page-title">BetOfOne</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-head">
								<select onChange="change(this.options[this.selectedIndex].value)">
									<option>::: 검색조건 :::</option>
									<option value="selectBox01">내기번호</option>
									<option value="selectBox02">내기장</option>
									<option value="selectBox03">내기제목</option>
								</select>
								<div id=view1 style="display: none;">
									<form action="findBet.do">
										<input type="hidden" name="betWay" value="${betWay }">
										<input size="50" type="text" name="betId" placeholder="내기번호을 입력하세요"> 
										<input class="btn btn-xs btn-default" type="submit" value="검색">
									</form>
								</div>
								<div id=view2 style="display: none;">
									<form action="findBet.do">
									<input type="hidden" name="betWay" value="${betWay }"> 
										<input size="50" type="text" name="betOwner" placeholder="내기장을 입력하세요"> <input
											class="btn btn-xs btn-default" type="submit" value="검색">
									</form>
								</div>
								<div id=view3 style="display: none;">
									<form action="findBet.do">
									<input type="hidden" name="betWay" value="${betWay }"> 
										<input size="50" type="text" name="title" placeholder="내기제목을 입력하세요"> <input
											class="btn btn-xs btn-default" type="submit" value="검색">
									</form>
								</div>
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
									<c:if test="${bet ne null }">
										<tr>
											<td align="center">${bet.betId }</td>
											<td align="center"><a
												href="BetDetail.do?betId=${bet.betId}"
												class="list-group-item hidden-xs">${bet.title }</a></td>
											<td align="center">${bet.betOwner }</td>
											<td align="center">${bet.state }</td>
										</tr>
										</c:if>
										
										<c:forEach items="${list }" var="list">
										<tr>
											<td align="center">${list.betId }</td>
											<td align="center"><a
												href="BetDetail.do?betId=${list.betId}"
												class="list-group-item hidden-xs">${list.title }</a></td>
											<td align="center">${list.betOwner }</td>
											<td align="center">${list.state }</td>
										</tr>
										</c:forEach>
										
										<c:forEach items="${list1 }" var="list">
										<tr>
											<td align="center">${list.betId }</td>
											<td align="center"><a
												href="BetDetail.do?betId=${list.betId}"
												class="list-group-item hidden-xs">${list.title }</a></td>
											<td align="center">${list.betOwner }</td>
											<td align="center">${list.state }</td>
										</tr>
										</c:forEach>
										
									</thead>
									<c:forEach var="list" items="${BetList }">
										<tr>
											<td align="center">${list.betId }</td>
											<td align="center"><a
											href="BetDetail.do?betId=${list.betId}"
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
											<div align="right"><a href="registBet.do"><button type="button"
												class="btn btn btn-warning">내기생성</button></a></div>
					</c:when>
					
				</c:choose>






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