
public class Character {
    
    //properties
    private String name = "";
    private int hp = 0;
    private int agility = 0;
    private int intel = 0;
    private int clumsiness = 0;
    private int speed = 0;
    
    public Character(String name, int hp, int agility, int intel, int clumsiness, int speed)
    {
        this.name = name;
        this.hp = hp;
        this.agility = agility;
        this.intel = intel;
        this.clumsiness = clumsiness;
        this.speed = speed;
    }
}
