import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class OpeningController {
    @FXML
    private BorderPane backgroundPane;
    @FXML
    private VBox equipmentWindow;
    @FXML
    private Pane characterWindow;
    @FXML
    private VBox statsWindow;

    public OpeningController() {
        // constructor needs
    }

    @FXML
    public void initialize() {
        backgroundPane.setBackground(new Background(new BackgroundImage(
                new Image("images/boarderBackground.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        true,
                        true,
                        true,
                        true
                ))));
    }
}
