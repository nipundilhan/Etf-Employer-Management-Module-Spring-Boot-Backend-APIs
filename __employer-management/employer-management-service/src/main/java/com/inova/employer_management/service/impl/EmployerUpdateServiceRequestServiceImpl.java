package com.inova.employer_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.inova.applogger.util.MethodLogging;
import com.inova.common.request.BpmProcessesInstancesRequest;
import com.inova.common.service.OtpManageService;
import com.inova.common.service.ToDoTaskListService;
import com.inova.config.EmployerManagementConfig;
import com.inova.config.PrefixConfig;
import com.inova.dao.entities.ContactInfo;
import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerGeneralContact;
import com.inova.dao.entities.EmployerInterim;
import com.inova.dao.entities.EmployerInterimGeneralContact;
import com.inova.dao.entities.EmployerRequestUpdate;
import com.inova.dao.entities.MstContactType;
import com.inova.dao.entities.MstEmployerIndustryType;
import com.inova.dao.entities.MstEmployerInterimReferenceTable;
import com.inova.dao.entities.MstEmployerNatureBusiness;
import com.inova.dao.entities.MstEmployerOrganizationType;
import com.inova.dao.entities.MstEmployerStatus;
import com.inova.dao.entities.MstEmployerType;
import com.inova.dao.entities.MstLanguage;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstSbu;
import com.inova.dao.entities.MstServiceRequestSource;
import com.inova.dao.entities.MstServiceRequestStatus;
import com.inova.dao.entities.MstServiceRequestType;
import com.inova.dao.entities.Organization;
import com.inova.dao.entities.ServiceRequest;
import com.inova.dao.entities.ServiceRequestDocument;
import com.inova.dao.entities.ServiceRequestEmployerUpdate;
import com.inova.dao.entities.ServiceRequestStatusHistory;
import com.inova.dao.entities.User;
import com.inova.dao.entities.build.ContactInfoEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimEntityBuilder;
import com.inova.dao.entities.build.EmployerInterimGeneralContactEntityBuilder;
import com.inova.dao.entities.build.EmployerRequestGeneralContactAddupdateEntityBuilder;
import com.inova.dao.entities.build.EmployerRequestUpdateEntityBuilder;
import com.inova.dao.entities.build.ServiceRequestDocumentEntityBuilder;
import com.inova.dao.entities.build.ServiceRequestEmployerUpdateEntityBuilder;
import com.inova.dao.entities.build.ServiceRequestEntityBuilder;
import com.inova.dao.entities.build.ServiceRequestStatusHistoryEntityBuilder;
import com.inova.dao.repositories.ContactInfoRepository;
import com.inova.dao.repositories.EmployerInterimGeneralContactRepository;
import com.inova.dao.repositories.EmployerInterimRepository;
import com.inova.dao.repositories.EmployerRequestGeneralContactAddupdateRepository;
import com.inova.dao.repositories.EmployerRequestUpdateRepository;
import com.inova.dao.repositories.ServiceRequestDocumentRepository;
import com.inova.dao.repositories.ServiceRequestEmployerUpdateRepository;
import com.inova.dao.repositories.ServiceRequestRepository;
import com.inova.dao.repositories.ServiceRequestStatusHistoryRepository;
import com.inova.dao.validate.DocumentUploadedValidator;
import com.inova.dao.validate.EmployerGeneralContactValidator;
import com.inova.dao.validate.EmployerValidator;
import com.inova.dao.validate.MstContactTypeValidator;
import com.inova.dao.validate.MstEmployerIndustryTypeValidator;
import com.inova.dao.validate.MstEmployerInterimReferenceTableValidator;
import com.inova.dao.validate.MstEmployerNatureBusinessValidator;
import com.inova.dao.validate.MstEmployerOrganizationTypeValidator;
import com.inova.dao.validate.MstEmployerStatusValidator;
import com.inova.dao.validate.MstEmployerTypeValidator;
import com.inova.dao.validate.MstLanguageValidator;
import com.inova.dao.validate.MstPriorityValidator;
import com.inova.dao.validate.MstSbuValidator;
import com.inova.dao.validate.MstServiceRequestSourceValidator;
import com.inova.dao.validate.MstServiceRequestStatusValidator;
import com.inova.dao.validate.MstServiceRequestTypeValidator;
import com.inova.dao.validate.OrganizationValidator;
import com.inova.dao.validate.UserValidator;
import com.inova.document.request.DocumentUpdateRequest;
import com.inova.document.service.DocumentService;
import com.inova.dto.enums.EmployerVerificationEpfBulkItemEnum;
import com.inova.employer_management.service.EmployerUpdateServiceRequestService;
import com.inova.enums.MstContactTypeEnum;
import com.inova.enums.MstModuleEnum;
import com.inova.enums.MstOtpCodeEnum;
import com.inova.enums.MstSbuEnum;
import com.inova.enums.MstServiceRequestSourceEnum;
import com.inova.enums.MstServiceRequestStatusEnum;
import com.inova.enums.MstServiceRequestTypeEnum;
import com.inova.etfb.employer_management.response.EmployerUpdateServiceRequestResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.request.DocumentUploadedRequestChild2;
import com.inova.request.EmployerDocumentRequest;
import com.inova.request.EmployerUpdateServiceRequestContactInfoRequest;
import com.inova.request.EmployerUpdateServiceRequestEmployerInterimRequest;
import com.inova.request.EmployerUpdateServiceRequestRequest;
import com.inova.request.EmployerUpdateServiceRequestUpdateRequest;
import com.inova.request.OtpGeneratedRequestChild4;
import com.inova.request.dto.ContactInfoRequestDto;
import com.inova.request.dto.EmployerInterimGeneralContactRequestDto;
import com.inova.request.dto.EmployerInterimRequestDto;
import com.inova.request.dto.EmployerRequestGeneralContactAddupdateRequestDto;
import com.inova.request.dto.EmployerRequestUpdateRequestDto;
import com.inova.request.dto.ServiceRequestDocumentRequestDto;
import com.inova.request.dto.ServiceRequestEmployerUpdateRequestDto;
import com.inova.request.dto.ServiceRequestRequestDto;
import com.inova.request.dto.ServiceRequestStatusHistoryRequestDto;
import com.inova.request.dto.build.EmployerUpdateServiceRequestEmployerInterimRequestDtoBuilder;
import com.inova.request.dto.build.EmployerUpdateServiceRequestUpdateRequestDtoBuilder;
import com.inova.response.dto.DocumentUploadedResponseDto;
import com.inova.response.dto.EmployerInterimResponseDto;
import com.inova.response.dto.EmployerRequestUpdateResponseDto;
import com.inova.response.dto.ServiceRequestResponseDto;
import com.inova.response.dto.ServiceRequestStatusHistoryResponseDto;
import com.inova.response.dto.build.EmployerInterimResponseDtoBuilder;
import com.inova.response.dto.build.EmployerRequestUpdateResponseDtoBuilder;
import com.inova.response.dto.build.ServiceRequestResponseDtoBuilder;
import com.inova.response.dto.build.ServiceRequestStatusHistoryResponseDtoBuilder;
import com.inova.util.OrganizationUtil;
import com.inova.util.RandomNumberGenerator;
import com.inova.util.RefNoUtil;
import com.inova.util.UserUtil;

