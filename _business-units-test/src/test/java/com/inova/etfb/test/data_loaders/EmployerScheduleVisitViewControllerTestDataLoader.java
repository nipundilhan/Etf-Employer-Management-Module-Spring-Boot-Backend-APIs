package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerScheduleVisit;
import com.inova.dao.entities.MstEmployerScheduleVisitStatus;
import com.inova.dao.repositories.EmployerRepository;
import com.inova.dao.repositories.EmployerScheduleVisitRepository;
import com.inova.dao.repositories.MstEmployerScheduleVisitStatusRepository;

@Component
public class EmployerScheduleVisitViewControllerTestDataLoader {
	@Autowired
	EmployerScheduleVisitRepository employerScheduleVisitRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	@Autowired
	EmployerRepository employerRepository;
	@Autowired
	MstEmployerScheduleVisitStatusRepository mstEmployerScheduleVisitStatusRepository;

	public EmployerScheduleVisit insertEmployerScheduleVisitWithCloseStatusRecord() {

		EmployerScheduleVisit employerScheduleVisit = new EmployerScheduleVisit();
		employerScheduleVisit.setRefNo(222L);
		employerScheduleVisit.setEmployerId(txnCommonDataLoader.insertEmployer());
		employerScheduleVisit.setTypeId(mstDataLoader.insertMstEmployerScheduleVisitType());
		employerScheduleVisit.setStatusId(this.getExistingMstEmployerScheduleVisitStatusClose());
		employerScheduleVisit.setStatusAt(new Date());
		employerScheduleVisit.setScheduledAt(new Date());
		employerScheduleVisit.setOwnerOrganizationId(txnCommonDataLoader.insertOrganization());
		employerScheduleVisit.setCreatedAt(new Date());
		employerScheduleVisit.setUpdatedAt(new Date());

		employerScheduleVisit = employerScheduleVisitRepository.save(employerScheduleVisit);
		return employerScheduleVisit;
	}



	private MstEmployerScheduleVisitStatus getExistingMstEmployerScheduleVisitStatusClose() {
		Optional<MstEmployerScheduleVisitStatus> optionalMstScheduleVisitStatus = this.mstEmployerScheduleVisitStatusRepository
				.findByCode("CLS");
		if (optionalMstScheduleVisitStatus.isPresent()) {
			return optionalMstScheduleVisitStatus.get();
		} else {
			return null;
		}
	}

}
