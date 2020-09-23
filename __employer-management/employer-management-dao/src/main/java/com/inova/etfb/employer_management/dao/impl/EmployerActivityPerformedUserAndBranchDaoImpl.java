package com.inova.etfb.employer_management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inova.applogger.util.MethodLogging;
import com.inova.etfb.employer_management.dao.EmployerActivityPerformedUserAndBranchDao;
import com.inova.etfb.employer_management.request.EmployerActivityUserRequest;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedBranchRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerActivityPerformedUserRespDto;

@Repository
public class EmployerActivityPerformedUserAndBranchDaoImpl implements EmployerActivityPerformedUserAndBranchDao {
	
    @PersistenceContext
    EntityManager manager;
    
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public List<EmployerActivityPerformedUserRespDto> getEmployerActivityPerformedUsers(EmployerActivityUserRequest req) {
    	
		StringBuilder nativeQuery = new StringBuilder();
        
        nativeQuery.append("SELECT ");
        nativeQuery.append("distinct ");
        nativeQuery.append("usr.id  AS created_user_id, ");
        nativeQuery.append("usr.display_name AS created_user_name ");
      
        nativeQuery.append("FROM ");
        
        nativeQuery.append("txn_employer txn_emplyr ");
        nativeQuery.append("JOIN transaction trnsactn ON txn_emplyr.transaction_id = trnsactn.id ");
        nativeQuery.append("JOIN user usr ON trnsactn.created_by = usr.id ");
        nativeQuery.append("JOIN organization_user organization_usr ON organization_usr.user_id = usr.id ");
        nativeQuery.append("JOIN organization orgnztn ON  orgnztn.id = organization_usr.organization_id ");
        
    	List<String> listConditions = new ArrayList<>();
     	
 	
    	if (req.getEmployerId() != null) {
    		listConditions.add(" txn_emplyr.employer_id  =:emp_id  ");
    	}   	
    	if (req.getEtfBrachId() != null) {
    		listConditions.add(" orgnztn.id =:org_id  ");
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
    		nativeQuery.append(" orgnztn.owner = TRUE and ");
    		nativeQuery.append(conditions.toString());
    	}else {
    		
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(" orgnztn.owner = TRUE ");
    	}
    		
        Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerActivityPerformedUserDetailMapping");

    	if (req.getEmployerId() != null) {    	
            query.setParameter("emp_id", req.getEmployerId());
    	}    	    	
    	if (req.getEtfBrachId() != null) {
            query.setParameter("org_id", req.getEtfBrachId());
    	}
     
    	return query.getResultList();
        
    }
    
    
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public List<EmployerActivityPerformedBranchRespDto> getEmployerActivityPerformedBranches(Long employerId) {
    	
		StringBuilder nativeQuery = new StringBuilder();
        
        nativeQuery.append("SELECT ");
        nativeQuery.append("distinct ");
        nativeQuery.append("etfbbranch.id AS created_organization_id, ");
        nativeQuery.append("etfbbranch.name AS created_organization_name ");
      
        nativeQuery.append("FROM ");
        
        nativeQuery.append("txn_employer txn_emplyr ");
        nativeQuery.append("JOIN transaction  trnsactn ON txn_emplyr.transaction_id = trnsactn.id ");
        nativeQuery.append("JOIN organization etfbbranch ON trnsactn.created_organization_id = etfbbranch.id ");

    	List<String> listConditions = new ArrayList<>();
     	
 	
    	if (employerId != null) {
    		listConditions.add(" txn_emplyr.employer_id  =:emp_id  ");
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
    		nativeQuery.append(" etfbbranch.owner =  true and ");    		
    		nativeQuery.append(conditions.toString());
    	}else {
    		
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(" etfbbranch.owner =  true ");
    		
    	}
    		
        Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerActivityPerformedBranchDetailMapping");

    	if (employerId != null) {  	
            query.setParameter("emp_id", employerId);
    	}      
     
    	return query.getResultList();
    }

}
