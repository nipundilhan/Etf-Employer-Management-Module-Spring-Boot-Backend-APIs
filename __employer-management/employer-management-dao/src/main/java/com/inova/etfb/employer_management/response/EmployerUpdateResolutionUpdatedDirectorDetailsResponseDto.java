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
public class EmployerUpdateResolutionUpdatedDirectorDetailsResponseDto {
    @JsonProperty("employer_interim_director_id")
    private Long employerInterimDirectorId;

    @JsonProperty("employer_director_id")
    private Long employerDirectorId;

    @JsonProperty("director_title")
    private String directorTitle;

    @JsonProperty("date_joined")
    private Date dateJoined;

    @JsonProperty("date_terminated")
    private Date dateTerminated;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("designation_updated")
    private Integer designationUpdated;

    @JsonProperty("active_updated")
    private Integer activeUpdated;

    @JsonProperty("inactive_reason_updated")
    private Integer inactiveReasonUpdated;

    @JsonProperty("date_joined_updated")
    private Integer dateJoinedUpdated;

    @JsonProperty("date_terminated_updated")
    private Integer dateTerminatedUpdated;

    @JsonProperty("note_updated")
    private Integer noteUpdated;

    @JsonProperty("note_public_updated")
    private Integer notePublicUpdated;

    @JsonProperty("signature_updated")
    private Integer signatureUpdated;

    @JsonProperty("ignore_address_changes")
    private Boolean ignoreAddressChanges;

    @JsonProperty("ignore_contact_changes")
    private Boolean ignoreContactChanges;

    @JsonProperty("signature")
    private byte[] signature;

}
