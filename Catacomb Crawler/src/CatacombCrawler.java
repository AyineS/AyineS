import java.util.*;
/**Reperesents the class containing the crucial game logic
 */
public class CatacombCrawler {
    private Hero hero;
    private Catacomb catacomb;
    private Scanner scnr;
    private Random rng;
    /**
     * Constructor to create a CatacombCrawler game object using given heroName and catacomb size
     * @param heroName name of the hero
     * @param size size of the catacomb
     */
    public CatacombCrawler(String heroName, int size) 
    {
        hero = new Hero(heroName);
        catacomb = new Catacomb(size);
        scnr = new Scanner(System.in);
        rng = new Random();
    }
    /**
     * Private helper method which handles the combat between the hero and a given monster
     * @param monster The monster who will be fighting the hero 
     */
    private void fight(Monster monster) 
    {
            System.out.println(hero.getName() + " at " + hero.getX() + ", " + hero.getY() + " with "+ hero.getHealth() + " health versus " + monster.getName()+ " at " + monster.getX() + ", " + monster.getY() + " with "+ monster.getHealth()+" health");
            while (hero.isAlive() && monster.isAlive()) 
            {
                int heroDamage = rng.nextInt(10) + 1; // Set hero maxDamage 1-10
                int monsterDamage = rng.nextInt(5) + 1; // Set monster maxDamage 1-5

                monster.dealDamage(heroDamage);
                hero.dealDamage(monsterDamage);

                System.out.println("You hit for " + heroDamage + " damage");
                if (monster.isAlive()) 
                {
                    System.out.println("You get hit for " + monsterDamage + " damage");
                }
            }

            if (!monster.isAlive()) 
            {
                System.out.println(monster.getName() + " has been defeated!");
            } 
            else 
            {
                System.out.println("You were defeated by " + monster.getName() + "!");
            }
        catacomb.clearDeadMonsters();
    }
    /**
     * Main while loop which handles the game logic
     */
    public void play() 
    {
        while (hero.isAlive()) // game keeps going until the hero is alive or has escaped the catacomb
        {
            catacomb.showMap(hero);

            if (hero.getX() == catacomb.getSize() - 1 && hero.getY() == catacomb.getSize() - 1) 
            {
                System.out.println("You have escaped the catacomb!");
                break; // exits the loop when hero escapes the catacomb
            }
            System.out.println(hero.getName() + " at " + hero.getX() + ", " + hero.getY() + " with "+ hero.getHealth() + " health" );

            int nearbyMonsters = catacomb.countNearbyMonsters(hero.getX(), hero.getY());
            System.out.println("You smell " + nearbyMonsters + " monsters nearby.");

            System.out.print("Which way do you want to go (north, south, east, west)? ");
            String direction = scnr.nextLine().toLowerCase();

            if (isValidMove(direction)) 
            {
                hero.move(direction);
                hero.dealDamage(2); // One move costs 2 hit points
                if (catacomb.getMonsterAt(hero.getX(), hero.getY()) != null) 
                {
                    fight(catacomb.getMonsterAt(hero.getX(), hero.getY()));
                }
            } 
            else 
            {
                System.out.println("You can't move that way! ");
            }
        }

        if (!hero.isAlive()) // if conditional to avoid printing "You died." after hero escapes the catacomb
        {
            System.out.println("You died.");
        }
    }
    
    /**
     * Method which checks if moving towards a given direction from hero's current position is possible
     * @param direction the direction hero is trying to move in
     * @return boolean value of whether moving in that direction is possible or not
     */
    private boolean isValidMove(String direction) 
    {
        int newX = hero.getX();
        int newY = hero.getY();

        switch (direction) 
        {
            case "north":
                newX--;
                break;
            case "south":
                newX++;
                break;
            case "west":
                newY--;
                break;
            case "east":
                newY++;
                break;
            default:
                return false;
        }

        return newX >= 0 && newX < catacomb.getSize() && newY >= 0 && newY < catacomb.getSize();
    }
}
