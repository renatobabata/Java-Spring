package com.renato.spring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renato.spring5tutorial.mail.MailSender;

@RestController
public class MailController {
	
	private MailSender mailSender;

	// @Autowired is used to search for info into Application Context
	@Autowired
	public MailController(@Qualifier("smtpMailSender") MailSender smtp) {
		// smtp is bean name
		this.mailSender = smtp;
	}
	
	@RequestMapping("/mail")
	public String mail() {
		
		mailSender.send("mail@example.com","A test mail","Body of the test mail");

		return "Mail sent";
		
	}
	
	
}
