<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 <meta name="description" content="Project Description" />
 <meta name="keywords" content="Project Keywords" />
 <title>BetOfOne</title>
 <link href="resources/css/style5.css" rel="stylesheet" type="text/css" />
 <link href="resources/css/style4.css" rel="stylesheet" type="text/css" />
 <!--[if IE]><link href="resources/css/style-ie.css" rel="stylesheet" type="text/css" /><![endif]-->
 <script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
 <script type="text/javascript" src="resources/js/jquery.cycle.all.js"></script>
 <script type="text/javascript" src="resources/js/site.js"></script>
 <script>
 function display1(box){
 indivisual1.style.display = 'block';
 company1.style.display = 'none';
 }
 
 function display2(box){
 indivisual1.style.display = 'none';
 company1.style.display = 'block';
 }
 
 window.onload=display1
 </script>
 
 
 
 </head>
 <body>
 
    <form action="/Bet/registBet.do" method="POST">
          
                   <table>
                      <colgroup>
                         <col width="90" />
                         <col width="*" />
                         <col width="100" />
                         <col width="100" />
                         <col width="100" />
                      </colgroup>
 
                      <thead>
                         <tr>
                            <th>제목</th>
                            <td><input id="title" name="title" class="form-control"
                               type="text" placeholder="제목을 입력하세요." size="60"></td>
                         </tr>
                         <tr>
                            <th>내용</th>
                            <td align="left"><input id="content" name="content"
                               class="form-control" type="text" placeholder="내용을 입력하세요."
                               size="60"><br> <br></td>
                         </tr>
                         
                         <tr>
 
                            <th>포인트</th>
                            <td><input name="point" class="form-control" type="text"
                               placeholder="포인트을 입력해주세요." size="20"></td>
                         <tr>
                            <th>종료날짜</th>
                            <td><input id="endDate" name="endDate"
                               class="form-control" type="text" placeholder="YYMMDD"
                               size="50"></td>
                         </tr>
                         <tr>
                            <th>공개여부</th>
                            <td><input type="radio" name="openCheck" value="공개">공개
                               <input type="radio" name="openCheck" value="비공개">비공개
                               </td>
                         </tr>
                         
                         <tr>
                            <th>BetOf</th>
                            <td><input type="radio" name="betWay" onClick="display1()" value="one">One
                               <input type="radio" name="betWay" onClick="display1()" value="team">Team
                               <input type="radio" name="betWay" onclick="display2()" value="all">All
                               </td>
                         </tr>
                         
                        <tr id="indivisual1">
                            <th>포인트방식</th>
 
                            <td>
                               <input type="radio" name="pointCheck"  value="올인">올인
                               <input type="radio" name="pointCheck" value="자유">자유
                               <input type="radio" name="pointCheck" value="고정">고정
                               </td>
                         </tr>
                   </table>
             
          <div align="right">
             <button type="submit" class="btn btn btn-warning">내기생성</button>
          </div>
    </form>
 
 </body>
 </html>