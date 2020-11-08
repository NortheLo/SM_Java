import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;

public class Parser {

    public Vector<Integer> findAll(String pattern, String data) {
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
            Vector<Integer> startComment = new Vector<Integer>();
            Vector<Integer> endComment = new Vector<Integer>();
            Vector<Integer> Beschreibung = new Vector<Integer>();
            Vector<Integer> Datum = new Vector<Integer>();
            Vector<Integer> Uhrzeit = new Vector<Integer>();

            startLines = findAll("{", text);
            endLines = findAll("}", text);
            // startComment = findAll("/*", text);
            // endComment = findAll("*/", text);
            Beschreibung = findAll("Beschreibung", text);
            Datum = findAll("Datum", text);
            Uhrzeit = findAll("Uhrzeit", text);
            // text.replaceAll("\\/\\*[\\s\\S]*?\\*\\/|(['\"])[\\s\\S]+?\\1(*SKIP)(*FAIL)|\\/{2}.*",
            // "");
            for (int i = 0; i < startLines.size(); ++i) {
                Termin termin = new Termin();
                int x = Beschreibung.size();
                if (Beschreibung.size() > i && startLines.elementAt(i) < Beschreibung.elementAt(i) && Beschreibung.elementAt(i) < endLines.elementAt(i)) {
                    termin.Beschreibung = text.substring(Beschreibung.elementAt(i),text.indexOf("\n", Beschreibung.elementAt(i)));
                }
                if (Datum.size() > i && startLines.elementAt(i) < Datum.elementAt(i) && Datum.elementAt(i) < endLines.elementAt(i)) {
                    termin.Datum = text.substring(Datum.elementAt(i), text.indexOf("\n", Datum.elementAt(i)));
                }
                if (Uhrzeit.size() > i && startLines.elementAt(i) < Uhrzeit.elementAt(i) && Uhrzeit.elementAt(i) < endLines.elementAt(i)) {
                    termin.Uhrzeit = text.substring(Uhrzeit.elementAt(i), text.indexOf("\n", Uhrzeit.elementAt(i)));
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