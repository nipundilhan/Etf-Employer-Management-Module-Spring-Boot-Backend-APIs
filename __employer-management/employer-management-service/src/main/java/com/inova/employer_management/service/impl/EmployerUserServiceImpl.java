package com.inova.employer_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.inova.applogger.util.MethodLogging;
import com.inova.common.service.AddressService;
import com.inova.common.service.ContactInfoService;
import com.inova.common.service.PersonGeneralService;
import com.inova.config.EmployerManagementConfig;
import com.inova.dao.entities.Address;
import com.inova.dao.entities.ContactInfo;
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
import com.inova.dao.entities.MstConfiguration;
import com.inova.dao.entities.MstCountry;
import com.inova.dao.entities.MstDistrict;
import com.inova.dao.entities.MstEmployerMemberGroup;
import com.inova.dao.entities.MstIdentityNicType;
import com.inova.dao.entities.MstPersonGeneralReferenceTable;
import com.inova.dao.entities.MstReason;
import com.inova.dao.entities.MstTitle;
import com.inova.dao.entities.MstTxnAction;
import com.inova.dao.entities.MstVerificationMethod;
import com.inova.dao.entities.Organization;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonGeneralAddress;
import com.inova.dao.entities.PersonGeneralContact;
import com.inova.dao.entities.PersonGeneralNic;
import com.inova.dao.entities.PersonGeneralPassport;
import com.inova.dao.entities.ServiceCounterRequirementType;
import com.inova.dao.entities.Transaction;
import com.inova.dao.entities.TxnEmployer;
import com.inova.dao.entities.User;
import com.inova.dao.entities.build.EmployerDocumentEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimUserEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimUserMemberGroupEntityBuilder;
import com.inova.dao.entities.build.EmployerRequestServiceCounterDmuEntityBuilder;
import com.inova.dao.entities.build.EmployerUserEntityBuilder;
import com.inova.dao.entities.build.EmployerUserHistoryEntityBuilder;
import com.inova.dao.entities.build.EmployerUserMemberGroupEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralContactEntityBuilder;
import com.inova.dao.entities.build.TransactionEntityBuilder;
import com.inova.dao.entities.build.TxnEmployerEntityBuilder;
import com.inova.dao.entities.clone.PersonGeneralAddressCloneEntityBuilder;
import com.inova.dao.entities.clone.PersonGeneralCloneEntityBuilder;
import com.inova.dao.entities.clone.PersonGeneralContactCloneEntityBuilder;
import com.inova.dao.entities.clone.PersonGeneralNicCloneEntityBuilder;
import com.inova.dao.entities.clone.PersonGeneralPassportCloneEntityBuilder;
import com.inova.dao.repositories.AddressRepository;
import com.inova.dao.repositories.EmployerDocumentRepository;
import com.inova.dao.repositories.EmployerInterimUserMemberGroupRepository;
import com.inova.dao.repositories.EmployerInterimUserRepository;
import com.inova.dao.repositories.EmployerRequestServiceCounterDmuRepository;
import com.inova.dao.repositories.EmployerUserHistoryRepository;
import com.inova.dao.repositories.EmployerUserMemberGroupRepository;
import com.inova.dao.repositories.EmployerUserRepository;
import com.inova.dao.repositories.PersonGeneralAddressRepository;
import com.inova.dao.repositories.PersonGeneralContactRepository;
import com.inova.dao.repositories.PersonGeneralNicRepository;
import com.inova.dao.repositories.PersonGeneralPassportRepository;
import com.inova.dao.repositories.PersonGeneralRepository;
import com.inova.dao.repositories.TransactionRepository;
import com.inova.dao.repositories.TxnEmployerRepository;
import com.inova.dao.validate.ContactInfoValidator;
import com.inova.dao.validate.DmuInboundValidator;
import com.inova.dao.validate.DocumentUploadedValidator;
import com.inova.dao.validate.EmployerUserMemberGroupValidator;
import com.inova.dao.validate.EmployerUserValidator;
import com.inova.dao.validate.EmployerValidator;
import com.inova.dao.validate.MstCivilStatusValidator;
import com.inova.dao.validate.MstConfigurationValidator;
import com.inova.dao.validate.MstCountryValidator;
import com.inova.dao.validate.MstDistrictValidator;
import com.inova.dao.validate.MstEmployerMemberGroupValidator;
import com.inova.dao.validate.MstIdentityNicTypeValidator;
import com.inova.dao.validate.MstPersonGeneralReferenceTableValidator;
import com.inova.dao.validate.MstReasonValidator;
import com.inova.dao.validate.MstTitleValidator;
import com.inova.dao.validate.MstTxnActionValidator;
import com.inova.dao.validate.MstVerificationMethodValidator;
import com.inova.dao.validate.OrganizationValidator;
import com.inova.dao.validate.PersonGeneralAddressValidator;
import com.inova.dao.validate.PersonGeneralContactValidator;
import com.inova.dao.validate.PersonGeneralNicValidator;
import com.inova.dao.validate.PersonGeneralPassportValidator;
import com.inova.dao.validate.PersonGeneralValidator;
import com.inova.dao.validate.ServiceCounterRequirementTypeValidator;
import com.inova.dao.validate.UserValidator;
import com.inova.document.request.DocumentUpdateRequest;
import com.inova.document.service.DocumentService;
import com.inova.employer_management.service.EmployerUserService;
import com.inova.enums.ActionType;
import com.inova.enums.MstModuleEnum;
import com.inova.enums.MstVerificationMethodEnum;
import com.inova.etfb.employer_management.dao.EmployerUserCreatePageLoadDao;
import com.inova.etfb.employer_management.wrapper.EmployerUserPageLoadRespDto;
import com.inova.exception.ApplicationException;
import com.inova.request.ContactInfoRequestChild2;
import com.inova.request.EmployerDocumentRequest;
import com.inova.request.EmployerUserMemberGroupRequestChild1;
import com.inova.request.EmployerUserRequestChild5;
import com.inova.request.PersonGeneralContactRequestChild4;
import com.inova.request.PersonGeneralContactRequestChild7;
import com.inova.request.dto.EmployerInterimUserRequestDto;
import com.inova.request.dto.EmployerRequestServiceCounterDmuRequestDto;
import com.inova.request.dto.EmployerUserRequestDto;
import com.inova.request.dto.PersonGeneralContactRequestDto;
import com.inova.request.dto.build.EmployerUserRequestDtoBuilder;
import com.inova.response.dto.ContactInfoResponseDto;
import com.inova.response.dto.DocumentUploadedResponseDto;
import com.inova.response.dto.EmployerUserResponseDto;
import com.inova.response.dto.build.EmployerUserResponseDtoBuilder;
import com.inova.util.DateUtil;
import com.inova.util.NoteFormatter;
import com.inova.util.OrganizationUtil;
import com.inova.util.UserUtil;

