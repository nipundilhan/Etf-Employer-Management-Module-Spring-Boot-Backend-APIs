package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.inova.dao.entities.*;
import com.inova.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.repositories.MstCountryRepository;
import com.inova.dao.repositories.MstDocumentTypeRepository;
import com.inova.dao.repositories.MstEmployerIndustryTypeRepository;
import com.inova.dao.repositories.MstEmployerNatureBusinessRepository;
import com.inova.dao.repositories.MstEmployerScheduleVisitStatusRepository;
import com.inova.dao.repositories.MstEmployerScheduleVisitTypeRepository;
import com.inova.dao.repositories.MstIdentityNicTypeRepository;
import com.inova.dao.repositories.MstOrganizationCategoryRepository;
import com.inova.dao.repositories.MstOrganizationStatusRepository;
import com.inova.dao.repositories.MstReasonRepository;
import com.inova.dao.repositories.MstRelationshipRepository;
import com.inova.dao.repositories.MstTitleRepository;
import com.inova.dao.repositories.MstTxnActionRepository;

@Component
public class MstDataLoader {
	@Autowired
	MstEmployerNatureBusinessRepository mstEmployerNatureBusinessRepository;
	@Autowired
	MstEmployerIndustryTypeRepository mstEmployerIndustryTypeRepository;
	@Autowired
	MstReasonRepository mstReasonRepository;
	@Autowired
	MstRelationshipRepository mstRelationshipRepository;
	@Autowired
	MstDmuInboundStatusRepository mstDmuInboundStatusRepository;

	@Autowired
	MstIdentityNicTypeRepository mstIdentityNicTypeRepository;
	@Autowired
	MstCountryRepository mstCountryRepository;
	@Autowired
	MstTitleRepository mstTitleRepository;
	@Autowired
	MstTxnActionRepository mstTxnActionRepository;
	@Autowired
	MstDocumentTypeRepository mstDocumentTypeRepository;
	@Autowired
	MstDmuPackingTypeRepository mstDmuPackingTypeRepository;
	@Autowired
	MstEmployerScheduleVisitTypeRepository mstEmployerScheduleVisitTypeRepository;
	@Autowired
	MstEmployerScheduleVisitStatusRepository mstEmployerScheduleVisitStatusRepository;
	@Autowired
	MstOrganizationCategoryRepository mstOrganizationCategoryRepository;
	@Autowired
	MstOrganizationStatusRepository mstOrganizationStatusRepository;
	@Autowired
	MstEmployerOrganizationTypeRepository mstMstEmployerOrganizationTypeRepository;
	@Autowired
	MstEmployerStatusRepository mstEmployerStatusRepository;
	@Autowired
	MstEmployerTypeRepository mstEmployerTypeRepository;
	@Autowired
	MstEmployerCreateSourceTypeRepository mstEmployerCreateSourceTypeRepository;
	@Autowired
	MstEnforcementDefaulterStatusRepository mstEnforcementDefaulterStatusRepository;
	@Autowired
	MstCollectionSourceRepository mstCollectionSourceRepository;
	@Autowired
	MstEmployerSelfEmploymentPaymentStatusRepository mstEmployerSelfEmploymentPaymentStatusRepository;
	@Autowired
	MstPaymentReferenceNoTypeRepository mstPaymentReferenceNoTypeRepository;
	@Autowired
	MstEtfbZoneRepository mstEtfbZoneRepository;
	@Autowired
	MstSelfEmploymentCategoryNatureRepository mstSelfEmploymentCategoryNatureRepository;
	@Autowired
	MstContactTypeRepository mstContactTypeRepository;
	@Autowired
	MstPriorityRepository mstPriorityRepository;
	@Autowired
	MstServiceRequestTypeRepository mstServiceRequestTypeRepository;
	@Autowired
	MstServiceRequestSourceRepository mstServiceRequestSourceRepository;
	@Autowired
	MstServiceRequestStatusRepository mstServiceRequestStatusRepository;
	@Autowired
	MstSbuRepository mstSbuRepository;
	@Autowired
	MstServiceCounterInquiryTypeRepository mstServiceCounterInquiryTypeRepository;
	@Autowired
	MstServiceCounterStatusRepository mstServiceCounterStatusRepository;
	@Autowired
	MstServiceCounterRequirementTypeRepository mstServiceCounterRequirementTypeRepository;
	@Autowired
	MstServiceCounterResolutionTypeRepository mstServiceCounterResolutionTypeRepository;
	@Autowired
	MstPersonReferenceTableRepository mstPersonReferenceTableRepository; 


