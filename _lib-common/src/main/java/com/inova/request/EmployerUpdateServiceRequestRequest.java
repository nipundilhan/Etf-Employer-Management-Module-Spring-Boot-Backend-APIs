package com.inova.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerUpdateServiceRequestRequest  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	

	

	@JsonProperty("employer_ref_no")
	private  Long employerRefNo;
	

	@JsonProperty("employer_interim_request")
	private  EmployerUpdateServiceRequestEmployerInterimRequest employerUpdateServiceRequestEmployerInterimRequest;

	@JsonProperty("employer_request_update")
	private  EmployerUpdateServiceRequestUpdateRequest employerUpdateServiceRequestUpdateRequest;
	
	
	@JsonProperty("contact_details_list")
	private List<EmployerUpdateServiceRequestContactInfoRequest> contactDetailsList;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("request_description")
	private String requestDescription;
	
	@JsonProperty("service_request_document_list")
	private List<Long> serviceRequestDocumentList;
	
	@JsonProperty("user_mobile_otp_details")
	private OtpGeneratedRequestChild2 userMobileOtpDetails;
	

	

	
	
	
}