@Service
public class EmployerUpdateServiceRequestServiceImpl implements EmployerUpdateServiceRequestService {
		
	public static final String SERVICE_REQUEST_SOURCE_CODE = MstServiceRequestSourceEnum.EMPPORT.getCode();
	public static final String SERVICE_REQUEST_TYPE_CODE =  MstServiceRequestTypeEnum.UPDEMP.getCode();
	public static final String SERVICE_REQUEST_STATUS_CODE = MstServiceRequestStatusEnum.OPN.getCode();
	public static final String SERVICE_REQUEST_SBU_CODE = MstSbuEnum.EMP_REL.getCode();
	public static final String VERIFICATION_EMAIL_TYPE_CODE = MstContactTypeEnum.EM.getCode();
	public static final String VERIFICATION_MOBILE_TYPE_CODE = MstContactTypeEnum.MB.getCode();
	public static final String UPDATE_EMPLOYER_OTP_CODE = MstOtpCodeEnum.CEMPPORT.getCode();
	public static final Long SERVICE_REQUEST_REFERENCE_TABLE_ID = 1l;
	public static final Long DEFAULT_PRIORITY_ID = 1l;
	public static final Boolean SERVICE_REQUEST_HOLD = false;
	public static final Boolean SERVICE_REQUEST_APPROVED = false;
	public static final Boolean SERVICE_REQUEST_APPROVE_REQUIRED = true;
	public static final String EMPLOYER_LOGO_DOCUMENT_UPLOAD_MODULE = MstModuleEnum.EMP_MNG.getCode();
	public static final String EMPLOYER_DOCUMENT_UPLOAD_MODULE = MstModuleEnum.EMP_MNG.getCode();
	
