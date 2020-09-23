package com.inova.employer_management.service.impl;


import java.util.Date;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inova.applogger.util.MethodLogging;
import com.inova.common.service.PersonGeneralAddressService;
import com.inova.common.service.PersonGeneralService;
import com.inova.config.EmployerManagementConfig;
import com.inova.dao.entities.AwarenessProgram;
import com.inova.dao.entities.AwarenessProgramEmployerAttendee;
import com.inova.dao.entities.ContactInfo;
import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerInterimUser;
import com.inova.dao.entities.EmployerUser;
import com.inova.dao.entities.EmployerUserHistory;
import com.inova.dao.entities.MstContactType;
import com.inova.dao.entities.MstCountry;
import com.inova.dao.entities.MstEmployerMemberGroup;
import com.inova.dao.entities.MstIdentityNicType;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstReason;
import com.inova.dao.entities.MstTxnAction;
import com.inova.dao.entities.MstUserCategory;
import com.inova.dao.entities.MstVerificationMethod;
import com.inova.dao.entities.Organization;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonGeneralContact;
import com.inova.dao.entities.PersonGeneralNic;
import com.inova.dao.entities.PersonGeneralPassport;
import com.inova.dao.entities.Transaction;
import com.inova.dao.entities.User;
import com.inova.dao.entities.build.AwarenessProgramPortalUserEntityBuilder;
import com.inova.dao.entities.build.ContactInfoEntityBuilder;
import com.inova.dao.entities.build.EmployerDocumentEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimUserEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimUserMemberGroupEntityBuilder;
import com.inova.dao.entities.build.EmployerUserEntityBuilder;
import com.inova.dao.entities.build.EmployerUserHistoryEntityBuilder;
import com.inova.dao.entities.build.EmployerUserMemberGroupEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralContactEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralNicEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralPassportEntityBuilder;
import com.inova.dao.entities.build.TransactionEntityBuilder;
import com.inova.dao.entities.build.TxnEmployerEntityBuilder;
import com.inova.dao.entities.build.UserEntityBuilder;
import com.inova.dao.repositories.AwarenessProgramPortalUserRepository;
import com.inova.dao.repositories.ContactInfoRepository;
import com.inova.dao.repositories.EmployerDocumentRepository;
import com.inova.dao.repositories.EmployerInterimUserMemberGroupRepository;
import com.inova.dao.repositories.EmployerInterimUserRepository;
import com.inova.dao.repositories.EmployerRepository;
import com.inova.dao.repositories.EmployerUserHistoryRepository;
import com.inova.dao.repositories.EmployerUserMemberGroupRepository;
import com.inova.dao.repositories.EmployerUserRepository;
import com.inova.dao.repositories.PersonGeneralContactRepository;
import com.inova.dao.repositories.PersonGeneralNicRepository;
import com.inova.dao.repositories.PersonGeneralPassportRepository;
import com.inova.dao.repositories.TransactionRepository;
import com.inova.dao.repositories.TxnEmployerRepository;
import com.inova.dao.repositories.UserRepository;
import com.inova.dao.validate.AwarenessProgramEmployerAttendeeValidator;
import com.inova.dao.validate.DocumentUploadedValidator;
import com.inova.dao.validate.EmployerValidator;
import com.inova.dao.validate.MstContactTypeValidator;
import com.inova.dao.validate.MstCountryValidator;
import com.inova.dao.validate.MstEmployerMemberGroupValidator;
import com.inova.dao.validate.MstIdentityNicTypeValidator;
import com.inova.dao.validate.MstPersonGeneralReferenceTableValidator;
import com.inova.dao.validate.MstReasonValidator;
import com.inova.dao.validate.MstTxnActionValidator;
import com.inova.dao.validate.MstUserCategoryValidator;
import com.inova.dao.validate.MstVerificationMethodValidator;
import com.inova.dao.validate.OrganizationValidator;
import com.inova.dao.validate.UserValidator;
import com.inova.employer_management.service.EmployerUserPortalService;
import com.inova.exception.ApplicationException;
import com.inova.request.AddressRequestChild1;
import com.inova.request.ContactInfoRequestChild1;
import com.inova.request.EmployerUserRequestChild2;
import com.inova.request.EmployerUserRequestChild3;
import com.inova.request.PersonGeneralAddressRequestChild2;
import com.inova.request.PersonGeneralRequestChild1;
import com.inova.request.dto.AwarenessProgramPortalUserRequestDto;
import com.inova.request.dto.ContactInfoRequestDto;
import com.inova.request.dto.EmployerDocumentRequestDto;
import com.inova.request.dto.EmployerInterimUserMemberGroupRequestDto;
import com.inova.request.dto.EmployerInterimUserRequestDto;
import com.inova.request.dto.EmployerUserHistoryRequestDto;
import com.inova.request.dto.EmployerUserMemberGroupRequestDto;
import com.inova.request.dto.EmployerUserRequestDto;
import com.inova.request.dto.PersonGeneralContactRequestDto;
import com.inova.request.dto.PersonGeneralNicRequestDto;
import com.inova.request.dto.PersonGeneralPassportRequestDto;
import com.inova.request.dto.TransactionRequestDto;
import com.inova.request.dto.TxnEmployerRequestDto;
import com.inova.request.dto.UserRequestDto;
import com.inova.request.dto.build.EmployerUserRequestDtoBuilder;
import com.inova.request.dto.build.PersonGeneralPassportRequestDtoBuilder;
import com.inova.response.dto.EmployerUserResponseDto;
import com.inova.response.dto.PersonGeneralResponseDto;
import com.inova.response.dto.build.EmployerUserResponseDtoBuilder;
import com.inova.util.OrganizationUtil;
import com.inova.util.UserUtil;




