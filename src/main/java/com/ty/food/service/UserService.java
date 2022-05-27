package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;

public class UserService {

	public User saveUser(User user) {
		UserDao userDao=new UserDao();
		
		if(user!=null) {
		return userDao.saveUser(user);
		}
		else
		return null;
	}
	
	public User getUserById(int id) {
		UserDao userDao=new UserDao();
              
		return userDao.getUserById(id);
	}
	
	public boolean deleteUserById(int id) {
		
		UserDao userDao=new UserDao();
	
     	return	userDao.deleteUserById(id);


	}
	
	public List<User> getAllUsers(){
		UserDao userDao=new UserDao();
		
		
		return userDao.getAllUser();
		
		
	}
	
	public void validateUser(String name,String password) {
		UserDao userDao=new UserDao();
            userDao.validateUser(name, password);
	}
}
