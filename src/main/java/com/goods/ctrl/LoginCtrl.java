package com.goods.ctrl;

import java.io.*;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goods.svc.LoginSvc;
import com.goods.svc.JoinSvc;
import com.goods.vo.LoginInfo;
import com.goods.vo.MemberInfo;
import com.goods.vo.*;

import jakarta.servlet.http.*;


@RestController
public class LoginCtrl {
	
	@Autowired
	private LoginSvc loginSvc;
	
	@Autowired
	private JoinSvc joinSvc;
	
	
	
	
	
	@PostMapping("/login")
	public void doLogin(HttpServletResponse response ,HttpServletRequest request, 
			@ModelAttribute LoginInfo requestData) throws Exception {
		
		String uid = requestData.getUid().trim().toLowerCase();
		String pw = requestData.getPw().trim();
		//String url = request.getParameter("url").replace('$', '&');
		
		LoginInfo li = new LoginInfo();
		li.setUid(uid);
		li.setPw(pw);
		
		MemberInfo loginInfo = loginSvc.getLoginInfo(li);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//System.out.println("ctrl에서 로그인인포" + loginInfo);
		
		if (loginInfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", loginInfo);
			//System.out.println(session);
			
			out.println("<script>");
			out.println("location.replace('/');");
			out.println("</script>");
			out.close();
			
		} else {
			out.println("<script>");
			out.println("alert('아이디 혹은 비밀번호가 틀렸습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
	}
	 
	// kakao login API로 접근 시 이메일 중복체크
	@PostMapping("/kakaoLogin/chkDup")
	public void chkDup(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value="email") String email,
			@RequestParam(value="gender", required=false) String gender,
			@RequestParam(value="birth", required=false) String birth,
			@RequestParam(value="nickname", required=false) String nickname) throws Exception{
		//System.out.println(email);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(email != null) {
			try {
				int result = loginSvc.chkEmail(email);
				//System.out.println("result : "+result);
				
				out.println(result);
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("카카오로그인 이메일 중복검사중 에러발생");
				out.close();
			}
		}
	}
	

	@PostMapping("/kakaoLogin")
	public void kakaoLogin(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value="email")String email) throws Exception {
		//System.out.println(email);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
			
		MemberInfo loginInfo = loginSvc.kakaoLogin(email);
		
		if (loginInfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", loginInfo);
			//System.out.println(session);
			
			out.println("<script>");
			out.println("location.replace('/');");
			out.println("</script>");
			out.close();
			
		} else {
			out.println("<script>");
			out.println("alert('비정상적인 접근입니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
	}
	
	
	
	
	
	
	
	
}
