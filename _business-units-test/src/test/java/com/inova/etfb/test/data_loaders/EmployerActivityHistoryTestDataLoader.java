package com.inova.etfb.test.data_loaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.TxnEmployer;
import com.inova.dao.repositories.TxnEmployerRepository;

@Component
public class EmployerActivityHistoryTestDataLoader {
	
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;
	
	@Autowired
	private TxnEmployerRepository txnEmployerRepository;
	
	public TxnEmployer insertTxnEmployer() {
		TxnEmployer txnEmployer =  getExistingTxnEmployer();
		if(txnEmployer != null) {
			
			return txnEmployer;
		}
		else {
			
			txnEmployer =  new TxnEmployer();
			txnEmployer.setEmployerId(txnCommonDataLoader.insertEmployer());
			txnEmployer.setTransactionId(txnCommonDataLoader.insertTransaction());
			txnEmployer = txnEmployerRepository.save(txnEmployer);
		}
		return txnEmployer;
	}
	
	private TxnEmployer getExistingTxnEmployer() {
		 List<TxnEmployer> content = this.txnEmployerRepository.findAll(PageRequest.of(0, 1)).getContent();
			if(!content.isEmpty()) {
				return content.get(0);
			} else {
				return null;
			}
	}

}
