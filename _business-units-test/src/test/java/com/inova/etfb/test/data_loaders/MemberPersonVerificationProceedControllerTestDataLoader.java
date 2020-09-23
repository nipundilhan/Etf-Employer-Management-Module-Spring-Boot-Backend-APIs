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
import com.inova.dao.entities.MstCurrency;
import com.inova.dao.entities.MstIdentityNicType;
import com.inova.dao.entities.MstMemberAccountStatus;
import com.inova.dao.entities.MstMemberAccountType;
import com.inova.dao.entities.MstMemberCreatedSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestType;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstPersonStatus;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstSelfEmploymentCategory;
import com.inova.dao.entities.MstSelfEmploymentCategoryNature;
import com.inova.dao.entities.MstSelfEmploymentPreRegistrationStatus;
import com.inova.dao.entities.MstSelfEmploymentRegistrationSource;
import com.inova.dao.entities.MstSelfEmploymentStatus;
import com.inova.dao.entities.MstVerificationRequestStatus;
import com.inova.dao.entities.MstVerificationStatus;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonGeneralNic;
import com.inova.dao.entities.PersonGeneralPassport;
import com.inova.dao.entities.SelfEmployment;
import com.inova.dao.entities.SelfEmploymentInterim;
import com.inova.dao.entities.SelfEmploymentPreRegistration;
import com.inova.dao.repositories.EmployerDirectorRepository;
import com.inova.dao.repositories.Member1Repository;
import com.inova.dao.repositories.MemberAccountNomineeRepository;
import com.inova.dao.repositories.MemberAccountRepository;
import com.inova.dao.repositories.MemberPersonVerificationRequestRepository;
import com.inova.dao.repositories.PersonGeneralNicRepository;
import com.inova.dao.repositories.PersonGeneralPassportRepository;
import com.inova.dao.repositories.PersonGeneralRepository;
import com.inova.dao.repositories.PersonRepository;
import com.inova.dao.repositories.SelfEmploymentInterimRepository;
import com.inova.dao.repositories.SelfEmploymentPreRegistrationDocumentRepository;
import com.inova.dao.repositories.SelfEmploymentPreRegistrationRepository;

@Component
public class MemberPersonVerificationProceedControllerTestDataLoader {

	@Autowired
	MemberPersonVerificationRequestRepository memberPersonVerificationRequestRepository;
	@Autowired
	PersonGeneralRepository personGeneralRepository;
	@Autowired
	PersonGeneralNicRepository personGeneralNicRepository;
	@Autowired
	PersonGeneralPassportRepository personGeneralPassportRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	MemberAccountRepository memberAccountRepository;
	@Autowired
	Member1Repository member1Repository;
	@Autowired
	MemberAccountNomineeRepository memberAccountNomineeRepository;
	@Autowired
	private EmployerDirectorRepository employerDirectorRepository;
	@Autowired
	SelfEmploymentPreRegistrationRepository	selfEmploymentPreRegistrationRepository;
	@Autowired
	SelfEmploymentInterimRepository	selfEmploymentInterimRepository;
	
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	// member_person_verification_request
	public MemberPersonVerificationRequest insertMemberPersonVerificationRequest() {
		MemberPersonVerificationRequest memberPersonVerificationRequest = getExistingMemberPersonVerificationRequest();
		if(memberPersonVerificationRequest!=null) {
			insertMemberAccount(memberPersonVerificationRequest);
			insertMemberAccountNominee(memberPersonVerificationRequest);
			insertEmployerDirector(memberPersonVerificationRequest);
			insertSelfEmploymentPreRegistration(memberPersonVerificationRequest);
			return memberPersonVerificationRequest;
		}
		memberPersonVerificationRequest = new MemberPersonVerificationRequest();
		memberPersonVerificationRequest.setRefNo(1234);
		memberPersonVerificationRequest.setPriorityId(new MstPriority(1l));
		memberPersonVerificationRequest.setRequestTypeId(new MstMemberPersonVerificationRequestType(2l));
		memberPersonVerificationRequest.setRequestSourceId(new MstMemberPersonVerificationRequestSource(1l));
		memberPersonVerificationRequest.setPersonGeneralId(insertPersonGeneral());
		memberPersonVerificationRequest.setCreatedAt(new Date());
		memberPersonVerificationRequest.setUpdatedAt(new Date());
		memberPersonVerificationRequest.setCreatedBy(txnCommonDataLoader.insertUser());
		memberPersonVerificationRequest.setStatusId(new MstVerificationRequestStatus(1l));
		memberPersonVerificationRequest.setVerificationStatusId(new MstVerificationStatus(1l));
		memberPersonVerificationRequest =  memberPersonVerificationRequestRepository.save(memberPersonVerificationRequest);
		insertMemberAccount(memberPersonVerificationRequest);
		insertMemberAccountNominee(memberPersonVerificationRequest);
		insertEmployerDirector(memberPersonVerificationRequest);
		insertSelfEmploymentPreRegistration(memberPersonVerificationRequest);
		
		
		
		return memberPersonVerificationRequest;
	}

