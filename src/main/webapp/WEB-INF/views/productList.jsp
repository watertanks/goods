<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "java.time.*"%>
<%@ page import ="com.goods.vo.*" %>
<%@ include file = "/WEB-INF/views/_inc/head.jsp" %>
<link href="/css/init.css" rel="stylesheet">
<%

request.setCharacterEncoding("utf-8");
//PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
//ArrayList<ProductInfo> productList = (ArrayList<ProductInfo>)request.getAttribute("productList");
//ArrayList<ArtistCode> bigList = (ArrayList<ArtistCode>)request.getAttribute("bigList");
//ArrayList<ArtistProduct> smallList = (ArrayList<ArtistProduct>)request.getAttribute("smallList");

ArrayList<ProductInfo> productList = (ArrayList<ProductInfo>)request.getAttribute("pi");
//ArrayList<ArtistCode> ac = (ArrayList<ArtistCode>)request.getAttribute("ac");
//ArrayList<ArtistProduct> ap = (ArrayList<ArtistProduct>)request.getAttribute("ap");

long allCount = (long) request.getAttribute("allCount");
long allPage = (long) request.getAttribute("allPage");
long bSize = (long) request.getAttribute("bSize");
long cPage = (long) request.getAttribute("cPage");


String orderby = request.getParameter("orderby");
if(orderby==null){ orderby = ""; } 
String key = request.getParameter("key");
if(key==null){ key = ""; } 
else{ key = key.trim().toLowerCase(); }
String schtype = request.getParameter("schtype");
if(schtype==null){ schtype = ""; } 
String ac = request.getParameter("ac");
if(ac == null || ac.equals("")) ac = "";
String ap = request.getParameter("ac");
if(ap == null || ap.equals("")) ap = "";

//String query = "&ac="+ac+"&ap="+ap+"&orderby="+orderby+"&key="+key+"&schtype="+schtype; //쿼리스트링

/*
페이지 정보
PageInfo
-현재 페이지: cpage
-페이지당 상품개수: psize
-페이징영역에 표시될 페이지수: bsize
-현재 로드된 레코드(상품)개수: rcnt
-전체 페이지 개수: pcnt
-시작 페이지: spage

쿼리 스트링
-대분류: ac
-소뷴류: ap
-orderby: 정렬조건  
-a: 기본값(등록역순) b: 판매량 c: 낮은가격순 d: 높은가격 
-keyword: 검색어
-schtype: 검색조건(전체: n, 아티스트: a, 상품: p)

상품정보
productInfo 상품정보
bigList 상품 대분류(아티스트)
smallList 상품 소분류

*/

