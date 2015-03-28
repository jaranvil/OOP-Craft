package temp;

import java.util.Random;

import javax.swing.*;

public abstract class Character {
	//properties
    
    Random rand = new Random();
    
	private String name="";
	private String characterClass = "";
	private int hp = 0;
	private int maxHP = 0;
	private int minSkill=0;
	private int maxSkill=0;
	private int minlaziness=0;
	private int maxlaziness=0;
	private int speed=0;
	private int minDefense=0;
	private int maxDefense=0;
	private int money;
	private Icon picture100x150;
	private Icon picture239x318;
	private Icon picture150x250;
	private boolean defensePotion=false;
	
	private Weapon weapon = (Weapon) new Fists();
	private Armour helmet=null;
	private Armour chestplate=null;
	private Armour leggings=null;
	
	
	//property procedures
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
	public int getMinSkill() {
		return minSkill;
	}
	public void setMinSkill(int minSkill) {
		this.minSkill = minSkill;
	}
	public int getMaxSkill() {
		return maxSkill;
	}
	public void setMaxSkill(int maxSkill) {
		this.maxSkill = maxSkill;
	}
	public int getMinlaziness() {
		return minlaziness;
	}
	public void setMinlaziness(int minlaziness) {
		this.minlaziness = minlaziness;
	}
	public int getMaxlaziness() {
		return maxlaziness;
	}
	public void setMaxlaziness(int maxlaziness) {
		this.maxlaziness = maxlaziness;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
    public String getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    public Icon getPicture100x150() {
        return picture100x150;
    }
    public void setPicture100x150(Icon picture100x150) {
        this.picture100x150 = picture100x150;
    }
    public Icon getPicture239x318() {
        return picture239x318;
    }
    public void setPicture239x318(Icon picture239x318) {
        this.picture239x318 = picture239x318;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Icon getPicture150x250() {
        return picture150x250;
    }
    public void setPicture150x250(Icon picture150x250) {
        this.picture150x250 = picture150x250;
    }
    public Armour getHelmet() {
        return helmet;
    }
    public void setHelmet(Armour helmet) {
        this.helmet = helmet;
    }
    public Armour getChestplate() {
        return chestplate;
    }
    public void setChestplate(Armour chestplate) {
        this.chestplate = chestplate;
    }
    public Armour getLeggings() {
        return leggings;
    }
    public void setLeggings(Armour leggings) {
        this.leggings = leggings;
    }
	public boolean isDefensePotion() {
		return defensePotion;
	}
	public void setDefensePotion(boolean defensePotion) {
		this.defensePotion = defensePotion;
	}

    
    
    
	//equip weapon
	public void equip(int weapon)
	{
		if(weapon==0)
		    this.weapon = (Weapon) new Fists();
		if(weapon==1)
            this.weapon = (Weapon) new WoodenSword();
		if(weapon==2)
            this.weapon = (Weapon) new IronSword();
		if(weapon==3)
            this.weapon = (Weapon) new DiamondSword();
	}
	
	public void equipArmour(int armour, int type)
	{
	    //equip helmets
	    if(armour==0 && type==0)
	        helmet = null;
	    if(armour==1 && type==0)
            helmet = (Armour) new CopperHelmet();
	    if(armour==2 && type==0)
            helmet = (Armour) new IronHelmet();
	    if(armour==3 && type==0)
            helmet = (Armour) new DiamondHelmet();
	        
	  //equip chestplate
        if(armour==0 && type==1)
            chestplate = null;
        if(armour==1 && type==1)
            chestplate = (Armour) new CopperChestplate();
        if(armour==2 && type==1)
            chestplate = (Armour) new IronChestplate();
        if(armour==3 && type==1)
            chestplate = (Armour) new DiamondChestplate();
        
      //equip leggings
        if(armour==0 && type==2)
            leggings = null;
        if(armour==1 && type==2)
            leggings = (Armour) new CopperLeggings();
        if(armour==2 && type==2)
            leggings = (Armour) new IronLeggings();
        if(armour==3 && type==2)
            leggings = (Armour) new DiamondLeggings();
	}

	public int attack()
	{
	    weapon.depreciate();
	    
	    int damage = rand.nextInt((weapon.getMaxDamage() - weapon.getMinDamage()) + 1) + weapon.getMinDamage();
	    int skillBonus = rand.nextInt((maxSkill - minSkill) + 1) + minSkill;
	    return damage+skillBonus;
	}
	
	public abstract int defense(int attack, int opponent);





}
