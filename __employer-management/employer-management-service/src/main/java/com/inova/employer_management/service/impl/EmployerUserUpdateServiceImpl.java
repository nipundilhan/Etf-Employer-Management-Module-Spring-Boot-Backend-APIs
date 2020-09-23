package com.inova.employer_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.inova.common.service.OtpManageService;
import com.inova.common.service.PersonGeneralContactService;
import com.inova.common.service.PersonGeneralNicService;
import com.inova.common.service.PersonGeneralPassportService;
import com.inova.config.EmployerManagementConfig;
import com.inova.dao.entities.Address;
import com.inova.dao.entities.DmuInbound;
import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerDocument;
import com.inova.dao.entities.EmployerInterimUser;
import com.inova.dao.entities.EmployerInterimUserMemberGroup;
import com.inova.dao.entities.EmployerRequestServiceCounterDmu;
import com.inova.dao.entities.EmployerUser;
import com.inova.dao.entities.EmployerUserHistory;
import com.inova.dao.entities.EmployerUserMemberGroup;
import com.inova.dao.entities.MstCivilStatus;
import com.inova.dao.entities.MstCountry;
import com.inova.dao.entities.MstDistrict;
import com.inova.dao.entities.MstEmployerMemberGroup;
import com.inova.dao.entities.MstIdentityNicType;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstTitle;
import com.inova.dao.entities.MstTxnAction;
import com.inova.dao.entities.MstUserCategory;
import com.inova.dao.entities.MstVerificationMethod;
import com.inova.dao.entities.Organization;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonGeneralAddress;
import com.inova.dao.entities.PersonGeneralNic;
import com.inova.dao.entities.PersonGeneralPassport;
import com.inova.dao.entities.ServiceRequest;
import com.inova.dao.entities.Transaction;
import com.inova.dao.entities.TxnEmployer;
import com.inova.dao.entities.User;
import com.inova.dao.entities.build.AddressEntityBuilder;
import com.inova.dao.entities.build.EmployerDocumentEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimUserEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimUserMemberGroupEntityBuilder;
import com.inova.dao.entities.build.EmployerRequestServiceCounterDmuEntityBuilder;
import com.inova.dao.entities.build.EmployerUserEntityBuilder;
import com.inova.dao.entities.build.EmployerUserHistoryEntityBuilder;
import com.inova.dao.entities.build.EmployerUserMemberGroupEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralAddressEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralEntityBuilder;
import com.inova.dao.entities.build.TransactionEntityBuilder;
import com.inova.dao.entities.build.TxnEmployerEntityBuilder;
import com.inova.dao.repositories.AddressRepository;
import com.inova.dao.repositories.EmployerDocumentRepository;
import com.inova.dao.repositories.EmployerInterimUserMemberGroupRepository;
import com.inova.dao.repositories.EmployerInterimUserRepository;
import com.inova.dao.repositories.EmployerRequestServiceCounterDmuRepository;
import com.inova.dao.repositories.EmployerUserHistoryRepository;
import com.inova.dao.repositories.EmployerUserMemberGroupRepository;
import com.inova.dao.repositories.EmployerUserRepository;
import com.inova.dao.repositories.MstEmployerMemberGroupRepository;
import com.inova.dao.repositories.PersonGeneralAddressRepository;
import com.inova.dao.repositories.PersonGeneralNicRepository;
import com.inova.dao.repositories.PersonGeneralPassportRepository;
import com.inova.dao.repositories.PersonGeneralRepository;
import com.inova.dao.repositories.TransactionRepository;
import com.inova.dao.repositories.TxnEmployerRepository;
import com.inova.dao.validate.DmuInboundValidator;
import com.inova.dao.validate.DocumentUploadedValidator;
import com.inova.dao.validate.EmployerUserValidator;
import com.inova.dao.validate.EmployerValidator;
import com.inova.dao.validate.MstCivilStatusValidator;
import com.inova.dao.validate.MstCountryValidator;
import com.inova.dao.validate.MstDistrictValidator;
import com.inova.dao.validate.MstIdentityNicTypeValidator;
import com.inova.dao.validate.MstPersonGeneralReferenceTableValidator;
import com.inova.dao.validate.MstTitleValidator;
import com.inova.dao.validate.MstTxnActionValidator;
import com.inova.dao.validate.MstUserCategoryValidator;
import com.inova.dao.validate.MstVerificationMethodValidator;
import com.inova.dao.validate.OrganizationValidator;
import com.inova.dao.validate.PersonGeneralAddressValidator;
import com.inova.dao.validate.PersonGeneralNicValidator;
import com.inova.dao.validate.PersonGeneralPassportValidator;
import com.inova.dao.validate.ServiceRequestValidator;
import com.inova.dao.validate.UserValidator;
import com.inova.employer_management.service.EmployerUserUpdateService;
import com.inova.exception.ApplicationException;
import com.inova.request.AddressRequest;
import com.inova.request.EmployerDocumentRequest;
import com.inova.request.EmployerUserMemberGroupRequestChild1;
import com.inova.request.EmployerUserRequestChild4;
import com.inova.request.OtpGeneratedRequestChild4;
import com.inova.request.PersonGeneralContactRequestChild2;
import com.inova.request.PersonGeneralContactRequestChild4;
import com.inova.request.PersonGeneralNicRequestChild1;
import com.inova.request.PersonGeneralPassportRequestChild1;
import com.inova.request.dto.AddressRequestDto;
import com.inova.request.dto.EmployerInterimUserRequestDto;
import com.inova.request.dto.EmployerRequestServiceCounterDmuRequestDto;
import com.inova.request.dto.EmployerUserRequestDto;
import com.inova.request.dto.PersonGeneralAddressRequestDto;
import com.inova.request.dto.PersonGeneralRequestDto;
import com.inova.request.dto.TransactionRequestDto;
import com.inova.request.dto.build.EmployerUserRequestDtoBuilder;
import com.inova.request.dto.build.PersonGeneralRequestDtoBuilder;
import com.inova.response.dto.EmployerUserResponseDto;
import com.inova.util.DateUtil;
import com.inova.util.NoteFormatter;
import com.inova.util.OrganizationUtil;
import com.inova.util.UserUtil;

