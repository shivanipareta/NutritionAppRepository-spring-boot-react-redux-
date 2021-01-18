package com.yash.nutritionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.nutritionapp.domain.User;

/**
 * Repository class for user which extends crudRepository and performs crud operations
 * @author Vanshika Chaturvedi
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserIdentification(String userIdentification);

}
