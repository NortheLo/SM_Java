import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import java.net.URLConnection;


public class GetDocument{
    private String target;
    private String output;

    public GetDocument(String newtarget){
        target = newtarget;
    }

    public String printDocument(){
       //URL url = new URL("");
        try{
            URL url = new URL(target);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                for (String line; (line = reader.readLine()) != null;) {
                    output += "\n" + line;
                    //System.out.println(line);
                }
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
        return output;
    }
}