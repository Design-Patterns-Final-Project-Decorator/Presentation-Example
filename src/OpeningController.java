import javafx.event.ActionEvent;
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

    private ArmorView view;

    public OpeningController() {
        this.view = new PlatemailView();
    }

    @FXML
    public void initialize() {
        // add mystic tree background O_o
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

        // making the buttons
        Button b1 = new Button("Add Armor Age");
        b1.setOnAction(event -> updateDisplay(new ArmorAge(view)));

        Button b2 = new Button("Add Armor Color");
        b2.setOnAction(event -> updateDisplay(new ArmorColor(view)));

        Button b3 = new Button("Add Armor Heraldry");
        b3.setOnAction(event -> updateDisplay(new ArmorHeraldry(view)));

        equipmentWindow.getChildren().addAll(b1, b2, b3);
    }

    @FXML
    private void reset(ActionEvent actionEvent) {
        updateDisplay(new PlatemailView());
    }

    @FXML
    private void undo(ActionEvent actionEvent) {
        updateDisplay(view.undo());
    }

    private void updateDisplay(ArmorView newAV) {
        if (newAV != null) {
            this.view = newAV;
            characterWindow = view.render();
        }
    }
}
