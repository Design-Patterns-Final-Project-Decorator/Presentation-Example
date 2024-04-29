import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

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

        addAgeButtons();

        addColorButtons();

        addHeraldryButtons();

        characterWindow.getChildren().add(new PlatemailView().render());

        showStats();
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
            characterWindow.getChildren().clear();
            characterWindow.getChildren().add(view.render());
            showStats();
        }
    }

    private void addAgeButtons() {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        Text text = new Text("Add Age");
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        Button newButton = new Button("New");
        newButton.setOnAction(event -> updateDisplay(new ArmorAge(view, "New")));
        Button oldButton = new Button("Old");
        oldButton.setOnAction(event -> updateDisplay(new ArmorAge(view, "Old")));
        Button ancientButton = new Button("Ancient");
        ancientButton.setOnAction(event -> updateDisplay(new ArmorAge(view, "Ancient")));
        hBox.getChildren().addAll(newButton, oldButton, ancientButton);
        vBox.getChildren().addAll(text, hBox);
        equipmentWindow.getChildren().add(vBox);
    }

    private void addColorButtons() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        Text text = new Text("Add Color");
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        Button redButton = new Button("Red");
        redButton.setOnAction(event -> updateDisplay(new ArmorColor(view, "red")));
        Button blueButton = new Button("Blue");
        blueButton.setOnAction(event -> updateDisplay(new ArmorColor(view, "blue")));
        Button greenButton = new Button("Green");
        greenButton.setOnAction(event -> updateDisplay(new ArmorColor(view, "green")));
        hbox.getChildren().addAll(redButton, blueButton, greenButton);
        vbox.getChildren().addAll(text, hbox);
        equipmentWindow.getChildren().add(vbox);
    }

    private void addHeraldryButtons() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        Text text = new Text("Add Heraldry");
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        Button treeButton = new Button("Tree");
        treeButton.setOnAction(event -> updateDisplay(new ArmorHeraldry(view, "tree")));
        Button bridgeButton = new Button("Bridge");
        bridgeButton.setOnAction(event -> updateDisplay(new ArmorHeraldry(view, "bridge")));
        Button bearButton = new Button("Bear");
        bearButton.setOnAction(event -> updateDisplay(new ArmorHeraldry(view, "bear")));
        hbox.getChildren().addAll(treeButton, bridgeButton, bearButton);
        vbox.getChildren().addAll(text, hbox);
        equipmentWindow.getChildren().add(vbox);
    }

    private void showStats() {
        statsWindow.getChildren().clear();
        Text text = new Text("Stats");
        text.setStyle("-fx-fill: white");
        HBox nameHBox = new HBox();
        nameHBox.setSpacing(10);
        Text name = new Text("Name: ");
        name.setStyle("-fx-fill: white");
        Text armorName = new Text(view.getName());
        armorName.setStyle("-fx-fill: white");
        nameHBox.getChildren().addAll(name, armorName);
        HBox defenseHBox = new HBox();
        Text defense = new Text("Defense: ");
        defense.setStyle("-fx-fill: white");
        Text armorDefense = new Text(view.getDefense());
        armorDefense.setStyle("-fx-fill: white");
        defenseHBox.getChildren().addAll(defense, armorDefense);
        statsWindow.getChildren().addAll(text, nameHBox, defenseHBox);
    }
}
