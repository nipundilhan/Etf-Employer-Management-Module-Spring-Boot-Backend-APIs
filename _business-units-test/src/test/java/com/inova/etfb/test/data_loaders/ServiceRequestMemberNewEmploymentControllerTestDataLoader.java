package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.ServiceRequest;
import com.inova.dao.repositories.ServiceRequestRepository;

@Component
public class ServiceRequestMemberNewEmploymentControllerTestDataLoader {
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	public ServiceRequest instertServiceRequest() {
		ServiceRequest serviceRequest = getExistingServiceRequest();
		
		if(serviceRequest != null) {
			return serviceRequest;
		}else {
			serviceRequest = new ServiceRequest();
			serviceRequest.setPriorityId(mstDataLoader.getExistingMstPriority());
			serviceRequest.setSourceId(mstDataLoader.getExistingMstServiceRequestSource());
			serviceRequest.setRefNo(1234);
			serviceRequest.setTypeId(mstDataLoader.getExistingMstServiceRequestType());
			serviceRequest.setStatusId(mstDataLoader.getExistingMstServiceRequestStatus());
			serviceRequest.setStatusAt(new Date());
			serviceRequest.setCreatedAt(new Date());
			serviceRequest.setUpdatedAt(new Date());
			serviceRequest.setServiceRequestSbuId(mstDataLoader.getExistingMstSbu());
			serviceRequest.setHold(true);
			serviceRequest.setApprovalRequired(false);
			serviceRequest.setApproved(true);
			
			return serviceRequestRepository.save(serviceRequest);
		}
	}
	
	private ServiceRequest getExistingServiceRequest() {
		List<ServiceRequest> serviceRequest = serviceRequestRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!serviceRequest.isEmpty()) {
			return serviceRequest.get(0);
		} else {
			return null;
		}
	}
}
