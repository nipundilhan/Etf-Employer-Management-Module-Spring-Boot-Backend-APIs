package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerInterim;
import com.inova.dao.entities.EmployerVerificationRequest;
import com.inova.dao.entities.MstEmployerIndustryType;
import com.inova.dao.entities.MstEmployerInterimReferenceTable;
import com.inova.dao.entities.MstEmployerNatureBusiness;
import com.inova.dao.entities.MstEmployerOrganizationType;
import com.inova.dao.entities.MstEmployerStatus;
import com.inova.dao.entities.MstEmployerType;
import com.inova.dao.entities.MstEmployerVerificationRequestSourceType;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstUserCategory;
import com.inova.dao.entities.MstVerificationRequestStatus;
import com.inova.dao.entities.MstVerificationStatus;
import com.inova.dao.entities.User;
import com.inova.dao.repositories.EmployerInterimRepository;
import com.inova.dao.repositories.EmployerVerificationRequestRepository;
import com.inova.dao.repositories.MstEmployerVerificationRequestSourceTypeRepository;
import com.inova.dao.repositories.UserRepository;

@Component
public class PendingEmployerVerificationSearchControllerTestDataLoader {
	@Autowired
	EmployerVerificationRequestRepository employerVerificationRequestRepository;
	@Autowired
	EmployerInterimRepository employerInterimRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	MstDataLoader mstDataLoader;
	@Autowired
	MstEmployerVerificationRequestSourceTypeRepository mstEmployerVerificationRequestSourceTypeRepository;
	MstEmployerVerificationRequestSourceType mstEmployerVerificationRequestSourceType;

	public EmployerVerificationRequest insertEmployerVerificationRequest() {

		EmployerVerificationRequest empVerifRequest = getExistingEmployerVerificationRequest();

		if (empVerifRequest != null) {
			return empVerifRequest;
		} else {
			empVerifRequest = new EmployerVerificationRequest();
			empVerifRequest.setRefNo(1l);

			MstEmployerVerificationRequestSourceType sourceType = new MstEmployerVerificationRequestSourceType();
			sourceType.setId(1l);
			empVerifRequest.setRequestSourceTypeId(sourceType);

			EmployerInterim employerInterimSaved = insertEmployerInterim();
			empVerifRequest.setEmployerInterimId(employerInterimSaved);

			MstVerificationRequestStatus reqStatus = new MstVerificationRequestStatus();
			reqStatus.setId(1l);
			empVerifRequest.setStatusId(reqStatus);
			empVerifRequest.setCreatedAt(new Date());

			MstVerificationStatus vStatus = new MstVerificationStatus();
			vStatus.setId(1l);
			empVerifRequest.setVerificationStatusId(vStatus);

			MstPriority priority = new MstPriority();
			priority.setId(1l);
			empVerifRequest.setPriorityId(priority);

			return employerVerificationRequestRepository.save(empVerifRequest);
		}
	}

	public EmployerInterim insertEmployerInterim() {
		MstEmployerNatureBusiness natureBusinessSaved = mstDataLoader.insertMstEmployerNatureBusiness();
		MstEmployerOrganizationType organizationType = new MstEmployerOrganizationType();
		organizationType.setId(1l);

		MstEmployerIndustryType industryTypeSaved = mstDataLoader.insertMstEmployerIndustryType(1);
		MstEmployerInterimReferenceTable referenceTable = new MstEmployerInterimReferenceTable();
		referenceTable.setId(1l);
		MstEmployerType empType = new MstEmployerType();
		empType.setId(1l);

		MstEmployerStatus empStatus = new MstEmployerStatus();
		empStatus.setId(1l);
		EmployerInterim ei = new EmployerInterim();
		ei.setName("test employer interim name");
		ei.setNatureOfBusinessId(natureBusinessSaved);
		ei.setEmployerOrganizationTypeId(organizationType);
		ei.setIndustryTypeId(industryTypeSaved);
		ei.setReferenceTableId(referenceTable);
		ei.setCreatedAt(new Date());
		ei.setUpdatedAt(new Date());
		ei.setEmployerTypeId(empType);
		ei.setEmployerStatusId(empStatus);
		return employerInterimRepository.save(ei);
	}

	private EmployerVerificationRequest getExistingEmployerVerificationRequest() {
		List<EmployerVerificationRequest> employerVerificationRequestList = employerVerificationRequestRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!employerVerificationRequestList.isEmpty()) {
			return employerVerificationRequestList.get(0);
		} else {
			return null;
		}
	}

	public User insertUser() {
		String username = "testUser";
		User user = getExistingUser(username);
		if (user != null) {
			return user;
		} else {
			MstUserCategory cat = new MstUserCategory();
			cat.setId(1l);
			user = new User();
			user.setUsername(username);
			user.setCategoryId(cat);
			user.setPassword(username);
			user.setCreatedAt(new Date());
			return userRepository.save(user);
		}
	}

	private User getExistingUser(String username) {
		Optional<User> reason = userRepository.findByUsername(username);
		if(reason.isPresent()) {
			return reason.get();
		} else {
			return null;
		}
	}
}