@Service
public class EmployerUserPortalServiceImpl implements EmployerUserPortalService{
	
	
	public static final String VERIFICATION_METHOD_CODE = "OTP";
	public static final String USER_CATEGORY_CODE = "EMP";
	public static final Long REFERENCE_TABLE_ID = 5l;
	public static final Long INACTIVE_REASON_ID = 1l;
	public static final Long ACTION_NO_EMPLOYER_USER_PORTAL_CREATED = 1008L;
	public static final String EMAIL_CONTACT_TYPE_CODE = "EM";
	public static final String MOBILE_CONTACT_TYPE_CODE = "MB";
	public static final String CREATE_SELF_AGENT_PORTAL_OTP_CODE = "CSAGNPORT";
	
	
	
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private OrganizationValidator organizationValidator;
	@Autowired
	private MstVerificationMethodValidator mstVerificationMethodValidator;
	@Autowired
	private MstPersonGeneralReferenceTableValidator mstPersonGeneralReferenceTableValidator;
	@Autowired
	private MstUserCategoryValidator mstUserCategoryValidator;
	@Autowired
	private MstTxnActionValidator mstTxnActionValidator;	
	@Autowired	
	private EmployerValidator employerValidator;	
	@Autowired	
	private MstContactTypeValidator mstContactTypeValidator;	
	@Autowired	
	private MstEmployerMemberGroupValidator mstEmployerMemberGroupValidator;	
	@Autowired	
	private MstIdentityNicTypeValidator  mstIdentityNicTypeValidator;	
	@Autowired	
	private AwarenessProgramEmployerAttendeeValidator awarenessProgramEmployerAttendeeValidator;	
	@Autowired	
	private DocumentUploadedValidator documentUploadedValidator;	
	@Autowired	
	private MstCountryValidator mstCountryValidator;
	@Autowired	
	private MstReasonValidator mstReasonValidator;

	

	@Autowired
	private OrganizationUtil organizationUtil;
	@Autowired
	private UserUtil userUtil;
	
	
	
