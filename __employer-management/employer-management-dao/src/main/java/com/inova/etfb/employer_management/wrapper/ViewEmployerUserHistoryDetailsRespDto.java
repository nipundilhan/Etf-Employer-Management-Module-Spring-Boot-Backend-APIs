package com.inova.etfb.employer_management.wrapper;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerUserHistoryInfoResponseMapping" , entities = {
		@EntityResult(entityClass = ViewEmployerUserHistoryDetailsRespDto.class , fields = {
				@FieldResult(name = "id", column = "id"),
				@FieldResult(name = "updatedTime", column = "updateAt"),
				@FieldResult(name = "updatedBy", column = "updateBy"),
			    @FieldResult(name = "updatedEtfbBranch" , column = "updatedEtfbBranch"),
				@FieldResult(name = "dmuInboundRefno" , column = "dmuRefNo"),
				@FieldResult(name = "serviceCounterRefno" , column = "serviceCounterRefNo"),
				@FieldResult(name = "serviceRequestRefno" , column = "serviceRequestRefNo")
				
		}),
})


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class ViewEmployerUserHistoryDetailsRespDto {

	@Id
	@JsonProperty("id")
	private Long id;
	@JsonProperty("updated_at")
	private Date updatedTime;
	@JsonProperty("updated_by")
	private String updatedBy;
	@JsonProperty("updated_etfb_branch")
	private String updatedEtfbBranch;
	@JsonProperty("dmu_inbound_refno")
	private Long dmuInboundRefno;
	@JsonProperty("service_counter_refno")
	private Long serviceCounterRefno;
	@JsonProperty("service_request_refno")
	private Long serviceRequestRefno;

}

