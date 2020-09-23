package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.EmplyrUserBasicDetResDto;
import com.inova.etfb.employer_management.wrapper.EmplyrUserBasicDetResDto.EmplyrUserBasicDetResDtoBuilder;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerMemHistrySearchRequest {
	
	
	@NotNull(message = "employer member account id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	@JsonProperty("employer_member_account_id")
	private Long employerMemberAccountId;
	
	@JsonProperty("current_view_date")
	private Date currentDate;
	
	@JsonProperty("history_table_id")
	private Integer HistoryTableId;

	@NotNull(message = "history type cannot be null")
	@JsonProperty("history_type")
	private Integer historyType;
	
//	History Types
//	0 - first_one
//	1 - last_one
//	2 - previous
//	3 - next

}
