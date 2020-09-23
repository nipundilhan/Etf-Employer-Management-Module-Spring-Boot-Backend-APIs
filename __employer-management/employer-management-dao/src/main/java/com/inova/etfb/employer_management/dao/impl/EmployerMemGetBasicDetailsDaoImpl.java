package com.inova.etfb.employer_management.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inova.applogger.util.MethodLogging;
import com.inova.etfb.employer_management.dao.EmployrMemGetBasicDetailsDao;
import com.inova.etfb.employer_management.request.MemberAnnualStatementSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerMemBasicDetRespDto;
import com.inova.exception.ApplicationException;

@Repository
public class EmployerMemGetBasicDetailsDaoImpl implements EmployrMemGetBasicDetailsDao {

	@PersistenceContext
    EntityManager manager;

	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public EmployerMemBasicDetRespDto getEmployerMemberBasicDetails(MemberAnnualStatementSearchRequest searchRequest) throws ApplicationException {
    	
    	try {
    		

    	StringBuilder nativeQuery = new StringBuilder(); 
    	
        nativeQuery.append("SELECT ");
        nativeQuery.append("empmemacc.id AS prime_id, ");
        nativeQuery.append("empmemacc.member_no AS member_no, ");
        nativeQuery.append("prsn.name_with_initials AS name_with_initials, ");
        nativeQuery.append("prsn.first_name  AS first_name, ");
        nativeQuery.append("prsn.ref_no as person_ref_no, ");      
//        nativeQuery.append(" (SELECT prsn_nic.nic_no  from person_identity_nic prsn_nic  WHERE prsn.id = prsn_nic.person_id and prsn_nic.active = true  limit 1 ) AS nic_no, ");
//        nativeQuery.append(" (SELECT mst_id_typ.code  from person_identity_nic prsn_nic INNER JOIN mst_identity_nic_type mst_id_typ ON prsn_nic.nic_type_id = mst_id_typ.id ");       
//        nativeQuery.append(" 	 WHERE prsn.id = prsn_nic.person_id and prsn_nic.active = true  limit 1 ) AS nic_type, ");
//        nativeQuery.append(" (SELECT mst_id_typ.name  from person_identity_nic prsn_nic INNER JOIN mst_identity_nic_type mst_id_typ ON prsn_nic.nic_type_id = mst_id_typ.id ");       
//        nativeQuery.append(" 	 WHERE prsn.id = prsn_nic.person_id and prsn_nic.active = true  limit 1 ) AS nic_type_name, ");        
//        nativeQuery.append(" 		  (SELECT prsn_psprt.passport_no  FROM person_identity_passport prsn_psprt WHERE prsn.id = prsn_psprt.person_id AND  prsn_psprt.active =  true LIMIT 1  ) AS passport_no, ");
        nativeQuery.append("pinic.nic_no AS nic_no, ");
        nativeQuery.append("mint.code AS nic_type, ");
        nativeQuery.append("mint.name AS nic_type_name, ");
        nativeQuery.append("pip.passport_no AS passport_no, ");
        nativeQuery.append("orgnztn.name  AS created_organization, ");
        nativeQuery.append("usr.display_name AS created_user, ");
        nativeQuery.append("empmemacc.created_at AS created_at, ");        
        nativeQuery.append("empmemacc.designation	AS designation ");
                
        nativeQuery.append("FROM ");
        
        nativeQuery.append("employer_member_account empmemacc ");
        nativeQuery.append("JOIN member_account mmbracc ON empmemacc.member_account_id = mmbracc.id ");
        nativeQuery.append("JOIN member mmbr ON mmbracc.member_id = mmbr.id ");
        nativeQuery.append("JOIN person prsn ON mmbr.person_id = prsn.id ");
        nativeQuery.append("JOIN person_identity_nic  pinic ON prsn.id = pinic.person_id ");
        nativeQuery.append("JOIN mst_identity_nic_type mint ON pinic.nic_type_id = mint.id ");
        nativeQuery.append("JOIN person_identity_passport pip ON prsn.id = pip.person_id ");
        nativeQuery.append("JOIN organization orgnztn ON orgnztn.id = empmemacc.created_organization_id ");
        nativeQuery.append("JOIN user usr ON usr.id = empmemacc.created_by ");
        
        
		if (searchRequest.getEmployerId() != null && searchRequest.getMemberNo() != null) {
			nativeQuery.append(" WHERE ");   
//			nativeQuery.append(" empmemacc.employer_id = " + searchRequest.getEmployerId());
//			nativeQuery.append(" AND ");
			nativeQuery.append(" empmemacc.id = " + searchRequest.getMemberNo());
			nativeQuery.append("  AND pinic.active = TRUE AND pip.active = true ");
			
						
		}
        
		nativeQuery.append(" LIMIT 1 ");
        
        
        
		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerMemBasicDetMapping");
		return (EmployerMemBasicDetRespDto) query.getSingleResult();

    	
		}catch(Exception e) {
			
			throw new ApplicationException("exception occurs in dao layer");
			
		}
    }
	
	
	
