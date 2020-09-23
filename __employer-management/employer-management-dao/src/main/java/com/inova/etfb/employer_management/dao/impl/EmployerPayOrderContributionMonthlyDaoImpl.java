package com.inova.etfb.employer_management.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inova.applogger.util.MethodLogging;
import com.inova.etfb.employer_management.dao.EmployerPayOrderContributionMonthlyDao;
import com.inova.etfb.employer_management.request.EmployerContributionSearchRequest;
import com.inova.etfb.employer_management.request.EmployerPayOrderContributionSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerContributionMonthlyRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerContributionRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderContributionMonthlyRespDto;

@Repository
public class EmployerPayOrderContributionMonthlyDaoImpl implements EmployerPayOrderContributionMonthlyDao{


	
	
    @PersistenceContext
    EntityManager manager;
    
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public List<EmployerPayOrderContributionMonthlyRespDto> searchEmployerPayOrderContributionMonthly(EmployerPayOrderContributionSearchRequest searchRequest) {
    	

		StringBuilder nativeQuery = new StringBuilder();
        
        nativeQuery.append("SELECT ");
        nativeQuery.append("mmbr_accnt_allctn.month AS allocation_month,  ");
        nativeQuery.append("sum(mmbr_accnt_allctn.amount) AS allocation_amount       ");   
        
        nativeQuery.append("FROM   ");
        
        nativeQuery.append("member_account_allocation mmbr_accnt_allctn    ");
        nativeQuery.append("JOIN mst_member_account_allocation_status mst_mmbr_accnt_allctn_sts ON mst_mmbr_accnt_allctn_sts.id = mmbr_accnt_allctn.status_id   ");
        nativeQuery.append("JOIN member_account mmbr_accnt ON mmbr_accnt.id = mmbr_accnt_allctn.member_account_id   ");
        nativeQuery.append("JOIN employer_member_account emplyr_mmbr_accnt ON emplyr_mmbr_accnt.member_account_id = mmbr_accnt.id   ");
        
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add("emplyr_mmbr_accnt.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
    	}if (searchRequest.getYear() != null) {
    		listConditions.add(" mmbr_accnt_allctn.year  =:year  " );
			paramMap.put("year", searchRequest.getYear());
    	}
 
    	   	
    	if (!listConditions.isEmpty()) {
    		StringBuilder conditions = new StringBuilder();
    	
    		for (int i = 0; i < listConditions.size(); i++) {
    			String arrayElement = listConditions.get(i);
    			if (i != 0) {
    				conditions.append(" AND ");
    				conditions.append(arrayElement);
    			} else {
    				conditions.append(" ");
    				conditions.append(arrayElement);
    			}
    		}
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(" mst_mmbr_accnt_allctn_sts.code != 'CAN' AND ");

    		
    		nativeQuery.append(conditions.toString());
    	} else {
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(" mst_mmbr_accnt_allctn_sts.code != 'CAN' ");

    	}
    	
    	nativeQuery.append(" GROUP BY mmbr_accnt_allctn.month  ");
    	nativeQuery.append(" ORDER BY mmbr_accnt_allctn.month  ");    	
    	
        Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerPayOrderMonthlyMapping");   
    	
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
                
    	return query.getResultList();
    	
    }
 	
 	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override  	
 	public List<EmployerContributionMonthlyRespDto> EmployerContributionMonthly(EmployerPayOrderContributionSearchRequest searchRequest) {
 		
		StringBuilder nativeQuery = new StringBuilder();
		nativeQuery.append(" select  employer_payment_remittance_detail.month AS contribution_month ,                                                                          ");
		nativeQuery.append(" MONTHNAME(STR_TO_DATE(CONCAT(2000,'-',employer_payment_remittance_detail.month,'-',2), '%Y-%m-%d') )   AS contribution_month_name ,                    ");
		nativeQuery.append(" SUM(employer_payment_remittance_detail.contribution)   AS contributed_amount ,                        ");// TODO need to confirm payment_received.amount
		nativeQuery.append(" (CASE ");
		nativeQuery.append("  when sum(mst_payment_status.code  = 'SUC') > 0 then true  ") ;
		nativeQuery.append("  else false  ");
		nativeQuery.append("  END ");
		nativeQuery.append("  ) AS success_state , ");
		nativeQuery.append("  sum(mst_payment_status.code  = 'SUC') AS success_payments , ");
		nativeQuery.append("  sum(mst_payment_status.code  = 'PND') AS pending_payments ");			
		nativeQuery.append(" from                                                                             ");
		nativeQuery.append(" employer_payment_remittance_detail                                               ");
		nativeQuery.append(" join  employer_payment                                                           ");
		nativeQuery.append("  on employer_payment.id = employer_payment_remittance_detail.employer_payment_id ");
		nativeQuery.append(" join  employer_payment_collection                                                ");
		nativeQuery.append("  on employer_payment_collection.employer_payment_id = employer_payment.id        ");
		nativeQuery.append(" join  collection                                                                 ");
		nativeQuery.append("  on collection.id = employer_payment_collection.collection_id                    ");
		nativeQuery.append(" join  payment_received_collection                                                ");
		nativeQuery.append("  on payment_received_collection.collection_id = collection.id                    ");
		nativeQuery.append(" join  payment_received                                                           ");
		nativeQuery.append("  on payment_received.id = payment_received_collection.payment_received_id        ");
		nativeQuery.append(" join  mst_payment_status                                                         ");
		nativeQuery.append("  on mst_payment_status.id = payment_received.payment_status_id                   ");
//		nativeQuery.append(" where                                                                            ");
//		nativeQuery.append(" employer_payment_remittance_detail.member_account_id =  :pMemberAccountId and    ");
//		nativeQuery.append(" employer_payment_remittance_detail.year =  :pContributedYear and                 ");
//		nativeQuery.append(" employer_payment_remittance_detail.canceled = false and                          ");
//		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                              ");
//		nativeQuery.append(" mst_payment_status.code = 'PND')												   ");
		
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" employer_payment.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
    	}if (searchRequest.getYear() != null) {
    		listConditions.add(" employer_payment_remittance_detail.year  =:year  " );
			paramMap.put("year", searchRequest.getYear());
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
    		nativeQuery.append(" WHERE                                                                            ");
    		nativeQuery.append(" employer_payment_remittance_detail.canceled = false AND                         ");
    		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                              ");
    		nativeQuery.append(" mst_payment_status.code = 'PND')	AND											   ");
    		
    		nativeQuery.append(conditions.toString());
    	} else {
    		nativeQuery.append(" WHERE                                                                            ");
    		nativeQuery.append(" employer_payment_remittance_detail.canceled = false and                          ");
    		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                              ");
    		nativeQuery.append(" mst_payment_status.code = 'PND')												   ");

    	}
				
