package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmploymentUpdateAddressDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentUpdateContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentUpdateNomineeDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmploymentUpdatePersonalAndMemDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentUpdateResponseDto {
	
	@JsonProperty("personal_and_member_employment_details")
	private EmploymentUpdatePersonalAndMemDetailsRespDto employmentUpdatePersonalAndMemDetails;
	@JsonProperty("member_employment_addresses")
	private List<EmploymentUpdateAddressDetailsRespDto> employmentUpdateAddressDetailsList;
	@JsonProperty("member_employment_contacts")
	private List<EmploymentUpdateContactDetailsRespDto> employmentUpdateContactDetailsList;
	@JsonProperty("member_employment_nominees")
	private List<EmploymentUpdateNomineeDetailsRespDto> employmentUpdateNomineeDetailsList;

}
