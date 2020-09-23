package com.inova.etfb.employer_management.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.request.AddressRequestChild3;
import com.inova.request.EmployerBranchContactRequestChild2;
import com.inova.request.EmployerBranchCourtRequest;
import com.inova.request.EmployerBranchRequestChild2;
import com.inova.request.EmployerDocumentRequest;
import com.inova.request.EmployerRequestServiceCounterDmuRequestChild3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerBranchDetailAddUpdateRequest {

	@NotNull
	@JsonProperty("added_branch")
	private boolean addedBranch;
	
	@NotNull
	@Valid
	@JsonProperty("employer_branch_request")
	private EmployerBranchRequestChild2 employerBranchRequest;
	
	@Valid
	@JsonProperty("address_request")
	private AddressRequestChild3 addressRequest;
	
	@Valid
	@JsonProperty("employer_branch_contacts")
	private List<EmployerBranchContactRequestChild2> employerBranchContacts;
	
	@Valid
	@JsonProperty("employer_branch_courts")
	private List<EmployerBranchCourtRequest> employerBranchCourts;
	
	@Valid
	@JsonProperty("employer_request_service_counter_dmu_request")
	private EmployerRequestServiceCounterDmuRequestChild3 employerRequestServiceCounterDmuRequest;
	
	@Valid
	@JsonProperty("employer_documents")
	private List<EmployerDocumentRequest> employerDocuments;
}
