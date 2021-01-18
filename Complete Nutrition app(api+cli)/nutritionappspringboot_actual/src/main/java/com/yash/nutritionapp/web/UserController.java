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

import com.yash.nutritionapp.domain.User;
import com.yash.nutritionapp.exceptions.UserIDException;
import com.yash.nutritionapp.service.MapValidationErrorService;
import com.yash.nutritionapp.service.UserService;




/**
 * UseController handles requests for crud performing through url
 * @author Vanshika Chaturvedi
 *
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;


	/**
	 * find all the users 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<User> user = userService.getAllUsers();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	/**
	 * create new user
	 * @param user
	 * @param result
	 * @return
	 * @throws UserIDException
	 */
	@PostMapping("/users")
	public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) throws UserIDException{
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		User savedUser = userService.saveOrUpdate(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	/**
	 * get user by userIdentification 
	 * @param userIdentification
	 * @return
	 * @throws UserIDException
	 */
	@GetMapping("/{userIdentification}")
	public ResponseEntity<?> findByUserIdentification(@PathVariable String userIdentification) throws UserIDException {
		User user = userService.getUserByUserIdentification(userIdentification);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * delete user by user identification 
	 * @param userIdentification
	 * @return
	 * @throws UserIDException
	 */
	@DeleteMapping("/{userIdentification}")
	public ResponseEntity<?> deleteById(@PathVariable String userIdentification) throws UserIDException {
		userService.delteUserByUserIdentification(userIdentification);
		return new ResponseEntity<String>(
				"user with userIdentification" + userIdentification.toUpperCase() + " is successfully deleted", HttpStatus.OK);
	}
}
