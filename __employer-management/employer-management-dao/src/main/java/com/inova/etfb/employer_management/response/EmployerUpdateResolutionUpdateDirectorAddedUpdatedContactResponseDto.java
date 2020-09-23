package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateResolutionUpdateDirectorAddedUpdatedContactResponseDto {
    @JsonProperty(value = "reference_table_code_id")
    private Integer referenceTableCodeId;
    @JsonProperty(value = "reference_table_id")
    private Long referenceTableId;
    @JsonProperty("person_contact_id")
    private Long personContactId;
    @JsonProperty("contact_info_id")
    private Long contactInfoId;
    @JsonProperty("contact_type_id")
    private Long contactTypeId;
    @JsonProperty("contact_type")
    private String contactType;
    @JsonProperty("contact_type_sin")
    private String contactTypeSin;
    @JsonProperty("contact_type_tam")
    private String contactTypeTam;
    @JsonProperty("contact_value")
    private String contactValue;
    @JsonProperty("public_note")
    private String publicNote;
    @JsonProperty("note")
    private String note;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("contact_sms")
    private Boolean contactSms;
    @JsonProperty("contact_email")
    private Boolean contactEmail;
    @JsonProperty("incorrect_contact")
    private Boolean incorrectContact;
    @JsonProperty("added")
    private Boolean added;
    @JsonProperty("selected")
    private Boolean selected;
    @JsonProperty("created_at")
    private Date createdAt;
}
