package com.goods.svc;

import com.goods.vo.*;
import com.goods.vo.LoginInfo;
import com.goods.vo.MemberInfo;

public interface LoginSvc {
	
	public MemberInfo getLoginInfo (LoginInfo li) throws Exception;
	
	public int chkEmail(String email) throws Exception;
	
	public MemberInfo kakaoLogin(String email) throws Exception;
}
