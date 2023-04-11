package com.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goods.vo.MemberInfo;

@Mapper
public interface AdminMapper {
	
	public long getAllMemberCnt();
	
	public long getNewMemberCnt();
	
}
