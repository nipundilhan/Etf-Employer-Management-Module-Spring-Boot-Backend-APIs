package com.inova.etfb.employer_management.param;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import com.inova.etfb.employer_management.wrapper.EmployerPayOrderTotalDataResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerTotalDataResponseDto;


@SqlResultSetMappings({
	
		@SqlResultSetMapping(name = "EmployerPayOrderTotalDataResponseDtoMapping", 
		       classes = @ConstructorResult(targetClass = EmployerPayOrderTotalDataResponseDto.class, columns = {
				@ColumnResult(name = "totalPayOrderInstallmentAmount", type = Double.class),
				@ColumnResult(name = "totalPayOrderBalanceAmount", type = Double.class), 
				@ColumnResult(name = "totalPayOrderPaidAmount", type = Double.class) 
				    })
		    ),

//Add additional mappings following above mapping as needed.
		
		@SqlResultSetMapping(name = "EmployerTotalDataResponseDtoMapping", 
	       classes = @ConstructorResult(targetClass = EmployerTotalDataResponseDto.class, columns = {
			@ColumnResult(name = "totalInstallmentAmount", type = Double.class),
			@ColumnResult(name = "totalBalanceAmount", type = Double.class)
			    })
	    ),
	
})
@Entity
public class SQLMappings {

	@Id
	private Long dummyId;

}
