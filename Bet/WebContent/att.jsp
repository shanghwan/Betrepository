<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>attedance</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="resources/css/style2.css" rel="stylesheet" type="text/css" />
<!--[if IE]><link href="resources/css/style-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="resources/js/site.js"></script>
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
				<h1 class="page-title">Attendance</h1>
			</div>
			<!-- // end #banner -->
			<div id="main" class="clearfix">
				<div id="content">
			
			<%
Calendar cal = Calendar.getInstance();
 
String strYear = request.getParameter("year");
String strMonth = request.getParameter("month");
 
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int date = cal.get(Calendar.DATE);
 
if(strYear != null)
{
  year = Integer.parseInt(strYear);
  month = Integer.parseInt(strMonth);
 
}else{
 
}
//년도/월 셋팅
cal.set(year, month, 1);
 
int startDay = cal.getMinimum(java.util.Calendar.DATE);
int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
int newLine = 0;
 
//오늘 날짜 저장.
Calendar todayCal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
 
 
%>
					

												
 
</HEAD>
<BODY>

 

<!--날짜 네비게이션  -->
<table width="100%" border="0" cellspacing="1" cellpadding="1" id="KOO" bgcolor="#F3F9D7" style="border:1px solid #CED99C">
 
<tr>
<td height="60">
 
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
             <td height="10">
             </td>
       </tr>
      
       <tr>
             <td align="center" >
                    <a href="<c:url value='/CalendarExam2.jsp' />?year=<%=year-1%>&amp;month=<%=month%>" target="_self">
                           <b>&lt;&lt;</b><!-- 이전해 -->
                    </a>
                    <%if(month > 0 ){ %>
                    <a href="<c:url value='/CalendarExam2.jsp' />?year=<%=year%>&amp;month=<%=month-1%>" target="_self">
                           <b>&lt;</b><!-- 이전달 -->
                    </a>
                    <%} else {%>
                           <b>&lt;</b>
                    <%} %>
                    &nbsp;&nbsp;
                    <%=year%>년
                   
                    <%=month+1%>월
                    &nbsp;&nbsp;
                    <%if(month < 11 ){ %>
                    <a href="<c:url value='/CalendarExam2.jsp' />?year=<%=year%>&amp;month=<%=month+1%>" target="_self">
                           <!-- 다음달 --><b>&gt;</b>
                    </a>
                    <%}else{%>
                           <b>&gt;</b>
                    <%} %>
                    <a href="<c:url value='/CalendarExam2.jsp' />?year=<%=year+1%>&amp;month=<%=month%>" target="_self">
                           <!-- 다음해 --><b>&gt;&gt;</b>
                    </a>
             </td>
       </tr>
       </table>
 
</td>
</tr>
</table>
<br>
<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
<THEAD>
<TR bgcolor="#CECECE">
       <TD width='100px'>
       <DIV align="center"><font color="red">일</font></DIV>
       </TD>
       <TD width='100px'>
       <DIV align="center">월</DIV>
       </TD>
       <TD width='100px'>
       <DIV align="center">화</DIV>
       </TD>
       <TD width='100px'>
       <DIV align="center">수</DIV>
       </TD>
       <TD width='100px'>
       <DIV align="center">목</DIV>
       </TD>
       <TD width='100px'>
       <DIV align="center">금</DIV>
       </TD>
       <TD width='100px'>
       <DIV align="center"><font color="#529dbc">토</font></DIV>
       </TD>
</TR>
</THEAD>
<TBODY>
<TR>
<center><a href="attendance.do" onclick="{$action_attend}"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/calendar/btn_attend.gif" alt="출석체크" /></a></center>
<%
 
//처음 빈공란 표시
for(int index = 1; index < start ; index++ )
{
  out.println("<TD >&nbsp;</TD>");
  newLine++;
}
 
for(int index = 1; index <= endDay; index++)
{
       String color = "";
 
       if(newLine == 0){          color = "RED";
       }else if(newLine == 6){    color = "#529dbc";
       }else{                     color = "BLACK"; };
 
       String sUseDate = Integer.toString(year); 
       sUseDate += Integer.toString(month+1).length() == 1 ? "0" + Integer.toString(month+1) : Integer.toString(month+1);
       sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);
 
       int iUseDate = Integer.parseInt(sUseDate);
      
      
       String backColor = "#EFEFEF";
       if(iUseDate == intToday ) {
             backColor = "#c9c9c9";
       }
       out.println("<TD valign='top' align='left' height='92px' bgcolor='"+backColor+"' nowrap>");
       %>
       <font color='<%=color%>'>
             <%=index %>
       </font>
 
       <%
      
       out.println("<BR>");
       out.println(iUseDate);
       out.println("<BR>");
      
      
       //기능 제거 
       out.println("</TD>");
       newLine++;
 
       if(newLine == 7)
       {
         out.println("</TR>");
         if(index <= endDay)
         {
           out.println("<TR>");
         }
         newLine=0;
       }
}
//마지막 공란 LOOP
while(newLine > 0 && newLine < 7)
{
  out.println("<TD>&nbsp;</TD>");
  newLine++;
}
%>



				</div>
				<!-- // end #content -->
				
			</div>
			
			<!-- // end #footer -->
		</div>
		
		<c:choose>
					<c:when test="${loginUser eq null }">
						<div id="sidebar">
							<div class="widget widget-search">
								<h2>Login</h2>
								<div class="contentarea" align="center">
									<form action="login.do" method="post">
										&nbsp;&nbsp;ID : <input type="text" name="userId"
											placeholder="아이디" size="12"></input><br /> PW : <input
											type="password" name="password" placeholder="패스워드" size="12"></input><br></br>
										<button type="submit" class="btn btn btn-warning">로그인</button>
										<a href="signUp.jsp"><button type="button"
												class="btn btn btn-warning">회원 가입</button></a>

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
										<label>${loginUser.name }님 환영합니다.</label><br>
										<br> <label>포인트 : ${loginUser.point }p</label> <br></br>
										<button type="submit" class="btn btn btn-warning">logout</button>
										<a href="#"><button type="button"
												class="btn btn btn-warning">MyPage</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
		<!-- // end #container -->
	</div>
	<!-- // end #wrapper -->