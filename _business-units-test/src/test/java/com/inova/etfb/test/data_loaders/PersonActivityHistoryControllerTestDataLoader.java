package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.Transaction;
import com.inova.dao.entities.TxnMember;
import com.inova.dao.repositories.TransactionRepository;
import com.inova.dao.repositories.TxnMemberRepository;
import com.inova.util.NoteFormatter;

@Component
public class PersonActivityHistoryControllerTestDataLoader {
	
	@Autowired
	private TxnMemberRepository txnMemberRepository;

	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	@Autowired
	private MstDataLoader mstDataLoader;
	
	@Autowired
	private TransactionRepository transactionRepository;
	

	public TxnMember insertTxnMember() {
		
		TxnMember txnMember = getExistingTxnMember();
		
		if(txnMember != null) {
			return txnMember;
		}
		
		txnMember = new TxnMember();
		txnMember.setMemberId(this.txnCommonDataLoader.insertMember());
		txnMember.setTransactionId(insertTransaction());
		
		return this.txnMemberRepository.save(txnMember);
	}


	private TxnMember getExistingTxnMember() {

		List<TxnMember> listTxnMember = this.txnMemberRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!listTxnMember.isEmpty()) {
			return listTxnMember.get(0);
		}
		return null;
	}


	private Transaction insertTransaction() {
		
		Transaction transaction = getExistingTransaction();
		
		if(transaction != null) {
			return transaction;
		}else {
			transaction = new Transaction();
			transaction.setActionId(this.mstDataLoader.insertMstTxnAction(2001));
			transaction.setNote(NoteFormatter.getFormattedNote("", "test note", "test"));
			return this.transactionRepository.save(transaction);
		}
		
	}


	private Transaction getExistingTransaction() {
		
		List<Transaction> transaction = this.transactionRepository.findAll(PageRequest.of(0, 1)).getContent();
		
		if(!transaction.isEmpty()) {
			return transaction.get(0);
		}else {
			return null;
		}
	}
	
	
	
}
