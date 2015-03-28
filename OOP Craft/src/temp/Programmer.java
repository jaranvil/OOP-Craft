package temp;

import javax.swing.ImageIcon;

public class Programmer extends Character{
	
    public Programmer()
    {
        setMaxHP(150);
        setHp(150);
        setMinSkill(2);
        setMaxSkill(7);
        setMinlaziness(0);
        setMaxlaziness(5);
        setSpeed(4);
        setMinDefense(0);
        setMaxDefense(5);
        setPicture100x150( new ImageIcon(getClass().getResource("images/programmer100x150.png")));
        setPicture239x318( new ImageIcon(getClass().getResource("images/programmer239x318.png")));
        setMoney(0);
        setCharacterClass("Programmer");
        setPicture150x250(new ImageIcon(getClass().getResource("images/programmer150x250.png")));
    }
    
    @Override
	public int defense(int attack, int opponent)
	{
	    int defense = rand.nextInt((getMaxDefense() - getMinDefense()) + 1) + getMinDefense();
	    int laziness = rand.nextInt((getMaxlaziness() - getMinlaziness()) + 1) + getMinlaziness();
         
        int armour=0;
        if(!(getHelmet()==null))
        {
            armour = armour + getHelmet().defend(opponent);
        }
        if(!(getChestplate()==null))
        {
            armour = armour + getChestplate().defend(opponent);
        }
        if(!(getLeggings()==null))
        {
            armour = armour + getLeggings().defend(opponent);
        }

        int result = attack - defense + laziness - armour;
        
        if(opponent == 2)
        	result = result + 3;
        
        if(isDefensePotion())
        	result = result - 10;
        
        if(result<0)
            result=0;
        
        return result;
	}
    
}
