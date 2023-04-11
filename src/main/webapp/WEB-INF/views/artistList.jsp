<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "java.time.*"%>
<%@ page import ="com.goods.vo.*" %>

<%@ include file = "/WEB-INF/views/_inc/head.jsp" %>

<%
request.setCharacterEncoding("utf-8");

ArrayList<ArtistCode> artistList = (ArrayList<ArtistCode>)request.getAttribute("artistList");


long allCount = (long) request.getAttribute("allCount");
long allPage = (long) request.getAttribute("allPage");
long bSize = (long) request.getAttribute("bSize");
long cPage = (long) request.getAttribute("cPage");

String orderby = (String) request.getAttribute("orderby");
String schtype = (String) request.getAttribute("schtype");
%>

<style>
li {list-style: none;}

main { transform: translateY(300px);  width: 70%;
    margin: 0 auto;}
.content_top {

}
.content_top > h2{
    font-size: 60px;
    text-align: center;
    color: #ddd;
    font-family: 'Merriweather', serif;
    font-family: 'Roboto Slab', serif;
}
.content_top > p {
    font-size: 15px;
}
.artistlist {
    padding-top: 1%;
    

}
.artistlist > ul{
   display: flex;
   flex-wrap: wrap;
   width:100%;
   

}
.artistlist > ul > li {
    padding: 0 2%;
    text-align: center;
    padding-top: 3%;
    width:25%;
}
.artistlist > ul > li> p > h3 {
  display: none;
}
.paging {
	width: 100%;
	text-align : center;
	margin-top:5%;
}
.paging a, .paging p{
	display: inline-block;
	 width: 50px;
}
</style>

    <main>
 
    <div class="content_top">
        <h2>ARTIST</h2>
        <p>
           <strong>총 [ <%=allCount%> ]팀의 아티스트가 있습니다. </strong>
        </p>

        <span name ="schForm" style="float:right;">
        
        <form name = "schForm" id="schForm" method="GET" action="/al?page=1">
            <select name = "orderby" id="orderby">
       		  	<option value = "a" <%if(orderby!=null && orderby.equals("a")){%> selected = "selected" <%} %>>업데이트 순</option>
				<option value = "b" <%if(orderby!=null && orderby.equals("b")){%> selected = "selected" <%} %>>가나다 순</option>
            </select>
            <input type="submit" value="검색" />
        </form>
     </span>
    </div>
 
    <div class = "artistlist">

        <ul class = "artistinfo">
<%

for(int i = 0; i < artistList.size(); i++) {
	ArtistCode ac = artistList.get(i);
	String KorName = ac.getAc_name_k();
	String EngName = ac.getAc_name_e();
	
%>
            <li >
            	<a href="/pl?page=1&ac=<%=ac.getAc_id()%>&key=<%=ac.getAc_name_k()%>&schtype=a">
               <img src="/img/artist/<%=ac.getAc_img() %>"></a>
				<p>
					<h3>
						<%=KorName %>
						<br>
					</h3><%=EngName %>
				</p>
            </li>
 
		
<%
}
%>	
	
        </ul>

    </div>
    
    <div class="paging" style="text-align:center;">
    <%
    if(cPage == 1){  
    %>
    <span>처음</span>
    <%} else { %>
	    <a href="/pl?page=1&orderby=<%=orderby%>" >처음</a>
	<%}%>
	<%
    for(int i=0; i < bSize; i++){
    	long pageNum = i + 1;
    	if(allPage <= bSize){
    		bSize = allPage;
    		
    	}
    %>
  	<%
  	if(orderby == null || orderby.equals("a")){
  		orderby = "a";
  	} else {
  		orderby = "b";
  	}
  	%>
	    <a href="/al?page=<%=pageNum%>&orderby=<%=orderby%>"><%=pageNum %></a>
	    <%} %>
	    <%if(cPage == allPage) {%>
	    	<span>마지막</span>
	    <%} else{ %>
	    <a href="/al?page=<%=bSize%>&orderby=<%=orderby%>">마지막</a>
	    <%} %>
	    
	   
    </div>
   
 <script>

 </script>
</main>
</body>
</html>
</body>
</html>