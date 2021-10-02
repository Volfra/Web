package co.edu.poli.mail.services;

import java.io.File;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import co.edu.poli.mail.model.Mail;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;
 
    @Value("${spring.mail.username}")
    private String emailFrom;
    
    public void sendEmail (Mail mail) {
    	
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        
        try {
 
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(emailFrom);
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(mail.getMailContent());
            
            if (mail.getAttachments()!=null)
                for (Object attachment: mail.getAttachments()) {
                	File f = new File(attachment.toString());
                    FileSystemResource file = new FileSystemResource(f);
                    mimeMessageHelper.addAttachment(f.getName(), file);
                }
            	
            mailSender.send(mimeMessageHelper.getMimeMessage());
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
       
    }

}
