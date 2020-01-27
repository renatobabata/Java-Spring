package com.renato.spring5tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component
@Qualifier("smtpMailSender")
public class SmtpMailSender implements MailSender {

	private static Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		
		log.info("Sending SMTP mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
		
	}
}
