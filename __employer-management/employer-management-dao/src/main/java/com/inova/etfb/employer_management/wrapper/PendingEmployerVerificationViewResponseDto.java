package com.inova.etfb.employer_management.wrapper;

import java.util.Date;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.response.dto.AddressResponseDtoChild1;
import com.inova.response.dto.ContactInfoResponseDtoChild4;
import com.inova.response.dto.EmployerVerificationRequestHoldHistoryResponseDtoChild2;
import com.inova.response.dto.EmployerVerificationRequestMessageResponseDtoChild3;
import com.inova.response.dto.MessageDeliveredResponseDtoChild2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "PendingEmployerVerificationViewResponseMapping", entities = {
		@EntityResult(entityClass = PendingEmployerVerificationViewResponseDto.class , fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "createdAt", column = "createdAt"),
				@FieldResult(name = "createdBy", column = "createdBy"),
				@FieldResult(name = "requestNote", column = "requestNote"),
				@FieldResult(name = "prefix", column = "prefix"),
				@FieldResult(name = "requestRefNumber", column = "requestRefNumber"),
				@FieldResult(name = "hold", column = "hold"),
				@FieldResult(name = "priority", column = "priority"),
				@FieldResult(name = "epfNumber" , column = "epfNumber"),
				@FieldResult(name = "businessRegNumber", column = "businessRegNumber"),
				@FieldResult(name = "employerNameEnglish", column = "employerNameEnglish"),
				@FieldResult(name = "employerNameSinhala", column = "employerNameSinhala"),
				@FieldResult(name = "employerNameTamil", column = "employerNameTamil"),
				@FieldResult(name = "createdEtfbBranch", column = "createdEtfbBranch"),
				@FieldResult(name = "createdEtfbZone", column = "createdEtfbZone"),
				@FieldResult(name = "employerEtfbBranch", column = "employerEtfbBranch"),
				@FieldResult(name = "employerType", column = "employerType"),
				@FieldResult(name = "requestedSource", column = "requestedSource"),
				@FieldResult(name = "requestedSourceCode", column = "requestedSourceCode"),
				@FieldResult(name = "localGovName", column = "localGovName"),
				@FieldResult(name = "gramaNiladhariDevName", column = "gramaNiladhariDevName"),
				@FieldResult(name = "gramaNiladhariDevCode", column = "gramaNiladhariDevCode"),
				@FieldResult(name = "industryType", column = "industryType"),
				@FieldResult(name = "employerOrganizationType", column = "employerOrganizationType"),
				@FieldResult(name = "natureOfBusiness", column = "natureOfBusiness"),
				@FieldResult(name = "logo", column = "logo"),
				@FieldResult(name = "dmsRef", column = "dmsRef"),
				@FieldResult(name = "employerInterimBranchId", column = "employerInterimBranchId"),
				@FieldResult(name = "employerOrganizationTypeId", column = "employerOrganizationTypeId"),
				@FieldResult(name = "employerOrganizationTypeName", column = "employerOrganizationTypeName"),
				@FieldResult(name = "industryTypeId", column = "industryTypeId"),
				@FieldResult(name = "industryTypeName", column = "industryTypeName"),
				@FieldResult(name = "natureOfBusinessId", column = "natureOfBusinessId"),
				@FieldResult(name = "natureOfBusinessName", column = "natureOfBusinessName"),
				@FieldResult(name = "ownBranchId", column = "ownBranchId"),
				@FieldResult(name = "verificationStatus", column = "verificationStatus"),
				@FieldResult(name = "employerInterimId", column = "employerInterimId"),
				@FieldResult(name = "inputContent", column = "inputContent"),
				
		}),
	}, classes = {
		/*Don't change the order. This is the parameter order of AddressResponseDtoChild1 constructor*/
		@ConstructorResult(targetClass  = AddressResponseDtoChild1.class , columns  = {
				@ColumnResult(name = "address1", type = String.class),
				@ColumnResult(name = "address2" , type = String.class),
				@ColumnResult(name = "address3" , type = String.class),
				@ColumnResult(name = "address1Sin", type = String.class),
				@ColumnResult(name = "address2Sin" , type = String.class),
				@ColumnResult(name = "address3Sin" , type = String.class),
				@ColumnResult(name = "address1Tam", type = String.class),
				@ColumnResult(name = "address2Tam" , type = String.class),
				@ColumnResult(name = "address3Tam" , type = String.class),
				@ColumnResult(name = "city", type = String.class),
				@ColumnResult(name = "citySin" , type = String.class),
				@ColumnResult(name = "cityTam" , type = String.class),
				@ColumnResult(name = "postalCode" , type = String.class),
				@ColumnResult(name = "note" , type = String.class),
				@ColumnResult(name = "districtEng" , type = String.class),
				@ColumnResult(name = "districtSin" , type = String.class),
				@ColumnResult(name = "districtTam" , type = String.class),
				@ColumnResult(name = "divisionalSecretariat" , type = String.class),
				@ColumnResult(name = "gramaNiladhariDevName" , type = String.class),
				@ColumnResult(name = "gramaNiladhariDevCode" , type = String.class),
				@ColumnResult(name = "countryId" , type = Integer.class),
				@ColumnResult(name = "districtId" , type = Integer.class),
		}),
		@ConstructorResult(targetClass  = AddressResponseDtoChild1.class , columns  = {
				@ColumnResult(name = "hoAddress1", type = String.class),
				@ColumnResult(name = "hoAddress2" , type = String.class),
				@ColumnResult(name = "hoAddress3" , type = String.class),
				@ColumnResult(name = "hoCity", type = String.class),
				@ColumnResult(name = "hoPostalCode" , type = String.class),
				@ColumnResult(name = "hoDistrictEng" , type = String.class)
		})
	})

	@SqlResultSetMapping(name = "ContactInfoResponseChild1Mapping", classes = {
		/*Don't change the order. This is the parameter order of ContactInfoResponseDtoChild1 constructor*/
		@ConstructorResult(targetClass  = ContactInfoResponseDtoChild4.class , columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "value" , type = String.class),
				@ColumnResult(name = "note" , type = String.class),
				@ColumnResult(name = "code", type = String.class),
				@ColumnResult(name = "nameEng" , type = String.class),
				@ColumnResult(name = "employerInterimGeneralContactId" , type = Long.class),
		})
	})

	@SqlResultSetMapping(name = "AddressResponseDtoChild1Mapping", classes = {
		/*Don't change the order. This is the parameter order of AddressResponseDtoChild1 constructor*/
		@ConstructorResult(targetClass  = AddressResponseDtoChild1.class , columns  = {
				@ColumnResult(name = "address1", type = String.class),
				@ColumnResult(name = "address2" , type = String.class),
				@ColumnResult(name = "address3" , type = String.class),
				@ColumnResult(name = "address1Sin", type = String.class),
				@ColumnResult(name = "address2Sin" , type = String.class),
				@ColumnResult(name = "address3Sin" , type = String.class),
				@ColumnResult(name = "address1Tam", type = String.class),
				@ColumnResult(name = "address2Tam" , type = String.class),
				@ColumnResult(name = "address3Tam" , type = String.class),
				@ColumnResult(name = "city", type = String.class),
				@ColumnResult(name = "citySin" , type = String.class),
				@ColumnResult(name = "cityTam" , type = String.class),
				@ColumnResult(name = "postalCode" , type = String.class),
				@ColumnResult(name = "note" , type = String.class),
				@ColumnResult(name = "districtEng" , type = String.class),
				@ColumnResult(name = "districtSin" , type = String.class),
				@ColumnResult(name = "districtTam" , type = String.class),
				@ColumnResult(name = "divisionalSecretariat" , type = String.class),
				@ColumnResult(name = "gramaNiladhariDevName" , type = String.class),
				@ColumnResult(name = "gramaNiladhariDevCode" , type = String.class),
			
		})
	})

