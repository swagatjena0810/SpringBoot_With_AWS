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
@Table(name="Insurance_Plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsurancePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Plan_ID")
	private Integer planId;
	
	@Column(name="Plan_Name")
	private String planName;
	
	@Column(name="Plan_Start_Date")
	private LocalDate planStartDate;
	
	@Column(name="Plan_End_Date")
	private LocalDate planEndDate;
	
	@Column(name="Active")
	private boolean isActive;
	
	@Column(name="Plan_Category")
	private String planCategory;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updatedDate;
	
}
