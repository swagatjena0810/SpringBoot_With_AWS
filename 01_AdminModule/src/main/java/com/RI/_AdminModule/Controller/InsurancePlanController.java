package com.RI._AdminModule.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RI._AdminModule.Entities.InsurancePlan;
import com.RI._AdminModule.Services.IInsurancePlanService;
import com.RI._AdminModule.Utils.AppConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/insuranceplan")
public class InsurancePlanController {
	
	@Autowired
	private IInsurancePlanService planService;
	
	
	@PostMapping("/addplan")
	public ResponseEntity<InsurancePlan> addInsurancePlan(
			@RequestBody InsurancePlan plan ){
		
		if(plan!=null) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(planService.addInsurancePlan(plan));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@PutMapping("/updateplan")
	public ResponseEntity<InsurancePlan> updateInsurancePlan(
			@RequestBody InsurancePlan plan ){
		
		if(plan!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(planService.updateInsurancePlan(plan));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@DeleteMapping("/deleteplan/{planId}")
	public ResponseEntity<InsurancePlan> deleteInsurancePlan(
			@PathVariable("planId") Integer planId){
		
		if(planId!=null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(planService.deleteInsurancePlan(planId));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@PostMapping("/activate/{planName}")
	public ResponseEntity<String> activateInsurancePlan(
			@PathVariable("planName") String planName){
		if(planName!=null) {
			planService.activateInsurancePlan(planName);
			return ResponseEntity.ok(AppConstants.responseAfterPlanActivated);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@PostMapping("/deactivate/{planName}")
	public ResponseEntity<String> deactivateInsurancePlan(
			@PathVariable("planName") String planName){
		if(planName!=null) {
			planService.deactivateInsurancePlan(planName);
			return ResponseEntity.ok(AppConstants.responseAfterPlanDeactivated);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@GetMapping("/viewPlanList")
	public ResponseEntity<List<InsurancePlan>> viewAllInsurancePlans(){
		return ResponseEntity.ok(planService.viewInsurancePlans());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
