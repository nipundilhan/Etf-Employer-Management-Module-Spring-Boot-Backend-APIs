package com.inova.etfb.employer_management.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.common.response.dto.MemberAccountNomineeBasicDetailsResponseDto;
import com.inova.dto.PersonAddressListItemResponseDtoChild1;
import com.inova.dto.PersonContactListItemResponseDtoChild1;
import com.inova.response.dto.DocumentUploadedResponseDtoChild2;
import com.inova.response.dto.EmployerMemberAccountResponseDtoChild2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerMemberAccountDetailResponseDto extends EmployerMemberAccountResponseDtoChild2 {

	@JsonProperty("person_addresses")
	private List<PersonAddressListItemResponseDtoChild1> lstPersonAddress;
	@JsonProperty("person_contacts")
	private List<PersonContactListItemResponseDtoChild1> lstPersonContacts;
	@JsonProperty("member_account_nominees")
	private List<MemberAccountNomineeBasicDetailsResponseDto> lstMemAccNomineeDetails;
	@JsonProperty("employer_documents")
	private List<DocumentUploadedResponseDtoChild2> lstEmployerDocuments;

}