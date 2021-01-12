import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainSceneController {
    final String header = "Sehr geehrte empfänger dieser Email,\n folgende Termine im überblick:\n\n";

    @FXML
    private Button sendbutton;
    @FXML
    private Button addButton;
    @FXML
    private TextField field_title;
    @FXML
    private TextField field_time;
    @FXML
    private TextField field_date;
    @FXML
    private TextField field_description;
    @FXML
    public ListView listView1;

    @FXML
    private void addEntry() {
        Termin termin = new Termin();
        termin.Beschreibung = field_description.getText();
        termin.Datum = field_date.getText();
        termin.Titel = field_title.getText();
        termin.Uhrzeit = field_time.getText();
        Parser.termine.add(termin);
        listView1.getItems().add(termin.Titel + " -- " + termin.Datum);
    }

    @FXML
    private void sendClicked() {
        String mailContent = header;

        for (int i = 0; i < Parser.termine.size(); ++i) {
            mailContent += "\n\n\n";
            if (Parser.termine.elementAt(i).Titel != null) {
                mailContent += "Titel: " + Parser.termine.elementAt(i).Titel;
                mailContent += "\n";
            }
            if (Parser.termine.elementAt(i).Datum != null) {
                mailContent += "Datum: " + Parser.termine.elementAt(i).Datum;
                mailContent += "\n";
            }
            if (Parser.termine.elementAt(i).Uhrzeit != null) {
                mailContent += "Uhrzeit: " + Parser.termine.elementAt(i).Uhrzeit;
                mailContent += "\n";
            }
            if (Parser.termine.elementAt(i).Beschreibung != null) {
                mailContent += "Beschreibung: " + Parser.termine.elementAt(i).Beschreibung;
            }
        }

        mailContent += "\n\nMfg,\ndas BotBoot";
        System.out.println(mailContent);
        sendbutton.setText("Mail has been sent!");
        Mail mail = new Mail();
        mail.sendEmail("jonas.woerner@online.de", "test", mailContent);
    }
}