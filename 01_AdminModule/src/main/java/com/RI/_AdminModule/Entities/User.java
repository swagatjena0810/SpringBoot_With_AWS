package com.RI._AdminModule.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Column(name="Password")
	private String userPassword;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;
}
