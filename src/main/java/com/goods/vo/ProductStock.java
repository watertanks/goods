package com.goods.vo;

import lombok.Data;

@Data
public class ProductStock {
	
	private long ps_idx;
	
	private String pi_id;
	
	private String ps_am_name;
	
	private long ps_stock;
	
	private long ps_sale;
	
	private String ps_isview;

	public long getPs_idx() {
		return ps_idx;
	}

	public void setPs_idx(long ps_idx) {
		this.ps_idx = ps_idx;
	}

	public String getPi_id() {
		return pi_id;
	}

	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}

	public String getPs_am_name() {
		return ps_am_name;
	}

	public void setPs_am_name(String ps_am_name) {
		this.ps_am_name = ps_am_name;
	}

	public long getPs_stock() {
		return ps_stock;
	}

	public void setPs_stock(long ps_stock) {
		this.ps_stock = ps_stock;
	}

	public long getPs_sale() {
		return ps_sale;
	}

	public void setPs_sale(long ps_sale) {
		this.ps_sale = ps_sale;
	}

	public String getPs_isview() {
		return ps_isview;
	}

	public void setPs_isview(String ps_isview) {
		this.ps_isview = ps_isview;
	}

	@Override
	public String toString() {
		return "productStock [ps_idx=" + ps_idx + ", pi_id=" + pi_id + ", ps_am_name=" + ps_am_name + ", ps_stock="
				+ ps_stock + ", ps_sale=" + ps_sale + ", ps_isview=" + ps_isview + "]";
	}
	
	
}
