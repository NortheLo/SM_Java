import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MainSceneController {
    
    @FXML
    private Button button1;

    @FXML
    private ListView listView1;

    @FXML
    private void buttonClicked() {
        button1.setText("Click me again!");
        listView1.getItems().add("Item 1");
    }
}