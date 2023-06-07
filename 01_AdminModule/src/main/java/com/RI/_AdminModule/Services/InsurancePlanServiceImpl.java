package com.RI._AdminModule.Services;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RI._AdminModule.Entities.InsurancePlan;
import com.RI._AdminModule.Exceptions.PlanAlreadyExistsException;
import com.RI._AdminModule.Exceptions.PlanNotFoundException;
import com.RI._AdminModule.Repositories.PlanRepository;
import com.RI._AdminModule.Utils.AppConstants;

@Service
public class InsurancePlanServiceImpl implements IInsurancePlanService {
	
	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public InsurancePlan addInsurancePlan(InsurancePlan insurancePlan) {
		Optional<InsurancePlan> iPlan=this.planRepository.findByPlanName(insurancePlan.getPlanName());
		if(iPlan.isPresent()) {
			throw new PlanAlreadyExistsException(insurancePlan.getPlanName()+AppConstants.planExists);
		}
		else {
//			LocalDate date = null;
//			insurancePlan.setCreatedDate(date.now());
			String loggedInUser=(String)session.getAttribute("emailId");
			insurancePlan.setCreatedBy(loggedInUser);
			return this.planRepository.save(insurancePlan);
		}
	}

	@Override
	public InsurancePlan updateInsurancePlan(InsurancePlan insurancePlan) {
		Optional<InsurancePlan> iPlan=this.planRepository.findByPlanName(insurancePlan.getPlanName());
		if(iPlan.isPresent()) {
//			LocalDate date=null;
//			insurancePlan.setUpdatedDate(date.now());
			String loggedInUser=(String)session.getAttribute("emailId");
			insurancePlan.setUpdatedBy(loggedInUser);;
			return this.planRepository.save(insurancePlan);
		}
		else {
			return addInsurancePlan(insurancePlan);
		}
	}

	@Override
	public InsurancePlan deleteInsurancePlan(Integer planId) {
		Optional<InsurancePlan> iPlan=this.planRepository.findById(planId);
		if(iPlan.isPresent()) {
			planRepository.deleteById(planId);
			return iPlan.get();
		}
		else {
			throw new PlanNotFoundException(AppConstants.planNotFound);
		}
	}

	@Override
	public String deactivateInsurancePlan(String planName) {
		Optional<InsurancePlan> iPlan=this.planRepository.findByPlanName(planName);
		if(iPlan.isPresent()) {
			String loggedInUser=(String)session.getAttribute("emailId");
			InsurancePlan plan=iPlan.get();
			plan.setActive(false);
			plan.setUpdatedBy(loggedInUser);
			planRepository.save(plan);
			return plan.getPlanName()+AppConstants.responseAfterPlanDeactivated;
		}
		else {
			throw new PlanNotFoundException(planName+AppConstants.planNotFound);
		}
		
	}

	
	@Override
	public String activateInsurancePlan(String planName) {
		Optional<InsurancePlan> iPlan=this.planRepository.findByPlanName(planName);
		if(iPlan.isPresent()) {
			String loggedInUser=(String)session.getAttribute("emailId");
			InsurancePlan plan=iPlan.get();
			plan.setActive(true);
			plan.setUpdatedBy(loggedInUser);
			planRepository.save(plan);
			return plan.getPlanName()+AppConstants.responseAfterPlanActivated;
			
		}
		else {
			throw new PlanNotFoundException(planName+AppConstants.planNotFound);
		}
	}

	@Override
	public List<InsurancePlan> viewInsurancePlans() {
		return this.planRepository.findAll();
	}

}
