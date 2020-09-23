package com.inova.etfb.employer_management.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inova.etfb.employer_management.dao.EmployerPayOrderDao;
import com.inova.etfb.employer_management.request.EmployerPayOrderRequest;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderDataResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderTotalDataResponseDto;

import org.apache.commons.lang.*;

@Repository
public class EmployerPayOrderDaoImpl implements EmployerPayOrderDao{

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployerPayOrderDataResponseDto> searchEmployerPayOrders(EmployerPayOrderRequest parameter) {
		
		StringBuilder nativeQuery = new StringBuilder();

		nativeQuery.append("SELECT ");
		nativeQuery.append("ROW_NUMBER() OVER (ORDER BY employer_payorder_instalment.id) AS rowNumber, ");
		nativeQuery.append("CONCAT_WS('', employer_payorder.prefix_ref_no,employer_payorder.ref_no) AS payOrderRefNo, ");
		nativeQuery.append("employer_payorder.total_amount AS totalAmount, ");
		nativeQuery.append("employer_payorder_instalment.balance_amount AS totalBalanceAmount, ");
		nativeQuery.append("employer_payorder_instalment.total_instalment_count AS noOfInstalement, ");
		nativeQuery.append("employer_payorder_instalment.instalment_number AS instalmentNo, ");
		nativeQuery.append("employer_payorder_instalment.instalment_due_date AS instalmentDueDate, ");
		nativeQuery.append("employer_payorder_instalment.instalment_amount AS instalmentAmount, "); 	
		nativeQuery.append("mst_employer_payorder_status.name AS payOrderStatus, ");
		nativeQuery.append("mst_employer_payorder_status.code AS payOrderStatusCode, ");
		nativeQuery.append("'\' AS  action ");
		nativeQuery.append("FROM employer_payorder_instalment ");
		nativeQuery.append("JOIN employer_payorder ON employer_payorder.id = employer_payorder_instalment.employer_payorder_id ");
		nativeQuery.append("LEFT JOIN mst_employer_payorder_status ON mst_employer_payorder_status.id = employer_payorder.status_id ");
		
		List<String> whereConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();
		if (parameter.getEmployerId() != null) {
			whereConditions.add("employer_payorder.employer_id = :getEmployerId");
			paramMap.put("getEmployerId", parameter.getEmployerId());
		}
		
		if(!StringUtils.isEmpty(parameter.getPayOrderRefNo())) {
		whereConditions.add("employer_payorder.ref_no = :getPayOrderRefNo");
		paramMap.put("getPayOrderRefNo", parameter.getPayOrderRefNo());
		}

		if(!StringUtils.isEmpty(parameter.getContributionFrom())) {
			whereConditions.add("Date_Format(employer_payorder.related_period_from,'%Y-%m') >= :getContributionFrom");
			paramMap.put("getContributionFrom", parameter.getContributionFrom());
		}

		if(!StringUtils.isEmpty(parameter.getContributionTo())) {
			whereConditions.add("Date_Format(employer_payorder.related_period_to,'%Y-%m') <= :getContributionTo");
			paramMap.put("getContributionTo", parameter.getContributionTo());
		}
		
		if (!StringUtils.isEmpty(parameter.getPayOrderStatus())) {
			whereConditions.add("mst_employer_payorder_status.code = :getPayOrderStatus");
			paramMap.put("getPayOrderStatus", parameter.getPayOrderStatus());
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
		nativeQuery.append(" ORDER BY employer_payorder.created_at DESC, employer_payorder_instalment.created_at ");

		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerPayOrderSearchResult");

		paramMap.forEach(query::setParameter);
		return query.getResultList();
	}

	@Override
	public EmployerPayOrderTotalDataResponseDto getTotalPayorderAmounts(EmployerPayOrderRequest parameter) {
		StringBuilder nativeQuery = new StringBuilder();

		nativeQuery.append("SELECT ");
		nativeQuery.append("SUM(employer_payorder.total_amount) AS totalPayOrderInstallmentAmount, ");
		nativeQuery.append("(SUM(employer_payorder.total_amount)- SUM(employer_payorder_instalment.balance_amount)) AS totalPayOrderPaidAmount, ");
		nativeQuery.append("SUM(employer_payorder_instalment.balance_amount) AS totalPayOrderBalanceAmount ");
		nativeQuery.append("FROM employer_payorder_instalment ");
		nativeQuery.append("JOIN employer_payorder ON employer_payorder.id = employer_payorder_instalment.employer_payorder_id ");
		nativeQuery.append("LEFT JOIN mst_employer_payorder_status ON mst_employer_payorder_status.id = employer_payorder.status_id ");
		
		List<String> whereConditions = new ArrayList<>();
		Map<String, Object> paramMap = new HashMap<>();
		if (parameter.getEmployerId() != null) {
			whereConditions.add("employer_payorder.employer_id = :getEmployerId");
			paramMap.put("getEmployerId", parameter.getEmployerId());
		}
		
		if(!StringUtils.isEmpty(parameter.getPayOrderRefNo())) {
		whereConditions.add("employer_payorder.ref_no = :getPayOrderRefNo");
		paramMap.put("getPayOrderRefNo", parameter.getPayOrderRefNo());
		}

		if(!StringUtils.isEmpty(parameter.getContributionFrom())) {
			whereConditions.add("Date_Format(employer_payorder.related_period_from,'%Y-%m') >= :getContributionFrom");
			paramMap.put("getContributionFrom", parameter.getContributionFrom());
		}

		if(!StringUtils.isEmpty(parameter.getContributionTo())) {
			whereConditions.add("Date_Format(employer_payorder.related_period_to,'%Y-%m') <= :getContributionTo");
			paramMap.put("getContributionTo", parameter.getContributionTo());
		}
		
		if (!StringUtils.isEmpty(parameter.getPayOrderStatus())) {
			whereConditions.add("mst_employer_payorder_status.code = :getPayOrderStatus");
			paramMap.put("getPayOrderStatus", parameter.getPayOrderStatus());
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
		nativeQuery.append(" ORDER BY employer_payorder.created_at DESC, employer_payorder_instalment.created_at ");
		Query query = this.manager.createNativeQuery(nativeQuery.toString() , "EmployerPayOrderTotalDataResponseDtoMapping");

		paramMap.forEach(query::setParameter);
		
		return (EmployerPayOrderTotalDataResponseDto)query.getSingleResult();
	}







}