%>
<style>
main{max-width: 100%;
    margin: 0 auto;
    position: relative;
    top: 220px;
}
.header-sch > select {
padding:0;
}
</style>
<main>
	<div class="wrapper">
		<form name = "schForm" id="schForm" >
			<select name = "orderby">
				<option value = "a" <%if(orderby!=null && orderby.equals("a")){%> selected = "selected" <%} %>>최신순</option>
				<option value = "b" <%if(orderby!=null && orderby.equals("b")){%> selected = "selected" <%} %>>인기순</option>
				<option value = "c" <%if(orderby!=null && orderby.equals("c")){%> selected = "selected" <%} %>>낮은가격순</option>
				<option value = "d" <%if(orderby!=null && orderby.equals("d")){%> selected = "selected" <%} %>>높은가격순</option>
			</select>
		
			<select name = "schtype" >
				<option value = "n" <%if(schtype!=null && schtype.equals("n")){%> selected = "selected" <%} %>>카테고리</option>
				<option value = "a" <%if(schtype!=null && schtype.equals("a")){%> selected = "selected" <%} %>>아티스트</option>
				<option value = "p" <%if(schtype!=null && schtype.equals("p")){%> selected = "selected" <%} %>>상품명</option>
			</select>
			
			<input type = "search" id = "key" name = "key" value = "<%=key %>" class= "search">
			
			<input type="submit"class = "button" value="검색" />
			<button onclick = "init();" class = "button">초기화</button>
		</form>
		
		<script type="text/javascript">
			function init(){
				let schForm = document.schForm;
				if(schForm.ac!=null){ schForm.ac.value = ''; }
				if(schForm.ap!=null){ schForm.ap.value = ''; }
				schForm.orderby.value = '';
				schForm.schtype.value = '';
				schForm.key.value = '';
			}
		</script>
		
		<%if(productList.size()==0){%>
		<p>검색 결과가 없습니다</p>
		<%}else{%>
		
		<ul class="product_list">
		
		<%
		ProductInfo pi = null;
		
		for(int i = 0;i<productList.size();i++){
			pi = productList.get(i);
			int realPrice = pi.getPi_price();
			if(pi.getPi_dc()>0){
				realPrice = realPrice * (100-pi.getPi_dc())/100;
			}
		%>
			<li>
		<%
		char special = pi.getPi_special().charAt(0);
		if(special == 'n'){
			out.print("<p class='new'>NEW</p>");
		}
		else if(special == 'h'){
			out.print("<p class='hot'>HOT</p>");
		}
		else if(special == 'm'){
			out.print("<p class='md'>MD추천</p>");
		}
		%>
			<figure>
				<a href="/pd?piid=<%=pi.getPi_id()%>">
				<img src="<%="/img/product/"+pi.getPi_img1()%>">
				</a>
			</figure>
			<div>
				<p>
					<span class="pdt_name"><%=pi.getPi_name() %></span><br> 
					<span><%=pi.getAc_name_e() %></span><br>
					<span><%=realPrice %>원 &nbsp;&nbsp;
					<%if(pi.getPi_dc()>0) {%><%=pi.getPi_dc()%>%할인<%} %>
					</span><br>
				</p>
				<a href="cart_view?piid=<%=pi.getPi_id()%>"><i class="bi bi-cart"></i></a>
			</div> 
		</li>
	
	<% }%>
			
		</ul>
		<div class="paging" style="text-align:center;">
    <%
    if(cPage == 1){  
    %>
    <span>처음</span>
    <%} else { %>
	    <a href="/pl?page=1&orderby=<%=orderby%>&schtype=<%=schtype%>&key=<%=key%>&ac=<%=ac%>">처음</a>
	<%}%>
	<%
    for(int i=0; i < bSize; i++){
    	if(allPage <= bSize){
    		bSize = allPage;
    	}
    %>
	    <a href="/pl?page=<%=i+1%>&orderby=<%=orderby%>&schtype=<%=schtype%>&key=<%=key%>&ac=<%=ac%>"><%=i+1 %></a>
	    <%} %>
	    <%if(cPage == allPage) {%>
	    	<span>마지막</span>
	    <%} else{ %>
	    <a href="/pl?page=<%=bSize%>&orderby=<%=orderby%>&schtype=<%=schtype%>&key=<%=key%>&ac=<%=ac%>">마지막</a>
	    <%} %>
    </div>
	<% }%>
	</div>
	
</main>
<style>

.menu {
	display: flex;
	flex-wrap: wrap;
	margin: 30px 0;
	width: 100%;
	text-align: center;
	justify-content: space-between;
}
form{
	width: 100%;
}
.menu a, form select{
	border: 1px solid black;
	padding: 10px;
	width: 10%;
	min-width: 120px;
}
form .search{
	width: 30%;
	border: 1px solid black;
	padding: 10px;
	min-width: 120px;
	margin-left: 20px;
}
.product_list {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	margin: 20px 0;
}

.product_list li {
	width: 25%;
	padding: 10px;
	display: flex;
	flex-wrap: wrap;
	position: relative;
	min-width: 250px;
}
.product_list div{
	width: 100%;
	padding: 5px;
	display: flex;
	flex-wrap: wrap;
}
.product_list li div p{
	width: 80%;
}
.bi-cart{
	font-size: 40px;
}

.pdt_name {
	font-size: 18px;
}

.new {
	width: 50px;
	font-size: 20px;
	text-align: center;
	position: absolute;
	left: 10px;
	top: 10px;
	background-color: yellow;
}

.hot {
	width: 50px;
	font-size: 20px;
	text-align: center;
	position: absolute;
	left: 10px;
	top: 10px;
	background-color: red;
	color: white;
}

.md {
	width: 50px;
	font-size: 20px;
	text-align: center;
	position: absolute;
	left: 10px;
	top: 10px;
	background-color: blue;
	color: white;
}

.paging {
	width: 100%;
}
.paging a, .paging p{
	display: inline-block;
	 width: 50px;
}
</style>
