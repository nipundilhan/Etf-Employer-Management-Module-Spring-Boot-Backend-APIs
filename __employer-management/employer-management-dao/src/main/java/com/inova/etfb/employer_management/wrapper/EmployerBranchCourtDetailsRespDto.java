package com.inova.etfb.employer_management.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerBranchCourtDetailsUpdateMapping", entities = {
		@EntityResult(entityClass = EmployerBranchCourtDetailsRespDto.class, fields = {
				@FieldResult(name = "employerBranchCourtId", column = "employerBranchCourtId"),
				@FieldResult(name = "employerBranchId", column = "employerBranchId"),
				@FieldResult(name = "courtTypeCode", column = "courtTypeCode"),
				@FieldResult(name = "courtType", column = "courtType"),
				@FieldResult(name = "courtEng", column = "courtEng"),
				@FieldResult(name = "courtSin", column = "courtSin"),
				@FieldResult(name = "courtTam", column = "courtTam"),
				@FieldResult(name = "description", column = "description")

		}), })

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerBranchCourtDetailsRespDto {

	@Id
	@JsonProperty("employer_branch_court_id")
	private Long employerBranchCourtId;
	@JsonProperty("employer_branch_id")
	private Long employerBranchId;
	@JsonProperty("court_type_code")
	private String courtTypeCode;
	@JsonProperty("court_type")
	private String courtType;
	@JsonProperty("court_eng")
	private String courtEng;
	@JsonProperty("court_sin")
	private String courtSin;
	@JsonProperty("court_tam")
	private String courtTam;
	private String description;

}
