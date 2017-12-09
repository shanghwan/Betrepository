<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>BetOfAll</title>
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
         <c:if test="${bet.betOwner eq userId or userId eq 'admin'}">
            <a
               href="deleteBetAllReport.do?target=${bet.betId }&userId=${userId}"
               class="glyphicon glyphicon-trash pull-right" style="padding: 10px">삭제</a>
         </c:if>
         <a class="glyphicon glyphicon-cog pull-right" style="padding: 10px"
            onclick="showPopup1();">신고</a> <br>
            
         <div align="center">
            <c:if test="${bet.state eq '대기' }">
               <c:if test="${userId eq bet.betOwner }">
               <a   href="startBetOfAll.do?betId=${bet.betId }"
               class="btn btn btn-warning">Game Start</a>
                  
               </c:if>
            </c:if>
         </div>   
            
         <div align="right">
            <br> 종료날짜 : ${bet.endDate} <br> 상태 : ${bet.state} <br>
            내기장 아이디 : ${bet.betOwner } <br> 내기 방식 : BetOf${bet.betWay } <br>
            포인트 방식 : ${bet.pointCheck } <br>
            <c:if test="${bet.pointCheck eq 'LOCK' }">내기포인트 : ${bet.point }</c:if>

         </div>

         <div id="main" class="clearfix">
            <div id="page">
               <h3 class="page-title" align="center">${bet.content }</h3>
            <br>
                              
               <c:if test="${bet.state eq '대기' }">
                  <c:if test="${userId eq bet.betOwner }">
                     <form action="ImageA.do" method="POST"
                     enctype="multipart/form-data">
                        <input type="hidden" name="betId" value="${bet.betId }">
                        <input type="file" name="photoA">
                        <button type="submit" value="올리기">A팀 사진올리기</button>
                     </form>
                  </c:if>   
                  
                  <c:if test="${userId eq bet.betOwner }">
                     <form action="ImageB.do" method="POST"
                     enctype="multipart/form-data">
                        <input type="hidden" name="betId" value="${bet.betId }">
                        <input type="file" name="photoB">
                        <button type="submit" value="올리기">B팀 사진올리기</button>
                  </form>
                  </c:if>   
               </c:if>            
                              
                              
                  <form action="gameJoin.do" method="post">
                     <input type="hidden" name="betId" value="${bet.betId }">
                     <input type="hidden" name="pointBet" value="${bet.point }">
                     <table>
                        <tr>
                           <td><td><img class="imgs" src="/images/${bet.photoA }" alt="이미지를 올려주세요" /><br><br>
                           <c:if test="${bet.state eq '진행'}">
                                 <input type="radio" name="teamName" value="A">A</c:if>
                           <td><img src="resources/images/vs.png" alt="Banner Image 1" /></td>
                           <td><img class="imgs" src="/images/${bet.photoB }" alt="이미지를 올려주세요" /> <br><br>
                           <c:if test="${bet.state eq '진행'}">
                            <input   type="radio" name="teamName" value="B">B<br></c:if></td>
                        </tr>
                     </table>
                     <c:if test="${bet.state eq '진행'}">
                     <div align="center">
                        <input type="submit" class="btn btn btn-warning" value="투표하기">
                     </div>
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
               <br> TEAM A :
               <c:forEach var="a" items="${teamA.players }">
                  &nbsp;${a.userId }&nbsp;(${a.point }&nbsp;Point) ,
                  </c:forEach>
               <br> TEAM B :
               <c:forEach var="p" items="${teamB.players }">
                  &nbsp;${p.userId }&nbsp;(${p.point }&nbsp;Point) ,
                  </c:forEach>


               <c:forEach var="clist" items="${bet.comments }">
                  <table class="table" style="font-size: 13px; padding: 20px;">
                     <tr>
                        <td>${clist.commentId }</td>
                        <td>${clist.userId }</td>
                        <td class="text-right">${clist.regDate }<a
                           class="glyphicon glyphicon-trash"
                           href="removeComment.do?betId=${bet.betId}&commentId=${clist.commentId}"></a>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <p class="txt">${clist.content }</p> <c:if
                              test="${clist.photo ne null }">
                              <img src="${clist.photo }">
                           </c:if>

                        </td>
                     </tr>
                  </table>
               </c:forEach>

               <div class="panel-footer">
                  <div class="write_area">
                     <form action="registComment.do" method="POST">
                        <input type="hidden" name="betId" value="${bet.betId }">
                        <textarea class="input_write_comment" name="content"
                           placeholder="댓글쓰기"></textarea>
                        <br> <br> <br>
                        <div class="form-group">
                           <div class="col-lg-10">
                              <input type="file" name="photo" class="form-control">
                           </div>
                        </div>
                        <input type="submit" class="comment_submit" value="작성">
                     </form>
                  </div>
               </div>
               <!-- // end #content -->
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