package com.inova.etfb.employer_management.dao;

import java.util.List;

import com.inova.etfb.employer_management.request.EmployerPayOrderRequest;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderDataResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderTotalDataResponseDto;


public interface EmployerPayOrderDao {
	List<EmployerPayOrderDataResponseDto> searchEmployerPayOrders(EmployerPayOrderRequest req);
	EmployerPayOrderTotalDataResponseDto getTotalPayorderAmounts(EmployerPayOrderRequest req);
}