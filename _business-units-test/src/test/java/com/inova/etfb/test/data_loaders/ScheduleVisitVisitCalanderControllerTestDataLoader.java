package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerScheduleVisit;
import com.inova.dao.repositories.EmployerRepository;
import com.inova.dao.repositories.EmployerScheduleVisitRepository;

@Component
public class ScheduleVisitVisitCalanderControllerTestDataLoader {
	@Autowired
	EmployerScheduleVisitRepository employerScheduleVisitRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	@Autowired
	EmployerRepository employerRepository;
	
	public EmployerScheduleVisit insertEmployerScheduleVisit() {
		EmployerScheduleVisit employerScheduleVisit = getExistingEmployerScheduleVisit();
		
		if(employerScheduleVisit != null) {
			return employerScheduleVisit;
		}else {
			employerScheduleVisit = new EmployerScheduleVisit();
			employerScheduleVisit.setRefNo(123L);
			employerScheduleVisit.setEmployerId(txnCommonDataLoader.insertEmployer());
			employerScheduleVisit.setTypeId(mstDataLoader.insertMstEmployerScheduleVisitType());
			employerScheduleVisit.setStatusId(mstDataLoader.insertMstEmployerScheduleVisitStatus());
			employerScheduleVisit.setStatusAt(new Date());
			employerScheduleVisit.setScheduledAt(new Date());
			employerScheduleVisit.setOwnerOrganizationId(txnCommonDataLoader.insertOrganization());
			employerScheduleVisit.setCreatedAt(new Date());
			employerScheduleVisit.setUpdatedAt(new Date());
		
			return employerScheduleVisitRepository.save(employerScheduleVisit);
		}
	}
	
	private EmployerScheduleVisit getExistingEmployerScheduleVisit() {
		List<EmployerScheduleVisit> employerScheduleVisit = employerScheduleVisitRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!employerScheduleVisit.isEmpty()) {
			return employerScheduleVisit.get(0);
		} else {
			return null;
		}
	}
	
	public Employer getScheduleVisitRelatedEmployer(Long id) {
		Optional<Employer> employer = employerRepository.findById(id);
		if(employer.isPresent()) {
			return employer.get();
		} else {
			return null;
		}
	}
}
