/*
 * 1.0.1	20200429		shirhan@inovaitsys.com					Implmented methods for search,
 * 																	and to get record count
 * 1.0.2	20200528		shirhan@inovaitsys.com					Implementation of employer member account update.
 * 																	Backlog #216
 * 1.0.3	20200701		shirhan@inovaitsys.com					Checking the existing code.
 * 
 * */
package com.inova.employer_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inova.applogger.util.MethodLogging;
import com.inova.common.dao.wrapper.CountResponseDto;
import com.inova.common.response.dto.EmploymentMemberAccountReferenceDetailsResponseDto;
import com.inova.common.response.dto.MemberAccountNomineeBasicDetailsResponseDto;
import com.inova.common.service.AddressService;
import com.inova.common.service.ContactInfoService;
import com.inova.common.service.NomineeService;
import com.inova.common.service.PersonAddressReferenceService;
import com.inova.common.service.PersonAddressService;
import com.inova.common.service.PersonContactReferenceService;
import com.inova.common.service.PersonContactService;
import com.inova.common.service.PersonGeneralAddressReferenceService;
import com.inova.common.service.PersonGeneralAddressService;
import com.inova.common.service.PersonGeneralContactReferenceService;
import com.inova.common.service.PersonGeneralContactService;
import com.inova.common.service.PersonGeneralNicService;
import com.inova.common.service.PersonGeneralPassportService;
import com.inova.common.service.PersonGeneralService;
import com.inova.dao.entities.Address;
import com.inova.dao.entities.DmuInbound;
import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerEmploymentRequestServiceCounterDmu;
import com.inova.dao.entities.EmployerInterimMemberAccount;
import com.inova.dao.entities.EmployerMemberAccount;
import com.inova.dao.entities.EmployerMemberAccountAddressHistory;
import com.inova.dao.entities.EmployerMemberDocument;
import com.inova.dao.entities.EmployerMemberNoUnique;
import com.inova.dao.entities.EmployerMemberNoUniquePK;
import com.inova.dao.entities.EnforcementEmployer;
import com.inova.dao.entities.Member1;
import com.inova.dao.entities.MemberAccount;
import com.inova.dao.entities.MemberAccountNominee;
import com.inova.dao.entities.MemberAccountStatusHistory;
import com.inova.dao.entities.MemberPersonVerificationRequest;
import com.inova.dao.entities.MstEmployerMemberAccountStatus;
import com.inova.dao.entities.MstEmployerMemberGroup;
import com.inova.dao.entities.MstLanguage;
import com.inova.dao.entities.MstMemberAccountStatus;
import com.inova.dao.entities.MstMemberAccountType;
import com.inova.dao.entities.MstMemberCreatedSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestSource;
import com.inova.dao.entities.MstMemberPersonVerificationRequestType;
import com.inova.dao.entities.MstPersonReferenceTable;
import com.inova.dao.entities.MstPriority;
import com.inova.dao.entities.MstReason;
import com.inova.dao.entities.MstRelationship;
import com.inova.dao.entities.MstTxnAction;
import com.inova.dao.entities.MstVerificationRequestStatus;
import com.inova.dao.entities.MstVerificationStatus;
import com.inova.dao.entities.Organization;
import com.inova.dao.entities.Person;
import com.inova.dao.entities.PersonAddress;
import com.inova.dao.entities.PersonAddressReference;
import com.inova.dao.entities.PersonContact;
import com.inova.dao.entities.PersonContactReference;
import com.inova.dao.entities.PersonGeneral;
import com.inova.dao.entities.PersonGeneralAddress;
import com.inova.dao.entities.PersonGeneralContact;
import com.inova.dao.entities.SelfEmploymentAgentDocument;
import com.inova.dao.entities.ServiceCounterRequirementType;
import com.inova.dao.entities.Transaction;
import com.inova.dao.entities.User;
import com.inova.dao.entities.build.AddressEntityBuilder;
import com.inova.dao.entities.build.EmployerEmploymentRequestServiceCounterDmuEntityBuilder;
import com.inova.dao.entities.build.EmployerMemberAccountAddressHistoryEntityBuilder;
import com.inova.dao.entities.build.EmployerMemberAccountContactHistoryEntityBuilder;
import com.inova.dao.entities.build.EmployerMemberAccountEntityBuilder;
import com.inova.dao.entities.build.EmployerMemberAccountHistoryEntityBuilder;
import com.inova.dao.entities.build.EmployerMemberDocumentEntityBuilder;
import com.inova.dao.entities.build.EmployerMemberNoUniqueEntityBuilder;
import com.inova.dao.entities.build.Member1EntityBuilder;
//import com.inova.dao.entities.build.EmployerMemberNoUniquePKEntityBuilder;
import com.inova.dao.entities.build.MemberAccountEntityBuilder;
import com.inova.dao.entities.build.MemberAccountNomineeEntityBuilder;
import com.inova.dao.entities.build.MemberAccountNomineeHistoryEntityBuilder;
import com.inova.dao.entities.build.MemberAccountStatusHistoryEntityBuilder;
import com.inova.dao.entities.build.MemberPersonVerificationRequestEntityBuilder;
import com.inova.dao.entities.build.PersonEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralAddressEntityBuilder;
import com.inova.dao.entities.build.PersonGeneralEntityBuilder;
import com.inova.dao.entities.build.SelfEmploymentAgentDocumentEntityBuilder;
import com.inova.dao.entities.build.TransactionEntityBuilder;
import com.inova.dao.entities.build.TxnEmployerEntityBuilder;
import com.inova.dao.entities.build.TxnMemberEntityBuilder;
import com.inova.dao.entities.history.EmployerInterimMemberAccountHistoryEntityBuilder;
import com.inova.dao.entities.history.MemberAccountNomineeHistory1EntityBuilder;
import com.inova.dao.entities.history.MemberPersonVerificationRequestHistoryEntityBuilder;
import com.inova.dao.repositories.AddressRepository;
import com.inova.dao.repositories.EmployerEmploymentRequestServiceCounterDmuRepository;
import com.inova.dao.repositories.EmployerInterimMemberAccountRepository;
import com.inova.dao.repositories.EmployerMemberAccountAddressHistoryRepository;
import com.inova.dao.repositories.EmployerMemberAccountContactHistoryRepository;
import com.inova.dao.repositories.EmployerMemberAccountHistoryRepository;
import com.inova.dao.repositories.EmployerMemberAccountRepository;
import com.inova.dao.repositories.EmployerMemberDocumentRepository;
import com.inova.dao.repositories.EmployerMemberNoUniqueRepository;
import com.inova.dao.repositories.Member1Repository;
import com.inova.dao.repositories.MemberAccountNomineeHistoryRepository;
import com.inova.dao.repositories.MemberAccountNomineeRepository;
import com.inova.dao.repositories.MemberAccountRepository;
import com.inova.dao.repositories.MemberAccountStatusHistoryRepository;
import com.inova.dao.repositories.MemberPersonVerificationRequestRepository;
import com.inova.dao.repositories.MemberPersonVerificationRequestStatusHistoryRepository;
import com.inova.dao.repositories.PersonAddressReferenceRepository;
import com.inova.dao.repositories.PersonContactReferenceRepository;
import com.inova.dao.repositories.PersonRepository;
import com.inova.dao.repositories.TransactionRepository;
import com.inova.dao.repositories.TxnEmployerRepository;
import com.inova.dao.repositories.TxnMemberRepository;
import com.inova.dao.validate.DmuInboundValidator;
import com.inova.dao.validate.DocumentUploadedValidator;
import com.inova.dao.validate.EmployerMemberAccountValidator;
import com.inova.dao.validate.EmployerMemberNoUniqueValidator;
import com.inova.dao.validate.EmployerValidator;
import com.inova.dao.validate.Member1Validator;
import com.inova.dao.validate.MemberAccountNomineeValidator;
import com.inova.dao.validate.MstEmployerMemberAccountStatusValidator;
import com.inova.dao.validate.MstEmployerMemberGroupValidator;
import com.inova.dao.validate.MstLanguageValidator;
import com.inova.dao.validate.MstMemberAccountStatusValidator;
import com.inova.dao.validate.MstMemberAccountTypeValidator;
import com.inova.dao.validate.MstMemberCreatedSourceValidator;
import com.inova.dao.validate.MstMemberPersonVerificationRequestSourceValidator;
import com.inova.dao.validate.MstMemberPersonVerificationRequestTypeValidator;
import com.inova.dao.validate.MstPersonReferenceTableValidator;
import com.inova.dao.validate.MstPriorityValidator;
import com.inova.dao.validate.MstReasonValidator;
import com.inova.dao.validate.MstRelationshipValidator;
import com.inova.dao.validate.MstTxnActionValidator;
import com.inova.dao.validate.MstVerificationRequestStatusValidator;
import com.inova.dao.validate.MstVerificationStatusValidator;
import com.inova.dao.validate.OrganizationValidator;
import com.inova.dao.validate.PersonAddressValidator;
import com.inova.dao.validate.PersonContactValidator;
import com.inova.dao.validate.PersonGeneralAddressValidator;
import com.inova.dao.validate.PersonGeneralContactValidator;
import com.inova.dao.validate.PersonGeneralValidator;
import com.inova.dao.validate.PersonValidator;
import com.inova.dao.validate.ServiceCounterRequirementTypeValidator;
import com.inova.dao.validate.UserValidator;
import com.inova.document.request.DocumentUpdateRequest;
import com.inova.document.service.DocumentService;
import com.inova.dto.PersonAddressListItemResponseDtoChild1;
import com.inova.dto.PersonContactListItemResponseDtoChild1;
import com.inova.employer_management.service.EmplymentMemberService;
import com.inova.enums.EmployedMemberStatus;
import com.inova.enums.MstLanguageEnum;
import com.inova.enums.MstMemberAccountTypeEnum;
import com.inova.enums.MstMemberCreatedSourceEnum;
import com.inova.enums.MstModuleEnum;
import com.inova.enums.MstPersonReferenceTableEnum;
import com.inova.etfb.employer_management.dao.EmployerMemberManagementDao;
import com.inova.etfb.employer_management.request.EmployerManageMemberSearchRequest;
import com.inova.etfb.employer_management.request.EmployerMemberCountRequest;
import com.inova.etfb.employer_management.request.UpdateEmploymentRequest;
import com.inova.etfb.employer_management.response.EmployerMemberAccountDetailResponseDto;
import com.inova.etfb.employer_management.response.UpdateEmploymentResponseDto;
import com.inova.exception.ApplicationException;
import com.inova.request.EmployerMemberAccountRequestChild2;
import com.inova.request.EmployerMemberAccountRequestChild4;
import com.inova.request.EmployerMemberDocumentRequest;
import com.inova.request.MemberAccountNomineeRequestChild2;
import com.inova.request.MemberAccountNomineeRequestChild3;
import com.inova.request.MemberAccountNomineeRequestChild5;
import com.inova.request.PersonAddressReferenceRequestChild1;
import com.inova.request.PersonAddressRequestChild2;
import com.inova.request.PersonAddressRequestChild3;
import com.inova.request.PersonAddressRequestChild6;
import com.inova.request.PersonContactReferenceRequestChild1;
import com.inova.request.PersonContactRequestChild2;
import com.inova.request.PersonContactRequestChild3;
import com.inova.request.PersonContactRequestChild7;
import com.inova.request.PersonGeneralAddressRequest;
import com.inova.request.PersonGeneralAddressRequestChild2;
import com.inova.request.PersonGeneralAddressRequestChild3;
import com.inova.request.PersonGeneralAddressRequestChild4;
import com.inova.request.PersonGeneralContactRequestChild2;
import com.inova.request.PersonGeneralContactRequestChild3;
import com.inova.request.PersonGeneralNicRequestChild1;
import com.inova.request.PersonGeneralPassportRequestChild1;
import com.inova.request.PersonGeneralRequestChild1;
import com.inova.request.dto.AddressRequestDto;
import com.inova.request.dto.EmployerEmploymentRequestServiceCounterDmuRequestDto;
import com.inova.request.dto.EmployerMemberAccountAddressHistoryRequestDto;
import com.inova.request.dto.EmployerMemberAccountContactHistoryRequestDto;
import com.inova.request.dto.EmployerMemberAccountRequestDto;
import com.inova.request.dto.EmployerMemberDocumentRequestDto;
import com.inova.request.dto.EmployerMemberNoUniqueRequestDto;
import com.inova.request.dto.Member1RequestDto;
//import com.inova.request.dto.EmployerMemberNoUniquePKRequestDto;
import com.inova.request.dto.MemberAccountNomineeRequestDto;
import com.inova.request.dto.MemberAccountRequestDto;
import com.inova.request.dto.MemberPersonVerificationRequestRequestDto;
import com.inova.request.dto.MemberPersonVerificationRequestStatusHistoryRequestDto;
import com.inova.request.dto.PersonAddressReferenceRequestDto;
import com.inova.request.dto.PersonAddressRequestDto;
import com.inova.request.dto.PersonContactReferenceRequestDto;
import com.inova.request.dto.PersonContactRequestDto;
import com.inova.request.dto.PersonGeneralAddressReferenceRequestDto;
import com.inova.request.dto.PersonGeneralAddressRequestDto;
import com.inova.request.dto.PersonGeneralContactReferenceRequestDto;
import com.inova.request.dto.PersonGeneralContactRequestDto;
import com.inova.request.dto.TransactionRequestDto;
import com.inova.request.dto.TxnEmployerRequestDto;
import com.inova.request.dto.TxnMemberRequestDto;
import com.inova.request.dto.build.AddressRequestDtoBuilder;
import com.inova.request.dto.build.EmployerMemberAccountRequestDtoBuilder;
import com.inova.request.dto.build.EmployerMemberDocumentRequestDtoBuilder;
import com.inova.response.dto.AddressResponseDto;
import com.inova.response.dto.ContactInfoResponseDto;
import com.inova.response.dto.DocumentUploadedResponseDtoChild2;
import com.inova.response.dto.EmployerMemberAccountResponseDtoChild1;
import com.inova.response.dto.EmployerMemberAccountResponseDtoChild2;
import com.inova.response.dto.EmployerMemberDocumentResponseDto;
import com.inova.response.dto.MemberAccountNomineeResponseDtoChild1;
import com.inova.response.dto.MemberAccountResponseDto;
import com.inova.response.dto.PersonAddressReferenceResponseDto;
import com.inova.response.dto.PersonAddressResponseDto;
import com.inova.response.dto.PersonContactReferenceResponseDto;
import com.inova.response.dto.PersonContactResponseDto;
import com.inova.response.dto.PersonGeneralAddressReferenceResponseDto;
import com.inova.response.dto.PersonGeneralAddressResponseDto;
import com.inova.response.dto.PersonGeneralContactReferenceResponseDto;
import com.inova.response.dto.PersonGeneralContactResponseDto;
import com.inova.response.dto.PersonGeneralNicResponseDto;
import com.inova.response.dto.PersonGeneralPassportResponseDto;
import com.inova.response.dto.PersonGeneralResponseDto;
import com.inova.response.dto.PersonGeneralResponseDtoChild2;
import com.inova.response.dto.SelfEmploymentAgentDocumentResponseDto;
import com.inova.response.dto.build.EmployerMemberAccountResponseDtoBuilderChild1;
import com.inova.response.dto.build.EmployerMemberDocumentResponseDtoBuilder;
import com.inova.util.NoteFormatter;
import com.inova.util.OrganizationUtil;
import com.inova.util.RefNoUtil;
import com.inova.util.UserUtil;

