package temp;

import javax.swing.ImageIcon;

public class DBADev extends Character{
    public DBADev()
    {
        setHp(100);
        setMaxHP(100);
        setMinSkill(2);
        setMaxSkill(3);
        setMinlaziness(0);
        setMaxlaziness(3);
        setSpeed(2);
        setMinDefense(0);
        setMaxDefense(5);
        setPicture100x150( new ImageIcon(getClass().getResource("images/dba100x150.png")));
        setPicture239x318( new ImageIcon(getClass().getResource("images/dba238x318.png")));
        setMoney(0);
        setCharacterClass("DBA");
        setPicture150x250(new ImageIcon(getClass().getResource("images/dba150x250.png")));
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
        
        if(opponent == 3)
        	result = result + 3;
        
        if(isDefensePotion())
        	result = result - 10;
        
        if(result<0)
            result=0;
        
        return result;
	}
}
