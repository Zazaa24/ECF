package com.zaza.ecf.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private SpringTemplateEngine thymeleafTemplateEngine;
	
	public void sendEmailInvitation (String adresseEmail) throws MessagingException {
		Map<String, Object> templateModel = new HashMap<String, Object>();
		
		templateModel.put("recipientName", adresseEmail);
		templateModel.put("senderName", "Arcadia");
		sendMessageUsingThymeleafTemplate(adresseEmail, "Invitation Arcadia", 
				templateModel, "email/utilisateur.html");
	}
	
	public void sendEmailContact (String adresseEmail, String sujet, String message) throws MessagingException {
		Map<String, Object> templateModel = new HashMap<String, Object>();
		
		templateModel.put("recipientName", adresseEmail);
		templateModel.put("subject", sujet);
		templateModel.put("message", message);
		sendMessageUsingThymeleafTemplate("sarpedon26@hotmail.com", "Demande de contact", 
				templateModel, "email/contact.html");
	}

	public void sendSimpleMessage(String to, String subject, String htmlBody) throws MessagingException {
		
		MimeMessage message = emailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	    helper.setFrom("MS_yoftmy@trial-pr9084zxw0mlw63d.mlsender.net");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(htmlBody, true);
		emailSender.send(message);

	}

	public void sendMessageUsingThymeleafTemplate(
	    String to, String subject, Map<String, Object> templateModel, String templatePath)
	        throws MessagingException {
	                
	    Context thymeleafContext = new Context();
	    thymeleafContext.setVariables(templateModel);
	    String htmlBody = thymeleafTemplateEngine.process(templatePath, thymeleafContext);
	    
	    sendSimpleMessage(to, subject, htmlBody);
	}
}
