package temp;

import javax.swing.ImageIcon;

public class Zombie extends Opponent{
    
    public Zombie()
    {
        setName("Zombie");
        setHp(100);
        setMaxHp(100);
        setMinLuck(0);
        setMaxLuck(5);
        setMinError(0);
        setMaxError(5);
        setSpeed(3);
        setMinAttack(9);
        setMaxAttack(15);
        setMinDefense(1);
        setMaxDefense(4);
        setReward(100);
        setPicture150x250(new ImageIcon(getClass().getResource("images/zombie150x250.png")));
        
    }
    
    @Override 
    public int attack()
    {
        int attack = rand.nextInt((getMaxAttack() - getMinAttack()) + 1) + getMinAttack();
        attack = attack + rand.nextInt(5);
        
        return attack;
    }
}
