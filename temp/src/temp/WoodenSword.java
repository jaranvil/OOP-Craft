package temp;

public class WoodenSword extends Weapon{
    public WoodenSword()
    {
        setMinDamage(3);
        setMaxDamage(10);
        setCost(55);
        setDurability(15);
    }
    
    @Override
    public void depreciate()
    {
    	setDurability(getDurability()-1);
    }
}
