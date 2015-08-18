package com.infrutious.springmvc.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.infrutious.springmvc.dto.HeaderData;
import com.infrutious.springmvc.dto.ReturnData;

public class DataFormatter {

	public static String formatToJson(List<List<String>> sourceData) {
		ReturnData returnData = new ReturnData();
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		returnData.setData(data);
		List<String> topHeader = null;
		for(int i=0;i<sourceData.size();i++){
			if(i==0){ // Header
				List<HeaderData> headerDatas = new ArrayList<HeaderData>();
				topHeader = sourceData.get(i);
				for(int j=0;j<topHeader.size();j++){
					HeaderData header = new HeaderData();
					header.setName(topHeader.get(j));
					header.setType("string");
					headerDatas.add(header);
				}
				returnData.setHeaderFields(headerDatas);
			}else{
				Map<String,String> innerData = new LinkedHashMap<String, String>();
				List<String> valueList = sourceData.get(i);
				for(int j=0;j<valueList.size();j++){
					innerData.put(topHeader.get(j), valueList.get(j));
				}
				data.add(innerData);
			}
		}
		return new Gson().toJson(returnData );
	}

}
