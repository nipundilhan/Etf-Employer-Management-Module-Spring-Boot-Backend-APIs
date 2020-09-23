package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.ServiceRequestEmployerUpdate;
import com.inova.etfb.employer_management.response.ServiceRequestEmployerUpdateResolutionResponseDto;
import com.inova.util.CreateResponseDtoBuilder;
import com.inova.util.UpdateResponseDtoBuilder;

@Component
public class ServiceRequestEmployerUpdateResolutionResponseDtoBuilder implements 
	CreateResponseDtoBuilder<ServiceRequestEmployerUpdate, ServiceRequestEmployerUpdateResolutionResponseDto>, 
	UpdateResponseDtoBuilder<ServiceRequestEmployerUpdate, ServiceRequestEmployerUpdateResolutionResponseDto> {

	//ModelMapper modelMapper;

	//@PostConstruct
	//public void init() {
    	//modelMapper = new ModelMapper();
	//}

	@Override
	public ServiceRequestEmployerUpdateResolutionResponseDto buildCreateResponseDto(ServiceRequestEmployerUpdate entity) {
		return ServiceRequestEmployerUpdateResolutionResponseDto
		.builder()
		.id(entity.getId())
		.employerId((entity.getEmployerId() != null) ? entity.getEmployerId().getId() : null)
		.serviceRequestId((entity.getServiceRequestId() != null) ? entity.getServiceRequestId().getId() : null)
		.completedBy((entity.getCompletedBy() != null) ? entity.getCompletedBy().getId() : null)
		.collectionEmployerServiceRequestId((entity.getCollectionEmployerServiceRequestId() != null) ? entity.getCollectionEmployerServiceRequestId().getId() : null)
		.requestedEmployerInterimId((entity.getRequestedEmployerInterimId() != null) ? entity.getRequestedEmployerInterimId().getId() : null)
		.employerVerificationRequestId((entity.getEmployerVerificationRequestId() != null) ? entity.getEmployerVerificationRequestId().getId() : null)
		.resolutionId((entity.getResolutionId() != null) ? entity.getResolutionId().getId() : null)
		.completed(entity.getCompleted())
		.completedAt(entity.getCompletedAt())
		.employerDetailUpdate(entity.getEmployerDetailUpdate())
		.employerBranchUpdate(entity.getEmployerBranchUpdate())
		.employerDirectorUpdate(entity.getEmployerDirectorUpdate())
		.resolutionRejectReasonId((entity.getResolutionRejectReasonId() != null) ? entity.getResolutionRejectReasonId().getId() : null)
		.build();
		//return modelMapper.map(entity, ServiceRequestEmployerUpdateResponseDto.class);
	}

	@Override
	public ServiceRequestEmployerUpdateResolutionResponseDto buildUpdateResponseDto(ServiceRequestEmployerUpdate entity) {
		return buildCreateResponseDto(entity);
	}

//	Developer code goes below this line without removing this comment...
}