	@Autowired
	private PersonGeneralService personGeneralService;	
	@Autowired
	private PersonGeneralAddressService personGeneralAddressService;	

	
	
	
	@Autowired	
	private EmployerUserRepository employerUserRepository;	
	@Autowired	
	private UserRepository userRepository;	
	@Autowired	
	private EmployerInterimUserRepository employerInterimUserRepository;	
	@Autowired	
	private EmployerUserHistoryRepository employerUserHistoryRepository;	
	@Autowired	
	private EmployerUserMemberGroupRepository employerUserMemberGroupRepository;		
	@Autowired	
	private EmployerRepository  employerRepository;	
	@Autowired	
	private EmployerInterimUserMemberGroupRepository employerInterimUserMemberGroupRepository;
	@Autowired	
	private ContactInfoRepository contactInfoRepository;	
	@Autowired	
	private PersonGeneralNicRepository personGeneralNicRepository;	
	@Autowired	
	private PersonGeneralPassportRepository personGeneralPassportRepository;	
	@Autowired	
	private PersonGeneralContactRepository personGeneralContactRepository;	
	@Autowired	
	private TransactionRepository transactionRepository;		
	@Autowired	
	private TxnEmployerRepository txnEmployerRepository;	
	@Autowired	
	private AwarenessProgramPortalUserRepository awarenessProgramPortalUserRepository;	
	@Autowired	
	private EmployerDocumentRepository employerDocumentRepository;

	
	@Autowired
	private EmployerUserRequestDtoBuilder employerUserRequestDtoBuilder;	
	@Autowired
	private PersonGeneralPassportRequestDtoBuilder personGeneralPassportRequestDtoBuilder;
	

	
	
	
	@Autowired
	private EmployerUserResponseDtoBuilder employerUserResponseDtoBuilder;
	
	
	
