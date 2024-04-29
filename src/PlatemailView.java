import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class PlatemailView implements ArmorView{

    private final Pane armorPane;

    public PlatemailView() {
        ImageView armorImage = new ImageView(new Image("images/basic_armor.png"));
        armorImage.setPreserveRatio(true);
        armorImage.setFitHeight(76);
        armorImage.setFitWidth(76);
        armorImage.setLayoutX(100);
        armorImage.setLayoutY(100);
        ImageView heraldryImage = new ImageView(new Image("images/basic_heraldry.png"));
        heraldryImage.setPreserveRatio(true);
        heraldryImage.setFitHeight(20);
        heraldryImage.setFitWidth(20);
        heraldryImage.setLayoutX(125);
        heraldryImage.setLayoutY(130);
        this.armorPane = new StackPane(armorImage, heraldryImage);
        this.armorPane.setLayoutX(100);
        this.armorPane.setLayoutY(100);
    }

    @Override
    public Pane render() {
        return armorPane;
    }

    @Override
    public String getName() {
        return "Platemail";
    }

    @Override
    public String getDefense() {
        return "40";
    }

    @Override
    public ArmorView undo() {
        return this;
    }
}