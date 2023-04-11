package com.goods.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageInfo {

	private int cpage;	// 현재페이지번호
	
	private int psize;	// 페이지 사이즈
	
	private int bsize;	// 페이징 블록 크기
	
	private int rcnt;	// 게시글(레코드)갯수
	
	private int pcnt;	// 페이지 갯수
	
	private int spage;	// 시작페이지
	
	private String schtype;	// 검색조건
	
	private String keyword;	// 검색어
	
	private String o;	// 정렬기준
	
	private String v;
	
	private String sch;

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public int getBsize() {
		return bsize;
	}

	public void setBsize(int bsize) {
		this.bsize = bsize;
	}

	public int getRcnt() {
		return rcnt;
	}

	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}

	public int getPcnt() {
		return pcnt;
	}

	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}

	public int getSpage() {
		return spage;
	}

	public void setSpage(int spage) {
		this.spage = spage;
	}

	public String getSchtype() {
		return schtype;
	}

	public void setSchtype(String schtype) {
		this.schtype = schtype;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getSch() {
		return sch;
	}

	public void setSch(String sch) {
		this.sch = sch;
	}

	@Override
	public String toString() {
		return "PageInfo [cpage=" + cpage + ", psize=" + psize + ", bsize=" + bsize + ", rcnt=" + rcnt + ", pcnt="
				+ pcnt + ", spage=" + spage + ", schtype=" + schtype + ", keyword=" + keyword + ", o=" + o + ", v=" + v
				+ ", sch=" + sch + "]";
	}
	


	
	
	
}
