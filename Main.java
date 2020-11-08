import java.util.Vector;
public class Main {
    public static void main(String[] args) {
        String target = "https://yopad.eu/p/JavaProjektTestTermine-365days/export/txt";
        Document document = new Document(target);
        
        System.out.println("Hello World");
        Parser parser = new Parser();
        Vector<Termin> termine = parser.parse("C://Users/jonas/Documents/SM_Java/sample.txt");
        
        System.out.println(termine.elementAt(1).Beschreibung);  
        
    }

}