@Service
public class EmployerUserServiceImpl implements EmployerUserService {

	@Autowired
	private EmployerUserRequestDtoBuilder employerUserRequestDtoBuilder;
	@Autowired
	private EmployerUserResponseDtoBuilder employerUserResponseDtoBuilder;

	@Autowired
	private UserUtil userUtil;
	@Autowired
	private OrganizationUtil organizationUtil;

	@Autowired
	private PersonGeneralService personGeneralService;
	@Autowired
	private ContactInfoService contactInfoService;
	@Autowired
	private AddressService addressServicce;
	@Autowired
	private DocumentService documentService;

	@Autowired
	private UserValidator userValidator;
	@Autowired
	private OrganizationValidator organizationValidator;
	@Autowired
	private EmployerUserValidator employerUserValidator;
	@Autowired
	private PersonGeneralValidator personGeneralValidator;
	@Autowired
	private MstReasonValidator mstReasonValidator;
	@Autowired
	private MstTitleValidator mstTitleValidator;
	@Autowired
	private MstCivilStatusValidator mstCivilStatusValidator;
	@Autowired
	private PersonGeneralAddressValidator personGeneralAddressValidator;
	@Autowired
	private ContactInfoValidator contactInfoValidator;
	@Autowired
	private PersonGeneralContactValidator personGeneralContactValidator;
	@Autowired
	private MstDistrictValidator mstDistrictValidator;
	@Autowired
	private MstPersonGeneralReferenceTableValidator mstPersonGeneralReferenceTableValidator;
	@Autowired
	private PersonGeneralNicValidator personGeneralNicValidator;
	@Autowired
	private MstIdentityNicTypeValidator mstIdentityNicTypeValidator;
	@Autowired
	private PersonGeneralPassportValidator personGeneralPassportValidator;
	@Autowired
	private MstCountryValidator mstCountryValidator;
	@Autowired
	private MstVerificationMethodValidator mstVerificationMethodValidator;
	@Autowired
	private EmployerUserMemberGroupValidator employerUserMemberGroupValidator;
	@Autowired
	private MstEmployerMemberGroupValidator mstEmployerMemberGroupValidator;
	@Autowired
	private ServiceCounterRequirementTypeValidator serviceCounterRequirementTypeValidator;
	@Autowired
	private DmuInboundValidator dmuInboundValidator;
	@Autowired
	private DocumentUploadedValidator documentUploadedValidator;
	@Autowired
	private MstTxnActionValidator mstTxnActionValidator;
	@Autowired
	private EmployerValidator employerValidator;
	@Autowired
	private MstConfigurationValidator mstConfigurationValidator;

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PersonGeneralRepository personGeneralRepository;
	@Autowired
	private PersonGeneralAddressRepository personGeneralAddressRepository;
	@Autowired
	private PersonGeneralContactRepository personGeneralContactRepository;
	@Autowired
	private PersonGeneralNicRepository personGeneralNicRepository;
	@Autowired
	private PersonGeneralPassportRepository personGeneralPassportRepository;
	@Autowired
	private EmployerUserRepository employerUserRepository;
	@Autowired
	private EmployerUserMemberGroupRepository employerUserMemberGroupRepository;
	@Autowired
	private EmployerInterimUserRepository employerInterimUserRepository;
	@Autowired
	private EmployerRequestServiceCounterDmuRepository employerRequestServiceCounterDmuRepository;
	@Autowired
	private EmployerUserHistoryRepository employerUserHistoryRepository;
	@Autowired
	private EmployerInterimUserMemberGroupRepository employerInterimUserMemberGroupRepository;
	@Autowired
	private EmployerDocumentRepository employerDocumentRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private TxnEmployerRepository txnEmployerRepository;

	@Autowired
	private EmployerManagementConfig empManageConfig;

	@Autowired
	private EmployerUserCreatePageLoadDao employerUserCreatePageLoadDao;

	private static final Long MST_PERSON_GENERAL_REFERENCE_TABLE_EMPLOYER_USER = 5L;
	private static final Long TXN_ACTION_EMPLOYER_USER_UPDATED = 1004L;
	private static final Long MST_CONFIGURATION_ID = 1L;

