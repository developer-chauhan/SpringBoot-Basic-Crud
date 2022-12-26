package com.authentication.user.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.user.model.UserModel;
import com.authentication.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	//get user by id
	@Override
	public Iterable<UserModel> getAllUser() {
		return userRepo.findAll();
	}

	//get user by id
	@Override
	public Object getUser(Long id) {
		return userRepo.findById(id);
	}
	
	//save user
	@Override
	public void createUser(UserModel user) {
		userRepo.save(user);
	}
	
	//update user
	@Override
	public void updateUser(Long id, UserModel user) {
		userRepo.findById(id)
		.map(uUser->{
			uUser.setEmail(user.getEmail());
			uUser.setName(user.getName());
			return userRepo.save(uUser);
		});
	}
	
	//delete user
	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
