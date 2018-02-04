/**
Copyright Prakash
All rights reserved
 */
package com.cms.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.orm.hibernate4.HibernateSystemException;
import org.springframework.transaction.CannotCreateTransactionException;

public interface UserDao {

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserById(long id);

	public User validateUser(String loginid)throws CannotCreateTransactionException;

	public List<User> listAllUsers();

}
