package com.infrutious.springmvc.dto;

import java.io.Serializable;
import java.util.List;

public class ReturnData implements Serializable{

	private List<String> headerFields;
	
	private List<List<String>> data;

	public List<String> getHeaderFields() {
		return headerFields;
	}

	public void setHeaderFields(List<String> headerFields) {
		this.headerFields = headerFields;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}
	
	
}
