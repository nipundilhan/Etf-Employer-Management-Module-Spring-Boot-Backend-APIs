package com.inova.etfb.employer_management.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class EmployerUpdateResolutionDirectorResponseDto {
    @JsonProperty("person_ref_no")
    private Long personRefNo;

    @JsonProperty("employer_request_director_add_id")
    private Long employerRequestDirectorAddId;

    @JsonProperty("employer_request_director_update_id")
    private Long employerRequestDirectorUpdateId;

    @JsonProperty("update_type")
    private Integer updateType;

    @JsonProperty("person_general_id")
    private Long personGeneralId;

    @JsonProperty("service_request_id")
    private Long serviceRequestId;

    @JsonProperty("person_not_exists")
    private Boolean personNotExists;

    @JsonProperty("person_exists")
    private Boolean personExists;

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("designation")
    private String designation;

    @JsonFormat(timezone = "Asia/Colombo")
    @JsonProperty("date_joined")
    private Date dateJoined;

    @JsonFormat(timezone = "Asia/Colombo")
    @JsonProperty("date_terminated")
    private Date dateTerminated;

    @JsonProperty("title")
    private String title;

    @JsonProperty("nic_type")
    private String nicType;

    @JsonProperty("nic_type_code")
    private String nicTypeCode;

    @JsonProperty("nic_type_description")
    private String nicTypeDescription;

    @JsonProperty("nic_no")
    private String nicNo;

    @JsonProperty("passport_no")
    private String passportNo;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("verification_status")
    private String verificationStatus;

    @JsonProperty("verification_status_code")
    private String verificationStatusCode;

    @JsonProperty("added")
    private Boolean added;

    @JsonProperty("updated")
    private Boolean updated;
}
