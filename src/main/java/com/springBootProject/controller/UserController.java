package com.springBootProject.controller;

import java.util.List; 
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springBootProject.entity.User;
import com.springBootProject.services.UserService; 
  

@Controller
public class UserController {
    private static final String Login_View="login";
    private static final String New_User_View="newuser";
    private static final String User_View="user"; 
    private static final String Users_list_View="userslist"; 

    @Autowired
    private UserService service;
    
    @RequestMapping("/")
    public String sayHello() {
        System.out.println("Reaching this point");
        return Login_View;
    }

    @RequestMapping(value="/user",method=RequestMethod.POST)
    public String user(@Validated User user,Model model) {
        System.out.println("User Name:"+user.getUserName());

        User findUser = service.findUser(user);
        if(findUser==null) {
            return New_User_View ;
        }
        else {
            model.addAttribute("user", findUser);
        return User_View;
          }    
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@Validated User user,Model model) {
        System.out.println("user name :"+user.getUserName());
        System.out.println("user Email :"+user.getUserEmail());

        List<User>usersList=service.saveUser(user);
        model.addAttribute("usersList", usersList);
        return Users_list_View; 
  
    } 
  
}