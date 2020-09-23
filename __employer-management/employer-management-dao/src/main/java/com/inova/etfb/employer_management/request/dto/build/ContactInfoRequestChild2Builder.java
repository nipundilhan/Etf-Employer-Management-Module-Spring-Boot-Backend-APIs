package com.inova.etfb.employer_management.request.dto.build;

import org.springframework.stereotype.Component;

import com.inova.request.ContactInfoRequestChild2;
import com.inova.request.ContactInfoRequestChild6;
import com.inova.util.CreateRequestDtoBuilder;

@Component
public class ContactInfoRequestChild2Builder  implements 
CreateRequestDtoBuilder<ContactInfoRequestChild6, ContactInfoRequestChild2>{

	@Override
	public ContactInfoRequestChild2 buildCreateDto(ContactInfoRequestChild6 request, Long id) {
		return ContactInfoRequestChild2.builder()
				.code(request.getCode())
				.value(request.getValue())
				.note(request.getNote())
				.incorrectContact(request.isIncorrectContact())
				.note(request.getNote())
				.build();
	}

}
