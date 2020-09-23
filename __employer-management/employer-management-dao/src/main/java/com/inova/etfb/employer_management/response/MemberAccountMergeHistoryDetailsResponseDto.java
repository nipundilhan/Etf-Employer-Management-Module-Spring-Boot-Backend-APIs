package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.dao.wrapper.MemberAccountMergeBasicRespDto;
import com.inova.common.dao.wrapper.MemberAccountMergeDetailsRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberAccountMergeHistoryDetailsResponseDto {

	@JsonProperty(value = "basic_merge_details")
	private MemberAccountMergeBasicRespDto memberAccountMergeBasicRespDto;
	@JsonProperty(value = "member_account_merge_list")
	private List<MemberAccountMergeDetailsRespDto> memberAccountMergeDetailsRespDtoList;
}

