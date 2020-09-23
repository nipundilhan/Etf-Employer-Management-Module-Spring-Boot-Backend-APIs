package com.inova.etfb.employer_management.dao.impl;

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
import com.inova.etfb.employer_management.dao.ViewEmployerProfileBasicDetailsDao;
import com.inova.etfb.employer_management.request.ViewEmployerBasicDetailsRequest;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerHistoryStartDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileBasicDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerStatusHistoryRespDto;

@Repository
public class ViewEmployerProfileBasicDetailsDaoImpl implements ViewEmployerProfileBasicDetailsDao{


    @PersistenceContext
    EntityManager manager;
    
	@PersistenceContext
	EntityManager entittyManager;
	
	
	

 	@MethodLogging
	public EmployerCurrentHistoryDateRespDto getDirectorDetailsHistory(ViewEmployerBasicDetailsRequest req) {			
//		History Types
//		0 - first_one
//		1 - last_one
//		2 - previous
//		3 - next
		
		StringBuilder nativeQuery = new StringBuilder();
		
		nativeQuery.append("SELECT ");
		nativeQuery.append("employer_history.id AS history_id, ");
		nativeQuery.append("employer_history.created_at AS updated_at ");
		nativeQuery.append("FROM  ");
		nativeQuery.append("employer_history ");			
		
		switch (req.getHistoryType()) {
		  case 0:
						  
			  nativeQuery.append("where employer_history.employer_id  =:employer_id ");
			  nativeQuery.append("ORDER BY  employer_history.created_at ASC , employer_history.id ASC ");
			  				  
		    break;
		  case 1:
			  
			  nativeQuery.append("where employer_history.employer_id  =:employer_id ");
			  nativeQuery.append("ORDER BY  employer_history.created_at DESC , employer_history.id DESC ");
			  
		    break;
		  case 2:

			  nativeQuery.append("where employer_history.employer_id  =:employer_id ");
			  nativeQuery.append("AND employer_history.created_at < (SELECT employer_history.created_at FROM employer_history WHERE employer_history.id =:employer_history_id ) ");
			  nativeQuery.append("ORDER BY  employer_history.created_at DESC , employer_history.id DESC  ");

		    break;
		  case 3:
			  
			  nativeQuery.append("where employer_history.employer_id  =:employer_id ");
			  nativeQuery.append("AND employer_history.created_at > (SELECT employer_history.created_at FROM employer_history WHERE employer_history.id =:employer_history_id ) ");
			  nativeQuery.append("ORDER BY employer_history.created_at ASC, employer_history.id ASC ");

		    break;
		}
		
		nativeQuery.append(" LIMIT 1 ");	
		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerCurrentHistoryDateResponseMapping");	
		query.setParameter("employer_id", req.getEmployerId());
		if(req.getHistoryType()== 2 || req.getHistoryType()== 3) {
			query.setParameter("employer_history_id", req.getEmployerHistoryTableId() );
		}
		
		
		try{
			return (EmployerCurrentHistoryDateRespDto) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}			
			
	}
	
