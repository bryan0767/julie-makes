package com.example.Julie.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Julie.repository.LoginRepository;

import com.example.Julie.model.User;
import java.lang.Math.*;
import java.lang.Character.*;

@RestController
public class LoginController {

  @Autowired
  LoginRepository loginRepository;

	@PostMapping("/login")
	@ResponseBody
	public Boolean login(@RequestBody User user) {
    User isUser = loginRepository.validate( user.getUsername(), hashFunction( user.getPassword() ) );

    if( isUser != null ) {
      return true;
    } else {
      return false;
    }

	 }

  // @PostMapping("/newUser")
 	// @ResponseBody
 	// public User newUser(@RequestBody User user) {
  //    user.setPassword( hashFunction(user.getPassword()) );
  //    return loginRepository.save(user);
 	//  }

   public String hashFunction(String key) {
       int hash = 0;
       String newString = "";

       for (int i = 0; i < key.length(); i++) {
           hash = (hash<<5) - hash;
           hash = key.charAt(i);
           hash = hash & hash;
           newString = newString + Integer.toString(hash);
       }

       return newString;
   }
}
