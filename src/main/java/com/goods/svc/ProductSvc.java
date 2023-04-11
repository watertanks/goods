package com.goods.svc;

import java.util.List;
import com.goods.vo.*;

public interface ProductSvc {

	public List<ProductInfo> getProductList(Criteria cri) throws Exception;
	
	public long getAllProductList(String pageset) throws Exception;
	
	public List<ArtistCode> getArtistcodeList() throws Exception;
	
	public List<ArtistProduct> getArtistProduct() throws Exception;
	
	public ProductInfo getProductInfo(String piid) throws Exception;
	
	public List<ProductStock> getProductStockList(String piid) throws Exception;
}