	public EmployerProfileBasicDetailsRespDto getEmployerDetails(ViewEmployerBasicDetailsRequest req) {
				
		StringBuilder nativeQuery = new StringBuilder();
				
		if(req.getHistory()) {
		nativeQuery.append("SELECT \r\n" + 
				"employer_interim.id AS employerId,\r\n" + 
				"employer_interim.epf_no AS epfNo,\r\n" + 
				"NULL AS refNo,\r\n" + 
				"NULL AS prefixRefNo,\r\n" + 
				"employer_interim.business_registration_no AS brn,\r\n" + 
				"employer_interim.`name` AS engName,\r\n" + 
				"employer_interim.name_sin AS sinName,\r\n" + 
				"employer_interim.name_tam AS tamName,\r\n" + 
				"employer_interim.employer_type_id AS empTypeId,\r\n" + 
				"mst_employer_type.`code` AS empTypeCode,\r\n" + 
				"mst_employer_type.`name` AS empTypeName,\r\n" + 
				"employer_interim.legacy_epf_no AS legacyEpfNo,\r\n" + 
				"employer_interim.industry_type_id AS industryTypeId,\r\n" + 
				"mst_employer_industry_type.name_eng AS industryTypeName,\r\n" + 
				"mst_employer_nature_business.name_eng AS natureOfBusiness,\r\n" + 
				"mst_employer_organization_type.`name` AS organizationType,\r\n" + 
				"employer_interim.date_liable_payment AS dateLiablePayment,\r\n" + 
				"mst_language.`name` AS preferredLanguage,\r\n" + 
				"employer_interim.government_entity AS governmentEntity,\r\n" + 
				"employer_interim.online_r4_requested AS onlineRemittanceRequested,\r\n" + 
				"employer_interim.online_ams_requested AS onlineAmsRequested,\r\n" + 
				"mobile.`value` AS verificationMobileNo,\r\n" + 
				"email.`value` AS verificationEmail,\r\n" + 
				"employer_interim.employer_status_id AS employerStatusId, \r\n"+
				"mst_employer_status.name AS employerStatus,\r\n" + 
				"NULL AS inactiveReason,\r\n" + 
				"NULL AS availableBalance,\r\n" + 
				"employer_interim.note AS employerNote,\r\n" + 
				"employer_history.created_at AS updateAt,\r\n" + 
				"hstoryUser.display_name AS updateBy,\r\n" + 
				"dmu_inbound.ref_no AS dmuInboundRefNo,\r\n" + 
				"dmu_inbound.prefix_ref_no AS dmuInboundPrefixRefNo,\r\n" + 
				"service_counter.ref_no AS serviceCounterRefNo,\r\n" + 
				"service_counter.prefix_ref_no AS serviceCounterPrefixRefNo,\r\n" + 
				"service_request.ref_no AS serviceRequestRefNo,\r\n" + 
				"service_request.prefix_ref_no AS serviceRequestPrefixRefNo,\r\n" + 
				"(CASE\r\n" + 
				"WHEN employer_history.created_organization_id IS NOT NULL THEN historyOrg.name\r\n" + 
				"WHEN employer_request_service_counter_dmu.portal = 1 THEN 'Emplyer Portal'\r\n" + 
				"ELSE ''\r\n" + 
				"END) AS updateEtfbBranch,\r\n" + 
				"employer_request_update.epf_no AS starEpfNo,\r\n" + 
				"employer_request_update.business_registration_no AS starBRN,\r\n" + 
				"employer_request_update.`name` AS starEmpName,\r\n" + 
				"employer_request_update.name_sin AS starEmpNameSinhala,\r\n" + 
				"employer_request_update.name_tam AS starEmpNameTamil,\r\n" + 
				"employer_request_update.employer_type_id AS starEmployerType,\r\n" + 
				"NULL AS starLegacyEpfNo,\r\n" + 
				"employer_request_update.industry_type_id AS starIndustryType,\r\n" + 
				"employer_request_update.nature_of_business_id AS starNatureOfBusiness,\r\n" + 
				"employer_request_update.employer_organization_type_id AS starOrganizationType,\r\n" + 
				"employer_request_update.date_liable_payment AS starDateLiableForPayment,\r\n" + 
				"employer_request_update.preferred_language_id AS starPreferredLanguage,\r\n" + 
				"employer_request_update.government_entity AS starGovernmentEntity,\r\n" + 
				"employer_request_update.online_r4_requested AS starOnlineRemitanceDetails,\r\n" + 
				"employer_request_update.online_ams_requested AS starOnlineAmsRequested,\r\n" + 
				"employer_request_update.verification_mobile_id AS starVerificationMobileNo,\r\n" + 
				"employer_request_update.verification_email_id AS starVerificationEmail,\r\n" + 
				"employer_history.id AS employerHistoryId ");
		
		nativeQuery.append("FROM employer_history\r\n" + 
				"JOIN  employer_interim ON employer_history.employer_interim_id = employer_interim.id\r\n" + 
				"LEFT JOIN mst_employer_type ON employer_interim.employer_type_id = mst_employer_type.id\r\n" + 
				"LEFT JOIN mst_employer_industry_type ON employer_interim.industry_type_id = mst_employer_industry_type.id\r\n" + 
				"LEFT JOIN mst_employer_nature_business ON employer_interim.nature_of_business_id = mst_employer_nature_business.id\r\n" + 
				"LEFT JOIN mst_employer_organization_type ON employer_interim.employer_organization_type_id = mst_employer_organization_type.id\r\n" + 
				"LEFT JOIN mst_language ON employer_interim.preferred_language_id = mst_language.id\r\n" + 
				"LEFT JOIN contact_info mobile ON employer_interim.verification_mobile_id = mobile.id\r\n" + 
				"LEFT JOIN contact_info email ON employer_interim.verification_email_id = email.id\r\n" + 
				"LEFT JOIN employer_request_update ON employer_interim.id = employer_request_update.employer_interim_id\r\n" + 
				"LEFT JOIN employer_request_service_counter_dmu ON employer_history.employer_request_service_counter_dmu_id = employer_request_service_counter_dmu.id\r\n" + 
				"LEFT JOIN dmu_inbound ON employer_request_service_counter_dmu.dmu_inbound_id = dmu_inbound.id\r\n" + 
				"LEFT JOIN service_request ON employer_request_service_counter_dmu.service_request_id = service_request.id\r\n" + 
				"LEFT JOIN service_counter_requirement_type ON employer_request_service_counter_dmu.service_counter_requirement_type_id = service_counter_requirement_type.id\r\n" + 
				"LEFT JOIN service_counter ON service_counter_requirement_type.service_counter_id = service_counter.id\r\n" + 
				"LEFT JOIN organization historyOrg ON employer_history.created_organization_id = historyOrg.id\r\n" + 
				"LEFT JOIN mst_employer_status  ON mst_employer_status.id = employer_interim.employer_status_id \r\n"+
				"LEFT JOIN `user` hstoryUser ON employer_history.created_by = hstoryUser.id   ");
		
		}else {
			nativeQuery.append("SELECT \r\n" + 
					"employer.id AS employerId,\r\n" + 
					"employer.epf_no AS epfNo,\r\n" + 
					"employer.ref_no AS refNo,\r\n" + 
					"employer.prefix_ref_no AS prefixRefNo,\r\n" + 
					"employer.business_registration_no AS brn,\r\n" + 
					"employer.`name` AS engName,\r\n" + 
					"employer.name_sin AS sinName,\r\n" + 
					"employer.name_tam AS tamName,\r\n" + 
					"employer.employer_type_id AS empTypeId,\r\n" + 
					"mst_employer_type.`code` AS empTypeCode,\r\n" + 
					"mst_employer_type.`name` AS empTypeName,\r\n" + 
					"employer.legacy_epf_no AS legacyEpfNo,\r\n" + 
					"employer.industry_type_id AS industryTypeId,\r\n" + 
					"mst_employer_industry_type.name_eng AS industryTypeName,\r\n" + 
					"mst_employer_nature_business.name_eng AS natureOfBusiness,\r\n" + 
					"mst_employer_organization_type.`name` AS organizationType,\r\n" + 
					"employer.date_liable_payment AS dateLiablePayment,\r\n" + 
					"mst_language.`name` AS preferredLanguage,\r\n" + 
					"employer.government_entity AS governmentEntity,\r\n" + 
					"employer.online_r4_requested AS onlineRemittanceRequested,\r\n" + 
					"employer.online_ams_requested AS onlineAmsRequested,\r\n" + 
					"mobile.`value` AS verificationMobileNo,\r\n" + 
					"email.`value` AS verificationEmail,\r\n" + 
					"employer.status_id AS employerStatusId,\r\n"+
					"mst_employer_status.`name` AS employerStatus,\r\n" + 
					"mst_reason.name_eng AS inactiveReason,\r\n" + 
					"employer_available_balance.available_balance_amount AS availableBalance,\r\n" + 
					"employer.note AS employerNote,\r\n" + 
					"NULL AS updateAt,\r\n" + 
					"NULL AS updateBy,\r\n" + 
					"NULL AS dmuInboundRefNo,\r\n" + 
					"NULL AS dmuInboundPrefixRefNo,\r\n" + 
					"NULL AS serviceCounterRefNo,\r\n" + 
					"NULL AS serviceCounterPrefixRefNo,\r\n" + 
					"NULL AS serviceRequestRefNo,\r\n" + 
					"NULL AS serviceRequestPrefixRefNo,\r\n" + 
					"NULL AS updateEtfbBranch,\r\n" + 
					"NULL AS starEpfNo,\r\n" + 
					"NULL AS starBRN,\r\n" + 
					"NULL AS starEmpName,\r\n" + 
					"NULL AS starEmpNameSinhala,\r\n" + 
					"NULL AS starEmpNameTamil,\r\n" + 
					"NULL AS starEmployerType,\r\n" + 
					"NULL AS starLegacyEpfNo,\r\n" + 
					"NULL AS starIndustryType,\r\n" + 
					"NULL AS starNatureOfBusiness,\r\n" + 
					"NULL AS starOrganizationType,\r\n" + 
					"NULL AS starDateLiableForPayment,\r\n" + 
					"NULL AS starPreferredLanguage,\r\n" + 
					"NULL AS starGovernmentEntity,\r\n" + 
					"NULL AS starOnlineRemitanceDetails,\r\n" + 
					"NULL AS starOnlineAmsRequested,\r\n" + 
					"NULL AS starVerificationMobileNo,\r\n" + 
					"NULL AS starVerificationEmail,\r\n" + 
					"NULL AS employerHistoryId    ");
			
			nativeQuery.append("FROM employer\r\n" + 
					"LEFT JOIN mst_employer_type ON employer.employer_type_id = mst_employer_type.id\r\n" + 
					"LEFT JOIN mst_employer_industry_type ON employer.industry_type_id = mst_employer_industry_type.id\r\n" + 
					"LEFT JOIN mst_employer_nature_business ON employer.nature_of_business_id = mst_employer_nature_business.id\r\n" + 
					"LEFT JOIN mst_employer_organization_type ON employer.employer_organization_type_id = mst_employer_organization_type.id\r\n" + 
					"LEFT JOIN mst_language ON employer.preferred_language_id = mst_language.id\r\n" + 
					"LEFT JOIN mst_employer_status ON employer.status_id = mst_employer_status.id\r\n" + 
					"LEFT JOIN mst_reason ON employer.inactive_reason_id = mst_reason.id\r\n" + 
					"LEFT JOIN employer_available_balance ON employer.available_balance_id = employer_available_balance.id\r\n" + 
					"LEFT JOIN contact_info mobile ON employer.verification_mobile_id = mobile.id\r\n" + 
					"LEFT JOIN contact_info email ON employer.verification_email_id = email.id ");				
		}
		
		
		List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();

		if (req.getHistory()) {
			if (req.getEmployerHistoryTableId() != null) {
				listConditions.add(" employer_history.id   =:employer_history_id  ");
				paramMap.put("employer_history_id", req.getEmployerHistoryTableId());
			}
		} else {
			if(req.getEmployerId() != null) {
				listConditions.add(" employer.id =:employer_id  ");
				paramMap.put("employer_id", req.getEmployerId());				
			}

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
		nativeQuery.append(conditions.toString());
		}

		Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerProfleDetailsMapping");

		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		
		try{
			return (EmployerProfileBasicDetailsRespDto) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}	
					
	}
	
	
	public List<EmployerContactRespDto> getEmployerContactDetails(ViewEmployerBasicDetailsRequest req) {
		
		StringBuilder nativeQuery = new StringBuilder();
		
		if (req.getHistory()) {

			nativeQuery.append("SELECT\r\n" + "employer_interim_general_contact.id AS person_contact_id,\r\n"
					+ "mst_contact_type.name_eng AS contact_type_name,\r\n" + "contact_info.`value` AS contact_no,\r\n"
					+ "employer_interim_general_contact.active AS active,\r\n"
					+ "contact_info.incorrect_contact AS incorrect_contact,\r\n"
					+ "employer_interim_general_contact.contact_sms AS use_for_sms,\r\n"
					+ "employer_interim_general_contact.contact_email AS use_for_mail,\r\n"
					+ "contact_info.note AS note ");

			nativeQuery.append("FROM employer_interim_general_contact\r\n" + 
					"JOIN employer_interim ON employer_interim.id = employer_interim_general_contact.employer_interim_id\r\n" + 
					"JOIN employer_history ON employer_history.employer_interim_id = employer_interim.id\r\n" + 
					"JOIN contact_info ON employer_interim_general_contact.contact_info_id = contact_info.id\r\n" + 
					"LEFT JOIN mst_contact_type ON contact_info.contact_type_id = mst_contact_type.id  ");
		} else {
			nativeQuery.append(" SELECT\r\n" + 
					"employer_general_contact.id AS person_contact_id,\r\n" + 
					"mst_contact_type.name_eng AS contact_type_name,\r\n" + 
					"contact_info.`value` AS contact_no,\r\n" + 
					"employer_general_contact.active AS active,\r\n" + 
					"contact_info.incorrect_contact AS incorrect_contact,\r\n" + 
					"employer_general_contact.contact_sms AS use_for_sms,\r\n" + 
					"employer_general_contact.contact_email AS use_for_mail,\r\n" + 
					"contact_info.note AS note   ");
			
			nativeQuery.append("FROM employer_general_contact\r\n" + 
					"JOIN contact_info ON employer_general_contact.contact_info_id = contact_info.id\r\n" + 
					"LEFT JOIN mst_contact_type ON contact_info.contact_type_id = mst_contact_type.id    ");

		}	

		
		List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();

		if (req.getHistory()) {
			if (req.getEmployerHistoryTableId() != null) {
				listConditions.add(" employer_history.id  =:employer_history_id  ");
				paramMap.put("employer_history_id", req.getEmployerHistoryTableId());
			}
		} else {
			
			if(req.getEmployerId() != null) {
				listConditions.add(" employer_general_contact.employer_id =:employer_id  ");
				paramMap.put("employer_id", req.getEmployerId());				
			}

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
			nativeQuery.append(conditions.toString());

		}
	
		Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerContactResponseDetailsMapping");

		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		return query.getResultList();
	
	}
	
	
	public  List<EmployerStatusHistoryRespDto> getEmployerStatusHistoryDetails(ViewEmployerBasicDetailsRequest req){
		
		StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append(" SELECT\r\n" + 
					"employer_status_history.id AS historyId,\r\n" + 
					"mst_employer_status.`name` AS statusHistory,\r\n" + 
					"mst_reason.name_eng AS inactiveReason,\r\n" + 
					"employer_status_history.created_at AS createdAt,\r\n" + 
					"user.display_name AS createdBy,\r\n" + 
					"organization.`name` AS branch  ");			
			nativeQuery.append("FROM\r\n" + 
					"employer_status_history\r\n" + 
					"JOIN mst_employer_status ON employer_status_history.status_id = mst_employer_status.id\r\n" + 
					"JOIN organization ON employer_status_history.created_organization_id = organization.id\r\n" + 
					"JOIN `user` ON employer_status_history.created_by = `user`.id\r\n" + 
					"LEFT JOIN mst_reason ON employer_status_history.inactive_reason_id = mst_reason.id   ");

		
		List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();


			
			if(req.getEmployerId() != null) {
				listConditions.add(" employer_status_history.employer_id =:employer_id  ");
				paramMap.put("employer_id", req.getEmployerId());				
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
			nativeQuery.append(conditions.toString());

		}
	
		Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerStatusHistoryDetailsMapping");

		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		return query.getResultList();		
		
	}
	
	
	public EmployerHistoryEndDateRespDto getEmployerHistoryEndDate(ViewEmployerBasicDetailsRequest req) {
		
		StringBuilder nativeQuery = new StringBuilder();
		
		nativeQuery.append("SELECT ");
		nativeQuery.append("employer_history.id AS history_id, ");
		nativeQuery.append("employer_history.created_at AS end_date ");
		nativeQuery.append("FROM  ");
		nativeQuery.append("employer_history ");		
		nativeQuery.append("where employer_history.employer_id  =:employer_id ");
		nativeQuery.append("ORDER BY  employer_history.created_at DESC , employer_history.id DESC ");
		nativeQuery.append(" LIMIT 1 ");	
		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerEndHistoryDateMapping");	
		query.setParameter("employer_id", req.getEmployerId());	
		
		
		try{
			return (EmployerHistoryEndDateRespDto) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}	
		
	}
	
	public EmployerHistoryStartDateRespDto getEmployerHistoryStartDate(ViewEmployerBasicDetailsRequest req) {
		
		StringBuilder nativeQuery = new StringBuilder();
		
		nativeQuery.append("SELECT ");
		nativeQuery.append("employer_history.id AS history_id, ");
		nativeQuery.append("employer_history.created_at AS start_date ");
		nativeQuery.append("FROM  ");
		nativeQuery.append("employer_history ");
		
		nativeQuery.append("where employer_history.employer_id  =:employer_id ");
		nativeQuery.append("ORDER BY  employer_history.created_at ASC , employer_history.id ASC ");
		
		nativeQuery.append(" LIMIT 1 ");	
		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerStartHistoryDateResponseMapping");	
		query.setParameter("employer_id", req.getEmployerId());
		
		try{
			return (EmployerHistoryStartDateRespDto) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}	
		
		
	}
	
	

	
	

}
