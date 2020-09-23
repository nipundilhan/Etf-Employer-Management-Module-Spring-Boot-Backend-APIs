package com.inova.etfb.employer_management.response.build;

import com.inova.etfb.employer_management.response.EmployerDirectorAddressResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorAddressDetailsResDto;
import com.inova.util.SingleResponseDtoBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployerDirectorAddressResponseDTOBuilder implements SingleResponseDtoBuilder<EmployerDirectorAddressDetailsResDto, EmployerDirectorAddressResponseDto> {

    @Override
    public EmployerDirectorAddressResponseDto buildCreateResponseDto(EmployerDirectorAddressDetailsResDto res) {
        return EmployerDirectorAddressResponseDto.builder()
                .active(res.getActive())
                .address1(res.getAddress1())
                .address2(res.getAddress2())
                .address3(res.getAddress3())
                .address4(res.getAddress4())
                .address1Sin(res.getAddress1Sin())
                .address2Sin(res.getAddress2Sin())
                .address3Sin(res.getAddress3Sin())
                .address4Sin(res.getAddress4Sin())
                .address1Tam(res.getAddress1Tam())
                .address2Tam(res.getAddress2Tam())
                .address3Tam(res.getAddress3Tam())
                .address4Tam(res.getAddress4Tam())
                .city(res.getCity())
				.citySin(res.getCitySin())
				.cityTam(res.getCityTam())
				.personAddressId(res.getPersonAddressId())
				.personAddressReferenceId(res.getPersonAddressReferenceId())
				.addressId(res.getAddressId())
				.postalCode(res.getPostalCode())
				.districtId(res.getDistrictId())
				.district(res.getDistrict())
				.districtSin(res.getDistrictSin())
				.districtTam(res.getDistrictTam())
				.poBox(res.getPoBox())
				.divisionalSecretariatId(res.getDivisionalSecretariatId())
				.divisional_secretariat(res.getDivisional_secretariat())
				.divisionalSecretariatSin(res.getDivisionalSecretariatSin())
				.divisionalSecretariatTam(res.getDivisionalSecretariatTam())
				.gramaNiladhariDivision(res.getGramaNiladhariDivision())
				.gramaNiladhariDivisionId(res.getGramaNiladhariDivisionId())
				.zipCode(res.getZipCode())
				.state(res.getState())
				.note(res.getNote())
				.publicNote(res.getPublicNote())
				.incorrectAddress(res.getIncorrectAddress())
				.incorrectAddressSin(res.getIncorrectAddressSin())
				.incorrectAddressTam(res.getIncorrectAddressTam())
				.countryId(res.getCountryId())
				.country(res.getCountry())
				.countrySin(res.getCountrySin())
				.countryTam(res.getCountryTam())
				.brnAddress(res.getBrnAddress())
				.mailingAddress(res.getMailingAddress())
				.createdAt(res.getCreatedAt())
				.build();
    }


}
