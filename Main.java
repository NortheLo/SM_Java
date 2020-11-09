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
    static MainSceneController ControllerHandle;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        loader.setController(new MainSceneController());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ControllerHandle = (MainSceneController) loader.getController();
        primaryStage.show();
        run();
    }

    public void run()
    {
        String target = "https://yopad.eu/p/JavaProjektTestTermine-365days/export/txt";
        File file = new File("C://Users/jonas/Documents/SM_Java/sample.txt");

        Document document = new Document(); 
        System.out.println("Hello World");
        Parser parser = new Parser();
        System.out.println("test");
        Vector<Termin> termine = parser.parse(document.getDocument(target)); 
        System.out.println(termine.elementAt(0).Beschreibung);  
        for(int i = 0;i < termine.size();++i){
            ControllerHandle.listView1.getItems().add(termine.elementAt(i).Datum);
        }
        
    }

}


