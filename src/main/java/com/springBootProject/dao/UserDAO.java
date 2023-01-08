package com.springBootProject.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Repository;

import com.springBootProject.entity.User;
 

 
@Repository
public class UserDAO {
    private static List<User>users=new ArrayList<User>();
   static {
       users.add(new User("admin","admin@wipro.com"));
       users.add(new User("Scott","scott@wipro.com"));
 
   }
   public User findUser(User user) {
       User userFound=null;

    for(User userItr:users){
           if(userItr.getUserName().equals(user.getUserName())){
           userFound=userItr;
           break;
           }
       }
       return userFound; 
     }

   public List<User> saveUser(User user) {
         users.add(user);
         return users;
        }

}

