package com.inova.etfb.employer_management.param;

import java.util.List;

import com.inova.common.dao.wrapper.DocumentRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserContactDetailsResDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserDetailsResDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserHistoryDetailsResDto;
import com.inova.etfb.employer_management.wrapper.EmployerProfileSelectedUserMemberGroupDetailsResDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerProfileSelectedUserDetailsParamDto {

	private EmployerProfileSelectedUserDetailsResDto userDetail;
	private List<EmployerProfileSelectedUserMemberGroupDetailsResDto> memberGroups;
	private List<EmployerProfileSelectedUserContactDetailsResDto> contactDetails;
	private List<DocumentRespDto> documentDetails;
	private List<EmployerProfileSelectedUserHistoryDetailsResDto> historyDateList;
	
}
