package com.inova.etfb.employer_management.wrapper;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerBulkUploadHistorySearchResult" , entities = {
		@EntityResult(entityClass = EmployerBulkUploadHistoryDataResponseDto.class , fields = {
				@FieldResult(name = "no", column = "no"),
				@FieldResult(name = "fileName" , column = "fileName"),
				@FieldResult(name = "createdDate" , column = "createdDate"),
				@FieldResult(name = "receivedDate" , column = "receivedDate"),
				@FieldResult(name = "uploadedAt" , column = "uploadedAt"),
				@FieldResult(name = "uploadedBy" , column = "uploadedBy"),
				@FieldResult(name = "status" , column = "status"),
				@FieldResult(name = "action" , column = "action")
		}),
})

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerBulkUploadHistoryDataResponseDto {

	@Id
	@JsonProperty("no")
	private Long no;
	
	@JsonProperty("file_name")
	private String fileName;
	
	@JsonProperty("created_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  createdDate;
	
	@JsonProperty("received_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  receivedDate;
	
	@JsonProperty("uploaded_at")
	private Date  uploadedAt;
	
	@JsonProperty("uploaded_by")
	private String  uploadedBy;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("action")
	private String  action;
}
