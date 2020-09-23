package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.enums.Gender;
import com.inova.etfb.employer_management.param.EmployerProfileSelectedUserDetailsParamDto;
import com.inova.etfb.employer_management.response.EmployerProfileSelectedUserDetailsResponseDto;
import com.inova.util.SingleResponseDtoBuilder;

@Component
public class EmployerProfileSelectedUserDetailsResponseDtoBuilder implements SingleResponseDtoBuilder<
					EmployerProfileSelectedUserDetailsParamDto, EmployerProfileSelectedUserDetailsResponseDto>{

	@Override
	public EmployerProfileSelectedUserDetailsResponseDto buildCreateResponseDto(
			EmployerProfileSelectedUserDetailsParamDto param) {
		return EmployerProfileSelectedUserDetailsResponseDto.builder()
				.employerUserId(param.getUserDetail().getEmployerUserId())
				.active(param.getUserDetail().getActive())
				.employerId(param.getUserDetail().getEmployerId())
				.personGeneralId(param.getUserDetail().getPersonGeneralId())
				.titleId(param.getUserDetail().getTitleId())
				.titleEng(param.getUserDetail().getTitleEng())
				.titleSin(param.getUserDetail().getTitleSin())
				.titleTam(param.getUserDetail().getTitleTam())
				.firstNameEng(param.getUserDetail().getFirstNameEng())
				.firstNameSin(param.getUserDetail().getFirstNameSin())
				.firstNameTam(param.getUserDetail().getFirstNameTam())
				.lastNameEng(param.getUserDetail().getLastNameEng())
				.lastNameSin(param.getUserDetail().getLastNameSin())
				.lastNameTam(param.getUserDetail().getLastNameTam())
				.fullNameEng(param.getUserDetail().getFullNameEng())
				.fullNameSin(param.getUserDetail().getFullNameSin())
				.fullNameTam(param.getUserDetail().getFullNameTam())
				.nameWithInitialsEng(param.getUserDetail().getNameWithInitialsEng())
				.nameWithInitialsSin(param.getUserDetail().getNameWithInitialsSin())
				.nameWithInitialsTam(param.getUserDetail().getNameWithInitialsTam())
				.gender(param.getUserDetail().getGender())
				.genderName(Gender.getValueByCode(param.getUserDetail().getGender().toString()).getLabel())
				.dateOfBirth(param.getUserDetail().getDateOfBirth())
				.designation(param.getUserDetail().getDesignation())
				.address1Eng(param.getUserDetail().getAddress1Eng())
				.address2Eng(param.getUserDetail().getAddress2Eng())
				.address3Eng(param.getUserDetail().getAddress3Eng())
				.address4Eng(param.getUserDetail().getAddress4Eng())
				.address1Sin(param.getUserDetail().getAddress1Sin())
				.address2Sin(param.getUserDetail().getAddress2Sin())
				.address3Sin(param.getUserDetail().getAddress3Sin())
				.address4Sin(param.getUserDetail().getAddress4Sin())
				.address1Tam(param.getUserDetail().getAddress1Tam())
				.address2Tam(param.getUserDetail().getAddress2Tam())
				.address3Tam(param.getUserDetail().getAddress3Tam())
				.address4Tam(param.getUserDetail().getAddress4Tam())
				.cityEng(param.getUserDetail().getCityEng())
				.citySin(param.getUserDetail().getCitySin())
				.cityTam(param.getUserDetail().getCityTam())
				.addressId(param.getUserDetail().getAddressId())
				.personGeneralAddressId(param.getUserDetail().getPersonGeneralAddressId())
				.personGeneralPassportId(param.getUserDetail().getPersonGeneralPassportId())
				.personGeneralNicId(param.getUserDetail().getPersonGeneralNicId())
				.districtId(param.getUserDetail().getDistrictId())
				.distrtictEng(param.getUserDetail().getDistrtictEng())
				.distrtictSin(param.getUserDetail().getDistrtictSin())
				.distrtictTam(param.getUserDetail().getDistrtictTam())
				.postalCode(param.getUserDetail().getPostalCode())
				.addressNote(param.getUserDetail().getAddressNote())
				.adminUser(param.getUserDetail().getAdminUser())
				.verificationMobileNo(param.getUserDetail().getVerificationMobileNo())
				.verificationEmail(param.getUserDetail().getVerificationEmail())
				.migrated(param.getUserDetail().getMigrated())
				.note(param.getUserDetail().getNote())
				.createdAt(param.getUserDetail().getCreatedAt())
				.createdBy(param.getUserDetail().getCreatedBy())
				.createdEtfbBranch(param.getUserDetail().getCreatedEtfbBranch())
				.nicNumber(param.getUserDetail().getNicNumber())
				.nicTypeId(param.getUserDetail().getNicTypeId())
				.nicTypeName(param.getUserDetail().getNicTypeName())
				.nicTypeCode(param.getUserDetail().getNicTypeCode())
				.nicTypeDescription(param.getUserDetail().getNicTypeDescription())
				.passportNumber(param.getUserDetail().getPassportNumber())
				.countryId(param.getUserDetail().getCountryId())
				.country(param.getUserDetail().getCountry())
				.dateIssued(param.getUserDetail().getDateIssued())
				.dateExpiry(param.getUserDetail().getDateExpiry())
				.civilStatusId(param.getUserDetail().getCivilStatusId())
				.civilStatusName(param.getUserDetail().getCivilStatusName())
				.civilStatusCode(param.getUserDetail().getCivilStatusCode())
				.inactiveReasonId(param.getUserDetail().getInactiveReasonId())
				.inactiveReasonDescription(param.getUserDetail().getInactiveReasonDescription())
				.inactiveReasonNameEng(param.getUserDetail().getInactiveReasonNameEng())
				.memberGroups(param.getMemberGroups())
				.contactDetails(param.getContactDetails())
				.documentDetails(param.getDocumentDetails())
				.historyDateList(param.getHistoryDateList())
				.build();
		}

}
