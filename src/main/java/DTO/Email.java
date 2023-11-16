package DTO;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private final String from = "thuhoa08102003@gmail.com";
	private	final String pass = "cxdc uoit xais oevc";
	
	public int sendOTP(String to) {	
		int otpvalue = createOTP();
		// properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// tạo Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, pass);
			}
		};
		
		//Phiên làm việc
		Session session = Session.getInstance(props, auth);
		
		//Tạo tin nhắn
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			msg.setSubject("OTP");
			msg.setSentDate(new Date());
			msg.setContent("<h2> MÃ OTP:</h2>"+otpvalue, "text/html;chartset=UTF-8");
			// gửi
			Transport.send(msg);
			System.out.println("Gửi thành công");
			return otpvalue;
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Gửi không thành công");
			return 0;
		}

	}
	public int createOTP() {
		Random rand = new Random();
		int otpvalue = 1 + rand.nextInt(1255650); // otpvalue = [1,1255650]
		return otpvalue;
	}
	public static void main(String args[]) {
		Email email = new Email();
		System.out.println(email.createOTP());
	}
}
