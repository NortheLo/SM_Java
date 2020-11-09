import java.util.Vector;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;


public class Main extends Application {
    public static void main(String[] args) {
        
        String target = "https://yopad.eu/p/JavaProjektTestTermine-365days/export/txt";
        File file = new File("C://Users/jonas/Documents/SM_Java/sample.txt");

        Document document = new Document(); 
        System.out.println("Hello World");
        Parser parser = new Parser();
        launch(args);
        Vector<Termin> termine = parser.parse(document.getDocument(target));
        
        System.out.println(termine.elementAt(0).Beschreibung);  
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new MainSceneController());
        URL xmlUrl = getClass().getResource("GUI.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}


