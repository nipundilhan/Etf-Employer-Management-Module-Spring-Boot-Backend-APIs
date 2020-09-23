package com.inova.etfb.test.data_loaders;

import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.EmployerPayment;
import com.inova.dao.entities.EmployerPaymentRemittanceDetail;
import com.inova.dao.entities.MstDocumentType;
import com.inova.dao.entities.PaymentReferenceNo;
import com.inova.dao.repositories.DocumentUploadedRepository;
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
public class UpdateEmploymentNomineeServiceRequestControllerTestDataLoader {
    @Autowired
    private EmployerPaymentRemittanceDetailRepository employerPaymentRemittanceDetailRepository;
    @Autowired
    DocumentUploadedRepository documentUploadedRepository;
    @Autowired
    TxnCommonDataLoader txnCommonDataLoader;
    @Autowired
    MstDataLoader mstDataLoader;

    public DocumentUploaded insertDocumentUploaded() {
        DocumentUploaded documentUploaded = getExistingDocumentUploaded();
        if (documentUploaded != null) {
            return documentUploaded;
        } else {
            documentUploaded = new DocumentUploaded();
            MstDocumentType mstDocumentType = new MstDocumentType();
            mstDocumentType.setId(1l);
            documentUploaded.setDocumentTypeId(mstDocumentType);
            documentUploaded.setName("Test Document by Pamitha");
            return documentUploadedRepository.save(documentUploaded);
        }
    }
    private DocumentUploaded getExistingDocumentUploaded() {
        List<DocumentUploaded> list = documentUploadedRepository.findAll(PageRequest.of(0, 1)).getContent();
        if(!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
