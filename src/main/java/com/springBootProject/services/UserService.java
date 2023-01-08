package com.springBootProject.services;


import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootProject.dao.UserDAO;
import com.springBootProject.entity.User; 
  
@Service
public class UserService {

    @Autowired
    UserDAO dao;
    public User findUser(User user) {
        return dao.findUser(user);

    }
    public List<User> saveUser(User user) {
        return dao.saveUser(user);

    }
}

