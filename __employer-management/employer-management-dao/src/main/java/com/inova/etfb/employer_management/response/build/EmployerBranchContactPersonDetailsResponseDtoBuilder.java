package com.inova.etfb.employer_management.response.build;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inova.common.dao.wrapper.DocumentRespDto;
import com.inova.enums.Gender;
import com.inova.etfb.employer_management.response.EmployerBranchContactPersonDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerBranchContactPersonContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerBranchContactPersonDetailsRespDto;
import com.inova.response.dto.DocumentUploadedResponseDtoChild4;
import com.inova.util.SearchResponseDtoBuilder;

import lombok.Data;

@Component
@Data
public class EmployerBranchContactPersonDetailsResponseDtoBuilder implements SearchResponseDtoBuilder<EmployerBranchContactPersonDetailsRespDto, EmployerBranchContactPersonDetailsResponseDto> {

	private List<EmployerBranchContactPersonContactDetailsRespDto> contactList;
	private List<DocumentRespDto> documentDetails;
	private DocumentUploadedResponseDtoChild4 signatureDoc;
	
	@Override
	public EmployerBranchContactPersonDetailsResponseDto buildResponseDto(
			EmployerBranchContactPersonDetailsRespDto searchResult) {

		return EmployerBranchContactPersonDetailsResponseDto.builder()
									.id(searchResult.getId())
									.branchId(searchResult.getBranchId())
									.personGeneralId(searchResult.getPersonGeneralId())
									.designation(searchResult.getDesignation())
									.active(searchResult.getActive())
									.inactiveReasonId(searchResult.getInactiveReasonId())
									.signature(searchResult.getSignature())
									.titleId(searchResult.getTitleId())
									.firstName(searchResult.getFirstName())
									.lastName(searchResult.getLastName())
									.fullName(searchResult.getFullName())
									.nameWithInitials(searchResult.getNameWithInitials())
									.gender(searchResult.getGender())
									.genderName(Gender.getValueByCode(searchResult.getGender()).getLabel())
									.dob(searchResult.getDob())
									.civilStatusCode(searchResult.getCivilStatusCode())
									.personGeneralNicId(searchResult.getPersonGeneralNicId())
									.nicNo(searchResult.getNicNo())
									.nicTypeCode(searchResult.getNicTypeCode())
									.personGeneralPassportId(searchResult.getPersonGeneralPassportId())
									.passportNo(searchResult.getPassportNo())
									.ppDateIssued(searchResult.getPpDateIssued())
									.ppDateExpiry(searchResult.getPpDateExpiry())
									.countryId(searchResult.getCountryId())
									.personGeneralAddressId(searchResult.getPersonGeneralAddressId())
									.address1(searchResult.getAddress1())
									.address2(searchResult.getAddress2())
									.address3(searchResult.getAddress3())
									.city(searchResult.getCity())
									.postalCode(searchResult.getPostalCode())
									.districtId(searchResult.getDistrictId())
									.districtName(searchResult.getDistrictName())
									.addressNote(searchResult.getAddressNote())
									.contactList(contactList)
									.documentDetails(documentDetails)
									.signatureDocDetails(signatureDoc)
									.build();
		
	}

}
