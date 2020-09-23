package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerMemNmneeHstrySearchRequest {
	
	
	@NotNull(message = "member account id cannot be null")
	@ApiModelProperty(required = true, value = "required field")
	@JsonProperty("member_account_id")
	private Long memberAccountId;
	
	
	@ApiModelProperty(required = true, value = "updated date required field")
	@JsonProperty("updated_date")
	private Date updatedDate;

}