		nativeQuery.append(" GROUP BY employer_payment_remittance_detail.month        ");
		nativeQuery.append(" Order BY employer_payment_remittance_detail.month ASC							   ");
		
		Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerContributionMonthlyMapping");

		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		return query.getResultList();

 	}

 	 	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override  	
 	public BigDecimal  getEmployerTotalContribution(EmployerPayOrderContributionSearchRequest searchRequest) {
		StringBuilder nativeQuery = new StringBuilder();
		nativeQuery.append(" select                                                                           ");
		nativeQuery.append(" SUM(employer_payment_remittance_detail.contribution)   AS contributed_amount     ");// TODO need to confirm payment_received.amount			
		nativeQuery.append(" from                                                                             ");
		nativeQuery.append(" employer_payment_remittance_detail                                               ");
		nativeQuery.append(" join  employer_payment                                                           ");
		nativeQuery.append("  on employer_payment.id = employer_payment_remittance_detail.employer_payment_id ");
		nativeQuery.append(" join  employer_payment_collection                                                ");
		nativeQuery.append("  on employer_payment_collection.employer_payment_id = employer_payment.id        ");
		nativeQuery.append(" join  collection                                                                 ");
		nativeQuery.append("  on collection.id = employer_payment_collection.collection_id                    ");
		nativeQuery.append(" join  payment_received_collection                                                ");
		nativeQuery.append("  on payment_received_collection.collection_id = collection.id                    ");
		nativeQuery.append(" join  payment_received                                                           ");
		nativeQuery.append("  on payment_received.id = payment_received_collection.payment_received_id        ");
		nativeQuery.append(" join  mst_payment_status                                                         ");
		nativeQuery.append("  on mst_payment_status.id = payment_received.payment_status_id                   ");
		
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" employer_payment.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
    	}if (searchRequest.getYear() != null) {
    		listConditions.add(" employer_payment_remittance_detail.year  =:year  " );
			paramMap.put("year", searchRequest.getYear());
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
    		nativeQuery.append(" WHERE                                                                           ");
    		nativeQuery.append(" employer_payment_remittance_detail.canceled = false AND                         ");
    		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                             ");
    		nativeQuery.append(" mst_payment_status.code = 'PND')	AND										     ");
    		
    		nativeQuery.append(conditions.toString());
    		
    	} else {
    		nativeQuery.append(" WHERE                                                                            ");
    		nativeQuery.append(" employer_payment_remittance_detail.canceled = false and                          ");
    		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                              ");
    		nativeQuery.append(" mst_payment_status.code = 'PND')												  ");
    	}
		
		Query query = this.manager.createNativeQuery(nativeQuery.toString());
		
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		BigDecimal val = null;
		try{
			val = (BigDecimal) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}	 
		return val;
 		
 	}

 	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override  	
 	public  BigDecimal getEmployerTotalPayOrderContribution(EmployerPayOrderContributionSearchRequest searchRequest) {
 		 		
		StringBuilder nativeQuery = new StringBuilder();
        
        nativeQuery.append("SELECT ");
        nativeQuery.append("sum(mmbr_accnt_allctn.amount) AS allocation_amount       ");   
        
        nativeQuery.append("FROM   ");
        
        nativeQuery.append("member_account_allocation mmbr_accnt_allctn    ");
        nativeQuery.append("JOIN mst_member_account_allocation_status mst_mmbr_accnt_allctn_sts ON mst_mmbr_accnt_allctn_sts.id = mmbr_accnt_allctn.status_id   ");
        nativeQuery.append("JOIN member_account mmbr_accnt ON mmbr_accnt.id = mmbr_accnt_allctn.member_account_id   ");
        nativeQuery.append("JOIN employer_member_account emplyr_mmbr_accnt ON emplyr_mmbr_accnt.member_account_id = mmbr_accnt.id   ");
        
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" emplyr_mmbr_accnt.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
    	}if (searchRequest.getYear() != null) {
    		listConditions.add(" mmbr_accnt_allctn.year  =:year  " );
			paramMap.put("year", searchRequest.getYear());
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
    		nativeQuery.append(" mst_mmbr_accnt_allctn_sts.code != 'CAN' AND ");

    		
    		nativeQuery.append(conditions.toString());
    	}
    	else {
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(" mst_mmbr_accnt_allctn_sts.code != 'CAN' ");

    	}

		Query query = this.manager.createNativeQuery(nativeQuery.toString());
		
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		BigDecimal val =  null;
		
		try{
			val = (BigDecimal) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
		return val;
 		 		
 	}
 	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override
 	public int minMaxEmployerAllocationYear(EmployerPayOrderContributionSearchRequest searchRequest , String order) {
 		
 		
		StringBuilder nativeQuery = new StringBuilder();
        
        nativeQuery.append("SELECT ");
        nativeQuery.append("mmbr_accnt_allctn.year AS allocation_year       ");   
        
        nativeQuery.append("FROM   ");
        
        nativeQuery.append("member_account_allocation mmbr_accnt_allctn    ");
        nativeQuery.append("JOIN mst_member_account_allocation_status mst_mmbr_accnt_allctn_sts ON mst_mmbr_accnt_allctn_sts.id = mmbr_accnt_allctn.status_id   ");
        nativeQuery.append("JOIN member_account mmbr_accnt ON mmbr_accnt.id = mmbr_accnt_allctn.member_account_id   ");
        nativeQuery.append("JOIN employer_member_account emplyr_mmbr_accnt ON emplyr_mmbr_accnt.member_account_id = mmbr_accnt.id   ");
        
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" emplyr_mmbr_accnt.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
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
    		nativeQuery.append(" mst_mmbr_accnt_allctn_sts.code != 'CAN' AND ");

    		
    		nativeQuery.append(conditions.toString());
    	}
    	else {
    		nativeQuery.append(" WHERE ");
    		nativeQuery.append(" mst_mmbr_accnt_allctn_sts.code != 'CAN' ");

    	}
    	
    	
        
        
        if (order != null) {
        	nativeQuery.append(" ORDER BY mmbr_accnt_allctn.year ");
        	nativeQuery.append( order);
    	}
        nativeQuery.append(" LIMIT 1   ");
    	
    	

		Query query = this.manager.createNativeQuery(nativeQuery.toString());
		
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
 		
 		
		int val = 0;
		
		try{
			val = (int) query.getSingleResult(); 
		} catch(NoResultException e) {
			return 0;
		}
		return val;

 	}
 	
 	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 	
 	public int minMaxEmployerContributionYear(EmployerPayOrderContributionSearchRequest searchRequest , String order) {
		StringBuilder nativeQuery = new StringBuilder();
		nativeQuery.append(" select                                                                           ");
		nativeQuery.append(" employer_payment_remittance_detail.year   AS allocation_year                     ");// TODO need to confirm payment_received.amount			
		nativeQuery.append(" from                                                                             ");
		nativeQuery.append(" employer_payment_remittance_detail                                               ");
		nativeQuery.append(" join  employer_payment                                                           ");
		nativeQuery.append("  on employer_payment.id = employer_payment_remittance_detail.employer_payment_id ");
		nativeQuery.append(" join  employer_payment_collection                                                ");
		nativeQuery.append("  on employer_payment_collection.employer_payment_id = employer_payment.id        ");
		nativeQuery.append(" join  collection                                                                 ");
		nativeQuery.append("  on collection.id = employer_payment_collection.collection_id                    ");
		nativeQuery.append(" join  payment_received_collection                                                ");
		nativeQuery.append("  on payment_received_collection.collection_id = collection.id                    ");
		nativeQuery.append(" join  payment_received                                                           ");
		nativeQuery.append("  on payment_received.id = payment_received_collection.payment_received_id        ");
		nativeQuery.append(" join  mst_payment_status                                                         ");
		nativeQuery.append("  on mst_payment_status.id = payment_received.payment_status_id                   ");
		
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" employer_payment.employer_id =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
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
    		nativeQuery.append(" WHERE                                                                           ");
    		nativeQuery.append(" employer_payment_remittance_detail.canceled = false AND                         ");
    		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                             ");
    		nativeQuery.append(" mst_payment_status.code = 'PND')	AND										     ");
    		
    		nativeQuery.append(conditions.toString());
    		
    	} else {
    		nativeQuery.append(" WHERE                                                                            ");
    		nativeQuery.append(" employer_payment_remittance_detail.canceled = false and                          ");
    		nativeQuery.append(" (mst_payment_status.code = 'SUC' or                                              ");
    		nativeQuery.append(" mst_payment_status.code = 'PND')												  ");
    	}
    	
    	
        if (order != null) {
        	nativeQuery.append(" ORDER BY employer_payment_remittance_detail.year ");
        	nativeQuery.append(order);
    	}
        nativeQuery.append(" LIMIT 1   ");
    	
    	
		
		Query query = this.manager.createNativeQuery(nativeQuery.toString());
		
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
 		
		int val = 0;
		
		try{
			val = (int) query.getSingleResult(); 
		} catch(NoResultException e) {
			return 0;
		}
		return val;
 	}
 	
 	
 	
 	
 	public BigInteger getEmployerActiveMembers(EmployerPayOrderContributionSearchRequest searchRequest) {
 		
		StringBuilder nativeQuery = new StringBuilder();
		nativeQuery.append(" select                                                                           ");
		nativeQuery.append(" COUNT(emplyr_mmbr_accnt.id) AS current_no_of_employees    ");
		nativeQuery.append(" from                                                                             ");
		nativeQuery.append(" employer_member_account emplyr_mmbr_accnt                                       ");
		nativeQuery.append(" JOIN mst_employer_member_account_status mst_emplyr_mmbr_accnt_sts ON mst_emplyr_mmbr_accnt_sts.id =  emplyr_mmbr_accnt.status_id                                                                             ");

		
    	List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
     	
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" emplyr_mmbr_accnt.employer_id  =:emp_id  ");
			paramMap.put("emp_id", searchRequest.getEmployerId());
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
    		nativeQuery.append(" WHERE                                                                 ");
    		nativeQuery.append(" mst_emplyr_mmbr_accnt_sts.name = 'Active' AND                         ");

    		
    		nativeQuery.append(conditions.toString());
    		
    	}
		
		Query query = this.manager.createNativeQuery(nativeQuery.toString());
		
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		BigInteger val = null;
		
		try{
			val = (BigInteger) query.getSingleResult();
			return val;
			
		} catch(NoResultException e) {
			return null;
		}
 		
 		
 		
 	}

}
