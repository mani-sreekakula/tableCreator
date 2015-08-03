package com.infrutious.springmvc.service;

import java.util.List;


public interface CustomService {
	void createTable(String tableName, List<List<String>> data);
	
	void dropTable(String tableName);

	void createData(String tableName, List<List<String>> data);
}
