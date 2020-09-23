package com.inova.etfb.employer_management.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.util.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResolutionEmployerDetailChangeSearchRequest extends Request{

	@JsonProperty("employer_id")
	@NotNull
	private Long employerId;
	@JsonProperty("service_req_id")
	@NotNull
	private Long serviceReqId;
	@JsonProperty("employer_interim_id")
	@NotNull
	private Long employerInterimId;
//	@NotNull
//	private Long generalContactId;
}
