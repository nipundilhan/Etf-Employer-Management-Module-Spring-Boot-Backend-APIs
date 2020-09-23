package com.inova.etfb.employer_management.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@SqlResultSetMapping(name = "EmployerUpdateResolutionBranchMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionBranchRespDto.class, fields = {
                @FieldResult(name = "rowNumber", column = "rowNumber"),
                @FieldResult(name = "employerBranchAddId", column = "employer_request_branch_add_id"),
                @FieldResult(name = "employerBranchUpdateId", column = "employer_request_branch_update_id"),
                @FieldResult(name = "employerBranchId", column = "employer_branch_id"),
                @FieldResult(name = "branchName", column = "branch_name"),
                @FieldResult(name = "address1", column = "address1"),
                @FieldResult(name = "address2", column = "address2"),
                @FieldResult(name = "address3", column = "address3"),
                @FieldResult(name = "address4", column = "address4"),
                @FieldResult(name = "city", column = "city"),
                @FieldResult(name = "employerOwnBranch", column = "employer_own_organization"),
                @FieldResult(name = "headOffice", column = "head_office"),
                @FieldResult(name = "brnAddress", column = "brn_address"),
                @FieldResult(name = "mailAddress", column = "mail_address"),
                @FieldResult(name = "status", column = "status"),
                @FieldResult(name = "added", column = "added"),
                @FieldResult(name = "updated", column = "updated"),
                @FieldResult(name = "createdAt", column = "created_at"),
        }),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateResolutionBranchRespDto {
    @Id
    private Long rowNumber;
    private Long employerBranchAddId;
    private Long employerBranchUpdateId;
    private Long employerBranchId;
    private String branchName;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private Boolean employerOwnBranch;
    private Boolean headOffice;
    private Boolean brnAddress;
    private Boolean mailAddress;
    private String status;
    private Boolean added;
    private Boolean updated;
    private Date createdAt;
}
