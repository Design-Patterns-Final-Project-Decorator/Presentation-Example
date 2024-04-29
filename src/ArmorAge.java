import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ArmorAge implements ArmorView {

    private final ArmorView baseArmor;
    private final String age;

    public ArmorAge(ArmorView baseArmor, String age) {
        this.baseArmor = baseArmor;
        this.age = age;
    }

    @Override
    public Pane render() {
        return baseArmor.render();
    }

    @Override
    public String getName() {
        if (baseArmor.getName().contains("New") || baseArmor.getName().contains("Old") || baseArmor.getName().contains("Ancient")) {
            return age + " Platemail";
        }
        return age + " " + baseArmor.getName();
    }

    @Override
    public String getDefense() {
        return switch (age) {
            case "New" -> "50";
            case "Old" -> "25";
            case "Ancient" -> "75";
            default -> "40";
        };
    }

    @Override
    public ArmorView undo() {
        return baseArmor;
    }
}