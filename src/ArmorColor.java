import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ArmorColor implements ArmorView {

    private final ArmorView baseArmor;
    private final String color;

    public ArmorColor(ArmorView baseArmor, String color) {
        this.baseArmor = baseArmor;
        this.color = color;
    }

    @Override
    public Pane render() {
        Pane armorPane = baseArmor.render();
        for(Node node : armorPane.getChildren()) {
            if(node instanceof ImageView) {
                if((((ImageView) node).getImage().getUrl()).contains("armor.png")) {
                    ((ImageView) node).setImage(new Image("images/"+color+"_armor.png"));
                }
            }
        }
        return armorPane;
    }

    @Override
    public String getName() {
        return baseArmor.getName();
    }

    @Override
    public String getDefense() {
        return baseArmor.getDefense();
    }

    @Override
    public ArmorView undo() {
        for(Node node : baseArmor.render().getChildren()) {
            if(node instanceof ImageView) {
                if((((ImageView) node).getImage().getUrl()).contains("images/"+color+"_armor.png")) {
                    ((ImageView) node).setImage(new Image("images/basic_armor.png"));
                }
            }
        }
        return baseArmor;
    }
}