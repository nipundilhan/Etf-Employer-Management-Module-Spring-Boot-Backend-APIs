package com.inova.etfb.test.data_loaders;

import com.inova.dao.entities.EmployerPayment;
import com.inova.dao.entities.EmployerPaymentRemittanceDetail;
import com.inova.dao.entities.PaymentReferenceNo;
import com.inova.dao.repositories.EmployerPaymentRemittanceDetailRepository;
import com.inova.dao.repositories.EmployerPaymentRepository;
import com.inova.dao.repositories.PaymentReferenceNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class SelectCollectionControllerTestDataLoader {
    @Autowired
    private EmployerPaymentRemittanceDetailRepository employerPaymentRemittanceDetailRepository;
    @Autowired
    private EmployerPaymentRepository employerPaymentRepository;
    @Autowired
    private PaymentReferenceNoRepository paymentReferenceNoRepository;
    @Autowired
    TxnCommonDataLoader txnCommonDataLoader;
    @Autowired
    MstDataLoader mstDataLoader;

    public EmployerPaymentRemittanceDetail insertEmployerPaymentRemittanceDetail() {
        EmployerPaymentRemittanceDetail employerPaymentRemittanceDetail = getExistingEmployerPaymentRemittanceDetail();
        if (employerPaymentRemittanceDetail != null) {
            return employerPaymentRemittanceDetail;
        }
        employerPaymentRemittanceDetail = new EmployerPaymentRemittanceDetail();
        employerPaymentRemittanceDetail.setEmployerPaymentId(insertEmployerPayment().getId());
        employerPaymentRemittanceDetail.setEmployerMemberAccountId(txnCommonDataLoader.insertEmployerMemberAccount().getId());
        employerPaymentRemittanceDetail.setMemberAccountId(txnCommonDataLoader.insertMemberAccount().getId());
        employerPaymentRemittanceDetail.setYear(2020);
        employerPaymentRemittanceDetail.setMonth(6);
        employerPaymentRemittanceDetail.setContribution(BigDecimal.valueOf(2000));
        employerPaymentRemittanceDetail.setMemberNo(1);
        employerPaymentRemittanceDetail.setContributionDueDate(new Date());
        employerPaymentRemittanceDetail.setGracePeriod(30);
        employerPaymentRemittanceDetail.setCreatedAt(new Date());

        return employerPaymentRemittanceDetailRepository.save(employerPaymentRemittanceDetail);

    }

    private EmployerPaymentRemittanceDetail getExistingEmployerPaymentRemittanceDetail() {
        List<EmployerPaymentRemittanceDetail> employerPaymentRemittanceDetails = employerPaymentRemittanceDetailRepository.findAll(PageRequest.of(0, 1)).getContent();
        if (!employerPaymentRemittanceDetails.isEmpty()) {
            return employerPaymentRemittanceDetails.get(0);
        }
        return null;
    }

    public EmployerPayment insertEmployerPayment() {
        EmployerPayment existingEmployerPayment = getExistingEmployerPayment();
        if (existingEmployerPayment != null) {
            return existingEmployerPayment;
        }
        existingEmployerPayment = new EmployerPayment();
        existingEmployerPayment.setSourceId(this.mstDataLoader.insertMstCollectionSource());
        existingEmployerPayment.setGeneratedAt(new Date());
        existingEmployerPayment.setPaymentReferenceNoId(insertPaymentReferenceNo());
        existingEmployerPayment.setStatusId(this.mstDataLoader.insertEmployerSelfEmploymentPaymentStatus());
        return employerPaymentRepository.save(existingEmployerPayment);
    }

    private EmployerPayment getExistingEmployerPayment() {
        List<EmployerPayment> employerPayments = this.employerPaymentRepository.findAll(PageRequest.of(0, 1)).getContent();
        if (!employerPayments.isEmpty()) {
            return employerPayments.get(0);
        }
        return null;
    }

    public PaymentReferenceNo insertPaymentReferenceNo() {
        PaymentReferenceNo existingPaymentReferenceNo = getExistingPaymentReferenceNo();
        if (existingPaymentReferenceNo != null) {
            return existingPaymentReferenceNo;
        }
        existingPaymentReferenceNo = new PaymentReferenceNo();
        existingPaymentReferenceNo.setTypeId(this.mstDataLoader.insertPaymentReferenceNoType());
        existingPaymentReferenceNo.setAmount(BigDecimal.valueOf(2000));
        existingPaymentReferenceNo.setRefNo(2434234324234324223L);
        return paymentReferenceNoRepository.save(existingPaymentReferenceNo);
    }

    private PaymentReferenceNo getExistingPaymentReferenceNo() {
        List<PaymentReferenceNo> employerPayments = this.paymentReferenceNoRepository.findAll(PageRequest.of(0, 1)).getContent();
        if (!employerPayments.isEmpty()) {
            return employerPayments.get(0);
        }
        return null;
    }

}