@Service
public class EmployerUserUpdateServiceImpl implements EmployerUserUpdateService {

	public static final String VERIFICATION_METHOD_CODE = "OTP";
	public static final String USER_CATEGORY_CODE = "EMP";
	public static final Long REFERENCE_TABLE_ID = 5l;
	public static final Long ACTION_NO_EMPLOYER_USER_CREATED = 1003L;
	public static final Long ACTION_NO_EMPLOYER_PORTAL_USER_CREATED = 1003L;
	public static final String EMAIL_CONTACT_TYPE_CODE = "EM";
	public static final String MOBILE_CONTACT_TYPE_CODE = "MB";
	public static final String CREATE_EMPLOYER_PORTAL_OTP_CODE = "CEMPPORT";
	public static final Long ACTION_NO_EMPLOYER_USER_PORTAL_CREATED = 1004L;

	// need to change
	public static final String USER_NAME = "USER1";
	public static final String PASSWORD = "INV@123";

	@Autowired
	private EmployerManagementConfig employerConfig;

	@Autowired
	private OtpManageService otpManageService;
	@Autowired
	private PersonGeneralNicService personGeneralNicService;
	@Autowired
	private PersonGeneralPassportService personGeneralPassportService;
	@Autowired
	private PersonGeneralContactService personGeneralContactService;
	@Autowired
	private PersonGeneralNicRepository personGeneralNicRepository;
	@Autowired
	private PersonGeneralPassportRepository personGeneralPassportRepository;
	@Autowired
	private PersonGeneralAddressRepository personGeneralAddressRepository;
	@Autowired
	private EmployerUserRepository employerUserRepository;
	@Autowired
	private EmployerInterimUserRepository employerInterimUserRepository;	
	@Autowired
	private MstEmployerMemberGroupRepository  mstEmployerUserMemberGroupRepository;
	@Autowired
	private EmployerDocumentRepository employerDocumentRepository;
	@Autowired
	private EmployerRequestServiceCounterDmuRepository employerRequestServiceCounterDmuRepository;
	@Autowired
	private EmployerUserHistoryRepository employerUserHistoryRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private TxnEmployerRepository txnEmployerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PersonGeneralRepository personGeneralRepository;
	@Autowired	
	private EmployerUserMemberGroupRepository employerUserMemberGroupRepository;
	@Autowired
	private EmployerInterimUserMemberGroupRepository employerInterimUserMemberGroupRepository;

	@Autowired
	private UserUtil userUtil;
	@Autowired
	private OrganizationUtil organizationUtil;

	@Autowired
	private MstVerificationMethodValidator verificationMethodValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private EmployerValidator employerValidator;
	@Autowired
	private OrganizationValidator organizationValidator;
	@Autowired
	private DocumentUploadedValidator documentUploadedValidator;
	@Autowired
	private MstUserCategoryValidator mstUserCategoryValidator;
	@Autowired
	private DmuInboundValidator dmuInboundValidator;
	@Autowired
	private ServiceRequestValidator serviceRequestValidator;
	@Autowired
	private MstTxnActionValidator mstTxnActionValidator;
	@Autowired
	private MstPersonGeneralReferenceTableValidator mstPersonGeneralReferenceTableValidator;
	@Autowired
	private MstIdentityNicTypeValidator mstIdentityNicTypeValidator;
	@Autowired
	private EmployerUserValidator employerUserValidator;
	@Autowired
	private MstCivilStatusValidator mstCivilStatusValidator;
	@Autowired
	private MstTitleValidator mstTitleValidator;
	@Autowired
	private MstCountryValidator mstCountryValidator;
	@Autowired
	private MstDistrictValidator mstDistrictValidator;
	@Autowired
	private PersonGeneralRequestDtoBuilder personGeneralRequestDtoBuilder;	
	@Autowired
	private PersonGeneralPassportValidator personGeneralPassportValidator;	
	@Autowired
	private PersonGeneralNicValidator personGeneralNicValidator;
	@Autowired
	private PersonGeneralAddressValidator personGeneralAddressValidator;
	@Autowired
	private EmployerUserRequestDtoBuilder employerUserRequestDtoBuilder;

