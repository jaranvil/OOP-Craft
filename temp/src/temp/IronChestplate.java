package temp;

public class IronChestplate extends Armour{
    public IronChestplate()
    {
        setDefense(7);
    }
    
    public int defend(int opponent)
    {
        if(opponent==3)
            return getDefense();
        else
            return 0;
    }
}
