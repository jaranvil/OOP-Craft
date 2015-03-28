package temp;

public class DiamondSword extends Weapon{
    public DiamondSword()
    {
        setMinDamage(15);
        setMaxDamage(30);
        setCost(505);
        setDurability(50);
    }
    
    @Override
    public void depreciate()
    {
    	setDurability(getDurability()-1);
    }
}
