import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.regex.*;

public class Controller {

    @FXML
    private TextArea Textarea;

    @FXML
    private Label results;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem copy;

    @FXML
    private MenuItem delete;

    @FXML
    private Menu edit;

    @FXML
    private Menu file;

    @FXML
    private Menu help;

    @FXML
    private MenuItem open;

    @FXML
    private MenuItem save;

    @FXML
    private MenuItem validation;

    public void openfile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(Textarea.getScene().getWindow());
        BufferedReader br = new BufferedReader(new FileReader(selectedFile));
        String st;
        while ((st = br.readLine()) != null)
            Textarea.appendText(st + "\n");

    }

    public void close() {
        Textarea.clear();
    }

    public void save() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File savedFile = fileChooser.showSaveDialog(Textarea.getScene().getWindow());
        Files.writeString(savedFile.toPath(), Textarea.getText());

    };

    public void copy() {
        StringSelection stringSelection = new StringSelection(Textarea.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        
    }
    public void email_validation(){
        StringBuilder sb = new StringBuilder();
        for(var x:Textarea.getText().split("[\n ]"))
            if(x.matches("(([a-zA-Z]([-._]?[a-zA-Z0-9])*)@([a-zA-Z]([-._]?[a-zA-Z0-9])*))")) sb.append(x).append("\n");
        results.setText(sb.toString().isEmpty()?"no email found":sb.toString());
        

        


   

            


    }
}
