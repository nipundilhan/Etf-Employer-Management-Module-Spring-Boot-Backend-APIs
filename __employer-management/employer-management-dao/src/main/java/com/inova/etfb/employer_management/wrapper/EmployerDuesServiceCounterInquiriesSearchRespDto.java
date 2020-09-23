package com.inova.etfb.employer_management.wrapper;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerDuesSearchServiceInquiriesResponseMapping", entities = {
		@EntityResult(entityClass = EmployerDuesServiceCounterInquiriesSearchRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "serviceCounterRefNo", column = "prefixRefNo"),
				@FieldResult(name = "createdAtDate", column = "created_at"),
				@FieldResult(name = "etfbBranch", column = "created_branch"),
				@FieldResult(name = "createdBy", column = "created_by"),
				@FieldResult(name = "status", column = "status"),
				@FieldResult(name = "fullName", column = "full_name"),
				@FieldResult(name = "nicNo", column = " nic_details"),
				@FieldResult(name = "serviceReqmntType", column = "service_requirement_types") }), })


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDuesServiceCounterInquiriesSearchRespDto {

	@Id
	@JsonProperty("id")
	private Long id;
	@JsonProperty("service_counter_refno")
	private String serviceCounterRefNo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("service_requirement_type")
	private String serviceReqmntType;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("branch")
	private String etfbBranch;


}
