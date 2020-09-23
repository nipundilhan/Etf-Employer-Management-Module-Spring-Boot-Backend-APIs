package com.inova.etfb.employer_management.request;

import java.util.List;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.request.EmployerMemberAccountRequestChild3;
import com.inova.request.EmployerMemberDocumentRequest;
import com.inova.request.PersonGeneralRequestChild9;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateEmploymentRequest {
	
	@JsonProperty("emp_mem_acc_id")
	@NotNull
	private Long employerMemberAccountId;
	
	@JsonProperty("service_counter_req_type_id")
	private Long scReqTypeId;
	
	@JsonProperty("dmu_inbound_id")
	private Long dmuInboundId;
	
	@JsonProperty("person_found")
	@NotNull
	private Boolean isPersonFound;
	
	@JsonProperty("person_id")
	private Long personId;
	
	@JsonProperty("change_person")
	@NotNull
	private Boolean isChangePerson;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("person_general_details")
	private PersonGeneralRequestChild9 personGeneral;
	
	@JsonProperty("employer_member_account_details")
	private EmployerMemberAccountRequestChild3 emAccountDetails;
	
	@JsonProperty("employer_member_account_documents")
	private List<EmployerMemberDocumentRequest> lstEmpMemDocument;
	
}
