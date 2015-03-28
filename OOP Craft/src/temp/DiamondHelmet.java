package temp;

public class DiamondHelmet extends Armour{
    public DiamondHelmet()
    {
        setDefense(5);
    }
    
    public int defend(int opponent)
    {
        if(opponent==1)
            return getDefense();
        else
            return 0;
    }
}
