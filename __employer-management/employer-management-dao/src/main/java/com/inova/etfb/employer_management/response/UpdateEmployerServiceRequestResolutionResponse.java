package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.ApprovalResolutionDetailsResponseDto;
import com.inova.common.dao.wrapper.DocumentRespDto;
import com.inova.common.dao.wrapper.EmployerResolutionServiceRequestHoldHistoryRespDto;
import com.inova.common.dao.wrapper.ServiceCounterResDto;
import com.inova.common.dao.wrapper.ServiceRequestRequirementTypeResDto;
import com.inova.common.dao.wrapper.ServiceRequestStatusHistoryDetailsResponseDto;
import com.inova.common.response.dto.EmployerResolutionDmuResponseDto;
import com.inova.common.response.dto.EmployerResolutionRejectHistoryResponseDto;
import com.inova.common.response.dto.EmployerResolutionResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorAddUpdateRespDto;
import com.inova.etfb.employer_management.wrapper.ServiceRequestApprovedDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.ServiceRequestResolutionStatusHistoryRespDto;
import com.inova.etfb.employer_management.wrapper.UpdateEmployerServiceRequestEmpDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployerServiceRequestResolutionResponse {

	@JsonProperty(value = "employer_resolution_response")
	private EmployerResolutionResponseDto serviceRequestDetails;

	@JsonProperty(value = "service_counter_info_response")
	private ServiceCounterResDto serviceCounterInfoResponse;
	
	@JsonProperty(value = "service_counter_requirement_types")
	private List<ServiceRequestRequirementTypeResDto> serviceRequestRequirementTypeResDtoList;

	@JsonProperty(value = "employer_resolution_reject_history_resp_list")
	private List<EmployerResolutionRejectHistoryResponseDto> serviceRequestRejectInfoList;

	@JsonProperty(value = "employer_resolution_dmu_response")
	private EmployerResolutionDmuResponseDto employerResolutionDmuResponse;

	@JsonProperty(value = "add_document_details")
	private List<DocumentRespDto> addDocumentDetailsList;

	@JsonProperty(value = "employer_details")
	private UpdateEmployerServiceRequestEmpDetailsRespDto employerDetails;

	@JsonProperty(value = "service_request_hold_history_details")
	private List<EmployerResolutionServiceRequestHoldHistoryRespDto> serviceRequestHoldHistory;

	@JsonProperty(value = "resolution_details")
	private ApprovalResolutionDetailsResponseDto approvalResolutionDetails;

	@JsonProperty(value = "service_request_status_history_details")
	private List<ServiceRequestStatusHistoryDetailsResponseDto> serviceRequestStatusHistory;

	@JsonProperty(value = "approved_details")
	private ServiceRequestApprovedDetailsRespDto approvedDetails;

	@JsonProperty(value = "resolution_status_history_details")
	private List<ServiceRequestResolutionStatusHistoryRespDto> resolutionStatusHistoryDetails;

	@JsonProperty(value = "resolution_director_add_update_details")
	private EmployerUpdateResolutionDirectorAddUpdateRespDto directorResolutionAddUpdateDetails;
}
