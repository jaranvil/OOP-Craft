package temp;

public class CopperChestplate extends Armour{
    public CopperChestplate()
    {
        setDefense(3);
    }
    
    public int defend(int opponent)
    {
        if(opponent==3)
            return getDefense();
        else
            return 0;
    }
}
