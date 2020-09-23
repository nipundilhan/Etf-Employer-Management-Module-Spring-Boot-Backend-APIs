package com.inova.etfb.employer_management.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.etfb.employer_management.wrapper.PendingEmployerVerificationSearchDetailsResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingEmployerSearchResponseDto {

	@JsonProperty("assignedVerificationDetails")
	List<PendingEmployerVerificationSearchDetailsResponseDto> assignedVerificationDetails;
	@JsonProperty("unassignedVerificationDetails")
	List<PendingEmployerVerificationSearchDetailsResponseDto> unassignedVerificationDetails;

}
