package com.inova.etfb.employer_management.response.build;

import com.inova.etfb.employer_management.param.EmployerUpdateResolutionUpdatedBranchDetailsParamDTO;
import com.inova.etfb.employer_management.response.EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto;
import com.inova.util.SingleResponseDtoBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployerBranchDetailsResponseDTOBuilder implements SingleResponseDtoBuilder<Object, EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto> {

    ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper = new ModelMapper();
    }

    @Override
    public EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto buildCreateResponseDto(Object employerUpdateResolutionBranchRespDTO) {

        modelMapper.typeMap(EmployerUpdateResolutionUpdatedBranchDetailsParamDTO.class, EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto.class)
                .addMappings(mapping -> {
                    mapping.map(EmployerUpdateResolutionUpdatedBranchDetailsParamDTO::getExistingEmployerBranchDetailsResDTO,
                            EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto::setExistingEmployerBranchDetailsResponseDTO);
                })
                .addMappings(mapping -> {
                    mapping.map(EmployerUpdateResolutionUpdatedBranchDetailsParamDTO::getExistingBranchContactDetailsResDTOList,
                            EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto::setExistingEmployerBranchContactDetailsResponseDTOList);
                })
                .addMappings(mapping -> {
                    mapping.map(EmployerUpdateResolutionUpdatedBranchDetailsParamDTO::getUpdatedBranchDetailsRespDTO,
                            EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto::setUpdatedBranchDetailsResponseDTO);
                })
                .addMappings(mapping -> {
                    mapping.map(EmployerUpdateResolutionUpdatedBranchDetailsParamDTO::getUpdatedBranchContactRespDTOList,
                            EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto::setUpdatedBranchContactResponseDTO);
                })
                .addMappings(mapping -> {
                    mapping.map(EmployerUpdateResolutionUpdatedBranchDetailsParamDTO::getAddedBranchDetailsRespDTO,
                            EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto::setAddedDetailsResponseDTO);
                })
        ;
        return modelMapper.map(employerUpdateResolutionBranchRespDTO, EmployerBranchUpdateResolutionUpdatedBranchDetailsResponseDto.class);
    }
}
