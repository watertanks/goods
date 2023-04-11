package com.goods.vo;

import lombok.Data;

@Data
public class ArtistCode {
	
	private int ac_idx;
	
	private String ac_id;
	
	private String ac_name_k;
	
	private String ac_name_e;
	
	private String ac_img;
	
	private String ac_date;

	
	
	
	
	
	public int getAc_idx() {
		return ac_idx;
	}

	public void setAc_idx(int ac_idx) {
		this.ac_idx = ac_idx;
	}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_name_k() {
		return ac_name_k;
	}

	public void setAc_name_k(String ac_name_k) {
		this.ac_name_k = ac_name_k;
	}

	public String getAc_name_e() {
		return ac_name_e;
	}

	public void setAc_name_e(String ac_name_e) {
		this.ac_name_e = ac_name_e;
	}

	public String getAc_img() {
		return ac_img;
	}

	public void setAc_img(String ac_img) {
		this.ac_img = ac_img;
	}

	public String getAc_date() {
		return ac_date;
	}

	public void setAc_date(String ac_date) {
		this.ac_date = ac_date;
	}

	@Override
	public String toString() {
		return "ArtistCode [ac_idx=" + ac_idx + ", ac_id=" + ac_id + ", ac_name_k=" + ac_name_k + ", ac_name_e="
				+ ac_name_e + ", ac_img=" + ac_img + ", ac_date=" + ac_date + "]";
	}
	
	
}
