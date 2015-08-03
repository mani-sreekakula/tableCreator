package com.infrutious.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.infrutious.springmvc.util.DBUtil;

@Repository("customDao")
public class CustomDaoImpl extends AbstractDao implements CustomDao {

	public void createTable(String tableName, List<List<String>> data) {
		Session session = getSession();
		session.createSQLQuery(DBUtil.createTable(tableName, data)).executeUpdate();
		return;
	}

	public void dropTable(String tableName) {
		Session session = getSession();
		session.createSQLQuery(DBUtil.dropTable(tableName)).executeUpdate();
		return;
	}

	public void createData(String tableName, List<List<String>> data) {
		Session session = getSessionFactory().openSession();
		List<String> insertQueries = DBUtil.createData(tableName, data);
		Transaction tx = session.beginTransaction();
		for ( int i=0; i<insertQueries.size(); i++ ) {
			String insertQuery = insertQueries.get(i);
		    session.createSQLQuery(insertQuery).executeUpdate();
		    if ( i % 20 == 0 ) { //20, same as the JDBC batch size
		        //flush a batch of inserts and release memory:
		        session.flush();
		        session.clear();
		    }
		}
		tx.commit();
		return;
	}

}
