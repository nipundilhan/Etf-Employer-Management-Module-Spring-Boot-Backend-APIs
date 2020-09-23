package com.inova.etfb.employer_management.response.build;

import java.util.List;

import com.inova.etfb.employer_management.response.ResolutionDirectorResponseDto;
import com.inova.etfb.employer_management.wrapper.ResolutionDirectorRespDto;
import com.inova.etfb.employer_management.wrapper.ResolutionNewDirectorAddressRespDto;
import com.inova.etfb.employer_management.wrapper.ResolutionNewDirectorContactRespDto;
import com.inova.util.SingleResponseDtoBuilder;

import lombok.Data;



@Data
public class ResolutionDirectorResponseDtoBuilder implements SingleResponseDtoBuilder<ResolutionDirectorRespDto, ResolutionDirectorResponseDto>{
	
	private List<ResolutionNewDirectorContactRespDto> contactDetailsResponseDtoList;
	private List<ResolutionNewDirectorAddressRespDto> addressDetailsResponseDtoList;

	@Override
	public ResolutionDirectorResponseDto buildCreateResponseDto(ResolutionDirectorRespDto singleResult) {
		
		return ResolutionDirectorResponseDto.builder()
				.civilStatus(singleResult.getCivilStatus())
				.civilStatusCode(singleResult.getCivilStatusCode())
				.civilStatusId(singleResult.getCivilStatusId())
				.country(singleResult.getCountry())
				.countryId(singleResult.getCountryId())
				.empReqDirectorAddId(singleResult.getEmpReqDirectorAddId())
				.employerInterimDirectorId(singleResult.getEmployerInterimDirectorId())
				.dateJoined(singleResult.getDateJoined())
				.dateTerrminated(singleResult.getDateTerrminated())
				.designation(singleResult.getDesignation())
				.status(singleResult.getStatus())
				.dob(singleResult.getDob())
				.firstName(singleResult.getFirstName())
				.firstNameSin(singleResult.getFirstNameSin())
				.firstNameTam(singleResult.getFirstNameTam())
				.fullName(singleResult.getFullName())
				.fullNameSin(singleResult.getFullNameSin())
				.fullNameTam(singleResult.getFullNameTam())
				.gender(singleResult.getGender())
				.lastName(singleResult.getLastName())
				.lastNameSin(singleResult.getLastNameSin())
				.lastNameTam(singleResult.getLastNameTam())
				.nameWithInitials(singleResult.getNameWithInitials())
				.nameWithInitialsSin(singleResult.getNameWithInitialsSin())
				.nameWithInitialsTam(singleResult.getNameWithInitialsTam())
				.personGeneralNicId(singleResult.getPersonGeneralNicId())
				.personIdentityNicId(singleResult.getPersonIdentityNicId())
				.nicNo(singleResult.getNicNo())
				.nicTypeId(singleResult.getNicTypeId())
				.nicTypeName(singleResult.getNicTypeName())
				.nicTypeDescription(singleResult.getNicTypeDescription())
				.nicTypeCode(singleResult.getNicTypeCode())
				.personGeneralPassportId(singleResult.getPersonGeneralPassportId())
				.personIdentityPassportId(singleResult.getPersonIdentityPassportId())
				.passDateExpiry(singleResult.getPassDateExpiry())
				.passDateIssued(singleResult.getPassDateIssued())
				.passportNo(singleResult.getPassportNo())
				.personGeneralId(singleResult.getPersonGeneralId())
				.personId(singleResult.getPersonId())
				.perRefNo(singleResult.getPerRefNo())
				.prePerRefNo(singleResult.getPrePerRefNo())
				.title(singleResult.getTitle())
				.titleSin(singleResult.getTitleSin())
				.titleTam(singleResult.getTitleTam())
				.titleId(singleResult.getTitleId())
				.empOrgTypeDir(singleResult.getEmpOrgTypeDir())
				.signatureUploadedId(singleResult.getSignatureDocUploadedId())
				.signatureDmsRef(singleResult.getSignatureDmsRef())
				.personProfileDmsRef(singleResult.getPersonProfileDmsRef())
				.addressList(addressDetailsResponseDtoList != null ? addressDetailsResponseDtoList :null)
				.contactList(contactDetailsResponseDtoList != null ? contactDetailsResponseDtoList :null)
				.build();
	}

}
