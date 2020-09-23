package com.inova.etfb.test.base;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.inova.common.service.EmploymentService;
import com.inova.common.service.NomineeService;
import com.inova.common.service.PersonContactReferenceService;
import com.inova.config.EmployerManagementConfig;
import com.inova.common.service.PersonAddressReferenceService;
import com.inova.employer_management.service.EmployerActivityPerformedBranchService;
import com.inova.employer_management.service.EmployerActivityPerformedUserService;
import com.inova.employer_management.service.EmployerActivtyHistoryService;
import com.inova.employer_management.service.EmployerDuesLegalCasesSerachService;
import com.inova.employer_management.service.EmployerDuesPaymentService;
import com.inova.employer_management.service.EmployerLegalCourtService;
import com.inova.employer_management.service.EmployerMemberAnnualStatmentService;
import com.inova.employer_management.service.EmployerOutBoundDmuService;
import com.inova.employer_management.service.EmployerRemittanceDetailService;
import com.inova.employer_management.service.EmployerViewProfileSearchService;
import com.inova.employer_management.service.PendingEmployerVerificationSearchService;
import com.inova.employer_management.service.ViewEmployerAvailableBalanceSearchService;
import com.inova.employer_management.service.ViewEmployerDetailsService;
import com.inova.employer_management.service.ViewEmployerDirectorDetailsService;
import com.inova.employer_relation.service.ScheduleVisitViewService;
import com.inova.employer_relation.service.ScheduleVisitVisitCalanderService;
import com.inova.employer_relation.service.ServiceRequestForFollowUpDefaulterService;
//import com.inova.employer_relation.service.SelectCollectionService;
import com.inova.employer_relation.service.SheduleVisitDefalterListService;
import com.inova.employer_relation.service.VisitScheduleViewDefaulterService;
import com.inova.member_relation.service.ViewEmployerNotFoundService;
import com.inova.memeber_management.service.CreateMemberPortalAccountService;
import com.inova.memeber_management.service.PersonActivityHistoryEtfbBranchService;
import com.inova.memeber_management.service.PersonActivityHistoryEtfbUsersService;
import com.inova.memeber_management.service.PersonActivityHistoryService;
import com.inova.memeber_management.service.PersonDocumentDetailsService;
import com.inova.memeber_management.service.PersonProfileAnnualStatementService;
import com.inova.memeber_management.service.PersonProfileDirectorOwnerPartnerDetailsService;
import com.inova.memeber_management.service.PersonProfileDocumentDetailsService;
import com.inova.memeber_management.service.PersonProfileEmploymentBasicDetailsService;
import com.inova.memeber_management.service.PersonProfileEmploymentDetailsService;
import com.inova.memeber_management.service.PersonProfileIdentityNicService;
import com.inova.memeber_management.service.PersonProfileIdentityPassportService;
import com.inova.memeber_management.service.PersonProfilePersonDetailsService;
import com.inova.memeber_management.service.PersonProfilePersonHistoryDetailsService;
import com.inova.memeber_management.service.PersonProfilePersonOutboundDocumentsService;
import com.inova.memeber_management.service.PersonProfilePictureHstoryDetailsService;
import com.inova.memeber_management.service.PersonProfileRepresetAsNomineeService;
import com.inova.memeber_management.service.PersonProfileViewMemberMenuService;
import com.inova.memeber_management.service.PersonVerficationPersonGeneralService;
import com.inova.memeber_management.service.PersonVerificationAssignUnassignService;
import com.inova.memeber_management.service.PersonVerificationHoldHistoryService;
import com.inova.memeber_management.service.PersonProfileRepresetAsNomineeService;
import com.inova.memeber_management.service.PersonVerficationPersonGeneralService;
import com.inova.memeber_management.service.PersonVerificationRequestDetailService;
import com.inova.memeber_management.service.PersonVerificationRequestMessageDetailService;
import com.inova.memeber_management.service.SelfEmploymentDetailsService;
import com.inova.memeber_management.service.ServiceCounterInquiriesService;
public abstract class BaseMockTest extends BaseTest {
	@MockBean
	protected PersonActivityHistoryEtfbBranchService personActivityHistoryEtfbBranchService;
	@MockBean
	protected PendingEmployerVerificationSearchService pendingEmployerVerificationSearchService;
	@MockBean
	protected SheduleVisitDefalterListService sheduleVisitDefalterListService;
	@MockBean
	protected ScheduleVisitVisitCalanderService scheduleVisitVisitCalanderService;
	@MockBean
	protected PersonActivityHistoryService personActivityHistoryService;
	@MockBean
	protected PersonDocumentDetailsService personDocumentDetailsService;
	@MockBean
	protected PersonProfileAnnualStatementService personProfileAnnualStatementService;
	@MockBean
	protected PersonProfileDocumentDetailsService personProfileDocumentDetailsService;
	@MockBean
	protected PersonProfileEmploymentBasicDetailsService personProfileEmploymentBasicDetailsService;
	@MockBean
	protected PersonProfileEmploymentDetailsService personProfileEmploymentDetailsService;
	@MockBean
	protected PersonProfileIdentityNicService personProfileIdentityNicService;
	@MockBean
	protected PersonProfileIdentityPassportService personProfileIdentityPassportService;
	@MockBean
	protected ServiceCounterInquiriesService serviceCounterInquiriesService;
	@MockBean
	protected PersonProfilePersonOutboundDocumentsService personProfilePersonOutboundDocumentsService;
	@MockBean
	protected EmploymentService employmentService;
	@MockBean
	protected EmployerRemittanceDetailService employerRemittanceDetailService;
	@MockBean
	protected PersonProfileViewMemberMenuService personProfileViewMemberMenuService;
	@MockBean
	protected PersonProfilePersonDetailsService personProfilePersonDetailsService;
	@MockBean
	protected ViewEmployerAvailableBalanceSearchService viewEmployerAvailableBalanceSearchService;
	@MockBean
	protected EmployerOutBoundDmuService employerOutBoundDmuService;
	@MockBean
	protected EmployerLegalCourtService employerLegalCourtService;
	@MockBean
	protected NomineeService nomineeService;
//    @MockBean
//    protected SelectCollectionService selectCollectionService;
    @MockBean
    protected VisitScheduleViewDefaulterService visitScheduleViewDefaulterService;
    @MockBean
    protected PersonProfileDirectorOwnerPartnerDetailsService personProfileDirectorOwnerPartnerDetailsService;
    @MockBean
	protected SelfEmploymentDetailsService selfEmploymentDetailsService;
	@MockBean
    protected PersonProfileRepresetAsNomineeService personProfileRepresetAsNomineeService;
	@MockBean
	protected PersonVerificationAssignUnassignService personVerificationAssignUnassignService;

