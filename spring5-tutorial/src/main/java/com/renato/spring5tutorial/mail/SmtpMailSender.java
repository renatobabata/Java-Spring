package com.renato.spring5tutorial.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component
@Qualifier("smtpMailSender")
public class SmtpMailSender implements MailSender {

	private static Log log = LogFactory.getLog(MockMailSender.class);
	
	private JavaMailSender javaMailSender;
	
	public SmtpMailSender(JavaMailSender javaMailSender) {
		
		this.javaMailSender = javaMailSender;
		
	}
	
	@Override
	public void send(String to, String subject, String body) throws MessagingException {
	
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message,true); 
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true);
		
		javaMailSender.send(message);
		
		/*
		log.info("Sending SMTP mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
		*/
						
	}
}
