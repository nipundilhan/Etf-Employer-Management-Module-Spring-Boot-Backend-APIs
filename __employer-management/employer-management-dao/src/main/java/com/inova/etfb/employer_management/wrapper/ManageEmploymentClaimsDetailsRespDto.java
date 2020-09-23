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

@SqlResultSetMapping(name = "ManageEmploymentClaimsDetailsResponseMapping", entities = {
		@EntityResult(entityClass = ManageEmploymentClaimsDetailsRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "memberNo", column = "member_no"),
				@FieldResult(name = "personRefNo", column = "person_ref_no"),
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "nicType", column = "nic_type"),
				@FieldResult(name = "passportNo", column = "passport_no"),
				@FieldResult(name = "designation", column = "designation"),
				@FieldResult(name = "nameWithInitials", column = "name_with_initials"),
				@FieldResult(name = "firstName", column = "first_name"),
				@FieldResult(name = "lastName", column = "last_name"),
				@FieldResult(name = "fullName", column = "full_name")

		}), })

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ManageEmploymentClaimsDetailsRespDto {
	
	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("member_no")
	private Long memberNo;
	@JsonProperty("person_ref_no")
	private Long personRefNo;
	@JsonProperty("nic_no")
	private String nicNo;
	@JsonProperty("designation")
	private String designation;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("name_with_initials")
	private String nameWithInitials;
	@JsonProperty("passport_no")
	private String passportNo;
	@JsonProperty("nic_type")
	private String nicType;

}