@SqlResultSetMapping(name = "MessageDeliveredResponseDtoChild2Mapping", classes = {
		/*Don't change the order. This is the parameter order of MessageDeliveredResponseDtoChild2 constructor*/
		@ConstructorResult(targetClass  = MessageDeliveredResponseDtoChild2.class , columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "contactTypeId" , type = Long.class),
				@ColumnResult(name = "messageCodeId" , type = Long.class),
				@ColumnResult(name = "contactValue", type = String.class),
				@ColumnResult(name = "subject" , type = String.class),
				@ColumnResult(name = "body" , type = String.class),
				@ColumnResult(name = "deliveredAt", type = Date.class),
				@ColumnResult(name = "deliveryStatus" , type = int.class),
				@ColumnResult(name = "deliveryNote" , type = String.class),
				@ColumnResult(name = "generateType", type = int.class),
				@ColumnResult(name = "contactType" , type = String.class)
		})
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PendingEmployerVerificationViewResponseDto {
	@Id
	@JsonProperty("row_number")
	private Long rowNumber;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("request_note")
	private String requestNote;
	@JsonProperty("prefix_ref_no")
	private String prefix;
	@JsonProperty("request_ref_number")
	private Long requestRefNumber;
	@JsonProperty("hold")
	private boolean hold;
	@JsonProperty("priority")
	private String priority;
	@JsonProperty("epf_number")
	private String epfNumber;
	@JsonProperty("business_reg_number")
	private String businessRegNumber;
	@JsonProperty("employer_name_eng")
	private String employerNameEnglish;
	@JsonProperty("employer_name_sin")
	private String employerNameSinhala;
	@JsonProperty("employer_name_tam")
	private String employerNameTamil;
	@JsonProperty("created_etfb_branch")
	private String createdEtfbBranch;
	@JsonProperty("created_etfb_zone")
	private String createdEtfbZone;
	@JsonProperty("employer_etfb_branch")
	private String employerEtfbBranch;
	@JsonProperty("employer_type")
	private String employerType;
	@JsonProperty("requested_source")
	private String requestedSource;
	@JsonProperty("requested_source_code")
	private String requestedSourceCode;
	@JsonProperty("local_gov_name")
	private String localGovName;
	@JsonProperty("grama_niladhari_dev_name")
	private String gramaNiladhariDevName;
	@JsonProperty("grama_niladhari_dev_code")
	private String gramaNiladhariDevCode;
	@JsonProperty("industry_type")
	private String industryType;
	@JsonProperty("employer_organization_type")
	private String employerOrganizationType;
	@JsonProperty("nature_of_business")
	private String natureOfBusiness;
	@JsonProperty("company_logo")
	private byte[] logo;
	@JsonProperty("dms_ref")
	private String dmsRef;
	@JsonProperty("employer_interim_branch_id")
	private Long employerInterimBranchId;
	@JsonProperty("employer_organization_type_id")
	private Long employerOrganizationTypeId;
	@JsonProperty("employer_organization_type_name")
	private String employerOrganizationTypeName;
	@JsonProperty("industry_type_id")
	private Long industryTypeId;
	@JsonProperty("industry_type_name")
	private String industryTypeName;
	@JsonProperty("nature_of_business_id")
	private Long natureOfBusinessId;
	@JsonProperty("nature_of_business_name")
	private String natureOfBusinessName;
	@JsonProperty("verification_status")
	private String verificationStatus;
	@JsonIgnore
	private Long ownBranchId;
	@JsonIgnore
	private Long employerInterimId;
	@JsonProperty("input_content")
	private String inputContent;


	@Transient
	@JsonInclude
	@JsonProperty("address")
	private AddressResponseDtoChild1 addressData;
	@Transient
	@JsonInclude
	@JsonProperty("headOfficeAddress")
	private AddressResponseDtoChild1 headOfficeAddressData;
	@Transient
	@JsonInclude
	@JsonProperty("branch_contacts")
	private List<ContactInfoResponseDtoChild4> contactList;
	@Transient
	@JsonInclude
	@JsonProperty("general_contacts")
	private List<ContactInfoResponseDtoChild4> generalContactList;
	@Transient
	@JsonInclude
	@JsonProperty("hold_history")
	private List<EmployerVerificationRequestHoldHistoryResponseDtoChild2> holdHistoryResponseDtoList;
	@Transient
	@JsonInclude
	@JsonProperty("messages")
	private List<EmployerVerificationRequestMessageResponseDtoChild3> messageListResponseDto;

}
