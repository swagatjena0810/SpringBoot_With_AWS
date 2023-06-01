package com.RI._AdminModule.Services;

import java.util.List;

import com.RI._AdminModule.Entities.InsurancePlan;

public interface IInsurancePlanService {
	
	public InsurancePlan addInsurancePlan(InsurancePlan insurancePlan);
	
	public InsurancePlan updateInsurancePlan(InsurancePlan insurancePlan);
	
	public InsurancePlan deleteInsurancePlan(Integer planId);
	
    public String deactivateInsurancePlan(String planName);
	
	public String activateInsurancePlan(String planName);
	
	public List<InsurancePlan> viewInsurancePlans();
	
}
