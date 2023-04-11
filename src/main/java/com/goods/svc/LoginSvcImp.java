package com.goods.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.mapper.MemberMapper;
import com.goods.svc.LoginSvc;
import com.goods.vo.LoginInfo;
import com.goods.vo.MemberInfo;

@Service
public class LoginSvcImp implements LoginSvc {
	
	@Autowired
	private MemberMapper memberMapper;

	
	
	
	@Override
	public MemberInfo getLoginInfo(LoginInfo li) throws Exception{
		
		MemberInfo loginInfo = memberMapper.loginProc(li);
		//System.out.println(loginInfo);
		return loginInfo;
	}
	
	@Override
	public int chkEmail(String email) throws Exception{
		int result = memberMapper.emailChk(email);
		return result;
	}
	
	@Override
	public MemberInfo kakaoLogin(String email) throws Exception{
		MemberInfo loginInfo = memberMapper.kakaoLogin(email);
		return loginInfo;
	}
}
