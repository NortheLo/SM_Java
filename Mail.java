import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;


public class Mail{
    private String AdressFrom, AdressTo, host = "localhost";
    
    public Mail(String newsender, String newreceiver){
        AdressFrom = newsender;
        AdressTo = newreceiver;
    }

    public String prepareMail(String Mail_ipt){
        String Mailcontent = "Liebe Platzhalter,\nhier ist unsere wöchentliche Mail mit allen Termine und dazugehörigen Informationen ";
        Mailcontent += Mail_ipt;
        return Mailcontent;
    }



    public void sendMail(String Mailcontent, String Mail_Headline, String AdressFrom, String AdressTo){
        try {

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}


