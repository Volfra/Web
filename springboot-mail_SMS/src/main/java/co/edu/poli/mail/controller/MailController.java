package co.edu.poli.mail.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.mail.model.Mail;
import co.edu.poli.mail.services.MailService;
 
@RestController
public class MailController {
 
	@Autowired
	private MailService notificationService;
	
	@RequestMapping("/api/v1/msg")
	public String sendEmail(@RequestBody Mail mail){
		notificationService.sendEmail(mail);
		return "Email sent successfully";
	}
	
}