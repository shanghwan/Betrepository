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
<link href="resources/css/style6.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style8.css" rel="stylesheet" type="text/css" />


<link href="resources/css2/bootstrap_modify.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css2/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css2/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css2/bootstrap-theme.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css2/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css2/layout.css" rel="stylesheet" type="text/css" />



<!--[if IE]><link href="resources/css/style-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
<script>
	function showPopup() {
		window.open("BetFail.do?betId=${bet.betId}", "a",
				"width=500, height=300, left=100, top=50");
	}
	function showPopup1() {
		window.open("BetReport.do?target=${bet.betId}&userId=${userId}", "a",
				"width=500, height=300, left=100, top=50");
	}
	function showPopup2() {
		window.open("UserReport.do?target=${bet.betOwner}&userId=${userId}", "a",
				"width=500, height=300, left=100, top=50");
	}
</script>
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
				<h1 class="page-title">[${bet.betId }]&nbsp;${bet.title }</h1>
			</div>
			<!-- // end #banner -->
			<c:if test="${bet.state eq '대기' and bet.betOwner eq userId or userId eq 'admin'}">
			<a href="deleteBetAllReport.do?target=${bet.betId }&userId=${userId}" class="glyphicon glyphicon-trash pull-right" style="padding: 10px">삭제</a>
				</c:if>
			<a class="glyphicon glyphicon-cog pull-right" style="padding: 10px"
				onclick="showPopup1();">신고</a> <br>
			<c:if test="${bet.state eq '대기' }">
				<c:if test="${userId eq bet.betOwner }">
					<button type="submit" class="btn btn btn-warning"
						onclick="showPopup();">초대하기</button>
				</c:if>
				<form action="gameJoin.do" method="post" name="sub1">
					<input type="hidden" name="betId" value="${bet.betId }"> <input
						type="text" name="pointBet" placeholder="포인트 입력 " size="12" id="pointBet"></input>
					
					<input type="radio" name="teamName" value="A" id="teamName">Team A <input
						type="radio" name="teamName" value="B">Team B
					<button type="button" class="btn btn btn-warning btn3">참여하기</button>
				</form>
			</c:if>

			<div align="center">
				<c:if test="${bet.state eq '대기' }">
					<c:if test="${userId eq teamA.leader.userId }">
						<form action="gameReady.do" method="post">
							<input type="hidden" name="betId" value="${bet.betId }">
							<input type="hidden" name="teamId" value="${teamA.teamId }">
							<c:choose>
								<c:when test="${teamA.start eq 'N' }">
									<input type="submit" class="btn btn btn-warning" value="준비완료">
								</c:when>
								<c:when test="${teamA.start eq 'Y' }">
									<input type="submit" class="btn btn btn-warning" value="준비해제">
								</c:when>
							</c:choose>
						</form>
					</c:if>

					<c:if test="${userId eq teamB.leader.userId }">
						<form action="gameReady.do" method="post">
							<input type="hidden" name="betId" value="${bet.betId }">
							<input type="hidden" name="teamId" value="${teamB.teamId }">
							<c:choose>
								<c:when test="${teamB.start eq 'N' }">
									<input type="submit" class="btn btn btn-warning" value="준비완료">
								</c:when>
								<c:when test="${teamB.start eq 'Y' }">
									<input type="submit" class="btn btn btn-warning" value="준비해제">
								</c:when>
							</c:choose>
						</form>
					</c:if>
				</c:if>
			</div>
			<div align="right">
            <br> 종료날짜 : ${bet.endDate} <br> 상태 : ${bet.state} <br> 내기장 아이디 : ${bet.betOwner }<a onclick="showPopup2();">[신고]</a> <br>
            <br> 내기 방식 : BetOf${bet.betWay } <br> 포인트 방식 : ${bet.pointCheck } <br> <c:if test="${bet.pointCheck eq 'LOCK' }">내기포인트 : ${bet.point }</c:if>

         </div>

			<div id="main" class="clearfix">
				<div id="page">
					<h3 class="page-title" align="center">${bet.content }</h3><br>
					<form action="betVote.do" method="post">
						<input type="hidden" name="betId" value="${bet.betId }">
						<table>
							<tr>
								<td><img src="resources/images/betofall.jpg"
									alt="Banner Image 1" /><br> <br> <c:if
										test="${bet.state eq '진행'}">
										<c:if
											test="${userId eq teamB.leader.userId or userId eq teamA.leader.userId}">
											<input type="radio" name="vote" value="A">Team A</c:if>
									</c:if></td>
								<td><img src="resources/images/vs.png" alt="Banner Image 1" /></td>
								<td><img src="resources/images/betofall.jpg"
									alt="Banner Image 1" /><br> <br> <c:if
										test="${bet.state eq '진행'}">
										<c:if
											test="${userId eq teamB.leader.userId or userId eq teamA.leader.userId}">
											<input type="radio" name="vote" value="B">Team B</c:if>
									</c:if></td>
							</tr>
						</table>
						<c:if test="${bet.state eq '진행'}">
							<c:if
								test="${userId eq teamB.leader.userId or userId eq teamA.leader.userId}">
								<div align="center">
									<button type="submit" class="btn btn btn-warning">투표하기</button>
								</div>
							</c:if>
						</c:if>
					</form>
						<c:if test="${bet.state eq '종료'}">
						WINNER TEAM : 
						<c:choose>
								<c:when test="${teamA.result eq 'WIN' }">
									 A
								</c:when>
								<c:when test="${teamB.result eq 'WIN' }">
									 B
								</c:when>
								<c:otherwise>
									 DRAW
								</c:otherwise>
							</c:choose>
						</c:if>
						<br>
						TEAM A :
						<c:forEach var="a" items="${teamA.players }">
						
						&nbsp;${a.userId }&nbsp;(${a.point }&nbsp;Point) <c:if test="${userId eq bet.betOwner and bet.state eq '대기' or userId eq teamA.leader.userId and bet.state eq '대기'}">
						<a href="deleteplayerByTeamA.do?betId=${bet.betId }&userId=${a.userId }&betWay=${bet.betWay}">[X]</a></c:if>,
						
						</c:forEach>
						<br> TEAM B :
						<c:forEach var="p" items="${teamB.players }">
						
						&nbsp;${p.userId }&nbsp;(${p.point }&nbsp;Point) <c:if test="${userId eq bet.betOwner and bet.state eq '대기' or userId eq teamB.leader.userId and bet.state eq '대기'}">
						<a href="deleteplayerByTeamA.do?betId=${bet.betId }&userId=${p.userId }&betWay=${bet.betWay}">[X]</a></c:if>,
						
						</c:forEach>
						
						
						

					<c:forEach var="comment" items="${bet.comments }">
						<table class="table" style="font-size: 13px; padding: 20px;">
							<tr>
								<td><strong>${comment.userId }</strong></td>
								<td class="text-right">${comment.regDate }<a
									class="glyphicon glyphicon-trash"
									href="removeComment.do?betId=${bet.betId} &commentId=${comment.commentId}"></a>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p class="txt">${comment.content }</p>
								</td>
							</tr>
						</table>
					</c:forEach>

				</div>
			</div>
			<!-- // end #content -->
		</div>

		<c:forEach var="comment" items="${article.comments }">
			<table class="table" style="font-size: 13px; padding: 20px;">
				<tr>
					<td><strong>${comment.nickname }</strong></td>
					<td class="text-right">${comment.commentDate }<a
						class="glyphicon glyphicon-trash"
						href="removeComment.do?betId=${bet.betId} &commentId=${comment.commentId}"></a>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<p class="txt">${comment.comments }</p>
					</td>
				</tr>
			</table>
		</c:forEach>

		<div class="panel-footer">
			<div class="write_area">
				<form action="registComment.do" method="post">
					<input type="hidden" name="betId" value="${bet.betId }">
					<textarea class="input_write_comment" name="comments"
						placeholder="댓글쓰기"></textarea>
					<input type="submit" class="comment_submit" value="전송">
				</form>
			</div>
		</div>
<script type="text/javascript">
$('.btn3').click(function(){
	if (document.getElementById("pointBet").value == "") {
         alert("포인트를 입력해주세요");
	}else if($(":radio[name=" +  $(teamName).attr("name") + "]:checked").length==0){
		alert("팀을 선택해주세요");
	}else
		   document.sub1.submit();
	})
</script>



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
		<!-- // end #content -->
	</div>
