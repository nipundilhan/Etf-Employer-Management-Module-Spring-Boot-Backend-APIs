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

@SqlResultSetMapping(name = "EmployerUpdateResolutionDirectorUpdatedDetailsMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionDirectorUpdatedDetailsRespDto.class, fields = {
                @FieldResult(name = "employerInterimDirectorId", column = "employer_interim_director_id"),
                @FieldResult(name = "employerDirectorId", column = "employer_director_id"),
                @FieldResult(name = "directorTitle", column = "director_title"),
                @FieldResult(name = "dateJoined", column = "date_joined"),
                @FieldResult(name = "dateTerminated", column = "date_terminated"),
                @FieldResult(name = "designation", column = "designation"),
                @FieldResult(name = "signature", column = "signature"),
                @FieldResult(name = "designationUpdated", column = "designation_updated"),
                @FieldResult(name = "activeUpdated", column = "active_updated"),
                @FieldResult(name = "inactiveReasonUpdated", column = "inactive_reason_updated"),
                @FieldResult(name = "dateJoinedUpdated", column = "date_joined_updated"),
                @FieldResult(name = "dateTerminatedUpdated", column = "date_terrminated_updated"),
                @FieldResult(name = "noteUpdated", column = "note_updated"),
                @FieldResult(name = "notePublicUpdated", column = "note_public_updated"),
                @FieldResult(name = "signatureUpdated", column = "signature_updated"),
                @FieldResult(name = "ignoreAddressChanges", column = "ignore_address_changes"),
                @FieldResult(name = "ignoreContactChanges", column = "ignore_contact_changes"),
                @FieldResult(name = "signatureDmsRef", column = "signature_dms_ref"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionDirectorUpdatedDetailsRespDto {
    @Id
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
    @JsonProperty("signature_dms_ref")
    private String signatureDmsRef;

}
