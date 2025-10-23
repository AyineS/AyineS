/**Code by Seniya Senanayake
 * Additional feature "showMap" has been implemented which prints out the catacomb and its entities before each turn
 */
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        
        int size;
        Scanner scnr = new Scanner(System.in);

        System.out.print("What is your name, heroic adventurer? ");
        String heroName = scnr.nextLine();

        System.out.print("How wide of a catacomb do you want to face (5-10)? ");
        
        while (true) {
            size = scnr.nextInt();
            if (size >= 5 && size <= 10) 
            {
                break;
            }
            System.out.println("That is not a valid catacomb size! ");
            System.out.print("How wide of a catacomb do you want to face (5-10)? ");
        }

        CatacombCrawler game = new CatacombCrawler(heroName, size);
        game.play();
    }
}
