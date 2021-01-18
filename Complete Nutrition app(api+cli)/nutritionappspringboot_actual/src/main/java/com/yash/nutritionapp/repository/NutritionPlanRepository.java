package com.yash.nutritionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.nutritionapp.domain.NutritionPlan;

@Repository
public interface NutritionPlanRepository extends CrudRepository<NutritionPlan, Long>{
	
	NutritionPlan findById(long id);

}
