package com.goods.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.mapper.AdminMapper;
import com.goods.vo.*;


@Service
public class AdminSvcImp implements AdminSvc {
	
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	
	
	@Override
	public long getAllMemberCnt(){
		long allMember = adminMapper.getAllMemberCnt();
		 
		 return allMember;
		
	}
	
	@Override
	public long getNewMemberCnt(){
		long newMember = adminMapper.getNewMemberCnt();
		
		return newMember;
	}
}
