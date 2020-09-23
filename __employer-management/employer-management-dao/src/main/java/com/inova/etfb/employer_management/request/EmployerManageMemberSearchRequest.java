/**
 * @author shirhan@inovaitsys.com
 * 
 */
package com.inova.etfb.employer_management.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class EmployerManageMemberSearchRequest {

	@JsonProperty("employer_id")
	@NotNull(message="Employer id cannot be null")
	@ApiModelProperty(required=true,value="Required field")
	private Long  empId;
	@JsonProperty("member_no")
	private Integer  memberNo;
	@JsonProperty("person_ref_no")
	private Long  personRefNo;
	@JsonProperty("nic_type")
	private Integer  nicType;
	@JsonProperty("nic_no")
	private String  nicNo;
	@JsonProperty("passport_no")
	private String  passportNo;
	@JsonProperty("name")
	private String  name;
	@JsonProperty("status")
	private Integer status;
	@JsonProperty("emp_mem_acc_status")
	private Integer  empMemAccountStatus;
	@JsonProperty("terminated")
	private Integer terminated;
	@JsonProperty("member_group")
	private Integer memberGroup;
	@JsonProperty("claimed")
	private Integer claimed;
	@JsonProperty("show_merged_child")
	private Boolean showMergedChild;

}
