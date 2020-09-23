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


@SqlResultSetMapping(name = "EmployerDuesSearchResponseMapping" , entities = {
		@EntityResult(entityClass = EmployerDuesLegalCasesSearchRespDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "legalCaseRefNo", column = "prefixRefNo"),
				@FieldResult(name = "status" , column = "statusName"),
				@FieldResult(name = "court" , column = "courtName"),
				@FieldResult(name = "legalCaseCat" , column = "categoryName"),
				@FieldResult(name = "createdBy" , column = "createdBy"),
				@FieldResult(name = "description" , column = "description"),
				@FieldResult(name = "courtCaseNo" , column = "crtCseNo"),
				@FieldResult(name = "lodNo" , column = "lodNo"),
				@FieldResult(name = "createdAtDate" , column = "createdAt"),
				@FieldResult(name = "etfbBranch" , column = "etfbBranch")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class EmployerDuesLegalCasesSearchRespDto {
	
	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("legal_case_refno")
	private String legalCaseRefNo;
	@JsonProperty("status")
	private String status;
	@JsonProperty("court")
	private String court;
	@JsonProperty("legal_case_cat")
	private String legalCaseCat;
	@JsonProperty("created_at_date")
	private Date createdAtDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("court_case_no")
	private String courtCaseNo;
	@JsonProperty("description")
	private String description;
	@JsonProperty("lod_no")
	private String lodNo;
	@JsonProperty("branch")
	private String etfbBranch;


}
