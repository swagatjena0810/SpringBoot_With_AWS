package com.RI._AdminModule.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CASEWORKERS_DATA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CaseWorker_ID")
	private Integer userId;
	
	@Column(name="Full_Name")
	private String fullName;
	
	@Column(name="Email_ID")
	private String emailId;
	
	@Column(name="Mobile_Number")
	private Long mobileNumber;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Date_of)Birth")
	private LocalDate dob;
	
	@Column(name="SSN_NO")
	private String ssnNo;
	
	@Column(name="Active")
	private boolean isActive;
	
	@Column(name="User_Role")
	private String userRole;
	
	@Column(name="Password")
	private String userPassword;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updatedDate;
}
