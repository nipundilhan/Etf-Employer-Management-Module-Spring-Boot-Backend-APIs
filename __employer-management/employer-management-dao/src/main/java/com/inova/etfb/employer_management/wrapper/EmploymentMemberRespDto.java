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

@SqlResultSetMapping(name = "EmploymentMemberRespDtoMapping", entities = {
		@EntityResult(entityClass = EmploymentMemberRespDto.class, fields = {
				@FieldResult(name = "id", column = "id"), 
				@FieldResult(name = "employerRefNo", column = "employer_ref_no"),
				@FieldResult(name = "memberNo", column = "member_no"),
				@FieldResult(name = "mergeAsChild", column = "merged_as_child"),
				@FieldResult(name = "mergeAsParent", column = "merged_as_parent"), 
				@FieldResult(name = "memberAccountStatusId", column = "member_account_status_id"),
				@FieldResult(name = "memberAccountStatusCode", column = "member_account_status_code"), 
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "nicTypeCode", column = "nic_type_code"),
				@FieldResult(name = "nicDescription", column = "nic_type_description"),
				@FieldResult(name = "nicName", column = "nic_type_name"),
				@FieldResult(name = "passportNo", column = "passport_no"),			
				@FieldResult(name = "personRefNo", column = "person_ref_no"), 			
				@FieldResult(name = "fullName", column = "full_name"), 			
				@FieldResult(name = "designation", column = "designation"), 			
				@FieldResult(name = "dateJoined", column = "date_joined"), 			
				@FieldResult(name = "dateTerminated", column = "date_terminated"), 
				@FieldResult(name = "statusId", column = "status_id"), 
				@FieldResult(name = "statusCode", column = "status_code"), 
				}), 
		})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmploymentMemberRespDto {

	@Id
	@JsonProperty("id")
	private Long id;	
	
	@JsonProperty("employer_ref_no")
	private Long employerRefNo;	
	
	@JsonProperty("member_no")
	private Integer memberNo;	
	
	@JsonProperty("merged_as_child")
	private boolean mergeAsChild;	
	
	@JsonProperty("merged_as_parent")
	private boolean mergeAsParent;	
	
	@JsonProperty("member_account_status_id")
	private Long memberAccountStatusId;	
	
	@JsonProperty("member_account_status_code")
	private String memberAccountStatusCode;	
	
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
	
	@JsonProperty("person_ref_no")
	private Long personRefNo;	
	
	@JsonProperty("designation")
	private String designation;	
	
	@JsonProperty("full_name")
	private String fullName;	
	
	@JsonProperty("date_joined")
	private Date dateJoined;	
	
	@JsonProperty("date_terminated")
	private Date dateTerminated;	
	
	@JsonProperty("status_id")
	private Long statusId;	
	
	@JsonProperty("status_code")
	private String statusCode;	
	
}
