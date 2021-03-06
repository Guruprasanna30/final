package com.upog.tennis.repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.upog.tennis.util.Constant;
import com.upog.tennis.util.DataSourceFactory;
import com.upog.tennis.util.Util;

@Repository
public class DynamicReportRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
/*	@Autowired
	private DataSourceFactory dataSourceFactory;
	*/
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public List<List<Map<String,Object>>> getDynamicReport(String dynamicReportSQL){
		

		// JdbcTemplate jdbcTemplate=dataSourceFactory.getJdbcTemplatebyName(connectionName) ;

		List<List<Map<String,Object>>> result=new ArrayList<List<Map<String,Object>>>();
		List<Map<String, Object>> resultData=null;
		List<Map<String, Object>> resultHeader=null;
		try {
			System.out.println("Executing SQL");
			resultData=jdbcTemplate.queryForList(dynamicReportSQL);   
			System.out.println("queryResultMapObj" +  resultData);
			
			if(resultData.size() >0) {
				resultHeader=getHeaderData(resultData.get(0).keySet());
			}
			result.add(resultHeader);
			result.add(resultData);
		}catch(Exception e) {
			throw e;
		}
		 
		 return result;
	}
	
	private List<Map<String,Object>> getHeaderData(Set<String> columnHeaderSet){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for(String columnHeader : columnHeaderSet){
			   Map<String,Object> column= new HashMap<String,Object>();
			   column.put(Constant.GRID_JSON_HEADER_NAME,Util.toCamelCase(columnHeader));
			   column.put(Constant.GRID_JSON_HEADER_FIELD,columnHeader);
			   column.put(Constant.GRID_JSON_HEADER_SORT,Constant.TRUE_BOOLEAN);
			   column.put(Constant.GRID_JSON_HEADER_FILTER,Constant.TRUE_BOOLEAN);
			   column.put(Constant.GRID_JSON_HEADER_PINNED,null);
			   
			   result.add(column);
			}
		System.out.println("Header --> " + result);
		return result;
		
	}
	

}