@Service
public class EmplymentMemberServiceImpl implements EmplymentMemberService {
	public  EnforcementEmployer emp;
	public static final String EMPLOYER_MEMBER_ACCOUNT_STATUS = "INACT";
	public static final String MEMBER_ACCOUNT_STATUS = "VP";
	public static final String MEMBER_ACCOUNT_STATUS_OPEN = "OPN";
	public static final String MEMBER_ACCOUNT_TYPE = MstMemberAccountTypeEnum.EMP.getCode();

	public static final Long ACTION_NO_EMPLOYER_MEMBER_ACCOUNT_CREATED = 2003L;
	//TODO :: mst_member_person_verification_request_type entry for this, will need to take this value from Enum??
	public static final String REQUEST_TYPE_CODE = "EMPNT";
	//TODO :: mst_member_person_verification_request_source entry for this, will need to take this value from Enum??
	public static final String REQUEST_SOURCE_CODE = "ETFBMEMMG";
	public static final String STATUS_VERIFICATION = "VP";
	public static final String STATUS = "UN_ASG";
	public static final String REFERENCE_TABLE_CODE = MstPersonReferenceTableEnum.EMPMEMACC.getCode();
	//TODO :: mst_person_general_reference_table entry for this, will need to take this value from Enum??
	//"1","Member Person Verification Request","member_person_verification_request","person_general_id"
	public static final Long PG_REFERENCE_TABLE_ID = 1L;
	public static final String REFERENCE_TABLE_ENTITY_CLASS = EmployerMemberAccount.class.getSimpleName();	//TODO :: mst_person_general_reference_table entry for this, will need to take this value from Enum??
	//TODO :: mst_priority entry for this, will need to take this value from Enum??
	//"3","High"
	public static final Long MEM_VERIFICATION_PRIORITY = 3L;
	public static final String PROFILE_PIC_DOCUMENT_UPLOAD_MODULE = MstModuleEnum.EMP_MNG.getCode();
	public static final String MEMBER_CREATED_SOURCE = MstMemberCreatedSourceEnum.EMP.getCode();
	
	@Autowired
	private EmployerMemberAccountRequestDtoBuilder employerMemberAccountRequestDtoBuilder;
	@Autowired
	private EmployerValidator employerValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private OrganizationValidator organizationValidator;
	@Autowired
	private OrganizationUtil organizationUtil;
	@Autowired
	private UserUtil userUtil;
	@Autowired
	private MstEmployerMemberGroupValidator mstEmployerMemberGroupValidator;
	@Autowired
	private MstEmployerMemberAccountStatusValidator mstEmployerMemberAccountStatusValidator;
	@Autowired
	private MstMemberAccountTypeValidator mstMemberAccountTypeValidator;
	@Autowired
	private PersonGeneralNicService personGeneralNicServiceNew;
	@Autowired
	private PersonGeneralPassportService personGeneralPassportServiceNew;
	@Autowired
	private PersonGeneralAddressService personGeneralAddressServiceNew;
	@Autowired
	private PersonGeneralContactService personGeneralContactServiceNew;
	@Autowired
	private PersonGeneralService personGeneralServiceNew;
	@Autowired
	private MstPriorityValidator mstPriorityValidator;
	@Autowired
	private MstMemberPersonVerificationRequestTypeValidator memberPersonVerificationRequestTypeValidator;
	@Autowired
	private MstMemberPersonVerificationRequestSourceValidator memberPersonVerificationRequestSourceValidator;
	@Autowired
	private MstVerificationRequestStatusValidator verificationRequestStatusValidator;
	@Autowired
	private MstVerificationStatusValidator verificationStatusValidator;
	@Autowired
	private MemberPersonVerificationRequestRepository memberPersonVerificationRequestRepository;
	@Autowired
	private MemberPersonVerificationRequestStatusHistoryRepository memberPersonVerificationRequestStatusHistoryRepository;
	@Autowired
	private PersonAddressService personAddressServiceNew;
	@Autowired
	private PersonContactService personContactServiceNew;
	@Autowired
	private Member1Validator member1Validator;
	@Autowired
	private EmployerMemberAccountResponseDtoBuilderChild1 employerMemberAccountResponseDtoBuilder;
	@Autowired
	private MstMemberAccountStatusValidator mstMemberAccountStatusValidator;
	@Autowired
	private EmployerEmploymentRequestServiceCounterDmuRepository employerEmploymentRequestServiceCounterDmuRepository;
	@Autowired
	private MemberAccountRepository memberAccountRepository;
	@Autowired
	private EmployerMemberAccountRepository employerMemberAccountRepository;
	@Autowired
	private EmployerInterimMemberAccountRepository employerInterimMemberAccountRepository;
	@Autowired
	private EmployerMemberAccountHistoryRepository employerMemberAccountHistoryRepository;
	@Autowired
	private EmployerMemberNoUniqueRepository employerMemberNoUniqueRepository;
	@Autowired
	private DocumentUploadedValidator documentUploadedValidator;
	@Autowired
	private EmployerMemberDocumentRepository employerMemberDocumentRepository;
	@Autowired
	private EmployerMemberDocumentRequestDtoBuilder employerMemberDocumentRequestDtoBuilder;
	@Autowired
	private EmployerMemberDocumentResponseDtoBuilder employerMemberDocumentResponseDtoBuilder;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private MstTxnActionValidator mstTxnActionValidator;
	@Autowired
	private Member1Repository member1Repository;
	@Autowired
	private MstPersonReferenceTableValidator mstPersonReferenceTableValidator;
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private NomineeService memberAccountNomineeService;
	@Autowired
	private RefNoUtil refNoUtil;
	@Autowired
	private TxnMemberRepository txnMemberRepository;
	@Autowired
	private MemberAccountStatusHistoryRepository memberAccountStatusHistoryRepository;
	@Autowired
	private EmployerMemberManagementDao employerMemberManagementDao;				//1.0.1
	@Autowired
	private EmployerMemberAccountValidator employerMemberAccountValidator;
	//1.0.2 : Start
	@Autowired
	private PersonAddressReferenceService personAddressReferenceService;			
	@Autowired
	private PersonContactReferenceService personContactReferenceService;
	@Autowired
	private PersonGeneralValidator personGeneralValidator;
	@Autowired
	private ServiceCounterRequirementTypeValidator scReqTypeValidator;
	@Autowired
	private DmuInboundValidator dmuInboundValidator;
	@Autowired
	private AddressService addressService;
	@Autowired
	private ContactInfoService contactInfoService;
	@Autowired
	private PersonAddressValidator personAddressValidator;
	@Autowired
	private PersonContactValidator personContactValidator;
	@Autowired
	private PersonGeneralAddressValidator personGeneralAddressValidator;
	@Autowired
	private PersonGeneralContactValidator personGeneralContactValidator;
	@Autowired
	private EmployerMemberAccountAddressHistoryRepository emaAddressHistoryRepository;
	@Autowired
	private EmployerMemberAccountContactHistoryRepository emaContactHistoryRepository;
	@Autowired
	private MemberAccountNomineeHistoryRepository  memAccNomHistRepository;			
	@Autowired
	private MemberAccountNomineeRepository memAccNomRepository;						
	@Autowired
	private MemberAccountNomineeValidator memberAccountNomineeValidator;			
	@Autowired
	private PersonGeneralAddressReferenceService pgaReferenceService;				
	@Autowired
	private PersonGeneralContactReferenceService pgcReferenceService;				
	@Autowired
	private TxnEmployerRepository txnEmployerRepository;							
	@Autowired
	private MstLanguageValidator mstLanguageValidator;								
	@Autowired
	private PersonRepository personRepository;										
	@Autowired
	private MstReasonValidator mstReasonValidator;									
	@Autowired
	private MstRelationshipValidator mstRelationshipValidator;
	//1.0.2 : End
	//1.0.3 : Start
	@Autowired
	private EmployerMemberAccountRepository emAccountRepository;
	@Autowired
	private DocumentService documentService;
	//1.0.3 : End
	@Autowired
	private MstMemberCreatedSourceValidator mmcsValidator;
	@Autowired
	private PersonAddressReferenceRepository parRepository;
	@Autowired
	private PersonContactReferenceRepository pcrRepository;
	
