package temp;

public abstract class Armour {
    private int defense=0;

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public abstract int defend(int opponent);
}