	@MockBean
	protected PersonVerficationPersonGeneralService personVerficationPersonGeneralService;
	@MockBean
	protected PersonVerificationRequestDetailService personVerificationRequestDetailService;
	@MockBean
	protected PersonProfilePersonHistoryDetailsService personProfilePersonHistoryDetailsService;
	@MockBean
	protected PersonActivityHistoryEtfbUsersService personActivityHistoryEtfbUsersService;
	@MockBean
	protected ViewEmployerNotFoundService viewEmployerNotFoundService;
	@MockBean
	protected PersonVerificationRequestMessageDetailService personVerificationRequestMessageDetailService;
	@MockBean
	protected PersonProfilePictureHstoryDetailsService personProfilePictureHstoryDetailsService;
	@MockBean
    protected CreateMemberPortalAccountService createMemberPortalAccountService;
	@MockBean
	protected PersonVerificationHoldHistoryService personVerificationHoldHistoryService;
	@MockBean
	protected ScheduleVisitViewService scheduleVisitViewService;
	@MockBean
    protected PersonAddressReferenceService addressReferenceService;
	@MockBean
	protected PersonContactReferenceService personContactReferenceService;

    @MockBean
    protected ServiceRequestForFollowUpDefaulterService serviceRequestForDefaultersService;
    @MockBean
    protected ViewEmployerDirectorDetailsService viewEmployerDirectorDetailsService;

    @MockBean
    protected EmployerViewProfileSearchService employerViewProfileSearchService;
   	
    @MockBean
    protected EmployerActivtyHistoryService  employerActivtyHistoryService;		
    @MockBean
    protected EmployerActivityPerformedUserService employerActivityPerformedUserService;	
    @MockBean
    protected EmployerActivityPerformedBranchService employerActivityPerformedBranchService;  
    @MockBean
    protected EmployerMemberAnnualStatmentService employerMemAnnualStatmentService;
    @MockBean
    protected ViewEmployerDetailsService viewEmployerDetailsService;
    @MockBean
    protected EmployerDuesPaymentService employerDuesPaymentService;

    
    @MockBean
    protected EmployerDuesLegalCasesSerachService employerDuesLegalCasesSerachService;
    
    @Autowired
    private WebApplicationContext webApplicationContext;

	protected MockMvc mockMvc;;


	public BaseMockTest() {
	}

    public BaseMockTest(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
