package com.goods.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goods.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeCtrl {
	
	@GetMapping("/")
	public String home() {return "home";}
	
	@GetMapping("/logout")
	public String logout() {return "logout";}
	
	@GetMapping("/joinForm")
	public String joinForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginInfo") != null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그아웃 후 진행해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return "join";
	}
	
	
	@GetMapping("/loginForm")
	public String goLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginInfo") != null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 로그인중 입니다.');");
			out.println("location.replace('/');");
			out.println("</script>");
			out.close();
		}
		return "login";
	}
	
	
}


