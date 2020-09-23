package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

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

@SqlResultSetMapping(name = "EmploymentMergeHistoryRespDtoMapping", entities = {
		@EntityResult(entityClass = EmploymentMergeHistoryRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"), 
				@FieldResult(name = "employerRefNo", column = "employer_ref_no"),
				@FieldResult(name = "employerName", column = "employer_name"),
				@FieldResult(name = "mergedAt", column = "merged_at"),
				@FieldResult(name = "mergedBy", column = "merged_by"), 
				@FieldResult(name = "memberNo", column = "parent_member_no"),
				@FieldResult(name = "personRef", column = "person_ref_no"), 
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "nicTypeCode", column = "nic_type_code"),
				@FieldResult(name = "nicDescription", column = "nic_type_description"),
				@FieldResult(name = "nicName", column = "nic_type_name"),
				@FieldResult(name = "passportNo", column = "passport_no"),	 			
				@FieldResult(name = "fullName", column = "full_name"), 			
				@FieldResult(name = "designation", column = "designation"),  
				@FieldResult(name = "noOfChild", column = "no_of_child_members"), 
				}), 
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmploymentMergeHistoryRespDto {

	@Id
	@JsonProperty("id")
	private Long id;	
	
	@JsonProperty("employer_ref_no")
	private Long employerRefNo;	
	
	@JsonProperty("employer_name")
	private String employerName;	
	
	@JsonProperty("merged_at")
	private Date mergedAt;	
	
	@JsonProperty("merged_by")
	private String mergedBy;
	
	@JsonProperty("parent_member_no")
	private Integer memberNo;
	
	@JsonProperty("person_ref_no")
	private Long personRef;
	
	@JsonProperty("nic_no")
	private String nicNo;	
	
	@JsonProperty("nic_type_name")
	private String nicName;

	@JsonProperty("nic_type_code")
	private String nicTypeCode;

	@JsonProperty("nic_type_description")
	private String nicDescription;

	@JsonProperty("passport_no")
	private String passportNo;	
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("designation")
	private String designation;	
	
	@JsonProperty("no_of_child_members")
	private Integer noOfChild;
	
	
}
