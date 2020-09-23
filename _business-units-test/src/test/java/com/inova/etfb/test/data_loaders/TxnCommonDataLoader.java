package com.inova.etfb.test.data_loaders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerDirector;
import com.inova.dao.entities.EmployerMemberAccount;
import com.inova.dao.entities.Member1;
import com.inova.dao.entities.MemberAccount;
import com.inova.dao.entities.MemberAccountNominee;
import com.inova.dao.entities.MemberPersonVerificationRequest;
import com.inova.dao.entities.MstCurrency;
import com.inova.dao.entities.MstEmployerCreateSourceType;
import com.inova.dao.entities.MstEmployerMemberAccountStatus;
import com.inova.dao.entities.MstEmployerNatureBusiness;
import com.inova.dao.entities.MstEmployerOrganizationType;
import com.inova.dao.entities.MstEmployerStatus;
import com.inova.dao.entities.MstEmployerType;
import com.inova.dao.entities.MstMemberAccountStatus;
import com.inova.dao.entities.MstMemberAccountType;
import com.inova.dao.entities.MstMemberCreatedSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestType;
import com.inova.dao.entities.MstModule;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstPersonStatus;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstSelfEmploymentCategory;
import com.inova.dao.entities.MstSelfEmploymentCategoryNature;
import com.inova.dao.entities.MstSelfEmploymentRegistrationSource;
import com.inova.dao.entities.MstSelfEmploymentStatus;
import com.inova.dao.entities.MstServiceCounterInquiryType;
import com.inova.dao.entities.MstServiceCounterStatus;
import com.inova.dao.entities.MstUserCategory;
import com.inova.dao.entities.MstVerificationRequestStatus;
import com.inova.dao.entities.MstVerificationStatus;
import com.inova.dao.entities.Organization;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.SelfEmployment;
import com.inova.dao.entities.ServiceCounter;
import com.inova.dao.entities.Transaction;
import com.inova.dao.entities.User;
import com.inova.dao.repositories.DocumentUploadedRepository;
import com.inova.dao.repositories.EmployerDirectorRepository;
import com.inova.dao.repositories.EmployerMemberAccountRepository;
import com.inova.dao.repositories.EmployerRepository;
import com.inova.dao.repositories.Member1Repository;
import com.inova.dao.repositories.MemberAccountNomineeRepository;
import com.inova.dao.repositories.MemberAccountRepository;
import com.inova.dao.repositories.MemberPersonVerificationRequestRepository;
import com.inova.dao.repositories.OrganizationRepository;
import com.inova.dao.repositories.PersonGeneralRepository;
import com.inova.dao.repositories.PersonRepository;
import com.inova.dao.repositories.SelfEmploymentRepository;
import com.inova.dao.repositories.ServiceCounterRepository;
import com.inova.dao.repositories.TransactionRepository;
import com.inova.dao.repositories.UserRepository;
import com.inova.util.NoteFormatter;

@Component
public class TxnCommonDataLoader {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	EmployerMemberAccountRepository employerMemberAccountRepository;
	@Autowired
	EmployerRepository employerRepository;
	@Autowired
	MemberAccountRepository memberAccountRepository;
	@Autowired
	Member1Repository member1Repository;
	@Autowired
	OrganizationRepository organizationRepository;
	@Autowired
	MemberPersonVerificationRequestRepository memberPersonVerificationRequestRepository;
	@Autowired
	PersonGeneralRepository personGeneralRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private EmployerDirectorRepository employerDirectorRepository;
	@Autowired
	MemberAccountNomineeRepository memberAccountNomineeRepository;
	@Autowired
	SelfEmploymentRepository selfEmploymentRepository;
	@Autowired
	DocumentUploadedRepository documentUploadedRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ServiceCounterRepository serviceCounterRepository;
	
