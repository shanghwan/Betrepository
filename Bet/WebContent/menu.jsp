
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
					<c:when test="${loginUser eq null || loginUser.userId eq 'admin'}">
						<ul id="nav">
							<li><a href="Betlist.do?betWay=one">BetOfOne</a></li>
							<li><a href="Betlist.do?betWay=all">BetOfAll</a></li>
							<li><a href="Betlist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetlistByState.do?state=대기">preseason game</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul id="nav">
							<li><a href="Betlist.do?betWay=one">BetOfOne</a></li>
							<li><a href="Betlist.do?betWay=all">BetOfAll</a></li>
							<li><a href="Betlist.do?betWay=team">BetOfTeam</a></li>
							<li><a href="BetlistByState.do?state=대기">Preseason game</a></li>
							<li><a href="#">Rank</a></li>
							<li><a href="attendance.jsp">Attendance</a></li>
						</ul>
					</c:otherwise>
				</c:choose>