package com.inova.etfb.employer_management.response.build;

import com.inova.etfb.employer_management.response.EmployerDirectorContactResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorContactDetailsResDto;
import com.inova.util.SingleResponseDtoBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployerDirectorContactResponseDTOBuilder implements SingleResponseDtoBuilder<EmployerDirectorContactDetailsResDto, EmployerDirectorContactResponseDto> {

    @Override
    public EmployerDirectorContactResponseDto buildCreateResponseDto(EmployerDirectorContactDetailsResDto res) {
        return EmployerDirectorContactResponseDto.builder()
                .active(res.getActive())
                .contactEmail(res.getContactEmail())
                .contactInfoId(res.getContactInfoId())
                .contactSms(res.getContactSms())
                .contactType(res.getContactType())
                .contactTypeCode(res.getContactTypeCode())
                .contactTypeId(res.getContactTypeId())
                .contactTypeSin(res.getContactTypeSin())
                .contactTypeTam(res.getContactTypeTam())
                .contactValue(res.getContactValue())
                .incorrectContact(res.getIncorrectContact())
                .note(res.getNote())
                .personContactId(res.getPersonContactId())
                .personContactReferenceId(res.getPersonContactReferenceId())
                .publicNote(res.getPublicNote())
                .createdAt(res.getCreatedAt())
				.build();
    }


}
