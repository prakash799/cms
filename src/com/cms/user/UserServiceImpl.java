/**
Copyright Prakash
All rights reserved
*/
package com.cms.user;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.cms.security.EncryptPassword;

@Service
@Qualifier("userservice")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userdao")
	UserDao userDao;
	
	@Autowired
	@Qualifier("encryptpassword")
	EncryptPassword encrypt;
	
	public void setEncrypt(EncryptPassword encrypt) {
		this.encrypt = encrypt;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public User getUserById(long id) {
		User userById = userDao.getUserById(id);
		return userById;
	}
	

	@Override
	public User validateUser(String loginid, String password) throws NoSuchAlgorithmException,NumberFormatException {
		String validatedPassword = validatePassword(password);
		User validUser = getUserById(Long.valueOf(loginid));
		System.out.println("Password------------>"+validUser);
		if (validUser != null && validUser.getPassword() != null) {
			if(validatedPassword.equals(validUser.getPassword())) {
				return validUser;
			}
		}
		return null;
	}


	@Override
	public List<User> listAllUsers() {
		List<User> allUsers = userDao.listAllUsers();
		return allUsers;
	}
	
	
	public String validatePassword(String password) throws NoSuchAlgorithmException {
		String generateHashCode = encrypt.generateHashCode(password.trim());
		return generateHashCode;
	}
	
}
