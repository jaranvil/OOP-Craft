package temp;

public class IronLeggings extends Armour{
    public IronLeggings()
    {
        setDefense(5);
    }
    
    public int defend(int opponent)
    {
        if(opponent==2)
            return getDefense();
        else
            return 0;
    }

}
