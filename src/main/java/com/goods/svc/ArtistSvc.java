package com.goods.svc;

import java.util.List;
import com.goods.vo.*;

public interface ArtistSvc {
	
	public List<ArtistCode> getArtistList(Criteria cri) throws Exception;
	
	public long getAllArtistList(String ac) throws Exception;
}
