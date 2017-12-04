
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
					<c:when test="${loginUser eq null }">
						<div id="sidebar">
							<div class="widget widget-search">
								<h2>Login</h2>
								<div class="contentarea" align="center">
									<form action="login.do" method="post">
										&nbsp;&nbsp;ID : <input type="text" name="userId"
											placeholder="아이디 " size="12"></input><br /> PW : <input
											type="password" name="password" placeholder="패스워드" size="12"></input><br></br>
										<button type="submit" class="btn btn btn-warning">로그인</button>
										<a href="signUp.jsp"><button type="button"
												class="btn btn btn-warning">회원 가입</button></a>

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
										<label>${loginUser.name }님 환영합니다.</label><br>
										<br><label><a href="pointList.do">포인트</a>: ${loginUser.point }</label> <br></br>
										<button type="submit" class="btn btn btn-warning">logout</button>
										<a href="adminpage.jsp"><button type="button"
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
										<label>${loginUser.name }님 환영합니다.</label><br> <br> <label><a href="pointList.do">포인트</a>
											: ${loginUser.point }p</label> <br></br>
										<button type="submit" class="btn btn btn-warning">logout</button>
										<a href="mypage.jsp"><button type="button"
												class="btn btn btn-warning">MyPage</button></a>

									</form>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>