package spring.service;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import spring.model.User;


public class EmailService {
	public boolean sendVerificationEmail(User user) throws URISyntaxException, SQLException, ClassNotFoundException {
		final String username = "help.recruit.db316@gmail.com";
		final String password = "DB316Rocks!";
		
		if(user == null) {
			System.out.println("No User to Verify");
			return false;
		}
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(user.getEmail()));
			message.setSubject("[ACTION REQUIRED] Verify Yourself via Email");
			
			String newline = System.getProperty("line.separator"); 
			
			StringBuilder emailBody =  new StringBuilder();
			
			emailBody.append("Welcome to Recruit Monster!");
					
			message.setText(emailBody.toString());
			Transport.send(message);
			System.out.println("Done");
			return true;
		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			System.out.println("Mail ID not valid");
			return false;
		}
	}
}
