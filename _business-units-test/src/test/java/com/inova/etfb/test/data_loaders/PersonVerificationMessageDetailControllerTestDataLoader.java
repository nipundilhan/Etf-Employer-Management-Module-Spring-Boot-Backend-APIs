package com.inova.etfb.test.data_loaders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerDirector;
import com.inova.dao.entities.Member1;
import com.inova.dao.entities.MemberAccount;
import com.inova.dao.entities.MemberAccountNominee;
import com.inova.dao.entities.MemberPersonVerificationRequest;
import com.inova.dao.entities.MemberPersonVerificationRequestMessage;
import com.inova.dao.entities.MessageDelivered;
import com.inova.dao.entities.MstCurrency;
import com.inova.dao.entities.MstIdentityNicType;
import com.inova.dao.entities.MstMemberAccountStatus;
import com.inova.dao.entities.MstMemberAccountType;
import com.inova.dao.entities.MstMemberCreatedSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestType;
import com.inova.dao.entities.MstMessageContactType;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstPersonStatus;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstSelfEmploymentCategory;
import com.inova.dao.entities.MstSelfEmploymentCategoryNature;
import com.inova.dao.entities.MstSelfEmploymentPreRegistrationStatus;
import com.inova.dao.entities.MstSelfEmploymentRegistrationSource;
import com.inova.dao.entities.MstVerificationRequestStatus;
import com.inova.dao.entities.MstVerificationStatus;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonGeneralNic;
import com.inova.dao.entities.PersonGeneralPassport;
import com.inova.dao.entities.SelfEmploymentInterim;
import com.inova.dao.entities.SelfEmploymentPreRegistration;
import com.inova.dao.repositories.EmployerDirectorRepository;
import com.inova.dao.repositories.Member1Repository;
import com.inova.dao.repositories.MemberAccountNomineeRepository;
import com.inova.dao.repositories.MemberAccountRepository;
import com.inova.dao.repositories.MemberPersonVerificationRequestMessageRepository;
import com.inova.dao.repositories.MemberPersonVerificationRequestRepository;
import com.inova.dao.repositories.MessageDeliveredRepository;
import com.inova.dao.repositories.PersonGeneralNicRepository;
import com.inova.dao.repositories.PersonGeneralPassportRepository;
import com.inova.dao.repositories.PersonGeneralRepository;
import com.inova.dao.repositories.PersonRepository;
import com.inova.dao.repositories.SelfEmploymentInterimRepository;
import com.inova.dao.repositories.SelfEmploymentPreRegistrationRepository;

@Component
public class PersonVerificationMessageDetailControllerTestDataLoader {

	@Autowired
	MessageDeliveredRepository messageDeliveredRepository;
	@Autowired
	MemberPersonVerificationRequestRepository memberPersonVerificationRequestRepository;
	@Autowired
	PersonGeneralRepository personGeneralRepository;
	@Autowired
	MemberPersonVerificationRequestMessageRepository memberPersonVerificationRequestMessageRepository;
	
	@Autowired
	MstDataLoader mstDataLoader;

	public MessageDelivered insertMessageDelivered() {
		MessageDelivered messageDelivered = new MessageDelivered();
		messageDelivered.setContactTypeId(new MstMessageContactType(1L));
		messageDelivered.setDeliveredAt(new Date());
		messageDelivered.setCreatedAt(new Date());

		return messageDeliveredRepository.save(messageDelivered);
	}

	
	public MemberPersonVerificationRequestMessage insertMemberPersonVerificationRequestMessage() {
		MemberPersonVerificationRequestMessage memberPersonVerificationRequestMessage = new MemberPersonVerificationRequestMessage();
		memberPersonVerificationRequestMessage.setMemberPersonVerificationRequestId(insertMemberPersonVerificationRequest());
		memberPersonVerificationRequestMessage.setMessageId(insertMessageDelivered());
		memberPersonVerificationRequestMessage.setCreatedAt(new Date());

		return memberPersonVerificationRequestMessageRepository.save(memberPersonVerificationRequestMessage);
	}
	

	// member_person_verification_request
	public MemberPersonVerificationRequest insertMemberPersonVerificationRequest() {
		MemberPersonVerificationRequest memberPersonVerificationRequest = getExistingMemberPersonVerificationRequest();
		if (memberPersonVerificationRequest != null) {
			return memberPersonVerificationRequest;
		}
		memberPersonVerificationRequest = new MemberPersonVerificationRequest();
		memberPersonVerificationRequest.setRefNo(1234);
		memberPersonVerificationRequest.setPriorityId(new MstPriority(1l));
		memberPersonVerificationRequest.setRequestTypeId(new MstMemberPersonVerificationRequestType(1l));
		memberPersonVerificationRequest.setRequestSourceId(new MstMemberPersonVerificationRequestSource(1l));
		memberPersonVerificationRequest.setPersonGeneralId(insertPersonGeneral());
		memberPersonVerificationRequest.setCreatedAt(new Date());
		memberPersonVerificationRequest.setUpdatedAt(new Date());
		memberPersonVerificationRequest.setStatusId(new MstVerificationRequestStatus(1l));
		memberPersonVerificationRequest.setVerificationStatusId(new MstVerificationStatus(1l));
		memberPersonVerificationRequest = memberPersonVerificationRequestRepository
				.save(memberPersonVerificationRequest);

		return memberPersonVerificationRequest;
	}

	private MemberPersonVerificationRequest getExistingMemberPersonVerificationRequest() {
		List<MemberPersonVerificationRequest> memberPersonVerificationRequest = memberPersonVerificationRequestRepository
				.findAll(PageRequest.of(0, 1)).getContent();
		if (!memberPersonVerificationRequest.isEmpty()) {
			return memberPersonVerificationRequest.get(0);
		}
		return null;
	}

	// person_general
	public PersonGeneral insertPersonGeneral() {
		PersonGeneral personGeneral = getExistingPersonGeneral();
		if (personGeneral != null) {
			return personGeneral;
		}
		personGeneral = new PersonGeneral();
		personGeneral.setTitleId(mstDataLoader.insertMstTitle(1l));
		personGeneral.setFirstName("First Name");
		personGeneral.setFullName("Full Name");
		personGeneral.setCreatedAt(new Date());
		personGeneral.setUpdatedAt(new Date());
		personGeneral.setGender('M');
		personGeneral.setReferenceTableId(new MstPersonGeneralReferenceTable(1l));
		return personGeneralRepository.save(personGeneral);
	}

	private PersonGeneral getExistingPersonGeneral() {
		List<PersonGeneral> personGeneral = personGeneralRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!personGeneral.isEmpty()) {
			return personGeneral.get(0);
		}
		return null;
	}

}
