/**
Copyright Prakash
All rights reserved
*/
package com.cms.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cms.user.User;
import com.cms.user.UserDao;
import com.cms.user.UserDaoImpl;
 
@ContextConfiguration(locations = "classpath:spring-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDAO 
{
     
    @Autowired
    private UserDao userDao;
     
     
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void testGetUserById()
    {
    	
    	User user = new User();
    	user.setEmail("test@gmail.com");
    	user.setId(4);
    	user.setLoginid("888");
    	user.setName("test");
    	user.setPassword("test");
    	user.setPhone("9898989898");
    	
        userDao = new UserDaoImpl();
        userDao.getUserById(999);
         
        Assert.assertEquals(1, user.getLoginid());
    }
     
     
}
