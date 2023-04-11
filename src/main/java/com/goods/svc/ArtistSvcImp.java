package com.goods.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goods.mapper.ArtistMapper;
import com.goods.vo.*;


@Service
public class ArtistSvcImp implements ArtistSvc{
	
	@Autowired
	private ArtistMapper artistMapper;
	
	@Override
	public List<ArtistCode> getArtistList(Criteria cri) {
		List<ArtistCode> al = artistMapper.getArtistList(cri);
		
		//System.out.println(al);
		return al;
		
	}
	
	@Override
	public long getAllArtistList(String ac) {
		
		long result = artistMapper.getAllArtistList(ac);
		
		return result;
	}
}
