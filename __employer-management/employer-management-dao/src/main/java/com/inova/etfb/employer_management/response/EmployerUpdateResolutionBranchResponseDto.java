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
public class EmployerUpdateResolutionBranchResponseDto {
    @JsonProperty("employer_branch_add_id")
    private Long employerBranchAddId;
    @JsonProperty("employer_branch_updated_id")
    private Long employerBranchUpdateId;
    @JsonProperty("employer_branch_id")
    private Long employerBranchId;
    @JsonProperty("branch_name")
    private String branchName;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("address3")
    private String address3;
    @JsonProperty("address4")
    private String address4;
    @JsonProperty("city")
    private String city;
    @JsonProperty("employer_own_branch")
    private Boolean employerOwnBranch;
    @JsonProperty("head_office")
    private Boolean headOffice;
    @JsonProperty("brn_address")
    private Boolean brnAddress;
    @JsonProperty("mail_address")
    private Boolean mailAddress;
    @JsonProperty("status")
    private String status;
    @JsonProperty("added")
    private Boolean added;
    @JsonProperty("updated")
    private Boolean updated;
    @JsonProperty("created_at")
    private Date createdAt;
}
