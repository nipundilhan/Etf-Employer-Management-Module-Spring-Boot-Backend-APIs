package com.inova.etfb.employer_management.wrapper;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "EmployerProfileDetailsBase" , entities = {
		@EntityResult(entityClass = EmployerProfileDetailsBaseRespDto.class , fields = {
				@FieldResult(name = "employerId" , column = "empId"),
				@FieldResult(name = "employerInterimId" , column = "employerInterimId"),
				@FieldResult(name = "empRefNo" , column = "empRefNo"),
				@FieldResult(name = "epfNo" , column = "epfNo"),
				@FieldResult(name = "businessRegistrationNo" , column = "brn"),

				@FieldResult(name = "employerName" , column = "employerName"),
				@FieldResult(name = "employerNameSin" , column = "employerNameSin"),
				@FieldResult(name = "employerNameTam" , column = "employerNameTam"),
				@FieldResult(name = "temporaryAccountCreated" , column = "temporaryAccountCreated"),
				@FieldResult(name = "employerTypeCode" , column = "employerTypeCode"),
				@FieldResult(name = "employerTypeName" , column = "employerTypeName"),
				@FieldResult(name = "legacyEpfNo" , column = "legacyEpfNo"),

				@FieldResult(name = "industryTypeEng" , column = "IndustryTypeEng"),
				@FieldResult(name = "industryTypeSin" , column = "IndustryTypeSin"),
				@FieldResult(name = "industryTypeTam" , column = "IndustryTypeTam"),

				@FieldResult(name = "natureOfBusinessEng" , column = "natureOfBusinessEng"),
				@FieldResult(name = "natureOfBusinessSin" , column = "natureOfBusinessSin"),
				@FieldResult(name = "natureOfBusinessTam" , column = "natureOfBusinessTam"),

				@FieldResult(name = "organizationType" , column = "organizationType"),
				@FieldResult(name = "dateLiablePayment" , column = "dateLiablePayment"),
				@FieldResult(name = "preferredLanguageCode" , column = "preLanguageCode"),
				@FieldResult(name = "preferredLanguageName" , column = "preLanguageName"),
				@FieldResult(name = "governmentEntity" , column = "governmentEntity"),
				@FieldResult(name = "onlineR4Requested" , column = "onlineR4Requested"),
				@FieldResult(name = "onlineAmsRequested" , column = "onlineAmsRequested"),

				@FieldResult(name = "verificationMobileValue" , column = "verificationMobileValue"),
				@FieldResult(name = "verificationMobileCode" , column = "verificationMobileCode"),
				@FieldResult(name = "verificationEmailValue" , column = "verificationEmailValue"),
				@FieldResult(name = "verificationEmailCode" , column = "verificationEmailCode"),

				@FieldResult(name = "mergedAsChild" , column = "mergedAsChild"),
				@FieldResult(name = "mergedAsParent" , column = "mergedAsParent"),
				@FieldResult(name = "employerStatus" , column = "employerStatus"),
				@FieldResult(name = "employerStatusCode" , column = "employerStatusCode"),

				@FieldResult(name = "inactiveReason" , column = "inactiveReason"),
				@FieldResult(name = "inactiveReasonSin" , column = "inactiveReasonSin"),
				@FieldResult(name = "inactiveReasonTam" , column = "inactiveReasonTam"),

				@FieldResult(name = "availableBalance" , column = "availableBalance"),
				@FieldResult(name = "employerNote" , column = "employerNote"),
				@FieldResult(name = "employerNotePublic" , column = "employerNotePublic"),

				@FieldResult(name = "employerHistoryId" , column = "employerHistoryId"),
				@FieldResult(name = "updateAt" , column = "updateAt"),
				@FieldResult(name = "updateBy" , column = "updateBy"),
				@FieldResult(name = "updatedEtfbBranch" , column = "updatedEtfbBranch"),
				@FieldResult(name = "dmuInboundRefNo" , column = "dmuRefNo"),
				@FieldResult(name = "serviceCounterRefNo" , column = "serviceCounterRefNo"),
				@FieldResult(name = "serviceRequestRefNo" , column = "serviceRequestRefNo"),
				@FieldResult(name = "employerPortal" , column = "employerPortal"),

				@FieldResult(name = "epfNoUpdated" , column = "epfNoUpdated"),
				@FieldResult(name = "natureOfBusinessIdUpdated" , column = "natureOfBusinessIdUpdated"),
				@FieldResult(name = "nameUpdated" , column = "nameUpdated"),
				@FieldResult(name = "nameSinUpdated" , column = "nameSinUpdated"),
				@FieldResult(name = "nameTamUpdated" , column = "nameTamUpdated"),
				@FieldResult(name = "businessRegistrationNoUpdated" , column = "businessRegistrationNoUpdated"),
				@FieldResult(name = "employerOrganizationTypeIdUpdated" , column = "employerOrganizationTypeIdUpdated"),
				@FieldResult(name = "dateLiablePaymentUpdated" , column = "dateLiablePaymentUpdated"),
				@FieldResult(name = "industryTypeIdUpdated" , column = "industryTypeIdUpdated"),
				@FieldResult(name = "employerTypeIdUpdated" , column = "employerTypeIdUpdated"),
				@FieldResult(name = "employerStatusIdUpdated" , column = "employerStatusIdUpdated"),
				@FieldResult(name = "governmentEntityUpdated" , column = "governmentEntityUpdated"),
				@FieldResult(name = "preferredLanguageIdUpdated" , column = "preferredLanguageIdUpdated"),
				@FieldResult(name = "onlineR4RequestedUpdated" , column = "onlineR4RequestedUpdated"),
				@FieldResult(name = "onlineAmsRequestedUpdated" , column = "onlineAmsRequestedUpdated"),
				@FieldResult(name = "verificationMobileIdUpdated" , column = "verificationMobileIdUpdated"),

				@FieldResult(name = "logo" , column = "logo"),
		}),
})


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerProfileDetailsBaseRespDto {

	@Id
	private Long employerId;
	private Long employerInterimId;
	private Long empRefNo;
	private String epfNo;
	private String businessRegistrationNo;

	private String employerName;
	private String employerNameSin;
	private String employerNameTam;
	private Boolean temporaryAccountCreated;
	private String employerTypeCode;
	private String employerTypeName;
	private String legacyEpfNo;

	private String industryTypeEng;
	private String industryTypeSin;
	private String industryTypeTam;

	private String natureOfBusinessEng;
	private String natureOfBusinessSin;
	private String natureOfBusinessTam;

	private String organizationType;
	private Date dateLiablePayment;
	private String preferredLanguageCode;
	private String preferredLanguageName;
	private Boolean governmentEntity;
	private Boolean onlineR4Requested;
	private Boolean onlineAmsRequested;

	private String verificationMobileValue;
	private String verificationMobileCode;
	private String verificationEmailValue;
	private String verificationEmailCode;

	private Boolean mergedAsParent;
	private Boolean mergedAsChild;
	private String employerStatus;
	private String employerStatusCode;

	private String inactiveReason;
	private String inactiveReasonSin;
	private String inactiveReasonTam;

	private BigDecimal availableBalance;
	private String employerNote;
	private String employerNotePublic;

	private Long employerHistoryId;
	private Date updateAt;
	private String  updateBy;
	private String updatedEtfbBranch;
	private Long dmuInboundRefNo;
	private Long serviceCounterRefNo;
	private Long serviceRequestRefNo;
	private Boolean employerPortal;

	private Integer epfNoUpdated;
	private Integer natureOfBusinessIdUpdated;
	private Integer  nameUpdated;
	private Integer nameSinUpdated;
	private Integer nameTamUpdated;
	private Integer businessRegistrationNoUpdated;
	private Integer employerOrganizationTypeIdUpdated;
	private Integer dateLiablePaymentUpdated;
	private Integer industryTypeIdUpdated;
	private Integer employerTypeIdUpdated;
	private Integer employerStatusIdUpdated;
	private Integer governmentEntityUpdated;
	private Integer preferredLanguageIdUpdated;
	private Integer onlineR4RequestedUpdated;
	private Integer onlineAmsRequestedUpdated;
	private Integer verificationMobileIdUpdated;

	private byte[] logo;
}