	@Autowired
	private EmployerManagementConfig employerConfig;
	@Autowired
	private OtpManageService otpManageService;	
	@Autowired
	private DocumentService documentService;
	@Autowired
	private ToDoTaskListService toDoTaskListService;

	@Autowired
	private UserValidator userValidator;
	@Autowired
	private EmployerValidator employerValidator;
	@Autowired
	private OrganizationValidator organizationValidator;
	@Autowired
	private MstPriorityValidator mstPriorityValidator;
	@Autowired
	private MstServiceRequestSourceValidator mstServiceRequestSourceValidator;
	@Autowired
	private MstServiceRequestTypeValidator mstServiceRequestTypeValidator;
	@Autowired
	private MstServiceRequestStatusValidator mstServiceRequestStatusValidator;
	@Autowired
	private MstSbuValidator mstSbuValidator;
	@Autowired
	private MstEmployerNatureBusinessValidator mstEmployerNatureBusinessValidator;
	@Autowired
	private MstEmployerOrganizationTypeValidator mstEmployerOrganizationTypeValidator;
	@Autowired
	private MstEmployerIndustryTypeValidator mstEmployerIndustryTypeValidator;
	@Autowired
	private MstEmployerInterimReferenceTableValidator mstEmployerInterimReferenceTableValidator;
	@Autowired
	private MstEmployerTypeValidator mstEmployerTypeValidator;
	@Autowired
	private MstEmployerStatusValidator mstEmployerStatusValidator;
	@Autowired
	private MstContactTypeValidator mstContactTypeValidator;
	@Autowired
	private DocumentUploadedValidator documentUploadedValidator;	
	@Autowired
	private EmployerGeneralContactValidator employerGeneralContactValidator;
	@Autowired
	private MstLanguageValidator mstLanguageValidator;
	
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	@Autowired
	private EmployerRequestUpdateRepository employerRequestUpdateRepository;
	@Autowired
	private ServiceRequestEmployerUpdateRepository serviceRequestEmployerUpdateRepository;
	@Autowired
	private EmployerInterimRepository employerInterimRepository;
	@Autowired
	private ServiceRequestStatusHistoryRepository serviceRequestStatusHistoryRepository;
	@Autowired
	private ContactInfoRepository contactInfoRepository;
	@Autowired
	private EmployerInterimGeneralContactRepository employerInterimGeneralContactRepository;
	@Autowired
	private EmployerRequestGeneralContactAddupdateRepository employerRequestGeneralContactAddupdateRepository;
	@Autowired
	private ServiceRequestDocumentRepository serviceRequestDocumentRepository;

	@Autowired
	private UserUtil userUtil;
	@Autowired
	private OrganizationUtil organizationUtil;
	@Autowired
	private RefNoUtil refNoUtil;
	
	@Autowired
	private PrefixConfig prefixConfig;
	
	
	@Autowired
	private EmployerUpdateServiceRequestUpdateRequestDtoBuilder employerUpdateServiceRequestUpdateRequestDtoBuilder;	
	@Autowired
	private EmployerUpdateServiceRequestEmployerInterimRequestDtoBuilder employerUpdateServiceRequestEmployerInterimRequestDtoBuilder;
	@Autowired
	private ServiceRequestResponseDtoBuilder serviceRequestResponseDtoBuilder;	
	@Autowired
	private EmployerInterimResponseDtoBuilder employerInterimResponseDtoBuilder;	
	@Autowired
	private ServiceRequestStatusHistoryResponseDtoBuilder serviceRequestStatusHistoryResponseDtoBuilder;
	@Autowired
	private EmployerRequestUpdateResponseDtoBuilder employerRequestUpdateResponseDtoBuilder;
	

