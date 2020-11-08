import java.util.Vector;
import java.io.File;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        String target = "https://yopad.eu/p/JavaProjektTestTermine-365days/export/txt";
        File file = new File("C://Users/jonas/Documents/SM_Java/sample.txt");

        Document document = new Document(); 
        System.out.println("Hello World");
        Parser parser = new Parser();
        
        Vector<Termin> termine = parser.parse(document.getDocument(target));
        
        System.out.println(termine.elementAt(0).Beschreibung);  
        
    }

}
