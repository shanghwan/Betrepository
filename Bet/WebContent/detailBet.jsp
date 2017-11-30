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
</script>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">
					<a href="index.jsp"><h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">BetOf${bet.betWay }(${bet.betId })</h1>
			</div>
			<!-- // end #banner -->
			<a href="${ctx }/article/recommend.do?articleId=${article.articleId}"
				class="glyphicon glyphicon-cog pull-right" style="padding: 10px">추천</a>
			<a href="createBetReport.do?betId=${bet.betId }"
				class="glyphicon glyphicon-trash pull-right" style="padding: 10px">신고</a>
			<br>
			<c:if test="${userId eq bet.betOwner }">
				<div align="left">
					<button type="submit" class="btn btn btn-warning"
						onclick="showPopup();">초대하기</button>
				</div>
			</c:if>
			<c:forEach items="${list }" var="list">
			<c:if test="${userId eq list }">
			
			<div align="center">
						
					</div>
			
			
			
				<div align="left">
				<form action="gameJoin.do" method="post">
						<input type="hidden" name="betId" value="${bet.betId }">
						
							<input type="text" name="pointBet" placeholder="아이디 " size="12"></input>
							
							<input type="radio" name="teamName" value="A">Team A
                            <input type="radio" name="teamName" value="B">Team B
                            
							<button type="submit" class="btn btn btn-warning">참여하기</button>
						</form>
					
				</div>
			</c:if>
			</c:forEach>
			<div align="right">
				<br> 종료날짜 : ${bet.endDate} <br> 내기장 아이디 : ${bet.betOwner }
				<Br> 포인트 : ${bet.point } <br> 포인트방식 : ${bet.pointCheck } <br> 
					참여한 아이디 : <select> 
					<option selected>A팀</option>
					<option>옵션1</option>
					<option>옵션2</option>
					<option>옵션3</option>
				</select><select>
					<option selected>B팀</option>
					<option>옵션1</option>
					<option>옵션2</option>
					<option>옵션3</option>
				</select>
			</div>

			<div id="main" class="clearfix">
				<div id="page">
					<h1 class="page-title" align="center">${bet.title }</h1>
					<h3 class="page-title" align="left">${bet.content }</h3>
					<form action="#" method="post">
						<table>
							<tr>
								<td><img src="resources/images/betofall.jpg"
									alt="Banner Image 1" /><br> <br> <input type="radio"
									name="open" value="A">A</td>
								<td><img src="resources/images/vs.png" alt="Banner Image 1" /></td>
								<td><img src="resources/images/betofall.jpg"
									alt="Banner Image 1" /><br> <br> <input type="radio"
									name="open" value="B">B</td>
							</tr>
						</table>

						<div align="center">
							<button type="submit" class="btn btn btn-warning">투표하기</button>
						</div>

					</form>

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
								<td>
									<p class="txt">${comment.content }</p> <%-- 	
																	<p style="padding: 20px">${comment.contents }
										<c:if test="${comment.photo ne null }">
											<img src="/photo/123${comment.photo }">
										</c:if>
									</p> --%>
								</td>
							</tr>
						</table>
					</c:forEach>
					
					
					
					
					

					<div class="panel-footer">
						<div class="write_area">
							<form action="registComment.do" method="post">
								<input type="hidden" name="betId" value="${bet.betId }">
								<textarea class="input_write_comment" name="content"
									placeholder="댓글쓰기"></textarea>
								<div class="form-group">
									<label class="col-lg-2 control-label">이미지</label>

									<div class="col-lg-10">
										<input type="file" name="photo" class="form-control">
									</div>
								</div>
								<input type="submit" class="comment_submit" value="전송">


							</form>
						</div>
					</div>
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