	@Override
	@MethodLogging
	@Transactional(rollbackOn = ApplicationException.class)
	public EmployerUserResponseDto update(EmployerUserRequestChild5 req, Long id) throws ApplicationException {

		if (!req.isMobileNoOtpVerified() || !req.isEmployerMobileOtpVerified()) {
			throw new ApplicationException(this.empManageConfig.getErrorOtpFailed());
		}

		EmployerUserRequestDto requestDto = this.employerUserRequestDtoBuilder.buildUpdateDto(req, id);
		EmployerUser employerUser;
		Optional<EmployerUser> optEmployer = this.employerUserValidator.validate(id);
		if (optEmployer.isPresent()) {
			employerUser = optEmployer.get();
		} else {
			employerUser = null;
		}

		Optional<User> optUser = this.userValidator.validate(userUtil.getUserId("replace_me"));
		User user = optUser.isPresent() ? optUser.get() : null;
		Optional<Organization> optOrganization = this.organizationValidator
				.validate(organizationUtil.getOrganizationId("replace_me"));
		Organization organization = optOrganization.isPresent() ? optOrganization.get() : null;
		Optional<MstPersonGeneralReferenceTable> optMstPersonGeneralReferenceTable = this.mstPersonGeneralReferenceTableValidator
				.validate(MST_PERSON_GENERAL_REFERENCE_TABLE_EMPLOYER_USER);
		MstPersonGeneralReferenceTable mstPersonGeneralReferenceTable = optMstPersonGeneralReferenceTable.isPresent()
				? optMstPersonGeneralReferenceTable.get()
				: null;
		MstReason mstReason;
		if (req.getInactiveReasonId() != null) {
			Optional<MstReason> optReason = this.mstReasonValidator.validate(req.getInactiveReasonId());
			mstReason = optReason.isPresent() ? optReason.get() : null;
		} else {
			mstReason = null;
		}
		Optional<MstTitle> optTitle = this.mstTitleValidator.validate(req.getPersonGeneralRequest().getTitleId());
		MstTitle title = optTitle.isPresent() ? optTitle.get() : null;
		Optional<MstTxnAction> optTxnAction = this.mstTxnActionValidator
				.validateByActionNo(TXN_ACTION_EMPLOYER_USER_UPDATED);
		Optional<MstVerificationMethod> optVerificationMethod = this.mstVerificationMethodValidator
				.validateByCode(MstVerificationMethodEnum.OTP.getCode());
		ServiceCounterRequirementType serviceCounterRequirementType;
		if (req.getServiceCounterRequirementTypeId() != null) {
			Optional<ServiceCounterRequirementType> optRequirementType = this.serviceCounterRequirementTypeValidator
					.validate(req.getServiceCounterRequirementTypeId());
			if (optRequirementType.isPresent()) {
				serviceCounterRequirementType = optRequirementType.get();
			} else {
				serviceCounterRequirementType = null;
			}
		} else {
			serviceCounterRequirementType = null;
		}
		DmuInbound dmuInbound;
		if (req.getDmuInboundRefNo() != null) {
			Optional<DmuInbound> optDmuInbound = this.dmuInboundValidator.validateByRefNo(req.getDmuInboundRefNo());
			if (optDmuInbound.isPresent()) {
				dmuInbound = optDmuInbound.get();
			} else {
				dmuInbound = null;
			}
		} else {
			dmuInbound = null;
		}

		EmployerRequestServiceCounterDmuRequestDto counterRequestDto = EmployerRequestServiceCounterDmuRequestDto
				.builder().actionType(ActionType.UPDATD.getId()).build();
		EmployerRequestServiceCounterDmuEntityBuilder serviceCounterDmuEntityBuilder = new EmployerRequestServiceCounterDmuEntityBuilder();
		serviceCounterDmuEntityBuilder.setCreatedBy(user);
		serviceCounterDmuEntityBuilder.setCreatedOrganization(organization);
		serviceCounterDmuEntityBuilder.setEmployerId(employerUser.getEmployerId());
		serviceCounterDmuEntityBuilder.setEmployerUserId(employerUser);
		serviceCounterDmuEntityBuilder.setServiceCounterRequirementTypeId(serviceCounterRequirementType);
		serviceCounterDmuEntityBuilder.setDmuInboundId(dmuInbound);
		EmployerRequestServiceCounterDmu employerRequestServiceCounterDmu = serviceCounterDmuEntityBuilder
				.buildCreateEntity(counterRequestDto, null);
		serviceCounterDmuEntityBuilder.initCreatedBy(employerRequestServiceCounterDmu);
		serviceCounterDmuEntityBuilder.initCreatedOrganization(employerRequestServiceCounterDmu);
		employerRequestServiceCounterDmu = this.employerRequestServiceCounterDmuRepository
				.save(employerRequestServiceCounterDmu);
		
		// removing already existing admin_user references in order to create a new
		// admin_user reference
		if (req.isAdminUser() && req.isActive()) {
			EmployerUser oldAdminUser;
			List<EmployerUser> optAdminUser = this.employerUserValidator.validateByAdminUserAndActive(employerUser.getEmployerId().getId(), true, true);
			if (!optAdminUser.isEmpty()) {
				oldAdminUser = optAdminUser.get(0);
			} else {
				oldAdminUser = null;
			}
			if (oldAdminUser != null && employerUser != oldAdminUser) {
//				oldAdminUser.setAdminUser(false);
//				oldAdminUser.setUpdatedAt(DateUtil.currentTimestamp());
//				oldAdminUser.setUpdatedBy(user);
//				oldAdminUser.setUpdatedOrganizationId(organization);
//				oldAdminUser = this.employerUserRepository.save(oldAdminUser);

				EmployerUserRequestDto adminUserRequest = EmployerUserRequestDto.builder()
																				.userVerificationAt(oldAdminUser.getUserVerificationAt())
																				.designation(oldAdminUser.getDesignation())
																				.active(oldAdminUser.getActive())
																				.adminUser(false)
																				.build();
				EmployerUserEntityBuilder employerUseraEntityBuilder1 = new EmployerUserEntityBuilder();
				employerUseraEntityBuilder1.setUpdatedBy(user);
				employerUseraEntityBuilder1.setUpdatedOrganization(organization);
				employerUseraEntityBuilder1.setEmployerId(oldAdminUser.getEmployerId());
				employerUseraEntityBuilder1.setInactiveReasonId(oldAdminUser.getInactiveReasonId());
				employerUseraEntityBuilder1
						.setUserVerificationMethodId(oldAdminUser.getUserVerificationMethodId());
				employerUseraEntityBuilder1.setUserPersonGeneralId(oldAdminUser.getUserPersonGeneralId());
				employerUseraEntityBuilder1.setUserId(oldAdminUser.getUserId());
				oldAdminUser = employerUseraEntityBuilder1.buildUpdateEntity(adminUserRequest, oldAdminUser);
				employerUseraEntityBuilder1.initUpdatedBy(oldAdminUser);
				employerUseraEntityBuilder1.initUpdatedOrganization(oldAdminUser);
				oldAdminUser = this.employerUserRepository.save(oldAdminUser);
				
				// clones adminUser's person_general_details
				PersonGeneralCloneEntityBuilder personGeneralCloneEntityBuilder1 = new PersonGeneralCloneEntityBuilder();
				personGeneralCloneEntityBuilder1.setCreatedBy(user);
				personGeneralCloneEntityBuilder1.setCreatedOrganization(organization);
				PersonGeneral personGeneralClone1 = personGeneralCloneEntityBuilder1
						.buildDestinationEntity(oldAdminUser.getUserPersonGeneralId());
				personGeneralClone1 = this.personGeneralRepository.save(personGeneralClone1);

				// clones adminUser's person_general_address details --> for history purpose
				List<PersonGeneralAddress> personGeneralAddressList = this.personGeneralAddressValidator
						.validateByPersonGeneralId(oldAdminUser.getUserPersonGeneralId().getId());
				if(personGeneralAddressList != null) {
					for (PersonGeneralAddress itm : personGeneralAddressList) {
						PersonGeneralAddressCloneEntityBuilder personGeneralAddressCloneEntityBuilder1 = new PersonGeneralAddressCloneEntityBuilder();
						personGeneralAddressCloneEntityBuilder1.setPersonGeneral(personGeneralClone1);
						personGeneralAddressCloneEntityBuilder1.setCreatedBy(user);
						personGeneralAddressCloneEntityBuilder1.setCreatedOrganization(organization);
						PersonGeneralAddress personGeneralAddressClone1 = personGeneralAddressCloneEntityBuilder1
								.buildDestinationEntity(itm);
						this.personGeneralAddressRepository.save(personGeneralAddressClone1);
					}
				}

				// clones adminUser's person_general_contact details --> for history purpose
				List<PersonGeneralContact> personGeneralContactList = this.personGeneralContactValidator
						.validateByPersonGeneralId(oldAdminUser.getUserPersonGeneralId().getId());
				if(personGeneralContactList != null) {
					for (PersonGeneralContact itm : personGeneralContactList) {
						PersonGeneralContactCloneEntityBuilder personGeneralContactCloneEntityBuilder1 = new PersonGeneralContactCloneEntityBuilder();
						personGeneralContactCloneEntityBuilder1.setPersonGeneral(personGeneralClone1);
						personGeneralContactCloneEntityBuilder1.setCreatedBy(user);
						personGeneralContactCloneEntityBuilder1.setCreatedOrganization(organization);
						PersonGeneralContact personGeneralContactClone1 = personGeneralContactCloneEntityBuilder1
								.buildDestinationEntity(itm);
						this.personGeneralContactRepository.save(personGeneralContactClone1);
					}
				}

				// clones adminUser's person_general_nic details --> for history purpose
				List<PersonGeneralNic> personGeneralNicList = this.personGeneralNicValidator
						.validateByPersonGeneralId(oldAdminUser.getUserPersonGeneralId().getId());
				if(personGeneralNicList != null) {
					for (PersonGeneralNic itm : personGeneralNicList) {
						PersonGeneralNicCloneEntityBuilder personGeneralNicCloneEntityBuilder1 = new PersonGeneralNicCloneEntityBuilder();
						personGeneralNicCloneEntityBuilder1.setPersonGeneral(personGeneralClone1);
						personGeneralNicCloneEntityBuilder1.setCreatedBy(user);
						personGeneralNicCloneEntityBuilder1.setCreatedOrganization(organization);
						PersonGeneralNic personGeneralNicClone1 = personGeneralNicCloneEntityBuilder1
								.buildDestinationEntity(itm);
						this.personGeneralNicRepository.save(personGeneralNicClone1);
					}
				}
				// clones adminUser's person_general_passport details --> for history purpose
				List<PersonGeneralPassport> personGeneralPassportList = this.personGeneralPassportValidator
						.validateByPersonGeneralId(oldAdminUser.getUserPersonGeneralId().getId());
				if(personGeneralPassportList != null) {
					for (PersonGeneralPassport itm : personGeneralPassportList) {
						PersonGeneralPassportCloneEntityBuilder personGeneralPassportCloneEntityBuilder1 = new PersonGeneralPassportCloneEntityBuilder();
						personGeneralPassportCloneEntityBuilder1.setPersonGeneral(personGeneralClone1);
						personGeneralPassportCloneEntityBuilder1.setCreatedBy(user);
						personGeneralPassportCloneEntityBuilder1.setCreatedOrganization(organization);
						PersonGeneralPassport personGeneralPassportClone1 = personGeneralPassportCloneEntityBuilder1
								.buildDestinationEntity(itm);
						this.personGeneralPassportRepository.save(personGeneralPassportClone1);
					}
				}
				// creating employer_interim_user for old admin_user
				EmployerInterimUserRequestDto employerInterimUserRequestDto1 = EmployerInterimUserRequestDto.builder()
						.userVerificationAt(oldAdminUser.getUserVerificationAt()).active(oldAdminUser.getActive())
						.adminUser(false).designation(oldAdminUser.getDesignation()).build();
				EmployerInterimUserEntityBuilder employerInterimUserEntityBuilder1 = new EmployerInterimUserEntityBuilder();
				employerInterimUserEntityBuilder1.setCreatedBy(user);
				employerInterimUserEntityBuilder1.setCreatedOrganization(organization);
				employerInterimUserEntityBuilder1.setUserId(oldAdminUser.getUserId());
				employerInterimUserEntityBuilder1.setInactiveReasonId(oldAdminUser.getInactiveReasonId());
				employerInterimUserEntityBuilder1
						.setUserVerificationMethodId(oldAdminUser.getUserVerificationMethodId());
				employerInterimUserEntityBuilder1.setUserPersonGeneralId(personGeneralClone1);
				EmployerInterimUser employerInterimUser1 = employerInterimUserEntityBuilder1
						.buildCreateEntity(employerInterimUserRequestDto1, null);
				employerInterimUserEntityBuilder1.initCreatedBy(employerInterimUser1);
				employerInterimUserEntityBuilder1.initCreatedOrganization(employerInterimUser1);
				employerInterimUser1 = this.employerInterimUserRepository.save(employerInterimUser1);

				// creating employe_user_history for updated oldAdminUser
				EmployerUserHistoryEntityBuilder employerUserHistoryEntityBuilder1 = new EmployerUserHistoryEntityBuilder();
				employerUserHistoryEntityBuilder1.setCreatedBy(user);
				employerUserHistoryEntityBuilder1.setCreatedOrganization(organization);
				employerUserHistoryEntityBuilder1.setEmployerRequestServiceCounterDmuId(employerRequestServiceCounterDmu);
				employerUserHistoryEntityBuilder1.setEmployerInterimUserId(employerInterimUser1);
				employerUserHistoryEntityBuilder1.setEmployerUserId(oldAdminUser);
				EmployerUserHistory employerUserHistory1 = employerUserHistoryEntityBuilder1.buildCreateEntity(null, null);
				employerUserHistoryEntityBuilder1.initCreatedBy(employerUserHistory1);
				employerUserHistoryEntityBuilder1.initCreatedOrganization(employerUserHistory1);
				this.employerUserHistoryRepository.save(employerUserHistory1);
				
				
			}
		}

		requestDto.setUserVerificationAt(requestDto.getUserVerificationAt() != null ? requestDto.getUserVerificationAt()
				: DateUtil.currentTimestamp());
		requestDto.setDesignation(
				requestDto.getDesignation() != null ? requestDto.getDesignation() : employerUser.getDesignation());
		EmployerUserEntityBuilder employerUseraEntityBuilder = new EmployerUserEntityBuilder();
		employerUseraEntityBuilder.setUpdatedBy(user);
		employerUseraEntityBuilder.setUpdatedOrganization(organization);
		employerUseraEntityBuilder.setEmployerId(employerUser.getEmployerId());
		employerUseraEntityBuilder.setInactiveReasonId(mstReason);
		employerUseraEntityBuilder
				.setUserVerificationMethodId(optVerificationMethod.isPresent() ? optVerificationMethod.get() : null);
		employerUseraEntityBuilder.setUserPersonGeneralId(employerUser.getUserPersonGeneralId());
		employerUseraEntityBuilder.setUserId(employerUser.getUserId());
		employerUser = employerUseraEntityBuilder.buildUpdateEntity(requestDto, employerUser);
		employerUseraEntityBuilder.initUpdatedBy(employerUser);
		employerUseraEntityBuilder.initUpdatedOrganization(employerUser);
		employerUser = this.employerUserRepository.save(employerUser);

		PersonGeneral personGeneral = employerUser.getUserPersonGeneralId();
		personGeneral.setTitleId(title);
		personGeneral.setFirstName(req.getPersonGeneralRequest().getFirstName());
		personGeneral.setLastName(req.getPersonGeneralRequest().getLastName());
		personGeneral.setFullName(req.getPersonGeneralRequest().getFullName());
		personGeneral.setNameWithInitials(req.getPersonGeneralRequest().getNameWithInitials());
		personGeneral.setGender(req.getPersonGeneralRequest().getGender());
		personGeneral.setDob(req.getPersonGeneralRequest().getDob());
		personGeneral = this.personGeneralRepository.save(personGeneral);
		// for history purpose --> clones person_general record
		PersonGeneralCloneEntityBuilder personGeneralCloneEntityBuilder = new PersonGeneralCloneEntityBuilder();
		personGeneralCloneEntityBuilder.setCreatedBy(user);
		personGeneralCloneEntityBuilder.setCreatedOrganization(organization);
		PersonGeneral personGeneralClone = personGeneralCloneEntityBuilder.buildDestinationEntity(personGeneral);
		personGeneralClone = this.personGeneralRepository.save(personGeneralClone);

		EmployerInterimUserRequestDto employerInterimUserRequestDto = EmployerInterimUserRequestDto.builder()
				.userVerificationAt(employerUser.getUserVerificationAt()).active(employerUser.getActive())
				.adminUser(employerUser.getAdminUser()).designation(employerUser.getDesignation()).build();
		EmployerInterimUserEntityBuilder employerInterimUserEntityBuilder = new EmployerInterimUserEntityBuilder();
		employerInterimUserEntityBuilder.setCreatedBy(user);
		employerInterimUserEntityBuilder.setCreatedOrganization(organization);
		employerInterimUserEntityBuilder.setUserId(employerUser.getUserId());
		employerInterimUserEntityBuilder.setInactiveReasonId(employerUser.getInactiveReasonId());
		employerInterimUserEntityBuilder.setUserVerificationMethodId(employerUser.getUserVerificationMethodId());
		employerInterimUserEntityBuilder.setUserPersonGeneralId(personGeneralClone);
		EmployerInterimUser employerInterimUser = employerInterimUserEntityBuilder
				.buildCreateEntity(employerInterimUserRequestDto, null);
		employerInterimUserEntityBuilder.initCreatedBy(employerInterimUser);
		employerInterimUserEntityBuilder.initCreatedOrganization(employerInterimUser);
		employerInterimUser = this.employerInterimUserRepository.save(employerInterimUser);

		PersonGeneralAddress personGeneralAddress;
		if (req.getAddressRequest() != null && req.getAddressRequest().getAddressDetais() != null && req.getAddressRequest().getAddressDetais().getAddress1() != null) {
			if (req.getPersonGeneralAddressId() != null) {
				Optional<PersonGeneralAddress> optPersonGeneralAddress = this.personGeneralAddressValidator
						.validate(req.getPersonGeneralAddressId());
				personGeneralAddress = optPersonGeneralAddress.isPresent() ?  optPersonGeneralAddress.get() : null;
			}
			else {
				personGeneralAddress = new PersonGeneralAddress();
				personGeneralAddress.setActive(req.getAddressRequest().isActive());
				personGeneralAddress.setCreatedAt(DateUtil.currentTimestamp());
				personGeneralAddress.setCreatedBy(user);
				personGeneralAddress.setCreatedOrganizationId(organization);
				personGeneralAddress.setReferenceTableId(mstPersonGeneralReferenceTable);
			}
				MstDistrict mstDistrict;
				if (req.getAddressRequest().getAddressDetais().getDistrictId() != null) {
					Optional<MstDistrict> optDistrict = this.mstDistrictValidator
							.validate(req.getAddressRequest().getAddressDetais().getDistrictId());
					if (optDistrict.isPresent()) {
						mstDistrict = optDistrict.get();
					} else {
						mstDistrict = null;
					}
				} else {
					mstDistrict = null;
				}
				MstCountry mstCountry;
				if(req.getAddressRequest().getAddressDetais().getCountryId() != null) {
					Optional<MstCountry> optCountry = this.mstCountryValidator.validate(req.getAddressRequest().getAddressDetais().getCountryId());
					mstCountry = optCountry.isPresent() ? optCountry.get() : null;
				}
				else {
					mstCountry = null;
				}
				Address address = personGeneralAddress.getAddressId();
				if (address == null) {
					address = new Address();
				}
				address.setAddress1(req.getAddressRequest().getAddressDetais().getAddress1());
				address.setAddress2(req.getAddressRequest().getAddressDetais().getAddress2());
				address.setAddress3(req.getAddressRequest().getAddressDetais().getAddress3());
				address.setCity(req.getAddressRequest().getAddressDetais().getCity());
				address.setDistrictId(mstDistrict);
				address.setPostalCode(req.getAddressRequest().getAddressDetais().getPostalCode());
				address.setNote(NoteFormatter.getFormattedNote((personGeneralAddress.getAddressId() != null ? personGeneralAddress.getAddressId().getNote() : null), req.getAddressRequest().getAddressDetais().getNote(), user.getDisplayName()));
				address.setCountryId(mstCountry);
				if(address.getId() == null) {
					address = this.addressRepository.save(address);
					personGeneralAddress.setAddressId(address);
				}
				personGeneralAddress.setPersonGeneralId(personGeneral);
				personGeneralAddress.setUpdatedAt(DateUtil.currentTimestamp());
				personGeneralAddress.setUpdatedBy(user);
				personGeneralAddress.setUpdatedOrganizationId(organization);
				personGeneralAddress = this.personGeneralAddressRepository.save(personGeneralAddress);
				// for history purpose --> clones person_general_address
				PersonGeneralAddressCloneEntityBuilder personGeneralAddressCloneEntityBuilder = new PersonGeneralAddressCloneEntityBuilder();
				personGeneralAddressCloneEntityBuilder.setPersonGeneral(personGeneralClone);
				personGeneralAddressCloneEntityBuilder.setCreatedBy(user);
				personGeneralAddressCloneEntityBuilder.setCreatedOrganization(organization);
				PersonGeneralAddress personGeneralAddressClone = personGeneralAddressCloneEntityBuilder
						.buildDestinationEntity(personGeneralAddress);
				this.personGeneralAddressRepository.save(personGeneralAddressClone);

			
		}

		if (req.getExistingContacts() != null) {
			for (PersonGeneralContactRequestChild7 item : req.getExistingContacts()) {
				Optional<PersonGeneralContact> optPersanGeneralContact = this.personGeneralContactValidator
						.validate(item.getId());
				if (optPersanGeneralContact.isPresent()) {
					PersonGeneralContact personGeneralContact = optPersanGeneralContact.get();
					ContactInfoRequestChild2 contactReq = item.getContactInfoRequest();
					this.contactInfoService.update(contactReq, personGeneralContact.getContactInfoId().getId());
					personGeneralContact.setPersonGeneralId(personGeneral);
					personGeneralContact.setContactInfoId(personGeneralContact.getContactInfoId());
					personGeneralContact.setActive(item.isActive());
					personGeneralContact.setUpdatedAt(DateUtil.currentTimestamp());
					personGeneralContact.setUpdatedBy(user);
					personGeneralContact.setUpdatedOrganizationId(organization);
					personGeneralContact = this.personGeneralContactRepository.save(personGeneralContact);
					// for history purpose --> clones person_general_contact
					PersonGeneralContactCloneEntityBuilder personGeneralContactCloneEntityBuilder = new PersonGeneralContactCloneEntityBuilder();
					personGeneralContactCloneEntityBuilder.setPersonGeneral(personGeneralClone);
					personGeneralContactCloneEntityBuilder.setCreatedBy(user);
					personGeneralContactCloneEntityBuilder.setCreatedOrganization(organization);
					PersonGeneralContact personGeneralContactClone = personGeneralContactCloneEntityBuilder
							.buildDestinationEntity(personGeneralContact);
					this.personGeneralContactRepository.save(personGeneralContactClone);
				}

			}
		}

		if (req.getNewContacts() != null) {
			for (PersonGeneralContactRequestChild4 item : req.getNewContacts()) {
				ContactInfoResponseDto contactResponse = this.contactInfoService.create(item.getContactInfoRequest());
				Optional<ContactInfo> optContactInfo = this.contactInfoValidator.validate(contactResponse.getId());
				ContactInfo contact = optContactInfo.isPresent() ? optContactInfo.get() : null;
				PersonGeneralContactRequestDto contactRequestDto = PersonGeneralContactRequestDto.builder()
						.active(item.isActive()).build();
				PersonGeneralContactEntityBuilder personGeneralContactEntityBuilder = new PersonGeneralContactEntityBuilder();
				personGeneralContactEntityBuilder.setCreatedBy(user);
				personGeneralContactEntityBuilder.setCreatedOrganization(organization);
				personGeneralContactEntityBuilder.setContactInfoId(contact);
				personGeneralContactEntityBuilder.setPersonGeneralId(personGeneral);
				personGeneralContactEntityBuilder.setReferenceTableId(mstPersonGeneralReferenceTable);
				PersonGeneralContact personGeneralContact = personGeneralContactEntityBuilder
						.buildCreateEntity(contactRequestDto, null);
				personGeneralContactEntityBuilder.initCreatedBy(personGeneralContact);
				personGeneralContactEntityBuilder.initCreatedOrganization(personGeneralContact);
				personGeneralContact = this.personGeneralContactRepository.save(personGeneralContact);
				// for history purpose --> clones person_general_contact
				PersonGeneralContactCloneEntityBuilder personGeneralContactCloneEntityBuilder = new PersonGeneralContactCloneEntityBuilder();
				personGeneralContactCloneEntityBuilder.setPersonGeneral(personGeneralClone);
				personGeneralContactCloneEntityBuilder.setCreatedBy(user);
				personGeneralContactCloneEntityBuilder.setCreatedOrganization(organization);
				PersonGeneralContact personGeneralContactClone = personGeneralContactCloneEntityBuilder
						.buildDestinationEntity(personGeneralContact);
				this.personGeneralContactRepository.save(personGeneralContactClone);

			}
		}
		
		PersonGeneralNic personGeneralNic;
		if (req.getNicDetails() != null && req.getNicDetails().getNicNo() != null) {
			
			if (req.getPersonGeneralNicId() != null) {
				Optional<PersonGeneralNic> optPersonGeneralNic = this.personGeneralNicValidator
						.validate(req.getPersonGeneralNicId());
				personGeneralNic = optPersonGeneralNic.isPresent() ?  optPersonGeneralNic.get() : null;
				
			}	
			else {
				personGeneralNic = new PersonGeneralNic();
				personGeneralNic.setActive(req.getNicDetails().isActive());
				personGeneralNic.setCreatedAt(DateUtil.currentTimestamp());
				personGeneralNic.setCreatedBy(user);
				personGeneralNic.setCreatedOrganizationId(organization);
				personGeneralNic.setReferenceTableId(mstPersonGeneralReferenceTable);
			}
				
				Optional<MstIdentityNicType> optNicType = this.mstIdentityNicTypeValidator
						.validateByCode(req.getNicDetails().getCode());

				personGeneralNic.setPersonGeneralId(personGeneral);
				personGeneralNic.setNicNo(req.getNicDetails().getNicNo());
				personGeneralNic.setNicTypeId(optNicType.isPresent() ? optNicType.get() : null);
				personGeneralNic.setUpdatedAt(DateUtil.currentTimestamp());
				personGeneralNic.setUpdatedBy(user);
				personGeneralNic.setUpdatedOrganizationId(organization);
				personGeneralNic = this.personGeneralNicRepository.save(personGeneralNic);
				// for history purpose --> clones person_general_nic
				PersonGeneralNicCloneEntityBuilder personGeneralNicCloneEntityBuilder = new PersonGeneralNicCloneEntityBuilder();
				personGeneralNicCloneEntityBuilder.setPersonGeneral(personGeneralClone);
				personGeneralNicCloneEntityBuilder.setCreatedBy(user);
				personGeneralNicCloneEntityBuilder.setCreatedOrganization(organization);
				PersonGeneralNic personGeneralNicClone = personGeneralNicCloneEntityBuilder
						.buildDestinationEntity(personGeneralNic);
				personGeneralNicClone = this.personGeneralNicRepository.save(personGeneralNicClone);
			}
		

		PersonGeneralPassport personGeneralPassport;
		if (req.getPersonGeneralPassportRequest() != null && req.getPersonGeneralPassportRequest().getPassportNo() != null) {
			if (req.getPersonGeneralPassportId() != null) {
				Optional<PersonGeneralPassport> optPersonGeneralPassport = this.personGeneralPassportValidator
						.validate(req.getPersonGeneralPassportId());
				personGeneralPassport = optPersonGeneralPassport.isPresent() ?  optPersonGeneralPassport.get() : null;
				
			}	
			else {
				personGeneralPassport = new PersonGeneralPassport();
				personGeneralPassport.setActive(req.getPersonGeneralPassportRequest().isActive());
				personGeneralPassport.setCreatedAt(DateUtil.currentTimestamp());
				personGeneralPassport.setCreatedBy(user);
				personGeneralPassport.setCreatedOrganizationId(organization);
				personGeneralPassport.setReferenceTableId(mstPersonGeneralReferenceTable);
			}
				
			Optional<MstCountry> optCountry = this.mstCountryValidator
					.validate(req.getPersonGeneralPassportRequest().getCountryId());

				personGeneralPassport.setPersonGeneralId(personGeneral);
				personGeneralPassport.setPassportNo(req.getPersonGeneralPassportRequest().getPassportNo());
				personGeneralPassport.setDateIssued(req.getPersonGeneralPassportRequest().getDateIssued());
				personGeneralPassport.setDateExpiry(req.getPersonGeneralPassportRequest().getDateExpiry());
				personGeneralPassport.setCountryId(optCountry.isPresent() ? optCountry.get() : null);
				personGeneralPassport.setUpdatedAt(DateUtil.currentTimestamp());
				personGeneralPassport.setUpdatedBy(user);
				personGeneralPassport.setUpdatedOrganizationId(organization);
				personGeneralPassport = this.personGeneralPassportRepository.save(personGeneralPassport);
				// for history purpose --> clones person_general_passport
				PersonGeneralPassportCloneEntityBuilder personGeneralPassportCloneEntityBuilder = new PersonGeneralPassportCloneEntityBuilder();
				personGeneralPassportCloneEntityBuilder.setPersonGeneral(personGeneralClone);
				personGeneralPassportCloneEntityBuilder.setCreatedBy(user);
				personGeneralPassportCloneEntityBuilder.setCreatedOrganization(organization);
				PersonGeneralPassport personGeneralPassportClone = personGeneralPassportCloneEntityBuilder
						.buildDestinationEntity(personGeneralPassport);
				this.personGeneralPassportRepository.save(personGeneralPassportClone);
			
		}

	

		if (req.getEmployerUserMemberGroupRequestList() != null) {
			List<EmployerUserMemberGroup> existingUserMemberGroupList = this.employerUserMemberGroupValidator
					.validateByEmployerUserId(employerUser.getId());
			if (existingUserMemberGroupList != null) {
				for (EmployerUserMemberGroup item : existingUserMemberGroupList) {
					this.employerUserMemberGroupRepository.delete(item);
				}
			}
			for (EmployerUserMemberGroupRequestChild1 item : req.getEmployerUserMemberGroupRequestList()) {
				Optional<MstEmployerMemberGroup> optMemberGroup = this.mstEmployerMemberGroupValidator
						.validateByCode(item.getMemberGroupCode());
				EmployerUserMemberGroupEntityBuilder employerUserGroupEntityBuilder = new EmployerUserMemberGroupEntityBuilder();
				employerUserGroupEntityBuilder.setEmployerUserId(employerUser);
				employerUserGroupEntityBuilder
						.setMemberGroupId(optMemberGroup.isPresent() ? optMemberGroup.get() : null);
				employerUserGroupEntityBuilder.setCreatedBy(user);
				employerUserGroupEntityBuilder.setCreatedOrganization(organization);
				EmployerUserMemberGroup employerUserMemberGroup = employerUserGroupEntityBuilder.buildCreateEntity(null,
						null);
				employerUserGroupEntityBuilder.initCreatedBy(employerUserMemberGroup);
				employerUserGroupEntityBuilder.initCreatedOrganization(employerUserMemberGroup);
				employerUserMemberGroup = this.employerUserMemberGroupRepository.save(employerUserMemberGroup);

				EmployerInterimUserMemberGroupEntityBuilder interimUserMemberGroupEntityBuilder = new EmployerInterimUserMemberGroupEntityBuilder();
				interimUserMemberGroupEntityBuilder.setCreatedBy(user);
				interimUserMemberGroupEntityBuilder.setCreatedOrganization(organization);
				interimUserMemberGroupEntityBuilder.setEmployerInterimUserId(employerInterimUser);
				interimUserMemberGroupEntityBuilder
						.setMemberGroupId(optMemberGroup.isPresent() ? optMemberGroup.get() : null);
				EmployerInterimUserMemberGroup interimMemberGroup = interimUserMemberGroupEntityBuilder
						.buildCreateEntity(null, null);
				interimUserMemberGroupEntityBuilder.initCreatedBy(interimMemberGroup);
				interimUserMemberGroupEntityBuilder.initCreatedOrganization(interimMemberGroup);
				this.employerInterimUserMemberGroupRepository.save(interimMemberGroup);
			}
		}

		

		EmployerUserHistoryEntityBuilder employerUserHistoryEntityBuilder = new EmployerUserHistoryEntityBuilder();
		employerUserHistoryEntityBuilder.setCreatedBy(user);
		employerUserHistoryEntityBuilder.setCreatedOrganization(organization);
		employerUserHistoryEntityBuilder.setEmployerRequestServiceCounterDmuId(employerRequestServiceCounterDmu);
		employerUserHistoryEntityBuilder.setEmployerInterimUserId(employerInterimUser);
		employerUserHistoryEntityBuilder.setEmployerUserId(employerUser);
		EmployerUserHistory employerUserHistory = employerUserHistoryEntityBuilder.buildCreateEntity(null, null);
		employerUserHistoryEntityBuilder.initCreatedBy(employerUserHistory);
		employerUserHistoryEntityBuilder.initCreatedOrganization(employerUserHistory);
		this.employerUserHistoryRepository.save(employerUserHistory);

		if (req.getDocumentList() != null) {
			DocumentUpdateRequest documentUpdateRequest = new DocumentUpdateRequest();
			documentUpdateRequest.setModuleCode(MstModuleEnum.EMP_MNG.getCode());
			List<Long> documentList = new ArrayList<>();
			for (EmployerDocumentRequest itm : req.getDocumentList()) {
				documentList.add(itm.getDocumentUploadedId());
			}
			documentUpdateRequest.setDocumentList(documentList);
			// store newly added documents to alfesko
			List<DocumentUploadedResponseDto> documentUploadedResponsesList = this.documentService
					.updateDmsRefParentRef(documentUpdateRequest);
			// insert records to employer_document table
			for (DocumentUploadedResponseDto itm : documentUploadedResponsesList) {
				Optional<DocumentUploaded> document = this.documentUploadedValidator.validate(itm.getId());
				EmployerDocumentEntityBuilder documentEntityBuilder = new EmployerDocumentEntityBuilder();
				documentEntityBuilder.setDocumentUploadedId(document.isPresent() ? document.get() : null);
				documentEntityBuilder.setEmployerId(employerUser.getEmployerId());
				EmployerDocument employerDocument = documentEntityBuilder.buildCreateEntity(null, null);
				this.employerDocumentRepository.save(employerDocument);
			}
		}

		TransactionEntityBuilder transactionEntityBuilder = new TransactionEntityBuilder();
		transactionEntityBuilder.setCreatedBy(user);
		transactionEntityBuilder.setCreatedOrganization(organization);
		transactionEntityBuilder.setActionId(optTxnAction.isPresent() ? optTxnAction.get() : null);
		Transaction transaction = transactionEntityBuilder.buildCreateEntity(null, null);
		transactionEntityBuilder.initCreatedBy(transaction);
		transactionEntityBuilder.initCreatedOrganization(transaction);
		transaction = this.transactionRepository.save(transaction);

		TxnEmployerEntityBuilder txnEmployerEntityBuilder = new TxnEmployerEntityBuilder();
		txnEmployerEntityBuilder.setTransactionId(transaction);
		txnEmployerEntityBuilder.setEmployerUserId(employerUser);
		txnEmployerEntityBuilder.setEmployerId(employerUser.getEmployerId());
		TxnEmployer txnEmployer = txnEmployerEntityBuilder.buildCreateEntity(null, null);
		this.txnEmployerRepository.save(txnEmployer);

		return this.employerUserResponseDtoBuilder.buildUpdateResponseDto(employerUser);
	}

	@MethodLogging
	@Override
	public EmployerUserPageLoadRespDto readByRefNo(Long id) throws ApplicationException {
		Optional<Employer> optEmployer = this.employerValidator.validateByRefNo(id);
		Employer employer = new Employer();
		if (optEmployer.isPresent()) {
			employer = optEmployer.get();
		}
		Optional<MstConfiguration> optConfiguration = this.mstConfigurationValidator.validate(MST_CONFIGURATION_ID);
		MstConfiguration configuration = optConfiguration.isPresent() ? optConfiguration.get() : null;
		Integer maxCount = 0;
		if (configuration != null) {
			maxCount = configuration.getMaxEmployerUsers();
		}
		EmployerUserPageLoadRespDto result = this.employerUserCreatePageLoadDao.getByEmployerId(employer.getId(),
				maxCount);
		if (!ObjectUtils.isEmpty(result)) {
			return result;
		}
		return null;
	}
}
