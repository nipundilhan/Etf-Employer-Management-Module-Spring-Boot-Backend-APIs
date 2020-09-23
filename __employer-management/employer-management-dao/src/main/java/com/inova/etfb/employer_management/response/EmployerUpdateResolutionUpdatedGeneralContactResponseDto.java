package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateResolutionUpdatedGeneralContactResponseDto {
    @JsonProperty("contact_id")
    private Long contactId;
    @JsonProperty("branch_id")  // not used, for frontend easiness
    private Long branchId;
    @JsonProperty("contact_info_id")
    private Long contactInfoId;
    @JsonProperty("contact_type")
    private String contactType;
    @JsonProperty("contact_type_id")
    private Long contactTypeId;
    @JsonProperty("contact_value")
    private String contactValue;
    @JsonProperty("contact_note")
    private String contactNote;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("incorrect_contact")
    private Boolean incorrectContact;
}
