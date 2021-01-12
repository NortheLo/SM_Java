import javax.mail.*;

import java.sql.Date;
import java.util.Properties;
import javax.activation.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail{
    
    public Mail(){

    }
	public void sendEmail( String toEmail, String subject, String body)
	{
		final String fromEmail = "botboot1@web.de"; 
		final String password = "botboot1";
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.web.de");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("botboot1@web.de", "BotBoot"));
	      msg.setReplyTo(InternetAddress.parse("botboot1@web.de", false));
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8");
	      msg.setSentDate(new Date(System.currentTimeMillis()));
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
    }
}
