package com.goods.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goods.svc.*;
import com.goods.vo.*;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@Controller
public class ProductCtrl {
	
	@Autowired
	private ProductSvc productSvc;
	
	
	@GetMapping("/pl")
	public String goProductList(HttpServletRequest request, HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Criteria cri) throws Exception {
		
		// 쿼리스트링
		String where = "";
		String ac = request.getParameter("ac");				// artistCode
		String ap = request.getParameter("ap");				// artistProduct
		String key = request.getParameter("key");		 	// keyword
		String schtype = request.getParameter("schtype");	// schtype
		
		String pageset = null;
		if(ac != null && !ac.equals("")) {
 			where += " and ac.ac_id = '"+ac+"' ";
 			pageset = " AND ac_id = '" + ac + "' ";
 		}
 		
 		if(ap != null && !ap.equals("")) {
 			where += " and ap.ap_id = '"+ap+"' ";
 		}
 		
 		if(key != null && !key.equals("")) {
 			key = key.trim().toUpperCase();
 			if(schtype!=null && schtype.equals("a")) {
 				where += " and ac.ac_name_k like '%"+key+"%' or ac.ac_name_e like '%"+key+"%'";
 			}else {
 				where += " and pi.pi_name like '%"+key+"%' ";	
 			}
 		}
 		
 		if(!where.equals("")) {
 			where = where.substring(5, where.length());
 			where = " where "+where;
 		}
 		
	 	// 정렬기준
		String orderby = request.getParameter("orderby");
		if(orderby == null || orderby.equals("") || orderby.equals("a") ) {	// 최신순
			orderby = "pi_sdate DESC";
		} else if(orderby.equals("b")) {									// 인기순
			orderby = "pi_sale DESC";
		} else if(orderby.equals("c")) {									// 낮은가격순
			orderby = "pi_price ";
		}  else if(orderby.equals("d")) {									// 높은가격순
			orderby = "pi_price DESC";
		}
		//System.out.println("정렬기준 : " + orderby);
 		
		
		cri.setOrderby(orderby);
		cri.setKeyword(key);
		cri.setSchType(schtype);
		cri.setPage(page);
		cri.setbSize(10);
		cri.setSize(8);
		cri.setQueryString(where);
		
		
		
		long allCount = productSvc.getAllProductList(pageset);
		long bSize = cri.getbSize();
		long cPage = page;
		long allPage;
		
		
		if(allCount % cri.getbSize() == 0) {
			allPage = allCount / cri.getSize();
		} else {
			allPage = (allCount / cri.getSize()) + 1;
		}
		
		

		List<ArtistCode> artistcode = productSvc.getArtistcodeList();
		List<ArtistProduct> artistproduct = productSvc.getArtistProduct();
		
		
		if(page > allPage) {
			return "error";
		} else {
			model.addAttribute("pi", productSvc.getProductList(cri));
			model.addAttribute("allCount", allCount);
			model.addAttribute("allPage", allPage);
			model.addAttribute("bSize", bSize);
			model.addAttribute("cPage", cPage);
			model.addAttribute("orderby", orderby);
			model.addAttribute("schtype", schtype);
			model.addAttribute("keyword", key);
			model.addAttribute("ac", artistcode);
			model.addAttribute("ap", artistproduct);
			
			
			//System.out.println("cri : " + cri);
			//System.out.println("올프로덕트 : "+ allCount);
			//System.out.println("allpage : "+allPage);
			//System.out.println("bSize : "+bSize);
			//System.out.println("cPage : " + cPage);
		}
		
		return "productList";
	}
	
	@GetMapping("/pd")
	public String goProductDetail(HttpServletRequest request, HttpServletResponse response,
			Model model,@RequestParam("piid") String piid) throws Exception {
		
		//System.out.println("piid 는 ? " + piid);
		
		ProductInfo pi = productSvc.getProductInfo(piid);
		List<ProductStock> ps = productSvc.getProductStockList(piid);
		
		model.addAttribute("pi", pi);
		//System.out.println("pi는 ? " + pi);
		
		model.addAttribute("ps", ps);
		//System.out.println("ps 는 ? "+ps);
		
		return "productDetail";
	}
	
		

}
