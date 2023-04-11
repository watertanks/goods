<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/_inc/adminHead.jsp" %>
<link href="/css/init.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">
<%
request.setCharacterEncoding("utf-8");

long newMember = (long)request.getAttribute("newMemberCnt");
long allMember = (long)request.getAttribute("allMemberCnt");
%>
<style>
.main_page{ margin:0 auto;
	width:900px; border: 1px solid #000; display:flex; flex-wrap: wrap;
	
}
.left{
	width:450px;
}
.right{
	width:450px;
}

</style>
<div class="main_page" text-align="center">
	<div class="left">
		<div>
			<h2>회원수</h2>
			<h4>신규회원 : [ <%=newMember %> ] 명</h4>
			<h4>전체회원 : [ <%=allMember %> ] 명</h4>
		</div>
		<div>
			<div></div>
			<div></div>
		</div>
	</div>
	<div class="right">
		<div>
			<div>
				<h2>전일매출</h2>
				<p>000000원</p>
			</div>
		</div>
		<div>
			<h2>Q&A</h2>
			<h4>답변 미완료 [0] 개</h4>
		</div>
		<div>
			<h2>굿즈판매량 순위</h2>
			<p>BTS</p><span>00000000원</span>
		</div>
	</div>
</div>
</body>
</html>