	//1.0.3 :: Start
	@Override
	@MethodLogging
	@Transactional(rollbackFor=ApplicationException.class)
	public EmployerMemberAccountResponseDtoChild1 create(EmployerMemberAccountRequestChild4 req)
			throws ApplicationException {
		EmployerMemberAccountRequestDto requestDto = employerMemberAccountRequestDtoBuilder.buildCreateDto(req, null);

		//Validate
		Optional<User> opUser = userValidator.validate(userUtil.getUserId("replace_me"));
		Optional<Organization> opOrganization = organizationValidator
														.validate(organizationUtil.getOrganizationId("replace_me"));
		Optional<Employer> opEmployer = employerValidator.validate(requestDto.getEmployerId());
		Optional<MstEmployerMemberGroup> mstEmployerMemberGroupOptional = mstEmployerMemberGroupValidator
																							.validateByCode(req.getMemberGroupCode());
		Optional<MstEmployerMemberAccountStatus> mstEmployerMemberAccountStatusOptional = mstEmployerMemberAccountStatusValidator
				.validateByCode(EMPLOYER_MEMBER_ACCOUNT_STATUS);
		Optional<MstMemberAccountType> mstMemberAccountTypeOptional = mstMemberAccountTypeValidator
				.validateByCode(MEMBER_ACCOUNT_TYPE);
		Optional<MstMemberAccountStatus> mstMemberAccountStatusOptional = mstMemberAccountStatusValidator
				.validateByCode(MEMBER_ACCOUNT_STATUS);
		Optional<MstMemberAccountStatus> opMstMemAccStatusOpn = mstMemberAccountStatusValidator
				.validateByCode(MEMBER_ACCOUNT_STATUS_OPEN);
		Optional<MstPersonReferenceTable> opMstPersonReferenceTable = mstPersonReferenceTableValidator.validateByCode(REFERENCE_TABLE_CODE);
		
		Optional<MstLanguage> opLang = Optional.empty();
		if(req.getPrefLangCode()!=null) {
			opLang = mstLanguageValidator.validateByCode(req.getPrefLangCode());
		}/*else {
			opLang = mstLanguageValidator.validateByCode(MstLanguageEnum.ENG.getCode());
		}*/
		
		EmployerMemberAccountResponseDtoChild1 employerMemberAccountResponseDto = null;
		List<PersonContactResponseDto> personContactResponseDtoList = new ArrayList<>();
		List<PersonAddressResponseDto> personAddressResponseDtoList = new ArrayList<>();
		PersonGeneralResponseDto personGeneralResponseDto = null;
		PersonGeneralNicResponseDto personGeneralNicResponseDto = null;
		PersonGeneralPassportResponseDto personGeneralPassportResponseDto = null;
		List<PersonGeneralAddressResponseDto> personGeneralAddressResponseDtoList = new ArrayList<>();
		List<PersonGeneralContactResponseDto> personGeneralContactResponseDtoList = new ArrayList<>();
		List<EmployerMemberDocumentResponseDto> employerMemberDocumentResponseDtoList = new ArrayList<>();
		List<MemberAccountNomineeResponseDtoChild1> memberAccountNomineeResponseDtoList = new ArrayList<>();
		MemberAccount memberAccount = null;
		EmployerMemberAccount employerMemberAccount = null;
		MemberPersonVerificationRequest memberPersonVerificationRequest = null;
		Optional<Person> opPerson = Optional.empty();
		PersonGeneral personGeneral = null;
		
		Optional<MstTxnAction> opMstTxnAction = mstTxnActionValidator.validateByActionNo(ACTION_NO_EMPLOYER_MEMBER_ACCOUNT_CREATED);
		
		//Note :: Person and member has a one to one relationship
		//1) Person exists
		if ((req.getPersonRefNo()!=null)&&(req.getPersonRefNo()!=0)){
			//1.1) Validate the person reference that is sent
			opPerson = personValidator.validateByRefNo(req.getPersonRefNo());
			Optional<Member1> opMember1 = member1Validator.validateByPersonId(opPerson.get().getId());

			//20200822 :: Update language preference
			//opPerson.get().setPreferredLanguageId(opLang.get());
			//personRepository.save(opPerson.get());
			//20200822
			
			//1.2) Create member_account record
			MemberAccountRequestDto memberAccountRequestDto = MemberAccountRequestDto.builder()
																	.refNo(refNoUtil.getRefNumber("member_account")).build();
			
			MemberAccountEntityBuilder maEB = new MemberAccountEntityBuilder();
			maEB.setCreatedBy(opUser.get());
			maEB.setCreatedOrganization(opOrganization.get());
			maEB.setStatusBy(opUser.get());
			maEB.setStatusOrganization(opOrganization.get());
			maEB.setStatusId(opMstMemAccStatusOpn.get());		//20200812 :: As per Mr.Devage's comment this should be OPEN for this scenario
			maEB.setMemberPersonVerificationRequestId(memberPersonVerificationRequest); //Person already verified : null
			maEB.setMemberId(opMember1.get());											//Found member
			maEB.setAccountTypeId(mstMemberAccountTypeOptional.get());					//EMP
			memberAccount = memberAccountRepository.save(maEB.buildCreateEntity(memberAccountRequestDto, null));
			
			//1.3) Create member_account_status_history record
			MemberAccountStatusHistoryEntityBuilder mashEB = new MemberAccountStatusHistoryEntityBuilder();
			mashEB.setCreatedBy(opUser.get());
			mashEB.setCreatedOrganization(opOrganization.get());
			mashEB.setMemberAccountId(memberAccount);						//Above created
			mashEB.setMemberAccountStatusId(memberAccount.getStatusId());	//Above created
			MemberAccountStatusHistory accountStatusHistory = 
													this.memberAccountStatusHistoryRepository.save(mashEB.buildCreateEntity(null, null));
			
			//Note : Member number should be unique for a given employee at an organization. This is not unique in the table.
			//       If the column was made unique then another employer could not have an employee with the same member number.
			EmployerMemberAccount ema = emAccountRepository.findByEmployerIdAndMemberNo(requestDto.getMemberNo(), opEmployer.get().getId());
			if(ema!=null) {
				throw new ApplicationException("Member No. already exists"); //TODO : Get message from config
				
			}else {
				
				EmployerMemberNoUniqueRequestDto emnuRequestDTO = EmployerMemberNoUniqueRequestDto.builder()
																						.employer(opEmployer.get().getId())
																						.memberNo(requestDto.getMemberNo())
																						.build();
				
				EmployerMemberNoUniqueEntityBuilder emnuEB = new EmployerMemberNoUniqueEntityBuilder();
				emnuEB.setEmployer(opEmployer.get());
				EmployerMemberNoUnique employerMemberNoUnique = emnuEB.buildCreateEntity(emnuRequestDTO,null);
				try {
					employerMemberNoUniqueRepository.save(employerMemberNoUnique);
				} catch (Exception e) {
					throw new ApplicationException("Member No. already exists"); //TODO : Get message from config
					
				}
				
				//1.4) Create employer_member_account record
				EmployerMemberAccountEntityBuilder emaEB = new EmployerMemberAccountEntityBuilder();
				emaEB.setCreatedBy(opUser.get());
				emaEB.setCreatedOrganization(opOrganization.get());
				emaEB.setStatusBy(opUser.get());
				emaEB.setStatusOrganization(opOrganization.get());
				emaEB.setStatusId(mstEmployerMemberAccountStatusOptional.get());
				emaEB.setEmployerId(opEmployer.get());
				emaEB.setMemberAccountId(memberAccount);
				emaEB.setMemberGroupId(mstEmployerMemberGroupOptional.get());
				employerMemberAccount = employerMemberAccountRepository.save(emaEB.buildCreateEntity(requestDto, null));

				employerMemberAccountResponseDto = employerMemberAccountResponseDtoBuilder.buildCreateResponseDto(employerMemberAccount);

			}

			//1.5) Create person_address record(s) and person_address_reference
			if ((req.getPersonAddressCreateRequestList()!=null) &&
					(!req.getPersonAddressCreateRequestList().isEmpty())) {
				
				personAddressResponseDtoList = new ArrayList<>();
				
				for (PersonAddressRequestChild3 aReq : req.getPersonAddressCreateRequestList()) {

					PersonAddressRequestChild2 convPersonAddress = (PersonAddressRequestChild2) convert(
																						aReq,PersonAddressRequestChild2.class);
					convPersonAddress.setPersonId(opPerson.get().getId());

					PersonAddressReferenceRequestChild1 convReference = (PersonAddressReferenceRequestChild1) convert(
																						aReq.getPersonAddressReferenceRequest(),
																							PersonAddressReferenceRequestChild1.class);
					
					convReference.setReferenceTableCodeId(opMstPersonReferenceTable.get().getId());
					convReference.setReferenceTableEntityClass(REFERENCE_TABLE_ENTITY_CLASS);
					convReference.setReferenceTableId(employerMemberAccount.getId());
					convPersonAddress.setPersonAddressReferenceRequest(convReference);
					personAddressResponseDtoList.add(personAddressServiceNew.processPersonAddress(convPersonAddress,aReq.getId()));
					
				}
				
			}
			
			//1.6) Create person_contact records(s)
			if ((req.getPersonContactCreateRequestList()!=null) &&
							(!req.getPersonContactCreateRequestList().isEmpty())) {
				
				personContactResponseDtoList = new ArrayList<>();
				
				for (PersonContactRequestChild3 cReq : req.getPersonContactCreateRequestList()) {
					
					PersonContactRequestChild2 convPersonContact = (PersonContactRequestChild2) convert(
																						cReq, PersonContactRequestChild2.class);
					convPersonContact.setPersonId(opPerson.get().getId());
					
					PersonContactReferenceRequestChild1 convReference = (PersonContactReferenceRequestChild1) convert(
																							cReq.getPersonContactReferenceRequest(),
																							PersonContactReferenceRequestChild1.class);
					
					convReference.setReferenceTableCodeId(opMstPersonReferenceTable.get().getId());
					convReference.setReferenceTableEntityClass(REFERENCE_TABLE_ENTITY_CLASS);
					convReference.setReferenceTableId(employerMemberAccount.getId());
					convPersonContact.setPersonContactReferenceRequest(convReference);
					personContactResponseDtoList.add(personContactServiceNew.processPersonContact(convPersonContact,cReq.getId()));
					
				}
			}

			//1.7) Create transaction record
			TransactionRequestDto transactionDto = TransactionRequestDto.builder()
																			.note(null)
																			.build();
			
			TransactionEntityBuilder txnEB = new TransactionEntityBuilder();
			txnEB.setActionId(opMstTxnAction.isPresent()?opMstTxnAction.get():null);
			txnEB.setCreatedBy(opUser.isPresent()?opUser.get():null);
			txnEB.setCreatedOrganization(opOrganization.isPresent()?opOrganization.get():null);
			Transaction transaction = transactionRepository.save(txnEB.buildCreateEntity(transactionDto, null));
			
			//1.8) Create txn_member record
			TxnMemberEntityBuilder txnmEB = new TxnMemberEntityBuilder();
			txnmEB.setMemberId(opMember1.get());
			txnmEB.setTransactionId(transaction);
			txnmEB.setMemberAccountId(memberAccount);
			txnmEB.setMemberAccountStatusHistoryId(accountStatusHistory);
			txnMemberRepository.save(txnmEB.buildCreateEntity(new TxnMemberRequestDto(), null));

		} else {
			//2) Person does not exist
			Optional<Member1> opDummyMember = member1Repository.findByVerificationDummy(true);
			
			//Note : Moving the Profile Picture file from Temp location to DMS location
			if((req.getPersonGeneralRequest().getProfilePictureDocUploadedId()!=null)
					&&(req.getPersonGeneralRequest().getProfilePictureDocUploadedId()>0)) {
				List<Long> lstDocId = new ArrayList();
				lstDocId.add(req.getPersonGeneralRequest().getProfilePictureDocUploadedId());
				
				DocumentUpdateRequest duRequest = new DocumentUpdateRequest(PROFILE_PIC_DOCUMENT_UPLOAD_MODULE, lstDocId);
				documentService.updateDmsRefParentRef(duRequest);
			}
			
			//2.1) Create person_general record
			PersonGeneralRequestChild1 pgRequest = (PersonGeneralRequestChild1) convert(
					req.getPersonGeneralRequest(), PersonGeneralRequestChild1.class);
			pgRequest.setReferenceTableId(PG_REFERENCE_TABLE_ID);
			pgRequest.setPreferredLanguageCode(opLang.isPresent()?opLang.get().getCode():null);//20200822
			personGeneralResponseDto = personGeneralServiceNew.create(pgRequest);
			personGeneral = new PersonGeneral(personGeneralResponseDto.getId());

			//2.1) Create person_general_nic
			if (req.getPersonGeneralNicRquest() != null) {
				PersonGeneralNicRequestChild1 pgnRequest = (PersonGeneralNicRequestChild1) convert(
						req.getPersonGeneralNicRquest(), PersonGeneralNicRequestChild1.class);
				pgnRequest.setPersonGeneralId(personGeneral.getId());
				pgnRequest.setReferenceTableId(PG_REFERENCE_TABLE_ID);
				personGeneralNicResponseDto = personGeneralNicServiceNew.create(pgnRequest);

			}
			
			//2.2) Create person_general_passport
			if (req.getPersonGeneralPassportRquest() != null) {
				PersonGeneralPassportRequestChild1 personGeneralPassportRequest = (PersonGeneralPassportRequestChild1) convert(
						req.getPersonGeneralPassportRquest(), PersonGeneralPassportRequestChild1.class);
				personGeneralPassportRequest.setReferenceTableId(PG_REFERENCE_TABLE_ID);
				personGeneralPassportRequest.setPersonGeneralId(personGeneral.getId());
				personGeneralPassportResponseDto = personGeneralPassportServiceNew.create(personGeneralPassportRequest);

			}

			Optional<MstPriority> opPriority = mstPriorityValidator.validate(MEM_VERIFICATION_PRIORITY);
			Optional<MstMemberPersonVerificationRequestType> opMemPerVerifRequestType = 
					memberPersonVerificationRequestTypeValidator.validateByCode(REQUEST_TYPE_CODE);
			Optional<MstMemberPersonVerificationRequestSource> memberPersonVerificationRequestSource = 
					memberPersonVerificationRequestSourceValidator.validateByCode(REQUEST_SOURCE_CODE);
			Optional<MstVerificationRequestStatus> verificationRequestStatus = 
					verificationRequestStatusValidator.validateByCode(STATUS);
			Optional<MstVerificationStatus> verificationStatus = 
					verificationStatusValidator.validateByCode(STATUS_VERIFICATION);

			MemberPersonVerificationRequestRequestDto verificationReqDto = MemberPersonVerificationRequestRequestDto.builder()
					.refNo(refNoUtil.getRefNumber("member_person_verification_request")).build();
			
			//2.3) Create member_person_verification_request
			MemberPersonVerificationRequestEntityBuilder mpvrEB = new MemberPersonVerificationRequestEntityBuilder();
			mpvrEB.setCreatedBy(opUser.isPresent()?opUser.get():null);
			mpvrEB.setCreatedOrganization(opOrganization.isPresent() ? opOrganization.get():null);
			mpvrEB.setPriorityId(opPriority.isPresent()?opPriority.get():null);
			mpvrEB.setRequestTypeId(opMemPerVerifRequestType.get());
			mpvrEB.setRequestSourceId(memberPersonVerificationRequestSource.get());
			mpvrEB.setPersonGeneralId(personGeneral);
			mpvrEB.setStatusId(verificationRequestStatus.get());
			mpvrEB.setStatusBy(opUser.isPresent()?opUser.get():null);
			mpvrEB.setVerificationStatusId(verificationStatus.get());

			memberPersonVerificationRequest = memberPersonVerificationRequestRepository
																		.save(mpvrEB.buildCreateEntity(verificationReqDto, null));

			//2.4) Create member_person_verification_request_status_history
			MemberPersonVerificationRequestHistoryEntityBuilder mpvhrEB = new MemberPersonVerificationRequestHistoryEntityBuilder();
			memberPersonVerificationRequestStatusHistoryRepository.save(mpvhrEB.buildHistoryEntity(memberPersonVerificationRequest));

			//2.5) Create member_account
			MemberAccountRequestDto memberAccountRequestDto = MemberAccountRequestDto.builder()
					.refNo(refNoUtil.getRefNumber("member_account")).build();
			
			MemberAccountEntityBuilder maEB = new MemberAccountEntityBuilder();
			maEB.setCreatedBy(opUser.get());
			maEB.setCreatedOrganization(opOrganization.get());
			maEB.setStatusBy(opUser.get());
			maEB.setStatusOrganization(opOrganization.get());
			maEB.setStatusId(mstMemberAccountStatusOptional.get());
			maEB.setMemberPersonVerificationRequestId(memberPersonVerificationRequest);
			maEB.setMemberId(opDummyMember.get());
			maEB.setAccountTypeId(mstMemberAccountTypeOptional.get());
			memberAccount = memberAccountRepository.save(maEB.buildCreateEntity(memberAccountRequestDto, null));
			
			//2.6) Create member_account_status_history
			MemberAccountStatusHistoryEntityBuilder statusHistoryEntityBuilder = new MemberAccountStatusHistoryEntityBuilder();
			statusHistoryEntityBuilder.setCreatedBy(opUser.get());
			statusHistoryEntityBuilder.setCreatedOrganization(opOrganization.get());
			statusHistoryEntityBuilder.setMemberAccountId(memberAccount);
			statusHistoryEntityBuilder.setMemberAccountStatusId(memberAccount.getStatusId());
			MemberAccountStatusHistory accountStatusHistory = memberAccountStatusHistoryRepository
					.save(statusHistoryEntityBuilder.buildCreateEntity(null, null));

			//Note : Member number should be unique for a given employee at an organization. This is not unique in the table.
			//       If the column was made unique then another employer could not have an employee with the same member number.
			EmployerMemberAccount ema = emAccountRepository.findByEmployerIdAndMemberNo(requestDto.getMemberNo(), opEmployer.get().getId());
			if(ema!=null) {
				throw new ApplicationException("Member No. already exists"); //TODO : Get message from config
				
			}else {
				
				EmployerMemberNoUniqueRequestDto emnuRequestDTO = EmployerMemberNoUniqueRequestDto.builder()
																						.employer(opEmployer.get().getId())
																						.memberNo(requestDto.getMemberNo())
																						.build();
				
				EmployerMemberNoUniqueEntityBuilder emnuEB = new EmployerMemberNoUniqueEntityBuilder();
				emnuEB.setEmployer(opEmployer.get());
				EmployerMemberNoUnique employerMemberNoUnique = emnuEB.buildCreateEntity(emnuRequestDTO,null);
				try {
					employerMemberNoUniqueRepository.save(employerMemberNoUnique);
				} catch (Exception e) {
					throw new ApplicationException("Member No. already exists"); //TODO : Get message from config
					
				}
				
				//2.7) Create employer_member_account record
				EmployerMemberAccountEntityBuilder emaEB = new EmployerMemberAccountEntityBuilder();
				emaEB.setCreatedBy(opUser.get());
				emaEB.setCreatedOrganization(opOrganization.get());
				emaEB.setStatusBy(opUser.get());
				emaEB.setStatusOrganization(opOrganization.get());
				emaEB.setStatusId(mstEmployerMemberAccountStatusOptional.get());
				emaEB.setEmployerId(opEmployer.get());
				emaEB.setMemberAccountId(memberAccount);
				emaEB.setMemberGroupId(mstEmployerMemberGroupOptional.get());
				employerMemberAccount = employerMemberAccountRepository.save(emaEB.buildCreateEntity(requestDto, null));

				employerMemberAccountResponseDto = employerMemberAccountResponseDtoBuilder.buildCreateResponseDto(employerMemberAccount);

			}

			//2.8) Create person_general_address list
			if ( (req.getAddressList()!=null) && (!req.getAddressList().isEmpty()) ) {
				personGeneralAddressResponseDtoList = new ArrayList<>();
				for (PersonGeneralAddressRequestChild3 addressReq : req.getAddressList()) {
					PersonGeneralAddressRequestChild2 pgaRequest = (PersonGeneralAddressRequestChild2) convert(
							addressReq, PersonGeneralAddressRequestChild2.class);
					pgaRequest.setActive(addressReq.isActive());
					pgaRequest.setReferenceTableId(PG_REFERENCE_TABLE_ID);
					pgaRequest.setPersonGeneralId(personGeneral.getId());
					pgaRequest.setReferenceTableCodeId(opMstPersonReferenceTable.get().getId());
					pgaRequest.setReferenceTableKey(employerMemberAccount.getId());
					pgaRequest.setPersonGeneralAddressReferenceRequest(addressReq.getPersonGeneralAddressReferenceRequest());

					PersonGeneralAddressResponseDto addressResponse = personGeneralAddressServiceNew.create(pgaRequest);
					personGeneralAddressResponseDtoList.add(addressResponse);
				}

			}

			//2.9) Create person_general_contact list
			if ((req.getContactList()!=null) && (!req.getContactList().isEmpty())){
				personGeneralContactResponseDtoList = new ArrayList<>();
				for (PersonGeneralContactRequestChild3 contactReq : req.getContactList()) {
					
					PersonGeneralContactRequestChild2 pgcRequest = (PersonGeneralContactRequestChild2) convert(
							contactReq, PersonGeneralContactRequestChild2.class);
					pgcRequest.setActive(contactReq.isActive());
					pgcRequest.setReferenceTableId(PG_REFERENCE_TABLE_ID);
					pgcRequest.setPersonGeneralId(personGeneral.getId());
					pgcRequest.setReferenceTableCodeId(opMstPersonReferenceTable.get().getId());
					pgcRequest.setReferenceTableKey(employerMemberAccount.getId());
					pgcRequest.setPersonGeneralContactReferenceRequest(contactReq.getPersonGeneralContactReferenceRequest());

					PersonGeneralContactResponseDto contactResponse = personGeneralContactServiceNew.create(pgcRequest);
					personGeneralContactResponseDtoList.add(contactResponse);
					
				}

			}

			//Create transaction record
			TransactionRequestDto transactionDto = TransactionRequestDto.builder()
																			.note(NoteFormatter.getFormattedNote(null,"Employment creation with new person.",opUser.get().getDisplayName()))
																			.build();
			
			TransactionEntityBuilder txnEB = new TransactionEntityBuilder();
			txnEB.setActionId(opMstTxnAction.isPresent()?opMstTxnAction.get():null);
			txnEB.setCreatedBy(opUser.isPresent()?opUser.get():null);
			txnEB.setCreatedOrganization(opOrganization.isPresent()?opOrganization.get():null);
			Transaction transaction = transactionRepository.save(txnEB.buildCreateEntity(transactionDto, null));
			
			//Create txn_member record
			TxnMemberEntityBuilder txnmEB = new TxnMemberEntityBuilder();
			txnmEB.setMemberId(opDummyMember.get());
			txnmEB.setTransactionId(transaction);
			txnmEB.setMemberAccountId(memberAccount);
			txnmEB.setMemberAccountStatusHistoryId(accountStatusHistory);
			txnMemberRepository.save(txnmEB.buildCreateEntity(new TxnMemberRequestDto(), null));

		}
		
		//TODO 20200706 :: Need to check nominee scenrios, since they were omitted
		//3) Nominee Details
		if ((req.getMemberAccountNomineeRequest()!=null)
				&&(!req.getMemberAccountNomineeRequest().isEmpty())) {
			
			memberAccountNomineeResponseDtoList = new ArrayList<>();
			for (MemberAccountNomineeRequestChild3 MemberAccountNomineeRequest : req.getMemberAccountNomineeRequest()) {
				MemberAccountNomineeRequestChild2 convertedRequest = (MemberAccountNomineeRequestChild2) convert(
						MemberAccountNomineeRequest, MemberAccountNomineeRequestChild2.class);
				convertedRequest.setMemberAccountRefNo(memberAccount.getRefNo());
				MemberAccountNomineeResponseDtoChild1 MemberAccountNomineeResponseDto = memberAccountNomineeService
						.create(convertedRequest);
				memberAccountNomineeResponseDtoList.add(MemberAccountNomineeResponseDto);
			}

		}
		
		//4) Create employer_employment_request_service_counter_dmu
		EmployerEmploymentRequestServiceCounterDmuRequestDto eerscdRDTO = EmployerEmploymentRequestServiceCounterDmuRequestDto
																			.builder()
																			.actionType(1)
																			.build();
		EmployerEmploymentRequestServiceCounterDmuEntityBuilder eerscdEB = new EmployerEmploymentRequestServiceCounterDmuEntityBuilder();
		eerscdEB.setCreatedBy(opUser.get());
		eerscdEB.setCreatedOrganization(opOrganization.get());
		eerscdEB.setEmployerMemberAccountId(employerMemberAccount);
		//eerscdEB.setMemberAccountNomineeId(null);

		EmployerEmploymentRequestServiceCounterDmu eerscdE = employerEmploymentRequestServiceCounterDmuRepository
																						.save(eerscdEB.buildCreateEntity(eerscdRDTO, null));
		
		//5) Create employer_interim_member_account
		EmployerInterimMemberAccountHistoryEntityBuilder eimahEB = new EmployerInterimMemberAccountHistoryEntityBuilder();
		eimahEB.setMemberPersonVerificationRequest(memberPersonVerificationRequest);
		eimahEB.setPerson(opPerson.isPresent()?opPerson.get():null);
		eimahEB.setPersonGeneral(personGeneral);
		EmployerInterimMemberAccount eimaE = employerInterimMemberAccountRepository
																	.save(eimahEB.buildHistoryEntity(employerMemberAccount));
		
		//6) Create employer_member_account_history
		EmployerMemberAccountHistoryEntityBuilder emahEB = new EmployerMemberAccountHistoryEntityBuilder();
		emahEB.setCreatedBy(opUser.get());
		emahEB.setCreatedOrganization(opOrganization.get());
		emahEB.setEmployerEmploymentRequestServiceCounterDmuId(eerscdE);
		emahEB.setEmployerMemberAccountId(employerMemberAccount);
		emahEB.setEmployerInterimMemberAccountId(eimaE);
		employerMemberAccountHistoryRepository.save(emahEB.buildCreateEntity(null, null));

		//7) Create employer_member_document
		if ( (req.getEmployerMemberDocumentRequest()!=null) &&
					(!req.getEmployerMemberDocumentRequest().isEmpty())) {
			
			//Note :: Moving file to DMS
			//20200710 - According to Achini's comments this push was done first. Reason not so sure. If the same block of code was
			//done after the next loop, this part fails.
			List<Long> lstDocId = new ArrayList();
			for (EmployerMemberDocumentRequest documentRequest : req.getEmployerMemberDocumentRequest()) {
				lstDocId.add(documentRequest.getDocumentUploadedId());
			}
			DocumentUpdateRequest duRequest = new DocumentUpdateRequest(PROFILE_PIC_DOCUMENT_UPLOAD_MODULE,lstDocId);
			documentService.updateDmsRefParentRef(duRequest);
			
			employerMemberDocumentResponseDtoList = new ArrayList<>();
			for (EmployerMemberDocumentRequest documentRequest : req.getEmployerMemberDocumentRequest()) {
				
				EmployerMemberDocumentRequestDto emdRequestDTO = employerMemberDocumentRequestDtoBuilder
																							.buildCreateDto(documentRequest, null);
				Optional<DocumentUploaded> opDocumentUploaded = documentUploadedValidator.validate(emdRequestDTO.getDocumentUploadedId());

				EmployerMemberDocumentEntityBuilder emdEB = new EmployerMemberDocumentEntityBuilder();
				emdEB.setEmployerMemberAccountId(employerMemberAccount);
				emdEB.setDocumentUploadedId(opDocumentUploaded.isPresent()?opDocumentUploaded.get():null);

				EmployerMemberDocument employerMemberDocument = 
															employerMemberDocumentRepository.save(emdEB.buildCreateEntity(emdRequestDTO, null));
				
				EmployerMemberDocumentResponseDto edResponseDTO = employerMemberDocumentResponseDtoBuilder
																								.buildCreateResponseDto(employerMemberDocument);
				employerMemberDocumentResponseDtoList.add(edResponseDTO);
				
			}

		}

//		employerMemberAccountResponseDto.setPersonAddressResponseDtoList(personAddressResponseDtoList);
//		employerMemberAccountResponseDto.setPersonContactResponseDtoList(personContactResponseDtoList);
//		employerMemberAccountResponseDto.setPersonGeneralResponseDto(personGeneralResponseDto);
//		employerMemberAccountResponseDto.setPersonGeneralNicResponseDto(personGeneralNicResponseDto);
//		employerMemberAccountResponseDto.setPersonGeneralPassportResponseDto(personGeneralPassportResponseDto);
//		employerMemberAccountResponseDto.setPersonGeneralAddressResponseDtoList(personGeneralAddressResponseDtoList);
//		employerMemberAccountResponseDto.setPersonGeneralContactResponseDtoList(personGeneralContactResponseDtoList);
//		employerMemberAccountResponseDto
//				.setEmployerMemberDocumentResponseDtoList(employerMemberDocumentResponseDtoList);
//		employerMemberAccountResponseDto.setMemberAccountNomineeResponseDtoList(memberAccountNomineeResponseDtoList);
		return employerMemberAccountResponseDto;
	}
	//1.0.3 - End
	
