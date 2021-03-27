package co.edu.poli.mail.services;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.mail.model.SMS;

@Service
public class SMSServiceTwilio implements SMSService{
	
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACf860fd39e3378551c64cca96740f216d";
    public static final String AUTH_TOKEN = "54b55f1763c81905bbc03d57df4c2978";

    @Override
    public Message sendSMS(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(sms.getPhoneNumberTo()),
                new com.twilio.type.PhoneNumber("+14159917390"),//The Twilio phone number
                sms.getBody())
           .create();

        return message;
    }
    
}

