package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerInterimGeneralContact;
import com.inova.etfb.employer_management.response.ServiceRequestEmployerInterimGeneralContactResponseDto;
import com.inova.util.CreateResponseDtoBuilder;
import com.inova.util.UpdateResponseDtoBuilder;


@Component
public class ServiceRequestEmployerInterimGeneralContactResponseDtoBuilder implements 
	CreateResponseDtoBuilder<EmployerInterimGeneralContact, ServiceRequestEmployerInterimGeneralContactResponseDto>, 
	UpdateResponseDtoBuilder<EmployerInterimGeneralContact, ServiceRequestEmployerInterimGeneralContactResponseDto> {

//ModelMapper modelMapper;

//@PostConstruct
//public void init() {
	//modelMapper = new ModelMapper();
//}

@Override
public ServiceRequestEmployerInterimGeneralContactResponseDto buildCreateResponseDto(EmployerInterimGeneralContact entity) {
	return ServiceRequestEmployerInterimGeneralContactResponseDto
	.builder()
	.id(entity.getId())
	.contactInfoId((entity.getContactInfoId() != null) ? entity.getContactInfoId().getId() : null)
	.employerInterimId((entity.getEmployerInterimId() != null) ? entity.getEmployerInterimId().getId() : null)
	.active(entity.getActive())
	.contactSms(entity.getContactSms())
	.contactEmail(entity.getContactEmail())
	.build();
	//return modelMapper.map(entity, EmployerInterimGeneralContactResponseDto.class);
}

@Override
public ServiceRequestEmployerInterimGeneralContactResponseDto buildUpdateResponseDto(EmployerInterimGeneralContact entity) {
	return buildCreateResponseDto(entity);
}

//Developer code goes below this line without removing this comment...
}
