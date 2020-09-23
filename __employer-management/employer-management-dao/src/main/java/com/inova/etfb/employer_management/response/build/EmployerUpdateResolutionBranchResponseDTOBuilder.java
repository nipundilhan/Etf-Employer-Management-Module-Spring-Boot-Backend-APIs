package com.inova.etfb.employer_management.response.build;

import com.inova.etfb.employer_management.response.EmployerUpdateResolutionBranchResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerUpdateResolutionBranchRespDto;
import com.inova.util.ListResponseDtoBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployerUpdateResolutionBranchResponseDTOBuilder implements ListResponseDtoBuilder<EmployerUpdateResolutionBranchRespDto, EmployerUpdateResolutionBranchResponseDto> {

    ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper = new ModelMapper();
    }

    @Override
    public EmployerUpdateResolutionBranchResponseDto buildListResponseDto(EmployerUpdateResolutionBranchRespDto employerUpdateResolutionBranchRespDTO) {
        return modelMapper.map(employerUpdateResolutionBranchRespDTO, EmployerUpdateResolutionBranchResponseDto.class);
    }
}