	@Override
	@MethodLogging
	@Transactional(rollbackFor = ApplicationException.class)
	public EmployerUpdateServiceRequestResponseDto create(EmployerUpdateServiceRequestRequest req)
			throws ApplicationException {
// validations
		Optional<User> optionalUser = this.userValidator.validate(this.userUtil.getUserId("jwtToken"));
		User user = optionalUser.isPresent() ? optionalUser.get() : null;
		Optional<Organization> optionalOrganization = this.organizationValidator.validate(this.organizationUtil.getOrganizationId("jwtToken"));
		Organization organization = optionalOrganization.isPresent() ? optionalOrganization.get() : null;
		Optional<Employer> optionalEmployer = employerValidator.validateByRefNo(req.getEmployerRefNo());
		Employer employer = optionalEmployer.isPresent() ? optionalEmployer.get() : null;

		Optional<MstPriority> priorityOptional = mstPriorityValidator.validate(DEFAULT_PRIORITY_ID);
		Optional<MstServiceRequestSource> serviceRequestSourceOptional = mstServiceRequestSourceValidator.validateByCode(SERVICE_REQUEST_SOURCE_CODE);
		Optional<MstServiceRequestType> serviceRequestTypeOptional = mstServiceRequestTypeValidator.validateByCode(SERVICE_REQUEST_TYPE_CODE);
		Optional<MstServiceRequestStatus> serviceRequestStatusOptional = mstServiceRequestStatusValidator.validateByCode(SERVICE_REQUEST_STATUS_CODE);
		Optional<MstSbu> sbuOptional = mstSbuValidator.validateByCode(SERVICE_REQUEST_SBU_CODE);
		Optional<MstEmployerInterimReferenceTable> employerInterimReferenceTableOptional = mstEmployerInterimReferenceTableValidator.validate(SERVICE_REQUEST_REFERENCE_TABLE_ID);
		Optional<MstEmployerNatureBusiness> employerNatureBusinessOptional = mstEmployerNatureBusinessValidator.validate(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getNatureOfBusinessId());
		Optional<MstEmployerOrganizationType> employerOrganizationTypeOptional = mstEmployerOrganizationTypeValidator.validateByCode(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getEmployerOrganizationTypeCode());
		Optional<MstEmployerIndustryType> employerIndustryTypeOptional = mstEmployerIndustryTypeValidator.validate(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getIndustryTypeId());
		Optional<MstEmployerType> employerTypeOptional = mstEmployerTypeValidator.validateByCode(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getEmployerTypeCode());
		Optional<MstEmployerStatus> employerStatusOptional = mstEmployerStatusValidator.validateByCode(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getEmployerStatusCode());
		Optional<MstLanguage> mstLanguage = mstLanguageValidator.validateByCode(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getPreferredLanguageCode());
// employer OTP mobile verification
/*		if (req.getUserMobileOtpDetails() != null) {
			OtpGeneratedRequestChild4 otpVerifyRequest = new OtpGeneratedRequestChild4();
			otpVerifyRequest.setContactValue(req.getUserMobileOtpDetails().getContactValue());
			otpVerifyRequest.setMstOtpCode(UPDATE_EMPLOYER_OTP_CODE);
			otpVerifyRequest.setOtpValue(req.getUserMobileOtpDetails().getOtpValue());
			otpManageService.verifyOTP(otpVerifyRequest);
		} else {
			throw new ApplicationException(employerConfig.getErrorOtpFailed());
		}
*/
		
		
		StringBuilder bpmFormat = new StringBuilder();
		bpmFormat.append(employer.getRefNo());
		bpmFormat.append(",");
		if(employer.getEpfNo() != null && employer.getName() != null) {
			bpmFormat.append(employer.getEpfNo());
			bpmFormat.append(",");
			bpmFormat.append(employer.getName());
		}		
		

		
		ServiceRequestRequestDto serviceRequestRequestDto = ServiceRequestRequestDto.builder()
		.refNo(refNoUtil.getRefNumber(""))
		.prefixRefNo(prefixConfig.getServiceRequest())
		.bpmData(bpmFormat.toString())
		.description(req.getRequestDescription())
		.note(req.getNote()).hold(SERVICE_REQUEST_HOLD).approvalRequired(SERVICE_REQUEST_APPROVE_REQUIRED)
		.approved(SERVICE_REQUEST_APPROVED).build();

//save service request		
		ServiceRequestEntityBuilder serviceRequestEntityBuilder = new ServiceRequestEntityBuilder();
		serviceRequestEntityBuilder.setCreatedBy(user);
		serviceRequestEntityBuilder.setStatusBy(user);
		serviceRequestEntityBuilder.setStatusOrganization(organization);
		serviceRequestEntityBuilder.setOwnerOrganizationId(organization);
		serviceRequestEntityBuilder.setPriorityId(priorityOptional.isPresent() ? priorityOptional.get() : null);
		serviceRequestEntityBuilder.setSourceId(serviceRequestSourceOptional.isPresent() ? serviceRequestSourceOptional.get() : null);
		serviceRequestEntityBuilder.setTypeId(serviceRequestTypeOptional.isPresent() ? serviceRequestTypeOptional.get() : null);
		serviceRequestEntityBuilder.setStatusId(serviceRequestStatusOptional.isPresent() ? serviceRequestStatusOptional.get() : null);
		serviceRequestEntityBuilder.setServiceRequestSbuId(sbuOptional.isPresent() ? sbuOptional.get() : null);		
//		ServiceRequestRequestDto serviceRequestRequestDto = this.createServiceRequestDto(req);
		ServiceRequest serviceRequestSaved = serviceRequestRepository.save(serviceRequestEntityBuilder.buildCreateEntity(serviceRequestRequestDto, null));
		ServiceRequestResponseDto serviceRequestResponseDto = serviceRequestResponseDtoBuilder.buildCreateResponseDto(serviceRequestSaved);

		
		//call jbpm process
		BpmProcessesInstancesRequest bpmProcessesInstancesRequest = new BpmProcessesInstancesRequest();
		bpmProcessesInstancesRequest.setRefNo(serviceRequestSaved.getRefNo());
		this.toDoTaskListService.create(bpmProcessesInstancesRequest);
		
		
//saved service request status history 
		ServiceRequestStatusHistoryEntityBuilder serviceRequestStatusHistoryEntityBuilder = new ServiceRequestStatusHistoryEntityBuilder();
		serviceRequestStatusHistoryEntityBuilder.setCreatedBy(user);
		serviceRequestStatusHistoryEntityBuilder.setCreatedOrganization(organization);
		serviceRequestStatusHistoryEntityBuilder.setServiceRequestId(serviceRequestSaved);
		serviceRequestStatusHistoryEntityBuilder.setStatusId(serviceRequestStatusOptional.isPresent() ? serviceRequestStatusOptional.get() : null);
		ServiceRequestStatusHistory serviceRequestStatusHistorySaved = serviceRequestStatusHistoryRepository.save(serviceRequestStatusHistoryEntityBuilder.buildCreateEntity(new ServiceRequestStatusHistoryRequestDto(), null));
		ServiceRequestStatusHistoryResponseDto serviceRequestStatusHistoryResponseDto = serviceRequestStatusHistoryResponseDtoBuilder.buildCreateResponseDto(serviceRequestStatusHistorySaved);
		
		//mobile verification
		ContactInfo mobileVerification = null;
		if (req.getEmployerUpdateServiceRequestEmployerInterimRequest().getVerificationMobile() != null) {
			Optional<MstContactType> optionalContactType = mstContactTypeValidator.validateByCode(VERIFICATION_MOBILE_TYPE_CODE);
			ContactInfoEntityBuilder contactInfoEntityBuilder = new ContactInfoEntityBuilder();
			contactInfoEntityBuilder.setContactTypeId(optionalContactType.isPresent() ? optionalContactType.get() : null);
			contactInfoEntityBuilder.setCreatedBy(user);
			contactInfoEntityBuilder.setCreatedOrganization(organization);
			ContactInfoRequestDto contactInfoRequestDto = new ContactInfoRequestDto();
			contactInfoRequestDto.setValue(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getVerificationMobile());
			mobileVerification = contactInfoRepository.save(contactInfoEntityBuilder.buildCreateEntity(contactInfoRequestDto, null));
		}
		
		//email verification
		ContactInfo emailVerification = null;
		if (req.getEmployerUpdateServiceRequestEmployerInterimRequest().getVerificationEmail() != null) {
			Optional<MstContactType> optionalContactType = mstContactTypeValidator.validateByCode(VERIFICATION_EMAIL_TYPE_CODE);
			ContactInfoEntityBuilder contactInfoEntityBuilder = new ContactInfoEntityBuilder();
			contactInfoEntityBuilder.setContactTypeId(optionalContactType.isPresent() ? optionalContactType.get() : null);
			contactInfoEntityBuilder.setCreatedBy(user);
			contactInfoEntityBuilder.setCreatedOrganization(organization);
			ContactInfoRequestDto contactInfoRequestDto = new ContactInfoRequestDto();
			contactInfoRequestDto.setValue(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getVerificationEmail());
			emailVerification = contactInfoRepository.save(contactInfoEntityBuilder.buildCreateEntity(contactInfoRequestDto, null));
		}
		
		//logo doc validation
		DocumentUploaded logoUploaded = null;	
		List<Long> documentListUploadAlfresco = new ArrayList<>();
		if(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getLogoDocUploadedId() != null) {			
			Optional<DocumentUploaded> documentUploaded = documentUploadedValidator.validate(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getLogoDocUploadedId());
			logoUploaded  = documentUploaded.isPresent() ? documentUploaded.get() :null;
			documentListUploadAlfresco.add(req.getEmployerUpdateServiceRequestEmployerInterimRequest().getLogoDocUploadedId());
		}
		
//save employer interim		
		EmployerInterimEntityBuilder employerInterimEntityBuilder = new EmployerInterimEntityBuilder();
		employerInterimEntityBuilder.setCreatedBy(user);
		employerInterimEntityBuilder.setCreatedOrganization(organization);
		employerInterimEntityBuilder.setNatureOfBusinessId(employerNatureBusinessOptional.isPresent() ? employerNatureBusinessOptional.get() : null);
		employerInterimEntityBuilder.setEmployerOrganizationTypeId(employerOrganizationTypeOptional.isPresent() ? employerOrganizationTypeOptional.get() : null);
		employerInterimEntityBuilder.setIndustryTypeId(employerIndustryTypeOptional.isPresent() ? employerIndustryTypeOptional.get() : null);
		employerInterimEntityBuilder.setReferenceTableId(employerInterimReferenceTableOptional.isPresent() ? employerInterimReferenceTableOptional.get() : null);
		employerInterimEntityBuilder.setEmployerTypeId(employerTypeOptional.isPresent() ? employerTypeOptional.get() : null);
		employerInterimEntityBuilder.setEmployerStatusId(employerStatusOptional.isPresent() ? employerStatusOptional.get() : null);
		employerInterimEntityBuilder.setPreferredLanguageId(mstLanguage.isPresent() ? mstLanguage.get() : null);
		employerInterimEntityBuilder.setVerificationEmailId(emailVerification);
		employerInterimEntityBuilder.setVerificationMobileId(mobileVerification);	
		employerInterimEntityBuilder.setLogoDocUploadedId(logoUploaded);
		EmployerInterimRequestDto EmployerInterimRequestDto = employerUpdateServiceRequestEmployerInterimRequestDtoBuilder.buildCreateDto(req.getEmployerUpdateServiceRequestEmployerInterimRequest(), null);		
		EmployerInterim employerInterimSaved = employerInterimRepository.save(employerInterimEntityBuilder.buildCreateEntity(EmployerInterimRequestDto, null));
		EmployerInterimResponseDto employerInterimResponseDto = employerInterimResponseDtoBuilder.buildCreateResponseDto(employerInterimSaved);
		
//save service request employer update		
		ServiceRequestEmployerUpdateEntityBuilder serviceRequestEmployerUpdateEntityBuilder = new ServiceRequestEmployerUpdateEntityBuilder();
		serviceRequestEmployerUpdateEntityBuilder.setEmployerId(employer);
		serviceRequestEmployerUpdateEntityBuilder.setServiceRequestId(serviceRequestSaved);
		serviceRequestEmployerUpdateEntityBuilder.setRequestedEmployerInterimId(employerInterimSaved);
		ServiceRequestEmployerUpdateRequestDto serviceRequestEmployerUpdateRequestDto =new ServiceRequestEmployerUpdateRequestDto();
		serviceRequestEmployerUpdateRequestDto.setEmployerDetailUpdate(true);
		ServiceRequestEmployerUpdate serviceRequestEmployerUpdateSaved = serviceRequestEmployerUpdateRepository.save(serviceRequestEmployerUpdateEntityBuilder.buildCreateEntity( serviceRequestEmployerUpdateRequestDto, null));

//save employer request update		
		EmployerRequestUpdateEntityBuilder employerRequestUpdateEntityBuilder = new EmployerRequestUpdateEntityBuilder();
		employerRequestUpdateEntityBuilder.setEmployerId(employer);
		employerRequestUpdateEntityBuilder.setEmployerInterimId(employerInterimSaved);
		employerRequestUpdateEntityBuilder.setServiceRequestEmployerUpdateId(serviceRequestEmployerUpdateSaved);
		EmployerRequestUpdateRequestDto employerRequestUpdateRequestDto =  employerUpdateServiceRequestUpdateRequestDtoBuilder.buildCreateDto(req.getEmployerUpdateServiceRequestUpdateRequest(), null);		
		EmployerRequestUpdate employerRequestUpdate = employerRequestUpdateRepository.save(employerRequestUpdateEntityBuilder.buildCreateEntity(employerRequestUpdateRequestDto, null));
		EmployerRequestUpdateResponseDto employerRequestUpdateResponseDto = employerRequestUpdateResponseDtoBuilder.buildCreateResponseDto(employerRequestUpdate);
		
//save documents list		
		if (req.getServiceRequestDocumentList() != null) {
			List<ServiceRequestDocument> serviceRequestDocumentUploadedList = new ArrayList<>();
			for (Long DocumentId : req.getServiceRequestDocumentList()) {
				documentListUploadAlfresco.add(DocumentId);
				Optional<DocumentUploaded> documentUploaded = documentUploadedValidator.validate(DocumentId);
				ServiceRequestDocumentEntityBuilder serviceRequestDocumentEntityBuilder = new ServiceRequestDocumentEntityBuilder();
				serviceRequestDocumentEntityBuilder.setDocumentUploadedId(documentUploaded.isPresent() ? documentUploaded.get() : null);
				serviceRequestDocumentEntityBuilder.setServiceRequestId(serviceRequestSaved);
				ServiceRequestDocument serviceRequestDocument = serviceRequestDocumentEntityBuilder.buildCreateEntity(null, null);
				serviceRequestDocumentUploadedList.add(serviceRequestDocument);
			}
			serviceRequestDocumentRepository.saveAll(serviceRequestDocumentUploadedList);
		}
		
//save documents to alfresco
		if(!documentListUploadAlfresco.isEmpty()){
			//DocumentUpdateRequest duRequest = new DocumentUpdateRequest(EMPLOYER_DOCUMENT_UPLOAD_MODULE, documentListUploadAlfresco);
			DocumentUpdateRequest duRequest = new DocumentUpdateRequest();
			duRequest.setModuleCode(EMPLOYER_DOCUMENT_UPLOAD_MODULE);
			duRequest.setDocumentList(documentListUploadAlfresco);
			
			documentService.updateDmsRefParentRef(duRequest);
		}

//save contacts details		
		if (req.getContactDetailsList() != null) {		  
			List<EmployerUpdateServiceRequestContactInfoRequest> contactDetailsList = req.getContactDetailsList();
			for (EmployerUpdateServiceRequestContactInfoRequest contactInfoRequest : contactDetailsList) {				
				EmployerGeneralContact employerGeneralContact = null;
				// when update the existing contact validate contact
				if (contactInfoRequest.getEmployerGeneralContactId() != null) {
					Optional<EmployerGeneralContact> EmployerGeneralContactOptional = employerGeneralContactValidator.validate(contactInfoRequest.getEmployerGeneralContactId());
					employerGeneralContact = EmployerGeneralContactOptional.isPresent()? EmployerGeneralContactOptional.get(): null;
				}
				Optional<MstContactType> optionalContactType = mstContactTypeValidator.validateByCode(contactInfoRequest.getContactTypeCode());
				ContactInfoEntityBuilder contactInfoEntityBuilder = new ContactInfoEntityBuilder();
				contactInfoEntityBuilder.setContactTypeId(optionalContactType.isPresent() ? optionalContactType.get() : null);
				contactInfoEntityBuilder.setCreatedBy(user);
				contactInfoEntityBuilder.setCreatedOrganization(organization);
				ContactInfoRequestDto contactInfoRequestDto = new ContactInfoRequestDto();
				contactInfoRequestDto.setValue(contactInfoRequest.getValue());
				contactInfoRequestDto.setPublicNote(contactInfoRequest.getNote());
				ContactInfo contactInfo = contactInfoRepository.save(contactInfoEntityBuilder.buildCreateEntity(contactInfoRequestDto, null));

				
				EmployerInterimGeneralContactEntityBuilder employerInterimGeneralContactEntityBuilder = new EmployerInterimGeneralContactEntityBuilder();
				employerInterimGeneralContactEntityBuilder.setEmployerInterimId(employerInterimSaved);
				employerInterimGeneralContactEntityBuilder.setContactInfoId(contactInfo);
				EmployerInterimGeneralContactRequestDto employerInterimGeneralContactRequestDto = new EmployerInterimGeneralContactRequestDto();
				employerInterimGeneralContactRequestDto.setActive(contactInfoRequest.getActive());
				employerInterimGeneralContactRequestDto.setContactSms(contactInfoRequest.getUseForSms());
				employerInterimGeneralContactRequestDto.setContactEmail(contactInfoRequest.getUseForEmail());				
				employerInterimGeneralContactEntityBuilder.buildCreateEntity(employerInterimGeneralContactRequestDto,null);
				EmployerInterimGeneralContact employerInterimGeneralContact = employerInterimGeneralContactRepository.save(employerInterimGeneralContactEntityBuilder.buildCreateEntity(employerInterimGeneralContactRequestDto, null));

				EmployerRequestGeneralContactAddupdateEntityBuilder employerRequestGeneralContactAddUpdateEntityBuilder = new EmployerRequestGeneralContactAddupdateEntityBuilder();
				employerRequestGeneralContactAddUpdateEntityBuilder.setEmployerId(employer);
				employerRequestGeneralContactAddUpdateEntityBuilder.setEmployerInterimGeneralContactId(employerInterimGeneralContact);
				if (employerGeneralContact != null) {
					employerRequestGeneralContactAddUpdateEntityBuilder.setEmployerGeneralContactId(employerGeneralContact);
				}
				employerRequestGeneralContactAddUpdateEntityBuilder.setServiceRequestEmployerUpdateId(serviceRequestEmployerUpdateSaved);
				EmployerRequestGeneralContactAddupdateRequestDto employerRequestGeneralContactAddupdateRequestDto = new EmployerRequestGeneralContactAddupdateRequestDto();
				employerRequestGeneralContactAddupdateRequestDto.setUpdateType(contactInfoRequest.getInsertType());
				employerRequestGeneralContactAddupdateRepository.save(employerRequestGeneralContactAddUpdateEntityBuilder.buildCreateEntity(employerRequestGeneralContactAddupdateRequestDto, null));

			}
		}
		
		
		
		return EmployerUpdateServiceRequestResponseDto.builder()
		.serviceRequestResponse(serviceRequestResponseDto)
		.employerInterimResponse(employerInterimResponseDto)
		.employerRequestUpdateResponse(employerRequestUpdateResponseDto)
		.serviceRequestStatusHistoryResponse(serviceRequestStatusHistoryResponseDto)
		.build();
	}


	public ServiceRequestRequestDto createServiceRequestDto(EmployerUpdateServiceRequestRequest req) {

		return ServiceRequestRequestDto.builder()
				.refNo(refNoUtil.getRefNumber(""))
				.prefixRefNo(prefixConfig.getServiceRequest())
				.description(req.getRequestDescription())
				.note(req.getNote()).hold(SERVICE_REQUEST_HOLD).approvalRequired(SERVICE_REQUEST_APPROVE_REQUIRED)
				.approved(SERVICE_REQUEST_APPROVED).build();

	}


}
