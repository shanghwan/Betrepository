<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>회원가입</title>
<style>
/*   경고에 대한 style jQuery에서 사용*/
tr td.error input,tr td.error textarea,tr td.error label {
   background: red;
}
tr td p.error {
   margin: 0;
   color: red;
   font-weight: bold;
   margin-bottom: 1em;}
</style>

<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style2.css" rel="stylesheet" type="text/css" />
<!--[if IE]><link href="resources/css/style-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
<script type="text/javascript">
function passwordCheck() {
	var password = document.getElementById("password").value;
	var passwordok = document.getElementById("passwordok").value;
	
	if(passwordok == ""){
		document.getElementById("passwordokText").innerHTML = ""
	}else if(password != passwordok){
		document.getElementById("passwordokText").innerHTML = "불일치합니다"
		document.getElementById("passwordokText").style.color = "red"
	}else{
		document.getElementById("passwordokText").innerHTML = "일치합니다"
		document.getElementById("passwordokText").style.color = "blue"
	}
}
</script>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">
					<a href="main.do"><h1>내기의 神</h1></a>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">회원가입</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="page" align="center">
					<br>
					<form action="Userregist.do" method="post">
						<table>
							<tr>
								<th>ID</th>
								<td><input id="loginId" name="userId" class="form-control required validate" type="text" placeholder="ID를 입력해주세요." size="50"></td>
							</tr>
							<tr>
								<th>Password</th>
								<td><input id="password" name="password"
									class="form-control validate number" type="password" 
									placeholder="비밀번호를 입력해주세요." size="50"></td>
							</tr>
							<tr>
								<th>Password 확인</th>
								<td><input id="passwordok" name="passwordok"
									class="form-control" type="password" 
									placeholder="비밀번호를 입력해주세요." size="50" onkeyup="passwordCheck()">&nbsp;&nbsp;<output id="passwordokText" width="100"></output></td>
							</tr>
							<tr>
								<th>Name</th>
								<td><input id="name" name="name" class="form-control validate name"
									type="text"  placeholder="이름을 입력해주세요." size="50"></td>
							</tr>
						</table>
						<br>
						<div align="center">
							<input class="btn" type="reset" value="취소"> <input
								class="btn btn-success" type="submit" value="가입">
						</div>
					</form>
					<br>

				</div>
			</div>
			<!-- // end #main -->
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
</div></div>
<script type="text/javascript">
$("form").submit(function(){
    // 에러 초기화(추가로 붙는 내용 삭제)
    $("p.error").remove();
    $("dl dd").removeClass("error");
    
    // filter 메소드를 이용해 text, textarea 요소들 중에서 validate 클래스를 갖는 것만 찾는다.
    $(":text, textarea").filter(".validate").each(function() {
       //필수 항목 검사
       // this -> filter로 걸러진 text, textarea중에 하나
       $(this).filter(".required").each(function() {
          if($(this).val() == ""){
             $(this).before("<p class='error'>필수 항목 입니다. </p>");
          }
       });
       
       //연락처 검사
       $(this).filter(".number").each(function() {
    	   if($(this).val() == ""){
               $(this).before("<p class='error'>필수 항목 입니다. </p>");
               $(this).before("<p class='error'>4이상 입력해주세요. </p>");
            }
       });
       
       //메일 검사
       $(this).filter(".name").each(function() {
    	   if($(this).val() == ""){
               $(this).before("<p class='error'>필수 항목 입니다. </p>");
               $(this).before("<p class='error'>이름을 입력해주세요. </p>");
            }
       });
    });
    
    if($("p.error").length > 0){
       //에러가 발생했을 때 스크롤 이동
       $("html, body").animate({scrollTop : $("p.error.first").offset.top - 40}, "slow");
       //에러 항목에 대한 음영처리
       $("p.error").parent().addClass("error");
       return false;
    }
 });  
</script>
</body>

</html>