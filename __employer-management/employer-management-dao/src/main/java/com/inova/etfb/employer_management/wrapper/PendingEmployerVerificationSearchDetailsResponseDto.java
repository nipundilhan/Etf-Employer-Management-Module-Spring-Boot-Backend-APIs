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

@SqlResultSetMapping(name = "PendingEmployerVerificationSearchResponseMapping", entities = {
	@EntityResult(entityClass = PendingEmployerVerificationSearchDetailsResponseDto.class , fields = {
			@FieldResult(name = "rowNumber", column = "rowNumber"),
			@FieldResult(name = "createdAt", column = "createdAt"),
			@FieldResult(name = "requestRefNumber", column = "requestRefNumber"),
			@FieldResult(name = "hold", column = "hold"),
			@FieldResult(name = "priority", column = "priority"),
			@FieldResult(name = "epfNumber" , column = "epfNumber"),
			@FieldResult(name = "businessRegNumber" , column = "businessRegNumber"),
			@FieldResult(name = "employerNameEnglish" , column = "employerNameEnglish"),
			@FieldResult(name = "etfbBranch" , column = "etfbBranch"),
			@FieldResult(name = "employerType" , column = "employerType"),
			@FieldResult(name = "requestedSource" , column = "requestedSource"),
			@FieldResult(name = "employerVerificationRequestId" , column = "employer_verification_request_id"),
	})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PendingEmployerVerificationSearchDetailsResponseDto {
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("created_at")
	protected Date createdAt;
	@JsonProperty("request_ref_number")
	protected Long requestRefNumber;
	@JsonProperty("hold")
	protected boolean hold;
	@JsonProperty("priority")
	protected String priority;
	@JsonProperty("epf_number")
	protected String epfNumber;
	@JsonProperty("business_reg_number")
	protected String businessRegNumber;
	@JsonProperty("employer_name_eng")
	protected String employerNameEnglish;
	@JsonProperty("etfb_branch")
	protected String etfbBranch;
	@JsonProperty("requested_source")
	protected String requestedSource;
	@JsonProperty("employer_type")
	protected String employerType;
	@JsonProperty("employer_verification_request_id")
	protected Long employerVerificationRequestId;
}