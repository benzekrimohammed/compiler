import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.*;
import javafx.scene.paint.Color;

public class Main extends Application{

public static void main(String[] args) {
    launch(args);
}
@Override
    public void start(Stage stage)  throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("window.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Compiler");
        stage.show();
    }
}
