/**
Copyright Prakash
All rights reserved
 */
package com.cms.user;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

public interface UserDao {

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserById(long id);

	public User validateUser(String loginid);

	public List<User> listAllUsers();
}
