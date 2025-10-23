/**Represents a monster
 */
public class Monster {
    private String name;
    private int health;
    private int x;
    private int y;

    /**
     * Constructor for Monster class
     * @param name name of the monster ("Monster 1, Monster 2, ....")
     * @param x 'X' coordinate of monster
     * @param y 'Y' coordinate of monster
     */
    public Monster(String name, int x, int y) 
    {
        this.name = name;
        health = 25;
        this.x = x;
        this.y = y;
    }
    /**
     * Getter method to access monster's name
     * @return name of the monster
     */
    public String getName() 
    {
        return name;
    }
    /**
     * Getter method to access monster's health
     * @return current health of monster
     */
    public int getHealth() 
    {
        return health;
    }
    /**
     * Method which updates the monster's health after taking damage
     * @param damage damage taken by the monster
     */
    public void dealDamage(int damage) 
    {
        health = health - damage;
    }
    /**
     * Getter method to access monster's X coordinate
     * @return monster's X coordinate
     */
    public int getX() 
    {
        return x;
    }
    /**
     * Getter method to access monster's Y coordinate
     * @return monster's Y coordinate
     */
    public int getY() 
    {
        return y;
    }
    /**
     * Method to check if the monster is still alive
     * @return boolean value of monster's alive status
     */
    public boolean isAlive() 
    {
        return health > 0;
    }
}
