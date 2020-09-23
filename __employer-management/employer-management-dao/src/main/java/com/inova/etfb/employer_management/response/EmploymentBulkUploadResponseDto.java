package com.inova.etfb.employer_management.response;

import java.util.List;
import com.inova.dao.entities.EmployerMemberAccountBulkItem;
import com.inova.response.dto.DocumentUploadedResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentBulkUploadResponseDto {
	List<EmployerMemberAccountBulkItem> employerMemberAccountBulkItems;
	DocumentUploadedResponseDto documentUploadedResponseDto;
}
