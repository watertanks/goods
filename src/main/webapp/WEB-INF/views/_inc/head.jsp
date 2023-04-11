<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.net.*" %>
<%@ page import = "java.time.*" %>
<%@ page import = "com.goods.vo.*" %>

<%! 
public String getUserRequest(String req){
	return req.trim().replace("<", "&lt").replace("'", "''");
}
%>
<%
MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
boolean isLogin = false;
if (loginInfo != null)	isLogin = true;
// 로그인 여부를 판단할 변수 isLogin 생성
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta property="og:url"                content="https://watertanks.github.io/goods/" />
    <meta property="og:type"               content="website" />
    <meta property="og:title"              content="굿즈" />
    <meta property="og:description"        content="굿즈 " />
    <meta property="twitter:url"                content="http://www.nytimes.com/2015/02/19/arts/international/when-great-minds-dont-think-alike.html" />
    <meta property="twitter:card"               content="summary" />
    <meta property="twitter:site"               content="굿즈" />
    <meta property="twitter:title"              content="굿즈" />
    <meta property="twitter:description"        content="굿즈 " />
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js" ></script>
	<link href="/css/common.css" rel="stylesheet" type="text/css" >
</head>
<style>


.header-mini-1rd div {
    border: 0px solid #000;
    padding: 5px;
    text-align: center;
}
.header-3rd { display: flex; justify-content: flex-end;}
</style>
<script>
    document.addEventListener('scroll',function(){
        const scr = document.documentElement.scrollTop;
        if(scr > 10){
            $('#header').change().hide();
            $('#header-mini').change().show();
        } else if(scr <= 9){
            $('#header').change().show();
            $('#header-mini').change().hide();
        }
    });

    /*
    const mTrigger = document.querySelector(`.trigger-menu`)
        const mNav = document.querySelector(`.m-nav`)

        mTrigger.on('click', function(){
        	mNav.classList.toggle('active');
            mTrigger.classList.toggle('active');
        }) 
        
        $('.m-service').on('click',function(){
            $('.m-service p').slideToggle();
        })
	*/





</script>
<body>
     <header class="header" id="header">
        <div class="header-main">
            
            <div class="header-middle">
                <div class="header-3rd" style="display: flex; justify-content: flex-end;">
                    
                    <div class="header-login">
<%if(!isLogin){ %>
                        <a href="/loginForm">로그인</a>
                        <a href="/joinForm">회원가입</a>
                        <a href="/find">아이디 및 비밀번호찾기</a>
<%} else if(isLogin) {%>
                  <a href="/logout">로그아웃</a>
                  <a href="/my_page">내 정보</a>
                  <a href="/order_list">주문내역</a>
<%} %>
                    </div>
                </div>
                <div class="header-2rd">
                    
                  
                    <div class="header-left">
                        <a href="/"><img src="/img/logo.png" alt="MainLogo"></a>
                    </div>
                </div>
                <div class="header-1st">
                    <div class="header-ctgr">
                        
                        <div>
                            <a href="/al?page=1">ARTIST</a>
                        </div>
                        <div>
                            <a href="/pl?page=1">MD</a>
                        </div>
                        <div>
                            <a href="event_list">EVENT</a>
                        </div>
                        <div>
                            <a href="">CUSTOMER</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <header class="header-mini" id="header-mini">
        <div class="header-3rd">
                    
            <div class="header-login">
<%if(!isLogin){ %>
            <a href="/loginForm">로그인</a>
            <a href="/joinForm">회원가입</a>
            <a href="">아이디 및 비밀번호찾기</a>
<%} else if(isLogin) {%>
            <a href="/logout">로그아웃</a>
            <a href="/">내 정보</a>
            <a href="/">주문내역</a>
<%} %>
            </div>
        </div>
        <div class="header-mini-1rd">
            <div class="logo">
               <a href = "/">
                      <img src="/img/logo.png">
                </a>
            </div>
            <div><a href="/al?page=1">ARTIST</a></div>
            <div><a href="/pl?page=1">MD</a></div>
            <div><a href="#">COMING SOON</a></div>
            <div><a href="#">EVENT</a></div>
            <div><a href="#">CUSTOMER</a></div>
           
        </divc>
    </header>



