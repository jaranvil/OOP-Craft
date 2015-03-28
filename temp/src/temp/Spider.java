package temp;

import javax.swing.ImageIcon;

public class Spider extends Opponent {
    
    public Spider()
    {
        setName("Spider");
        setHp(60);
        setMaxHp(60);
        setMinLuck(1);
        setMaxLuck(3);
        setMinError(0);
        setMaxError(5);
        setSpeed(4);
        setMinAttack(4);
        setMaxAttack(10);
        setMinDefense(0);
        setMaxDefense(2);
        setReward(50);
        setPicture150x250(new ImageIcon(getClass().getResource("images/spider150x250.png")));
        
    }
    

    @Override 
    public int attack()
    {
        int attack = rand.nextInt((getMaxAttack() - getMinAttack()) + 1) + getMinAttack();
        attack = attack + rand.nextInt(3);
        
        return attack;
    }
}