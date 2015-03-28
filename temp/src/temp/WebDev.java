package temp;

import javax.swing.ImageIcon;

public class WebDev extends Character{
    public WebDev()
    {
        setHp(90);
        setMaxHP(90);
        setMinSkill(1);
        setMaxSkill(3);
        setMinlaziness(0);
        setMaxlaziness(2);
        setSpeed(3);
        setMinDefense(0);
        setMaxDefense(2);
        setPicture100x150( new ImageIcon(getClass().getResource("images/webdev100x150.png")));
        setPicture239x318( new ImageIcon(getClass().getResource("images/webdev239x318.png")));
        setMoney(0);
        setCharacterClass("Web Dev");
        setPicture150x250(new ImageIcon(getClass().getResource("images/webdev150x250.png")));
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
        
        if(opponent == 0)
        	result = result + 3;
        
        if(isDefensePotion())
        	result = result - 10;
        
        if(result<0)
            result=0;
        
        return result;
	}

}
