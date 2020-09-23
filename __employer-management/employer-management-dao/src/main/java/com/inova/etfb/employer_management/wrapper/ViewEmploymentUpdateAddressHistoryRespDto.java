package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ViewEmploymentUpdateAddressHistoryResponseMapping", entities = {
		@EntityResult(entityClass = ViewEmploymentUpdateAddressHistoryRespDto.class, fields = {
				@FieldResult(name = "rowNumber", column = "rowNumber"),
				@FieldResult(name = "empMemAccntHisryId", column = "emp_mem_accnt_hisry_id"),
				@FieldResult(name = "empMemAccntId", column = "emp_mem_accnt_id"),
				@FieldResult(name = "pasnGnrlAddrsId", column = "psn_gnrl_addrs_id"),
				@FieldResult(name = "psnGnrlId", column = "person_general_id"),
				@FieldResult(name = "address1Eng", column = "address1_eng"),
				@FieldResult(name = "address1Sin", column = "address1_sin"),
				@FieldResult(name = "address1Tam", column = "address1_tam"),
				@FieldResult(name = "address2Eng", column = "address2_eng"),
				@FieldResult(name = "address2Sin", column = "address2_sin"),
				@FieldResult(name = "address2Tam", column = "address2_tam"),
				@FieldResult(name = "address3Eng", column = "address3_eng"),
				@FieldResult(name = "address3Sin", column = "address3_sin"),
				@FieldResult(name = "address3Tam", column = "address3_tam"),
				@FieldResult(name = "address4Eng", column = "address4_eng"),
				@FieldResult(name = "address4Sin", column = "address4_sin"),
				@FieldResult(name = "address4Tam", column = "address4_tam"),
				@FieldResult(name = "cityEng", column = "city_eng"),
				@FieldResult(name = "citySin", column = "city_sin"),
				@FieldResult(name = "cityTam", column = "city_tam"),
				@FieldResult(name = "districtEng", column = "district_eng"),
				@FieldResult(name = "districtSin", column = "district_sin"),
				@FieldResult(name = "districtTam", column = "district_tam"),
				@FieldResult(name = "postalCode", column = "postal_code"),
				@FieldResult(name = "etfbBranch", column = "etfb_branch"),
				@FieldResult(name = "addressNote", column = "address_note"),
				@FieldResult(name = "updatedTime", column = "update_at"),
				@FieldResult(name = "updatedBy", column = "update_by"),
				@FieldResult(name = "dmuRefNo", column = "dmu_refNo"),
				@FieldResult(name = "serviceCounterRefNo", column = "service_counter_refNo"),
				@FieldResult(name = "serviceRequestRefNo", column = "service_request_refNo")
		// @FieldResult(name = "portal" , column = "portal")

		}), })

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ViewEmploymentUpdateAddressHistoryRespDto {

	@Id
	@JsonProperty("rowNumber")
	private Long rowNumber;
	@JsonProperty("emp_mem_accnt_hisry_id")
	private Long empMemAccntHisryId;
	@JsonProperty("emp_mem_accnt_id")
	private Long empMemAccntId;
	@JsonProperty("psn_gnrl_addrs_id")
	private Long pasnGnrlAddrsId;
	@JsonProperty("person_general_id")
	private Long psnGnrlId;
	@JsonProperty("address1_eng")
	private String address1Eng;
	@JsonProperty("address1_sin")
	private String address1Sin;
	@JsonProperty("address1_tam")
	private String address1Tam;
	@JsonProperty("address2_eng")
	private String address2Eng;
	@JsonProperty("address2_sin")
	private String address2Sin;
	@JsonProperty("address2_tam")
	private String address2Tam;
	@JsonProperty("address3_eng")
	private String address3Eng;
	@JsonProperty("address3_sin")
	private String address3Sin;
	@JsonProperty("address3_tam")
	private String address3Tam;
	@JsonProperty("address4_eng")
	private String address4Eng;
	@JsonProperty("address4_sin")
	private String address4Sin;
	@JsonProperty("address4_tam")
	private String address4Tam;
	@JsonProperty("city_eng")
	private String cityEng;
	@JsonProperty("city_sin")
	private String citySin;
	@JsonProperty("city_tam")
	private String cityTam;
	@JsonProperty("district_eng")
	private String districtEng;
	@JsonProperty("district_sin")
	private String districtSin;
	@JsonProperty("district_tam")
	private String districtTam;
	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("address_note")
	private String addressNote;
	@JsonProperty("updated_at")
	private Date updatedTime;
	@JsonProperty("update_by")
	private String updatedBy;
	@JsonProperty("branch")
	private String etfbBranch;

	@JsonProperty("dmu_ref_no")
	private Long dmuRefNo;
	@JsonProperty("service_counter_re_no")
	private Long serviceCounterRefNo;
	@JsonProperty("service_request_ref_no")
	private Long serviceRequestRefNo;
//	@JsonProperty("portal")
//	private boolean portal;

}
