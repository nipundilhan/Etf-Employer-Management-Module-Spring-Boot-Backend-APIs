package com.inova.etfb.test.data_loaders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.Employer;
import com.inova.dao.entities.EmployerMemberAccount;
import com.inova.dao.entities.MemberAccount;
import com.inova.dao.entities.MstEmployerCreateSourceType;
import com.inova.dao.entities.MstEmployerMemberAccountStatus;
import com.inova.dao.entities.MstEmployerMemberGroup;
import com.inova.dao.entities.MstEmployerOrganizationType;
import com.inova.dao.entities.MstEmployerStatus;
import com.inova.dao.entities.MstEmployerType;
import com.inova.dao.entities.MstMemberAccountStatus;
import com.inova.dao.entities.MstMemberAccountType;
import com.inova.dao.repositories.EmployerMemberAccountRepository;
import com.inova.dao.repositories.EmployerRepository;
import com.inova.dao.repositories.MemberAccountRepository;
import com.inova.util.NoteFormatter;
import com.inova.util.RefNoUtil;

@Component
public class PersonProfileEmploymentBasicDetailsControllerTestDataLoader {

	@Autowired
	private EmployerMemberAccountRepository employerMemberAccountRepository;

	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	@Autowired
	private MemberAccountRepository memberAccountRepository;
	
	@Autowired
	private MstDataLoader mstDataLoader;
	
	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private RefNoUtil refNoUtil;
	
	
	public EmployerMemberAccount insertEmployerMemberAccount() {

		EmployerMemberAccount employerMemberAccount = getExistingEmployerMemberAccount();
		if(employerMemberAccount != null) {
			return employerMemberAccount ;
		}
		employerMemberAccount = new EmployerMemberAccount();
		Employer employer = insertEmployer();
		MemberAccount memberAccount = insertMemberAccount();
		employerMemberAccount.setEmployerId(employer);
		employerMemberAccount.setMemberAccountId(memberAccount);
		employerMemberAccount.setNote(NoteFormatter.getFormattedNote("", "test note", "test"));
		employerMemberAccount.setNotePublic(NoteFormatter.getFormattedNote("", "test note public", "test"));
		employerMemberAccount.setMemberNo(10);
		employerMemberAccount.setDesignation("Lawyer");
		employerMemberAccount.setDateJoined(new Date());
		employerMemberAccount.setDateTerminated(new Date());
		MstEmployerMemberGroup mstEmployerMemberGroup = new MstEmployerMemberGroup();
		mstEmployerMemberGroup.setId(1L);
		
		MstEmployerMemberAccountStatus mstEmployerMemberAccountStatus = new MstEmployerMemberAccountStatus();
		mstEmployerMemberAccountStatus.setId(1L);
		employerMemberAccount.setStatusId(mstEmployerMemberAccountStatus);
		employerMemberAccount.setMemberGroupId(mstEmployerMemberGroup);
		return this.employerMemberAccountRepository.save(employerMemberAccount);
	}

	public Employer insertEmployer() {
		
		Employer employer = getExistingEmployer();
		
		if(employer != null) {
			return employer;
		}
		
		employer = new Employer();
		employer.setRefNo(refNoUtil.getRefNumber("employer"));
		employer.setEpfNo("EMP001");
		employer.setName("test employer");
		employer.setNote(NoteFormatter.getFormattedNote("", "test note", "test"));
		employer.setNotePublic(NoteFormatter.getFormattedNote("", "test note public", "test"));
		
		MstEmployerStatus mstEmployerStatus = new MstEmployerStatus();
		mstEmployerStatus.setId(1L);
		employer.setStatusId(mstEmployerStatus);
		
		employer.setIndustryTypeId(this.mstDataLoader.insertMstEmployerIndustryType(1L));
		employer.setNatureOfBusinessId(this.mstDataLoader.insertMstEmployerNatureBusiness());
		
		MstEmployerType mstEmployerType = new MstEmployerType();
		mstEmployerType.setId(1L);
		employer.setEmployerTypeId(mstEmployerType);
		
		MstEmployerCreateSourceType mstEmployerCreateSourceType = new MstEmployerCreateSourceType();
		mstEmployerCreateSourceType.setId(1L);
		employer.setCreatedSourceTypeId(mstEmployerCreateSourceType);
		
		MstEmployerOrganizationType employerOrganizationTypeId = new MstEmployerOrganizationType();
		employerOrganizationTypeId.setId(1L);
		employer.setEmployerOrganizationTypeId(employerOrganizationTypeId );
		return this.employerRepository.save(employer);
	}
	
	public MemberAccount insertMemberAccount() {
		
		MemberAccount memberAccount = getExistingMemberAccount();
		
		if(memberAccount != null) {
			return memberAccount;
		}
		
		memberAccount = new MemberAccount();
		
		memberAccount.setRefNo(refNoUtil.getRefNumber("member_account"));
		MstMemberAccountType mstMemberAccountType = new MstMemberAccountType(); 
		mstMemberAccountType.setId(2L);
		memberAccount.setAccountTypeId(mstMemberAccountType);
		
		MstMemberAccountStatus mstMemberAccountStatus = new MstMemberAccountStatus();
		mstMemberAccountStatus.setId(2L);
		memberAccount.setStatusId(mstMemberAccountStatus);
		
		memberAccount.setMemberId(this.txnCommonDataLoader.insertMember());
		this.memberAccountRepository.save(memberAccount);
		return memberAccount;
	}

	private EmployerMemberAccount getExistingEmployerMemberAccount() {

		List<EmployerMemberAccount> employerMemAcc = this.employerMemberAccountRepository.findAll(PageRequest.of(0, 1)).getContent();

		if(!employerMemAcc.isEmpty())
			return employerMemAcc.get(0);
		else
			return null;
	}

	private Employer getExistingEmployer() {

		List<Employer> employerList = this.employerRepository.findAll(PageRequest.of(0, 1)).getContent();

		if(!employerList.isEmpty()) 
			return employerList.get(0);
		else
			return null;
	}
	
	private MemberAccount getExistingMemberAccount() {

		List<MemberAccount> memberAccountList = this.memberAccountRepository.findAll(PageRequest.of(0, 1)).getContent();

		if(!memberAccountList.isEmpty()) 
			return memberAccountList.get(0);
		else
			return null;
	}
}
