package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SqlResultSetMapping(name = "EmployerUpdateResolutionBranchContactDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionBranchContactDetailsRespDto.class, fields = {
                @FieldResult(name = "contactId", column = "contact_id"),
                @FieldResult(name = "contactInfoId", column = "contact_info_id"),
                @FieldResult(name = "contactType", column = "contact_type"),
                @FieldResult(name = "contactTypeId", column = "contact_type_id"),
                @FieldResult(name = "contactValue", column = "contact_value"),
                @FieldResult(name = "contactNote", column = "contact_note"),
                @FieldResult(name = "active", column = "active"),
                @FieldResult(name = "incorrectContact", column = "incorrect_contact"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionBranchContactDetailsRespDto {
    @Id
    private Long contactId;
    private Long contactInfoId;
    private String contactType;
    private Long contactTypeId;
    private String contactValue;
    private String contactNote;
    private Boolean active;
    private Boolean incorrectContact;
}
