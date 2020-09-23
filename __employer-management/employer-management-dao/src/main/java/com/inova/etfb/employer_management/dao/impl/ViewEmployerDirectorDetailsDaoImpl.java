package com.inova.etfb.employer_management.dao.impl;

import java.math.BigDecimal;
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
import com.inova.etfb.employer_management.dao.ViewEmployerDirectorDetailsDao;
import com.inova.etfb.employer_management.request.ViewEmployerAvailableBalanceSearchRequest;
import com.inova.etfb.employer_management.request.ViewEmployerDirectorDetailsRequest;
import com.inova.etfb.employer_management.wrapper.EmployerAddressRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorInformationRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorMemberDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorPersonalDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorSignatureRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateHistoryDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateStartDateRespDto;

import com.inova.etfb.employer_management.wrapper.ViewEmployerDirectorDetailsRespDto;


@Repository
public class ViewEmployerDirectorDetailsDaoImpl implements ViewEmployerDirectorDetailsDao{

    @PersistenceContext
    EntityManager manager;

	@PersistenceContext
	EntityManager entittyManager;

	@SuppressWarnings("unchecked")
	@Override
	@MethodLogging
	public List<ViewEmployerDirectorDetailsRespDto> getDirectorDetails(Long employerId) {
		StringBuilder nativeQuery = new StringBuilder();

		nativeQuery.append("SELECT ");
		nativeQuery.append("ROW_NUMBER() OVER (ORDER BY employer_director.id) rowNumber, ");
		nativeQuery.append("employer_director.id AS directorId, ");
		nativeQuery.append(" (CASE          \r\n" +
				"            WHEN person.prefix_ref_no IS NOT NULL THEN CONCAT(person.prefix_ref_no,\r\n" +
				"            person.ref_no)       \r\n" +
				"            ELSE person.ref_no      \r\n" +
				"        END) AS refNo, ");
		nativeQuery.append("person.full_name AS fullName, ");
		nativeQuery.append("employer_director.date_joined AS joinedDate, ");
		nativeQuery.append("employer_director.date_terrminated AS terminatedDate, ");

		nativeQuery.append("employer_director.active AS isActive, ");
		nativeQuery.append("employer_director.designation AS designation, ");


		nativeQuery.append("(SELECT prsn_idntty_nic.nic_no\r\n" +
				"		   FROM person prsn1 \r\n" +
				"			JOIN person_identity_nic prsn_idntty_nic ON  prsn_idntty_nic.person_id = prsn1.id\r\n" +
				"			JOIN mst_identity_nic_type mst_idntty_nic_typ ON mst_idntty_nic_typ.id = prsn_idntty_nic.nic_type_id\r\n" +
				"		   WHERE prsn1.id = person.id AND prsn_idntty_nic.active = true\r\n" +
				"		   LIMIT 1\r\n" +
				"		 ) AS nic_no , ");
		nativeQuery.append(" (SELECT mst_idntty_nic_typ.name\r\n" +
				"		   FROM person prsn1 \r\n" +
				"			JOIN person_identity_nic prsn_idntty_nic ON  prsn_idntty_nic.person_id = prsn1.id\r\n" +
				"			JOIN mst_identity_nic_type mst_idntty_nic_typ ON mst_idntty_nic_typ.id = prsn_idntty_nic.nic_type_id\r\n" +
				"		   WHERE prsn1.id = person.id AND prsn_idntty_nic.active = true\r\n" +
				"		   LIMIT 1\r\n" +
				"		 ) AS nic_code , ");
		nativeQuery.append("(SELECT mst_idntty_nic_typ.description\r\n" +
				"		   FROM person prsn1 \r\n" +
				"			JOIN person_identity_nic prsn_idntty_nic ON  prsn_idntty_nic.person_id = prsn1.id\r\n" +
				"			JOIN mst_identity_nic_type mst_idntty_nic_typ ON mst_idntty_nic_typ.id = prsn_idntty_nic.nic_type_id\r\n" +
				"		   WHERE prsn1.id = person.id AND prsn_idntty_nic.active = true\r\n" +
				"		   LIMIT 1\r\n" +
				"		 ) AS nic_name , ");

		nativeQuery.append("(SELECT prsn_idnty_psprt.passport_no from person prsn2\r\n" +
				"		 	JOIN person_identity_passport prsn_idnty_psprt ON prsn_idnty_psprt.person_id = prsn2.id\r\n" +
				"		 	JOIN mst_country mst_cntry ON mst_cntry.id = prsn_idnty_psprt.country_id\r\n" +
				"		 	WHERE  prsn2.id = person.id AND prsn_idnty_psprt.active = true\r\n" +
				"		 	LIMIT 1		    \r\n" +
				"		 ) AS passport_details, ");

		nativeQuery.append("'\' AS  action ");
		nativeQuery.append("FROM employer_director ");
		nativeQuery.append("JOIN person AS person ON person.id = employer_director.person_id ");

		List<String> whereConditions = new ArrayList<String>();
		Map<String, Object> paramMap = new HashMap<>();
		if (employerId != null) {
			whereConditions.add("employer_director.employer_id  =:employerId ");
			paramMap.put("employerId", employerId);
		}


		if (!whereConditions.isEmpty()) {
			StringBuilder conditions = new StringBuilder();
			for (int i = 0; i < whereConditions.size(); i++) {
				if (i != 0) {
					conditions.append(" AND ");
					conditions.append(whereConditions.get(i));
				} else {
					conditions.append(whereConditions.get(i));
				}
			}
			nativeQuery.append(" WHERE ");

			nativeQuery.append(conditions.toString());
		}

		nativeQuery.append(" ORDER BY employer_director.created_at DESC");

		Query query = this.entittyManager.createNativeQuery(nativeQuery.toString(), "ViewEmployerDirectorDetails");
		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		return query.getResultList();
	}


