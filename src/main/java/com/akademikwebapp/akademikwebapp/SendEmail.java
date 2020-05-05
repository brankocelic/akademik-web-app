package com.akademikwebapp.akademikwebapp;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	final String myAccountEmail = "caffee.akadameki@gmail.com";
	final String password = "E6pm9zE4";
	
	private String fromEmail;
	private String subject;
	private String userMessage;

	public SendEmail() {
	}

	public void sendMail() throws MessagingException {

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
	
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session, fromEmail, subject, userMessage);

		Transport.send(message);

		System.out.println("Message send succefully!");
	}

	public String getfromEmail() {
		return fromEmail;
	}

	public void setfromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	private static Message prepareMessage(Session session, String fromMail, String subject,
			String usermessage) {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("branko.b.celic@gmail.com"));
			message.setSubject(subject);
			message.setText(fromMail+"\n"+usermessage);
			return message;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
