package com.inova.etfb.test.data_loaders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.EmployerAvailableBalance;
import com.inova.dao.repositories.EmployerAvailableBalanceRepository;

@Component
public class ViewEmployerAvailableBalanceAccountControllerTestDataLoader {
	@Autowired
	EmployerAvailableBalanceRepository employerAvailableBalanceRepository;
	@Autowired
	private TxnCommonDataLoader txnCommonDataLoader;

	public EmployerAvailableBalance insertEmployerAvailableBalance() {
		EmployerAvailableBalance availableBalance = getExistingEmployerAvailableBalance();
		if (availableBalance != null) {
			return availableBalance;
		} else {
			availableBalance = new EmployerAvailableBalance();
			availableBalance.setEmployerId(txnCommonDataLoader.insertEmployer());
			availableBalance.setTransactionId(txnCommonDataLoader.insertTransaction());
			availableBalance.setAmount(new BigDecimal(100.00));
			availableBalance.setCreatedAt(new Date());
			availableBalance.setAvailableBalanceAmount(new BigDecimal(100.00));
			availableBalance.setCredit(true);
			return employerAvailableBalanceRepository.save(availableBalance);
		}
	}

	private EmployerAvailableBalance getExistingEmployerAvailableBalance() {
		List<EmployerAvailableBalance> balances = employerAvailableBalanceRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!balances.isEmpty()) {
			return balances.get(0);
		} else {
			return null;
		}
	}
}
