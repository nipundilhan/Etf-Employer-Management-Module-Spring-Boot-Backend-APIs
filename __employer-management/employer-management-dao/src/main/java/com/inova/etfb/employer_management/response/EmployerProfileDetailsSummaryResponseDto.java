package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.AddressResponseDtoChild1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileDetailsSummaryResponseDto {

	@JsonProperty("employer_id")
	private Long employerId;
	@JsonProperty("employer_interim_id")
	private Long employerInterimId;
	@JsonProperty("employer_ref_no")
	private Long empRefNo;
	@JsonProperty("epf_no")
	private String epfNo;
	@JsonProperty("business_registration_no")
	private String businessRegistrationNo;

	@JsonProperty("employer_name")
	private String employerName;
	@JsonProperty("employer_type_code")
	private String employerTypeCode;
	@JsonProperty("employer_type_name")
	private String employerTypeName;

	@JsonProperty("industry_type_eng")
	private String industryTypeEng;

	@JsonProperty("nature_of_business_eng")
	private String natureOfBusinessEng;

	@JsonProperty("organization_type")
	private String organizationType;

	@JsonProperty("employer_status")
	private String employerStatus;
	@JsonProperty("employer_status_code")
	private String employerStatusCode;
	@JsonProperty("employer_note")
	private String employerNote;


	@JsonProperty("head_office")
	private AddressResponseDtoChild1 headofficeAddressData;
	@JsonProperty("general_contacts")
	private List<EmployerProfileGeneralContactResponseDto> generalContacts;
	@JsonProperty("logo")
	private String logoBase64;
//	@JsonProperty("messages")
//	private List<MessageDeliveredResponseDtoChild2> messages;

//	@JsonIgnore
//	private List<EmployerProfileHistoryDateResponseDto> historyDatesList;
//	@JsonIgnore
//	private List<EmployerProfileStatusHistoryResponseDto> statusHistoryList;



}
