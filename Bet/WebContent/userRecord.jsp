
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
					<c:when test="${loginUser eq null or userId eq 'admin' }">
						<div id="sidebar">
							<div class="widget widget-search">
								
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div id="sidebar">
							<div class="widget widget-search">
								<center><h2>${loginUser.name }님의 전적 (ง •̀_•́)ง</h2></center>
								<div class="contentarea" align="center">
										
										<label>${recordUser.total }전 ${recordUser.win }승 ${recordUser.draw }무  ${recordUser.lose }패
										<br> <br> <strong>승률 : ${recordUser.rate } %</strong> </label><br> <br> 
									
								</div>
								
							</div>
						</div>
					</c:otherwise>
				</c:choose>