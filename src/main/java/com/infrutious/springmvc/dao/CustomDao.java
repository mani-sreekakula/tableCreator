package com.infrutious.springmvc.dao;

import java.util.List;

public interface CustomDao {

	void createTable(String tableName, List<List<String>> data);

	void dropTable(String tableName);

	void createData(String tableName, List<List<String>> data);

}
