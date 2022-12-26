package com.authentication.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.authentication.user.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
	
}
