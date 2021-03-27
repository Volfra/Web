package co.edu.poli.mail.services;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.mail.model.SMS;

public interface SMSService {
	
	public Message sendSMS(SMS sms);

}