	@Override
	@MethodLogging
	@Transactional(rollbackOn = ApplicationException.class)
	public EmployerUserResponseDto update(EmployerUserRequestChild4 req, Long id) throws ApplicationException {
		// TODO Auto-generated method stub

		EmployerUserRequestDto requestDto = this.employerUserRequestDtoBuilder.buildCreateDto(req, null);

		// validations
		
		Optional<User> optionalUser = this.userValidator.validate(this.userUtil.getUserId("jwtToken"));
		User user = optionalUser.isPresent() ? optionalUser.get() :  null;

		Optional<Organization> optionalOrganization = this.organizationValidator.validate(this.organizationUtil.getOrganizationId("jwtToken"));
		Organization organization = optionalOrganization.isPresent() ? optionalOrganization.get():  null;

		Optional<MstUserCategory> optionalUserCategory = this.mstUserCategoryValidator.validateByCode(USER_CATEGORY_CODE);		
		Optional<MstVerificationMethod> optionalVerfication = this.verificationMethodValidator.validateByCode(VERIFICATION_METHOD_CODE);		
		MstVerificationMethod verificationMethod = optionalVerfication.isPresent() ? optionalVerfication.get() : null ;
		
		Optional<MstPersonGeneralReferenceTable> optionaleReferenceTable = this.mstPersonGeneralReferenceTableValidator.validate(REFERENCE_TABLE_ID);
	    MstPersonGeneralReferenceTable mstPersonGeneralReferenceTable = optionaleReferenceTable.isPresent() ? optionaleReferenceTable.get() : null;		
		
		Optional<MstTxnAction> optionalActionNo = mstTxnActionValidator.validateByActionNo(ACTION_NO_EMPLOYER_USER_PORTAL_CREATED);
		MstTxnAction mstTxnAction = optionalActionNo.isPresent() ? optionalActionNo.get() : null ;
		
		Optional<Employer> optionalEmployer = this.employerValidator.validateByRefNo(req.getEmployerRefNo());
		Employer employer = optionalEmployer.isPresent() ? optionalEmployer.get() : null;
		Optional<EmployerUser> employerUserOptional = employerUserValidator.validate(id);
		Optional<MstIdentityNicType> mstIdentityNicType = mstIdentityNicTypeValidator.validate(req.getNicTypeId());

		// user OTP mobile verification
		if (req.getUserMobileOtpDetails() != null) {
			OtpGeneratedRequestChild4 otpVerifyRequest = new OtpGeneratedRequestChild4();
			otpVerifyRequest.setContactValue(req.getUserMobileOtpDetails().getContactValue());
			otpVerifyRequest.setMstOtpCode(CREATE_EMPLOYER_PORTAL_OTP_CODE);
			otpVerifyRequest.setOtpValue(req.getUserMobileOtpDetails().getOtpValue());
			otpManageService.verifyOTP(otpVerifyRequest);
		} else {
			throw new ApplicationException(employerConfig.getEmployerUserOtpVerification());
		}

		// employer OTP mobile verification
		if (req.getEmployerOtpDetails() != null) {
			OtpGeneratedRequestChild4 otpVerifyRequest = new OtpGeneratedRequestChild4();
			otpVerifyRequest.setContactValue(req.getEmployerOtpDetails().getContactValue());
			otpVerifyRequest.setMstOtpCode(CREATE_EMPLOYER_PORTAL_OTP_CODE);
			otpVerifyRequest.setOtpValue(req.getEmployerOtpDetails().getOtpValue());
			otpManageService.verifyOTP(otpVerifyRequest);
		} else {
			throw new ApplicationException(employerConfig.getEmployerOtpVerification());
		}

		EmployerUser employerUser = null;
		if (employerUserOptional.isPresent()) {
			employerUser = employerUserOptional.get();
		} else {
			throw new ApplicationException(employerConfig.getEmployerUserNotFound());
		}

		PersonGeneral personGeneral = null;
		if (employerUser.getUserPersonGeneralId() != null) {
			personGeneral = employerUser.getUserPersonGeneralId();
		} else {
			throw new ApplicationException(employerConfig.getPersonGeneralNotFound());
		}

		if (employerUser.getUserId() != null) {
			employerUser.getUserId();
		} else {
			throw new ApplicationException(employerConfig.getUserNotFound());
		}

		// update person general
		// concern - try to use personGeneralService in comman module
		PersonGeneral personGeneralSaved = null;
		if (req.getPersonGeneralRequest() != null) {			
			PersonGeneralRequestDto personGeneralRequestDto = personGeneralRequestDtoBuilder
					.buildUpdateDto(req.getPersonGeneralRequest(), personGeneral.getId());

			Optional<MstCivilStatus> optionalCivilStatus = Optional.empty();
			if (req.getCivilStatusId() != null) {
				optionalCivilStatus = mstCivilStatusValidator.validate(req.getCivilStatusId());
			}
			Optional<MstTitle> optionalMstTitle = Optional.empty();
			if (req.getPersonGeneralRequest().getTitleId() != null) {
				optionalMstTitle = mstTitleValidator.validate(req.getPersonGeneralRequest().getTitleId());
			}

			PersonGeneralEntityBuilder personGeneralEntityBuilder = new PersonGeneralEntityBuilder();
			personGeneralEntityBuilder.setUpdatedBy(user);
			personGeneralEntityBuilder.setUpdatedOrganization(organization);
			personGeneralEntityBuilder.setTitleId(optionalMstTitle.isPresent() ? optionalMstTitle.get() : null);
			personGeneralEntityBuilder.setReferenceTableId(mstPersonGeneralReferenceTable);
			personGeneralEntityBuilder
					.setCivilStatusId(optionalCivilStatus.isPresent() ? optionalCivilStatus.get() : null);
			personGeneralSaved = personGeneralRepository
					.save(personGeneralEntityBuilder.buildUpdateEntity(personGeneralRequestDto, personGeneral));
		}

		// update person general nic
		if (req.getNicNo() != null && req.getNicTypeId() != null) {
			PersonGeneralNicRequestChild1 personGeneralNicRequestChild1 = new PersonGeneralNicRequestChild1();
			personGeneralNicRequestChild1.setCode(mstIdentityNicType.get().getCode());
			personGeneralNicRequestChild1.setNicNo(req.getNicNo());
			personGeneralNicRequestChild1.setPersonGeneralId(personGeneral.getId());
			personGeneralNicRequestChild1.setActive(true);
			personGeneralNicRequestChild1.setReferenceTableId(mstPersonGeneralReferenceTable.getId());	
			Optional<PersonGeneralNic> optionalPersonGeneralNic = personGeneralNicValidator.validate(req.getPersonGeneralNicId());
			PersonGeneralNic PersonGeneralNic = optionalPersonGeneralNic.isPresent() ? optionalPersonGeneralNic.get() : null;
			personGeneralNicService.update(personGeneralNicRequestChild1, PersonGeneralNic.getId());

		}

		// update person general passport
		if (req.getPersonGeneralPassportRequest() != null) {

			PersonGeneralPassportRequestChild1 personGeneralPassportRequest = (PersonGeneralPassportRequestChild1) convert(
					req.getPersonGeneralPassportRequest(), PersonGeneralPassportRequestChild1.class);
			personGeneralPassportRequest.setPersonGeneralId(personGeneral.getId());
			personGeneralPassportRequest.setReferenceTableId(mstPersonGeneralReferenceTable.getId());		
			Optional<PersonGeneralPassport> optinalPersonGeneralPassport = personGeneralPassportValidator.validate(req.getPersonGeneralPassportId());
			PersonGeneralPassport personGeneralPassport = optinalPersonGeneralPassport.isPresent() ? optinalPersonGeneralPassport.get() : null;
			personGeneralPassportService.update(personGeneralPassportRequest, personGeneralPassport.getId());

		}

//update person general address		
		/**
		 * PersonGeneralAddressRequestChild2 personGeneralAddressRequest = new
		 * PersonGeneralAddressRequestChild2(); AddressRequestChild1 addressRequest =
		 * (AddressRequestChild1) convert( req.getAddressRequest().getAddressDetais(),
		 * AddressRequestChild1.class);
		 * personGeneralAddressRequest.setAddressRequest(addressRequest); //
		 * personGeneralAddressRequest.setActive(req.getAddressRequest().isActive());
		 * personGeneralAddressRequest.setReferenceTableId(mstPersonGeneralReferenceTable.getId());
		 * personGeneralAddressRequest.setPersonGeneralId(personGeneral.getId());
		 * 
		 * // PersonGeneralAddress personGeneralAddress = personGeneralAddressRepository
		 * // .findByIndexedPersonGeneralId(personGeneral.getId());
		 * 
		 * if (addressId != null) {
		 * personGeneralAddressService.update(personGeneralAddressRequest, addressId);
		 * // personGeneralAddressResponseDto
		 * 
		 * }
		 **/

		if (req.getAddressRequest() != null) {

			Optional<PersonGeneralAddress> optinalPersonGeneralAddress = personGeneralAddressValidator.validate(req.getPersonGeneralAddressId());
			PersonGeneralAddress personGeneralAddress = optinalPersonGeneralAddress.isPresent() ? optinalPersonGeneralAddress.get() : null ;
			Address address = personGeneralAddress.getAddressId();

			AddressRequest addressRequest = req.getAddressRequest().getAddressDetais();
			// concern about using AddressRequestDtoBuilder
			AddressRequestDto addressRequestDto = AddressRequestDto.builder().address1(addressRequest.getAddress1())
					.address2(addressRequest.getAddress2()).address3(addressRequest.getAddress3())
					.city(addressRequest.getCity()).postalCode(addressRequest.getPostalCode())
					.note(addressRequest.getNote()).build();

			MstCountry mstCountry = mstCountryValidator.validate(addressRequest.getCountryId()).get();
			MstDistrict mstDistrict = mstDistrictValidator.validate(addressRequest.getDistrictId()).get();

			AddressEntityBuilder addressEntityBuilder = new AddressEntityBuilder();
			addressEntityBuilder.setCountryId(mstCountry);
			addressEntityBuilder.setDistrictId(mstDistrict);
			addressEntityBuilder.setUpdatedBy(user);
			addressEntityBuilder.setUpdatedOrganization(organization);
			Address addressEntity = addressEntityBuilder.buildUpdateEntity(addressRequestDto, address);

			Address updatedAddress = addressRepository.save(addressEntity);

			PersonGeneralAddressEntityBuilder personGeneralAddressEntityBuilder = new PersonGeneralAddressEntityBuilder();
			personGeneralAddressEntityBuilder.setPersonGeneralId(personGeneral);
			personGeneralAddressEntityBuilder.setAddressId(updatedAddress);
			personGeneralAddressEntityBuilder.setUpdatedBy(user);
			personGeneralAddressEntityBuilder.setUpdatedOrganization(organization);
			personGeneralAddressEntityBuilder.setReferenceTableId(mstPersonGeneralReferenceTable);

			PersonGeneralAddressRequestDto personGeneralAddressRequestDto = new PersonGeneralAddressRequestDto();
			personGeneralAddressRequestDto.setActive(true);
			PersonGeneralAddress PersonGeneralAddressEntity = personGeneralAddressEntityBuilder
					.buildUpdateEntity(personGeneralAddressRequestDto, personGeneralAddress);

			personGeneralAddressRepository.save(PersonGeneralAddressEntity);
		}

		// create person_general_contact list
		if (!req.getContactList().isEmpty()) {
			for (PersonGeneralContactRequestChild4 contactReq : req.getContactList()) {
				PersonGeneralContactRequestChild2 personGeneralContactRequest = new PersonGeneralContactRequestChild2();
				personGeneralContactRequest.setContactInfoRequest(contactReq.getContactInfoRequest());
				personGeneralContactRequest.setActive(contactReq.isActive());
				personGeneralContactRequest.setReferenceTableId(mstPersonGeneralReferenceTable.getId());
				personGeneralContactRequest.setPersonGeneralId(personGeneral.getId());
				personGeneralContactRequest.setPersonGeneralContactReferenceRequest(null);
				personGeneralContactService.create(personGeneralContactRequest);
			}
		}
		
		List<EmployerUserMemberGroup> employerUserMemberGroupList = new ArrayList<>();

		List<EmployerUserMemberGroupRequestChild1> employerUserMemberGroupRequestChild1List = new ArrayList<>();

		if (!req.getEmployerUserMemberGroupRequestList().isEmpty()) {
			employerUserMemberGroupRequestChild1List = req.getEmployerUserMemberGroupRequestList();
		
		}else {
			throw new ApplicationException(this.employerConfig.getErrorEmployerUserMemberGroup());
		}		
		
/**		

		@Query(value ="select * from employer_user_member_group where employer_user_id = ?1 ", nativeQuery = true)
		List<EmployerUserMemberGroup> findMemGroupsEmpUserId(Long id);
	
		List<EmployerUserMemberGroup> currentUserMemberGroupList = employerUserMemberGroupRepository
			.findMemGroupsEmpUserId(id);
		for (EmployerUserMemberGroup memGroup : currentUserMemberGroupList) {
			employerUserMemberGroupRepository.deleteById(memGroup.getId());

		}

**/	

	for (EmployerUserMemberGroupRequestChild1 memberGroup : employerUserMemberGroupRequestChild1List) {
		MstEmployerMemberGroup mstEmployerMemberGroup = this.mstEmployerUserMemberGroupRepository
				.findByCode(memberGroup.getMemberGroupCode())
				.orElseThrow(() -> new ApplicationException(this.employerConfig.getNotExist()));

		EmployerUserMemberGroupEntityBuilder employerUserMemberGroupEntityBuilder = new EmployerUserMemberGroupEntityBuilder();
		employerUserMemberGroupEntityBuilder.setEmployerUserId(employerUser);
		employerUserMemberGroupEntityBuilder.setMemberGroupId(mstEmployerMemberGroup);
		employerUserMemberGroupEntityBuilder.setCreatedBy(user);
		employerUserMemberGroupEntityBuilder.setCreatedOrganization(organization);
		EmployerUserMemberGroup empUserMemberGroup = employerUserMemberGroupEntityBuilder.buildCreateEntity(null,
				new EmployerUserMemberGroup());
		employerUserMemberGroupList.add(empUserMemberGroup);
	}	
	if(!employerUserMemberGroupList.isEmpty()) {
		employerUserMemberGroupRepository.saveAll(employerUserMemberGroupList);		
	}

		// update employer user
		requestDto.setUserVerificationAt(DateUtil.currentTimestamp());
		EmployerUserEntityBuilder employerUserEntityBuilder = new EmployerUserEntityBuilder();
		employerUserEntityBuilder.setEmployerId(employer);
		employerUserEntityBuilder.setUserId(user);// TODO should be changed to updated user
		employerUserEntityBuilder.setUserPersonGeneralId(personGeneral);
		employerUserEntityBuilder.setUserVerificationMethodId(verificationMethod);
		employerUserEntityBuilder.setUpdatedBy(user);
		employerUserEntityBuilder.setUpdatedOrganization(organization);

		EmployerUser employerUserToBeSaved = employerUserEntityBuilder.initUpdateEntity(requestDto, employerUser);
//recheck this one
//		employerUserToBeSaved.setEmployerUserMemberGroupList(employerUserMemberGroupList);
		employerUser = this.employerUserRepository.save(employerUserToBeSaved);

		// create employer_interim_user
		EmployerInterimUserEntityBuilder employerInterimUserEntityBuilder = new EmployerInterimUserEntityBuilder();
		EmployerInterimUserRequestDto employerInterimUserRequestDto = new EmployerInterimUserRequestDto();
		employerInterimUserRequestDto.setActive(true);
		employerInterimUserRequestDto.setAdminUser(employerUser.getAdminUser());
		employerInterimUserRequestDto.setDesignation(employerUser.getDesignation());
		employerInterimUserRequestDto.setUserVerificationAt(employerUser.getUserVerificationAt());
		employerInterimUserEntityBuilder.setAwarenessProgramId(employerUser.getAwarenessProgramId());
		employerInterimUserEntityBuilder.setCreatedBy(employerUser.getCreatedBy());
		employerInterimUserEntityBuilder.setCreatedOrganization(employerUser.getCreatedOrganizationId());
		employerInterimUserEntityBuilder.setEmployerInterimId(null);
		employerInterimUserEntityBuilder.setInactiveReasonId(employerUser.getInactiveReasonId());
		employerInterimUserEntityBuilder.setUserId(employerUser.getUserId());
		employerInterimUserEntityBuilder.setUserPersonGeneralId(employerUser.getUserPersonGeneralId());
		employerInterimUserEntityBuilder.setUserVerificationMethodId(employerUser.getUserVerificationMethodId());
		EmployerInterimUser employerInterimUser = this.employerInterimUserRepository
				.save(employerInterimUserEntityBuilder.buildCreateEntity(employerInterimUserRequestDto,
						new EmployerInterimUser()));
		
		//save employer inter user member group
		List<EmployerInterimUserMemberGroup> employerInterimUserMemberGroupList = new ArrayList<>();
		for (EmployerUserMemberGroup employerUserMemberGroup : employerUserMemberGroupList) {
			EmployerInterimUserMemberGroupEntityBuilder employerInterimUserMemberGroupEntityBuilder = new EmployerInterimUserMemberGroupEntityBuilder();
			employerInterimUserMemberGroupEntityBuilder.setEmployerInterimUserId(employerInterimUser);
			employerInterimUserMemberGroupEntityBuilder.setMemberGroupId(employerUserMemberGroup.getMemberGroupId());
			employerInterimUserMemberGroupEntityBuilder.setCreatedBy(employerUserMemberGroup.getCreatedBy());
			employerInterimUserMemberGroupEntityBuilder
					.setCreatedOrganization(employerUserMemberGroup.getCreatedOrganizationId());
			EmployerInterimUserMemberGroup employerInterimUserMemberGroup = employerInterimUserMemberGroupEntityBuilder.buildCreateEntity(null, new EmployerInterimUserMemberGroup());
			employerInterimUserMemberGroupList.add(employerInterimUserMemberGroup);
//			this.employerInterimUserMemberGroupRepository.save(employerInterimUserMemberGroupEntityBuilder
//					.buildCreateEntity(null, new EmployerInterimUserMemberGroup()));
		}
		if(!employerInterimUserMemberGroupList.isEmpty()) {
			this.employerInterimUserMemberGroupRepository.saveAll(employerInterimUserMemberGroupList);
		}

		// dmuInound validation
		DmuInbound dmuInbound = null;
		if (req.getEmployerRequestServiceCounterDmuRequest().getDmuInboundRefNo() != null) {
			dmuInbound = this.dmuInboundValidator
					.validateByRefNo(req.getEmployerRequestServiceCounterDmuRequest().getDmuInboundRefNo()).get();
		}

		// serviceRequest validation
		ServiceRequest serviceRequest = null;
		if (req.getEmployerRequestServiceCounterDmuRequest().getServiceRequestRefNo() != null) {
			serviceRequest = this.serviceRequestValidator
					.validateByRefNo(req.getEmployerRequestServiceCounterDmuRequest().getServiceRequestRefNo()).get();
		}

		// create employer_request_service_counter_dmu
		EmployerRequestServiceCounterDmu employerRequestServiceCounterDmu = new EmployerRequestServiceCounterDmu();
		EmployerRequestServiceCounterDmuRequestDto employerRequestServiceCounterDmuRequestDto = new EmployerRequestServiceCounterDmuRequestDto();
		employerRequestServiceCounterDmuRequestDto.setActionType(2);
		employerRequestServiceCounterDmuRequestDto.setPortal(false);
//		if (req.getCreateEmployerUser() && !req.getCreateEmployerPortal()) {
		EmployerRequestServiceCounterDmuEntityBuilder employerRequestServiceCounterDmuEntityBuilder = new EmployerRequestServiceCounterDmuEntityBuilder();
		employerRequestServiceCounterDmuEntityBuilder.setEmployerId(employer);
		employerRequestServiceCounterDmuEntityBuilder.setCreatedBy(user);
		employerRequestServiceCounterDmuEntityBuilder.setCreatedOrganization(organization);

		if (req.getDmuInboundService().equals(true)) {
			employerRequestServiceCounterDmuEntityBuilder.setDmuInboundId(dmuInbound);
		}
		if (req.getServiceCounterInquiry().equals(true)) {

			employerRequestServiceCounterDmuEntityBuilder.setServiceRequestId(serviceRequest);
			employerRequestServiceCounterDmuEntityBuilder
					.setServiceCounterRequirementTypeId(serviceRequest.getServiceCounterRequirementTypeId());
		}
		employerRequestServiceCounterDmu = this.employerRequestServiceCounterDmuRepository
				.save(employerRequestServiceCounterDmuEntityBuilder.buildCreateEntity(
						employerRequestServiceCounterDmuRequestDto, new EmployerRequestServiceCounterDmu()));
//		}

		EmployerUserHistoryEntityBuilder employerUserHistoryEntityBuilder = new EmployerUserHistoryEntityBuilder();
		employerUserHistoryEntityBuilder.setCreatedBy(user);
		employerUserHistoryEntityBuilder.setCreatedOrganization(organization);
		employerUserHistoryEntityBuilder.setEmployerInterimUserId(employerInterimUser);
//		if (request.getCreateEmployerUser()) {
		employerUserHistoryEntityBuilder.setEmployerRequestServiceCounterDmuId(employerRequestServiceCounterDmu);
//		}
		employerUserHistoryEntityBuilder.setEmployerUserId(employerUser);
		this.employerUserHistoryRepository
				.save(employerUserHistoryEntityBuilder.buildCreateEntity(null, new EmployerUserHistory()));

		// validate document_upload
		List<DocumentUploaded> documentUploadedList = new ArrayList<>();
		for (EmployerDocumentRequest employerDocumentRequest : req.getEmployerDocumentRequestList()) {
			Optional<DocumentUploaded> documentUploaded = documentUploadedValidator
					.validate(employerDocumentRequest.getDocumentUploadedId());
			documentUploadedList.add(documentUploaded.get());
		}

		// create employer_document
		List<EmployerDocument> EmployerDocumentList = new ArrayList<>();
		if (req.getEmployerDocumentRequestList() != null) {
			for (DocumentUploaded docUpld : documentUploadedList) {
				EmployerDocumentEntityBuilder employerDocumentEntityBuilder = new EmployerDocumentEntityBuilder();
				employerDocumentEntityBuilder.setEmployerId(employer);
				employerDocumentEntityBuilder.setDocumentUploadedId(docUpld);
				EmployerDocument employerDocument = employerDocumentEntityBuilder.buildCreateEntity(null, new EmployerDocument());
				EmployerDocumentList.add(employerDocument);
//				this.employerDocumentRepository
//						.save(employerDocumentEntityBuilder.buildCreateEntity(null, new EmployerDocument()));
			}
		}
		this.employerDocumentRepository.saveAll(EmployerDocumentList);

		// check whether is this part nessasary
		if (req.getRemovedEmployerDocumentList() != null) {
			for (Long removeempDocId : req.getRemovedEmployerDocumentList()) {
				this.employerDocumentRepository.deleteById(removeempDocId);
			}
		}

		TransactionEntityBuilder transactionEntityBuilder = new TransactionEntityBuilder();
		TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
		transactionRequestDto.setNote(NoteFormatter.getFormattedNote(null, null, user.getDisplayName()));
		transactionEntityBuilder.setActionId(mstTxnAction);
		transactionEntityBuilder.setCreatedBy(user);
		transactionEntityBuilder.setCreatedOrganization(organization);
		Transaction transaction = this.transactionRepository
				.save(transactionEntityBuilder.buildCreateEntity(transactionRequestDto, new Transaction()));

		// create txn_employer
		TxnEmployerEntityBuilder txnEmployerEntityBuilder = new TxnEmployerEntityBuilder();
		txnEmployerEntityBuilder.setTransactionId(transaction);
		txnEmployerEntityBuilder.setEmployerId(employer);
		txnEmployerEntityBuilder.setEmployerUserId(employerUser);
		this.txnEmployerRepository.save(txnEmployerEntityBuilder.buildCreateEntity(null, new TxnEmployer()));

		EmployerUserResponseDto buildCreateResponseDto = EmployerUserResponseDto.builder()
				.designation(employerUser.getDesignation()).adminUser(employerUser.getAdminUser())
				.active(employerUser.getActive()).build();
		return buildCreateResponseDto;

	}

