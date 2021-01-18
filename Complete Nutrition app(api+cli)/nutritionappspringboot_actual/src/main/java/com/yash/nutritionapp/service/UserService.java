package com.yash.nutritionapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.nutritionapp.domain.User;
import com.yash.nutritionapp.exceptions.UserIDException;
import com.yash.nutritionapp.repository.UserRepository;

/**
 * Service class for user which performs all the service related to user
 * @author Vanshika Chaturvedi
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * saveOrUpdate method used to save and update the user and return user
	 * @param user
	 * @return
	 * @throws UserIDException
	 */
	public User saveOrUpdate (User user) throws UserIDException{
		try {
		user.setUserIdentification(user.getUserIdentification().toUpperCase());
		System.out.println("User ID"+user.getId());
		Long id = user.getId();
		userRepository.save(user);
		User savedUser = userRepository.save(user);
		return savedUser;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new UserIDException("user " + user.getUserIdentification().toUpperCase() + " already exists");
		}
	}
	
	/**
	 * grtAllUsers used to get all the users and returns list of users
	 * @return
	 */
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	/**
	 * getUserByUserIdentification finds user by userIdentification and return user
	 * @param userIdentification
	 * @return
	 * @throws UserIDException
	 */
	public User getUserByUserIdentification(String userIdentification) throws UserIDException {
		User user = userRepository.findByUserIdentification(userIdentification);
		if(user==null)
		{
			throw new UserIDException("user " + user.getUserIdentification().toUpperCase() + " does not exists");
		}
		return user;
	}

	/**
	 * delteUserByUserIdentification deletes user by user identification 
	 * @param userIdentification
	 * @throws UserIDException
	 */
	public void delteUserByUserIdentification(String userIdentification) throws UserIDException {
		User user = userRepository.findByUserIdentification(userIdentification);
		if(user==null)
		{
			throw new UserIDException("user " + user.getUserIdentification().toUpperCase() + " does not exists");
		}
		userRepository.delete(user);
	}
	
}