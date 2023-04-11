package com.goods.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.goods.svc.AdminSvc;
import com.goods.vo.MemberInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AdminCtrl {
	
	@Autowired
	private AdminSvc adminSvc;
	
	
	@GetMapping("/admin")
	public String goAdminHome(HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		
		long newMemberCnt = adminSvc.getNewMemberCnt();
		long allMemberCnt = adminSvc.getAllMemberCnt();
		
		model.addAttribute("newMemberCnt", newMemberCnt);
		model.addAttribute("allMemberCnt", allMemberCnt);
		
		
		
		return "adminHome";
	}
}
