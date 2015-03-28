package temp;

public class IronHelmet extends Armour{
    public IronHelmet()
    {
        setDefense(3);
    }
    
    public int defend(int opponent)
    {
        if(opponent==1)
            return getDefense();
        else
            return 0;
    }

}
