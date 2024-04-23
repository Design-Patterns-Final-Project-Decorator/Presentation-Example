import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int MIN_WIDTH = 600;
    private static final int MIN_HEIGHT = 400;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //create an FXMLLoader object so you can get/set your controller objects
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OpeningPage.fxml"));
        Parent mainWindow = loader.load();
        stage.setScene(new Scene(mainWindow));
        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.show();
    }
}