	@Autowired
	MstDataLoader mstDataLoader;

	

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
			person.setUpdatedAt(new Date());
			person.setCreatedBy(insertUser());
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
			person.setUpdatedAt(new Date());
			person.setCreatedBy(insertUser());
			return personRepository.save(person);
		}
	}

	private Person getExistingNomineePerson() {
		List<Person> persons = personRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty()) {
			return persons.get(1);
		} else {
			return null;
		}
	}
	
	// create employer_member_accounr
	public EmployerMemberAccount insertEmployerMemberAccount() {
		EmployerMemberAccount employerMemberAccount = getExistingEmployerMemberAccount();
		if (employerMemberAccount != null) {
			return employerMemberAccount;
		} else {
			employerMemberAccount = new EmployerMemberAccount();
			employerMemberAccount.setEmployerId(insertEmployer());
			employerMemberAccount.setMemberAccountId(insertMemberAccount());
			MstEmployerMemberAccountStatus mstEmployerMemberAccountStatus = new MstEmployerMemberAccountStatus();
			mstEmployerMemberAccountStatus.setId(1l);
			employerMemberAccount.setStatusId(mstEmployerMemberAccountStatus);
			employerMemberAccount.setStatusAt(new Date());
			employerMemberAccount.setMemberNo(333);
			employerMemberAccount.setCreatedBy(insertUser());
			return employerMemberAccountRepository.save(employerMemberAccount);
		}
	}
	
	private EmployerMemberAccount getExistingEmployerMemberAccount() {
		List<EmployerMemberAccount> employerMemberAccount = employerMemberAccountRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!employerMemberAccount.isEmpty()) {
			return employerMemberAccount.get(0);
		} else {
			return null;
		}
	}
	// create employer
	public Employer insertEmployer() {
		Employer employer = getExistingEmployer();
		if (employer != null) {
			return employer;
		} else {
			employer = new Employer();
			MstEmployerStatus mstEmployerStatus = new MstEmployerStatus();
			mstEmployerStatus.setId(1l);
			employer.setStatusId(mstEmployerStatus);
			employer.setStatusAt(new Date());
			Long generatedLong = 1l + (long) (Math.random() * (1000000000l - 1l));
			employer.setRefNo(generatedLong);
			MstEmployerType mstEmployerType = new MstEmployerType();
			mstEmployerType.setId(1l);
			employer.setEmployerTypeId(mstEmployerType);
			employer.setTemporaryAccountCreated(false);
			MstEmployerNatureBusiness mstEmployerNatureBusiness = new MstEmployerNatureBusiness();
			mstEmployerNatureBusiness.setId(1l);
			employer.setNatureOfBusinessId(mstEmployerNatureBusiness);
			employer.setName("Test Employer");
			MstEmployerOrganizationType mstEmployerOrganizationType = new MstEmployerOrganizationType();
			mstEmployerOrganizationType.setId(1l);
			employer.setEmployerOrganizationTypeId(mstEmployerOrganizationType);
			employer.setIndustryTypeId(mstDataLoader.insertMstEmployerIndustryType(1l));
			MstEmployerCreateSourceType mstEmployerCreateSourceType = new MstEmployerCreateSourceType();
			mstEmployerCreateSourceType.setId(1l);
			employer.setCreatedSourceTypeId(mstEmployerCreateSourceType);
			employer.setCreatedBy(insertUser());
			return employerRepository.save(employer);
		}
	}
	
	private Employer getExistingEmployer() {
		List<Employer> employer = employerRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!employer.isEmpty()) {
			return employer.get(0);
		} else {
			return null;
		}
	}
	// create member_account
	public MemberAccount insertMemberAccount() {
		MemberAccount memberAccount = getExistingMemberAccount();
		if (memberAccount != null) {
			return memberAccount;
		} else {
			memberAccount = new MemberAccount();
			memberAccount.setMemberId(insertMember());
			Long generatedLong = 1l + (long) (Math.random() * (1000000000l - 1l));
			memberAccount.setRefNo(generatedLong);
			MstMemberAccountStatus mstMemberAccountStatus = new MstMemberAccountStatus();
			mstMemberAccountStatus.setId(1l);
			memberAccount.setStatusId(mstMemberAccountStatus);
			memberAccount.setStatusAt(new Date());
			memberAccount.setAccountTypeId(new MstMemberAccountType(1l));
			memberAccount.setCreatedBy(insertUser());
			return memberAccountRepository.save(memberAccount);
		}
		
	}

	private MemberAccount getExistingMemberAccount() {
		List<MemberAccount> memberAccount = memberAccountRepository.findAll(PageRequest.of(0, 1)).getContent();
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
			MstMemberCreatedSource mstMemberCreatedSource = new MstMemberCreatedSource();
			mstMemberCreatedSource.setId(1l);
			member.setCreatedSourceId(mstMemberCreatedSource);
			member.setCreatedBy(insertUser());
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
	// create organization
	public Organization insertOrganization() {
		Organization organization = getExistingOrganization();
		if (organization != null) {
			return organization;
		} else {
			organization = new Organization();
			organization.setOrganizationCategoryId(mstDataLoader.insertMstOrganizationCategory());
			organization.setOwner(true);
			organization.setCreatedAt(new Date());
			organization.setUpdatedAt(new Date());
			organization.setStatusId(mstDataLoader.insertMstOrganizationStatus());
			organization.setStatusAt(new Date());
			organization.setMigrated(false);
			organization.setCreatedBy(insertUser());
			return organizationRepository.save(organization);
		}

	}
	
	private Organization getExistingOrganization() {
		List<Organization> organization = organizationRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!organization.isEmpty()) {
			return organization.get(0);
		} else {
			return null;
		}
	}
	// member_person_verification_request
	public MemberPersonVerificationRequest insertMemberPersonVerificationRequest() {
		MemberPersonVerificationRequest memberPersonVerificationRequest = getExistingMemberPersonVerificationRequest();
		if(memberPersonVerificationRequest!=null) {
			return memberPersonVerificationRequest;
		}
		memberPersonVerificationRequest = new MemberPersonVerificationRequest();
		Long generatedLong = 1l + (long) (Math.random() * (1000000000l - 1l));
		memberPersonVerificationRequest.setRefNo(generatedLong);
		memberPersonVerificationRequest.setPriorityId(new MstPriority(1l));
		memberPersonVerificationRequest.setRequestTypeId(new MstMemberPersonVerificationRequestType(2l));
		memberPersonVerificationRequest.setRequestSourceId(new MstMemberPersonVerificationRequestSource(1l));
		memberPersonVerificationRequest.setPersonGeneralId(insertPersonGeneral());
		memberPersonVerificationRequest.setCreatedAt(new Date());
		memberPersonVerificationRequest.setUpdatedAt(new Date());
		memberPersonVerificationRequest.setStatusId(new MstVerificationRequestStatus(1l));
		memberPersonVerificationRequest.setVerificationStatusId(new MstVerificationStatus(1l));
		memberPersonVerificationRequest.setCreatedBy(insertUser());
		return memberPersonVerificationRequest;
	}

	private MemberPersonVerificationRequest getExistingMemberPersonVerificationRequest() {
		List<MemberPersonVerificationRequest> memberPersonVerificationRequest = memberPersonVerificationRequestRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!memberPersonVerificationRequest.isEmpty()) {
			return memberPersonVerificationRequest.get(0);
		}
		return null;
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
		personGeneral.setReferenceTableId(new MstPersonGeneralReferenceTable(1l));
		personGeneral.setCreatedBy(insertUser());
		return personGeneral;
	}

	private PersonGeneral getExistingPersonGeneral() {
		List<PersonGeneral> personGeneral = personGeneralRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!personGeneral.isEmpty()) {
			return personGeneral.get(0);
		}
		return null;
	}
	// transaction
	public Transaction insertTransaction() {
		Transaction transaction = getExistingTransaction();
		if(transaction != null) {
			return transaction;
		} else {
			transaction = new Transaction();
			transaction.setActionId(this.mstDataLoader.insertMstTxnAction(2001));
			transaction.setNote(NoteFormatter.getFormattedNote("", "test note", "test"));
			return this.transactionRepository.save(transaction);
		}
	}

	private Transaction getExistingTransaction() {
		List<Transaction> transaction = this.transactionRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!transaction.isEmpty()) {
			return transaction.get(0);
		} else {
			return null;
		}
	}
	
	//employer_director
	public EmployerDirector insertEmployerDirector() {
		EmployerDirector employerDirector = getExistingEmployerDirector();
		if(employerDirector != null) {
			return employerDirector;
		}
		employerDirector = new EmployerDirector();
		employerDirector.setEmployerId(insertEmployer());
		employerDirector.setPersonId(insertPerson());
		employerDirector.setCreatedAt(new Date());
		employerDirector.setUpdatedAt(new Date());
		employerDirector.setCreatedBy(insertUser());
		return this.employerDirectorRepository.save(employerDirector);
		
	}

	private EmployerDirector getExistingEmployerDirector() {
		List<EmployerDirector> employerDirector = this.employerDirectorRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!employerDirector.isEmpty()) {
			return employerDirector.get(0);
		} else {
			return null;
		}
	}
	
	// create member_accountNominee
	public MemberAccountNominee insertMemberAccountNominee() {
		MemberAccountNominee memberAccountNominee = getExistingMemberAccountNominee();
		if (memberAccountNominee != null) {
			return memberAccountNominee;
		} else {
			memberAccountNominee = new MemberAccountNominee();
			memberAccountNominee.setPersonId(insertNomineePerson());
			memberAccountNominee.setMemberAccountId(insertMemberAccount());
			memberAccountNominee.setMemberPersonVerificationRequestId(null);
			memberAccountNominee.setCreatedAt(new Date());
			memberAccountNominee.setUpdatedAt(new Date());
			memberAccountNominee.setRelationshipId(mstDataLoader.insertMstRelationship());
			memberAccountNominee.setShare(new BigDecimal(10));
			memberAccountNominee.setCreatedBy(insertUser());
			return memberAccountNomineeRepository.save(memberAccountNominee);
		}
	}

	private MemberAccountNominee getExistingMemberAccountNominee() {
		List<MemberAccountNominee> persons = memberAccountNomineeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!persons.isEmpty()) {
			return persons.get(0);
		} else {
			return null;
		}
	}
	// create self_employment
	public SelfEmployment insertSelfEmployment() {
		SelfEmployment selfEmployment = getExistingSelfEmployment();
		if (selfEmployment != null) {
			return selfEmployment;
		} else {
			selfEmployment = new SelfEmployment();
			Long generatedLong = 1l + (long) (Math.random() * (1000000000l - 1l));
			selfEmployment.setRefNo(generatedLong);
			selfEmployment.setRegistrationSourceId(new MstSelfEmploymentRegistrationSource(1l));
			selfEmployment.setStatusId(new MstSelfEmploymentStatus(1l));
			selfEmployment.setStatusAt(new Date());
			selfEmployment.setEmploymentCategoryId(new MstSelfEmploymentCategory(1l));
			selfEmployment.setEmploymentNatureId(new MstSelfEmploymentCategoryNature(1l));
			selfEmployment.setMemberAccountId(insertMemberAccount());
			selfEmployment.setMinContribution(new BigDecimal(100));
			selfEmployment.setCurrencyId(new MstCurrency(1l));
			selfEmployment.setOwnerOrganizationId(insertOrganization());
			selfEmployment.setCreatedBy(insertUser());
			return selfEmploymentRepository.save(selfEmployment);
		}
		
	}

	private SelfEmployment getExistingSelfEmployment() {
		List<SelfEmployment> selfEmployment = selfEmploymentRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!selfEmployment.isEmpty()) {
			return selfEmployment.get(0);
		} else {
			return null;
		}
	}
	
	// create person_document
	public DocumentUploaded insertDocumentUpload() {
		DocumentUploaded documentUploaded = getExistingDocumentUploaded();
		if (documentUploaded != null) {
			return documentUploaded;
		} else {
			documentUploaded = new DocumentUploaded();
			documentUploaded.setDocumentTypeId(mstDataLoader.insertMstDocumentType());
			documentUploaded.setName("Doc Name");
			documentUploaded.setDmsRef("c712076c-e255-40b2-af22-92d8261d3faa");
			documentUploaded.setModuleId(new MstModule(1l));
			documentUploaded.setCreatedBy(insertUser());
			return documentUploadedRepository.save(documentUploaded);
		}
	}
	
	private DocumentUploaded getExistingDocumentUploaded() {
		List<DocumentUploaded> documentUploaded = documentUploadedRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!documentUploaded.isEmpty()) {
			return documentUploaded.get(0);
		} else {
			return null;
		}
	}
	
	//service counter
	public ServiceCounter insertServiceCounter() {
		ServiceCounter serviceCounter = getExistingServiceCounter();
		if(serviceCounter != null) {
			return serviceCounter;
		} else {
			serviceCounter = new ServiceCounter();
			serviceCounter.setInquiryTypeId(new MstServiceCounterInquiryType(1L));
			serviceCounter.setRefNo(123);
			serviceCounter.setStatusId(new MstServiceCounterStatus(1L));
			serviceCounter.setStatusAt(new Date());
			serviceCounter.setCreatedAt(new Date());
			
			return serviceCounter;
		}
	}
	
	private ServiceCounter getExistingServiceCounter() {
		List<ServiceCounter> content = this.serviceCounterRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!content.isEmpty()) {
			return content.get(0);
		} else {
			return null;
		}
		
	}
	
	public User insertUser() {
		User user = getExistingUser();
		if (user != null) {
			return user;
		} else {
			user = new User();
			user.setCategoryId(new MstUserCategory(1l));
			user.setUsername("ABCD");
			user.setPassword("123");
			user.setDisplayName("User Display");
			return userRepository.save(user);
		}
	}
	
	private User getExistingUser() {
		List<User> user = userRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!user.isEmpty()) {
			return user.get(0);
		} else {
			return null;
		}
	}
}
