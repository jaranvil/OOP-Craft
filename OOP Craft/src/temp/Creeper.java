package temp;

import javax.swing.ImageIcon;

public class Creeper extends Opponent{
    
    public Creeper()
    {
        setName("Creeper");
        setHp(160);
        setMaxHp(160);
        setMinLuck(1);
        setMaxLuck(6);
        setMinError(1);
        setMaxError(7);
        setSpeed(2);
        setMinAttack(15);
        setMaxAttack(30);
        setMinDefense(2);
        setMaxDefense(8);
        setReward(200);
        setPicture150x250(new ImageIcon(getClass().getResource("images/creeper150x250.png")));
        
    }
    
    @Override 
    public int attack()
    {
        int attack = rand.nextInt((getMaxAttack() - getMinAttack()) + 1) + getMinAttack();
        attack = attack + rand.nextInt(6);
        
        return attack;
    }
}