	@Override
	public String getDirectorType(Long employerId) {
		// TODO Auto-generated method stub
		StringBuilder nativeQuery = new StringBuilder();
		nativeQuery.append("SELECT mst_emplyr_orgnztn_typ.director_name As directorName  ");
		nativeQuery.append("FROM employer_director as emplyr_dirctr ");
		nativeQuery.append("JOIN employer emplyr ON emplyr.id = emplyr_dirctr.employer_id ");
		nativeQuery.append("JOIN mst_employer_organization_type mst_emplyr_orgnztn_typ ON mst_emplyr_orgnztn_typ.id = emplyr.employer_organization_type_id ");

		List<String> whereConditions = new ArrayList<String>();
		Map<String, Object> paramMap = new HashMap<>();
		if (employerId!= null) {

			whereConditions.add("emplyr.id = :employerId");
			paramMap.put("employerId",employerId);

		}

		if (!whereConditions.isEmpty()) {
			StringBuilder conditions = new StringBuilder();
			for (int i = 0; i < whereConditions.size(); i++) {
				if(i != 0) {
					conditions.append(" AND ");
					conditions.append(whereConditions.get(i));
				}else {
					conditions.append(whereConditions.get(i));
				}
			}
			nativeQuery.append(" WHERE ");
			nativeQuery.append(conditions.toString());
		}
		nativeQuery.append(" LIMIT 1 ");
		Query query = this.entittyManager.createNativeQuery(nativeQuery.toString());

		paramMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});

		try{
			return (String) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}

	}


	 	@Override
	 	@MethodLogging
		public EmployerDirectorCurrentHistoryDateRespDto getDirectorDetailsHistory(ViewEmployerDirectorDetailsRequest request) {
//			History Types
//			0 - first_one
//			1 - last_one
//			2 - previous
//			3 - next

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append("SELECT ");
			nativeQuery.append("emplyr_dirctr_histry.id AS history_id , ");
			nativeQuery.append("emplyr_dirctr_histry.created_at AS updated_at , ");
			nativeQuery.append("emplyr_dirctr_histry.employer_interim_director_id AS employer_interim_director_id  ");
			nativeQuery.append("FROM ");
			nativeQuery.append("employer_director_history emplyr_dirctr_histry ");

			switch (request.getHistoryType()) {
			  case 0:

				  nativeQuery.append("WHERE emplyr_dirctr_histry.employer_director_id =:director_id ");
				  nativeQuery.append("ORDER BY emplyr_dirctr_histry.created_at ASC, emplyr_dirctr_histry.id ASC ");

			    break;
			  case 1:

				  nativeQuery.append("WHERE emplyr_dirctr_histry.employer_director_id =:director_id ");
				  nativeQuery.append("ORDER BY emplyr_dirctr_histry.created_at DESC, emplyr_dirctr_histry.id DESC ");

			    break;
			  case 2:

				  nativeQuery.append("WHERE emplyr_dirctr_histry.employer_director_id =:director_id ");
				  nativeQuery.append("AND emplyr_dirctr_histry.created_at < (SELECT employer_director_history.created_at FROM employer_director_history WHERE id =:director_history_id ) ");
				  nativeQuery.append("ORDER BY emplyr_dirctr_histry.created_at DESC, emplyr_dirctr_histry.id DESC ");

			    break;
			  case 3:

				  nativeQuery.append("WHERE emplyr_dirctr_histry.employer_director_id =:director_id ");
				  nativeQuery.append("AND emplyr_dirctr_histry.created_at > (SELECT employer_director_history.created_at FROM employer_director_history WHERE id =:director_history_id ) ");
				  nativeQuery.append("ORDER BY emplyr_dirctr_histry.created_at ASC, emplyr_dirctr_histry.id ASC ");

			    break;
			}

			nativeQuery.append(" LIMIT 1 ");
			Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerDirectorCurrentHistoryDetailsMapping");
			query.setParameter("director_id", request.getDirectorId());
			if(request.getHistoryType()== 2 || request.getHistoryType()== 3) {
				query.setParameter("director_history_id", request.getEmployerDirectorHistoryId());
			}


			try{
				return (EmployerDirectorCurrentHistoryDateRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}

		}

		@Override
		@MethodLogging
		public List<EmployerContactRespDto> getDirectorContactssDetails(ViewEmployerDirectorDetailsRequest request) {

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append(" SELECT ");
			nativeQuery.append(" prsn_cntct.id AS person_contact_id, ");
			nativeQuery.append(" mst_cntct_typ.name_eng AS contact_type_name,       ");
			nativeQuery.append(" cntct_inf.value AS contact_no ,       ");
			nativeQuery.append(" prsn_cntct.active AS active,       ");
			nativeQuery.append(" cntct_inf.incorrect_contact AS incorrect_contact,       ");
			nativeQuery.append(" cntct_inf.note as note , ");
			nativeQuery.append(" prsn_cntct_rfrnc.contact_sms AS use_for_sms,       ");
			nativeQuery.append(" prsn_cntct_rfrnc.contact_email AS use_for_mail       ");
			nativeQuery.append(" FROM   ");
			nativeQuery.append(" employer_director emplyr_drctr  ");
			nativeQuery.append(" JOIN person prsn ON prsn.id = emplyr_drctr.person_id      ");
			nativeQuery.append(" JOIN person_contact prsn_cntct ON  prsn_cntct.person_id = prsn.id      ");
			nativeQuery.append(" LEFT JOIN person_contact_reference prsn_cntct_rfrnc ON prsn_cntct_rfrnc.person_contact_id = prsn_cntct.id       ");
			nativeQuery.append(" JOIN contact_info cntct_inf  ON cntct_inf.id = prsn_cntct.contact_info_id       ");
			nativeQuery.append(" JOIN mst_contact_type mst_cntct_typ ON mst_cntct_typ.id = cntct_inf.contact_type_id       ");

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();


			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_drctr.id  =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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

			nativeQuery.append(" ORDER BY prsn_cntct.created_at desc  ");

			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerContactResponseDetailsMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			return query.getResultList();
		}


		@Override
		@MethodLogging
		public List<EmployerAddressRespDto> getDirectorAddressDetails(ViewEmployerDirectorDetailsRequest request){

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append(" SELECT ");
			nativeQuery.append(" prsn_addrss.id as person_address_id, ");
			nativeQuery.append(" addrss.id as address_id, ");
			nativeQuery.append(" addrss.address1 as address1,       ");
			nativeQuery.append(" addrss.address2 AS address2,      ");
			nativeQuery.append(" addrss.address3 AS address3,       ");
			nativeQuery.append(" addrss.city AS city,       ");
			nativeQuery.append(" addrss.incorrect_address AS incorrectAddress, ");
			nativeQuery.append(" addrss.incorrect_address_sin AS incorrectAddressSin, ");
			nativeQuery.append(" addrss.incorrect_address_tam AS incorrectAddressTam, ");
			nativeQuery.append(" prsn_addrss.active  AS active,       ");
			nativeQuery.append(" prsn_addrss_rfrnc.mailing_address AS mailing_address,      ");
			nativeQuery.append(" prsn_addrss_rfrnc.brn_address AS brn_address, ");
			nativeQuery.append(" addrss.note as note ");
			nativeQuery.append(" FROM   ");
			nativeQuery.append(" employer_director emplyr_drctr  ");
			nativeQuery.append(" JOIN person prsn ON prsn.id = emplyr_drctr.person_id     ");
			nativeQuery.append(" JOIN person_address prsn_addrss ON prsn_addrss.person_id = prsn.id      ");
			nativeQuery.append(" LEFT JOIN person_address_reference prsn_addrss_rfrnc ON  prsn_addrss_rfrnc.person_address_id = prsn_addrss.id     ");
			nativeQuery.append(" JOIN address addrss ON addrss.id = prsn_addrss.address_id     ");

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();


			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_drctr.id  =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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

			nativeQuery.append(" ORDER BY prsn_addrss.created_at desc  ");

			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerAddressResponseDetailsMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			return query.getResultList();
		}

		@Override
		@MethodLogging
		public EmployerDirectorPersonalDetailsRespDto getDirectorPersonalDetails(ViewEmployerDirectorDetailsRequest request) {

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append("SELECT ");
			nativeQuery.append("emplyr_dirctr.id AS director_id,        ");
			nativeQuery.append("mst_emplyr_orgnztn_typ.director_name AS director_type, ");
			nativeQuery.append("prsn.first_name AS eng_first_name ,        ");
			nativeQuery.append("prsn.last_name AS eng_last_name ,        ");
			nativeQuery.append("prsn.full_name AS eng_full_name ,        ");
			nativeQuery.append("prsn.name_with_initials AS eng_name_with_initial,        ");
			nativeQuery.append("mst_ttle.name_eng AS eng_title ,        ");
			nativeQuery.append("prsn.prefix_ref_no AS person_prefix_ref_no ,        ");
			nativeQuery.append("prsn.ref_no AS person_ref_no,        ");
			nativeQuery.append("prsn.dob AS date_of_birth,        ");
			nativeQuery.append("( case        ");
			nativeQuery.append(" 	 when prsn.gender = 'M' then 'Male'       ");
			nativeQuery.append("     ELSE 'Female'        ");
			nativeQuery.append("  end        ");
			nativeQuery.append(")AS gender ,        ");
			nativeQuery.append("mst_cvl_sts.name AS civil_status,        ");
			nativeQuery.append("prsn.first_name_sin AS sin_first_name ,        ");
			nativeQuery.append("prsn.last_name_sin AS sin_last_name ,        ");
			nativeQuery.append("prsn.full_name_sin AS sin_full_name ,        ");
			nativeQuery.append("prsn.name_with_initials_sin AS sin_name_with_initial,  ");
			nativeQuery.append("mst_ttle.name_sin AS sin_title ,  ");
			nativeQuery.append("prsn.first_name_tam AS tam_first_name ,  ");
			nativeQuery.append("prsn.last_name_tam AS tam_last_name ,  ");
			nativeQuery.append("prsn.full_name_tam AS tam_full_name ,  ");
			nativeQuery.append("prsn.name_with_initials_tam AS tam_name_with_initial,  ");
			nativeQuery.append("mst_ttle.name_tam AS tam_title ,  ");
//			nativeQuery.append("(SELECT CONCAT_WS (' | ',prsn_idntty_nic.nic_no , mst_idntty_nic_typ.name)  ");
//			nativeQuery.append("    	FROM person prsn1  ");
//			nativeQuery.append("    JOIN person_identity_nic prsn_idntty_nic ON  prsn_idntty_nic.person_id = prsn1.id  ");
//			nativeQuery.append("    JOIN mst_identity_nic_type mst_idntty_nic_typ ON mst_idntty_nic_typ.id = prsn_idntty_nic.nic_type_id  ");
//			nativeQuery.append("        WHERE prsn1.id = prsn.id AND prsn_idntty_nic.active = true ");
//			nativeQuery.append("    LIMIT 1 ");
//			nativeQuery.append(") AS nic_details , ");
//			nativeQuery.append("(SELECT CONCAT_WS (' | ',prsn_idnty_psprt.passport_no , mst_cntry.name_eng , prsn_idnty_psprt.date_issued ,prsn_idnty_psprt.date_expiry ) ");
//			nativeQuery.append("        FROM person prsn2   ");
//			nativeQuery.append("  	JOIN person_identity_passport prsn_idnty_psprt ON prsn_idnty_psprt.person_id = prsn2.id ");
//			nativeQuery.append("    JOIN mst_country mst_cntry ON mst_cntry.id = prsn_idnty_psprt.country_id ");
//			nativeQuery.append("        WHERE  prsn2.id = prsn.id AND prsn_idnty_psprt.active = true ");
//			nativeQuery.append("    LIMIT 1 ");
//			nativeQuery.append(") AS passport_details  , ");
			nativeQuery.append(" prsn_idntty_nic.nic_no AS nic_no,   ");
			nativeQuery.append(" mst_idntty_nic_typ.name AS nic_type    ,   ");
			nativeQuery.append(" prsn_idnty_psprt.passport_no AS passport_no ,   ");
			nativeQuery.append(" prsn_idnty_psprt.date_issued AS date_issued,   ");
			nativeQuery.append(" prsn_idnty_psprt.date_expiry AS date_expire,   ");
			nativeQuery.append(" mst_cntry.name_eng AS country_name ,   ");
			nativeQuery.append(" mst_verfctn_sts.name as verification_status_name,   ");
			nativeQuery.append(" mst_verfctn_sts.code AS verification_status_code,   ");
			nativeQuery.append(" emplyr_dirctr.active AS active , ");
			nativeQuery.append(" dcmnt_upld.dms_ref AS profile_pic_ref , ");
			nativeQuery.append("emplyr_dirctr.note AS note,    ");
			nativeQuery.append("emplyr_dirctr.created_at AS created_at,    ");
			nativeQuery.append("usr.display_name AS created_by,    ");
			nativeQuery.append("orgnztn.name AS created_etfb_branch,   ");
			nativeQuery.append("emplyr_dirctr.migrated AS migrated    ");

			nativeQuery.append(" FROM   ");
			nativeQuery.append(" employer_director emplyr_dirctr  ");
			nativeQuery.append(" JOIN employer emplyr ON emplyr.id = emplyr_dirctr.employer_id  ");
			nativeQuery.append(" JOIN mst_employer_organization_type mst_emplyr_orgnztn_typ ON mst_emplyr_orgnztn_typ.id = emplyr.employer_organization_type_id   ");
			nativeQuery.append(" JOIN person prsn ON prsn.id = emplyr_dirctr.person_id  ");

			nativeQuery.append(" LEFT JOIN member_person_verification_request mmbr_prsn_vrfctn_rqst ON mmbr_prsn_vrfctn_rqst.id = emplyr_dirctr.member_person_verification_request_id   ");
			nativeQuery.append(" LEFT JOIN mst_verification_status mst_verfctn_sts ON mst_verfctn_sts.id = mmbr_prsn_vrfctn_rqst.verification_status_id   ");
			nativeQuery.append(" LEFT JOIN person_identity_nic prsn_idntty_nic ON  prsn_idntty_nic.person_id = prsn.id   ");
			nativeQuery.append(" LEFT JOIN mst_identity_nic_type mst_idntty_nic_typ  ON mst_idntty_nic_typ.id = prsn_idntty_nic.nic_type_id    ");
			nativeQuery.append(" LEFT JOIN person_identity_passport prsn_idnty_psprt   ON prsn_idnty_psprt.person_id = prsn.id   ");
			nativeQuery.append(" LEFT JOIN mst_country mst_cntry ON mst_cntry.id = prsn_idnty_psprt.country_id   ");
			nativeQuery.append(" LEFT JOIN  document_uploaded dcmnt_upld ON dcmnt_upld.id = prsn.profile_picture_doc_uploaded_id    ");



			nativeQuery.append("JOIN mst_title mst_ttle ON mst_ttle.id = prsn.title_id  ");
			nativeQuery.append("LEFT JOIN mst_civil_status mst_cvl_sts ON mst_cvl_sts.id = prsn.civil_status_id  ");
			nativeQuery.append("JOIN user usr ON  usr.id = emplyr_dirctr.created_by  ");
			nativeQuery.append("JOIN organization orgnztn ON orgnztn.id = emplyr_dirctr.created_organization_id   ");

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();

			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_dirctr.id  =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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
				nativeQuery.append(" WHERE (prsn_idntty_nic.id IS NULL OR prsn_idntty_nic.active = TRUE) ");//prsn_idntty_nic.id will be null if no NIC
				nativeQuery.append(" AND (prsn_idnty_psprt.id IS NULL OR prsn_idnty_psprt.active = TRUE) AND ");//prsn_idntty_nic.id will be null if no passport
				nativeQuery.append(conditions.toString());
			}

			nativeQuery.append(" ORDER BY emplyr_dirctr.created_at desc LIMIT 1 ");

			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerDirectorPersonalDetMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			try{
				return (EmployerDirectorPersonalDetailsRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}
		}

		@Override
		@MethodLogging
		public EmployerDirectorInformationRespDto getDirectorInformationDetails(ViewEmployerDirectorDetailsRequest request) {
			StringBuilder nativeQuery = new StringBuilder();


			if(request.getHistory()) {

				nativeQuery.append("SELECT ");
				nativeQuery.append("emplyr_dirctr.id AS director_id,        ");
				nativeQuery.append("emplyr_dirctr.date_joined AS date_joined ,        ");
				nativeQuery.append("emplyr_dirctr.date_terrminated AS date_terminated ,        ");
				nativeQuery.append("emplyr_dirctr.active AS active ,        ");
				nativeQuery.append("mst_rsn.name_eng AS inactive_reason ,       ");
				nativeQuery.append("emplyr_dirctr.designation AS designation ,       ");
				nativeQuery.append("emplyr_rqst_drctr_updt.date_joined AS changed_date_joined, ");
				nativeQuery.append("emplyr_rqst_drctr_updt.date_terrminated AS changed_date_terminated, ");
				nativeQuery.append("emplyr_rqst_drctr_updt.active AS changed_active, ");
				nativeQuery.append("emplyr_rqst_drctr_updt.designation AS changed_designation ");
				nativeQuery.append("FROM   ");
				nativeQuery.append("employer_director_history emplyr_dirctr_hstry ");
				nativeQuery.append("JOIN employer_interim_director emplyr_dirctr ON emplyr_dirctr.id = emplyr_dirctr_hstry.employer_interim_director_id   ");
				nativeQuery.append("LEFT JOIN mst_reason mst_rsn  ON mst_rsn.id = emplyr_dirctr.inactive_reason_id   ");
				nativeQuery.append("LEFT JOIN employer_request_director_update emplyr_rqst_drctr_updt ON  emplyr_rqst_drctr_updt.id = emplyr_dirctr_hstry.employer_request_director_update_id   ");
			}
			else {

				nativeQuery.append("SELECT ");
				nativeQuery.append("emplyr_dirctr.id AS director_id,        ");
				nativeQuery.append("emplyr_dirctr.date_joined AS date_joined ,        ");
				nativeQuery.append("emplyr_dirctr.date_terrminated AS date_terminated ,        ");
				nativeQuery.append("emplyr_dirctr.active AS active ,        ");
				nativeQuery.append("mst_rsn.name_eng AS inactive_reason ,       ");
				nativeQuery.append("emplyr_dirctr.designation AS designation,        ");
				nativeQuery.append("0 AS changed_date_joined, ");
				nativeQuery.append("0 AS changed_date_terminated, ");
				nativeQuery.append("0 AS changed_active, ");
				nativeQuery.append("0 AS changed_designation ");
				nativeQuery.append("FROM   ");
				nativeQuery.append(" employer_director emplyr_dirctr  ");
				nativeQuery.append("LEFT JOIN mst_reason mst_rsn ON mst_rsn.id = emplyr_dirctr.inactive_reason_id  ");

			}

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();

			if(request.getHistory()) {
				if (request.getEmployerDirectorHistoryId() != null) {
					listConditions.add(" emplyr_dirctr_hstry.id   =:director_id  ");
					paramMap.put("director_id", request.getEmployerDirectorHistoryId());
				}
			}
			else {
				if (request.getDirectorId() != null) {
					listConditions.add(" emplyr_dirctr.id  =:director_id  ");
					paramMap.put("director_id", request.getDirectorId());
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
				nativeQuery.append(" WHERE  ");
				nativeQuery.append(conditions.toString());

			}

			nativeQuery.append("  LIMIT 1  ");

			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerDirectorInformationDetMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			try{
				return (EmployerDirectorInformationRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}
		}

		@Override
		@MethodLogging
		public EmployerDirectorUpdateEndDateRespDto getDirectorUpdateEndDate(ViewEmployerDirectorDetailsRequest request) {

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append("SELECT ");
			nativeQuery.append("emplyr_dirctr_histry.id AS director_history_id , ");
			nativeQuery.append("emplyr_dirctr_histry.created_at AS end_date ");
			nativeQuery.append("FROM ");
			nativeQuery.append("employer_director_history emplyr_dirctr_histry ");

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();

			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_dirctr_histry.employer_director_id  =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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

	        nativeQuery.append("ORDER BY emplyr_dirctr_histry.created_at DESC, emplyr_dirctr_histry.id DESC ");
	        nativeQuery.append("LIMIT 1 ");
			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "ViewEmployerDirectorUpdateEndDateResponseMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			try{
				return (EmployerDirectorUpdateEndDateRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}
		}

		@Override
		@MethodLogging
		public EmployerDirectorUpdateStartDateRespDto getDirectorUpdateStartDate(ViewEmployerDirectorDetailsRequest request) {

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append("SELECT ");
			nativeQuery.append("emplyr_dirctr_histry.id AS director_history_id , ");
			nativeQuery.append("emplyr_dirctr_histry.created_at AS start_date ");
			nativeQuery.append("FROM ");
			nativeQuery.append("employer_director_history emplyr_dirctr_histry ");

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();

			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_dirctr_histry.employer_director_id  =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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

	        nativeQuery.append("ORDER BY emplyr_dirctr_histry.created_at ASC, emplyr_dirctr_histry.id ASC ");
	        nativeQuery.append("LIMIT 1 ");
			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "ViewEmployerDirectorUpdateStartDateResponseMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			try{
				return (EmployerDirectorUpdateStartDateRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}

		}

		@Override
		@MethodLogging
		public EmployerDirectorUpdateHistoryDetailsRespDto getEmployerDirecotorUpdateHistoryDetails(ViewEmployerDirectorDetailsRequest request) {

			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append("SELECT ");
			nativeQuery.append("emplyr_dirctr_hstry.id AS director_history_id, ");
			nativeQuery.append("dmu_inbnd.ref_no AS dmu_inbound_ref_no , ");
			nativeQuery.append("dmu_inbnd.prefix_ref_no AS dmu_inbound_prefix_ref_no , ");
			nativeQuery.append("srvc_rqst.ref_no AS service_request_ref_no, ");
			nativeQuery.append("srvc_rqst.prefix_ref_no AS service_request_prefix_ref_no, ");
			nativeQuery.append("srvc_cntr.ref_no AS service_counter_ref_no, ");
			nativeQuery.append("srvc_cntr.prefix_ref_no AS service_counter_prefix_ref_no, ");
			nativeQuery.append("usr.display_name AS user_name_updated, ");
			nativeQuery.append("orgnztn.name AS etfb_branch, ");
			nativeQuery.append("emplyr_dirctr_hstry.created_at AS time_updated ");
			nativeQuery.append("FROM ");
			nativeQuery.append("employer_director_history emplyr_dirctr_hstry ");
			nativeQuery.append("JOIN employer_interim_director emplyr_intrm_drctr ON emplyr_intrm_drctr.id = emplyr_dirctr_hstry.employer_interim_director_id ");
			nativeQuery.append("JOIN organization orgnztn ON orgnztn.id = emplyr_dirctr_hstry.created_organization_id ");
			nativeQuery.append("JOIN user usr ON usr.id = emplyr_dirctr_hstry.created_by ");
			nativeQuery.append("LEFT JOIN employer_request_service_counter_dmu emplyr_rqst_srvc_cntr_dmu ON emplyr_rqst_srvc_cntr_dmu.id = emplyr_dirctr_hstry.employer_request_service_counter_dmu_id ");
			nativeQuery.append("LEFT JOIN dmu_inbound dmu_inbnd ON dmu_inbnd.id = emplyr_rqst_srvc_cntr_dmu.dmu_inbound_id ");
			nativeQuery.append("LEFT JOIN service_request srvc_rqst ON srvc_rqst.id = emplyr_rqst_srvc_cntr_dmu.service_request_id ");
			nativeQuery.append("LEFT JOIN service_counter_requirement_type srvc_cntr_rqrmnt_typ ON  srvc_cntr_rqrmnt_typ.id = emplyr_rqst_srvc_cntr_dmu.service_counter_requirement_type_id ");
			nativeQuery.append("LEFT JOIN service_counter srvc_cntr ON  srvc_cntr.id = srvc_cntr_rqrmnt_typ.service_counter_id ");

			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();

			if (request.getEmployerDirectorHistoryId() != null) {
				listConditions.add(" emplyr_dirctr_hstry.id  =:director_history_id  ");
				paramMap.put("director_history_id", request.getEmployerDirectorHistoryId());
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

			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerDirectorUpdateHistoryDetailsMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			try{
				return (EmployerDirectorUpdateHistoryDetailsRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}

		}

		@Override
		@MethodLogging
		public List<EmployerDirectorSignatureRespDto> getEmployerDirectorSignaturesDetails(ViewEmployerDirectorDetailsRequest request) {


			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append(" SELECT ");
			nativeQuery.append(" emplyr_drctr_sgntr.id signature_id, ");
			nativeQuery.append(" emplyr_drctr_sgntr.active AS active, ");
			nativeQuery.append(" emplyr_drctr_sgntr.created_at AS created_at, ");
			nativeQuery.append(" usr.display_name AS created_by , ");
			nativeQuery.append(" orgnztn.name AS created_etfb_branch, ");
			nativeQuery.append(" dcmnt_upld.dms_ref AS signature_ref ");

			nativeQuery.append(" FROM   ");
			nativeQuery.append(" employer_director_signature emplyr_drctr_sgntr  ");
			nativeQuery.append(" JOIN document_uploaded dcmnt_upld ON dcmnt_upld.id = emplyr_drctr_sgntr.signature_doc_uploaded_id ");
			nativeQuery.append(" JOIN organization orgnztn ON orgnztn.id = emplyr_drctr_sgntr.created_organization_id ");
			nativeQuery.append(" JOIN user usr ON usr.id = emplyr_drctr_sgntr.created_by ");
			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();


			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_drctr_sgntr.employer_director_id =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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

			nativeQuery.append(" ORDER BY emplyr_drctr_sgntr.created_at desc  ");

			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerDirectorSignatureDetailsMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			return query.getResultList();

		}


		@Override
		public EmployerDirectorMemberDetailsRespDto checkDirectorIsMember(ViewEmployerDirectorDetailsRequest request) {


			StringBuilder nativeQuery = new StringBuilder();

			nativeQuery.append("SELECT ");
			nativeQuery.append("emplyr_drctr.id AS director_id, ");
			nativeQuery.append("emplyr_mmbr_account.member_no AS member_no , ");
			nativeQuery.append("(case ");
			nativeQuery.append(" when ");
			nativeQuery.append("(SELECT COUNT(emplyr1.id) ");
			nativeQuery.append("	FROM employer emplyr1 ");
			nativeQuery.append("	JOIN employer_director emplyr_drctr1 ON emplyr_drctr1.employer_id = emplyr1.id ");
			nativeQuery.append("	JOIN employer_member_account emplyr_mmbr_account1 ON emplyr_mmbr_account1.employer_id =  emplyr1.id ");
			nativeQuery.append("	JOIN member_account mmbr_accnt1 ON mmbr_accnt1.id = emplyr_mmbr_account1.member_account_id ");
			nativeQuery.append("	JOIN member mmbr1 ON mmbr1.id = mmbr_accnt1.member_id ");
			nativeQuery.append("	WHERE emplyr1.id = emplyr.id AND emplyr_drctr1.id = emplyr_drctr.id ");
			nativeQuery.append(") > 0 ");
			nativeQuery.append("THEN true ");
			nativeQuery.append("ELSE false ");
			nativeQuery.append("END ) AS member_of_same_company ");
			nativeQuery.append("FROM ");
			nativeQuery.append(" employer emplyr ");
			nativeQuery.append("JOIN employer_director emplyr_drctr ON emplyr_drctr.employer_id = emplyr.id ");
			nativeQuery.append("JOIN employer_member_account emplyr_mmbr_account ON emplyr_mmbr_account.employer_id =  emplyr.id ");
			nativeQuery.append("JOIN member_account mmbr_accnt ON mmbr_accnt.id = emplyr_mmbr_account.member_account_id ");
			nativeQuery.append("JOIN member mmbr ON mmbr.id = mmbr_accnt.member_id ");


			List<String> listConditions = new ArrayList<>();
			Map<String, Object> paramMap = new HashMap<>();

			if (request.getDirectorId() != null) {
				listConditions.add(" emplyr_drctr.id   =:director_id  ");
				paramMap.put("director_id", request.getDirectorId());
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
			nativeQuery.append(" LIMIT 1 ");
			Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerDirectorMemberDetailsMapping");

			paramMap.forEach((key, value) -> {
				query.setParameter(key, value);
			});

			try{
				return (EmployerDirectorMemberDetailsRespDto) query.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}



		}







}
