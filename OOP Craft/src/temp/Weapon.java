package temp;

public abstract class Weapon {
    private int minDamage;
    private int maxDamage;
    private int cost;
    private int durability;
    
    
    
    
    public int getMinDamage() {
        return minDamage;
    }
    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }
    public int getMaxDamage() {
        return maxDamage;
    }
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    
    
    public abstract void depreciate();

}
