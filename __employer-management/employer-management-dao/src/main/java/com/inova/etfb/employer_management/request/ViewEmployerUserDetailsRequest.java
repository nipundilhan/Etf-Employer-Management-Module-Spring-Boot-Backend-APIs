package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.response.ViewEmployerUserHistoryAvailableResponseDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewEmployerUserDetailsRequest {
	
	@NotNull(message = "employer_id cannot be null")
	@Min(value = 0, message = "employer id should not be less than 0")
	@ApiModelProperty(required = true, value = "required field")
	@JsonProperty("employer_user_id")
	private Long  empUserId;
	
	@JsonProperty("history")
	private Boolean history;
	
	@JsonProperty("current_history_date")
	private Date currentHistoryDate;
	
	@JsonProperty("history_type")
	private Integer historyType;

//	History Types
//	0 - first_one
//	1 - last_one
//	2 - previous
//	3 - next


}
