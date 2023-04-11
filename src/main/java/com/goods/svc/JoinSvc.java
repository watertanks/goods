package com.goods.svc;

import com.goods.vo.*;

public interface JoinSvc {
	

	public int kakaoJoinSvc(MemberInfo mi) throws Exception;
	
	public int nickChk(String unick) throws Exception;
	
	public int idChk(String uid) throws Exception;
	
	public int emailChkJoin(String email) throws Exception;
	
	public int memberIn(MemberInfo mi) throws Exception;
	
	public int memberAddrIn(MemberAddr ma) throws Exception;
	
	public int memberPointIn(MemberPoint mp) throws Exception;
}
