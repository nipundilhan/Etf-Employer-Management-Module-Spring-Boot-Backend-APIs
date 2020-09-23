package com.inova.etfb.employer_management.response.build;

import org.springframework.stereotype.Component;

import com.inova.etfb.employer_management.param.EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO;
import com.inova.etfb.employer_management.response.EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto;
import com.inova.util.ListResponseDtoBuilder;

@Component
public class EmployerDirectorDetailsResponseDTOBuilder implements ListResponseDtoBuilder<EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO, EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto> {

	@Override
	public EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto buildListResponseDto(
			EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO listResult) {
		// TODO Auto-generated method stub
		return null;
	}

//    ModelMapper modelMapper;
//
//    @PostConstruct
//    public void init() {
//        modelMapper = new ModelMapper();
//    }
//
//    @Override
//    public EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto buildListResponseDto(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO employerUpdateResolutionBranchRespDTO) {
//        modelMapper.typeMap(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO.class, EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto.class)
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getExistingEmployerDirectorDetailsResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setExistingEmployerDirectorDetailsResponseDto);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getFoundPersonDetailsResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setFoundPersonDetailsResponseDto);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getNotFoundPersonDetailsResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setNotFoundPersonDetailsResponseDto);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getUpdatedDirectorDetailsResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setUpdatedDirectorDetailsResponseDto);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getUpdatedAddressListResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setUpdatedAddressResponseDtoList);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getExistingPersonAddressListResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setExistingPersonAddressResponseDtoList);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getExistingPersonContactListResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setExistingPersonContactResponseDtoList);
//                })
//                .addMappings(mapping -> {
//                    mapping.map(EmployerUpdateResolutionUpdatedDirectorDetailsParamDTO::getUpdatedContactListResp,
//                            EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto::setUpdatedContactResponseDtoList);
//                })
//        ;
//        EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto response = modelMapper.map(employerUpdateResolutionBranchRespDTO, EmployerDirectorUpdateResolutionUpdatedDirectorDetailsResponseDto.class);
//        response.getExistingEmployerDirectorDetailsResponseDto().setGender(response.getExistingEmployerDirectorDetailsResponseDto().getGender().equals("M") ? "Male": "Female");
//        response.getExistingEmployerDirectorDetailsResponseDto().setGender(response.getExistingEmployerDirectorDetailsResponseDto().getGender().equals("U") ? "Unknown": "Male");
//        return response;
//    }
}
