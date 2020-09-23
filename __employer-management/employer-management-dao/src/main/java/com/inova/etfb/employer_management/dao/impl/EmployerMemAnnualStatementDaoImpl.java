package com.inova.etfb.employer_management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inova.applogger.util.MethodLogging;
import com.inova.etfb.employer_management.dao.EmployerMemAnnualStatementDao;
import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.exception.ApplicationException;


@Repository
public class EmployerMemAnnualStatementDaoImpl implements EmployerMemAnnualStatementDao{
	
    @PersistenceContext
    EntityManager manager;
	
    
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public List<EmployerMemAnnualStatementResDto> searchEmployerMemberAnnualStatement(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException {
    	
    	try {
    		

    	StringBuilder nativeQuery = new StringBuilder(); 
    	
        nativeQuery.append("SELECT ");
        nativeQuery.append("icamaa.id AS prime_id, ");
        nativeQuery.append("empmemacc.member_no AS member_no, ");
        nativeQuery.append("ica.accounting_year AS ams_year, ");
        nativeQuery.append("icamaad.name_with_initials AS name_with_initials, ");       
        nativeQuery.append("icamaad.person_ref_no as person_ref_no, ");
        nativeQuery.append("icamaad.nic_number AS nic_no, ");       
        nativeQuery.append("icamaad.nic_type AS nic_type, ");
        
        nativeQuery.append("icamaad.passport_number AS passport_no, ");
        nativeQuery.append("ica.interest_percentage_id AS interest_rate, ");
        nativeQuery.append("(icamaa.opening_balance_amount + icamaa.merged_opening_balance_amount) AS opening_balance_amount, ");
        nativeQuery.append("(icamaa.total_allocation+ icamaa.merged_total_allocation) AS contribution_credited_amount, ");
        nativeQuery.append("icamaa.total_interest_amount AS interest_amount, ");
        nativeQuery.append("icamaa.end_member_balance_amount AS year_end_balance , ");
        
        nativeQuery.append("case ");
        nativeQuery.append("  when ");
        nativeQuery.append("   (SELECT count(icamaaa.id) ");
        nativeQuery.append("      from int_calc_amic_member_account_ams_adjustment icamaaa  ");
        nativeQuery.append("         LEFT JOIN int_calc_rmic_member_account_ams icrmaa on icrmaa.id = icamaaa.int_calc_rmic_member_account_ams_id ");
        nativeQuery.append("         LEFT JOIN int_calc_rmic icr on icr.id = icrmaa.int_calc_rmic_id ");
        nativeQuery.append("         LEFT JOIN mst_int_calc_rmic_status micrs on micrs.id = icr.status_id ");


        nativeQuery.append("       where ");
        nativeQuery.append("         icamaaa.int_calc_amic_member_account_ams_id = icamaa.id and micrs.code = 'Approved' ");
        nativeQuery.append("   ) = 0 ");
        nativeQuery.append("  then 'No'  ");
        nativeQuery.append("  ELSE 'Yes'  "); 
        nativeQuery.append("END AS adjesment  ");
        
        
        
        nativeQuery.append("FROM ");
        
        nativeQuery.append("int_calc_amic_member_account_ams icamaa ");
        
        nativeQuery.append("LEFT JOIN int_calc_amic ica ON icamaa.int_calc_amic_id = ica.id ");
        nativeQuery.append("LEFT JOIN member_account mmbracc ON icamaa.member_account_id = mmbracc.id ");      
        nativeQuery.append("LEFT JOIN int_calc_amic_member_account_ams_document icamaad ON icamaa.id = icamaad.int_calc_amic_member_account_ams_id ");      
        nativeQuery.append("LEFT JOIN employer_member_account empmemacc ON mmbracc.id = empmemacc.member_account_id "); 
        
        
//        nativeQuery.append("LEFT JOIN member mmbr ON mmbracc.member_id = mmbr.id ");
//        nativeQuery.append("LEFT JOIN person prsn ON mmbr.person_id = prsn.id ");
//        nativeQuery.append("LEFT JOIN person_identity_nic  pinic ON prsn.id = pinic.person_id ");       
//        nativeQuery.append("LEFT JOIN mst_identity_nic_type mint ON pinic.nic_type_id = mint.id ");
//        nativeQuery.append("LEFT JOIN person_identity_passport pip ON prsn.id = pip.person_id ");
        
        
//        nativeQuery.append("CROSS JOIN (SELECT \\@cnt \\:\\= 0 ) AS dummy ");
        
      
    	List<String> listConditions = new ArrayList<>();
  
    	
 /**
    	if (searchRequest.getFromYear() != null && searchRequest.getToYear()!= null) {
    		listConditions.add(" ica.accounting_year BETWEEN '"+searchRequest.getFromYear()+"' AND '"+searchRequest.getToYear()+"'" );
    	} 	
    	if (searchRequest.getMemberNo() != null) {
    		listConditions.add(" empmemacc.member_no =" + searchRequest.getMemberNo());
    	}
    	if (searchRequest.getEmployerId() != null) {
    		listConditions.add(" empmemacc.employer_id =" + searchRequest.getEmployerId());
    	}
    	
**/    	
    	
    	
    	if (searchRequest.getFromYear() != null && searchRequest.getToYear()!= null) {   		
    		listConditions.add(" ica.accounting_year BETWEEN :start AND :end " );   		
    	} else if(searchRequest.getFromYear() != null) {
    		listConditions.add(" ica.accounting_year > :start " );     		
    	} else if(searchRequest.getToYear()!= null) {
    		listConditions.add(" ica.accounting_year < :to " );    
    	}
    	
    	if (searchRequest.getMemberNo() != null) {   		
    		listConditions.add(" empmemacc.member_no =:mem_no ");   		
    	}
    	if (searchRequest.getEmployerId() != null) {   		
    		listConditions.add(" empmemacc.employer_id =:empyr_id " );
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
    		nativeQuery.append(" ica.status_id = 3 AND ");   		
    		nativeQuery.append(conditions.toString());
    	}
    	else {
    		
        	nativeQuery.append(" WHERE ica.status_id = 3 ");
    	}


        
//        nativeQuery.append(" ");       
//        nativeQuery.append(" ");       
//        nativeQuery.append(" ");
//        nativeQuery.append(" ");       
    	nativeQuery.append(" ORDER BY row_no asc , icamaa.created_at desc");
        Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerMemAnnualStatementMapping");
        
        
    	if (searchRequest.getFromYear() != null) {   		
            query.setParameter("start", searchRequest.getFromYear()); 		
    	} 	
    	if (searchRequest.getToYear() != null) {   		
            query.setParameter("end", searchRequest.getToYear());  	
    	}
    	if (searchRequest.getMemberNo() != null) {   		
            query.setParameter("mem_no", searchRequest.getMemberNo());    		
    	}
    	if (searchRequest.getEmployerId() != null) {    		
            query.setParameter("empyr_id", searchRequest.getEmployerId());
    	}

        

        
    	
    	return query.getResultList();
    	
		}catch(Exception e) {
			
			throw new ApplicationException("exception occurs in dao layer");
			
		}
    }
 	
 	
 	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public List<EmployerMemAnnualStatementResDto> searchEmployerMemberAms(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException {
    	
    	try {
    		
    		
        	StringBuilder nativeQuery = new StringBuilder(); 
        	
            nativeQuery.append("SELECT ");
            nativeQuery.append("icamaa.id AS prime_id, ");
            nativeQuery.append("empmemacc.member_no AS member_no, ");
            nativeQuery.append("ica.accounting_year AS ams_year, ");
            
            
            nativeQuery.append("icamaad.name_with_initials AS name_with_initials, ");       
            nativeQuery.append("icamaad.person_ref_no as person_ref_no, ");
            nativeQuery.append("icamaad.nic_number AS nic_no, ");       
            nativeQuery.append("icamaad.nic_type AS nic_type, ");           
            nativeQuery.append("icamaad.passport_number AS passport_no, ");
            
            
//            nativeQuery.append("prsn.name_with_initials AS name_with_initials, ");       
//            nativeQuery.append("prsn.ref_no as person_ref_no, ");
//            nativeQuery.append("pinic.nic_no AS nic_no, ");       
//            nativeQuery.append("mint.name AS nic_type, ");          
//            nativeQuery.append("pip.passport_no AS passport_no, ");
            
            
            nativeQuery.append("ica.interest_percentage AS interest_rate, ");
            nativeQuery.append("(icamaa.opening_balance_amount + icamaa.merged_opening_balance_amount) AS opening_balance_amount, ");
            nativeQuery.append("(icamaa.total_allocation+ icamaa.merged_total_allocation) AS contribution_credited_amount, ");
            nativeQuery.append("(icamaa.total_interest_amount + icamaa.total_dividend_amount) AS interest_amount, ");
            nativeQuery.append("icamaa.end_member_balance_amount AS year_end_balance , ");
            
            
            nativeQuery.append("case ");
            nativeQuery.append("  when ");
            nativeQuery.append("   (SELECT count(icamaaa.id) ");
            nativeQuery.append("      from int_calc_amic_member_account_ams_adjustment icamaaa  ");
            nativeQuery.append("         LEFT JOIN int_calc_rmic_member_account_ams icrmaa on icrmaa.id = icamaaa.int_calc_rmic_member_account_ams_id ");
            nativeQuery.append("         LEFT JOIN int_calc_rmic icr on icr.id = icrmaa.int_calc_rmic_id ");
            nativeQuery.append("         LEFT JOIN mst_int_calc_rmic_status micrs on micrs.id = icr.status_id ");


            nativeQuery.append("       where ");
            nativeQuery.append("         icamaaa.int_calc_amic_member_account_ams_id = icamaa.id and micrs.name = 'Approved' ");
            nativeQuery.append("   ) = 0 ");
            nativeQuery.append("  then 'No'  ");
            nativeQuery.append("  ELSE 'Yes'  "); 
            nativeQuery.append("END AS adjesment  ");
            
            
            
            nativeQuery.append("FROM ");
            
            nativeQuery.append("int_calc_amic_member_account_ams icamaa ");
            
            nativeQuery.append("INNER JOIN int_calc_amic ica ON icamaa.int_calc_amic_id = ica.id ");
            nativeQuery.append("INNER JOIN mst_int_calc_amic_status micas ON micas.id = ica.status_id ");
            nativeQuery.append("INNER JOIN member_account mmbracc ON icamaa.member_account_id = mmbracc.id ");      
            nativeQuery.append("INNER JOIN int_calc_amic_member_account_ams_document icamaad ON icamaa.id = icamaad.int_calc_amic_member_account_ams_id ");      
            nativeQuery.append("INNER JOIN employer_member_account empmemacc ON mmbracc.id = empmemacc.member_account_id "); 
            
            
//            nativeQuery.append("LEFT JOIN member mmbr ON mmbracc.member_id = mmbr.id ");
//            nativeQuery.append("LEFT JOIN person prsn ON mmbr.person_id = prsn.id ");
//            nativeQuery.append("LEFT JOIN person_identity_nic  pinic ON prsn.id = pinic.person_id ");       
//            nativeQuery.append("LEFT JOIN mst_identity_nic_type mint ON pinic.nic_type_id = mint.id ");
//            nativeQuery.append("LEFT JOIN person_identity_passport pip ON prsn.id = pip.person_id ");
            

    		
        	List<String> listConditions = new ArrayList<>();
        	  
    	    	
        	    	if (searchRequest.getFromYear() != null && searchRequest.getToYear()!= null) {   		
        	    		listConditions.add(" ica.accounting_year BETWEEN :start AND :end " );   		
        	    	}  else if(searchRequest.getFromYear() != null) {
        	    		listConditions.add(" ica.accounting_year >= :start " );     		
        	    	} else if(searchRequest.getToYear()!= null) {
        	    		listConditions.add(" ica.accounting_year <= :end " );    
        	    	}	
        	    	if (searchRequest.getMemberNo() != null) {   		
        	    		listConditions.add(" empmemacc.id =:mem_account_id ");   		
        	    	}
        	    	if (searchRequest.getEmployerId() != null) {   		
        	    		listConditions.add(" empmemacc.employer_id =:empyr_id " );
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
        	    		nativeQuery.append(" micas.name = 'Approved' AND ");   		
        	    		nativeQuery.append(conditions.toString());
        	    	}
        	    	else {
        	    		
        	        	nativeQuery.append(" WHERE micas.name = 'Approved' ");
        	    	}
  		
    		
        	    	nativeQuery.append(" ORDER BY ica.accounting_year desc");
        	        Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerMemAnnualStatementMapping");
        	        
        	        
        	    	if (searchRequest.getFromYear() != null) {   		
        	            query.setParameter("start", searchRequest.getFromYear()); 		
        	    	} 	
        	    	if (searchRequest.getToYear() != null) {   		
        	            query.setParameter("end", searchRequest.getToYear());  	
        	    	}	
        	    	if (searchRequest.getMemberNo() != null) {   		
        	            query.setParameter("mem_account_id", searchRequest.getMemberNo());    		
        	    	}
        	    	if (searchRequest.getEmployerId() != null) {    		
        	            query.setParameter("empyr_id", searchRequest.getEmployerId());
        	    	}       	        
        	    	
        	    	return query.getResultList();	

        	
    		}catch(Exception e) {
    			
    			throw new ApplicationException("exception occurs in dao layer");
    			
    		}
      }


}
