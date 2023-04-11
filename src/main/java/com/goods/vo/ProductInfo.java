package com.goods.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ProductInfo {
	
	private String pi_id;
	
	private String ac_id;
	
	private int ap_id;
	
	private String pi_name;
	
	private int pi_price;
	
	private int pi_cost;
	
	private int pi_dc;
	
	private String pi_img1;
	
	private String pi_img2;
	
	private String pi_img3;
	
	private String pi_desc;
	
	private String pi_text;
	
	private String pi_special;
	
	private String pi_sdate;
	
	private int pi_read;
	
	private long pi_sale;
	
	private String pi_isview;
	
	private String pi_date;
	
	private long ai_idx;
	
	private String pi_last;
	
	private long pi_ad_idx;

	private String ac_name_k;
	
	private String ac_name_e;
	
	private String ap_name;
	
	
	

	public String getPi_id() {
		return pi_id;
	}

	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public int getAp_id() {
		return ap_id;
	}

	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}

	public String getPi_name() {
		return pi_name;
	}

	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}

	public int getPi_price() {
		return pi_price;
	}

	public void setPi_price(int pi_price) {
		this.pi_price = pi_price;
	}

	public int getPi_cost() {
		return pi_cost;
	}

	public void setPi_cost(int pi_cost) {
		this.pi_cost = pi_cost;
	}

	public int getPi_dc() {
		return pi_dc;
	}

	public void setPi_dc(int pi_dc) {
		this.pi_dc = pi_dc;
	}

	public String getPi_img1() {
		return pi_img1;
	}

	public void setPi_img1(String pi_img1) {
		this.pi_img1 = pi_img1;
	}

	public String getPi_img2() {
		return pi_img2;
	}

	public void setPi_img2(String pi_img2) {
		this.pi_img2 = pi_img2;
	}

	public String getPi_img3() {
		return pi_img3;
	}

	public void setPi_img3(String pi_img3) {
		this.pi_img3 = pi_img3;
	}

	public String getPi_desc() {
		return pi_desc;
	}

	public void setPi_desc(String pi_desc) {
		this.pi_desc = pi_desc;
	}

	public String getPi_text() {
		return pi_text;
	}

	public void setPi_text(String pi_text) {
		this.pi_text = pi_text;
	}

	public String getPi_special() {
		return pi_special;
	}

	public void setPi_special(String pi_special) {
		this.pi_special = pi_special;
	}

	public String getPi_sdate() {
		return pi_sdate;
	}

	public void setPi_sdate(String pi_sdate) {
		this.pi_sdate = pi_sdate;
	}

	public int getPi_read() {
		return pi_read;
	}

	public void setPi_read(int pi_read) {
		this.pi_read = pi_read;
	}

	public long getPi_sale() {
		return pi_sale;
	}

	public void setPi_sale(long pi_sale) {
		this.pi_sale = pi_sale;
	}

	public String getPi_isview() {
		return pi_isview;
	}

	public void setPi_isview(String pi_isview) {
		this.pi_isview = pi_isview;
	}

	public String getPi_date() {
		return pi_date;
	}

	public void setPi_date(String pi_date) {
		this.pi_date = pi_date;
	}

	public long getAi_idx() {
		return ai_idx;
	}

	public void setAi_idx(long ai_idx) {
		this.ai_idx = ai_idx;
	}

	public String getPi_last() {
		return pi_last;
	}

	public void setPi_last(String pi_last) {
		this.pi_last = pi_last;
	}

	public long getPi_ad_idx() {
		return pi_ad_idx;
	}

	public void setPi_ad_idx(long pi_ad_idx) {
		this.pi_ad_idx = pi_ad_idx;
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

	public String getAp_name() {
		return ap_name;
	}

	public void setAp_name(String ap_name) {
		this.ap_name = ap_name;
	}

	@Override
	public String toString() {
		return "ProductInfo [pi_id=" + pi_id + ", ac_id=" + ac_id + ", ap_id=" + ap_id + ", pi_name=" + pi_name
				+ ", pi_price=" + pi_price + ", pi_cost=" + pi_cost + ", pi_dc=" + pi_dc + ", pi_img1=" + pi_img1
				+ ", pi_img2=" + pi_img2 + ", pi_img3=" + pi_img3 + ", pi_desc=" + pi_desc + ", pi_text=" + pi_text
				+ ", pi_special=" + pi_special + ", pi_sdate=" + pi_sdate + ", pi_read=" + pi_read + ", pi_sale="
				+ pi_sale + ", pi_isview=" + pi_isview + ", pi_date=" + pi_date + ", ai_idx=" + ai_idx + ", pi_last="
				+ pi_last + ", pi_ad_idx=" + pi_ad_idx + ", ac_name_k=" + ac_name_k + ", ac_name_e=" + ac_name_e
				+ ", ap_name=" + ap_name + "]";
	}

	

	
	
	
	
	
	
	
	
	
	
}