	private Object convert(Object object, Class<?> type) {
		ModelMapper modelMapper = new ModelMapper();
		Object MapperObject = modelMapper.map(object, type);
		return MapperObject;
	}

	// TODO -
	// 1 update the API with related to the new Database Changes
	// 2 write API to load data to the front end
	// 3 check whether there can be multiple active IDs,PASSPORT s, NIC s and ADDRESESS to same employer use
	// same PERSON GENERAL account . then update should be changed

	// 4 add below with email verification id
	/**
	 * update user ContactInfo verificationMobileId = null; if
	 * ("MB".equals(req.getUserMobileOtpDetails().getContactTypeCode())) {
	 * ContactInfoRequestChild2 verifiedRequestMobile = new
	 * ContactInfoRequestChild2();
	 * verifiedRequestMobile.setCode(MOBILE_CONTACT_TYPE_CODE);
	 * verifiedRequestMobile.setValue(req.getUserMobileOtpDetails().getContactValue());
	 * ContactInfoResponseDto contactInfoResponseDtoUserMobile =
	 * contactInfoService.create(verifiedRequestMobile); verificationMobileId = new
	 * ContactInfo(contactInfoResponseDtoUserMobile.getId()); } if (originalUser !=
	 * null) { originalUser.setVerificationMobileId(verificationMobileId); User
	 * updatedUser = userRepository.save(originalUser); }
	 **/

