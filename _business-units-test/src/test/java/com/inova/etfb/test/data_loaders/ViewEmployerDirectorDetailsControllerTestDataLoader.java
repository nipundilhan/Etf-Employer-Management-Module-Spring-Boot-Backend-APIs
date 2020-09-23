package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerDirector;
import com.inova.dao.entities.EmployerDirectorHistory;
import com.inova.dao.entities.EmployerInterimDirector;
import com.inova.dao.entities.MstEmployerInterimReferenceTable;
import com.inova.dao.repositories.EmployerDirectorHistoryRepository;
import com.inova.dao.repositories.EmployerInterimDirectorRepository;

@Component
public class ViewEmployerDirectorDetailsControllerTestDataLoader {
	@Autowired
	EmployerDirectorHistoryRepository employerDirectorHistoryRepository;
	@Autowired
	EmployerInterimDirectorRepository employerInterimDirectorRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;

	public EmployerDirectorHistory insertEmployerDirectorHistory() {
		EmployerDirectorHistory employerDirectorHistory = getExistingEmployerDirectorHistory();
		if (employerDirectorHistory != null) {
			return employerDirectorHistory;
		} else {
			employerDirectorHistory = new EmployerDirectorHistory();
			EmployerDirector employerDirector = txnCommonDataLoader.insertEmployerDirector();
			employerDirectorHistory.setEmployerDirectorId(employerDirector);
			employerDirectorHistory.setEmployerInterimDirectorId(insertEmployerInterimDirector());
			employerDirectorHistory.setCreatedAt(new Date());
			return employerDirectorHistoryRepository.save(employerDirectorHistory);
		}
	}

	private EmployerDirectorHistory getExistingEmployerDirectorHistory() {
		List<EmployerDirectorHistory> persons = employerDirectorHistoryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}

	public EmployerInterimDirector insertEmployerInterimDirector() {
		EmployerInterimDirector employerInterimDirector = getExistingEmployerInterimDirector();
		if (employerInterimDirector != null) {
			return employerInterimDirector;
		} else {
			employerInterimDirector = new EmployerInterimDirector();
			employerInterimDirector.setCreatedAt(new Date());
			MstEmployerInterimReferenceTable referenceTable = new MstEmployerInterimReferenceTable();
			referenceTable.setId(1l);
			employerInterimDirector.setReferenceTableId(referenceTable);
			return employerInterimDirectorRepository.save(employerInterimDirector);
		}
	}

	private EmployerInterimDirector getExistingEmployerInterimDirector() {
		List<EmployerInterimDirector> employerInterimDirectors = employerInterimDirectorRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!employerInterimDirectors.isEmpty()) {
			return employerInterimDirectors.get(0);
		} else {
			return null;
		}
	}
}
