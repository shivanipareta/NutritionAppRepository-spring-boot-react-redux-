package com.yash.nutritionapp.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.nutritionapp.domain.DietPlan;
import com.yash.nutritionapp.exceptions.DietPlanIdException;
import com.yash.nutritionapp.service.DietPlanService;
import com.yash.nutritionapp.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/dietPlan")
@CrossOrigin
public class DietPlanController {
	
	@Autowired
	DietPlanService dietPlanService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		List<DietPlan> dietPlan  = dietPlanService.getAllDietPlan();
		return new ResponseEntity<List<DietPlan>>(dietPlan, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> createNewDietPlan(@Valid @RequestBody DietPlan dietPlan, BindingResult result) throws DietPlanIdException {
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		DietPlan diet=dietPlanService.saveOrUpdate(dietPlan);
		return new ResponseEntity<DietPlan>(diet, HttpStatus.CREATED);
	}

	
	@GetMapping("/{userId}")
	public ResponseEntity<?> findByUserId(@PathVariable String userId) throws DietPlanIdException {
		DietPlan dietPlan = dietPlanService.getDietPlanByUserId(userId);
		return new ResponseEntity<DietPlan>(dietPlan, HttpStatus.OK);
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable String userId) throws DietPlanIdException {
		dietPlanService.deleteDietPlanByUserId(userId);
		return new ResponseEntity<String>(
				"User with " + userId.toUpperCase() + " is successfully deleted", HttpStatus.OK);
	}

}
