/**Represents the hero 
*/
public class Hero {
    private String name;
    private int health;
    private int x; 
    private int y;

    /**
     * Constructor for Hero class
     * @param name name of hero
     */
    public Hero(String name) 
    {
        this.name = name;
        health = 100;
        x = 0;
        y = 0;
    }
    /**
     * Getter method to access hero's name
     * @return name of the hero
     */
    public String getName() 
    {
        return name;
    }
    /**
     * Getter method to access hero's health
     * @return current health of hero
     */
    public int getHealth() 
    {
        return health;
    }
    /**
     * Getter method to access hero's current X coordinate
     * @return hero's X coordinate
     */
    public int getX() 
    {
        return x;
    }
    /**
     * Getter method to access hero's current Y coordinate
     * @return hero's Y coordinate
     */
    public int getY() 
    {
        return y;
    }
    /**
     * Method which updates the hero's health after taking damage
     * @param damage damage taken by the hero
     */
    public void dealDamage(int damage) 
    {
        health = health - damage;
    }
    /**
     * Method to move the hero in a given direction using a switch statement
     * @param direction direction to be moved in
     */
    public void move(String direction) 
    {
        switch (direction) 
        {
            case "north":
                x--;
                break;
            case "south":
                x++;
                break;
            case "west":
                y--;
                break;
            case "east":
                y++;
                break;
        }
    }
    /**
     * Method to check if the hero is still alive
     * @return boolean value of hero's alive status
     */
    public boolean isAlive() 
    {
        return health > 0;
    }
}
