package com.inova.etfb.employer_management.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inova.util.JsonToStringBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerMemberAccountBulkItems implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp="^[A-Z]+$|^$",message="NIC Type Value Containing Wrong Format")
	@JsonProperty("NIC Type")
	private String nicType;

	@Pattern(regexp="(^[a-zA-Z0-9]+$)|^$",message="NIC No. Value Containing Wrong Format")
	@Size(min = 10,max = 12, message = "NIC No. Maximum Allowed Length is 12 Characters Minimum 10 Characters")
	@JsonProperty("NIC No.")
	private String nicNo;

	@Pattern(regexp="(^[a-zA-Z0-9]+$)|^$",message="Passport No. Value Containing Wrong Format")
	@Size(max = 15, message = "Passport No. Maximum Allowed Length is 15 Characters")
	@JsonProperty("Passport No.")
	private String passportNo;

	@Pattern(regexp="(^([a-zA-Z])+$|^$)",message="Title Value Containing Wrong Format")
    @NotEmpty(message = "Title cannot be null or Empty")
	@JsonProperty("title")
	private String title;

	@Pattern(regexp="(^([a-zA-Z])+$|^$)",message="First Name Value Containing Wrong Format")
	@Size(max = 50, message = "First Name Maximum Allowed Length is 50 Characters")
    @NotEmpty(message = "First Name cannot be null or Empty")
	@JsonProperty("First Name")
	private String firstName;

	@Pattern(regexp="(^([a-zA-Z])+$|^$)",message="Last Name Value Containing Wrong Format")
	@Size(max = 50, message = "Last Name Maximum Allowed Length is 50 Characters")
    @NotEmpty(message = "Last Name cannot be null or Empty")
	@JsonProperty("Last Name")
	private String lastName;
	
	@Pattern(regexp="^([a-zA-Z])([a-zA-Z ])*[a-zA-Z]+$",message="Full Name Value Containing Wrong Format")
	@NotEmpty(message = "Full Name cannot be null or Empty")
	@JsonProperty("Full Name")
	private String fullName;
	
	@Pattern(regexp="^([a-zA-Z]).([a-zA-Z]).*[a-zA-Z]+$",message="Name with Initials Value Containing Wrong Format")
	@Size(max = 100, message = "Name with Initials Maximum Allowed Length is 100 Characters")
	@NotEmpty(message = "Name with Initials cannot be null or Empty")
	@JsonProperty("Name with Initials")
	private String nameWithInitials;
	
	@Pattern(regexp="^(Male|Female)$",message="Gender Value Containing Wrong Format")
	@NotEmpty(message = "Gender cannot be null or Empty")
	@JsonProperty("Gender")
	private String gender;
	
	@Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message="Date of Birth Value Containing Wrong Format")
	@NotEmpty(message = "Dath of Birth cannot be null or Empty")
	@JsonProperty("Date of Birth")
	private String dateOfBirth;
	
	@Pattern(regexp="(^([0-9])+$|^$)",message="Member Number Value Containing Wrong Format")
	@NotEmpty(message = "Member No cannot be null or Empty")
	@Size(max = 10, message = "Member No. Maximum Allowed Length is 10 Characters")
	@Max(value = Integer.MAX_VALUE, message = "Member No. Maximum Allowed value should not be greater than "+Integer.MAX_VALUE)
	@JsonProperty("Member No.")
	private String memberNo;
	
	@Pattern(regexp="^\\d{1,12}\\.\\d{0,2}$",message="Salary Applicable Value Containing Wrong Format")
	@Size(max = 15, message = "Salary Applicable for ETFB (Rs.) Maximum Allowed Length is 15 Characters")
	@JsonProperty("Salary Applicable for ETFB (Rs.)")
	private String salaryEtfb;

	@Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message="Date Joined Value Containing Wrong Format")
	@JsonProperty("Date Joined")
	private String dateJoined;
	
	@Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",message="Date of Termnation Value Containing Wrong Format")
	@JsonProperty("Date of Termination")
	private String dateTerminated;
	
	//@Pattern(regexp="^([a-zA-Z])([a-zA-Z ])*[a-zA-Z]+$",message="Designation Value Containing Wrong Format")
	@Size(max = 20, message = "Designation Maximum Allowed Length is 20 Characters")
	@JsonProperty("Designation")
	private String designation;

	
	@Override
	public String toString() {
	    JsonToStringBuilder builder = new JsonToStringBuilder();
	    builder.append("nic_type", nicType);
	    builder.append("nic_no", nicNo);
	    builder.append("passport_no", passportNo);
	    builder.append("title", title);
	    builder.append("first_name", firstName);
	    builder.append("last_name", lastName);    
	    builder.append("full_name", fullName);
	    builder.append("name_with_initials", nameWithInitials);
	    builder.append("gender", gender);     
	    builder.append("date_of_birth", dateOfBirth);
	    builder.append("member_no", memberNo);  
	    builder.append("salary_applicable", salaryEtfb);
	    builder.append("date_joined", dateJoined);     
	    builder.append("date_of_termination", dateTerminated);
	    builder.append("designation", designation);  
	    return builder.build();
	}

}
