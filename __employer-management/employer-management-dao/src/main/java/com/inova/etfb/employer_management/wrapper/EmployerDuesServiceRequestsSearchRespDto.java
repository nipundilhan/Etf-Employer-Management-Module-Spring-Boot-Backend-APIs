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

@SqlResultSetMapping(name = "EmployerDuesSearchServiceReqResponseMapping", entities = {
		@EntityResult(entityClass = EmployerDuesServiceRequestsSearchRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "serviceReqRefNo", column = "serviceReqRefNo"),
				@FieldResult(name = "requestedSource", column = "sourceName"),
				@FieldResult(name = "serviceReqType", column = "typeName"),
				@FieldResult(name = "sbuName", column = "sbuName"),
				@FieldResult(name = "status", column = "statusName"),
				@FieldResult(name = "etfbBranch", column = "etfbBranch"),
				@FieldResult(name = "createdBy", column = "createdBy"),
				@FieldResult(name = "createdAtDate", column = "createdAt"),
				@FieldResult(name = "description", column = "description"),
				@FieldResult(name = "resEtfbBranch", column = "resEtfbBranch")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDuesServiceRequestsSearchRespDto {

	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("service_request_ref_no")
	private Long serviceReqRefNo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("requested_source")
	private String requestedSource;
	@JsonProperty("service_request-type")
	private String serviceReqType;
	@JsonProperty("sbu_name")
	private String sbuName;
	@JsonProperty("created_etfb_branch")
	private String etfbBranch;
	@JsonProperty("responsible_etfb_branch")
	private String resEtfbBranch;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("description")
	private String description;

}
