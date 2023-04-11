<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "_inc/head.jsp" %>
<%
request.setCharacterEncoding("utf-8");
String url = request.getParameter("url");	// 로그인 후 이동할 페이지 주소
if (url == null)	url = "/";
// 로그인 후 이동할 페이지 주소가 없으면 메인 화면으로 지정
%>
<link href="/css/loginForm.css" rel="stylesheet" type="text/css">
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<style>
main {	max-width: 1200px;
	margin: 0 auto;
	position: relative;
	top: 220px;
	}
</style>
<main>
    <article class="frmWrap">
        <h2>로그인</h2>
        <form name="frmlogin" id="frmlogin" method="post" >
        <input type="hidden" name="url" id="url" value="<%=url %>" />
        <input type="hidden" name="uid" id="uid" value="" />
        <input type="hidden" name="pw" id="pw" value="" />
            <p>ID <input type="text" name="textUid" id="textUid" value="test1" placeholder="아이디" /></p>
            <p>PW <input type="password" name="textPw" id="textPw" value="1234" placeholder="비밀번호"/></p>
            <span><button onclick="javascript:login();">로그인</button></span>
        </form>
        <p style=""><a href="#">회원가입</a>/<a href="#">아이디 & 비밀번호찾기</a></p>
        <div class="loginApi">
            <a class="btn btnkakao" id="kakao-login-btn"  href="javascript:kakaoLogin();" style="width:200px; margin:10px auto;">
            	<img style="width:200px;" src="/img/Kakao.png" alt="카카오">
            </a>
        </div>
    </article>
</main>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('cd1ada7163660ca63c0cbaeff479524f');
function kakaoLogin() {
    Kakao.Auth.login({
      scope:'profile_nickname, account_email, gender, birthday, talk_message',
      success: function(authObj){
         console.log(authObj);
         Kakao.API.request({
            url:'/v2/user/me',
            success: function(res){
               const account = res.kakao_account;
               var email = account.email;
           	   var gender = (account.gender.value='male')?'남':'여';
           		 var birth = "0000" + account.birthday;
           		 var nickname = account.profile.nickname;
           		 
           		 console.log(email+gender+birth+nickname);
           		 
           		console.log("첫번째"+gender);
               //console.log(account);
               //console.log(account.birthday);
               $.ajax({
                  type : "POST",
                  url : "/kakaoLogin/chkDup",
                  data : {
                     "email" : email,
                     "gender" : gender,
                     "birth" : birth,
                     "nickname" : nickname
                  },
                  success : function(chkRs){
                     if (chkRs == 0) { // 체크한 email로 가입한 기존회원이 없으면
                        $.ajax({
                           type : "POST",
                           url : "/kakaoJoin",
                           data : {
                              "email" : email,
                              "gender" : gender,
                              "birth" : "0000" + account.birthday,
                              "nickname" : account.profile.nickname
                           },
                           success : function(e){
                              alert(e);
                           }
                        });
                     } else if(chkRs != 0){ // uid와 동일한 기존 회원의 아이디가 있으면
                        createHiddenLoginForm(email);
                     }
                  },
                  fail: function(error) {
                        alert(error);
                  }
               });
             }
          });
      	}
   	});
}

function createHiddenLoginForm(email){
	
	var frm = document.createElement('form');
	frm.setAttribute('method', 'post');
	frm.setAttribute('action', '/kakaoLogin');
	
	var hiddenInput = document.createElement('input');
	hiddenInput.setAttribute('type', 'hidden');
	hiddenInput.setAttribute('name', 'email');
	hiddenInput.setAttribute('value', email);
	
	frm.appendChild(hiddenInput);
	document.body.appendChild(frm);
	frm.submit();
}

function login(){
	/*
	var textUid = $('#textUid').val();
	var textPw = $('#textPw').val();
	$.ajax({
		type : "POST",
		url : "/login",
		data : 
			{
			uid : textUid,
			pw  : textPw
			},
		success: function(data){
			alert(data);
		},
		fail: function(e){
			alert('통신 오류');
		}
	});
	*/
	
	var frm = $('#frmlogin');
	frm.attr('action', '/login');
	frm.attr('method', 'post');
	
	var textUid = $('#textUid').val();
	var textPw = $('#textPw').val();
	
	$('#uid').val(textUid);
	$('#pw').val(textPw);
	
	frm.submit();
}

</script>



