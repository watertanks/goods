package com.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.goods.vo.*;

@Mapper
public interface ArtistMapper {
	
	public List<ArtistCode> getArtistList(Criteria cri);
	
	public long getAllArtistList(String ac);
	
}
