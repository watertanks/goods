package com.goods.ctrl;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.goods.svc.*;
import com.goods.vo.MemberAddr;
import com.goods.vo.MemberInfo;
import com.goods.vo.MemberPoint;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@RestController
public class JoinCtrl {
	
	@Autowired
	public JoinSvc joinSvc;
	
	
	
	@PostMapping("/kakaoJoin")
	public void doKakaoLogin(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value="email") String email,
			@RequestParam(value="gender", required=false) String gender,
			@RequestParam(value="birth", required=false) String birth,
			@RequestParam(value="nickname", required=false) String nickname) throws Exception {
		//System.out.println(email);
		//System.out.println(gender);
		//System.out.println(birth);
		//System.out.println(nickname);
		
		MemberInfo mi = new MemberInfo();
		
		mi.setMi_email(email);
		mi.setMi_gender(gender);
		mi.setMi_birth(birth);
		mi.setMi_nickname(nickname);
		mi.setMi_status("b");
		
		int result = joinSvc.kakaoJoinSvc(mi);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result != 2) {
			out.println("<script>");
			out.println("alert('회원가입실패\n다시시도해주세요.')");
			out.println("</script>");
			out.close();
		}
		out.println("회원가입을 진심으로 환영합니다.");
		out.close();
	}
	
	
	
	@PostMapping("/nickChk")
	public int nickChk(HttpServletResponse response ,HttpServletRequest request,
			@RequestParam(value="unick") String unick) throws Exception {
		int result = 0;
		//System.out.println(unick);
		result += joinSvc.nickChk(unick);
		//System.out.println("unick int : " + result);
		return result;
	}
	
	@PostMapping("/idChk")
	public int idChk(HttpServletResponse response ,HttpServletRequest request,
			@RequestParam(value="uid") String id) throws Exception {
		int result = 0;
		String uid = id.trim().toLowerCase();
		//System.out.println(uid);
		result += joinSvc.idChk(uid);
		//System.out.println("uid result : " + result);
		return result;
	}
	
	@PostMapping("/emailChkJoin")
	public int emailChk(HttpServletResponse response ,HttpServletRequest request,
			@RequestParam(value="e1") String e1,
			@RequestParam(value="e3") String e3) throws Exception {
		int result = 0;
		String email = e1.trim().toLowerCase() +"@"+ e3.trim().toLowerCase();
		//System.out.println(email);
		
		result += joinSvc.emailChkJoin(email);
		//System.out.println("emailchk result" + result);
		return result;
	}
	
	@PostMapping("/join")
	public void doJoin(HttpServletResponse response ,HttpServletRequest request,
		@RequestParam(value="mi_id") String id,
		@RequestParam(value="mi_pw") String pass,
		@RequestParam(value="mi_name") String name,
		@RequestParam(value="mi_nickname") String nickname,
		@RequestParam(value="mi_gender") String gender,
		@RequestParam(value="by") String by,
		@RequestParam(value="bm") String bm,
		@RequestParam(value="bd") String bd,
		@RequestParam(value="p1") String p1,
		@RequestParam(value="p2") String p2,
		@RequestParam(value="p3") String p3,
		@RequestParam(value="e1") String e1,
		@RequestParam(value="e2") String e2,
		@RequestParam(value="e3") String e3,
		@RequestParam(value="ma_zip") String zip,
		@RequestParam(value="ma_addr1") String addr1,
		@RequestParam(value="ma_addr2") String addr2 ) throws Exception{
		
		MemberInfo mi = new MemberInfo();
		
		mi.setMi_id(id);
		mi.setMi_pw(pass);
		mi.setMi_name(name);
		mi.setMi_nickname(nickname);
		mi.setMi_gender(gender);
		mi.setMi_birth(by+"-"+bm+"-"+bd);
		mi.setMi_email(e1.trim() + "@" + e3.trim().toLowerCase());
		mi.setMi_phone(p1+"-"+p2+"-"+p3);
		mi.setMi_point(1000);
		
		
		int result = 0;
		result += joinSvc.memberIn(mi);
		
		if(result == 1) {
			
			MemberAddr ma = new MemberAddr();
			
			ma.setMi_id(id);
			ma.setMa_name("기본주소");
			ma.setMa_rname(name);
			ma.setMa_phone(mi.getMi_phone());
			ma.setMa_zip(zip);
			ma.setMa_addr1(addr1);
			ma.setMa_addr2(addr2);
			
			result += joinSvc.memberAddrIn(ma);
		}
		if(result == 2) {	// 포인트 내역
			MemberPoint mp = new MemberPoint();
			
			mp.setMi_id(id);
			mp.setMp_point(1000);
			mp.setMp_desc("가입축하금");
			
			result += joinSvc.memberPointIn(mp);
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result != 3) {
			out.println("<script>");
			out.println("alert('회원가입실패\n다시시도해주세요.')");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('회원가입을 진심으로 환영합니다.')");
			out.println("location.replace('/');");
			out.println("</script>");
			out.close();
		}
		
		
		
	}
}
