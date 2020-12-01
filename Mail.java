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
    private String AdressFrom, AdressTo, host;
    
    public Mail(String newsender, String newreceiver, String newhost){
        AdressFrom = newsender;
        AdressTo = newreceiver;
        host = newhost;
    }

    public String prepareMail(String Mail_ipt){
        String Mailcontent = "Liebe Platzhalter,\nhier ist unsere wöchentliche Mail mit allen Termine und dazugehörigen Informationen ";
        Mailcontent += Mail_ipt;
        return Mailcontent;
    }
    
    public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

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
    
    public static void doIt(){
        
        final String fromEmail = "jo161woe"; //requires valid gmail id
		final String password = "Vodafone1"; // correct password for gmail id
		final String toEmail = "BefreiendLebendigerSeehund@grugrug.ru"; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "asmtp.htwg-konstanz.de"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.starttls.enable", "true");		
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "587"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	    sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

	}
    
}
