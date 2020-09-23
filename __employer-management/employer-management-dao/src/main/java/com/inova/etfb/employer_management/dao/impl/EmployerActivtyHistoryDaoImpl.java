package com.inova.etfb.employer_management.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.inova.applogger.util.MethodLogging;
import com.inova.etfb.employer_management.dao.EmployerActivtyHistoryDao;
import com.inova.etfb.employer_management.request.EmployerActivitySearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivtyHistoryRespDto;
import com.inova.exception.ApplicationException;

@Repository
public class EmployerActivtyHistoryDaoImpl implements EmployerActivtyHistoryDao {
    @PersistenceContext
    EntityManager manager;
    
    
	public String make_date_format(Date date) { 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    formatter.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
	    String strDate= formatter.format(date);  
	    System.out.println(strDate);
		return strDate;  
	}
	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
	public List<EmployerActivtyHistoryRespDto> searchEmployerActivityHistory(EmployerActivitySearchRequest searchRequest){
		

		StringBuilder nativeQuery = new StringBuilder();
        
        nativeQuery.append("SELECT ");
        nativeQuery.append("trnsactn.id AS transaction_id, ");
        nativeQuery.append("trnsactn.created_at AS created_at, ");
        nativeQuery.append("usr.display_name AS created_by, ");
        nativeQuery.append("etfbbranch.name AS organization_name, ");
        nativeQuery.append("mst_txnaction.name AS action_type ");
        
        nativeQuery.append("FROM ");
        
        nativeQuery.append("txn_employer txn_emplyr ");
        nativeQuery.append("LEFT JOIN transaction trnsactn ON txn_emplyr.transaction_id = trnsactn.id ");
        nativeQuery.append("LEFT JOIN mst_txn_action mst_txnaction ON trnsactn.action_id =  mst_txnaction.id ");
        nativeQuery.append("LEFT JOIN employer emplyr ON txn_emplyr.employer_id = emplyr.id ");
        nativeQuery.append("LEFT JOIN user usr ON trnsactn.created_by = usr.id ");
        nativeQuery.append("LEFT JOIN organization etfbbranch ON trnsactn.created_organization_id = etfbbranch.id ");
		
        
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	

    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" txn_emplyr.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
    	}if (searchRequest.getEtfBrachId() != null) {
    		listConditions.add(" trnsactn.created_organization_id  =:branch_id  " );
			paramMap.put("branch_id", searchRequest.getEtfBrachId());
    	}
    	if (searchRequest.getCreatedUserId() != null) {
    		listConditions.add(" trnsactn.created_by  =:created_user_id  " );
			paramMap.put("created_user_id", searchRequest.getCreatedUserId());
    	}
    	
    	if (searchRequest.getCreatedAtFrom() != null ) {
    		listConditions.add(" Date_Format(trnsactn.created_at,'%Y-%m-%d') >= :start " );
    		paramMap.put("start", make_date_format(searchRequest.getCreatedAtFrom()));
    	} 
    	
    	if (searchRequest.getCreatedAtTo()!= null) {
    		listConditions.add(" Date_Format(trnsactn.created_at,'%Y-%m-%d') <= :end" );
    		paramMap.put("end", make_date_format(searchRequest.getCreatedAtTo()));
    	} 
    	   	
    	if (!listConditions.isEmpty()) {
    		StringBuilder conditions = new StringBuilder();
    	
    		for (int i = 0; i < listConditions.size(); i++) {
    			String arrayElement = listConditions.get(i);
    			if (i != 0) {
    				conditions.append(" AND ");
    				conditions.append(arrayElement);
    			}else {
    				conditions.append(" ");
    				conditions.append(arrayElement);
    			}
    		}
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(conditions.toString());
    	}
    	
    	
    	
    	if(!StringUtils.isEmpty(searchRequest.getOrder())) {
    		if("asc".equals(searchRequest.getOrder()) ||  "desc".equals(searchRequest.getOrder()) ) {
    			nativeQuery.append(" ORDER BY trnsactn.created_at ");
    			nativeQuery.append(searchRequest.getOrder());
    			
    		}  	
    		else {
    			  nativeQuery.append(" ORDER BY trnsactn.created_at desc ");
    		}
    	}else {

		  nativeQuery.append(" ORDER BY trnsactn.created_at desc ");
    		
    	}

    	
        Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerActivtyHistoryMapping");
            
    	
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
                
    	return query.getResultList();
	}
 	
}
