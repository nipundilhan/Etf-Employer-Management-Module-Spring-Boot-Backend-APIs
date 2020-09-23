package com.inova.employer_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.employer_management.service.ViewEmployerDirectorDetailsService;
import com.inova.etfb.employer_management.dao.ViewEmployerDirectorDetailsDao;
import com.inova.etfb.employer_management.request.ViewEmployerDirectorDetailsRequest;
import com.inova.etfb.employer_management.response.EmployerDirectorInformationResponseDto;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsFinalResponseDto;
import com.inova.etfb.employer_management.response.ViewEmployerDirectorDetailsResponseDto;
import com.inova.etfb.employer_management.wrapper.EmployerAddressRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerContactRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorCurrentHistoryDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorInformationRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorMemberDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorPersonalDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorSignatureRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateEndDateRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateHistoryDetailsRespDto;
import com.inova.etfb.employer_management.wrapper.EmployerDirectorUpdateStartDateRespDto;

import com.inova.etfb.employer_management.wrapper.ViewEmployerDirectorDetailsRespDto;

import com.inova.exception.ApplicationException;

@Service
public class ViewEmployerDirectorDetailsServiceImpl implements ViewEmployerDirectorDetailsService{


	@Autowired
	private ViewEmployerDirectorDetailsDao viewEmployerDirectorDetailsDao;
	
	@Override
	@MethodLogging
	public ViewEmployerDirectorDetailsFinalResponseDto search(ViewEmployerDirectorDetailsRequest req) throws ApplicationException {
		
		List<EmployerAddressRespDto> directorAddressDetailsList = viewEmployerDirectorDetailsDao.getDirectorAddressDetails(req);
		List<EmployerContactRespDto> directorContactsDetailsList = viewEmployerDirectorDetailsDao.getDirectorContactssDetails(req);
		EmployerDirectorPersonalDetailsRespDto directorPersonalDetails = viewEmployerDirectorDetailsDao.getDirectorPersonalDetails(req);
		EmployerDirectorUpdateEndDateRespDto directorUpdateEndDate = viewEmployerDirectorDetailsDao.getDirectorUpdateEndDate(req);
		EmployerDirectorUpdateStartDateRespDto directorUpdateStartDate = viewEmployerDirectorDetailsDao.getDirectorUpdateStartDate(req);
		List<EmployerDirectorSignatureRespDto> employerDirectorSignaturesDetails = viewEmployerDirectorDetailsDao.getEmployerDirectorSignaturesDetails(req);
		EmployerDirectorInformationResponseDto EmployerDirectorInformationResponse = new EmployerDirectorInformationResponseDto();
		EmployerDirectorCurrentHistoryDateRespDto directorDetailsCurrentHistory = null;
		EmployerDirectorUpdateHistoryDetailsRespDto employerDirecotorUpdateHistoryDetails =  null;
		EmployerDirectorInformationRespDto directorInformationDetails = null;
		
		EmployerDirectorMemberDetailsRespDto checkDirectorIsMember = viewEmployerDirectorDetailsDao.checkDirectorIsMember( req);
		
		if(req.getHistory()){
					
			directorDetailsCurrentHistory = viewEmployerDirectorDetailsDao.getDirectorDetailsHistory(req);
			
			if(directorDetailsCurrentHistory != null){
				req.setEmployerDirectorHistoryId(directorDetailsCurrentHistory.getHistoryId());
				directorInformationDetails = viewEmployerDirectorDetailsDao.getDirectorInformationDetails(req);		
				employerDirecotorUpdateHistoryDetails = viewEmployerDirectorDetailsDao.getEmployerDirecotorUpdateHistoryDetails(req);				
				EmployerDirectorInformationResponse.setEmployerDirectorInformationRespDto(directorInformationDetails);
			}else {			
				return null;			
			}			
		}else{
			directorInformationDetails = viewEmployerDirectorDetailsDao.getDirectorInformationDetails(req);		
			employerDirecotorUpdateHistoryDetails = new EmployerDirectorUpdateHistoryDetailsRespDto();
			EmployerDirectorInformationResponse.setEmployerDirectorInformationRespDto(directorInformationDetails);					
		}
		
		if(checkDirectorIsMember != null && directorInformationDetails != null) {
			EmployerDirectorInformationResponse.setMemberOfSameCompany(checkDirectorIsMember.getMemberOfSameCompany());
			EmployerDirectorInformationResponse.setMemberNumber(checkDirectorIsMember.getMemberNo());
		}
		
		
		
		
		return ViewEmployerDirectorDetailsFinalResponseDto.builder()
		.employerDirectorPersonalDetails(directorPersonalDetails)
		.EmployerDirectorUpdateHistoryDetails(employerDirecotorUpdateHistoryDetails)
		.EmployerDirectorUpdateStartDateDetails(directorUpdateStartDate)
		.EmployerDirectorUpdateEndDateDetails(directorUpdateEndDate)
		.EmployerDirectorCurrentHistoryDateDetails(directorDetailsCurrentHistory)
		.employerDirectorInformations(EmployerDirectorInformationResponse)
		.employerDirectorSignaturesDetails(employerDirectorSignaturesDetails)
		.directorAddressDetails(directorAddressDetailsList)
		.directorContactsDetails(directorContactsDetailsList)
		.build();
	}
		

	@Override
	public ViewEmployerDirectorDetailsResponseDto readById(Long id) throws ApplicationException {
		List<ViewEmployerDirectorDetailsRespDto> response = viewEmployerDirectorDetailsDao.getDirectorDetails(id);
		ViewEmployerDirectorDetailsResponseDto viewEmployerDirectorDetailsResponseDto = new ViewEmployerDirectorDetailsResponseDto();
		viewEmployerDirectorDetailsResponseDto.setViewEmployerDirectorODetails(response);
		String directorType = viewEmployerDirectorDetailsDao.getDirectorType(id);
		if(directorType != null) {
			viewEmployerDirectorDetailsResponseDto.setDirectorType(directorType);
		}else {
			return null;
		}	
		return viewEmployerDirectorDetailsResponseDto;
	}

	@Override
	public Object readAll(Integer pageNumber, Integer pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;

	}

}
