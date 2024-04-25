import javafx.fxml.FXML;
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

    private ArmorView view;

    public OpeningController() {
        // constructor needs
        view = new PlatemailView();
    }

    private void updateDisplay() {
        view.render();
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
