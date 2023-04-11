<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.time.*"%>
<%@ page import="com.goods.vo.*"%>


<%
boolean isAdminLogin = false; //로그인 여부
AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo"); //로그인 정보
if(adminInfo == null){ 
	isAdminLogin = false;
} else{
	isAdminLogin = true;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<div class="admin_menu">
        <a href="member_list">회원관리</a>
        <a href="product_list">상품관리</a>
        <a href="admin_order_list">주문관리</a>
        <a href="artist_list">아티스트</a>
        <a href="#">출시예정</a>
        <a href="#">이벤트</a>
        <a href="#">고객센터</a>
        <a href="#">통계</a>
    </div>
    
    <div>
	<% if(!isAdminLogin){ %>
		<a href = "admin_login_form">관리자 로그인</a>
	<%}else{ %>
		<p>관리자 <%=adminInfo.getAi_id() %>님 로그인중</p>
		<a href = "logout.jsp">로그아웃</a>
	<%} %>
	</div>
	