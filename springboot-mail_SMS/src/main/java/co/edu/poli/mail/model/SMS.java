package co.edu.poli.mail.model;

public class SMS {
	
	private String phoneNumberTo;
	
	private String body;
	
	public SMS () {
		
	}

	public String getPhoneNumberTo() {
		return phoneNumberTo;
	}

	public void setPhoneNumberTo(String phoneNumberTo) {
		this.phoneNumberTo = phoneNumberTo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
