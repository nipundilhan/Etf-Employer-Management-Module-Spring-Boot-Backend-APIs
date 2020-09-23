package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;

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

@SqlResultSetMapping(name = "EmploymentUpdateNomineeDetailsMapping", entities = {
		@EntityResult(entityClass = EmploymentUpdateNomineeDetailsRespDto.class, fields = {
 				@FieldResult(name = "rowNumber", column = "rowNumber"), 
				@FieldResult(name = "employerMemAccId", column = "employerMemAccId") ,
 				@FieldResult(name = "nomineeId", column = "nomineeId"), 
				@FieldResult(name = "personId", column = "personId") ,
 				@FieldResult(name = "personRefNo", column = "personRefNo"), 
				@FieldResult(name = "prefixRefNo", column = "prefixRefNo") ,
 				@FieldResult(name = "nicNo", column = "nicNo"), 
				@FieldResult(name = "nicType", column = "nicType"),
 				@FieldResult(name = "passportNo", column = "passportNo"), 
				@FieldResult(name = "title", column = "title"),
				@FieldResult(name = "firstName", column = "firstName"),
 				@FieldResult(name = "lastName", column = "lastName"), 
				@FieldResult(name = "relationship", column = "relationship"),
 				@FieldResult(name = "relationshipDesc", column = "relationshipDesc"),
 				@FieldResult(name = "spouse", column = "spouse"), 
				@FieldResult(name = "share", column = "share")
		}), })
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentUpdateNomineeDetailsRespDto {

	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("employer_mem_acc_id")
	private Long employerMemAccId;
	@JsonProperty("nominee_id")
	private Long nomineeId;
	@JsonProperty("person_id")
	private Long personId;
	@JsonProperty("person_ref_no")
	private Long personRefNo;
	@JsonProperty("prefix_ref_no")
	private String prefixRefNo;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("nic_type")
	private String nicType;
	@JsonProperty("passport_no")
	private String passportNo;
	private String title; 
	@JsonProperty("first_name")
	private String firstName; 
	@JsonProperty("last_name")
	private String lastName;
	private String relationship;
	@JsonProperty("relationship_desc")
	private String relationshipDesc; 
	private String spouse;
	private BigDecimal share;
}
