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

@SqlResultSetMapping(name = "ViewBranchDeailViewResult" , entities = {
		@EntityResult(entityClass = ViewBranchDetailsMainResponseDto.class , fields = {
				
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				
				@FieldResult(name = "reqRefNo", column = "reqRefNo"),
				
				@FieldResult(name = "empBranchId", column = "empBranchId"),
				
				@FieldResult(name = "empIterimBranchId" , column = "empIterimBranchId"),
				
				@FieldResult(name = "branchName" , column = "branchName"),
				
				@FieldResult(name = "employerOwnEtfbBranch" , column = "employerOwnEtfbBranch"),
				
				@FieldResult(name = "headOffice" , column = "headOffice"),
				
				@FieldResult(name = "brnAddress" , column = "brnAddress"),
				
				@FieldResult(name = "maillingAddress" , column = "maillingAddress"),
				
				@FieldResult(name = "status" , column = "status"),
				
				@FieldResult(name = "inactiveReasonEng" , column = "inactiveReasonEng"),
				
				@FieldResult(name = "inactiveReasonSin" , column = "inactiveReasonSin"),
				
				@FieldResult(name = "inactiveReasonTam" , column = "inactiveReasonTam"),
				
				@FieldResult(name = "address1Eng" , column = "address1Eng"),
				
				@FieldResult(name = "address2Eng" , column = "address2Eng"),
				
				@FieldResult(name = "address3Eng" , column = "address3Eng"),
				
				@FieldResult(name = "address4Eng" , column = "address4Eng"),
				
				@FieldResult(name = "cityEng" , column = "cityEng"),
				
				@FieldResult(name = "address1Sin" , column = "address1Sin"),
				
				@FieldResult(name = "address2Sin" , column = "address2Sin"),
				
				@FieldResult(name = "address3Sin" , column = "address3Sin"),
				
				@FieldResult(name = "address4Sin" , column = "address4Sin"),
				
				@FieldResult(name = "citySin" , column = "citySin"),
				
				@FieldResult(name = "address1Tam" , column = "address1Tam"),
				
				@FieldResult(name = "address2Tam" , column = "address2Tam"),
				
				@FieldResult(name = "address3Tam" , column = "address3Tam"),
				
				@FieldResult(name = "address4Tam" , column = "address4Tam"),
				
				@FieldResult(name = "cityTam" , column = "cityTam"),
				
				@FieldResult(name = "districtEng" , column = "districtEng"),
				
				@FieldResult(name = "districtSin" , column = "districtSin"),
				
				@FieldResult(name = "districtTam" , column = "districtTam"),
				
				@FieldResult(name = "postalCode" , column = "postalCode"),
				
				@FieldResult(name = "incorrectAddressEng" , column = "incorrectAddressEng"),
				
				@FieldResult(name = "incorrectAddressSin" , column = "incorrectAddressSin"),
				
				@FieldResult(name = "incorrectAddressTam" , column = "incorrectAddressTam"),
				
				@FieldResult(name = "addressNote" , column = "addressNote"),
				
				@FieldResult(name = "addressNoteCreatedAt" , column = "addressNoteCreatedAt"),
				
				@FieldResult(name = "addressNoteCreatedBy" , column = "addressNoteCreatedBy"),
				
				@FieldResult(name = "gnName" , column = "gnName"),
				
				@FieldResult(name = "gnCode" , column = "gnCode"),
				
				@FieldResult(name = "divisionalSecretariatEng" , column = "divisionalSecretariatEng"),
				
				@FieldResult(name = "divisionalSecretariatSin" , column = "divisionalSecretariatSin"),
				
				@FieldResult(name = "divisionalSecretariatTam" , column = "divisionalSecretariatTam"),
				
				@FieldResult(name = "localGovermentAuthEng" , column = "localGovermentAuthEng"),
				
				@FieldResult(name = "localGovermentAuthSin" , column = "localGovermentAuthSin"),
				
				@FieldResult(name = "localGovermentAuthTam" , column = "localGovermentAuthTam"),
				
				@FieldResult(name = "etfbBranch" , column = "etfbBranch"),
				
				@FieldResult(name = "etfbZone" , column = "etfbZone"),
				
				@FieldResult(name = "policeEng" , column = "policeEng"),
				
				@FieldResult(name = "policeSin" , column = "policeSin"),
				
				@FieldResult(name = "policeTam" , column = "policeTam"),
				
				@FieldResult(name = "policeDescription" , column = "policeDescription"),
				
				@FieldResult(name = "policeStationNote" , column = "policeStationNote"),
				
				@FieldResult(name = "courtsNote" , column = "courtsNote"),
				
				@FieldResult(name = "branchNote" , column = "branchNote"),
				
				@FieldResult(name = "createdAt" , column = "createdAt"),
				
				@FieldResult(name = "createdBy" , column = "createdBy"),
				
				@FieldResult(name = "createEtfbBranch" , column = "createEtfbBranch"),
				
				@FieldResult(name = "updateAt" , column = "updateAt"),
				
				@FieldResult(name = "employerBranchHistoryId" , column = "employerBranchHistoryId"),
				
				@FieldResult(name = "updateBy" , column = "updateBy"),				
				
				@FieldResult(name = "dmuInboundRefNo" , column = "dmuInboundRefNo"),
				
				@FieldResult(name = "dmuInboundPrefixRefNo" , column = "dmuInboundPrefixRefNo"),
				
				@FieldResult(name = "serviceCounterRefNo" , column = "serviceCounterRefNo"),
				
				@FieldResult(name = "serviceCounterPrefixRefNo" , column = "serviceCounterPrefixRefNo"),
				
				@FieldResult(name = "serviceRequestRefNo" , column = "serviceRequestRefNo"),
				
				@FieldResult(name = "serviceRequestPrefixRefNo" , column = "serviceRequestPrefixRefNo"),
				
				@FieldResult(name = "updateEtfbBranch" , column = "updateEtfbBranch"),
				
				@FieldResult(name = "starName" , column = "starName"),
				
				@FieldResult(name = "starEmpOwnBranch" , column = "starEmpOwnBranch"),
				
				@FieldResult(name = "starHeadOffice" , column = "starHeadOffice"),
				
				@FieldResult(name = "starBrnAddress" , column = "starBrnAddress"),
				
				@FieldResult(name = "starMaillingAddress" , column = "starMaillingAddress"),
				
				@FieldResult(name = "starAddress" , column = "starAddress"),
				
				@FieldResult(name = "starLocalGovenrmentAuthority" , column = "starLocalGovenrmentAuthority"),
				
				@FieldResult(name = "starEtfbBranch" , column = "starEtfbBranch"),
				
				@FieldResult(name = "starEtfbZone" , column = "starEtfbZone"),
				
				@FieldResult(name = "starPoliceStation" , column = "starPoliceStation"),
				
				@FieldResult(name = "branchMigrated" , column = "branchMigrated")
					
		}),
})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewBranchDetailsMainResponseDto {
	
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


