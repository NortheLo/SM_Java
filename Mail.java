import javax.mail.*;
import java.util.Properties;
import javax.activation.*;
import javax.mail.internet.*;


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



    public void sendMail(String Mailcontent, String Mail_Headline, String AdressFrom, String AdressTo){
        
        Properties properties = System.getProperties();
        properties.setProperty("", host);  //SMTP needs to be filled out
        Session session = Session.getDefaultInstance(properties);

        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AdressFrom));
            message.addRecipient(Message.RecipientType.TO , new InternetAddress(AdressTo));
            message.setSubject(Mail_Headline);
            message.setText(Mailcontent);
            System.out.println("Mail has been sent succesfully!");
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
    
}