	// consider a which is the preffered way to find existing ID s of the records
	// going to update
	// recheck the repositary mehtods getting id's
	/**
	 * 
	 * emplyrUserBasicDetResDto = employrUsrDetailsDao.getEmployerUserDetails(id);
	 * 
	 * Long personGeneralNicId = null; Long personGeneralPassportId = null; Long
	 * personGeneralAddressId = null; Long addressId = null;
	 * 
	 * if(emplyrUserBasicDetResDto != null) {
	 * 
	 * Optional<PersonGeneralNic> findByPersonGeneralId =
	 * personGeneralNicRepository.findByPersonGeneralId(personGeneral);
	 * 
	 * personGeneralNicId = emplyrUserBasicDetResDto.getPersonGeneralNicId();
	 * personGeneralPassportId =
	 * emplyrUserBasicDetResDto.getPersonGeneralPassportId(); personGeneralAddressId
	 * = emplyrUserBasicDetResDto.getPersonGeneralAddressId(); addressId =
	 * emplyrUserBasicDetResDto.getAddressId();
	 * 
	 * } 
	 * to find nessary id's
	 * //          PersonGeneralNic PersonGeneralNic = personGeneralNicRepository.findByPersonGeneralId(personGeneral).get();
	   //			PersonGeneralPassport personGeneralPassport = personGeneralPassportRepository
	   //			.findByIndexedPersonGeneralId(personGeneral.getId());
	   //			PersonGeneralAddress personGeneralAddress = personGeneralAddressRepository
	   //					.findByPersonGeneralId(personGeneralSaved).get();
	 * 1-  use a daoimpl method
	 * 2 - find id's using repositary methods
	 * 3 - provide related IDs to the front end intially in data retrieve API and expect
	 * back them to the back end API and validate
	 **/

}
