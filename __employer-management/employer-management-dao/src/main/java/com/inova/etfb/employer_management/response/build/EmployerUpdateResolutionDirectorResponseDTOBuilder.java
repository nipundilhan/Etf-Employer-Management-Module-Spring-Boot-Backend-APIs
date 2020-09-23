package com.inova.etfb.employer_management.response.build;

import com.inova.etfb.employer_management.response.EmployerUpdateResolutionDirectorResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionDirectorRespDto;
import com.inova.util.ListResponseDtoBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployerUpdateResolutionDirectorResponseDTOBuilder implements ListResponseDtoBuilder<EmployerUpdateResolutionDirectorRespDto, EmployerUpdateResolutionDirectorResponseDto> {

    ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper = new ModelMapper();
    }

    @Override
    public EmployerUpdateResolutionDirectorResponseDto buildListResponseDto(EmployerUpdateResolutionDirectorRespDto employerUpdateResolutionDirectorRespDTO) {
        return modelMapper.map(employerUpdateResolutionDirectorRespDTO, EmployerUpdateResolutionDirectorResponseDto.class);
    }
}
