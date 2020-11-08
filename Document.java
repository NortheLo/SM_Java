import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import java.net.URLConnection;


public class Document{

    public String getDocument(String target){
        //String output = new String();
        char[] output = new char[1000];
        try{
            URL url = new URL(target);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                reader.read(output);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }catch(MalformedURLException s){
            s.printStackTrace();
        }
        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                output += "\n" + line;
                //System.out.println(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        return new String(output);
    }
}