	public MstEmployerIndustryType insertMstEmployerIndustryType(long id) {
		Optional<MstEmployerIndustryType> indType = mstEmployerIndustryTypeRepository.findById(id);
		if (indType != null && indType.isPresent()) {
			return indType.get();
		} else {
			MstEmployerIndustryType industryType = new MstEmployerIndustryType();
			industryType.setNameEng("test industry type");
			industryType.setCreatedAt(new Date());
			industryType.setUpdatedAt(new Date());
			return mstEmployerIndustryTypeRepository.save(industryType);
		}
	}

	public MstEmployerNatureBusiness insertMstEmployerNatureBusiness() {
		String name = "Test Nature of Business";
		Optional<MstEmployerNatureBusiness> natureBusinessOpt = mstEmployerNatureBusinessRepository.findByNameEng(name);

		if (natureBusinessOpt != null && natureBusinessOpt.isPresent()) {
			return natureBusinessOpt.get();
		} else {
			MstEmployerNatureBusiness natureBusiness = new MstEmployerNatureBusiness();
			natureBusiness.setNameEng(name);
			natureBusiness.setUpdatedAt(new Date());
			return mstEmployerNatureBusinessRepository.save(natureBusiness);
		}
	}

	public MstTitle insertMstTitle(long id) {
		Optional<MstTitle> title = mstTitleRepository.findById(id);
		if (title != null && title.isPresent()) {
			return title.get();
		} else {
			MstTitle mstTitle = new MstTitle();
			mstTitle.setNameEng("test title");
			return mstTitleRepository.save(mstTitle);
		}
	}

	public MstReason insertMstReason() {
		MstReason reason = getExistingMstReason();
		if (reason != null) {
			return reason;
		} else {
			reason = new MstReason();
			reason.setNameEng("Test Reason");
			reason.setCreatedAt(new Date());
			reason.setUpdatedAt(new Date());
			return mstReasonRepository.save(reason);
		}
	}

