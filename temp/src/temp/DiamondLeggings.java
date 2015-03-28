package temp;

public class DiamondLeggings extends Armour{
    public DiamondLeggings()
    {
        setDefense(10);
    }
    
    public int defend(int opponent)
    {
        if(opponent==2)
            return getDefense();
        else
            return 0;
    }
}
