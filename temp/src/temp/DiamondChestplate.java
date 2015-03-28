package temp;

public class DiamondChestplate extends Armour{
    public DiamondChestplate()
    {
        setDefense(12);
    }
    
    public int defend(int opponent)
    {
        if(opponent==3)
            return getDefense();
        else
            return 0;
    }
}
