package com.inova.etfb.employer_management.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.util.JsonToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerVerificationBulkErrorCsvDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("EPF No.")
	private String epfNo;

	@JsonProperty("Employer Name")
	private String employerName;

	@JsonProperty("BRN")
	private String brnNo;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("District")
	private String disitrict;

	@JsonProperty("Contact No.")
	private String contactNo;
	
	@Override
	public String toString() {
	    JsonToStringBuilder builder = new JsonToStringBuilder();
	    builder.append("epf_no", epfNo);
	    builder.append("employer_name", employerName);
	    builder.append("brn_no", brnNo);
	    builder.append("address", "\""+address+"\"");
	    builder.append("disitrict", disitrict);
	    builder.append("contact_no", contactNo);    
	    return builder.build();
	}

}
