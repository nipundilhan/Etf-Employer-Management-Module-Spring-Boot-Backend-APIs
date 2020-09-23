package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "EmployerUpdateResolutionDirectorMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionDirectorRespDto.class, fields = {
                @FieldResult(name = "rowNumber", column = "rowNumber"),
                @FieldResult(name = "employerRequestDirectorAddId", column = "employer_request_director_add_id"),
                @FieldResult(name = "employerRequestDirectorUpdateId", column = "employer_request_director_update_id"),
                @FieldResult(name = "updateType", column = "update_type"),
                @FieldResult(name = "personRefNo", column = "person_ref_no"),
                @FieldResult(name = "personNotExists", column = "person_not_exists"),
                @FieldResult(name = "personExists", column = "person_exists"),
                @FieldResult(name = "personId", column = "person_id"),
                @FieldResult(name = "personGeneralId", column = "person_general_id"),
                @FieldResult(name = "serviceRequestId", column = "service_request_id"),
                @FieldResult(name = "fullName", column = "full_name"),
                @FieldResult(name = "firstName", column = "first_name"),
                @FieldResult(name = "lastName", column = "last_name"),
                @FieldResult(name = "designation", column = "designation"),
                @FieldResult(name = "dateJoined", column = "date_joined"),
                @FieldResult(name = "dateTerminated", column = "date_terminated"),
                @FieldResult(name = "title", column = "title"),
                @FieldResult(name = "nicType", column = "nic_type"),
                @FieldResult(name = "nicTypeCode", column = "nic_type_code"),
                @FieldResult(name = "nicTypeDescription", column = "nic_type_description"),
                @FieldResult(name = "nicNo", column = "nic_no"),
                @FieldResult(name = "passportNo", column = "passport_no"),
                @FieldResult(name = "active", column = "active"),
                @FieldResult(name = "verificationStatus", column = "verification_status"),
                @FieldResult(name = "verificationStatusCode", column = "verification_status_code"),

                @FieldResult(name = "added", column = "added"),
                @FieldResult(name = "updated", column = "updated"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionDirectorRespDto {
    @Id
    private Long rowNumber;
    private Long employerRequestDirectorAddId;
    private Long employerRequestDirectorUpdateId;
    private Integer updateType;
    private Long personRefNo;
    private Long personGeneralId;
    private Long serviceRequestId;
    private Boolean personExists;
    private Boolean personNotExists;
    private Long personId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String designation;
    private Date dateJoined;
    private Date dateTerminated;
    private String title;
    private String nicType;
    private String nicTypeCode;
    private String nicTypeDescription;
    private String nicNo;
    private String passportNo;
    private Boolean active;
    private String verificationStatus;
    private String verificationStatusCode;
    private Boolean added;
    private Boolean updated;
}
