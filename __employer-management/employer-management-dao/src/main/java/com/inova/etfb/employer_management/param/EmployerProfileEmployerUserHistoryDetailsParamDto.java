package com.inova.etfb.employer_management.param;

import java.util.List;

import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserContactDetailsResDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserDetailsResDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserMemberGroupDetailsResDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileEmployerUserHistoryDetailsParamDto {

	private EmployerProfileSelectedUserDetailsResDto userHistoryDetails;
	private List<EmployerProfileSelectedUserMemberGroupDetailsResDto> memberGroups;
	private List<EmployerProfileSelectedUserContactDetailsResDto> contactDetails;
	
}
