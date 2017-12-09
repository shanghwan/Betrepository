
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${loginUser eq null }">
		<div id="sidebar">
			<div class="widget widget-search">
				<h2>Login</h2>
				<div class="contentarea" align="center">
					<form action="login.do" method="post" name="sub1">
						&nbsp;&nbsp;ID : <input type="text" name="userId" id="userId"
							placeholder="아이디 " size="12"></input><br /> PW : <input
							type="password" id="password" name="password" placeholder="패스워드" size="12"></input><br></br>
						<button type="button" class="btn btn btn-warning btn2" onclick="testAlertBox()"> 로그인 </button>
						<a href="signUp.jsp"><button type="button" class="btn btn btn-warning">회원 가입</button></a>
					
					</form>

				</div>
			</div>
		</div>
	</c:when>
	<c:when test="${loginUser.userId eq 'admin'}">
		<div id="sidebar">
			<div class="widget widget-search">
				<h2>회원</h2>
				<div class="contentarea" align="center">
					<form action="logout.do" method="post">
						<label>${loginUser.name }님 환영합니다.</label><br> <br>
						<label><a href="pointList.do">포인트</a>: ${loginUser.point }</label>
						<br></br>
						<button type="submit" class="btn btn btn-warning">logout</button>
						<a href="adminpage.do"><button type="button"
								class="btn btn btn-warning">admin Page</button></a>

					</form>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div id="sidebar">
			<div class="widget widget-search">
				<h2>회원</h2>
				<div class="contentarea" align="center">
					<form action="logout.do" method="post">
						<label>${loginUser.name }님 환영합니다.</label><br> <br> <label><a
							href="pointList.do">포인트</a> : ${loginUser.point }p</label> <br></br>
						<button type="submit" class="btn btn btn-warning">logout</button>
						<a href="mypage.jsp"><button type="button" class="btn btn btn-warning">MyPage</button></a>

					</form>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
$('.btn2').click(function(){
	if (document.getElementById("userId").value == "") {
         alert("아이디를 입력해주세요");
	}else if(document.getElementById("password").value == "") {
		alert("비밀번호를 입력해주세요");
	}else
		   document.sub1.submit();
	})
</script>
</body>
</html>


