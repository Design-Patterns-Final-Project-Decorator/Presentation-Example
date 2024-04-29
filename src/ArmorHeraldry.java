import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ArmorHeraldry implements ArmorView{

    private final ArmorView baseArmor;
    private final String heraldry;

    public ArmorHeraldry(ArmorView baseArmor, String heraldry) {
        this.baseArmor = baseArmor;
        this.heraldry = heraldry;
    }

    @Override
    public Pane render() {
        Pane armorPane = baseArmor.render();
        for(Node node : armorPane.getChildren()){
            if(node instanceof ImageView){
                if((((ImageView) node).getImage().getUrl()).contains("heraldry.png")) {
                    ((ImageView) node).setImage(new Image("images/"+heraldry+"_heraldry.png"));
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
            if(node instanceof ImageView){
                if((((ImageView) node).getImage().getUrl()).contains("images/"+heraldry+"_heraldry.png")) {
                    ((ImageView) node).setImage(new Image("images/basic_heraldry.png"));
                }
            }
        }
        return baseArmor;
    }
}