	@Autowired
	private EmployerManagementConfig employerConfig;
	

	
	
	
	@Override
	@MethodLogging
	@Transactional(rollbackFor = ApplicationException.class)
	public EmployerUserResponseDto create(EmployerUserRequestChild3 req) throws ApplicationException {
		
		try {	

		Optional<MstPersonGeneralReferenceTable> mstPersonGeneralReferenceTable = mstPersonGeneralReferenceTableValidator
				.validate(REFERENCE_TABLE_ID);
		
		Optional<User> optionalUser = userValidator.validate(userUtil.getUserId("replace_me"));
		
		Optional<Organization> optionalOrganization = organizationValidator
				.validate(organizationUtil.getOrganizationId("replace_me"));
		
		Optional<MstVerificationMethod> mstVerificationMethod = mstVerificationMethodValidator
				.validateByCode(VERIFICATION_METHOD_CODE);
		
		Optional<MstTxnAction> optionalMstTxnAction = mstTxnActionValidator
				.validateByActionNo(ACTION_NO_EMPLOYER_USER_PORTAL_CREATED);
		
		Optional<MstUserCategory> mstUserCategory = mstUserCategoryValidator.validateByCode(USER_CATEGORY_CODE);

		Optional<MstIdentityNicType> mstIdentityNicType = mstIdentityNicTypeValidator.validateByCode(req.getCode());
		
		Optional<MstReason> mstReason = mstReasonValidator.validate(INACTIVE_REASON_ID);

		
		
		
		Optional<Employer> employer = employerValidator.validateByRefNo(req.getEmployerRefno()); // replace the ref number by path variable
		
		
		EmployerUserRequestDto requestDto = employerUserRequestDtoBuilder.buildCreateDto(req,null);
		
		
		Date date =  new Date();
		

		
		
		PersonGeneralResponseDto personGeneralResponseDto = null;

		// create person_general

		PersonGeneralRequestChild1 personGeneralRequest = (PersonGeneralRequestChild1) convert(
						req.getPersonGeneralRequest(), PersonGeneralRequestChild1.class);
		personGeneralRequest.setReferenceTableId(mstPersonGeneralReferenceTable.get().getId());
		personGeneralResponseDto = personGeneralService.create(personGeneralRequest);
		PersonGeneral personGeneral = new PersonGeneral(personGeneralResponseDto.getId());

		
				
//		create user		
		UserEntityBuilder userEntityBuilder = new UserEntityBuilder();

		userEntityBuilder.setCategoryId(mstUserCategory.get());		

		UserRequestDto userRequestDto =  new UserRequestDto();
		userRequestDto.setUsername(generateUserName());
		userRequestDto.setPassword(generatePassWord());
		userRequestDto.setDisplayName(generateDisplayName());
		userRequestDto.setActive(true);
		userRequestDto.setInvalidLoginCount(0);
//		userRequestDto.setLoginUrl(generateLoginUrl());
		
		User user = userEntityBuilder.buildCreateEntity(userRequestDto, null);
		user = userRepository.save(user);
		

//		check whether is a awareness programme attendee
		AwarenessProgram awarenessProgramId = null;
		if (req.isAwarenessProgrammeAttendee()) {

			Optional<AwarenessProgramEmployerAttendee> awarenessProgramEmployerAttendee = awarenessProgramEmployerAttendeeValidator
					.validate(req.getAttendeeId());
			
			awarenessProgramId = awarenessProgramEmployerAttendee.get().getAwarenessProgramId();
		}	
		
				
		
//		create employer_interim_user		
		EmployerInterimUserEntityBuilder employerInterimUserEntityBuilder  = new EmployerInterimUserEntityBuilder();
//	foriegn keys
	//	required
		employerInterimUserEntityBuilder.setUserId(user);
	//  not required 	
		// set 
		employerInterimUserEntityBuilder.setCreatedBy(optionalUser.get());
		employerInterimUserEntityBuilder.setCreatedOrganization(optionalOrganization.get());
		employerInterimUserEntityBuilder.setUserVerificationMethodId(mstVerificationMethod.get());
		employerInterimUserEntityBuilder.setUserPersonGeneralId(personGeneral);
					
		if (awarenessProgramId !=  null) {			
			employerInterimUserEntityBuilder.setAwarenessProgramId(awarenessProgramId);			
		}

		EmployerInterimUserRequestDto employerInterimUserRequestDto =  new EmployerInterimUserRequestDto();		
		employerInterimUserRequestDto.setUserVerificationAt(date);
		employerInterimUserRequestDto.setActive(true);
		employerInterimUserRequestDto.setAdminUser(req.isAdminUser());
		employerInterimUserRequestDto.setDesignation(req.getDesignation());
		
		EmployerInterimUser employerInterimUser = employerInterimUserEntityBuilder.buildCreateEntity(employerInterimUserRequestDto, null);
		
		employerInterimUser = employerInterimUserRepository.save(employerInterimUser);

		

		
//		create employer_user
		EmployerUserEntityBuilder employerUserEntityBuilder = new EmployerUserEntityBuilder();
		employerUserEntityBuilder.setCreatedBy(optionalUser.get());
		employerUserEntityBuilder.setCreatedOrganization(optionalOrganization.get());
		employerUserEntityBuilder.setUserId(user); // need to create user
		employerUserEntityBuilder.setUserPersonGeneralId(personGeneral);
		employerUserEntityBuilder.setUserVerificationMethodId(mstVerificationMethod.get());
		employerUserEntityBuilder.setEmployerId(employer.get());
		employerUserEntityBuilder.setInactiveReasonId(mstReason.get());
		// not required fields
		if (awarenessProgramId !=  null) {			
			employerUserEntityBuilder.setAwarenessProgramId(awarenessProgramId);			
		}

		EmployerUser tempEmployerUser = employerUserEntityBuilder.buildCreateEntity(requestDto, null);
		tempEmployerUser.setUserVerificationAt(date);

		EmployerUser employerUser = employerUserRepository.save(tempEmployerUser);

		
		
//      create person general nic		
			if (req.getNicNo() != null) {
				PersonGeneralNicEntityBuilder personGeneralNicEntityBuilder = new PersonGeneralNicEntityBuilder();
				personGeneralNicEntityBuilder.setNicTypeId(mstIdentityNicType.get());
				personGeneralNicEntityBuilder.setPersonGeneralId(personGeneral);
				personGeneralNicEntityBuilder.setReferenceTableId(mstPersonGeneralReferenceTable.get());
				personGeneralNicEntityBuilder.setCreatedBy(optionalUser.get());
				personGeneralNicEntityBuilder.setCreatedOrganization(optionalOrganization.get());

				PersonGeneralNicRequestDto personGeneralNicRequestDto = new PersonGeneralNicRequestDto();
				personGeneralNicRequestDto.setNicNo(req.getNicNo());
				PersonGeneralNic personGeneralNic = personGeneralNicEntityBuilder
						.buildCreateEntity(personGeneralNicRequestDto, null);
				personGeneralNicRepository.save(personGeneralNic);

			}
	
		
		
//      create person general passport
		Optional<MstCountry> mstCountry = mstCountryValidator.validate(req.getPersonGeneralPassportRequest().getCountryId());
				
		PersonGeneralPassportEntityBuilder personGeneralPassportEntityBuilder = new PersonGeneralPassportEntityBuilder();		
		personGeneralPassportEntityBuilder.setCountryId(mstCountry.get());
		personGeneralPassportEntityBuilder.setPersonGeneralId(personGeneral);
		personGeneralPassportEntityBuilder.setReferenceTableId(mstPersonGeneralReferenceTable.get());
		personGeneralPassportEntityBuilder.setCreatedBy(optionalUser.get());
		personGeneralPassportEntityBuilder.setCreatedOrganization(optionalOrganization.get());
		PersonGeneralPassportRequestDto  personGeneralPassportRequestDto = personGeneralPassportRequestDtoBuilder.buildCreateDto(req.getPersonGeneralPassportRequest(), null);		
		PersonGeneralPassport personGeneralPassport =  personGeneralPassportEntityBuilder.buildCreateEntity(personGeneralPassportRequestDto, null);		
		personGeneralPassportRepository.save(personGeneralPassport);
		

		
		
// 		create person_general_address
		//		req.getAddressRequest() -  AddressRequest
		if (req.getAddressRequest() != null) {
			PersonGeneralAddressRequestChild2 personGeneralAddressRequest = new PersonGeneralAddressRequestChild2();
			AddressRequestChild1 addressRequest = (AddressRequestChild1) convert(
					req.getAddressRequest(), AddressRequestChild1.class);
			// this method required a AddressRequestChild1 type object
			personGeneralAddressRequest.setAddressRequest(addressRequest);
			personGeneralAddressRequest.setReferenceTableId(mstPersonGeneralReferenceTable.get().getId());
			personGeneralAddressRequest.setPersonGeneralId(personGeneral.getId());
			personGeneralAddressRequest.setPersonGeneralAddressReferenceRequest(null);
			personGeneralAddressService.create(personGeneralAddressRequest);
		}
		

		
				
//		 create person_general_contact list
		if (!req.getContactInfoRequestList().isEmpty()) {
			for (ContactInfoRequestChild1 contactReq : req.getContactInfoRequestList()) {
								
				Optional<MstContactType> mstContactType = mstContactTypeValidator.validate(contactReq.getContactTypeId());
						
				ContactInfoEntityBuilder contactInfoEntityBuilder = new ContactInfoEntityBuilder();
				contactInfoEntityBuilder.setContactTypeId(mstContactType.get());				
				contactInfoEntityBuilder.setCreatedBy(optionalUser.get());
				contactInfoEntityBuilder.setCreatedOrganization(optionalOrganization.get());
				
				ContactInfoRequestDto  ContactInfoRequestDto =  new ContactInfoRequestDto();
				ContactInfoRequestDto.setValue(contactReq.getValue());
				ContactInfoRequestDto.setPublicNote(contactReq.getPublicNote());
				ContactInfoRequestDto.setNote(contactReq.getNote());
				ContactInfoRequestDto.setIncorrectContact(contactReq.isIncorrectContact()); 
								
				ContactInfo contactInfo = contactInfoEntityBuilder.buildCreateEntity(ContactInfoRequestDto, null);
			
				ContactInfo tempSavedContactInfo = contactInfoRepository.save(contactInfo);
				
				
				PersonGeneralContactEntityBuilder personGeneralContactEntityBuilder  = new PersonGeneralContactEntityBuilder();
				personGeneralContactEntityBuilder.setContactInfoId(tempSavedContactInfo);
				personGeneralContactEntityBuilder.setPersonGeneralId(personGeneral);
				personGeneralContactEntityBuilder.setReferenceTableId(mstPersonGeneralReferenceTable.get());
				personGeneralContactEntityBuilder.setCreatedBy(optionalUser.get());
				personGeneralContactEntityBuilder.setCreatedOrganization(optionalOrganization.get());
				PersonGeneralContact personGeneralContact = personGeneralContactEntityBuilder.buildCreateEntity(new PersonGeneralContactRequestDto(), null);

					
				personGeneralContactRepository.save(personGeneralContact);

			}

		}
		
		
		
	
		
//		create employer_user_history		
		EmployerUserHistoryEntityBuilder employerUserHistoryEntityBuilder = new EmployerUserHistoryEntityBuilder();
		employerUserHistoryEntityBuilder.setEmployerInterimUserId(employerInterimUser);
		employerUserHistoryEntityBuilder.setEmployerUserId(employerUser);
		//	    not required fields
		employerUserHistoryEntityBuilder.setCreatedBy(optionalUser.get());
		employerUserHistoryEntityBuilder.setCreatedOrganization(optionalOrganization.get());		
		EmployerUserHistory employerUserHistory = employerUserHistoryEntityBuilder.buildCreateEntity(new EmployerUserHistoryRequestDto(), null);
		employerUserHistoryRepository.save(employerUserHistory);
		

		
		
//		create member_groups
			if (!req.getMemberGroups().isEmpty()) {
				for (Long memberGroupId : req.getMemberGroups()) {

					Optional<MstEmployerMemberGroup> mstEmployerMemberGroup = mstEmployerMemberGroupValidator
							.validate(memberGroupId);

//			create employer_user_member_group			
					EmployerUserMemberGroupEntityBuilder employerUserMemberGroupEntityBuilder = new EmployerUserMemberGroupEntityBuilder();
					employerUserMemberGroupEntityBuilder.setMemberGroupId(mstEmployerMemberGroup.get());
					employerUserMemberGroupEntityBuilder.setEmployerUserId(employerUser);
					employerUserMemberGroupEntityBuilder.setCreatedBy(optionalUser.get());
					employerUserMemberGroupEntityBuilder.setCreatedOrganization(optionalOrganization.get());
					employerUserMemberGroupRepository.save(employerUserMemberGroupEntityBuilder
							.buildCreateEntity(new EmployerUserMemberGroupRequestDto(), null));

//			create employer_interim-user_member_group
					EmployerInterimUserMemberGroupEntityBuilder employerInterimUserMemberGroupEntityBuilder = new EmployerInterimUserMemberGroupEntityBuilder();
					employerInterimUserMemberGroupEntityBuilder.setMemberGroupId(mstEmployerMemberGroup.get());
					employerInterimUserMemberGroupEntityBuilder.setEmployerInterimUserId(employerInterimUser);
					employerInterimUserMemberGroupEntityBuilder.setCreatedBy(optionalUser.get());
					employerInterimUserMemberGroupEntityBuilder.setCreatedOrganization(optionalOrganization.get());

					employerInterimUserMemberGroupRepository.save(employerInterimUserMemberGroupEntityBuilder
							.buildCreateEntity(new EmployerInterimUserMemberGroupRequestDto(), null));
				}
			} else {

				throw new ApplicationException(this.employerConfig.getErrorEmployerUserMemberGroup());
			}


		
//			create awareness programme portal user		
			if (req.isAwarenessProgrammeAttendee()) {

				Optional<AwarenessProgramEmployerAttendee> awarenessProgramEmployerAttendee = awarenessProgramEmployerAttendeeValidator
						.validate(req.getAttendeeId());
				
				AwarenessProgramPortalUserEntityBuilder awarenessProgramPortalUserEntityBuilder = new AwarenessProgramPortalUserEntityBuilder();
//				awarenessProgramPortalUserEntityBuilder.setEmployerUserId(employerUser);
				awarenessProgramPortalUserEntityBuilder.setAttendeeEmployerId(awarenessProgramEmployerAttendee.get());
				awarenessProgramPortalUserEntityBuilder.setCreatedBy(optionalUser.get());
				awarenessProgramPortalUserEntityBuilder.setCreatedOrganization(optionalOrganization.get());
				awarenessProgramPortalUserRepository.save(awarenessProgramPortalUserEntityBuilder
						.buildCreateEntity(new AwarenessProgramPortalUserRequestDto(), null));

			}
		

		
//       upload document				
		for(Long documentId : req.getUploadedDocuments() ) {
		
			Optional<DocumentUploaded> documentUploaded = documentUploadedValidator.validate(documentId);
			EmployerDocumentEntityBuilder employerDocumentEntityBuilder = new EmployerDocumentEntityBuilder();
			employerDocumentEntityBuilder.setDocumentUploadedId(documentUploaded.get());
			employerDocumentEntityBuilder.setEmployerId(employer.get());
			employerDocumentRepository.save(employerDocumentEntityBuilder.buildCreateEntity(new EmployerDocumentRequestDto(), null));
		
		}
		
		
		
//		update employer		
		if(employer.isPresent()) {
			if (!employer.get().getPortalCreated()) {
				Employer emp = employer.get();
				emp.setPortalCreated(true);
				emp.setPortalCreatedAt(date);
				emp.setUpdatedBy(optionalUser.get());
				emp.setUpdatedOrganizationId(optionalOrganization.get());

				employerRepository.save(emp);

			}
		}
		else {
			throw new ApplicationException("employer not found");
		}
		
		
			

		
// 		create transaction		
		TransactionEntityBuilder transactionEntityBuilder = new TransactionEntityBuilder();	
		transactionEntityBuilder.setActionId(optionalMstTxnAction.get());
		transactionEntityBuilder.setCreatedBy(optionalUser.get());		
		transactionEntityBuilder.setCreatedOrganization(optionalOrganization.get());	
		Transaction transaction =  transactionRepository.save(transactionEntityBuilder.buildCreateEntity(new TransactionRequestDto(), null));
		
		
		
//		create txn employer		
		TxnEmployerEntityBuilder txnEmployerEntityBuilder = new TxnEmployerEntityBuilder();
		txnEmployerEntityBuilder.setEmployerUserId(employerUser);
		txnEmployerEntityBuilder.setEmployerId(employer.get());
		txnEmployerEntityBuilder.setTransactionId(transaction);		
		txnEmployerRepository.save( txnEmployerEntityBuilder.buildCreateEntity(new TxnEmployerRequestDto(), null));
		

		return employerUserResponseDtoBuilder.buildCreateResponseDto(employerUser);
	
		}
		catch (ApplicationException e) {
			throw e;
		}
		catch (Exception e) {
			
			throw new ApplicationException("exception occurs in service layer");
		}
	}
	

	
	
	
	private Object convert(Object object, Class<?> type) {
		ModelMapper modelMapper = new ModelMapper();
		Object MapperObject = modelMapper.map(object, type);
		return MapperObject;
	}
	
	
	
	private String generatePassWord() {		
		return "pass";
	}
	
	public String generateUserName() {		
		return "user name";
	}
	
	public String generateDisplayName() {		
		return "display name";
	}
	
	public String generateUniqueId() {		
		return "3455";
	}
	
	public String generateLoginUrl() {		
		return "http:localhost:8282/etf/loginurl";
	}

}
