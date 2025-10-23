import java.util.Random;

public class Player 
{
    private String name;
    private int health;
    private int maxDamage;

    /**
     * Constructor to create a player object with given name, 100 health & given max damage
     * @param name name set during object creation
     * @param maxDamage maxDamage set during object creation
     */
    public Player(String name, int maxDamage) 
    {
        this.name = name;
        this.health = 100;
        this.maxDamage = maxDamage;
    }

    /**
     * Setter method to set a desired name
     * @param name name of player object
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter method to access the name
     * @return name of the player object
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter method to set a desired health
     * @param health health value of player object
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * Getter method to access the health
     * @return health value of player object
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Setter method to set a desired maxDamage threshold
     * @param maxDamage maxDamage value of player object
     */
    public void setMaxDamage(int maxDamage)
    {
        this.maxDamage = maxDamage;
    }

    /**
     * Getter method to access the maxDamage
     * @return maxDamage value of player object
     */
    public int getMaxDamage()
    {
        return maxDamage;
    }

    /**
     * Method to deal random damage between 0 & maxDamage to the enemy
     * @param enemy other player object who is recieving the damage
     */
    public void dealDamage(Player enemy) 
    {
        Random rng = new Random();
        int damage = rng.nextInt(maxDamage + 1);
        enemy.health = enemy.health - damage;
        if (enemy.health < 0) 
        {
            enemy.health = 0; 
        }
    }

    /**
     * Method to print player name followed by their health
     * @return string containing player name and health
     */
    @Override
    public String toString() 
    {
        return name + ": HP " + health;
    }
}
