package com.inova.etfb.employer_management.wrapper;

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

@SqlResultSetMapping(name = "UpdateEmployerServiceRequestResolutionBranchDetailsMapping" , entities = {
		@EntityResult(entityClass = UpdateEmployerServiceRequestResolutionBranchDetailsRespDto.class , fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "branchName" , column = "branchName"),
				@FieldResult(name = "branchAddress" , column = "branchAddress"),
				@FieldResult(name = "empOwnBranch", column = "empOwnBranch"),
				@FieldResult(name = "headOffice" , column = "headOffice"),
				@FieldResult(name = "brnAddress" , column = "brnAddress"),
				@FieldResult(name = "mailAddress" , column = "mailAddress"),
				@FieldResult(name = "branchStatus" , column = "branchStatus"),
				@FieldResult(name = "addedBranch" , column = "addedBranch"),
				@FieldResult(name = "updatedBranch" , column = "updatedBranch")
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class UpdateEmployerServiceRequestResolutionBranchDetailsRespDto {
	@Id
	@JsonProperty("employer_interim_branch_or_branch_id")
	private Long id;
	
	@JsonProperty("branch_name")
	private String branchName;
	@JsonProperty("branch_address")
	private String branchAddress;
	@JsonProperty("employer_own_organization")
	private boolean empOwnBranch;
	@JsonProperty("head_office")
	private boolean headOffice;
	@JsonProperty("brn_address")
	private boolean brnAddress;
	@JsonProperty("mailing_address")
	private boolean mailAddress;
	@JsonProperty("branch_status")
	private String branchStatus;
	
	@JsonProperty("added_branch")
	private String addedBranch;
	@JsonProperty("updated_branch")
	private String updatedBranch;
	
}
