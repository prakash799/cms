/**
Copyright Prakash
All rights reserved
 */
package com.cms.user;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

public interface UserService {

	public User validateUser(String loginid, String password)throws NoSuchAlgorithmException;

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserById(long id);

	public List<User> listAllUsers();
}
