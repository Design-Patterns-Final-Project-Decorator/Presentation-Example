import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //create an FXMLLoader object so you can get/set your controller objects
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OpeningPage.fxml"));
        Parent mainWindow = loader.load();
        stage.setScene(new Scene(mainWindow));
        stage.show();
    }
}