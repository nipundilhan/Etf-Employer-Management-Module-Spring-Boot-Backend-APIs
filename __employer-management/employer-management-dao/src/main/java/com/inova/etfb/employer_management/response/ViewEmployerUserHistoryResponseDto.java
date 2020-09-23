package com.inova.etfb.employer_management.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewEmployerUserHistoryResponseDto {

	@JsonProperty("updated_at")
	private Date updatedTime;
	@JsonProperty("updated_by")
	private String updatedBy;
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	@JsonProperty("dmu_inbound_refno")
	private Long dmuInboundRefno;
	@JsonProperty("service_counter_refno")
	private Long serviceCounterRefno;
	@JsonProperty("service_request_refno")
	private Long serviceRequestRefno;

}