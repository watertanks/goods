package com.goods.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goods.mapper.ProductMapper;
import com.goods.svc.ProductSvc;
import com.goods.vo.*;

@Service
public class ProductSvcImp implements ProductSvc{
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@Override
	public List<ProductInfo> getProductList(Criteria cri){
		List<ProductInfo> pl = productMapper.getProductList(cri);
		
		//System.out.println(pl);
		return pl;
	}
	
	@Override
	public long getAllProductList(String pageset) {
		long result = productMapper.getAllProductList(pageset);
		
		return result;
	}
	
	@Override
	public List<ArtistCode> getArtistcodeList(){
		List<ArtistCode> ac = productMapper.getArtistcodeList();
		
		return ac;
	}
	
	@Override
	public List<ArtistProduct> getArtistProduct(){
		List<ArtistProduct> ap = productMapper.getArtistProduct();
		
		return ap;
	}
	
	@Override
	public ProductInfo getProductInfo(String piid){
		ProductInfo pi = productMapper.getProductInfo(piid);
		
		return pi;
	}
	
	@Override
	public List<ProductStock> getProductStockList(String piid){
		List<ProductStock> ps = productMapper.getProductStockList(piid);
		
		return ps;
	}
}
