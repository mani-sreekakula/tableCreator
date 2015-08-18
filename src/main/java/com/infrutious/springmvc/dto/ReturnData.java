package com.infrutious.springmvc.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ReturnData implements Serializable{

	private List<HeaderData> headerFields;
	
	private List<Map<String,String>> data;

	public List<HeaderData> getHeaderFields() {
		return headerFields;
	}

	public void setHeaderFields(List<HeaderData> headerFields) {
		this.headerFields = headerFields;
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}
	
	
}
