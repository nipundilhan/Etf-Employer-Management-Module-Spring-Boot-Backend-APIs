package com.inova.employer_management.service;


import java.util.List;

import com.inova.etfb.employer_management.request.ViewEmployerDirectorDetailsRequest;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsFinalResponseDto;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.ViewEmployerDirectorDetailsRespDto;
import com.inova.util.RecordReadable;
import com.inova.util.Searchable;

public interface ViewEmployerDirectorDetailsService extends RecordReadable<ViewEmployerDirectorDetailsResponseDto, Object>,
									Searchable<ViewEmployerDirectorDetailsRequest,ViewEmployerDirectorDetailsFinalResponseDto>{


}
