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

@SqlResultSetMapping(name = "EmployerMemNomineHstryDetMapping", entities = {
		@EntityResult(entityClass = EmployerMemNomineHstryRespDto.class, fields = {
 				@FieldResult(name = "memAccntNomineeHstryId", column = "mem_accnt_nominee_hstry_id"), 
 				@FieldResult(name = "personRefNo", column = "person_ref_no"),  
 				@FieldResult(name = "personPrefixRefNo", column = "person_prefix_ref_no"),
				@FieldResult(name = "title", column = "title"),
				@FieldResult(name = "firstName", column = "first_name"),
				@FieldResult(name = "lastName", column = "last_name"),
				@FieldResult(name = "fullName", column = "full_name"),
				@FieldResult(name = "nameWithInitials", column = "name_with_initials"),
				@FieldResult(name = "dateOfBirth", column = "date_of_birth"),			
				@FieldResult(name = "nicType", column = "nic_type"),
				@FieldResult(name = "nicNo", column = "nic_no"),
				@FieldResult(name = "passportNo", column = "passport_no"),
				@FieldResult(name = "country", column = "country"),
 				@FieldResult(name = "updatedAt", column = "updated_at"), 
				@FieldResult(name = "updatedBy", column = "updated_by"),
 				@FieldResult(name = "updatedEtfbBranch", column = "updated_etfb_branch"), 
 				@FieldResult(name = "dmuInboundPrefixRefNo", column = "dmu_inbound_prefix_ref_no"),
 				@FieldResult(name = "serviceRequestPrefixRefNo", column = "service_request_prefix_ref_no"),
 				@FieldResult(name = "serviceCounterPrefixRefNo", column = "service_counter_prefix_ref_no"),
				@FieldResult(name = "dmuInboundRefNo", column = "dmu_inbound_ref_no"),
 				@FieldResult(name = "serviceRequestRefNo", column = "service_request_ref_no"), 
				@FieldResult(name = "serviceCounterRefNo", column = "service_counter_ref_no"),
				@FieldResult(name = "note", column = "note") }), })

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerMemNomineHstryRespDto {
	
	
	@Id
	@JsonProperty("mem_accnt_nominee_hstry_id")
	private Long memAccntNomineeHstryId;
	
	@JsonProperty("person_ref_no")
	private String personRefNo;
	
	@JsonProperty("person_prefix_ref_no")
	private String personPrefixRefNo;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("name_with_initials")
	private String nameWithInitials;
		
	@JsonProperty("date_of_birth")
	private Date dateOfBirth;
	
	@JsonProperty("nic_type")
	private String nicType;
	
	@JsonProperty("nic_no")
	private String nicNo;
	
	@JsonProperty("passport_no")
	private String passportNo;
			
	@JsonProperty("country")
	private String country;
	
	
	@JsonProperty("end_date")
	private Date updatedAt;
	
	@JsonProperty("updated_by")
	private String updatedBy;
	
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	
	
	@JsonProperty("dmu_inbound_prefix_ref_no")
	private String dmuInboundPrefixRefNo;
	
	@JsonProperty("service_request_prefix_ref_no")
	private String serviceRequestPrefixRefNo;
	
	@JsonProperty("service_counter_prefix_ref_no")
	private String serviceCounterPrefixRefNo;
	
	@JsonProperty("dmu_inbound_ref_no")
	private String dmuInboundRefNo;
	
	@JsonProperty("service_request_ref_no")
	private String serviceRequestRefNo;
	
	@JsonProperty("service_counter_ref_no")
	private String serviceCounterRefNo;
	
	@JsonProperty("note")
	private String note;
		

}
