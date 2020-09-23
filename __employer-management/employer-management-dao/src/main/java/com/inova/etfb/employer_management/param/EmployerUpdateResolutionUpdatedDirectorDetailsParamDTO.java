package com.inova.etfb.employer_management.param;

import com.inova.common.dao.wrapper.PersonDetailsRespDto;
import com.inova.common.dao.wrapper.PersonGeneralDetailsRespDto;
import com.inova.etfb.employer_management.response.EmployerDirectorAddressResponseDto;
import com.inova.etfb.employer_management.response.EmployerDirectorContactResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorAddressDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorContactDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorExistingDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorUpdatedDetailsRespDto;
import com.inova.response.dto.EmployerRequestDirectorUpdateResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO {
	
	private EmployerRequestDirectorUpdateResponseDto employerRequestDirectorUpdateResponseDto;
    private EmployerUpdateResolutionDirectorExistingDetailsRespDto existingEmployerDirectorDetailsResp;
    private PersonDetailsRespDto foundPersonDetailsResp;
    private PersonGeneralDetailsRespDto notFoundPersonDetailsResp;
    private EmployerUpdateResolutionDirectorUpdatedDetailsRespDto updatedDirectorDetailsResp;
    private List<EmployerUpdateResolutionDirectorAddressDetailsRespDto> updatedAddressListResp;
    private List<EmployerDirectorAddressResponseDto> existingPersonAddressListResp;
    private List<EmployerDirectorContactResponseDto> existingPersonContactListResp;
    private List<EmployerUpdateResolutionDirectorContactDetailsRespDto> updatedContactListResp;

}
