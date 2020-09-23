package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.PersonDetailsRespDto;
import com.inova.common.dao.wrapper.PersonGeneralDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorAddressDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorExistingDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorUpdatedDetailsRespDto;
import com.inova.response.dto.EmployerRequestDirectorUpdateResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto {
	
	@JsonProperty("employer_request_director_update")
	private EmployerRequestDirectorUpdateResponseDto employerRequestDirectorUpdateResponseDto;
	
    @JsonProperty("existing_director_person_details")
    private EmployerUpdateResolutionDirectorExistingDetailsRespDto employerUpdateResolutionDirectorExistingDetailsRespDto;
//    private EmployerUpdateResolutionDirectorExistingDetailsResponseDto existingEmployerDirectorDetailsResponseDto;

    @JsonProperty("found_person_details")
    private PersonDetailsRespDto foundPersonDetailsResponseDto;

    @JsonProperty("not_found_person_details")
    private PersonGeneralDetailsRespDto notFoundPersonDetailsResponseDto;

    @JsonProperty("updated_director_details")
    private EmployerUpdateResolutionDirectorUpdatedDetailsRespDto employerUpdateResolutionDirectorUpdatedDetailsRespDto;
//    private EmployerUpdateResolutionUpdatedDirectorDetailsResponseDto updatedDirectorDetailsResponseDto;

    @JsonProperty("existing_person_addresses")
    private List<EmployerDirectorAddressResponseDto> existingPersonAddressResponseDtoList;

    @JsonProperty("updated_addresses")
    private List<EmployerUpdateResolutionDirectorAddressDetailsRespDto> employerUpdateResolutionDirectorAddressDetailsRespDtoList;
//    private List<EmployerUpdateResolutionUpdateDirectorAddedUpdatedAddressResponseDto> updatedAddressResponseDtoList;

    @JsonProperty("existing_person_contacts")
    private List<EmployerDirectorContactResponseDto> existingPersonContactResponseDtoList;

    @JsonProperty("updated_contacts")
    private List<EmployerUpdateResolutionDirectorContactDetailsRespDto> employerUpdateResolutionDirectorContactDetailsRespDtoList;
//    private List<EmployerUpdateResolutionUpdateDirectorAddedUpdatedContactResponseDto> updatedContactResponseDtoList;
}
