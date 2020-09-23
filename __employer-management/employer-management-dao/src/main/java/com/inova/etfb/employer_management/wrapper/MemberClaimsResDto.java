package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
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

@SqlResultSetMapping(name = "MemberClaimsMapping", entities = {
		@EntityResult(entityClass = MemberClaimsResDto.class, fields = {
 				@FieldResult(name = "rowNo", column = "row_no"), 
				@FieldResult(name = "claimId", column = "claim_id"),
				@FieldResult(name = "memberNo", column = "member_no"),
				@FieldResult(name = "claimRefNo", column = "claim_ref_no"),
				@FieldResult(name = "claimType", column = "claim_type"),
				@FieldResult(name = "statusName", column = "status_name"),
				@FieldResult(name = "personRefNo", column = "person_ref_no"),
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "nicType", column = "nic_type"),
				@FieldResult(name = "passportNo", column = "passport_no"),
				@FieldResult(name = "nameWithInitials", column = "name_with_initials"),	
				@FieldResult(name = "firstName", column = "first_name"),	
				@FieldResult(name = "lastName", column = "last_name"),
				@FieldResult(name = "fullName", column = "full_name"),
				@FieldResult(name = "createdAt", column = "created_at"),	
				@FieldResult(name = "createdBy", column = "created_by"),					
				@FieldResult(name = "createdEtfbBranch", column = "created_etfb_branch") }), })




@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MemberClaimsResDto {
	@Id
	@JsonProperty("row_no")
	private Long rowNo;
	
	@JsonProperty("claim_id")
	private Long claimId;
	
	@JsonProperty("member_no")
	private Long memberNo;
	
	@JsonProperty("claim_ref_no")
	private Long claimRefNo;
	
	@JsonProperty("claim_type")
	private String claimType;
	
	@JsonProperty("status_name")
	private String statusName;
	

		
	@JsonProperty("person_ref_no")
	private Long personRefNo;
	
	@JsonProperty("nic_no")
	private String nicNo;
	
	@JsonProperty("nic_type")
	private String nicType;
	
	@JsonProperty("passport_no")
	private String passportNo;
	
	@JsonProperty("name_with_initials")
	private String nameWithInitials;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	
	
	
	
	
	
	
}
