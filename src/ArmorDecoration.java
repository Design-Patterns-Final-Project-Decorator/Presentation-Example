
public abstract class ArmorDecoration implements ArmorView {
    private ArmorView baseArmor;

    public ArmorDecoration(ArmorView baseArmor) {
        this.baseArmor = baseArmor;
    }

    @Override
    public void render() {

    }
}