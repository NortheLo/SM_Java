import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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
    private void addClicked() {
        //addbutton.setText("Click me again!");
        listView1.getItems().add("Item 1");
    }
    @FXML
    private void sendClicked(){
        sendbutton.setText("Mail has been sent!");
        //call method to send mail
    }
    @FXML
    private void removeClicked(){
        listView1.getItems().remove("Item 1");
    }
}