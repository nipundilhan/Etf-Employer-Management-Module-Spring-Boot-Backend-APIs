package com.inova.etfb.employer_management.wrapper;

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

@SqlResultSetMapping(name = "EmployerUpdateResolutionDirectorAddUpdateRespDtoMapping", entities = {
        @EntityResult(entityClass = EmployerUpdateResolutionDirectorAddUpdateRespDto.class, fields = {
        		@FieldResult(name = "serviceRequestEmployerUpdateId", column = "service_request_employer_update_id"),
                @FieldResult(name = "employerRequestDirectorAddId", column = "employer_request_director_add_id"),
                @FieldResult(name = "employerRequestDirectorUpdateId", column = "employer_request_director_update_id"),
                @FieldResult(name = "personExists", column = "person_exists"),
                @FieldResult(name = "personNotExists", column = "person_not_exists"),
                @FieldResult(name = "added", column = "added"),
                @FieldResult(name = "updated", column = "updated"),
        }),
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployerUpdateResolutionDirectorAddUpdateRespDto {

	@Id
	@JsonProperty("service_request_employer_update_id")
    private Long serviceRequestEmployerUpdateId;
	
	@JsonProperty("employer_request_director_add_id")
    private Long employerRequestDirectorAddId;

    @JsonProperty("employer_request_director_update_id")
    private Long employerRequestDirectorUpdateId;
    
    @JsonProperty("person_not_exists")
    private Boolean personNotExists;

    @JsonProperty("person_exists")
    private Boolean personExists;
    
    @JsonProperty("added")
    private Boolean added;

    @JsonProperty("updated")
    private Boolean updated;
}
