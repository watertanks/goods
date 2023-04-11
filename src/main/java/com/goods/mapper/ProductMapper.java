package com.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goods.vo.*;

@Mapper
public interface ProductMapper {
	
	public List<ProductInfo> getProductList(Criteria cri);
	
	public long getAllProductList(String pageset);
	
	public List<ArtistCode> getArtistcodeList();
	
	public List<ArtistProduct> getArtistProduct();
	
	public ProductInfo getProductInfo(String piid);
	
	public List<ProductStock> getProductStockList(String piid);
}
