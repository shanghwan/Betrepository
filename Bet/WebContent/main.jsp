<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>내기의 신</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style3.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">				
					<a href="main.do"><img src="resources/images/bet-thor.jpg" /></a>
			</div>
			<br>
				<%@ include file="menu.jsp"%>
			</div>
			<br>
			<!-- // end #header -->
			<div id="banner">
				<div id="slider">
					<ul>
						<li><img src="resources/images/banners/moon.jpg"/>
						</li>
						<li><img src="resources/images/banners/3.jpg" />
						</li>
					</ul>
				</div>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="Betlist.do?betWay=all" title="Welcome to Dkntemplates">Welcome to
									BetOfAll</a>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb">
								<img src="resources/images/betOfAll.jpg"/>
							</div>
							<div class="post-summary">								
								<p>BetOfAll은 누구나 참여 할 수 있는 내기 방식입니다.  </p>								
								<p>1. 내기 생성시 BetOfAll을 선택해 방을 만들어주세요. </p>
								<p>2. 사진파일을 올린후에 GameStart를 눌러주세요.</p>
								<p>3. 기간 내 투표 수가 많은 쪽이 승자가 되어</p>
								<p>포인트를 얻을 수 있어요.</p>
								<p>* 10 포인트가 있으면 누구나 참여가 가능하며 </p>
								<p>  승리시 20포인트를 지급받을 수 있어요.  </p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="Betlist.do?betWay=one" title="Another Post Title">Welcome to BetOfOne</a>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb">
								<img src="resources/images/betOfOne.jpg" alt="" />
							</div>
							<div class="post-summary">								
								<p>BetOfOne은 팀 대 팀으로 여러 명이 참여하는 내기 방식입니다.</p>
								<p>1. BetOfTeam을 선택해 방을 만들어 회원을 초대해 주세요.</p>
								<p>2. 초대장을 수락 후, 포인트를 걸고 팀을 선택해요.</p>
								<p>3. 모두 준비완료를 누르면 내기 상태가 진행중으로 변경돼요.</p>
								<p>4. 투표를 통해 승자를 결정해주세요.</p>	
								<p>5. 승자는 걸려있는 포인트를 획득하게 되고,</p>
								<p>   패자는 포인트가 차감돼요.</p>													
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
					<div class="post">
						<div class="post-head">
							<h1>
								<a href="Betlist.do?betWay=team" title="Another Post Title">Welcome to BetOfTeam</a>
							</h1>
						</div>
						<div class="post-content clearfix">
							<div class="post-thumb">
								<img src="resources/images/betOfTeam.jpg" alt="Image" />
							</div>
							<div class="post-summary">
								<p>BetOfTeam은 1 대1로 참여하는 내기 방식입니다.</p>
								<p>1. BetOfOne을 선택해 방을 만들어 회원을 초대해 주세요.</p>
								<p>2. 초대장을 수락 후, 포인트를 걸고 팀을 선택해요.</p>
								<p>3. 모두 준비완료를 누르면 내기 상태가 진행중으로 변경돼요.</p>
								<p>4. 투표를 통해 승자를 결정해주세요.</p>	
								<p>5. 승자는 걸려있는 포인트를 획득하게 되고,</p>	
								<p>   패자는 포인트가 차감돼요.</p>
							</div>
						</div>
						<div class="post-utility"></div>
					</div>
				</div>
				<!-- // end #content -->
				<%@ include file="usermenu.jsp"%>
				<%@ include file="userRecord.jsp"%>
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


</body>
</html>