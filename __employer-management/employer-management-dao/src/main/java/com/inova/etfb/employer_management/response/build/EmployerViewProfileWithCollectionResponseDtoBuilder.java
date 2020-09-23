package com.inova.etfb.employer_management.response.build;


import com.inova.etfb.employer_management.response.EmployerProfileViewWithLastCollectionResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerLastCollectioDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerViewProfileSearchRespDto;
import com.inova.util.DateFormatter;
import com.inova.util.SingleResponseDtoBuilder;

import lombok.Data;

@Data
public class EmployerViewProfileWithCollectionResponseDtoBuilder
		implements SingleResponseDtoBuilder<Object, EmployerProfileViewWithLastCollectionResponseDto> {
	EmployerLastCollectioDetailsRespDto employerLastCollectioDetailsResponseDto;
	EmployerViewProfileSearchRespDto employerViewProfileSearchResponseDto;

	@Override
	public EmployerProfileViewWithLastCollectionResponseDto buildCreateResponseDto(Object singleResult) {
		return EmployerProfileViewWithLastCollectionResponseDto.builder()
				.employerId(employerViewProfileSearchResponseDto.getEmployerId())
				.epfNumber(employerViewProfileSearchResponseDto.getEpfNumber())
				.employerName(employerViewProfileSearchResponseDto.getEmployerName())
				.employerRefNumber(employerViewProfileSearchResponseDto.getEmployerRefNumber())
				.employerRefNumberPrefix(employerViewProfileSearchResponseDto.getEmployerRefNumberPrefix())
				.businessRegNumber(employerViewProfileSearchResponseDto.getBusinessRegNumber())
				.status(employerViewProfileSearchResponseDto.getStatus())
				.mergedAsChild(employerViewProfileSearchResponseDto.isMergedAsChild())
				.mergedAsParent(employerViewProfileSearchResponseDto.isMergedAsParent())
				.mergeAsMasterChild(employerViewProfileSearchResponseDto.isMergeAsMasterChild())
				.activeEmploymentCount(employerViewProfileSearchResponseDto.getActiveEmploymentCount())
				.activePortUsers(employerViewProfileSearchResponseDto.getActivePortUsers())
				.companyLogo(employerViewProfileSearchResponseDto.getLogoDocUploadedRef())
				.createdBy(employerViewProfileSearchResponseDto.getCreatedBy())
				//.createdAt(DateFormatter.convertStringToDateTime(employerViewProfileSearchResponseDto.getCreatedAt()))
				.createdAt(employerViewProfileSearchResponseDto.getCreatedAt())
				.etfbBranch(employerViewProfileSearchResponseDto.getEtfbBranch())
				.migrated(employerViewProfileSearchResponseDto.isMigrated())
				//.logoDocUploadedId(employerViewProfileSearchResponseDto.getLogoDocUploadedId())
				//.logoDocUploadedRef(employerViewProfileSearchResponseDto.getLogoDocUploadedRef())
				.lastCollectionRefNo(employerLastCollectioDetailsResponseDto != null ? employerLastCollectioDetailsResponseDto.getLastCollectionRefNo() : null)
				//.lastCollectionEffectiveDate(employerLastCollectioDetailsResponseDto != null ? DateFormatter.convertStringToDateTime((employerLastCollectioDetailsResponseDto.getLastCollectionEffectiveDate())): null)
				.lastCollectionEffectiveDate(employerLastCollectioDetailsResponseDto != null ? employerLastCollectioDetailsResponseDto.getLastCollectionEffectiveDate() : null)
				.lastCollectionContributionPeriod(employerLastCollectioDetailsResponseDto != null ? employerLastCollectioDetailsResponseDto.getLastCollectionContributionPeriod(): null)
				.lastCollectionPaymentStatus(employerLastCollectioDetailsResponseDto != null ? employerLastCollectioDetailsResponseDto.getLastCollectionPaymentStatus(): null)
				.meotName(employerViewProfileSearchResponseDto.getMeotName())
				.meotDirectorName(employerViewProfileSearchResponseDto.getMeotDirectorName())
				.build();
	}

}
