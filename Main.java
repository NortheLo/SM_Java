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
        primaryStage.setTitle("SM Java Projekt");
        primaryStage.show();
        run();
    }

    public void run()
    {
        String target = "https://yopad.eu/p/JavaProjektTestTermine-365days/export/txt";
        Document document = new Document(); 
        System.out.println("Document found!\n");
        Parser parser = new Parser();
        System.out.println("Parsing done!\n");
        Parser.termine = parser.parse(document.getDocument(target)); 
        System.out.println(Parser.termine.elementAt(0).Beschreibung);  
        for(int i = 0;i < Parser.termine.size();++i){
            ControllerHandle.listView1.getItems().add(Parser.termine.elementAt(i).Titel + " -- " + Parser.termine.elementAt(i).Datum);
        }
    }

}


