import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;
import java.util.regex.Pattern;

public class Parser {
    final String key_Beschreibung = "Beschreibung";
    final String key_Datum = "Datum";
    final String key_Uhrzeit = "Uhrzeit";
    final String key_Titel = "Titel";
    static Vector<Termin> termine = new Vector<Termin>();

    private Vector<Integer> findAll(String pattern, String data) {
        Vector<Integer> result = new Vector<Integer>();
        int index = 0;
        while (index != -1) {
            index = data.indexOf(pattern, ++index);
            
            if (index == -1) {
                break;
            } else {
                result.add(index);
            }
        }
        return result;
    }

    public Vector<Termin> parse(String text) {
        Vector<Termin> termine = new Vector<Termin>();
        try {
            Vector<Integer> startLines = new Vector<Integer>();
            Vector<Integer> endLines = new Vector<Integer>();
            Vector<Integer> Beschreibung = new Vector<Integer>();
            Vector<Integer> Datum = new Vector<Integer>();
            Vector<Integer> Uhrzeit = new Vector<Integer>();
            Vector<Integer> Titel = new Vector<Integer>();

            text = text.replaceAll("(?s)/\\*([^*]|[\\r\\n]|(\\*([^/]|[\\r\\n])))*\\*/",""); //remove comments

            startLines = findAll("{", text);
            endLines = findAll("}", text);
            Beschreibung = findAll(key_Beschreibung, text);
            Datum = findAll(key_Datum, text);
            Uhrzeit = findAll(key_Uhrzeit, text);
            Titel = findAll(key_Titel, text);
            
            for (int i = 0; i < startLines.size(); ++i) {
                Termin termin = new Termin();
                if (Beschreibung.size() > i && startLines.elementAt(i) < Beschreibung.elementAt(i) && Beschreibung.elementAt(i) < endLines.elementAt(i)) {
                    termin.Beschreibung = text.substring(Beschreibung.elementAt(i)+key_Beschreibung.length()+1,text.indexOf("}", Beschreibung.elementAt(i))).trim();
                }
                if (Datum.size() > i && startLines.elementAt(i) < Datum.elementAt(i) && Datum.elementAt(i) < endLines.elementAt(i)) {
                    termin.Datum = text.substring(Datum.elementAt(i)+key_Datum.length()+1, text.indexOf("\n", Datum.elementAt(i))).trim();
                }
                if (Uhrzeit.size() > i && startLines.elementAt(i) < Uhrzeit.elementAt(i) && Uhrzeit.elementAt(i) < endLines.elementAt(i)) {
                    termin.Uhrzeit = text.substring(Uhrzeit.elementAt(i)+key_Uhrzeit.length()+1, text.indexOf("\n", Uhrzeit.elementAt(i))).trim();
                }
                if (Titel.size() > i && startLines.elementAt(i) < Titel.elementAt(i) && Titel.elementAt(i) < endLines.elementAt(i)) {
                    termin.Titel = text.substring(Titel.elementAt(i)+key_Titel.length()+1, text.indexOf("\n", Titel.elementAt(i))).trim();
                }
                termine.add(termin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return termine;
    }

    public Vector<Termin> parse(File file) {
        String text = new String();
        try {
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];

        fis.read(bytes);
        fis.close();
        text = new String(bytes, "UTF-8");
        
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        return parse(text);
    }
        
    
}