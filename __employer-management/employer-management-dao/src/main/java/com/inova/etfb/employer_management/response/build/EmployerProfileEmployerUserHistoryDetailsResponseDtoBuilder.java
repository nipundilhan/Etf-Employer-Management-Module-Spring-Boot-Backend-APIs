package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.enums.Gender;
import com.inova.etfb.employer_management.param.EmployerProfileEmployerUserHistoryDetailsParamDto;
import com.inova.etfb.employer_management.response.EmployerProfileEmployerUserHistoryDetailsResponseDto;
import com.inova.util.SingleResponseDtoBuilder;

@Component
public class EmployerProfileEmployerUserHistoryDetailsResponseDtoBuilder implements SingleResponseDtoBuilder<
		EmployerProfileEmployerUserHistoryDetailsParamDto, EmployerProfileEmployerUserHistoryDetailsResponseDto> {

	@Override
	public EmployerProfileEmployerUserHistoryDetailsResponseDto buildCreateResponseDto(
			EmployerProfileEmployerUserHistoryDetailsParamDto param) {
		
		return EmployerProfileEmployerUserHistoryDetailsResponseDto.builder()
				.employerInterimUserId(param.getUserHistoryDetails().getEmployerUserId())
				.active(param.getUserHistoryDetails().getActive())
				.employerInterimId(param.getUserHistoryDetails().getEmployerId())
				.personGeneralId(param.getUserHistoryDetails().getPersonGeneralId())
				.titleId(param.getUserHistoryDetails().getTitleId())
				.titleEng(param.getUserHistoryDetails().getTitleEng())
				.titleSin(param.getUserHistoryDetails().getTitleSin())
				.titleTam(param.getUserHistoryDetails().getTitleTam())
				.firstNameEng(param.getUserHistoryDetails().getFirstNameEng())
				.firstNameSin(param.getUserHistoryDetails().getFirstNameSin())
				.firstNameTam(param.getUserHistoryDetails().getFirstNameTam())
				.lastNameEng(param.getUserHistoryDetails().getLastNameEng())
				.lastNameSin(param.getUserHistoryDetails().getLastNameSin())
				.lastNameTam(param.getUserHistoryDetails().getLastNameTam())
				.fullNameEng(param.getUserHistoryDetails().getFullNameEng())
				.fullNameSin(param.getUserHistoryDetails().getFullNameSin())
				.fullNameTam(param.getUserHistoryDetails().getFullNameTam())
				.nameWithInitialsEng(param.getUserHistoryDetails().getNameWithInitialsEng())
				.nameWithInitialsSin(param.getUserHistoryDetails().getNameWithInitialsSin())
				.nameWithInitialsTam(param.getUserHistoryDetails().getNameWithInitialsTam())
				.gender(param.getUserHistoryDetails().getGender())
				.genderName(Gender.getValueByCode(param.getUserHistoryDetails().getGender().toString()).getLabel())
				.dateOfBirth(param.getUserHistoryDetails().getDateOfBirth())
				.designation(param.getUserHistoryDetails().getDesignation())
				.address1Eng(param.getUserHistoryDetails().getAddress1Eng())
				.address2Eng(param.getUserHistoryDetails().getAddress2Eng())
				.address3Eng(param.getUserHistoryDetails().getAddress3Eng())
				.address4Eng(param.getUserHistoryDetails().getAddress4Eng())
				.address1Sin(param.getUserHistoryDetails().getAddress1Sin())
				.address2Sin(param.getUserHistoryDetails().getAddress2Sin())
				.address3Sin(param.getUserHistoryDetails().getAddress3Sin())
				.address4Sin(param.getUserHistoryDetails().getAddress4Sin())
				.address1Tam(param.getUserHistoryDetails().getAddress1Tam())
				.address2Tam(param.getUserHistoryDetails().getAddress2Tam())
				.address3Tam(param.getUserHistoryDetails().getAddress3Tam())
				.address4Tam(param.getUserHistoryDetails().getAddress4Tam())
				.cityEng(param.getUserHistoryDetails().getCityEng())
				.citySin(param.getUserHistoryDetails().getCitySin())
				.cityTam(param.getUserHistoryDetails().getCityTam())
				.addressId(param.getUserHistoryDetails().getAddressId())
				.personGeneralAddressId(param.getUserHistoryDetails().getPersonGeneralAddressId())
				.personGeneralPassportId(param.getUserHistoryDetails().getPersonGeneralPassportId())
				.personGeneralNicId(param.getUserHistoryDetails().getPersonGeneralNicId())
				.districtId(param.getUserHistoryDetails().getDistrictId())
				.distrtictEng(param.getUserHistoryDetails().getDistrtictEng())
				.distrtictSin(param.getUserHistoryDetails().getDistrtictSin())
				.distrtictTam(param.getUserHistoryDetails().getDistrtictTam())
				.postalCode(param.getUserHistoryDetails().getPostalCode())
				.addressNote(param.getUserHistoryDetails().getAddressNote())
				.adminUser(param.getUserHistoryDetails().getAdminUser())
				.verificationMobileNo(param.getUserHistoryDetails().getVerificationMobileNo())
				.verificationEmail(param.getUserHistoryDetails().getVerificationEmail())
				.migrated(param.getUserHistoryDetails().getMigrated())
				.note(param.getUserHistoryDetails().getNote())
				.createdAt(param.getUserHistoryDetails().getCreatedAt())
				.createdBy(param.getUserHistoryDetails().getCreatedBy())
				.createdEtfbBranch(param.getUserHistoryDetails().getCreatedEtfbBranch())
				.nicNumber(param.getUserHistoryDetails().getNicNumber())
				.nicTypeId(param.getUserHistoryDetails().getNicTypeId())
				.nicTypeName(param.getUserHistoryDetails().getNicTypeName())
				.nicTypeCode(param.getUserHistoryDetails().getNicTypeCode())
				.nicTypeDescription(param.getUserHistoryDetails().getNicTypeDescription())
				.passportNumber(param.getUserHistoryDetails().getPassportNumber())
				.countryId(param.getUserHistoryDetails().getCountryId())
				.country(param.getUserHistoryDetails().getCountry())
				.dateIssued(param.getUserHistoryDetails().getDateIssued())
				.dateExpiry(param.getUserHistoryDetails().getDateExpiry())
				.civilStatusId(param.getUserHistoryDetails().getCivilStatusId())
				.civilStatusName(param.getUserHistoryDetails().getCivilStatusName())
				.civilStatusCode(param.getUserHistoryDetails().getCivilStatusCode())
				.inactiveReasonId(param.getUserHistoryDetails().getInactiveReasonId())
				.inactiveReasonDescription(param.getUserHistoryDetails().getInactiveReasonDescription())
				.inactiveReasonNameEng(param.getUserHistoryDetails().getInactiveReasonNameEng())
				.memberGroups(param.getMemberGroups())
				.contactDetails(param.getContactDetails())
				.build();
	}

}
