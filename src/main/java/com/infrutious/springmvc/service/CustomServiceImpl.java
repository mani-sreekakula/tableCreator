package com.infrutious.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infrutious.springmvc.dao.CustomDao;

@Service("customService")
@Transactional
public class CustomServiceImpl implements CustomService {

	@Autowired
	private CustomDao dao;

	public void createTable(String tableName, List<List<String>> data) {
		dao.createTable(tableName, data);
	}

	public void dropTable(String tableName) {
		dao.dropTable(tableName);
		
	}

	public void createData(String tableName, List<List<String>> data) {
		dao.createData(tableName, data);
		
	}
	
}
