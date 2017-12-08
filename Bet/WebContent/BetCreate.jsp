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
<link href="resources/css/style5.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style4.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
</head>
<script>
	function display1(box) {
		indivisual1.style.display = 'block';
		company1.style.display = 'none';
	}

	function display2(box) {
		indivisual1.style.display = 'none';
		company1.style.display = 'block';
	}

	window.onload = display1
</script>
<body>
	<div id="wrapper">
		<div id="container">
			<div id="header" class="clearfix">
				<div id="logo">
					<a href="main.do"> <h1>내기의 神</h1></a>
					<p>what's up</p>
				</div>
				<%@ include file="menu.jsp"%>
			</div>
			<!-- // end #header -->
			<div id="banner">
				<h1 class="page-title">내기생성</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
					<div class="post">
						<div class="post-head">
						
							<form action="registBet.do" method="POST" name="sub3">
							<c:choose>
							<c:when test="${userId eq 'admin' }">
							<table>
									<colgroup>
										<col width="150" />
										<col width="100" />
									</colgroup>
									
									<thead>
										<tr>
											<th>제목<span style="color:red">(필수)</span></th>
											<td><input id="title2" name="title" class="form-control title validate"
												type="text" placeholder="제목을 입력하세요." size="60"></td>
										</tr>
										<tr>
											<th>내용<span style="color:red">(필수)</span></th>
											<td align="left"><input id="content2" name="content"
												class="form-control validate content" type="text" placeholder="내용을 입력하세요."
												size="60"><br> <br></td>
										</tr>

										<tr>

											<th>포인트<span style="color:red">(필수)</span></th>
											<td><input name="point" class="form-control" type="text"
												placeholder="포인트을 입력해주세요." size="20"></td>
										<tr>
											<th>종료날짜<span style="color:red">(필수)</span></th>
											<td><input id="endDate2" name="endDate"
												class="form-control validate endDate" type="Date" placeholder="YYMMDD"
												size="50"></td>
										</tr>
										
										<tr>
											<th>BetOf<span style="color:red">(필수)</span></th>
											<td><input type="radio" name="betWay validate All" onclick="display2()" value="All">All</td>
										</tr>
								</table>
							</c:when>
							<c:otherwise>
								<table>
									<colgroup>
										<col width="150" />
										<col width="100" />
									</colgroup>
									
									<thead>
										<tr>
											<th>제목<span style="color:red">(필수)</span></th>
											<td><input id="title" name="title" class="form-control validate title"
												type="text" placeholder="제목을 입력하세요." size="60"></td>
										</tr>
										<tr>
											<th>내용<span style="color:red">(필수)</span></th>
											<td align="left"><input id="content" name="content" class="form-control validate content" type="text" placeholder="내용을 입력하세요."
												size="60"><br> <br></td>
										</tr>

										<tr>

											<th>포인트<span style="color:red">(필수)</span></th>
											<td><input name="point" class="form-control" type="text"
												placeholder="포인트을 입력해주세요." size="20">&nbsp;(0~${loginUser.point }p)</td>
										<tr>
											<th>종료날짜<span style="color:red">(필수)</span></th>
											<td><input id="endDate" name="endDate"
												class="form-control validate endDate" type="Date" placeholder="YYMMDD" size="50"></td>
										</tr>
										
										<tr>
											<th>BetOf<span style="color:red">(필수)</span></th>
											<td><input type="radio" name="betWay" onClick="display1()" value="One" class="validate one team all" id="one">One(1vs1)
												<input type="radio" name="betWay" onClick="display1()" value="Team">Team(팀전)
												<input type="radio" name="betWay" onclick="display2()" value="All">All(혼자)</td>
										</tr>
										<tr>
											<th>포인트방식<span style="color:red">(필수)</span></th>
											<td id="indivisual1">
												<input type="radio" name="pointCheck"  value="ALLIN">올인 
												<input type="radio" name="pointCheck"  value="FREE">자유
												<input type="radio" name="pointCheck"  value="LOCK">고정</td>
										</tr>
										
								</table>
							</c:otherwise>
							</c:choose>
							<br>
								<div align="right">
									<button type="submit" class="btn btn btn-warning btn2">내기생성</button>
								</div>
							</form>
							
<script type="text/javascript">
$("form").submit(function(){
    // 에러 초기화(추가로 붙는 내용 삭제)
    $("p.error").remove();
    $("dl dd").removeClass("error");
    
    // filter 메소드를 이용해 text, textarea 요소들 중에서 validate 클래스를 갖는 것만 찾는다.
    $(":text, textarea").filter(".validate").each(function() {
       //필수 항목 검사
       // this -> filter로 걸러진 text, textarea중에 하나
       $(this).filter(".title").each(function() {
          if($(this).val() == ""){
             $(this).before("<p class='error'>필수 항목 입니다. </p>");
          }
       });
       
       //연락처 검사
       $(this).filter(".content").each(function() {
          if($(this).val() == ""){
             $(this).before("<p class='error'>필수 항목 입니다. </p>");
          }
       });
       
       //메일 검사
       $(this).filter(".endDate").each(function() {
    	   if($(this).val() == ""){
               $(this).before("<p class='error'>필수 항목 입니다. </p>");
            }
       });
       
       $(":radio").filter(".validate").each(function() {
           $(this).filter(".one").each(function() {
              if($(":radio[name=" +  $(this).attr("name") + "]:checked").length==0){
                 $(this).before("<p class='error'>필수 선택 항목입니다. </p>");
              }
           });
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

						</div>
					</div>
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
			</div>
		</div>
	</div>

</body>
</html>