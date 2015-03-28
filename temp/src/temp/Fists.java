package temp;

public class Fists extends Weapon{
    public Fists()
    {
        setMinDamage(0);
        setMaxDamage(5);
        setCost(0);
        setDurability(0);
    }
    
    @Override
    public void depreciate()
    {
    	//fists don't depreciate 
    }
}
