package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.EmployerProfileEmployerInboundDocumentsDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileEmployerInboundDocumentsDetailsResDto;
import com.inova.util.SearchResponseDtoBuilder;

@Component
public class EmployerProfileEmployerInboundDocumentsDetailsResponseDtoBuilder implements SearchResponseDtoBuilder<
		EmployerProfileEmployerInboundDocumentsDetailsResDto, EmployerProfileEmployerInboundDocumentsDetailsResponseDto> {

	@Override
	public EmployerProfileEmployerInboundDocumentsDetailsResponseDto buildResponseDto(
			EmployerProfileEmployerInboundDocumentsDetailsResDto searchResult) {
		return EmployerProfileEmployerInboundDocumentsDetailsResponseDto.builder()
				.dmuOutboundId(searchResult.getDmuOutboundId())
				.createdAt(searchResult.getCreatedAt())
				.dmuOuntboundPrefixRefNo(searchResult.getDmuOuntboundPrefixRefNo())
				.dmuOuntboundRefNo(searchResult.getDmuOuntboundRefNo())
				.documentType(searchResult.getDocumentType())
				.documentTypeDescription(searchResult.getDocumentTypeDescription())
				.documentName(searchResult.getDocumentName())
				.divisionName(searchResult.getDivisionName())
				.divisionCode(searchResult.getDivisionCode())
				.divisionDescription(searchResult.getDivisionDescription())
				.deliveryType(searchResult.getDeliveryType())
				.deliveryTypeCode(searchResult.getDeliveryTypeCode())
				.deliveryTypeDescription(searchResult.getDeliveryTypeDescription())
				.address1(searchResult.getAddress1())
				.address2(searchResult.getAddress2())
				.address3(searchResult.getAddress3())
				.address4(searchResult.getAddress4())
				.withinColombo(searchResult.getWithinColombo())
				.printRequiredAtDmu(searchResult.getPrintRequiredAtDmu())
				.printAtDmu(searchResult.getPrintAtDmu())
				.status(searchResult.getStatus())
				.statusCode(searchResult.getStatusCode())
				.statusDescription(searchResult.getStatusDescription())
				.build();
	}

}
