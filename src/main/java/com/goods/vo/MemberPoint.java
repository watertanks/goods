package com.goods.vo;

import lombok.Data;


@Data
public class MemberPoint {
	
	private int mp_idx;
	
	private String mi_id;
	
	private String mp_su;
	
	private int mp_point;
	
	private String mp_desc;
	
	private String mp_detail;
	
	private String mp_date;
	
	private int mp_admin;
	
	private int mp_yearpoint;

	public int getMp_idx() {
		return mp_idx;
	}

	public void setMp_idx(int mp_idx) {
		this.mp_idx = mp_idx;
	}

	public String getMi_id() {
		return mi_id;
	}

	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}

	public String getMp_su() {
		return mp_su;
	}

	public void setMp_su(String mp_su) {
		this.mp_su = mp_su;
	}

	public int getMp_point() {
		return mp_point;
	}

	public void setMp_point(int mp_point) {
		this.mp_point = mp_point;
	}

	public String getMp_desc() {
		return mp_desc;
	}

	public void setMp_desc(String mp_desc) {
		this.mp_desc = mp_desc;
	}

	public String getMp_detail() {
		return mp_detail;
	}

	public void setMp_detail(String mp_detail) {
		this.mp_detail = mp_detail;
	}

	public String getMp_date() {
		return mp_date;
	}

	public void setMp_date(String mp_date) {
		this.mp_date = mp_date;
	}

	public int getMp_admin() {
		return mp_admin;
	}

	public void setMp_admin(int mp_admin) {
		this.mp_admin = mp_admin;
	}

	public int getMp_yearpoint() {
		return mp_yearpoint;
	}

	public void setMp_yearpoint(int mp_yearpoint) {
		this.mp_yearpoint = mp_yearpoint;
	}

	@Override
	public String toString() {
		return "MemberPoint [mp_idx=" + mp_idx + ", mi_id=" + mi_id + ", mp_su=" + mp_su + ", mp_point=" + mp_point
				+ ", mp_desc=" + mp_desc + ", mp_detail=" + mp_detail + ", mp_date=" + mp_date + ", mp_admin="
				+ mp_admin + ", mp_yearpoint=" + mp_yearpoint + "]";
	}
	
	
	
	
	
}
