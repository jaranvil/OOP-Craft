package temp;

import javax.swing.ImageIcon;

public class Flower extends Opponent {
    
    
    public Flower()
    {
        setName("Red Rose");
        setHp(20);
        setMaxHp(20);
        setMinLuck(0);
        setMaxLuck(1);
        setMinError(0);
        setMaxError(1);
        setSpeed(5);
        setMinAttack(0);
        setMaxAttack(5);
        setMinDefense(0);
        setMaxDefense(0);
        setReward(25);
        setPicture150x250(new ImageIcon(getClass().getResource("images/flower150x250.png")));
        
    }
    
    
    @Override 
    public int attack()
    {
        int attack = rand.nextInt((getMaxAttack() - getMinAttack()) + 1) + getMinAttack();
        return attack;
    }

}
