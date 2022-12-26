package com.authentication.user.service;


import com.authentication.user.model.UserModel;

public interface UserService {
	public abstract Iterable<UserModel> getAllUser();
	public abstract void createUser(UserModel user);
	public abstract void updateUser(Long id, UserModel user);
	public abstract void deleteUser(Long id);
	public abstract Object getUser(Long id);
}