	public MstReason getExistingMstReason() {
		List<MstReason> reason = mstReasonRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!reason.isEmpty()) {
			return reason.get(0);
		} else {
			return null;
		}
	}

	public MstRelationship insertMstRelationship() {
		MstRelationship mstRelationship = getExistingMstRelationship();
		if (mstRelationship != null) {
			return mstRelationship;
		} else {
			mstRelationship = new MstRelationship();
			mstRelationship.setDescription("Test Relationship");
			mstRelationship.setName("TEST_RELATION");
			mstRelationship.setNameSin("TEST_RELATION_SIN");
			mstRelationship.setNameTam("TEST_RELATION_TAM");
			mstRelationship.setCreatedAt(new Date());
			mstRelationship.setUpdatedAt(new Date());
			return mstRelationshipRepository.save(mstRelationship);
		}
	}

	public MstRelationship getExistingMstRelationship() {
		List<MstRelationship> mstRelationships = mstRelationshipRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstRelationships.isEmpty()) {
			return mstRelationships.get(0);
		} else {
			return null;
		}
	}

	public MstCountry insertMstCountry() {
		MstCountry country = getExistingMstCountry();
		if (country != null) {
			return country;
		} else {
			country = new MstCountry();
			country.setNameEng("Test Country");
			country.setBaseCountry(false);
			country.setActive(true);
			return mstCountryRepository.save(country);
		}
	}

	public MstCountry getExistingMstCountry() {
		List<MstCountry> mstCountry = mstCountryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstCountry.isEmpty()) {
			return mstCountry.get(0);
		} else {
			return null;
		}
	}

	public MstTxnAction insertMstTxnAction(long actionNo) {
		MstTxnAction mstTxnAction = getMstTxnAction(actionNo);

		if(mstTxnAction != null) {
			return mstTxnAction;
		}else {
			mstTxnAction = new MstTxnAction();
			mstTxnAction.setActionNo(actionNo);
			mstTxnAction.setName("test action");
			mstTxnAction.setDescription("test description");
			return this.mstTxnActionRepository.save(mstTxnAction);
		}
	}
	private MstTxnAction getMstTxnAction(long actionNo) {

		Optional<MstTxnAction> mstAction = this.mstTxnActionRepository.findByActionNo(actionNo);

		if(mstAction.isPresent())
			return mstAction.get();
		else
			return null;
	}

	public MstDocumentType insertMstDocumentType() {
		MstDocumentType mstDocumentType = getExistingMstDocumentType();
		if(mstDocumentType != null) {
			return mstDocumentType;
		} else {
			mstDocumentType = new MstDocumentType();
			mstDocumentType.setNameEng("test doc english");
			return mstDocumentTypeRepository.save(mstDocumentType);
		}
	}
	private MstDocumentType getExistingMstDocumentType() {
		List<MstDocumentType> mstDocumentType = this.mstDocumentTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstDocumentType.isEmpty()) {
			return mstDocumentType.get(0);
		} else {
			return null;
		}
	}

	public MstDmuPackingType insertMstDmuPackingType() {
		MstDmuPackingType packingType = getExistingMstDmuPackingType();
		if(packingType != null) {
			return packingType;
		} else {
			packingType = new MstDmuPackingType();
			packingType.setCode("BOX");
			packingType.setName("Box");
			return mstDmuPackingTypeRepository.save(packingType);
		}
	}
	private MstDmuPackingType getExistingMstDmuPackingType() {
		List<MstDmuPackingType> packingTypes = this.mstDmuPackingTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!packingTypes.isEmpty()) {
			return packingTypes.get(0);
		} else {
			return null;
		}
	}

	public MstDmuInboundStatus insertMstDmuInboundStatus() {
		MstDmuInboundStatus status = getExistingMstDmuInboundStatus();
		if(status != null) {
			return status;
		} else {
			status = new MstDmuInboundStatus();
			status.setCode("TEST_STATUS");
			status.setName("Test status");
			return mstDmuInboundStatusRepository.save(status);
		}
	}

	private MstDmuInboundStatus getExistingMstDmuInboundStatus() {
		List<MstDmuInboundStatus> statuses = this.mstDmuInboundStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!statuses.isEmpty()) {
			return statuses.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerScheduleVisitType insertMstEmployerScheduleVisitType() {
		MstEmployerScheduleVisitType mstEmployerScheduleVisitType = getExistingMstEmployerScheduleVisitType();
		if(mstEmployerScheduleVisitType != null) {
			return mstEmployerScheduleVisitType;
		}else {
			mstEmployerScheduleVisitType = new MstEmployerScheduleVisitType();
			mstEmployerScheduleVisitType.setCode("OPN");
			mstEmployerScheduleVisitType.setName("test Open");

			return mstEmployerScheduleVisitTypeRepository.save(mstEmployerScheduleVisitType);
		}
	}
	private MstEmployerScheduleVisitType getExistingMstEmployerScheduleVisitType() {
		List<MstEmployerScheduleVisitType> mstEmployerScheduleVisitType = this.mstEmployerScheduleVisitTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstEmployerScheduleVisitType.isEmpty()) {
			return mstEmployerScheduleVisitType.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerScheduleVisitStatus insertMstEmployerScheduleVisitStatus() {
		MstEmployerScheduleVisitStatus mstEmployerScheduleVisitStatus = getExistingMstEmployerScheduleVisitStatus();
		if(mstEmployerScheduleVisitStatus != null) {
			return mstEmployerScheduleVisitStatus;
		}else {
			mstEmployerScheduleVisitStatus = new MstEmployerScheduleVisitStatus();
			mstEmployerScheduleVisitStatus.setCode("OPN");
			mstEmployerScheduleVisitStatus.setName("test Open");

			return mstEmployerScheduleVisitStatusRepository.save(mstEmployerScheduleVisitStatus);
		}
	}
	private MstEmployerScheduleVisitStatus getExistingMstEmployerScheduleVisitStatus() {
		List<MstEmployerScheduleVisitStatus> mstEmployerScheduleVisitStatus = this.mstEmployerScheduleVisitStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstEmployerScheduleVisitStatus.isEmpty()) {
			return mstEmployerScheduleVisitStatus.get(0);
		} else {
			return null;
		}
	}

	public MstOrganizationCategory insertMstOrganizationCategory() {
		MstOrganizationCategory mstOrganizationCategory = getExistingMstOrganizationCategory();
		if(mstOrganizationCategory != null) {
			return mstOrganizationCategory;
		}else {
			mstOrganizationCategory = new MstOrganizationCategory();
			mstOrganizationCategory.setCode("HD");
			mstOrganizationCategory.setName("test Head Office");

			return mstOrganizationCategoryRepository.save(mstOrganizationCategory);
		}
	}
	private MstOrganizationCategory getExistingMstOrganizationCategory() {
		List<MstOrganizationCategory> mstOrganizationCategory = this.mstOrganizationCategoryRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstOrganizationCategory.isEmpty()) {
			return mstOrganizationCategory.get(0);
		} else {
			return null;
		}
	}

	public MstOrganizationStatus insertMstOrganizationStatus() {
		MstOrganizationStatus mstOrganizationStatus = getExistingMstOrganizationStatus();
		if(mstOrganizationStatus != null) {
			return mstOrganizationStatus;
		}else {
			mstOrganizationStatus = new MstOrganizationStatus();
			mstOrganizationStatus.setCode("ACT");
			mstOrganizationStatus.setName("test Active");

			return mstOrganizationStatusRepository.save(mstOrganizationStatus);
		}
	}
	private MstOrganizationStatus getExistingMstOrganizationStatus() {
		List<MstOrganizationStatus> mstOrganizationStatus = this.mstOrganizationStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstOrganizationStatus.isEmpty()) {
			return mstOrganizationStatus.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerOrganizationType insertMstEmployerOrganizationType() {
		MstEmployerOrganizationType mstEmployerOrganizationType = getMstEmployerOrganizationType();

		if(mstEmployerOrganizationType != null) {
			return mstEmployerOrganizationType;
		}else {
			mstEmployerOrganizationType = new MstEmployerOrganizationType();
			mstEmployerOrganizationType.setActive(true);
			mstEmployerOrganizationType.setName("test action");
			mstEmployerOrganizationType.setDescription("test description");
			mstEmployerOrganizationType.setCode("test_code");
			mstEmployerOrganizationType.setDirectorName("test director");
			return this.mstMstEmployerOrganizationTypeRepository.save(mstEmployerOrganizationType);
		}
	}
	private MstEmployerOrganizationType getMstEmployerOrganizationType() {

		List<MstEmployerOrganizationType> mstEmployerOrganizationTypes = this.mstMstEmployerOrganizationTypeRepository.findAll(PageRequest.of(0, 1)).getContent();

		if (!mstEmployerOrganizationTypes.isEmpty()) {
			return mstEmployerOrganizationTypes.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerStatus insertMstEmployerStatus() {
			MstEmployerStatus mstEmployerOrganizationType = getMstEmployerStatus();

		if(mstEmployerOrganizationType != null) {
			return mstEmployerOrganizationType;
		}else {
			mstEmployerOrganizationType = new MstEmployerStatus();
			mstEmployerOrganizationType.setName("test action");
			mstEmployerOrganizationType.setDescription("test description");
			mstEmployerOrganizationType.setCode("test_code");
			return this.mstEmployerStatusRepository.save(mstEmployerOrganizationType);
		}
	}
	private MstEmployerStatus getMstEmployerStatus() {
		List<MstEmployerStatus> mstEmployerOrganizationTypes = this.mstEmployerStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!mstEmployerOrganizationTypes.isEmpty()) {
			return mstEmployerOrganizationTypes.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerType insertMstEmployerType() {
			MstEmployerType mstEmployerOrganizationType = getMstEmployerType();

		if(mstEmployerOrganizationType != null) {
			return mstEmployerOrganizationType;
		}else {
			mstEmployerOrganizationType = new MstEmployerType();
			mstEmployerOrganizationType.setName("test action");
			mstEmployerOrganizationType.setDescription("test description");
			mstEmployerOrganizationType.setCode("test_code");
			return this.mstEmployerTypeRepository.save(mstEmployerOrganizationType);
		}
	}
	private MstEmployerType getMstEmployerType() {
		List<MstEmployerType> mstEmployerOrganizationTypes = this.mstEmployerTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstEmployerOrganizationTypes.isEmpty()) {
			return mstEmployerOrganizationTypes.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerCreateSourceType insertMstEmployerCreateSourceType() {
		MstEmployerCreateSourceType mstEmployerCreateSourceType = getMstEmployerCreateSourceType();

		if(mstEmployerCreateSourceType != null) {
			return mstEmployerCreateSourceType;
		}else {
			mstEmployerCreateSourceType = new MstEmployerCreateSourceType();
			mstEmployerCreateSourceType.setName("test action");
			mstEmployerCreateSourceType.setDescription("test description");
			mstEmployerCreateSourceType.setCode("test_code");
			return this.mstEmployerCreateSourceTypeRepository.save(mstEmployerCreateSourceType);
		}
	}
	private MstEmployerCreateSourceType getMstEmployerCreateSourceType() {
		List<MstEmployerCreateSourceType> mstEmployerCreateSourceTypes = this.mstEmployerCreateSourceTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstEmployerCreateSourceTypes.isEmpty()) {
			return mstEmployerCreateSourceTypes.get(0);
		} else {
			return null;
		}
	}

	public MstEnforcementDefaulterStatus insertMstEnforcementDefaulterStatus() {
		MstEnforcementDefaulterStatus mstEmployerCreateSourceType = getMstEnforcementDefaulterStatus();

		if(mstEmployerCreateSourceType != null) {
			return mstEmployerCreateSourceType;
		}else {
			mstEmployerCreateSourceType = new MstEnforcementDefaulterStatus();
			mstEmployerCreateSourceType.setName("test action");
			mstEmployerCreateSourceType.setDescription("test description");
			mstEmployerCreateSourceType.setCode("test_code");
			return this.mstEnforcementDefaulterStatusRepository.save(mstEmployerCreateSourceType);
		}
	}
	private MstEnforcementDefaulterStatus getMstEnforcementDefaulterStatus() {
		List<MstEnforcementDefaulterStatus> mstEmployerCreateSourceTypes = this.mstEnforcementDefaulterStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstEmployerCreateSourceTypes.isEmpty()) {
			return mstEmployerCreateSourceTypes.get(0);
		} else {
			return null;
		}
	}

	public MstCollectionSource insertMstCollectionSource() {
		MstCollectionSource mstCollectionSource = getMstCollectionSource();

		if(mstCollectionSource != null) {
			return mstCollectionSource;
		}else {
			mstCollectionSource = new MstCollectionSource();
			mstCollectionSource.setName("test action");
			mstCollectionSource.setDescription("test description");
			mstCollectionSource.setCode("test_code");
			return this.mstCollectionSourceRepository.save(mstCollectionSource);
		}
	}
	private MstCollectionSource getMstCollectionSource() {
		List<MstCollectionSource> mstCollectionSources = this.mstCollectionSourceRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstCollectionSources.isEmpty()) {
			return mstCollectionSources.get(0);
		} else {
			return null;
		}
	}

	public MstEmployerSelfEmploymentPaymentStatus insertEmployerSelfEmploymentPaymentStatus() {
		MstEmployerSelfEmploymentPaymentStatus employerSelfEmploymentPaymentStatus = getEmployerSelfEmploymentPaymentStatus();

		if(employerSelfEmploymentPaymentStatus != null) {
			return employerSelfEmploymentPaymentStatus;
		}else {
			employerSelfEmploymentPaymentStatus = new MstEmployerSelfEmploymentPaymentStatus();
			employerSelfEmploymentPaymentStatus.setName("test action");
			employerSelfEmploymentPaymentStatus.setDescription("test description");
			employerSelfEmploymentPaymentStatus.setCode("test_code");
			return this.mstEmployerSelfEmploymentPaymentStatusRepository.save(employerSelfEmploymentPaymentStatus);
		}
	}
	private MstEmployerSelfEmploymentPaymentStatus getEmployerSelfEmploymentPaymentStatus() {
		List<MstEmployerSelfEmploymentPaymentStatus> collectionSources = this.mstEmployerSelfEmploymentPaymentStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!collectionSources.isEmpty()) {
			return collectionSources.get(0);
		} else {
			return null;
		}
	}

	public MstPaymentReferenceNoType insertPaymentReferenceNoType() {
		MstPaymentReferenceNoType employerSelfEmploymentPaymentStatus = getMstPaymentReferenceNoType();
		if (employerSelfEmploymentPaymentStatus != null) {
			return employerSelfEmploymentPaymentStatus;
		}
		employerSelfEmploymentPaymentStatus = new MstPaymentReferenceNoType();
		employerSelfEmploymentPaymentStatus.setName("test action");
		employerSelfEmploymentPaymentStatus.setDescription("test description");
		employerSelfEmploymentPaymentStatus.setCode("test_code");
		return this.mstPaymentReferenceNoTypeRepository.save(employerSelfEmploymentPaymentStatus);
	}
	private MstPaymentReferenceNoType getMstPaymentReferenceNoType() {
		List<MstPaymentReferenceNoType> collectionSources = this.mstPaymentReferenceNoTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!collectionSources.isEmpty()) {
			return collectionSources.get(0);
		} else {
			return null;
		}
	}

	// mst etfb zone
	public MstEtfbZone insertEtfbZone() {
		MstEtfbZone mstEtfbZone = getExistingEtfbZone();
		if(mstEtfbZone!=null) {
			return mstEtfbZone;
		}
		mstEtfbZone = new MstEtfbZone();
		mstEtfbZone.setZone("ETFB Zone");
		mstEtfbZone.setCreatedAt(new Date());
		mstEtfbZone.setUpdatedAt(new Date());
		return this.mstEtfbZoneRepository.save(mstEtfbZone);
		}

	private MstEtfbZone getExistingEtfbZone() {
		List<MstEtfbZone> mstEtfbZone = this.mstEtfbZoneRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstEtfbZone.isEmpty()) {
			return mstEtfbZone.get(0);
		}
			return null;
		}

	public MstSelfEmploymentCategoryNature insertMstSelfEmploymentCategoryNature() {
		MstSelfEmploymentCategoryNature mstSelfEmploymentCategoryNature = getMstSelfEmploymentCategoryNature();

		if(mstSelfEmploymentCategoryNature != null) {
			return mstSelfEmploymentCategoryNature;
		}else {
			mstSelfEmploymentCategoryNature = new MstSelfEmploymentCategoryNature();
			mstSelfEmploymentCategoryNature.setSelfEmploymentCategoryId(new MstSelfEmploymentCategory(1l));
			mstSelfEmploymentCategoryNature.setNameEng("Name");
			mstSelfEmploymentCategoryNature.setCreatedAt(new Date());
			mstSelfEmploymentCategoryNature.setUpdatedAt(new Date());
			return this.mstSelfEmploymentCategoryNatureRepository.save(mstSelfEmploymentCategoryNature);
		}
	}
	private MstSelfEmploymentCategoryNature getMstSelfEmploymentCategoryNature() {
		List<MstSelfEmploymentCategoryNature> mstSelfEmploymentCategoryNature = this.mstSelfEmploymentCategoryNatureRepository.findAll(PageRequest.of(0, 1)).getContent();
		if (!mstSelfEmploymentCategoryNature.isEmpty()) {
			return mstSelfEmploymentCategoryNature.get(0);
		} else {
			return null;
		}
	}

	public MstContactType insertMstContactType() {
		MstContactType contactType = getExistingMstContactType();
		if (contactType != null) {
			return contactType;
		}

		contactType = new MstContactType();
		contactType.setCode("test_code");
		contactType.setNameEng("test_name");
		return this.mstContactTypeRepository.save(contactType);

	}

	public MstContactType getExistingMstContactType() {
		List<MstContactType> contactTypes = this.mstContactTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!contactTypes.isEmpty()) {
			return contactTypes.get(0);
		} else {
			return null;
		}
	}

	

	public MstServiceRequestSource getExistingMstServiceRequestSource() {
		List<MstServiceRequestSource> mstPriority = mstServiceRequestSourceRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstPriority.isEmpty()) {
			return mstPriority.get(0);
		} else {
			return null;
		}
	}
	public MstServiceRequestType getExistingMstServiceRequestType() {
		List<MstServiceRequestType> mstPriority = mstServiceRequestTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstPriority.isEmpty()) {
			return mstPriority.get(0);
		} else {
			return null;
		}
	}
	public MstServiceRequestStatus getExistingMstServiceRequestStatus() {
		List<MstServiceRequestStatus> mstPriority = mstServiceRequestStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstPriority.isEmpty()) {
			return mstPriority.get(0);
		} else {
			return null;
		}
	}

	public MstSbu getExistingMstSbu() {
		List<MstSbu> mstSbu = mstSbuRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstSbu.isEmpty()) {
			return mstSbu.get(0);
		} else {
			return null;
		}
	}

	public MstServiceCounterInquiryType insertMstServiceCounterInquiryType() {
		MstServiceCounterInquiryType counterInquiryType = getExistingMstServiceCounterInquiryType();
		if(counterInquiryType != null) {
			return counterInquiryType;
		}

		counterInquiryType = new MstServiceCounterInquiryType();
		counterInquiryType.setName("test_name");
		counterInquiryType.setCode("test_code");
		counterInquiryType.setDescription("test_description");
		return this.mstServiceCounterInquiryTypeRepository.save(counterInquiryType);
	}

	public MstServiceCounterInquiryType getExistingMstServiceCounterInquiryType() {
		List<MstServiceCounterInquiryType> counterInquiries = this.mstServiceCounterInquiryTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!counterInquiries.isEmpty()) {
			return counterInquiries.get(0);
		} else {
			return null;
		}
	}

	public MstServiceCounterStatus insertMstServiceCounterStatus() {
		MstServiceCounterStatus serviceCounterStatus = getExistingMstServiceCounterStatus();
		if(serviceCounterStatus != null) {
			return serviceCounterStatus;
		}

		serviceCounterStatus = new MstServiceCounterStatus();
		serviceCounterStatus.setName("test_name");
		serviceCounterStatus.setCode("test_name");
		serviceCounterStatus.setDescription("test_description");
		return this.mstServiceCounterStatusRepository.save(serviceCounterStatus);
	}

	public MstServiceCounterStatus getExistingMstServiceCounterStatus() {
		List<MstServiceCounterStatus> serviceCounterStatuses = this.mstServiceCounterStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!serviceCounterStatuses.isEmpty()) {
			return serviceCounterStatuses.get(0);
		} else {
			return null;
		}
	}

	public MstServiceCounterRequirementType insertMstServiceCounterRequirementType() {
		MstServiceCounterRequirementType requirementType = getExistingMstServiceCounterRequirementType();
		if(requirementType != null) {
			return requirementType;
		}

		requirementType = new MstServiceCounterRequirementType();
		requirementType.setName("test_name");
		requirementType.setCode("test_code");
		requirementType.setActive(true);
		return this.mstServiceCounterRequirementTypeRepository.save(requirementType);
	}

	public MstServiceCounterRequirementType getExistingMstServiceCounterRequirementType() {
		List<MstServiceCounterRequirementType> serviceCounterRequirementTypes = this.mstServiceCounterRequirementTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!serviceCounterRequirementTypes.isEmpty()) {
			return serviceCounterRequirementTypes.get(0);
		} else {
			return null;
		}
	}

	public MstServiceCounterResolutionType insertMstServiceCounterResolutionType() {
		MstServiceCounterResolutionType resolutionType = getExistingMstServiceCounterResolutionType();
		if(resolutionType != null) {
			return resolutionType;
		}

		resolutionType = new MstServiceCounterResolutionType();
		resolutionType.setName("test_name");
		resolutionType.setCode("test_code");
		return this.mstServiceCounterResolutionTypeRepository.save(resolutionType);
	}

	public MstServiceCounterResolutionType getExistingMstServiceCounterResolutionType() {
		List<MstServiceCounterResolutionType> resolutionTypes = this.mstServiceCounterResolutionTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!resolutionTypes.isEmpty()) {
			return resolutionTypes.get(0);
		} else {
			return null;
		}
	}

	public MstPriority insertMstPriority() {
		MstPriority priority = getExistingMstPriority();
		if (priority != null) {
			return priority;
		}

		priority = new MstPriority();
		priority.setName("test_name");
		priority.setOrderIndex(1);
		priority.setDefaultPriority(false);
		priority.setDefaultPriorityPublic(true);
		return this.mstPriorityRepository.save(priority);
	}

	public MstPriority getExistingMstPriority() {
		List<MstPriority> mstPriority = mstPriorityRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!mstPriority.isEmpty()) {
			return mstPriority.get(0);
		} else {
			return null;
		}
	}
	
	public MstPersonReferenceTable getExistingMstPersonReferenceTable() {
		 List<MstPersonReferenceTable> mstPersonReferenceTable = mstPersonReferenceTableRepository.findAll(PageRequest.of(0, 1)).getContent();
		 if(!mstPersonReferenceTable.isEmpty()) {
			 return mstPersonReferenceTable.get(0);
		 } else {
			 return null;
		 }
	}
}

