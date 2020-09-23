package com.inova.etfb.test.data_loaders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.inova.dao.entities.DocumentUploaded;
import com.inova.dao.entities.EnforcementDefaulterEmployer;
import com.inova.dao.entities.EnforcementDefaulterEmployerGenerate;
import com.inova.dao.entities.MstDocumentType;
import com.inova.dao.repositories.DocumentUploadedRepository;
import com.inova.dao.repositories.EnforcementDefaulterEmployerGenerateRepository;
import com.inova.dao.repositories.EnforcementDefaulterEmployerRepository;

@Component
public class ServiceRequestForFollowUpDefaulterControllerTestDataLoader {
	@Autowired
	EnforcementDefaulterEmployerRepository enforcementDefaulterEmployerRepository;
	@Autowired
	EnforcementDefaulterEmployerGenerateRepository enforcementDefaulterEmployerGenerateRepository;
	@Autowired
    DocumentUploadedRepository documentUploadedRepository;
	@Autowired
	TxnCommonDataLoader txnCommonDataLoader;
	@Autowired
	MstDataLoader mstDataLoader;
	
	public EnforcementDefaulterEmployer instertEnforcementDefaulterEmployer() {
		EnforcementDefaulterEmployer enforcementDefaulterEmployer = getExistingEnforcementDefaulterEmployer();
		
		if(enforcementDefaulterEmployer != null) {
			return enforcementDefaulterEmployer;
		}else {
			enforcementDefaulterEmployer = new EnforcementDefaulterEmployer();
			enforcementDefaulterEmployer.setEmployerId(txnCommonDataLoader.insertEmployer());
			enforcementDefaulterEmployer.setEnforcementDefaulterEmployerGenerateId(instertEnforcementDefaulterEmployerGenerate());
			enforcementDefaulterEmployer.setStatusId(mstDataLoader.insertMstEnforcementDefaulterStatus());
			enforcementDefaulterEmployer.setStatusAt(new Date());
			enforcementDefaulterEmployer.setDueAmount(BigDecimal.valueOf(2000));
			enforcementDefaulterEmployer.setCreatedAt(new Date());
			enforcementDefaulterEmployer.setUpdatedAt(new Date());
			
			return enforcementDefaulterEmployerRepository.save(enforcementDefaulterEmployer);
		}
	}
	
	private EnforcementDefaulterEmployer getExistingEnforcementDefaulterEmployer() {
		List<EnforcementDefaulterEmployer> enforcementDefaulterEmployer = enforcementDefaulterEmployerRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!enforcementDefaulterEmployer.isEmpty()) {
			return enforcementDefaulterEmployer.get(0);
		} else {
			return null;
		}
	}
	
	public EnforcementDefaulterEmployerGenerate instertEnforcementDefaulterEmployerGenerate() {
		EnforcementDefaulterEmployerGenerate enforcementDefaulterEmployerGenerate = getExistingEnforcementDefaulterEmployerGenerate();
		
		if(enforcementDefaulterEmployerGenerate != null) {
			return enforcementDefaulterEmployerGenerate;
		}else {
			enforcementDefaulterEmployerGenerate = new EnforcementDefaulterEmployerGenerate();
			enforcementDefaulterEmployerGenerate.setRefNo(1234L);
			enforcementDefaulterEmployerGenerate.setEndYear(2021);
			enforcementDefaulterEmployerGenerate.setEndMonth(11);
			enforcementDefaulterEmployerGenerate.setStartYear(2020);
			enforcementDefaulterEmployerGenerate.setStartMonth(5);
			enforcementDefaulterEmployerGenerate.setSignificantDueAmount(BigDecimal.valueOf(2000));
			enforcementDefaulterEmployerGenerate.setCanceled(false);
			enforcementDefaulterEmployerGenerate.setCreatedAt(new Date());
			enforcementDefaulterEmployerGenerate.setDefaultMonthsPeriod(5);
			enforcementDefaulterEmployerGenerate.setGracePeriod(4);
			
			return enforcementDefaulterEmployerGenerateRepository.save(enforcementDefaulterEmployerGenerate);
		}
	}
	
	private EnforcementDefaulterEmployerGenerate getExistingEnforcementDefaulterEmployerGenerate() {
		List<EnforcementDefaulterEmployerGenerate> enforcementDefaulterEmployerGenerate = enforcementDefaulterEmployerGenerateRepository.findAll(PageRequest.of(0, 1)).getContent();
		if(!enforcementDefaulterEmployerGenerate.isEmpty()) {
			return enforcementDefaulterEmployerGenerate.get(0);
		} else {
			return null;
		}
	}
	
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