	//1.0.1 :: Start
	@Override
	@MethodLogging
	@Transactional(rollbackFor=ApplicationException.class)
	public CountResponseDto getEmployerMemberCount(EmployerMemberCountRequest request) throws ApplicationException {

		//Validate request
		Optional<Employer> employerOptional = employerValidator.validate(request.getEmpId());
		Long statusId = (request.getStatusId()!=0) ? mstEmployerMemberAccountStatusValidator.validate(request.getStatusId()).get().getId() : 0L;

		return employerMemberManagementDao.getEmployerMemberCount(employerOptional.get().getId(), statusId);
	}

	@Override
	@MethodLogging
	@Transactional(rollbackFor=ApplicationException.class)
	public List<EmployerMemberAccountResponseDtoChild2> search(EmployerManageMemberSearchRequest request) throws ApplicationException {
		//TODO :: Validate request
		return employerMemberManagementDao.searchEmployerMemberAccount(request);
	}
	
	@Override
	@MethodLogging
	@Transactional(rollbackFor=ApplicationException.class)
	public EmployerMemberAccountResponseDtoChild2 getEmployerMemberAccountById(Long empMemAccId) throws ApplicationException {
		//Validate
		Optional<EmployerMemberAccount> employerOptional = employerMemberAccountValidator.validate(empMemAccId);
		return employerMemberManagementDao.getEmployerMemberAccountDetails(empMemAccId);
	}
	//1.0.1 :: End
	//1.0.2 :: Start
	@Override
	@MethodLogging
	@Transactional(rollbackFor = ApplicationException.class)
	public UpdateEmploymentResponseDto updateEmployment(UpdateEmploymentRequest request) throws ApplicationException {
		
		UpdateEmploymentResponseDto response = new UpdateEmploymentResponseDto();
		
		Long PERSON_GEN_REF_TBL_ID=1L;
		//mst_member_person_verification_request_type -> 6, CRTEMP, Create Employment,This is for create Employment
		String UPDATE_REQUEST_TYPE="CRTEMP";
		//mst_member_person_verification_request_source -> 2, ETFBMEMMG, ETFB Member management
		String UPDATE_REQUEST_SOURCE="ETFBMEMMG";
		String NOMINEE_PERSON_REFERENCE="MEMACCNOM";
		//Action type employer_employment_request_service_counter_dmu
		Integer EERSCDMU_ACTION_TYPE=2;
		
		PersonGeneralResponseDtoChild2 pgResponseDto = null;
		PersonGeneralNicResponseDto pgNICResponseDto = null;
		PersonGeneralPassportResponseDto pfPassResponseDto = null;
		
		//Validate
		//Note:These would need to be replaced by actual values later. There is a hardcoded value	
		//Optional<User> optionalUser = userValidator.validate(userUtil.getUserId("replace_me"));
		//Optional<Organization> optionalOrganization = organizationValidator
		//										.validate(organizationUtil.getOrganizationId("replace_me"));
		//TODO 20200725 :: Hardcoding the IDs because an issue came up that could not retrieve the hardcoded person and
		//			  organization in the DB. BUT THIS SHOULD BE FIXED LATER!!
		Optional<User> optionalUser = userValidator.validate(1L);
		Optional<Organization> optionalOrganization = organizationValidator.validate(1L);

		//Priority of the request -> mst_priority ->2,Normal,1,1
		Optional<MstPriority> optinalPriority = mstPriorityValidator.validate(2L);
		//mst_person_reference_table -> Code EMPMEMACC
		Optional<MstPersonReferenceTable> opPersonReference = mstPersonReferenceTableValidator.validateByCode(REFERENCE_TABLE_CODE);
		///mst_person_reference_table -> Code MEMACCNOM
		Optional<MstPersonReferenceTable> opNomineePersonReference = mstPersonReferenceTableValidator.validateByCode(NOMINEE_PERSON_REFERENCE);
		
		//1010 (Employment Update) for action_id
		Optional<MstTxnAction> opMstTxnAction = mstTxnActionValidator.validateByActionNo(1010L);
		
		Optional<EmployerMemberAccount> empMemAcc = employerMemberAccountValidator.validate(request.getEmployerMemberAccountId());

		//Get member account
		Optional<MemberAccount> opMemberAccount = memberAccountRepository.findById(empMemAcc.get().getMemberAccountId().getId());
		//Get person for relevant member
		Person memPerson = opMemberAccount.get().getMemberId().getPersonId();
		
		//Need to do a person change
		if(request.getIsChangePerson()) {
			//1)Delete Person Address Reference entries
			//Reference table code is employer_member_account, and the id is employer_member_account id which is set
			// in the reference table's reference_table_id field.
			personAddressReferenceService.deleteAddressRefByRefTbleCodeAndRefTblId(REFERENCE_TABLE_CODE, empMemAcc.get().getId());
			personContactReferenceService.deleteContactRefByRefTbleCodeAndRefTblId(REFERENCE_TABLE_CODE, empMemAcc.get().getId());

			//2) Checking if person found or not found. If not found will need to create a person and
			//	 send it through the verification process. A person isn't created immediately as expected.
			if(request.getIsPersonFound()) {
				//3) If person found from the search then need to attach that person to member account table.
				Optional<Person> opPerson = personValidator.validate(request.getPersonId());
				Optional<Member1> opMember = member1Repository.findByPersonId(opPerson.get());
				MemberAccount maEntity = null;
				
				//There are persons who are not members in the system. In such case the person
				//should be made a member and then proceeded. 
				if(opMember.isPresent()) {
					opMemberAccount.get().setMemberId(opMember.get());
				}else { //Handling scenario where found person is not a member at the moment.
					
					//20200804 As per Mr. Devage's comment handling this is not a requirement at the
					//moment. Also it was said that a verification process isn't set to this scenario.
					Optional<MstMemberCreatedSource> opCreatedSource =  mmcsValidator.validateByCode(MEMBER_CREATED_SOURCE);
							
					//Create member
					Member1RequestDto mrDTO = Member1RequestDto.builder()
												.note(NoteFormatter.getFormattedNote(null,"Creating member, at update employment", optionalUser.get().getDisplayName()))
												.verificationDummy(false)
												.migrated(false)
												.build();
					
					Member1EntityBuilder mEB = new Member1EntityBuilder();
					mEB.setCreatedBy(optionalUser.get());
					mEB.setCreatedOrganization(optionalOrganization.get());
					mEB.setPersonId(opPerson.get());
					mEB.setCreatedSourceId(opCreatedSource.get());
					
					Member1 mE = member1Repository.save(mEB.buildCreateEntity(mrDTO,null));
					opMemberAccount.get().setMemberId(mE);
				}
				
				opMemberAccount.get().setUpdatedBy(optionalUser.get());
				opMemberAccount.get().setUpdatedOrganizationId(optionalOrganization.get());
				
				maEntity = memberAccountRepository.save(opMemberAccount.get());

				response.setMemAccResponse(MemberAccountResponseDto.builder()
						.id(maEntity.getId())
						.memberId(maEntity.getMemberId().getId())
						.statusId(maEntity.getStatusId().getId())
						.refNo(maEntity.getRefNo())
						.prefixRefNo(maEntity.getPrefixRefNo())
						.accountTypeId(maEntity.getAccountTypeId().getId())
						.build());

			}else {
				if(request.getPersonGeneral()!=null) {
					//4) If person does not exist need to create that person and attach that person
					//Until the verification process is clear a dummy person is created. The dummy person
					//is a meta data that should be available in the system after data migration.
					Optional<Member1> dummyMember = member1Repository.findByVerificationDummy(true);
					
					//4.1)Create Person General
					//20200514 as per discussion with Mr. Devage this field is set to know where the person_general
					//refers to. In this case it is going through a person verification. So it is set to "1".
					//1,Member Person Verification Request,member_person_verification_request,person_general_id
					request.getPersonGeneral().setReferenceTableId(PERSON_GEN_REF_TBL_ID);
					pgResponseDto = personGeneralServiceNew.create(request.getPersonGeneral());
					
					//Note :: NIC is not mandatory, this object could be null
					//4.2)Create Person General NIC
					if (request.getPersonGeneral().getPgNicRequest()!=null) {
						request.getPersonGeneral().getPgNicRequest().setActive(true);	//Always active in this case
						request.getPersonGeneral().getPgNicRequest().setPersonGeneralId(pgResponseDto.getId());
						request.getPersonGeneral().getPgNicRequest().setReferenceTableId(PERSON_GEN_REF_TBL_ID);
						
						pgNICResponseDto = personGeneralNicServiceNew.create(request.getPersonGeneral().getPgNicRequest());
					}
					
					//Note :: Passport is not mandatory, this object could be null
					//4.3) Create Person General Passport
					if (request.getPersonGeneral().getPgPassportRequest() != null) {
						request.getPersonGeneral().getPgPassportRequest().setActive(true);	//Always active in this case
						request.getPersonGeneral().getPgPassportRequest().setPersonGeneralId(pgResponseDto.getId());
						request.getPersonGeneral().getPgPassportRequest().setReferenceTableId(PERSON_GEN_REF_TBL_ID);
						
						pfPassResponseDto = personGeneralPassportServiceNew.create(request.getPersonGeneral().getPgPassportRequest());
					}

					//4.4) Create member person verification request
					//4.4.1) Certain validations related to member person verification
					Optional<MstMemberPersonVerificationRequestType> memPerVerifReqType = memberPersonVerificationRequestTypeValidator.validateByCode(UPDATE_REQUEST_TYPE);
					Optional<MstMemberPersonVerificationRequestSource> memPerVerifReqSource = memberPersonVerificationRequestSourceValidator.validateByCode(UPDATE_REQUEST_SOURCE);
					Optional<MstVerificationRequestStatus> verifReqStatus = verificationRequestStatusValidator.validateByCode(STATUS);	//Un-Assigned
					Optional<MstVerificationStatus> verifStatus = verificationStatusValidator.validateByCode(STATUS_VERIFICATION);		//Verification Pending
					Optional<PersonGeneral> personGeneral = personGeneralValidator.validate(pgResponseDto.getId());
					
					//4.4.2) Creating verification request DTO
					//Note : When checking the RefNoUtil class this is a class that randomly generates a number
					MemberPersonVerificationRequestRequestDto mpvReqDto = 
															MemberPersonVerificationRequestRequestDto.builder()
																.refNo(refNoUtil.getRefNumber("member_person_verification_request"))
																.build();

					//4.4.3) Entity creation and Save
					MemberPersonVerificationRequestEntityBuilder mpvrEB = new MemberPersonVerificationRequestEntityBuilder();
					mpvrEB.setCreatedBy(optionalUser.isPresent()?optionalUser.get():null);
					mpvrEB.setCreatedOrganization(optionalOrganization.isPresent()?optionalOrganization.get():null);
					mpvrEB.setPriorityId(optinalPriority.isPresent()?optinalPriority.get():null);
					mpvrEB.setRequestTypeId(memPerVerifReqType.get());
					mpvrEB.setRequestSourceId(memPerVerifReqSource.get());
					mpvrEB.setPersonGeneralId(personGeneral.get());
					mpvrEB.setStatusId(verifReqStatus.get());
					mpvrEB.setStatusBy(optionalUser.isPresent()?optionalUser.get():null);
					mpvrEB.setVerificationStatusId(verifStatus.get());
					
					MemberPersonVerificationRequest memPerVerifRequest = memberPersonVerificationRequestRepository.save(mpvrEB.buildCreateEntity(mpvReqDto,null));
					
					//5) Create member_person_verification_request_status_history
					MemberPersonVerificationRequestHistoryEntityBuilder mpvrhEB = new MemberPersonVerificationRequestHistoryEntityBuilder();
					memberPersonVerificationRequestStatusHistoryRepository.save(mpvrhEB.buildHistoryEntity(memPerVerifRequest));

					//6) Update Member Account
					//Note : A verification process finalizes these changes, therefore a dummy member is attached to the member account
					// that is being updated.
					opMemberAccount.get().setMemberId(dummyMember.get());
					opMemberAccount.get().setMemberPersonVerificationRequestId(memPerVerifRequest);
					MemberAccount maEntity = memberAccountRepository.save(opMemberAccount.get());

						response.setMemAccResponse(MemberAccountResponseDto.builder()
								.id(maEntity.getId())
								.memberId(maEntity.getMemberId().getId())
								.statusId(maEntity.getStatusId().getId())
								.refNo(maEntity.getRefNo())
								.prefixRefNo(maEntity.getPrefixRefNo())
								.accountTypeId(maEntity.getAccountTypeId().getId())
								.build());
					
				}else{
					//Note :: If person not found and the data needed for person creation is not found
					throw new ApplicationException("Person details needed for person creation not found in request");
				}
			}
			
		}else {//Need to do an Employment Info Change

			//Validate person ID of releavant member account
			//Optional<Person> opPerson = personValidator.validate(request.getPersonId());
			Optional<Person> opPerson = personValidator.validate(memPerson.getId());
			
			if(request.getEmAccountDetails()!=null) {

				//Validation
				Optional<ServiceCounterRequirementType> scReqType = Optional.empty();
				if(request.getScReqTypeId()!=null) {
					scReqType = scReqTypeValidator.validate(request.getScReqTypeId());
				}
				Optional<DmuInbound> dmuInbound = Optional.empty(); 
				if(request.getDmuInboundId()!=null) {
					 dmuInbound = dmuInboundValidator.validate(request.getDmuInboundId());
				}
				
				//Validate selected member group id
				Optional<MstEmployerMemberGroup> opMstEmpMemGroup = Optional.empty();
				if(request.getEmAccountDetails().getMemberGroupId()!=null) {
					opMstEmpMemGroup= mstEmployerMemberGroupValidator.validate(request.getEmAccountDetails().getMemberGroupId());
				}else if(request.getEmAccountDetails().getMemberGroupCode()!=null) {
					opMstEmpMemGroup= mstEmployerMemberGroupValidator.validateByCode(request.getEmAccountDetails().getMemberGroupCode());
				}
				//Validate selected preferred language
				Optional<MstLanguage> opMstLang = Optional.empty();
				//if(request.getEmAccountDetails().getPrefLangCode()!=null) {
					opMstLang = mstLanguageValidator.validateByCode(request.getEmAccountDetails().getPrefLangCode());
				//}
				
				//4a) Update employer member account
				//Note :: This needs to be set since builder in next line uses it. There may be a case in the future where
				//			this may need to be taken from the client side inorder to update the employer. For now it is
				//			safe to set this internally.
				EmployerMemberAccount emaEntity = empMemAcc.get();
				//Setting necessary fields that are sent from client, the rest are as they are found in the retrieved entity
				EmployerMemberAccountRequestDto emaRDTO = EmployerMemberAccountRequestDto.builder()
																.memberNo((request.getEmAccountDetails().getMemberNo()!= 0)
																				?request.getEmAccountDetails().getMemberNo():emaEntity.getMemberNo())
																.dateJoined((request.getEmAccountDetails().getDateJoined()!=null)
																				?request.getEmAccountDetails().getDateJoined():emaEntity.getDateJoined())
																.designation((request.getEmAccountDetails().getDesignation()!=null)
																				?request.getEmAccountDetails().getDesignation():emaEntity.getDesignation())
																.salary((request.getEmAccountDetails().getSalary()!=null)
																				?request.getEmAccountDetails().getSalary():emaEntity.getSalary())
																.salaryEtfb((request.getEmAccountDetails().getSalaryEtfb()!=null)
																				?request.getEmAccountDetails().getSalaryEtfb():emaEntity.getSalaryEtfb())
																.dateTerminated((request.getEmAccountDetails().getDateTerminated()!=null)
																				?request.getEmAccountDetails().getDateTerminated():emaEntity.getDateTerminated())
																.legacyEpfNo((request.getEmAccountDetails().getLegacyEpfNo()!=null)
																				?request.getEmAccountDetails().getLegacyEpfNo():emaEntity.getLegacyEpfNo())
																.legacyMemberNo(emaEntity.getLegacyMemberNo())
																.memberTerminated(emaEntity.getMemberTerminated())
																.migrated(emaEntity.getMigrated())
																.note(NoteFormatter.getFormattedNote(emaEntity.getNote(),
																	((request.getEmAccountDetails().getNote()!=null)?request.getEmAccountDetails().getNote():"Updating employment"),
																	optionalUser.get().getDisplayName()))
																.notePublic(NoteFormatter.getFormattedNote(emaEntity.getNotePublic(),
																		((request.getEmAccountDetails().getNote()!=null)?request.getEmAccountDetails().getNote():"Updating employment"),
																		optionalUser.get().getDisplayName()))
																.showMemberFullInformation(emaEntity.getShowMemberFullInformation())
																.build();

				//Entity builder level objects need to be set
				EmployerMemberAccountEntityBuilder emaEB = new EmployerMemberAccountEntityBuilder();
				emaEB.setStatusId(emaEntity.getStatusId());
				emaEB.setMergedParentEmployerMemberAccountId(emaEntity.getMergedParentEmployerMemberAccountId());
				emaEB.setBulkUploadItemId(emaEntity.getBulkUploadItemId());
				emaEB.setEmployerId(emaEntity.getEmployerId());
				emaEB.setBulkUploadId(emaEntity.getBulkUploadId());
				emaEB.setMemberAccountId(emaEntity.getMemberAccountId());
				emaEB.setMemberGroupId((opMstEmpMemGroup.isPresent())?opMstEmpMemGroup.get():emaEntity.getMemberGroupId());
				emaEB.setUpdatedBy(optionalUser.isPresent()?optionalUser.get():null);
				emaEB.setUpdatedOrganization(optionalOrganization.isPresent()?optionalOrganization.get():null);
				
				emaEntity = employerMemberAccountRepository.save(emaEB.buildUpdateEntity(emaRDTO, emaEntity));
				
				//20200608 according to Mr. Devage the perf language should be updated eventhough person and employer member are
				// in two seperate levels.
				memPerson.setUpdatedBy(optionalUser.isPresent()?optionalUser.get():null);
				memPerson.setUpdatedOrganizationId(optionalOrganization.isPresent()?optionalOrganization.get():null);
				memPerson.setPreferredLanguageId(opMstLang.isPresent()?opMstLang.get():null);
				memPerson = personRepository.save(memPerson);

				//4a.1) Creating employer_employment_request_service_counter_dmu record from the service counter search and
				//		DMU Inbound search
				//Note : As per Mr.Devage the action type is set to 2. Which means its an Update.
				EmployerEmploymentRequestServiceCounterDmuRequestDto eeRSCDMUReqDto = 
															EmployerEmploymentRequestServiceCounterDmuRequestDto
																.builder()
																.actionType(EERSCDMU_ACTION_TYPE)
																.build();
				
				EmployerEmploymentRequestServiceCounterDmuEntityBuilder eeSRCDMUEB = new EmployerEmploymentRequestServiceCounterDmuEntityBuilder();
				eeSRCDMUEB.setCreatedBy(optionalUser.get());
				eeSRCDMUEB.setCreatedOrganization(optionalOrganization.get());
				eeSRCDMUEB.setServiceCounterRequirementTypeId(scReqType.isPresent()?scReqType.get():null);		//Service Counter Requirement Type
				eeSRCDMUEB.setDmuInboundId(dmuInbound.isPresent()?dmuInbound.get():null);						//DMU Inbound
				eeSRCDMUEB.setEmployerMemberAccountId(emaEntity);												//Employer Member Account  
				
				EmployerEmploymentRequestServiceCounterDmu eeRSCDMU = employerEmploymentRequestServiceCounterDmuRepository
																			.save(eeSRCDMUEB.buildCreateEntity(eeRSCDMUReqDto, null));

				//4a.2) Creating employer_interim_member_account for history
				//Note :: Creates an EmployerInterimMemberAccount from EmployerMemberAccount.
				//The entityBuilder name may seem confusing here.
				EmployerInterimMemberAccountHistoryEntityBuilder eimahEB = new EmployerInterimMemberAccountHistoryEntityBuilder();
				EmployerInterimMemberAccount eiMemberAccount = employerInterimMemberAccountRepository
																	.save(eimahEB.buildHistoryEntity(emaEntity));

				//4a.3) Creating employer_member_account_history for history
				EmployerMemberAccountHistoryEntityBuilder emahEB = new EmployerMemberAccountHistoryEntityBuilder();
				emahEB.setCreatedBy(optionalUser.get());
				emahEB.setCreatedOrganization(optionalOrganization.get());
				emahEB.setEmployerEmploymentRequestServiceCounterDmuId(eeRSCDMU);
				emahEB.setEmployerMemberAccountId(emaEntity);
				emahEB.setEmployerInterimMemberAccountId(eiMemberAccount);
				employerMemberAccountHistoryRepository.save(emahEB.buildCreateEntity(null, null));
			
				//4a.3) Member address added/updated
				if ((request.getEmAccountDetails().getLstAddressDetails()!=null) &&
						(request.getEmAccountDetails().getLstAddressDetails().size()>0)) {
					
					for (PersonAddressRequestChild6 oAddress : request.getEmAccountDetails().getLstAddressDetails()) {
						
						AddressResponseDto aResp = null;
						PersonGeneralAddressResponseDto pgaRespDTO = null;
						PersonAddressResponseDto paRespDTO = null;
						PersonAddressReferenceResponseDto parRespDTO = null;
						
						//Adding new address for employment
						if( ((oAddress.getPersonAddressid()==null) && (oAddress.getPersonAddressRefid()==null)) ||
							((oAddress.getPersonAddressid()==0) && (oAddress.getPersonAddressRefid()==0)) ) {
							//1) Add a record to address
							//Note : In both create and update scenarios an address is created in address table.
							aResp = addressService.create(oAddress.getAddressRequest());
							
							//2) Add a record to person_general_address
							PersonGeneralAddressRequestDto pgaReqDTO = PersonGeneralAddressRequestDto.builder()
																			.personGeneralId(null)
																			.addressId(aResp.getId())
																			.active(true)
																			.referenceTableId(1L)		//Member Person Verification Request
																			.build();
							pgaRespDTO = personGeneralAddressServiceNew.create(pgaReqDTO);

							//3) Add a record to person_address
							PersonAddressRequestDto paReqDTO = PersonAddressRequestDto.builder()
																	.active(true)
																	.addressId(aResp.getId())
																	.migrated(false)
																	.personId(opPerson.get().getId())
																	.build();
							paRespDTO = personAddressServiceNew.create(paReqDTO);
							
							//4b) Add a record to person_address_refernce
							PersonAddressReferenceRequestDto parReqDTO = PersonAddressReferenceRequestDto.builder()
																			.brnAddress(oAddress.getPersonAddressReferenceRequest().isBrnAddress())
																			.mailingAddress(oAddress.getPersonAddressReferenceRequest().isMailingAddress())
																			.migrated(false)
																			.personAddressId(paRespDTO.getId())
																			.referenceTableCodeId(opPersonReference.get().getId()) //EMPMEMACC
																			.referenceTableId(empMemAcc.get().getId())
																			.build();
							parRespDTO = personAddressReferenceService.create(parReqDTO);
							
							//5) Add a record to employer_member_account_address_history
							Optional<PersonAddress> oPAddress = personAddressValidator.validate(paRespDTO.getId());
							Optional<PersonGeneralAddress> oPGAddress = personGeneralAddressValidator.validate(pgaRespDTO.getId());
							
							EmployerMemberAccountAddressHistoryRequestDto emaahRDTO = EmployerMemberAccountAddressHistoryRequestDto.builder()
																						.brnAddress(oAddress.getPersonAddressReferenceRequest().isBrnAddress())
																						.mailingAddress(oAddress.getPersonAddressReferenceRequest().isMailingAddress())
																						.build();
							
							EmployerMemberAccountAddressHistoryEntityBuilder emaahEB = new EmployerMemberAccountAddressHistoryEntityBuilder();
							emaahEB.setCreatedBy(optionalUser.get());
							emaahEB.setCreatedOrganization(optionalOrganization.get());
							emaahEB.setEmployerEmploymentRequestServiceCounterDmuId(eeRSCDMU); //Setting service counter DMU object created above
							emaahEB.setPersonAddressId(oPAddress.get());
							emaahEB.setPersonGeneralAddressId(oPGAddress.get());
							emaahEB.setEmployerMemberAccountId(empMemAcc.get());
							emaAddressHistoryRepository.save(emaahEB.buildCreateEntity(emaahRDTO, null));
							
						} else {
							//Updating the existing reference
							if ( ((oAddress.getSelectAddress()!=null)&&(oAddress.getSelectAddress()==true)) &&
								 ((oAddress.getPersonAddressid()!=null) && (oAddress.getPersonAddressid()>0)) &&
								 ((oAddress.getPersonAddressRefid()==null)||(oAddress.getPersonAddressRefid()<=0)) ){
								//If selected is set then creating a reference
								//Add a record to person_address_refernce
								PersonAddressReferenceRequestDto parReqDTO = PersonAddressReferenceRequestDto.builder()
																				.brnAddress(oAddress.getPersonAddressReferenceRequest().isBrnAddress())
																				.mailingAddress(oAddress.getPersonAddressReferenceRequest().isMailingAddress())
																				.migrated(false)
																				.personAddressId(oAddress.getPersonAddressid())
																				.referenceTableCodeId(opPersonReference.get().getId()) //EMPMEMACC
																				.referenceTableId(empMemAcc.get().getId())
																				.build();
								
								parRespDTO = personAddressReferenceService.create(parReqDTO);
								
								//TODO :: May need to add to history??
								
							} else if( ((oAddress.getSelectAddress()!=null)&&(oAddress.getSelectAddress()==true)) &&
									   ((oAddress.getPersonAddressid()!=null) && (oAddress.getPersonAddressid()>0)) &&
									   ((oAddress.getPersonAddressRefid()!=null)&&(oAddress.getPersonAddressRefid()>0)) ) {
								//Get the reference from reference id and update it
								Optional<PersonAddressReference> opPAR = parRepository.findById(oAddress.getPersonAddressRefid());
								if(opPAR.isPresent()) {
									opPAR.get().setMailingAddress(oAddress.getPersonAddressReferenceRequest().isMailingAddress());
									parRepository.save(opPAR.get());
									
									//TODO :: May need to add to history??
								}
							} else if ( ((oAddress.getSelectAddress()!=null)&&(oAddress.getSelectAddress()==false)) &&
									    ((oAddress.getPersonAddressRefid()!=null)&&(oAddress.getPersonAddressRefid()>0)) ){ 
								//If selected is false removing reference
								//Reference table code is employer_member_account, and the id is employer_member_account id which is set
								// in the reference table's reference_table_id field.
								personAddressReferenceService.deleteAddressRefByPersonAddressReferenceId(oAddress.getPersonAddressRefid());

							}
						}
					}
				}
				
				//4a.4) Member contact info added/updated
				if ((request.getEmAccountDetails().getLstContactDetails()!=null) &&
						(request.getEmAccountDetails().getLstContactDetails().size()>0)) {

					ContactInfoResponseDto ciResp = null;
					PersonGeneralContactResponseDto pgcRespDTO = null;
					PersonContactResponseDto pcRespDTO = null;
					PersonContactReferenceResponseDto pcrRespDTO = null;
					
					for (PersonContactRequestChild7 oContact : request.getEmAccountDetails().getLstContactDetails()) {
						
						//Adding new contact for employment
						if( ((oContact.getPersonContactid()==null) && (oContact.getPersonContactRefid()==null)) ||
							((oContact.getPersonContactid()==0) && (oContact.getPersonContactRefid()==0)) ) {

							//1) Add a record to contact_info
							//Note : In both create and update scenarios a contact is created in contact_info table.
							ciResp = contactInfoService.create(oContact.getContactInfoRequest());

							//2) Add a record to person_general_contact
							PersonGeneralContactRequestDto pgcReqDTO = PersonGeneralContactRequestDto.builder()
																			.personGeneralId(null)
																			.contactInfoId(ciResp.getId())
																			.active(true)
																			.referenceTableId(1L)	//Member Person Verification Request
																			.build();
							pgcRespDTO = personGeneralContactServiceNew.create(pgcReqDTO);
							
							//3) Add a record to person_contact
							PersonContactRequestDto pcReqDTO = PersonContactRequestDto.builder()
																	.active(true)
																	.contactInfoId(ciResp.getId())
																	.migrated(false)
																	.personId(opPerson.get().getId())
																	.build();
							pcRespDTO = personContactServiceNew.create(pcReqDTO);

							//4b) Add a record to person_contact_refernce
							PersonContactReferenceRequestDto pcrReqDTO = PersonContactReferenceRequestDto.builder()
																			.contactEmail(oContact.getPersonContactReferenceRequest().isContactEmail())
																			.contactSms(oContact.getPersonContactReferenceRequest().isContactSms())
																			.migrated(false)
																			.personContactId(pcRespDTO.getId())
																			.referenceTableCodeId(opPersonReference.get().getId()) //EMPMEMACC
																			.referenceTableId(empMemAcc.get().getId())
																			.build();
							pcrRespDTO = personContactReferenceService.create(pcrReqDTO);
							
							//5) Add a record to employer_member_account_contact_history
							Optional<PersonContact> oPContact = personContactValidator.validate(pcRespDTO.getId());
							Optional<PersonGeneralContact> oPGContact = personGeneralContactValidator.validate(pgcRespDTO.getId());
							
							EmployerMemberAccountContactHistoryRequestDto emachRDTO = EmployerMemberAccountContactHistoryRequestDto.builder()
																						.contactEmail(oContact.getPersonContactReferenceRequest().isContactEmail())
																						.contactSms(oContact.getPersonContactReferenceRequest().isContactSms())
																						.build();

							EmployerMemberAccountContactHistoryEntityBuilder emachEB = new EmployerMemberAccountContactHistoryEntityBuilder();
							emachEB.setCreatedBy(optionalUser.get());
							emachEB.setCreatedOrganization(optionalOrganization.get());
							emachEB.setEmployerEmploymentRequestServiceCounterDmuId(eeRSCDMU); //Setting service counter DMU object created above
							emachEB.setPersonContactId(oPContact.get());
							emachEB.setPersonGeneralContactId(oPGContact.get());
							emachEB.setEmployerMemberAccountId(empMemAcc.get());
							emaContactHistoryRepository.save(emachEB.buildCreateEntity(emachRDTO, null));
							
						} else {
							//Updating the existing reference
							if( ((oContact.getSelectContact()!=null)&&(oContact.getSelectContact()==true)) && 
								((oContact.getPersonContactid()!=null) && (oContact.getPersonContactid()>0)) &&
								((oContact.getPersonContactRefid()==null)||(oContact.getPersonContactRefid()<=0))) {
								//If selected is set then creating a reference
								
								//Add a record to person_contact_refernce
								PersonContactReferenceRequestDto pcrReqDTO = PersonContactReferenceRequestDto.builder()
										.contactEmail(oContact.getPersonContactReferenceRequest().isContactEmail())
										.contactSms(oContact.getPersonContactReferenceRequest().isContactSms())
										.migrated(false)
										.personContactId(oContact.getPersonContactid())
										.referenceTableCodeId(opPersonReference.get().getId()) //EMPMEMACC
										.referenceTableId(empMemAcc.get().getId())
										.build();
								pcrRespDTO = personContactReferenceService.create(pcrReqDTO);
								
								//TODO :: May need to add to history??
								
							}else if( ((oContact.getSelectContact()!=null)&&(oContact.getSelectContact()==true)) && 
									  ((oContact.getPersonContactid()!=null) && (oContact.getPersonContactid()>0)) &&
									  ((oContact.getPersonContactRefid()!=null)&&(oContact.getPersonContactRefid()>0)) ) {
								//Get the reference from reference id and update it
								Optional<PersonContactReference> opPCR = pcrRepository.findById(oContact.getPersonContactRefid());
								if(opPCR.isPresent()) {
									opPCR.get().setContactEmail(oContact.getPersonContactReferenceRequest().isContactEmail());
									opPCR.get().setContactSms(oContact.getPersonContactReferenceRequest().isContactSms());
									pcrRepository.save(opPCR.get());
								}
								
								//TODO :: May need to add to history??
								
							}else if( ((oContact.getSelectContact()!=null)&&(oContact.getSelectContact()==false)) &&
									  ((oContact.getPersonContactRefid()!=null)&&(oContact.getPersonContactRefid()>0)) ) { 
								//If selected is false removing reference
								//Reference table code is employer_member_account, and the id is employer_member_account id which is set
								// in the reference table's reference_table_id field.
								personContactReferenceService.deleteContactRefByPersonContactReferenceId(oContact.getPersonContactRefid());

							}
						}
					}
					
				}
				
				//5) Member Nominee added/updated
				if((request.getEmAccountDetails().getLstMemAccNomineeDetails()!=null) &&
						(request.getEmAccountDetails().getLstMemAccNomineeDetails().size()>0)) {

					for(MemberAccountNomineeRequestChild5 oMemAccNominee 
							: request.getEmAccountDetails().getLstMemAccNomineeDetails()) {
						
						MemberAccountNominee man = null;
						MemberAccountNomineeRequestDto manReqDTO = null;
						MemberPersonVerificationRequest mvpr = null;
						
						if(oMemAccNominee.getMemberAccountNomineeId()==null) {
							//Note :: Make an existing person a nominee or create a person and make them a nominee
							if((oMemAccNominee.getPgDetails()==null)&&(oMemAccNominee.getPersonId()!=null)) { 
								//5a) Find a person and make them a nominee
								//5a.1) Creating member_account_nominee	  
								Optional<Person> personNom = personRepository.findById(oMemAccNominee.getPersonId());
								Optional<MstReason> opReason = mstReasonValidator.validate(oMemAccNominee.getInactiveReasonId());
								Optional<MstRelationship> opRelationship = mstRelationshipValidator.validate(oMemAccNominee.getRelationshipId());;

								manReqDTO = MemberAccountNomineeRequestDto.builder()
												.active(true)
												.note(oMemAccNominee.getNote())
												.publicNote(oMemAccNominee.getPublicNote())
												.share(oMemAccNominee.getShare())
												.relationshipSpouce(oMemAccNominee.isRelationshipSpouce())
												.build();

								MemberAccountNomineeEntityBuilder manEB = new MemberAccountNomineeEntityBuilder();
								manEB.setMemberAccountId(opMemberAccount.get());			//Setting the memeber account of the selected employer member account
								manEB.setMemberPersonVerificationRequestId(mvpr);
								manEB.setInactiveReasonId((opReason!=null)?opReason.get():null);
								manEB.setRelationshipId((opRelationship!=null)?opRelationship.get():null);
								manEB.setPersonId(personNom.get());	//Set this to new person who is to be a nominee 
								manEB.setCreatedBy(optionalUser.get());
								manEB.setCreatedOrganization(optionalOrganization.get());

								man = memAccNomRepository.save(manEB.buildCreateEntity(manReqDTO, man));

								//5a.1.1) Create nominee address
								if ((oMemAccNominee.getLstAddressDetails()!=null) &&
										(oMemAccNominee.getLstAddressDetails().size()>0)) {
					
									for (PersonAddressRequestChild3 oAddress : oMemAccNominee.getLstAddressDetails()) {
										
										//1) Add a record to address
										//Note : In both create and update scenarios an address is created in address table.
										AddressResponseDto aResp = addressService.create(oAddress.getAddressRequest());
										
										//2) Add a record to person_address
										PersonAddressRequestDto paReqDTO = PersonAddressRequestDto.builder()
																				.active(true)
																				.addressId(aResp.getId())
																				.migrated(false)
																				.personId(personNom.get().getId())
																				.build();
										
										PersonAddressResponseDto paRespDTO = personAddressServiceNew.create(paReqDTO);
	
										//3) Add a record to person_address_refernce
										PersonAddressReferenceRequestDto parReqDTO = PersonAddressReferenceRequestDto.builder()
																						.brnAddress(oAddress.getPersonAddressReferenceRequest().isBrnAddress())
																						.mailingAddress(oAddress.getPersonAddressReferenceRequest().isMailingAddress())
																						.migrated(false)
																						.personAddressId(paRespDTO.getId())
																						.referenceTableCodeId(opNomineePersonReference.get().getId())
																						.referenceTableId(man.getId())
																						.build();
										PersonAddressReferenceResponseDto parRespDTO = personAddressReferenceService.create(parReqDTO);

									}
								}
								
								//5a.1.2) Nominee contact info added
								if ((oMemAccNominee.getLstContactDetails()!=null) &&
												(oMemAccNominee.getLstContactDetails().size()>0)) {

										for (PersonContactRequestChild3 oContact : oMemAccNominee.getLstContactDetails()) {
												
												//1) Add a record to contact_info
												//Note : In both create and update scenarios a contact is created in contact_info table.
												ContactInfoResponseDto ciResp = contactInfoService.create(oContact.getContactInfoRequest());

												//2) Add a record to person_contact
												PersonContactRequestDto pcReqDTO = PersonContactRequestDto.builder()
																						.active(true)
																						.contactInfoId(ciResp.getId())
																						.migrated(false)
																						.personId(personNom.get().getId())
																						.build();
												PersonContactResponseDto pcRespDTO = personContactServiceNew.create(pcReqDTO);
	
												//3) Add a record to person_contact_refernce
												PersonContactReferenceRequestDto pcrReqDTO = PersonContactReferenceRequestDto.builder()
																								.contactEmail(oContact.getPersonContactReferenceRequest().isContactEmail())
																								.contactSms(oContact.getPersonContactReferenceRequest().isContactSms())
																								.migrated(false)
																								.personContactId(pcRespDTO.getId())
																								.referenceTableCodeId(opNomineePersonReference.get().getId())
																								.referenceTableId(man.getId())
																								.build();
												PersonContactReferenceResponseDto pcrRespDTO = personContactReferenceService.create(pcrReqDTO);

										}		
								}
								
							} else if(oMemAccNominee.getPgDetails()!=null) { //5a.2) Create a person and then make them a nominee
								
								//Getting dummy member
								Optional<Member1> dummyMember = member1Repository.findByVerificationDummy(true);
								//1) Create person_general
								oMemAccNominee.getPgDetails().setReferenceTableId(PERSON_GEN_REF_TBL_ID);
								pgResponseDto = personGeneralServiceNew.create(oMemAccNominee.getPgDetails());
								
								//2) Create person_general_address
								if(oMemAccNominee.getPgDetails().getPgAddressRequest()!=null) {
									//2.1) Create address record
									AddressResponseDto aRespDTO = addressService.create(oMemAccNominee.getPgDetails()
																									.getPgAddressRequest()
																										.getAddressRequest());
									//2.2) Create person_general_address
									PersonGeneralAddressRequestDto pgaReqDTO = PersonGeneralAddressRequestDto.builder()
																					.active(true)
																					.addressId(aRespDTO.getId())
																					.personGeneralId(pgResponseDto.getId())
																					//.referenceTableId() //EMPMEMACC
																					.build();
									PersonGeneralAddressResponseDto pgaRespDTO = personGeneralAddressServiceNew.create(pgaReqDTO);

									//2.3) Create person_general_address_reference
									PersonGeneralAddressReferenceRequestDto pgarReqDTO = PersonGeneralAddressReferenceRequestDto.builder()
																							.active(true)
																							.brnAddress(oMemAccNominee.getPgDetails().getPgAddressRequest()
																												.getPersonGeneralAddressReferenceRequest().isBrnAddress())
																							.mailingAddress(oMemAccNominee.getPgDetails().getPgAddressRequest()
																												.getPersonGeneralAddressReferenceRequest().isMailingAddress())
																							.personGeneralAddressId(pgaRespDTO.getId())
																							.referenceTableCodeId(opPersonReference.get().getId())  //EMPMEMACC
																							.referenceTableId(empMemAcc.get().getId())
																							.build();
									PersonGeneralAddressReferenceResponseDto pgarRespDTO = pgaReferenceService.create(pgarReqDTO);
								}
								
								//3) Create person_general_contact
								if(oMemAccNominee.getPgDetails().getPgContactRequest()!=null) {
									//3.1) Create contact_info
									ContactInfoResponseDto ciResp = contactInfoService.create(oMemAccNominee.getPgDetails()
																												.getPgContactRequest()
																													.getContactInfoRequest());
									//3.2) Create person_general_contact
									PersonGeneralContactRequestDto pgcReqDTO = PersonGeneralContactRequestDto.builder()
																						.active(true)
																						.contactInfoId(ciResp.getId())
																						.personGeneralId(pgResponseDto.getId())
																						//.referenceTableId(referenceTableId)
																						.build();
									PersonGeneralContactResponseDto pgcRespDTO = personGeneralContactServiceNew.create(pgcReqDTO);
									
									//3.3) Create person_general_contact_reference
									PersonGeneralContactReferenceRequestDto pgcrReqDTO = PersonGeneralContactReferenceRequestDto.builder()
																								.active(true)
																								.contactEmail(oMemAccNominee.getPgDetails().getPgContactRequest()
																													.getPersonGeneralContactReferenceRequest().isContactEmail())
																								.contactSms(oMemAccNominee.getPgDetails().getPgContactRequest()
																													.getPersonGeneralContactReferenceRequest().isContactSms())
																								.personGeneralContactId(pgcRespDTO.getId())
																								.referenceTableCodeId(opPersonReference.get().getId())  //EMPMEMACC
																								.referenceTableId(empMemAcc.get().getId())
																								.build();
									PersonGeneralContactReferenceResponseDto pgcrRespDTO = pgcReferenceService.create(pgcrReqDTO);
								}

								//6) Create member_person_verification_request
								MemberPersonVerificationRequestRequestDto mpvrDTO = MemberPersonVerificationRequestRequestDto.builder()
																					.refNo(refNoUtil.getRefNumber("member_person_verification_request"))
																					.build();
								
								Optional<MstMemberPersonVerificationRequestType> memPerVerifReqType = memberPersonVerificationRequestTypeValidator.validateByCode(UPDATE_REQUEST_TYPE);
								Optional<MstMemberPersonVerificationRequestSource> memPerVerifReqSource = memberPersonVerificationRequestSourceValidator.validateByCode(UPDATE_REQUEST_SOURCE);
								Optional<MstVerificationRequestStatus> verifReqStatus = verificationRequestStatusValidator.validateByCode(STATUS);	//Un-Assigned
								Optional<MstVerificationStatus> verifStatus = verificationStatusValidator.validateByCode(STATUS_VERIFICATION);		//Verification Pending
								Optional<PersonGeneral> opPersonGeneral = personGeneralValidator.validate(pgResponseDto.getId());
								
								MemberPersonVerificationRequestEntityBuilder mpvrEB = new MemberPersonVerificationRequestEntityBuilder();
								mpvrEB.setCreatedBy(optionalUser.isPresent()?optionalUser.get():null);
								mpvrEB.setCreatedOrganization(optionalOrganization.isPresent()?optionalOrganization.get():null);
								mpvrEB.setPriorityId(optinalPriority.isPresent()?optinalPriority.get():null);
								mpvrEB.setRequestTypeId(memPerVerifReqType.get());
								mpvrEB.setRequestSourceId(memPerVerifReqSource.get());
								mpvrEB.setPersonGeneralId(opPersonGeneral.get());
								mpvrEB.setStatusId(verifReqStatus.get());
								mpvrEB.setStatusBy(optionalUser.isPresent()?optionalUser.get():null);
								mpvrEB.setVerificationStatusId(verifStatus.get());

								mvpr = memberPersonVerificationRequestRepository.save(mpvrEB.buildCreateEntity(mpvrDTO,null));
								
								//7) member_person_verification_request_status_history (create)
								memberPersonVerificationRequestStatusHistoryRepository.save(
										(new MemberPersonVerificationRequestHistoryEntityBuilder()).buildHistoryEntity(mvpr));
								
								//8) member_account_nominee (create)
								Optional<Person> personNom = null;
								Optional<MstReason> opReason = null;
								Optional<MstRelationship> opRelationship = null;
								
								if(oMemAccNominee.getPersonId()!=null) { personNom = personRepository.findById(oMemAccNominee.getPersonId());}
								if(oMemAccNominee.getInactiveReasonId()!=null) { opReason = mstReasonValidator.validate(oMemAccNominee.getInactiveReasonId());  }
								if(oMemAccNominee.getRelationshipId()!=null) { opRelationship =  mstRelationshipValidator.validate(oMemAccNominee.getRelationshipId()); }
								
								manReqDTO = MemberAccountNomineeRequestDto.builder()
												.active(true)
												.note(oMemAccNominee.getNote())
												.publicNote(oMemAccNominee.getPublicNote())
												.share(oMemAccNominee.getShare())
												.relationshipSpouce(oMemAccNominee.isRelationshipSpouce())
												.build();

								MemberAccountNomineeEntityBuilder manEB = new MemberAccountNomineeEntityBuilder();
								manEB.setMemberAccountId(opMemberAccount.get());			//Setting the memeber account of the selected employer member account
								manEB.setMemberPersonVerificationRequestId(mvpr);
								manEB.setInactiveReasonId((opReason!=null)?opReason.get():null);
								manEB.setRelationshipId((opRelationship!=null)?opRelationship.get():null);
								manEB.setPersonId((personNom!=null)?personNom.get():null);	//Set this to new person who is to be a nominee 
								manEB.setCreatedBy(optionalUser.get());
								manEB.setCreatedOrganization(optionalOrganization.get());

								man = memAccNomRepository.save(manEB.buildCreateEntity(manReqDTO, man));

							}
							
						} else { //Existing member account nominee updated
							
							//5b) Getting the relevant member account nominee record for update.
							//Note : When updating the member_account_nominee_id field should be sent in request. Then the person_id sent
							//		 will be considered as the person to be updated.
							Optional<MemberAccountNominee> objMemAccNom = memberAccountNomineeValidator.validate(oMemAccNominee.getMemberAccountNomineeId());
							Optional<Person> objPerson = personValidator.validate(oMemAccNominee.getPersonId());
							
							if(objMemAccNom != null) {
								man = objMemAccNom.get();
								manReqDTO = MemberAccountNomineeRequestDto.builder()
														.active(man.getActive())
														.note(man.getNote())
														.publicNote(man.getPublicNote())
														.share(man.getShare())
														.relationshipSpouce(man.getRelationshipSpouce())
														.build();

								MemberAccountNomineeEntityBuilder manEB = new MemberAccountNomineeEntityBuilder();
								manEB.setMemberAccountId(man.getMemberAccountId());
								manEB.setMemberPersonVerificationRequestId(man.getMemberPersonVerificationRequestId());
								manEB.setInactiveReasonId(man.getInactiveReasonId());
								manEB.setRelationshipId(man.getRelationshipId());
								manEB.setPersonId(objPerson.get());
								manEB.setCreatedBy(man.getCreatedBy());
								manEB.setCreatedOrganization(man.getCreatedOrganizationId());
								manEB.setUpdatedBy(optionalUser.get());
								manEB.setUpdatedOrganization(optionalOrganization.get());

								man = memAccNomRepository.save(manEB.buildUpdateEntity(manReqDTO, man));
								
							}else {
								//TODO :: If matching nominee not found for the ID that is passed from search
							}
						}
						
						//5c) Create member_account_nominee_history record
						MemberAccountNomineeHistory1EntityBuilder manhEB = new MemberAccountNomineeHistory1EntityBuilder();
						manhEB.setEerServiceCounterDMU(eeRSCDMU); //Setting service counter DMU object created above
						memAccNomHistRepository.save(manhEB.buildHistoryEntity(man));
						
					}
				}

			}else {
				//Note :: If member information is updated and the data needed for update is not found
				throw new ApplicationException("Member details needed for update not found in request");
			}

		}
		
		//Employer member document (Create)
		//Note : The physical file upload would be done once the UI is redirected to the Add Document screen.
		//		 Client must send the list of document references that are sent to DMS. Once those references are
		//		 obtained, if remove option is selected the relevant reference should be removed from the document
		//		 reference list. BUT this does not remove the actual physical document from DMS nor does it
		//		 trigger a sequence of events to remove the document from DMS.
		if( (request.getLstEmpMemDocument()!=null) && 
				(request.getLstEmpMemDocument().size()>0) ) {
					
					//Note :: Moving file to DMS
					//20200710 - According to Achini's comments this push was done first. Reason not so sure. If the same block of code was
					//done after the next loop, this part fails.
					List<Long> lstDocId = new ArrayList();
					for (EmployerMemberDocumentRequest documentRequest : request.getLstEmpMemDocument()) {
						lstDocId.add(documentRequest.getDocumentUploadedId());
					}
					DocumentUpdateRequest duRequest = new DocumentUpdateRequest(PROFILE_PIC_DOCUMENT_UPLOAD_MODULE,lstDocId);
					documentService.updateDmsRefParentRef(duRequest);
					
					request.getLstEmpMemDocument().forEach(objDoc ->{
						try {
							EmployerMemberDocumentRequestDto emdRequestDTO = employerMemberDocumentRequestDtoBuilder.buildCreateDto(objDoc, null);

							Optional<DocumentUploaded> opDU = documentUploadedValidator.validate(objDoc.getDocumentUploadedId());

							EmployerMemberDocumentEntityBuilder emdEB = new EmployerMemberDocumentEntityBuilder();
							emdEB.setEmployerMemberAccountId(empMemAcc.get());
							emdEB.setDocumentUploadedId(opDU.get());

							EmployerMemberDocument emd = employerMemberDocumentRepository.save(emdEB.buildCreateEntity(emdRequestDTO, null));

							EmployerMemberDocumentResponseDto edRespDTO = employerMemberDocumentResponseDtoBuilder.buildCreateResponseDto(emd);

						} catch (Exception e) {
							//Do nothing, since there maybe files that are valid after the invalid file. They should be
							//entered.
						}
			});
		}
		
		//Update note in selected employer member account
		EmployerMemberAccount emaE = empMemAcc.get();
		if(request.getNote()!=null) {
			/*EmployerMemberAccountRequestDto emaRDTO = EmployerMemberAccountRequestDto.builder()
														.note()
														.notePublic()
														.build();
														
			EmployerMemberAccountEntityBuilder emaEB = new EmployerMemberAccountEntityBuilder();
			emaEB.setEmployerId(emaE.getEmployerId());
			emaEB.setUpdatedBy(optionalUser.get());
			emaEB.setUpdatedOrganization(optionalOrganization.get());
			employerMemberAccountRepository.save(emaEB.buildUpdateEntity(emaRDTO, emaE));*/
			
			emaE.setNote(NoteFormatter.getFormattedNote(emaE.getNote(), request.getNote(), optionalUser.get().getDisplayName()));
			emaE.setNotePublic(NoteFormatter.getFormattedNote(emaE.getNote(), request.getNote(), optionalUser.get().getDisplayName()));
			emaE.setUpdatedBy(optionalUser.get());
			emaE.setUpdatedOrganizationId(optionalOrganization.get());
			emaE = employerMemberAccountRepository.save(emaE);
		}
	
		//Note : It is visible that transaction tracks the actions that are performed. But I don't see a place where
		//		 the details of what is being updated linked to the tracked txn????????
		//Create transaction
		TransactionEntityBuilder txnEB = new TransactionEntityBuilder();
		txnEB.setActionId(opMstTxnAction.get());
		txnEB.setCreatedBy(optionalUser.isPresent()?optionalUser.get():null);
		txnEB.setCreatedOrganization(optionalOrganization.isPresent()?optionalOrganization.get():null);
		Transaction txn = transactionRepository.save(txnEB.buildCreateEntity(null, null));

		//Create txn_employer
		TxnEmployerEntityBuilder txnEmpEB = new TxnEmployerEntityBuilder();
		txnEmpEB.setEmployerId(emaE.getEmployerId());
		txnEmpEB.setTransactionId(txn);
		txnEmployerRepository.save(txnEmpEB.buildCreateEntity(null, null));
		
		return response;
	}
	//1.0.2 :: End
	@Override
	@MethodLogging
	@Transactional(rollbackFor=ApplicationException.class)
	public EmployerMemberAccountDetailResponseDto getEmployerMemberAccountDetailsById(Long empMemAccId) throws ApplicationException {
		
		List<PersonAddressListItemResponseDtoChild1> lstPersonAddress = new ArrayList<>();
		List<PersonContactListItemResponseDtoChild1> lstPersonContacts = new ArrayList<>();
		
		//Validate
		Optional<EmployerMemberAccount> employerOptional = employerMemberAccountValidator.validate(empMemAccId);
		Person pE = employerOptional.get().getMemberAccountId().getMemberId().getPersonId();
				
		//Getting member details
		EmployerMemberAccountDetailResponseDto response = employerMemberManagementDao.getEmployerMemberAccountDetails2(empMemAccId);
		//Getting member person address details
		//lstPersonAddress = personAddressServiceNew.getAddressListByEmployerMemberAccountId(empMemAccId);
		lstPersonAddress = personAddressServiceNew.getAddressListByEmployerMemberAccountPersonId(pE.getId(),empMemAccId);
		response.setLstPersonAddress(lstPersonAddress);
		//Getting member person contact details
		//lstPersonContacts = personContactServiceNew.getContactListByEmployerMemberAccountId(empMemAccId);
		lstPersonContacts = personContactServiceNew.getContactListByEmployerMemberAccountPersonId(pE.getId(),empMemAccId);
		response.setLstPersonContacts(lstPersonContacts);
		
		List<MemberAccountNomineeBasicDetailsResponseDto> lstNomineeDetails = new ArrayList<>();
		if(employerOptional.get().getMemberAccountId()!=null) {
			//Note :: Member account nominees to be taken from selected member account ID. This method throws an exception when there aren't
			//any nominees for a given member_account.
			try {
				lstNomineeDetails = memberAccountNomineeService.getNomineeListByMemberAccountId2(employerOptional.get().getMemberAccountId().getId());
			} catch (ApplicationException e) {
				//Doing nothing at exception, since we do not want this to fail, but validators throw ApplicationException. Believe this is a reasonble
				//compromise
				lstNomineeDetails=null;
			}
		}
		response.setLstMemAccNomineeDetails(lstNomineeDetails);

		//Available Documents for employer member account
		//employer_member_document <-> employer_member_account
		//employer_member_document <-> document_uploaded
		List<DocumentUploadedResponseDtoChild2> lstEmpMemDoc = employerMemberManagementDao.getAllDocumentUploadByEmployerMemberAccountId(employerOptional.get().getId());
		if((lstEmpMemDoc!=null)&&(lstEmpMemDoc.size()>0)){
			response.setLstEmployerDocuments(lstEmpMemDoc);
		}

		return response;
	}
	
	private Object convert(Object object, Class<?> type) {
		ModelMapper modelMapper = new ModelMapper();
		Object MapperObject = modelMapper.map(object, type);
		return MapperObject;
	}

}
