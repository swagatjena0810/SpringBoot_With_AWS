package com.RI._AdminModule.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RI._AdminModule.Entities.InsurancePlan;

@Repository
public interface PlanRepository extends JpaRepository<InsurancePlan,Integer> {
	
	Optional<InsurancePlan> findByPlanName(String planName);
}
