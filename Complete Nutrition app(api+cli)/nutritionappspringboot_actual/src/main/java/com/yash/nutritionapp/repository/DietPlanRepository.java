package com.yash.nutritionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.nutritionapp.domain.DietPlan;

@Repository
public interface DietPlanRepository extends CrudRepository<DietPlan, Long> {
	DietPlan findByUserId(String userId);
}
