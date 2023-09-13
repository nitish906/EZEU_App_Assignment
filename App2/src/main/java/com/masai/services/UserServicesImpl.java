package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.repositery.UserDao;

@Service
public class UserServicesImpl  implements UserServices{
	
	@Autowired
	private UserDao dao;

	@Override
	public User saveusUser(User user) {
	 User createdUser= dao.save(user);
		return createdUser;
	}

}
