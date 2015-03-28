package temp;

public class IronSword extends Weapon{
    public IronSword()
    {
        setMinDamage(10);
        setMaxDamage(20);
        setCost(205);
        setDurability(25);
    }
    
    @Override
    public void depreciate()
    {
    	setDurability(getDurability()-1);
    }
}
