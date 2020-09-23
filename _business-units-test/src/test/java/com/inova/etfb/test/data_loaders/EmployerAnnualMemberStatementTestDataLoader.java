package com.inova.etfb.test.data_loaders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.IntCalcAmic;
import com.inova.dao.entities.IntCalcAmicMemberAccountAms;
import com.inova.dao.entities.MstIntCalcAmicAmsGenerateType;
import com.inova.dao.entities.MstIntCalcAmicAmsStatus;
import com.inova.dao.entities.MstIntCalcAmicStatus;
import com.inova.dao.entities.MstInterestDividendPercentage;
import com.inova.dao.entities.TxnEmployer;
import com.inova.dao.repositories.IntCalcAmicMemberAccountAmsRepository;
import com.inova.dao.repositories.IntCalcAmicRepository;
import com.inova.dao.repositories.MstIntCalcAmicAmsGenerateTypeRepository;
import com.inova.dao.repositories.MstIntCalcAmicAmsStatusRepository;
import com.inova.dao.repositories.MstIntCalcAmicStatusRepository;
import com.inova.dao.repositories.MstInterestDividendPercentageRepository;

@Component
public class EmployerAnnualMemberStatementTestDataLoader {
	
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	@Autowired
	private IntCalcAmicRepository intCalcAmicRepository; 
	
	@Autowired
	private MstIntCalcAmicStatusRepository mstIntCalcAmicStatusRepository;
	
	@Autowired
	private MstIntCalcAmicAmsStatusRepository mstIntCalcAmicAmsStatusRepository;
	
	@Autowired
	private MstInterestDividendPercentageRepository mstInterestDividendPercentageRepository;
	
	@Autowired
	private MstIntCalcAmicAmsGenerateTypeRepository  mstIntCalcAmicAmsGenerateTypeRepository;
	
	@Autowired
	private IntCalcAmicMemberAccountAmsRepository intCalcAmicMemberAccountAmsRepository;
	
	public IntCalcAmicMemberAccountAms insertIntCalcAmicMemberAccountAms() {
		IntCalcAmicMemberAccountAms intCalcAmicMemberAccountAms = getExistingIntCalcAmicMemberAccountAms();
		if(intCalcAmicMemberAccountAms != null) {
			return intCalcAmicMemberAccountAms;		
		}else{
			intCalcAmicMemberAccountAms = new IntCalcAmicMemberAccountAms();
			intCalcAmicMemberAccountAms.setIntCalcAmicId(insertIntCalcAmic());
			intCalcAmicMemberAccountAms.setGenerateTypeId(insertMstIntCalcAmicAmsGenerateType());
			intCalcAmicMemberAccountAms.setStatusId(insertMstIntCalcAmicAmsStatus());
			intCalcAmicMemberAccountAms.setMemberAccountId(txnCommonDataLoader.insertMemberAccount());
			BigDecimal value = new BigDecimal("0.01");
			intCalcAmicMemberAccountAms.setOpeningBalanceAmount(value);
			intCalcAmicMemberAccountAms.setMergedOpeningBalanceAmount(value);
			intCalcAmicMemberAccountAms.setOpeningBalanceInterestAmount(value);
			intCalcAmicMemberAccountAms.setTotalAllocationInterestAmount(value);
			intCalcAmicMemberAccountAms.setMergedTotalOpeningBalanceInterestAmount(value);
			intCalcAmicMemberAccountAms.setMergedTotalAllocationInterestAmount(value);
			intCalcAmicMemberAccountAms.setTotalInterestAmount(value);
			intCalcAmicMemberAccountAms.setOpeningBalanceDividendAmount(value);
			intCalcAmicMemberAccountAms.setTotalAllocationDividendAmount(value);
			intCalcAmicMemberAccountAms.setMergedTotalOpeningBalanceDividendAmount(value);
			intCalcAmicMemberAccountAms.setTotalAllocationDividendAmount(value);
			intCalcAmicMemberAccountAms.setTotalDividendAmount(value);
			intCalcAmicMemberAccountAms.setEndMemberBalanceAmount(value);
			return intCalcAmicMemberAccountAmsRepository.save(intCalcAmicMemberAccountAms);
		}
	}
	
	
	private IntCalcAmicMemberAccountAms getExistingIntCalcAmicMemberAccountAms() {
		 List<IntCalcAmicMemberAccountAms> content = this.intCalcAmicMemberAccountAmsRepository.findAll(PageRequest.of(0, 1)).getContent();
		 if(!content.isEmpty()) {
			return content.get(0);
		 } else {
			return null;
		 }		
	}

	public IntCalcAmic insertIntCalcAmic() {
		
		IntCalcAmic intCalcAmic = getExistingIntCalcAmic();
		
		if(intCalcAmic != null) {
			return intCalcAmic;
			
		} else {
			intCalcAmic = new IntCalcAmic();
			intCalcAmic.setRefNo((long) 8186);
			intCalcAmic.setStartDate(new Date());
			intCalcAmic.setEndDate(new Date());
			intCalcAmic.setAccountingYear(2020);
			intCalcAmic.setInterestPercentageId(getExistingMstInterestDividendPercentage());
			intCalcAmic.setStatusId(getExistingMstIntCalcAmicStatus());
			BigDecimal value = new BigDecimal("0.01");
			intCalcAmic.setInterestPercentage(value);
			intCalcAmic.setDividendPercentage(value);
			return intCalcAmicRepository.save(intCalcAmic);

		}
				

	}
	
