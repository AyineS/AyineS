import java.util.*;
/**Represents the catacomb(map)
 */
public class Catacomb {
    private int size;
    private ArrayList<Monster> monsters;
    private Random rng;
    
    /**
     * Constructor for Catacomb class
     * @param size size of the catacomb
     */
    public Catacomb(int size) 
    {
        this.size = size;
        monsters = new ArrayList<>();
        rng = new Random();
        generateMonsters();
    }
    /**
     * Getter method to access catacomb's size
     * @return size of the catacomb
     */
    public int getSize() 
    {
        return size;
    }
    /**
     * Method for creating monster objects depending of size of the catacomb and placing them in random rooms
     */
    private void generateMonsters() 
    {
        int totalRooms = size * size;
        int monsterCount = totalRooms / 6; // There should be 1 monster for every 6 rooms

        while (monsters.size() < monsterCount) {
            int x = rng.nextInt(size);
            int y = rng.nextInt(size);
            if (!(x == 0 && y == 0) && !checkMonsterAt(x, y)) // if statement to avoid placing monsters at staring position and already monster inhabited rooms
            { 
                monsters.add(new Monster("Monster " + (monsters.size() + 1), x, y)); // create new monster objects and add them to "monsters" ArrayList
            }
        }
    }
    /**
     * Method to check for monsters in a given room
     * @param x 'X' coordinate of the room
     * @param y 'Y' coordinate of the room
     * @return boolean value of whether a monster is present or not
     */
    private boolean checkMonsterAt(int x, int y) 
    {
        for (Monster monster : monsters) 
        {
            if (monster.getX() == x && monster.getY() == y) 
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Getter method which checks for a monster at a given room and returns it
     * @param x 'X' coordinate of the room
     * @param y 'Y' coordinate of the room
     * @return 'monster' object at the given room
     */
    public Monster getMonsterAt(int x, int y) 
    {
        for (Monster monster : monsters) 
        {
            if (monster.getX() == x && monster.getY() == y && monster.isAlive()) 
            {
                return monster;
            }
        }
        return null;
    }
    /**
     * Method which loops through the ArrayList 'monsters' and removes the dead monsters using a temporary ArrayList 'aliveMonsters'
     */
    public void clearDeadMonsters() 
    {
        ArrayList<Monster> aliveMonsters = new ArrayList<>();
        for (Monster monster : monsters) 
        {
            if (monster.isAlive()) 
            {
                aliveMonsters.add(monster);
            }
        }
        monsters = aliveMonsters;
    }
    /**
     * Method which counts the number
     * @param x 'X' coordinate of the hero
     * @param y 'Y' coordinate of the hero
     * @return number of monsters next to hero's current room
     */
    public int countNearbyMonsters(int x, int y) 
    {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Array containing values for 4 directions around hero's current position
        int count = 0;

        for (int[] dir : directions) 
        {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isWithinMap(newX, newY) && getMonsterAt(newX, newY) != null) 
            {
                count++;
            }
        }
        return count;
    }
    /**
     * Method which prints an updated map of the catacomb before each turn
     * @param hero hero object created for the current game
     */
    public void showMap(Hero hero) 
    {
        System.out.println("Catacomb Map:");
        for (int i = 0; i < size; i++) 
        {
            for (int j = 0; j < size; j++) 
            {
                if (i == hero.getX() && j == hero.getY()) 
                {
                    System.out.print("H "); // Symbol for hero
                } 
                else if (getMonsterAt(i, j) != null) 
                {
                    System.out.print("M "); // Symbol for monster
                } 
                else 
                {
                    System.out.print(". "); // Symbol for empty room
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Private helper method which checks if a given adjacent room to the hero is within the map
     * @param x 'X' coordinate of the room
     * @param y 'Y' coordinate of the room
     * @return boolean value of whether a given adjacent room to the hero is within the map
     */
    private boolean isWithinMap(int x, int y) 
    {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
