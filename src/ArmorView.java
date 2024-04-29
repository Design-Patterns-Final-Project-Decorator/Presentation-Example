import javafx.scene.layout.Pane;

public interface ArmorView {
    public Pane render();
    public String getName();
    public String getDefense();
    public ArmorView undo();
}