	private MemberPersonVerificationRequest getExistingMemberPersonVerificationRequest() {
		List<MemberPersonVerificationRequest> memberPersonVerificationRequest = memberPersonVerificationRequestRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!memberPersonVerificationRequest.isEmpty()) {
			return memberPersonVerificationRequest.get(0);
		}
		return null;
	}

	// create member_account
	public MemberAccount insertMemberAccount(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		MemberAccount memberAccount = getExistingMemberAccount(memberPersonVerificationRequest);
		if (memberAccount != null) {
			return memberAccount;
		} else {
			memberAccount = new MemberAccount();
			memberAccount.setMemberId(insertMember());
			memberAccount.setRefNo(123);
			memberAccount.setMemberPersonVerificationRequestId(memberPersonVerificationRequest);
			MstMemberAccountStatus mstMemberAccountStatus = new MstMemberAccountStatus();
			mstMemberAccountStatus.setId(1l);
			memberAccount.setStatusId(mstMemberAccountStatus);
			memberAccount.setStatusAt(new Date());
			memberAccount.setAccountTypeId(new MstMemberAccountType(1l));
			memberAccount.setCreatedBy(txnCommonDataLoader.insertUser());
			return memberAccountRepository.save(memberAccount);
		}
		
	}

	private MemberAccount getExistingMemberAccount(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		List<MemberAccount> memberAccount = memberAccountRepository.findByMemberPersonVerificationRequestId_Id(memberPersonVerificationRequest.getId());
		if(!memberAccount.isEmpty()) {
			return memberAccount.get(0);
		} else {
			return null;
		}
	}
	// create member
	public Member1 insertMember() {
		Member1 member = getExistingMember();
		if (member != null) {
			return member;
		} else {
			member = new Member1();
			member.setPersonId(insertPerson());
			member.setCreatedBy(txnCommonDataLoader.insertUser());
			MstMemberCreatedSource mstMemberCreatedSource = new MstMemberCreatedSource();
			mstMemberCreatedSource.setId(1l);
			member.setCreatedSourceId(mstMemberCreatedSource);
			return member1Repository.save(member);
		}
		
	}

	private Member1 getExistingMember() {
		List<Member1> member = member1Repository.findAll(PageRequest.of(0, 1)).getContent();
		if(!member.isEmpty()) {
			return member.get(0);
		} else {
			return null;
		}
	}
	// person_general
	public PersonGeneral insertPersonGeneral() {
		PersonGeneral personGeneral = getExistingPersonGeneral();
		if(personGeneral!=null) {
			return personGeneral;
		}
		personGeneral = new PersonGeneral();
		personGeneral.setTitleId(mstDataLoader.insertMstTitle(1l));
		personGeneral.setFirstName("First Name");
		personGeneral.setFullName("Full Name");
		personGeneral.setCreatedAt(new Date());
		personGeneral.setUpdatedAt(new Date());
		personGeneral.setCreatedBy(txnCommonDataLoader.insertUser());
		personGeneral.setReferenceTableId(new MstPersonGeneralReferenceTable(1l));
		return personGeneralRepository.save(personGeneral);
	}

	private PersonGeneral getExistingPersonGeneral() {
		List<PersonGeneral> personGeneral = personGeneralRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personGeneral.isEmpty()) {
			return personGeneral.get(0);
		}
		return null;
	}
	
	public PersonGeneralNic insertPersonGeneralNic(Long personGeneralId) {
		PersonGeneralNic personGeneralNic = getExistingPersonGeneralNic(personGeneralId);
		if(personGeneralNic!=null) {
			return personGeneralNic;
		}
		personGeneralNic = new PersonGeneralNic();
		personGeneralNic.setCreatedAt(new Date());
		personGeneralNic.setCreatedBy(txnCommonDataLoader.insertUser());
		personGeneralNic.setUpdatedAt(new Date());
		personGeneralNic.setNicNo("903123370v");
		personGeneralNic.setNicTypeId(new MstIdentityNicType(1l));
		personGeneralNic.setReferenceTableId(new MstPersonGeneralReferenceTable(1l));
		return personGeneralNicRepository.save(personGeneralNic);
	}
	
	private PersonGeneralNic getExistingPersonGeneralNic(Long personGeneralId) {
		List<PersonGeneralNic> personGeneralNic = personGeneralNicRepository.findByPersonGeneralId_Id(personGeneralId);
		if(!personGeneralNic.isEmpty()) {
			return personGeneralNic.get(0);
		}
		return null;
	}
	
	public PersonGeneralPassport insertPersonGeneralPassport(Long personGeneralId) {
		PersonGeneralPassport personGeneralPassport = getExistingPersonGeneralPassport(personGeneralId);
		if(personGeneralPassport!=null) {
			return personGeneralPassport;
		}
		personGeneralPassport = new PersonGeneralPassport();
		personGeneralPassport.setCreatedAt(new Date());
		personGeneralPassport.setCreatedBy(txnCommonDataLoader.insertUser());
		personGeneralPassport.setUpdatedAt(new Date());
		personGeneralPassport.setPassportNo("12345678TH");
		personGeneralPassport.setCountryId(mstDataLoader.insertMstCountry());
		
		personGeneralPassport.setReferenceTableId(new MstPersonGeneralReferenceTable(1l));
		return personGeneralPassportRepository.save(personGeneralPassport);
	}
	
	private PersonGeneralPassport getExistingPersonGeneralPassport(Long personGeneralId) {
		List<PersonGeneralPassport> personGeneralPassport = personGeneralPassportRepository.findByPersonGeneralId_Id(personGeneralId);
		if(!personGeneralPassport.isEmpty()) {
			return personGeneralPassport.get(0);
		}
		return null;
	}
	
	// create person
	public Person insertPerson() {
		Person person = getExistingPerson();
		if (person != null) {
			return person;
		} else {
			person = new Person();
			Long generatedLong = 1l + (long) (Math.random() * (1000000000l - 1l));
			person.setRefNo(generatedLong);
			MstPersonStatus status = new MstPersonStatus();
			status.setId(1l);
			person.setStatusId(status);
			person.setStatusAt(new Date());
			person.setGender('M');
			person.setTitleId(this.mstDataLoader.insertMstTitle(1L));
			person.setFullName("Sample Full Name");
			person.setCreatedAt(new Date());
			person.setCreatedBy(txnCommonDataLoader.insertUser());
			person.setUpdatedAt(new Date());
			return personRepository.save(person);
		}
	}

	private Person getExistingPerson() {
		List<Person> persons = personRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}
	
	// create person for nominee
	public Person insertNomineePerson() {
		Person person = getExistingNomineePerson();
		if (person != null) {
			return person;
		} else {
			person = new Person();
			Long generatedLong = 1l + (long) (Math.random() * (1000000000l - 1l));
			person.setRefNo(generatedLong);
			MstPersonStatus status = new MstPersonStatus();
			status.setId(1l);
			person.setStatusId(status);
			person.setStatusAt(new Date());
			person.setGender('M');
			person.setTitleId(this.mstDataLoader.insertMstTitle(1L));
			person.setFullName("Sample Full Name");
			person.setCreatedAt(new Date());
			person.setCreatedBy(txnCommonDataLoader.insertUser());
			person.setUpdatedAt(new Date());
			return personRepository.save(person);
		}
	}

	private Person getExistingNomineePerson() {
		List<Person> persons = personRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty() && persons.size()>1) {
			return persons.get(1);
		} else {
			return null;
		}
	}
	
	// create member_accountNominee
	public MemberAccountNominee insertMemberAccountNominee(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		MemberAccountNominee memberAccountNominee = getExistingMemberAccountNominee(memberPersonVerificationRequest);
		if (memberAccountNominee != null) {
			return memberAccountNominee;
		} else {
			memberAccountNominee = new MemberAccountNominee();
			memberAccountNominee.setPersonId(insertNomineePerson());
			memberAccountNominee.setMemberAccountId(txnCommonDataLoader.insertMemberAccount());
			memberAccountNominee.setMemberPersonVerificationRequestId(memberPersonVerificationRequest);
			memberAccountNominee.setCreatedAt(new Date());
			memberAccountNominee.setUpdatedAt(new Date());
			memberAccountNominee.setCreatedBy(txnCommonDataLoader.insertUser());
			memberAccountNominee.setRelationshipId(mstDataLoader.insertMstRelationship());
			memberAccountNominee.setShare(new BigDecimal(10));
			return memberAccountNomineeRepository.save(memberAccountNominee);
		}
	}

	private MemberAccountNominee getExistingMemberAccountNominee(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		List<MemberAccountNominee> persons = memberAccountNomineeRepository.findByMemberPersonVerificationRequestId_Id(memberPersonVerificationRequest.getId());
		if(!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}
	
	//employer_director
	public EmployerDirector insertEmployerDirector(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		EmployerDirector employerDirector = getExistingEmployerDirector(memberPersonVerificationRequest);
		if(employerDirector != null) {
			return employerDirector;
		}
		employerDirector = new EmployerDirector();
		employerDirector.setEmployerId(txnCommonDataLoader.insertEmployer());
		employerDirector.setMemberPersonVerificationRequestId(memberPersonVerificationRequest);
		employerDirector.setPersonId(insertPerson());
		employerDirector.setCreatedAt(new Date());
		employerDirector.setCreatedBy(txnCommonDataLoader.insertUser());
		employerDirector.setUpdatedAt(new Date());
		return this.employerDirectorRepository.save(employerDirector);
		
	}

	private EmployerDirector getExistingEmployerDirector(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		List<EmployerDirector> employerDirector = this.employerDirectorRepository.findByMemberPersonVerificationRequestId_Id(memberPersonVerificationRequest.getId());
		if(!employerDirector.isEmpty()) {
			return employerDirector.get(0);
		} else {
			return null;
		}
	}
	// create self_employment
	public SelfEmploymentPreRegistration insertSelfEmploymentPreRegistration(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		SelfEmploymentPreRegistration selfEmploymentPreRegistration = getExistingSelfEmploymentPreRegistration(memberPersonVerificationRequest);
		if (selfEmploymentPreRegistration != null) {
			return selfEmploymentPreRegistration;
		} else {
			selfEmploymentPreRegistration = new SelfEmploymentPreRegistration();
			selfEmploymentPreRegistration.setRegistrationSourceId(new MstSelfEmploymentRegistrationSource(1l));
			selfEmploymentPreRegistration.setStatusId(new MstSelfEmploymentPreRegistrationStatus(1l));
			selfEmploymentPreRegistration.setStatusAt(new Date());
			selfEmploymentPreRegistration.setCreatedBy(txnCommonDataLoader.insertUser());
			selfEmploymentPreRegistration.setMemberPersonVerificationRequestId(memberPersonVerificationRequest);
			selfEmploymentPreRegistration.setSelfEmploymentInterimId(insertSelfEmploymentInterim());
			return selfEmploymentPreRegistrationRepository.save(selfEmploymentPreRegistration);
		}
		
	}

	private SelfEmploymentPreRegistration getExistingSelfEmploymentPreRegistration(MemberPersonVerificationRequest memberPersonVerificationRequest) {
		List<SelfEmploymentPreRegistration> selfEmploymentPreRegistration = selfEmploymentPreRegistrationRepository.findByMemberPersonVerificationRequestId_Id(memberPersonVerificationRequest.getId());
		if(!selfEmploymentPreRegistration.isEmpty()) {
			return selfEmploymentPreRegistration.get(0);
		} else {
			return null;
		}
	}
	
	// create self_employment
	public SelfEmploymentInterim insertSelfEmploymentInterim() {
		SelfEmploymentInterim selfEmploymentInterim = getExistingSelfEmploymentInterim();
		if (selfEmploymentInterim != null) {
			return selfEmploymentInterim;
		} else {
			selfEmploymentInterim = new SelfEmploymentInterim();
			selfEmploymentInterim.setCommencementDate(new Date());
			selfEmploymentInterim.setEmploymentCategoryId(new MstSelfEmploymentCategory(1l));
			selfEmploymentInterim.setEmploymentNatureId(mstDataLoader.insertMstSelfEmploymentCategoryNature());
			selfEmploymentInterim.setMemberAccountId(txnCommonDataLoader.insertMemberAccount());
			selfEmploymentInterim.setMinContribution(new BigDecimal(100));
			selfEmploymentInterim.setCurrencyId(new MstCurrency(1l));
			selfEmploymentInterim.setOwnerOrganizationId(txnCommonDataLoader.insertOrganization());
			selfEmploymentInterim.setCreatedBy(txnCommonDataLoader.insertUser());
			return selfEmploymentInterimRepository.save(selfEmploymentInterim);
		}
		
	}

	private SelfEmploymentInterim getExistingSelfEmploymentInterim() {
		List<SelfEmploymentInterim> selfEmploymentInterim = selfEmploymentInterimRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!selfEmploymentInterim.isEmpty()) {
			return selfEmploymentInterim.get(0);
		} else {
			return null;
		}
	}
}
