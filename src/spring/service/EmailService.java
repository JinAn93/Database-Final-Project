package spring.service;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import spring.model.Post;


public class EmailService {
	public boolean sendFollowingUserNotificationEmail(Post post, List<String> emails) throws URISyntaxException, SQLException, ClassNotFoundException {
		final String username = "help.recruit.db316@gmail.com";
		final String password = "DB316Rocks!";
		
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
			String to = String.join(" , ",emails);
			InternetAddress[] parse = InternetAddress.parse(to, true);
			message.setRecipients(Message.RecipientType.TO, parse);
			message.setSubject("[Notification] New Post By " + post.getUser_name());
			StringBuilder emailBody =  new StringBuilder();
			String newline = System.getProperty("line.separator"); 
			emailBody.append("Welcome to Recruit Monster!" + newline
					+ "New post has been created by " + post.getUser_name() + "."
					+ newline + "Click the following link:" + "<a href=http://localhost:8080/Database-Final-Project/view-" + post.getPost_id() + "-post>New Post</a>");
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(emailBody.toString(), "UTF-8", "html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Mail ID not valid");
			return false;
		}
	}
	
	public boolean sendFollowingCompanyNotificationEmail(Post post, List<String> emails) throws URISyntaxException, SQLException, ClassNotFoundException {
		final String username = "help.recruit.db316@gmail.com";
		final String password = "DB316Rocks!";
		
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
			String to = String.join(" , ",emails);
			InternetAddress[] parse = InternetAddress.parse(to, true);
			message.setRecipients(Message.RecipientType.TO, parse);
			message.setSubject("[Notification] New Post About " + post.getCompany_name());
			StringBuilder emailBody =  new StringBuilder();
			String newline = System.getProperty("line.separator"); 
			emailBody.append("Welcome to Recruit Monster!" + newline
					+ "New post has been created about " + post.getCompany_name() + "."
					+ newline + "Click the following link:" + "<a href=http://localhost:8080/Database-Final-Project/view-" + post.getPost_id() + "-post>New Post</a>");
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(emailBody.toString(), "UTF-8", "html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Mail ID not valid");
			return false;
		}
	}
	
	public static void main(String[] args) {
		EmailService e = new EmailService();
		Post post = new Post();
		post.setCompany_name("Linkedin");
		post.setContent("Great");
		post.setInterview_position("Software Engineer Intern");
		post.setInterview_result("Great");
		post.setInterview_season("Winter");
		post.setInterview_year(2016);
		post.setPost_id(100);
		post.setUser_name("ryanchung93");
		for(int i=0; i<5; i++) {
			
		
		List<String> emails = new ArrayList<String>();
		emails.add("seungjinan93@gmail.com");
		try {
			e.sendFollowingCompanyNotificationEmail(post, emails);
			System.out.println("Test Email - Success!");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
}
