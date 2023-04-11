package com.goods.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private long page;		// 현재 페이지
	
	private long size;		// 한 페이지에 표시되는 데이터 개수 - perPage
	
	private long bSize;		// 페이징 블록 크기
	
	private long allRecord;	// 모든 레코드 갯수
	
	private long allPage;	// 모든 페이지 갯수
	
	private String schType;	// 검색조건
	
	private String keyword;	// 검색어
	
	private String orderby;		// 정렬기준
	
	private String queryString;	// 쿼리스트링 [WHERE ~~]
	

	
	public long getSkip() {
		return this.page = (page - 1) * size;
	}



	public long getPage() {
		return page;
	}



	public void setPage(long page) {
		this.page = page;
	}



	public long getSize() {
		return size;
	}



	public void setSize(long size) {
		this.size = size;
	}



	public long getbSize() {
		return bSize;
	}



	public void setbSize(long bSize) {
		this.bSize = bSize;
	}



	public long getAllRecord() {
		return allRecord;
	}



	public void setAllRecord(long allRecord) {
		this.allRecord = allRecord;
	}



	public long getAllPage() {
		return allPage;
	}



	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}



	public String getSchType() {
		return schType;
	}



	public void setSchType(String schType) {
		this.schType = schType;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	public String getOrderby() {
		return orderby;
	}



	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}



	public String getQueryString() {
		return queryString;
	}



	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}



	@Override
	public String toString() {
		return "Criteria [page=" + page + ", size=" + size + ", bSize=" + bSize + ", allRecord=" + allRecord
				+ ", allPage=" + allPage + ", schType=" + schType + ", keyword=" + keyword + ", orderby=" + orderby
				+ ", queryString=" + queryString + "]";
	}



	

	
	
	

	
	
}
