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

@SqlResultSetMapping(name = "EmployerUpdateResolutionDirectorContactDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionDirectorContactDetailsRespDto.class, fields = {

                @FieldResult(name = "rowNumber", column = "rowNumber"),
                @FieldResult(name = "employerRequestDirectorContactAddupdateId", column = "employer_request_director_contact_addupdate_id"),
                @FieldResult(name = "personContactId", column = "person_contact_id"),
                @FieldResult(name = "contactInfoId", column = "contact_info_id"),
                @FieldResult(name = "contactTypeId", column = "contact_type_id"),
                @FieldResult(name = "contactTypeCode", column = "contact_type_code"),
                @FieldResult(name = "contactType", column = "contact_type"),
                @FieldResult(name = "contactTypeSin", column = "contact_type_sin"),
                @FieldResult(name = "contactTypeTam", column = "contact_type_tam"),
                @FieldResult(name = "contactValue", column = "contact_value"),
                @FieldResult(name = "publicNote", column = "public_note"),
                @FieldResult(name = "note", column = "note"),
                @FieldResult(name = "active", column = "active"),
                @FieldResult(name = "contactSms", column = "contact_sms"),
                @FieldResult(name = "contactEmail", column = "contact_email"),
                @FieldResult(name = "incorrectContact", column = "incorrect_contact"),
                @FieldResult(name = "added", column = "added"),
                @FieldResult(name = "selected", column = "selected"),
                @FieldResult(name = "createdAt", column = "created_at"),
                @FieldResult(name = "updateType", column = "update_type"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionDirectorContactDetailsRespDto {
    @Id
    @JsonProperty("row_number")
    private Long rowNumber;
    @JsonProperty("employer_request_director_contact_addupdate_id")
    private Long employerRequestDirectorContactAddupdateId;
    @JsonProperty("person_contact_id")
    private Long personContactId;
    @JsonProperty("contact_info_id")
    private Long contactInfoId;
    @JsonProperty("contact_type_id")
    private Long contactTypeId;
    
    @JsonProperty("contact_type_code")
    private String contactTypeCode;
    
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
    @JsonProperty("update_type")
    private Integer updateType;

}
