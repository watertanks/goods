package com.goods.vo;

import lombok.Data;

@Data
public class AdminInfo {
	
	private long ai_idx;
	
	private String ai_id;
	
	private String ai_pw;
	
	private String ai_name;

	public long getAi_idx() {
		return ai_idx;
	}

	public void setAi_idx(long ai_idx) {
		this.ai_idx = ai_idx;
	}

	public String getAi_id() {
		return ai_id;
	}

	public void setAi_id(String ai_id) {
		this.ai_id = ai_id;
	}

	public String getAi_pw() {
		return ai_pw;
	}

	public void setAi_pw(String ai_pw) {
		this.ai_pw = ai_pw;
	}

	public String getAi_name() {
		return ai_name;
	}

	public void setAi_name(String ai_name) {
		this.ai_name = ai_name;
	}

	@Override
	public String toString() {
		return "AdminInfo [ai_idx=" + ai_idx + ", ai_id=" + ai_id + ", ai_pw=" + ai_pw + ", ai_name=" + ai_name + "]";
	}
	
	
}
