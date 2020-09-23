package com.inova.etfb.employer_management.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ViewEmployerBasicDetailsViewResult" , entities = {
		@EntityResult(entityClass = ViewEmployerBasicDetailsMainResponseDto.class , fields = {
				
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "employerId", column = "employerId"),
				@FieldResult(name = "epfNo", column = "epfNo"),
				@FieldResult(name = "refNo", column = "refNo"),
				@FieldResult(name = "prefixRefNo", column = "prefixRefNo"),
				@FieldResult(name = "BRN" , column = "BRN"),
				@FieldResult(name = "engName" , column = "engName"),
				@FieldResult(name = "sinName" , column = "sinName"),
				@FieldResult(name = "tamName" , column = "tamName"),
				@FieldResult(name = "empTypeId" , column = "empTypeId"),
				@FieldResult(name = "empTypeCode" , column = "empTypeCode"),
				@FieldResult(name = "empTypeName" , column = "empTypeName"),
				@FieldResult(name = "legacyEpfNo" , column = "legacyEpfNo"),
				@FieldResult(name = "industryTypeId" , column = "industryTypeId"),
				@FieldResult(name = "industryTypeName" , column = "industryTypeName"),
				@FieldResult(name = "natureOfBusiness" , column = "natureOfBusiness"),
				@FieldResult(name = "organizationType" , column = "organizationType"),
				@FieldResult(name = "dateLiablePayment" , column = "dateLiablePayment"),
				@FieldResult(name = "preferredLanguage" , column = "preferredLanguage"),
				@FieldResult(name = "governmentEntity" , column = "governmentEntity"),
				@FieldResult(name = "onlineRemittanceRequested" , column = "onlineRemittanceRequested"),
				@FieldResult(name = "onlineAmsRequested" , column = "onlineAmsRequested"),
				@FieldResult(name = "verificationMobileNo" , column = "verificationMobileNo"),
				@FieldResult(name = "verificationEmail" , column = "verificationEmail"),
				@FieldResult(name = "employerStatus" , column = "employerStatus"),
				@FieldResult(name = "inactiveReason" , column = "inactiveReason"),
				@FieldResult(name = "availableBalance" , column = "availableBalance"),
				@FieldResult(name = "employerNote" , column = "employerNote"),
				@FieldResult(name = "updateAt" , column = "updateAt"),
				@FieldResult(name = "updateBy" , column = "updateBy"),
				@FieldResult(name = "dmuInboundRefNo" , column = "dmuInboundRefNo"),
				@FieldResult(name = "dmuInboundPrefixRefNo" , column = "dmuInboundPrefixRefNo"),
				@FieldResult(name = "serviceCounterRefNo" , column = "serviceCounterRefNo"),
				@FieldResult(name = "serviceCounterPrefixRefNo" , column = "serviceCounterPrefixRefNo"),
				@FieldResult(name = "serviceRequestRefNo" , column = "serviceRequestRefNo"),
				@FieldResult(name = "serviceRequestPrefixRefNo" , column = "serviceRequestPrefixRefNo"),
				@FieldResult(name = "updateEtfbBranch" , column = "updateEtfbBranch"),
				@FieldResult(name = "starEpfNo" , column = "starEpfNo"),
				@FieldResult(name = "starBRN" , column = "starBRN"),
				@FieldResult(name = "starEmpName" , column = "starEmpName"),
				@FieldResult(name = "starEmpNameSinhala" , column = "starEmpNameSinhala"),
				@FieldResult(name = "starEmpNameTamil" , column = "starEmpNameTamil"),
				@FieldResult(name = "starEmployerType" , column = "starEmployerType"),
				@FieldResult(name = "starLegacyEpfNo" , column = "starLegacyEpfNo"),
				@FieldResult(name = "starIndustryType" , column = "starIndustryType"),
				@FieldResult(name = "starNatureOfBusiness" , column = "starNatureOfBusiness"),
				@FieldResult(name = "starOrganizationType" , column = "starOrganizationType"),
				@FieldResult(name = "starDateLiableForPayment" , column = "starDateLiableForPayment"),
				@FieldResult(name = "starPreferredLanguage" , column = "starPreferredLanguage"),
				@FieldResult(name = "starGovernmentEntity" , column = "starGovernmentEntity"),
				@FieldResult(name = "starOnlineRemitanceDetails" , column = "starOnlineRemitanceDetails"),
				@FieldResult(name = "starOnlineAmsRequested" , column = "starOnlineAmsRequested"),
				@FieldResult(name = "starVerificationMobileNo" , column = "starVerificationMobileNo"),
				@FieldResult(name = "starVerificationEmail" , column = "starVerificationEmail"),
				@FieldResult(name = "employerHistoryId" , column = "employerHistoryId")
					
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerBasicDetailsMainResponseDto {
	
	@Id
	@JsonProperty("row_number")
	private Integer rowNumber;

	@JsonProperty("emp_branch_id")
	private Long empBranchId;
	
	@JsonProperty("emp_iterim_branch_id")
	private Long empIterimBranchId;
	
	@JsonProperty("branch_name")
	private String  branchName;
	
	@JsonProperty("employer_own_ETFB_brach")
	private Integer  employerOwnEtfbBranch;
	
	@JsonProperty("head_office")
	private Integer  headOffice;
	
	@JsonProperty("brn_address")
	private Integer  brnAddress;
	
	@JsonProperty("mailling_address")
	private Integer  maillingAddress;
	
	@JsonProperty("status")
	private String  status;
	
	@JsonProperty("inactive_reason_eng")
	private String  inactiveReasonEng;
	
	@JsonProperty("inactive_reason_sin")
	private String  inactiveReasonSin;
	
	@JsonProperty("inactive_reason_tam")
	private String  inactiveReasonTam;
	
	@JsonProperty("address1_eng")
	private String  address1Eng;
	
	@JsonProperty("address2_eng")
	private String  address2Eng;
	
	@JsonProperty("address3_eng")
	private String  address3Eng;
	
	@JsonProperty("address4_eng")
	private String  address4Eng;
	
	@JsonProperty("city_eng")
	private String  cityEng;
	
	@JsonProperty("address1_sin")
	private String  address1Sin;
	
	@JsonProperty("address2_sin")
	private String  address2Sin;
	
	@JsonProperty("address3_sin")
	private String  address3Sin;
	
	@JsonProperty("address4_sin")
	private String  address4Sin;
	
	@JsonProperty("city_sin")
	private String  citySin;
	
	@JsonProperty("address1_tam")
	private String  address1Tam;
	
	@JsonProperty("address2_tam")
	private String  address2Tam;
	
	@JsonProperty("address3_tam")
	private String  address3Tam;
	
	@JsonProperty("address4_tam")
	private String  address4Tam;
	
	@JsonProperty("city_tam")
	private String  cityTam;
	
	@JsonProperty("district_eng")
	private String  districtEng;
	
	@JsonProperty("district_sin")
	private String  districtSin;
	
	@JsonProperty("district_tam")
	private String  districtTam;
	
	@JsonProperty("postal_code")
	private String  postalCode;
		
	@JsonProperty("incorrect_address_eng")
	private String  incorrectAddressEng;
	
	@JsonProperty("incorrect_address_sin")
	private String  incorrectAddressSin;
	
	@JsonProperty("incorrect_address_tam")
	private String  incorrectAddressTam;
	
	@JsonProperty("address_note")
	private String  addressNote;
	
	@JsonProperty("address_note_created_at")
	private Date  addressNoteCreatedAt;
	
	@JsonProperty("address_note_created_by")
	private String  addressNoteCreatedBy;
	
	@JsonProperty("gn_name")
	private String  gnName;
	
	@JsonProperty("gn_code")
	private String  gnCode;
	
	@JsonProperty("divisional_secretariat_eng")
	private String  divisionalSecretariatEng;
	
	@JsonProperty("divisional_secretariat_sin")
	private String  divisionalSecretariatSin;
	
	@JsonProperty("divisional_secretariat_tam")
	private String  divisionalSecretariatTam;
	
	@JsonProperty("local_goverment_auth_eng")
	private String  localGovermentAuthEng;
	
	@JsonProperty("local_goverment_auth_sin")
	private String  localGovermentAuthSin;
	
	@JsonProperty("local_goverment_auth_tam")
	private String  localGovermentAuthTam;
	
	@JsonProperty("etfb_branch")
	private String  etfbBranch;
	
	@JsonProperty("etfb_zone")
	private String  etfbZone;
	
	@JsonProperty("policeEng")
	private String  policeEng;
	
	@JsonProperty("police_sin")
	private String  policeSin;
	
	@JsonProperty("police_tam")
	private String  policeTam;
	
	@JsonProperty("police_description")
	private String  policeDescription;
	
	@JsonProperty("police_station_note")
	private String  policeStationNote;
	
	@JsonProperty("courts_note")
	private String  courtsNote;
	
	@JsonProperty("branch_note")
	private String  branchNote;
	
	@JsonProperty("created_at")
	private Date  createdAt;
	
	@JsonProperty("created_by")
	private String  createdBy;
	
	@JsonProperty("create_etfb_branch")
	private String  createEtfbBranch;
	
	@JsonProperty("update_at")
	private Date  updateAt;
	
	@JsonProperty("employer_branch_history_id")
	private Integer  employerBranchHistoryId;
	
	@JsonProperty("update_by")
	private String  updateBy;
	
	@JsonProperty("dmu_inbound_ref_no")
	private String  dmuInboundRefNo;
	
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String  dmuInboundPrefixRefNo;
	
	@JsonProperty("service_counter_ref_no")
	private String  serviceCounterRefNo;
	
	@JsonProperty("service_counter_prefix_ref_no")
	private String  serviceCounterPrefixRefNo;
	
	@JsonProperty("service_request_ref_no")
	private String  serviceRequestRefNo;
	
	@JsonProperty("service_request_prefix_ref_no")
	private String  serviceRequestPrefixRefNo;
	
	@JsonProperty("update_etfb_branch")
	private String  updateEtfbBranch;
	
	@JsonProperty("star_name")
	private Integer  starName;
	
	@JsonProperty("star_emp_own_branch")
	private Integer  starEmpOwnBranch;
	
	@JsonProperty("star_head_office")
	private Integer  starHeadOffice;
	
	@JsonProperty("star_brn_address")
	private Integer  starBrnAddress;
	
	@JsonProperty("star_mailling_address")
	private Integer  starMaillingAddress;
	
	@JsonProperty("star_address")
	private Integer  starAddress;
	
	@JsonProperty("star_local_govenrment_authority")
	private Integer  starLocalGovenrmentAuthority;
	
	@JsonProperty("star_etfb_branch")
	private Integer  starEtfbBranch;
	
	@JsonProperty("star_etfb_zone")
	private Integer  starEtfbZone;
	
	@JsonProperty("star_police_station")
	private Integer  starPoliceStation;
	
	@JsonProperty("branch_migrated")
	private Integer  branchMigrated;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_branch_contact_details")
	private List<ViewBranchDetailsContactResponseDto> viewBranchDetailsContactResponseDto;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_branch_cort_details")
	private List<ViewBranchDetailsCortResponseDto> viewBranchDetailsCortResponseDto;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "view_branch_contact_person_details")
	private List<ViewBranchDetailsContactPersonResponseDto> viewBranchDetailsContactPersonResponseDto;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "branch_history_start_date")
	private ViewBranchDetailsStartDateResponseDto viewBranchDetailsStartDateResponseDto;
	
	@Transient
	@JsonInclude
	@JsonProperty(value = "branch_history_end_date")
	private ViewBranchDetailsEndDateResponseDto viewBranchDetailsEndDateResponseDto;
}