	@MethodLogging
 	@SuppressWarnings("unchecked")
 	@Override 
    public EmployerMemBasicDetRespDto getEmployerMemberBasicDetailsUsingMemberAccountId(Long id) throws ApplicationException {
    	
    	try {
    		

    	StringBuilder nativeQuery = new StringBuilder(); 
    	
        nativeQuery.append("SELECT ");
        nativeQuery.append("empmemacc.id AS prime_id, ");
        nativeQuery.append("empmemacc.member_no AS member_no, ");
        nativeQuery.append("prsn.name_with_initials AS name_with_initials, ");
        nativeQuery.append("prsn.first_name  AS first_name, ");
        nativeQuery.append("prsn.ref_no as person_ref_no, ");  
        nativeQuery.append("prsn.prefix_ref_no AS person_prefix_ref_no , ");
//        nativeQuery.append(" (SELECT prsn_nic.nic_no  from person_identity_nic prsn_nic  WHERE prsn.id = prsn_nic.person_id and prsn_nic.active = true  limit 1 ) AS nic_no, ");
//        nativeQuery.append(" (SELECT mst_id_typ.code  from person_identity_nic prsn_nic INNER JOIN mst_identity_nic_type mst_id_typ ON prsn_nic.nic_type_id = mst_id_typ.id ");       
//        nativeQuery.append(" 	 WHERE prsn.id = prsn_nic.person_id and prsn_nic.active = true  limit 1 ) AS nic_type, ");
//        nativeQuery.append(" (SELECT mst_id_typ.name  from person_identity_nic prsn_nic INNER JOIN mst_identity_nic_type mst_id_typ ON prsn_nic.nic_type_id = mst_id_typ.id ");       
//        nativeQuery.append(" 	 WHERE prsn.id = prsn_nic.person_id and prsn_nic.active = true  limit 1 ) AS nic_type_name, ");        
//        nativeQuery.append(" 		  (SELECT prsn_psprt.passport_no  FROM person_identity_passport prsn_psprt WHERE prsn.id = prsn_psprt.person_id AND  prsn_psprt.active =  true LIMIT 1  ) AS passport_no, ");
        nativeQuery.append("pinic.nic_no AS nic_no, ");
        nativeQuery.append("mint.code AS nic_type, ");
        nativeQuery.append("mint.name AS nic_type_name, ");
        nativeQuery.append("pip.passport_no AS passport_no, ");
        nativeQuery.append("orgnztn.name  AS created_organization, ");
        nativeQuery.append("usr.display_name AS created_user, ");
        nativeQuery.append("empmemacc.created_at AS created_at, ");        
        nativeQuery.append("empmemacc.designation	AS designation ");
                
        nativeQuery.append("FROM ");
        
        nativeQuery.append("employer_member_account empmemacc ");
        nativeQuery.append("JOIN member_account mmbracc ON empmemacc.member_account_id = mmbracc.id ");
        nativeQuery.append("JOIN member mmbr ON mmbracc.member_id = mmbr.id ");
        nativeQuery.append("JOIN person prsn ON mmbr.person_id = prsn.id ");
        nativeQuery.append("JOIN person_identity_nic  pinic ON prsn.id = pinic.person_id ");
        nativeQuery.append("JOIN mst_identity_nic_type mint ON pinic.nic_type_id = mint.id ");
        nativeQuery.append("JOIN person_identity_passport pip ON prsn.id = pip.person_id ");
        nativeQuery.append("JOIN organization orgnztn ON orgnztn.id = empmemacc.created_organization_id ");
        nativeQuery.append("JOIN user usr ON usr.id = empmemacc.created_by ");
        
        
		if (id != null) {
			nativeQuery.append(" WHERE ");   
//			nativeQuery.append(" empmemacc.employer_id = " + searchRequest.getEmployerId());
//			nativeQuery.append(" AND ");
			nativeQuery.append(" empmemacc.id = " + id);
			nativeQuery.append("  AND pinic.active = TRUE AND pip.active = true ");
			
						
		}
        
		nativeQuery.append(" LIMIT 1 ");
        
        
        
		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerMemBasicDetMapping");
		return (EmployerMemBasicDetRespDto) query.getSingleResult();

    	
		}catch(Exception e) {
			
			return null;
			
		}
    }

}
