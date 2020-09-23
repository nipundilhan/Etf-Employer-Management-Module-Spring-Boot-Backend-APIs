package com.inova.etfb.employer_management.request.dto.build;

import org.springframework.stereotype.Component;

import com.inova.request.AddressRequestChild1;
import com.inova.request.AddressRequestChild3;
import com.inova.util.CreateRequestDtoBuilder;

@Component
public class AddressRequestChild1Builder implements 
CreateRequestDtoBuilder<AddressRequestChild3, AddressRequestChild1>{

	@Override
	public AddressRequestChild1 buildCreateDto(AddressRequestChild3 request, Long id) {
		return AddressRequestChild1.builder()
				.countryId(request.getCountryId())
				.districtId(request.getDistrictId())
				.divisionalSecretariatId(request.getDivisionalSecretariatId())
				.gramaNiladhariDivisionId(request.getGramaNiladhariDivisionId())

				.address1(request.getAddress1())
				.address2(request.getAddress2())
				.address3(request.getAddress3())
//				.address4(request.getAddress4())
				.city(request.getCity())
				.postalCode(request.getPostalCode())
//				.poBox(request.getPoBox())
//				.zipCode(request.getZipCode())
//				.state(request.getState())
//				.latitude(request.getLatitude())
//				.longitude(request.getLongitude())
				.incorrectAddress(request.isIncorrectAddress())
//				.publicNote(request.getPublicNote())
				.note(request.getNote())
				.address1Sin(request.getAddress1Sin())
				.address2Sin(request.getAddress2Sin())
				.address3Sin(request.getAddress3Sin())
//				.address4Sin(request.getAddress4Sin())
				.citySin(request.getCitySin())
				.incorrectAddressSin(request.isIncorrectAddressSin())
				.address1Tam(request.getAddress1Tam())
				.address2Tam(request.getAddress2Tam())
				.address3Tam(request.getAddress3Tam())
//				.address4Tam(request.getAddress4Tam())
				.cityTam(request.getCityTam())
				.incorrectAddressTam(request.isIncorrectAddressTam())
//				.migrated(request.isMigrated())
				.build();
	}

}
