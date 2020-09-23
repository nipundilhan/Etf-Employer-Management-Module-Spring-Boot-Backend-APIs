package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.enums.EmployerVerificationAssignedStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class PendingEmployerVerificationSearchRequestChild1 extends PendingEmployerVerificationSearchRequest {

	@JsonProperty("request_reference_number")
	private String requestRefNumber;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("created_date_from")
	private Date createdDateFrom;
	@JsonProperty("created_date_to")
	private Date createdDateTo;
	@JsonProperty("priority_id")
	private Long priorityId;
	@JsonProperty("assigned_status")
	@NotNull(message = "Should be 'ASG', 'UN_ASG' or 'ALL'")
	private EmployerVerificationAssignedStatus assignedStatus;
}
