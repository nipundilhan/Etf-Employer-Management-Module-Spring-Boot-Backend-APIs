package com.inova.etfb.employer_management.response.build;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.response.MemberAnnualStatementResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerMemAnnualStatementResDto;
import com.inova.util.CreateResponseDtoBuilder;

import lombok.Data;

@Component
@Data
public class MemberAnnualStatementResponseDTOBuilder  implements CreateResponseDtoBuilder<List<EmployerMemAnnualStatementResDto>, List<MemberAnnualStatementResponseDto>> {

	@Override
	public List<MemberAnnualStatementResponseDto> buildCreateResponseDto(List<EmployerMemAnnualStatementResDto> responseList) {
	
		List<MemberAnnualStatementResponseDto> finalResponselist = new ArrayList<MemberAnnualStatementResponseDto>();
		
		
		for(EmployerMemAnnualStatementResDto response: responseList ) {
			finalResponselist.add(MemberAnnualStatementResponseDto.builder()
					.primeId(response.getPrimeId())
					.memberNo(response.getMemberNo())
					.amsYear(response.getAmsYear())
					.nameWithInitials(response.getNameWithInitials())
					.personRefNo(response.getPersonRefNo())
					.nicType(response.getNicType())
					.nicNo(response.getNicNo())
					.passportNo(response.getPassportNo())
					.interestRate(response.getInterestRate())
					.openingBalanceAmount(response.getOpeningBalanceAmount())
					.contributionCreditedAmount(response.getContributionCreditedAmount())
					.interestAmount(response.getInterestAmount())
					.yearEndBalance(response.getYearEndBalance())
					.adjesment(response.getAdjesment())
					.build()
				);
		}
		
		return finalResponselist;
				
	}
	
	
}
