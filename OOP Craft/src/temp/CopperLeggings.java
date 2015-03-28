package temp;

public class CopperLeggings extends Armour{
    public CopperLeggings()
    {
        setDefense(2);
    }
    
    public int defend(int opponent)
    {
        if(opponent==2)
            return getDefense();
        else
            return 0;
    }
}
