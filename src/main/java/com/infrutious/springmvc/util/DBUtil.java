package com.infrutious.springmvc.util;

import java.util.ArrayList;
import java.util.List;

public class DBUtil {

	public static String createTable(String tableName, List<List<String>> data) {
		String query = "DROP TABLE IF EXISTS " + tableName + ";";
		query = " CREATE TABLE  " + tableName + " (";
		query += " SYSTEM_ID int(11) NOT NULL AUTO_INCREMENT, ";
		for (String headerData : data.get(0)) {
			query += " " + headerData + " varchar(255) NOT NULL,";
		}
		query += "PRIMARY KEY (SYSTEM_ID))";
		System.out.println(query);
		return query;
	}

	public static String dropTable(String tableName) {
		String query = "DROP TABLE IF EXISTS " + tableName + " ";
		System.out.println(query);
		return query;
	}

	public static List<List<String>> getHardCodeData() {
		List<List<String>> data = new ArrayList<List<String>>();
		List<String> coldata = new ArrayList<String>();
		coldata.add("company_no");
		coldata.add("company_name");
		coldata.add("company_type");
		data.add(coldata);
		return data;
	}

	public static List<String> createData(String tableName, List<List<String>> data) {
		List<String> insertQueries = new ArrayList<String>();
		if (data != null && data.size() > 1) {
			for (int i = 1; i < data.size(); i++) {
				List<String> colsData = data.get(i);
				String insertQuery = "INSERT INTO " + tableName + " VALUES (" + i;
				for (String columnData : colsData) {
					insertQuery += " ,'" + columnData + "'";
				}
				insertQuery += ")";
				insertQueries.add(insertQuery);
			}
		}
		return insertQueries;
	}
}
