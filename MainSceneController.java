import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainSceneController {
    
    @FXML
    private Button addbutton;

    @FXML
    private Button removebutton;

    @FXML
    private Button sendbutton;


    @FXML
    public ListView listView1;

    @FXML
    private TextField inputfield;

    @FXML
    private void addClicked() {
        //addbutton.setText("Click me again!");
        listView1.getItems().add("Item 1");
    }
    @FXML
    private void sendClicked(){
        sendbutton.setText("Mail has been sent!");
        Mail.doIt();
        //call method to send mail
    }
    @FXML
    private void removeClicked(){
        listView1.getItems().remove("Item 1");
    }
    @FXML
    private String getField(){
        String newdate = inputfield.getText();
        return newdate;
        //<TextField fx:id="inputfield" layoutX="700.0" layoutY="125.0" mnemonicParsing="false" onAction="#getField" text="Enter the name of the new entry"/>

    }
}