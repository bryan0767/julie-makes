package com.example.Julie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import com.example.Julie.model.Mail;

@RestController
public class MailController {

	@PostMapping("/sendMessage")
	@ResponseBody
	public static void sendMessage(@RequestParam("contact_name") String contact_name,
																 @RequestParam("contact_email") String contact_email,
																 @RequestParam("contact_phone") String contact_phone,
															   @RequestParam("contact_message") String contact_message,
														 	   @RequestParam("contact_other") String contact_other) {
	   //from,password,to,subject,message
		// System.out.println(contact_name + contact_email + contact_phone + contact_message + contact_other);
		Mail.send("bryanatencia224@gmail.com",
							  "Julie1@34",
							  "bryan.atencia@thetiebar.com",
							  "Message from " + contact_name,
							  "Email: " + contact_email + " Phone Number: " + contact_phone + " Message: " + contact_message + " PS: " + contact_other);
	  //change from, password and to
	 }
}
