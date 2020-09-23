package com.inova.etfb.employer_management.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inova.applogger.util.MethodLogging;
import com.inova.etfb.employer_management.dao.EmployerOutBoundDmuDao;
import com.inova.etfb.employer_management.request.EmployerOutBoundDmuSearchRequest;
import com.inova.etfb.employer_management.wrapper.EmployerOutBoundDmuRespDto;
import com.inova.util.DateFormatter;

@Repository
public class EmployerOutBoundDmuDaoImpl implements EmployerOutBoundDmuDao{
	
	
    @PersistenceContext
    EntityManager manager;
	
	@Override
	@MethodLogging
	public List<EmployerOutBoundDmuRespDto> searchOutBoundDmu(EmployerOutBoundDmuSearchRequest request, int offset, int pageSize) {

		StringBuilder nativeQuery = new StringBuilder();

		nativeQuery.append(" SELECT ");
		nativeQuery.append(" ROW_NUMBER() OVER ( ORDER BY dmu_inbnd.id) row_nmbr, ");
		nativeQuery.append(" dmu_inbnd.prefix_ref_no AS dmu_inbound_prefix_ref_no ,  ");
		nativeQuery.append(" dmu_inbnd.ref_no AS dmu_inbound_ref_no ,  ");
		nativeQuery.append(" dmu_inbnd_btch.prefix_ref_no AS dmu_inbound_batch_prefix_ref_no ,  ");
		nativeQuery.append(" dmu_inbnd_btch.ref_no AS dmu_inbound_batch_ref_no ,  ");
		nativeQuery.append(" orgnztn.name AS created_etfb_branch ,  ");
		nativeQuery.append(" dmu_inbnd.created_at AS created_at,  ");
		nativeQuery.append(" dmu_inbnd.sender_name AS sender_name ,  ");
		nativeQuery.append(" mst_dmu_pckng_typ.name AS packing_type ,  ");
		nativeQuery.append(" mst_dmu_dlvry_typ.name AS delivery_type , ");
		nativeQuery.append(" mst_doc_type.name_eng AS document_type ,  ");
		nativeQuery.append(" mst_dmu_ownr_dvsn_typ.name AS division ,  ");
		nativeQuery.append(" mst_dmu_inbnd_sts.name AS status ,  ");
		nativeQuery.append(" '/' AS action  ");
		nativeQuery.append(" FROM   ");
		nativeQuery.append(" dmu_inbound dmu_inbnd   ");
		nativeQuery.append(" JOIN dmu_inbound_sender_employer dmu_inbnd_sender_emplyr ON dmu_inbnd_sender_emplyr.dmu_inbound_id = dmu_inbnd.id  ");
		nativeQuery.append(" LEFT JOIN organization orgnztn ON orgnztn.id = dmu_inbnd.created_organization_id ");
		nativeQuery.append(" JOIN dmu_inbound_batch dmu_inbnd_btch ON dmu_inbnd_btch.id = dmu_inbnd.dmu_inbound_batch_id  ");
		nativeQuery.append(" LEFT JOIN mst_dmu_packing_type mst_dmu_pckng_typ ON mst_dmu_pckng_typ.id = dmu_inbnd.packing_type_id  ");
		nativeQuery.append(" LEFT JOIN mst_dmu_delivery_type mst_dmu_dlvry_typ ON mst_dmu_dlvry_typ.id = dmu_inbnd_btch.delivery_type_id  ");
		nativeQuery.append(" LEFT JOIN mst_document_type mst_doc_type ON mst_doc_type.id = dmu_inbnd.document_type_id  ");		
		nativeQuery.append(" LEFT JOIN mst_dmu_owner_division_type mst_dmu_ownr_dvsn_typ ON mst_dmu_ownr_dvsn_typ.id = dmu_inbnd.owner_division_type_id  ");
		nativeQuery.append(" LEFT JOIN mst_dmu_inbound_status mst_dmu_inbnd_sts ON mst_dmu_inbnd_sts.id = dmu_inbnd.status_id  ");	
		
		List<String> listConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();

		if (request.getEmployerId() != null) {
			listConditions.add(" dmu_inbnd_sender_emplyr.employer_id =:emp_id  ");
			paramMap.put("emp_id", request.getEmployerId());
		}
		if (request.getDeliveryTypeId() != null) {
			listConditions.add(" dmu_inbnd_btch.delivery_type_id =:delivery_type_id  ");
			paramMap.put("delivery_type_id", request.getDeliveryTypeId());
		}
		if (request.getDocumentTypeId() != null) {
			listConditions.add(" dmu_inbnd.document_type_id =:doc_type_id  ");
			paramMap.put("doc_type_id", request.getDocumentTypeId());
		}
		if (request.getDmuInboundRefNo() != null) {
			listConditions.add(" dmu_inbnd.ref_no =:dmu_inbound_ref_no  ");
			paramMap.put("dmu_inbound_ref_no", request.getDmuInboundRefNo());
		}
    	if (request.getCreatedAtFrom() != null ) {
    		listConditions.add(" Date_Format(dmu_inbnd.created_at,'%Y-%m-%d') >=:start " );
    		paramMap.put("start", DateFormatter.convertDateToStringWithTimeZone(request.getCreatedAtFrom()));
    	}     	
    	if (request.getCreatedAtTo()!= null) {
    		listConditions.add(" Date_Format(dmu_inbnd.created_at,'%Y-%m-%d') <=:end " );
    		paramMap.put("end",DateFormatter.convertDateToStringWithTimeZone(request.getCreatedAtTo()));
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

		nativeQuery.append(" ORDER BY dmu_inbnd.created_at desc  ");

		Query query = this.manager.createNativeQuery(nativeQuery.toString(), "EmployerOutBoundDmuMapping")
				.setFirstResult(offset).setMaxResults(pageSize);

		paramMap.forEach(query::setParameter);

		return query.getResultList();

	}
	


}