	private MstInterestDividendPercentage getExistingMstInterestDividendPercentage() {
		
		
		 List<MstInterestDividendPercentage> content = this.mstInterestDividendPercentageRepository.findAll(PageRequest.of(0, 1)).getContent();
			if(!content.isEmpty()) {
				return content.get(0);
			} else {
				return null;
			}
	}
	
	public MstInterestDividendPercentage insertMstInterestDividendPercentage() {
		MstInterestDividendPercentage mstInterestDividendPercentage = getExistingMstInterestDividendPercentage();
		if(mstInterestDividendPercentage  != null) {
				return mstInterestDividendPercentage;
		}else {
			mstInterestDividendPercentage = new MstInterestDividendPercentage();
			BigDecimal value = new BigDecimal("0.01");
			mstInterestDividendPercentage.setDividendPercentage(value);
			mstInterestDividendPercentage.setTotalInterestPercentage(value);
			mstInterestDividendPercentage.setInterestPercentage(value);
			mstInterestDividendPercentage.setStartAt(new Date());
			return mstInterestDividendPercentageRepository.save(mstInterestDividendPercentage);
			
		}
	}

	private IntCalcAmic getExistingIntCalcAmic() {
		
		 List<IntCalcAmic> content = this.intCalcAmicRepository.findAll(PageRequest.of(0, 1)).getContent();
			if(!content.isEmpty()) {
				return content.get(0);
			} else {
				return null;
			}
	}
	
	
	public MstIntCalcAmicStatus insertMstIntCalcAmicStatus() {
		
		MstIntCalcAmicStatus mstIntCalcAmicStatus = getExistingMstIntCalcAmicStatus();
		if(mstIntCalcAmicStatus != null) {
			
			return mstIntCalcAmicStatus;
		}else {
			mstIntCalcAmicStatus = new MstIntCalcAmicStatus();
			mstIntCalcAmicStatus.setCode("TST");
			mstIntCalcAmicStatus.setDescription("test status");
			mstIntCalcAmicStatus.setName("test");
			return mstIntCalcAmicStatusRepository.save(mstIntCalcAmicStatus);
		}
		
	}
	
	private MstIntCalcAmicStatus getExistingMstIntCalcAmicStatus() {
		
		 List<MstIntCalcAmicStatus> content = this.mstIntCalcAmicStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
			if(!content.isEmpty()) {
				return content.get(0);
			} else {
				return null;
			}
	}
	
	public MstIntCalcAmicAmsGenerateType insertMstIntCalcAmicAmsGenerateType() {
		
		MstIntCalcAmicAmsGenerateType mstIntCalcAmicAmsGenerateType = getExistingMstIntCalcAmicAmsGenerateType();
		if(mstIntCalcAmicAmsGenerateType != null) {
			
			return mstIntCalcAmicAmsGenerateType;
		}else{
			mstIntCalcAmicAmsGenerateType = new MstIntCalcAmicAmsGenerateType();
			mstIntCalcAmicAmsGenerateType.setCode("TST");
			mstIntCalcAmicAmsGenerateType.setName("test");
			mstIntCalcAmicAmsGenerateType.setDescription("test generate type");
			return mstIntCalcAmicAmsGenerateTypeRepository.save(mstIntCalcAmicAmsGenerateType);
		}
	
	
	}
	
	
	private MstIntCalcAmicAmsGenerateType getExistingMstIntCalcAmicAmsGenerateType() {
		 List<MstIntCalcAmicAmsGenerateType> content = this.mstIntCalcAmicAmsGenerateTypeRepository.findAll(PageRequest.of(0, 1)).getContent();
			if(!content.isEmpty()) {
				return content.get(0);
			} else {
				return null;
			}
		
	}
	
	
	public MstIntCalcAmicAmsStatus insertMstIntCalcAmicAmsStatus() {
		
		MstIntCalcAmicAmsStatus mstIntCalcAmicAmsStatus = getExistingMstIntCalcAmicAmsStatus();
		if(mstIntCalcAmicAmsStatus != null) {
			
			return mstIntCalcAmicAmsStatus;
		}else {
			mstIntCalcAmicAmsStatus = new MstIntCalcAmicAmsStatus();
			mstIntCalcAmicAmsStatus.setCode("TST");
			mstIntCalcAmicAmsStatus.setDescription("test status");
			mstIntCalcAmicAmsStatus.setName("test");
			return mstIntCalcAmicAmsStatusRepository.save(mstIntCalcAmicAmsStatus);
		}
		
	}
	
	private MstIntCalcAmicAmsStatus getExistingMstIntCalcAmicAmsStatus() {
		
		 List<MstIntCalcAmicAmsStatus> content = this.mstIntCalcAmicAmsStatusRepository.findAll(PageRequest.of(0, 1)).getContent();
			if(!content.isEmpty()) {
				return content.get(0);
			} else {
				return null;
			}
	}
}
