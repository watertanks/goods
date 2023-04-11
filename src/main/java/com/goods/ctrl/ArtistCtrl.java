package com.goods.ctrl;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goods.svc.ArtistSvc;
import com.goods.vo.Criteria;
import com.goods.vo.PageInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ArtistCtrl {

	@Autowired
	private ArtistSvc artistSvc;
	
	@GetMapping("/al")
	public String goArtistList(HttpServletRequest request, HttpServletResponse response,
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Criteria cri) throws Exception {
		
		String orderby = request.getParameter("orderby");
		if(orderby == null || orderby.equals("a")) {
			orderby = "a";
		} else {
			orderby = "b";
		}
		cri.setPage(page);
		cri.setbSize(10);
		cri.setSize(4);
		
		/*
		String where = "";
		
		if(schtype.equals("") || schtype == null) {
			schtype = "";
		} else if (schtype.equals("a")) {
			schtype = " and ";
		} else if (schtype.equals("b")) {
			schtype = " and ";
		}
		cri.setSchType(schtype);
		
		where += schtype;
		System.out.println("schtype : " + schtype);
		
		
		if(keyword.equals("") || keyword == null) {
			keyword = "";
		} else if(keyword.equals("a")) {
			keyword = " and ";
		}
		cri.setKeyword(keyword);
		where += keyword;
		
		System.out.println("keyword : " + keyword);
		
		
		if(!where.equals("")) {
 			where = where.substring(5, where.length());
 			where = " where " + where;
 		}
		
		cri.setQueryString(where);
		*/
		
		if(orderby.equals("a") || orderby == null) {
			orderby = "ac_date DESC";
		} else if(orderby.equals("b")) {
			orderby = "ac_name_k";
		}
		cri.setOrderby(orderby);
		System.out.println(orderby);
		
		String ac = request.getParameter("ac");
		
		if(ac == null || ac.equals("")) {
			ac = "";
		} else {
			ac = " WHERE ac_id = '" + ac + "' ";
		}
		//System.out.println(ac);
		
		long allCount = artistSvc.getAllArtistList(ac);
		long bSize = cri.getbSize();
		long cPage = page;
		long allPage;


		if(allCount % cri.getbSize() == 0) {
			allPage = allCount / cri.getSize();
		} else {
			allPage = (allCount / cri.getSize()) + 1;
		}
		
		
		
		if(page > allPage) {
			return "error";
		} else {
			
			model.addAttribute("artistList", artistSvc.getArtistList(cri));
			model.addAttribute("allCount", allCount);
			model.addAttribute("allPage", allPage);
			model.addAttribute("bSize", bSize);
			model.addAttribute("cPage", cPage);
			
			if(orderby.equals("ac_date DESC")) {
				orderby = "a";
			}else if(orderby.equals("ac_name_k")) {
				orderby = "b";
			}
			
			model.addAttribute("orderby", orderby);
			
			//System.out.println("화면으로 보내는 orderby = " + orderby);
			//System.out.println("cri : " + cri);
			//System.out.println("올아디스트 : "+allCount);
			//System.out.println("allpage : "+allPage);
			//System.out.println("bSize : "+bSize);
			//System.out.println("cPage : " + cPage);
		}
		//System.out.println("통신중임");
		
		return "artistList";
	}
}

/*

private int page;		// 현재 페이지

private int size;		// 한 페이지에 표시되는 데이터 개수 - perPage

private int bsize;		// 페이징 블록 크기

private int allRecord;	// 모든 레코드 갯수

private int allPage;	// 모든 페이지 갯수

private String schtype;	// 검색조건

private String keyword;	// 검색어

private String o;		// 정렬기준

*/