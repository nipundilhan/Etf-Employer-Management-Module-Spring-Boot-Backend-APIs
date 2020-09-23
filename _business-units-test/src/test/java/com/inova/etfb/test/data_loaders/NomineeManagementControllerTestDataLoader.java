package com.inova.etfb.test.data_loaders;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.MemberAccount;
import com.inova.dao.entities.MemberAccountNominee;
import com.inova.dao.entities.Person;
import com.inova.dao.repositories.MemberAccountNomineeRepository;

@Component
public class NomineeManagementControllerTestDataLoader {
	@Autowired
	MemberAccountNomineeRepository memberAccountNomineeRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	public MemberAccountNominee insertMemberAccountNominee() {
		MemberAccountNominee memberAccountNominee = getExistingMemberAccountNominee();
		if (memberAccountNominee != null) {
			return memberAccountNominee;
		} else {
			memberAccountNominee = new MemberAccountNominee();
			Person person = txnCommonDataLoader.insertPerson();
			MemberAccount memberAccount =  txnCommonDataLoader.insertMemberAccount();
			memberAccountNominee.setPersonId(person);
			memberAccountNominee.setMemberAccountId(memberAccount);
			memberAccountNominee.setActive(true);
			memberAccountNominee.setRelationshipId(mstDataLoader.insertMstRelationship());
			memberAccountNominee.setShare(new BigDecimal(12.50));
			memberAccountNominee.setRelationshipSpouce(true);
			return memberAccountNomineeRepository.save(memberAccountNominee);
		}
		
	}
	private MemberAccountNominee getExistingMemberAccountNominee() {
		List<MemberAccountNominee> memberAccountNominees = memberAccountNomineeRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!memberAccountNominees.isEmpty()) {
			return memberAccountNominees.get(0);
		} else {
			return null;
		}
	}
	
}
