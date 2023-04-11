package com.goods.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.mapper.MemberMapper;
import com.goods.svc.JoinSvc;
import com.goods.vo.LoginInfo;
import com.goods.vo.MemberAddr;
import com.goods.vo.MemberInfo;
import com.goods.vo.MemberPoint;

@Service
public class JoinSvcImp implements JoinSvc{
	
	@Autowired
	private MemberMapper memberMapper;
	
	
	
	@Override
	public int kakaoJoinSvc (MemberInfo mi) throws Exception{
		int result = 0;
		String email = mi.getMi_email();
		
		result += memberMapper.kakaoJoin(mi);
		//System.out.println("kakaoJoin : "+result);
		if(result == 1) {
			MemberPoint mp = new MemberPoint();
			mp.setMi_id(email);
			mp.setMp_point(1000);
			mp.setMp_desc("가입축하금");
			
			result += memberMapper.kakaoJoinPoint(mp);
		}
		//System.out.println("kakaoJoinPoint : "+result);
		if(result != 2) {
			result = 0;
		}
		return result;
	}
	
	@Override
	public int nickChk(String unick) throws Exception{
		int result = 0;
		result += memberMapper.nickChk(unick);
		return result;
	}
	
	@Override
	public int idChk(String uid) throws Exception{
		int result = 0;
		result += memberMapper.idChk(uid);
		System.out.println("uid svc result : " + result);
		return result;
	}
	
	@Override
	public int emailChkJoin(String email) throws Exception{
		int result = 0;
		result += memberMapper.emailChkJoin(email);
		return result;
	}
	
	@Override
	public int memberIn(MemberInfo mi) throws Exception{
		int result = 0;
		result += memberMapper.memberIn(mi);
		return result;
	}
	
	@Override
	public int memberAddrIn(MemberAddr ma) throws Exception{
		int result = 0;
		
		result = memberMapper.memberAddrIn(ma);
		return result;
	}
	
	@Override
	public int memberPointIn(MemberPoint mp) throws Exception{
		int result =0;
		
		result = memberMapper.memberPointIn(mp);
		
		return result;
	}
}
