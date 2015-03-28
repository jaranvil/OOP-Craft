package temp;

import java.util.Random;

import javax.swing.Icon;

public abstract class Opponent {
    Random rand = new Random();
    
    private String name="stub";
    private int hp;
    private int maxHp;
    private int minLuck;
    private int maxLuck;
    private int minError;
    private int maxError;
    private int speed;
    private int minAttack;
    private int maxAttack;
    private int minDefense;
    private int maxDefense;
    private int reward;
    private Icon picture150x250;
    
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public int getMinLuck() {
        return minLuck;
    }
    public void setMinLuck(int minLuck) {
        this.minLuck = minLuck;
    }
    public int getMaxLuck() {
        return maxLuck;
    }
    public void setMaxLuck(int maxLuck) {
        this.maxLuck = maxLuck;
    }
    public int getMinError() {
        return minError;
    }
    public void setMinError(int minError) {
        this.minError = minError;
    }
    public int getMaxError() {
        return maxError;
    }
    public void setMaxError(int maxError) {
        this.maxError = maxError;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMinAttack() {
        return minAttack;
    }
    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }
    public int getMaxAttack() {
        return maxAttack;
    }
    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }
    public int getMinDefense() {
        return minDefense;
    }
    public void setMinDefense(int minDefense) {
        this.minDefense = minDefense;
    }
    public int getMaxDefense() {
        return maxDefense;
    }
    public void setMaxDefense(int maxDefense) {
        this.maxDefense = maxDefense;
    }
    public int getReward() {
        return reward;
    }
    public void setReward(int reward) {
        this.reward = reward;
    }
    public Icon getPicture150x250() {
        return picture150x250;
    }
    public void setPicture150x250(Icon picture150x250) {
        this.picture150x250 = picture150x250;
    }


    
    public abstract int attack();

    
    public int defense(int attack)
    {
        int defense = rand.nextInt((maxDefense - minDefense) + 1) + minDefense;
        int result = attack - defense;
        
        if(result<0)
            result=0;
        
        return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
