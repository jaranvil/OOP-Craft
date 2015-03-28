package temp;

public class CopperHelmet extends Armour{
    public CopperHelmet()
    {
        setDefense(1);
    }
    
    public int defend(int opponent)
    {
        if(opponent==1)
            return getDefense();
        else
            return 0;
    }
}
