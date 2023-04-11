package com.goods.vo;

import lombok.Data;

@Data
public class ArtistProduct {
	
	private String ap_id;
	
	private String ap_name;

	public String getAp_id() {
		return ap_id;
	}

	public void setAp_id(String ap_id) {
		this.ap_id = ap_id;
	}

	public String getAp_name() {
		return ap_name;
	}

	public void setAp_name(String ap_name) {
		this.ap_name = ap_name;
	}

	@Override
	public String toString() {
		return "ArtistProduct [ap_id=" + ap_id + ", ap_name=" + ap_name + "]";
	}
	
	
	
}
