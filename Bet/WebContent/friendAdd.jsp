<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Project Description" />
<meta name="keywords" content="Project Keywords" />
<title>회원추가</title>
<style>
.green_window {
   display: inline-block;
   width: 366px;
   height: 34px;
   border: 3px solid #2db400;
   background: white;
}

.input_text {
   width: 348px;
   height: 21px;
   margin: 6px 0 0 9px;
   border: 0;
   line-height: 21px;
   font-weight: bold;
   font-size: 16px;
   outline: none;
}

.sch_smit {
   width: 54px;
   height: 40px;
   margin: 0;
   border: 0;
   vertical-align: top;
   background: #22B600;
   color: white;
   font-weight: bold;
   border-radius: 1px;
   cursor: pointer;
}

.sch_smit:hover {
   background: #56C82C;
}
</style>

<script type="text/javascript">
function javascript(){
	opener.open('friendList.do','_self').close();
	window.open("about:blank","_self").close();
}
</script>
</head>
<body>

   <form action="findUserId.do?friendId=${friendId }" method="post">
      <span class="green_window"> 
      <input type="text" class="input_text" name="userId" placeholder="아이디를 입력하세요." />
      </span>
      <button type="submit" class="sch_smit">검색</button>
   </form>

   <br>
   <c:choose>
      <c:when test="${user ne null }">
         <table>
            <colgroup>
               <col width="90" />
               <col width="*" />
            </colgroup>
            <tr align="center">
               <td>아이디</td>
               <td>이름</td>
            </tr>
            <c:if test="${userId ne user.userId }">
            <tr align="center">
               <td>${user.userId }</td>
               <td>${user.name }</td>
               <td align="right"><a href="friend.do?friendId=${user.userId }"><button type="button" onclick="javascript()">친구추가</button></a>
            </tr>
            </c:if>
         </table>
      </c:when>
      
   <c:otherwise>
   <table>
      <colgroup>
         <col width="90" />
         <col width="*" />
      </colgroup>
      <tr align="center">
         <td>아이디</td>
         <td>이름</td>
      </tr>

      <%-- <c:forEach items="${list }" var="list">
         <tr align="center">
            <td>${list }</td>
            <td><a href="deleteinviteByuserId.do?userId=${list }&betId=${betId}"><button type="button">X</button></a></td>
         </tr>
      </c:forEach> --%>
   </table>
   </c:otherwise>
</c:choose>
</body>
</html>