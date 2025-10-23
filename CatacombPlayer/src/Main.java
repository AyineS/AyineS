/**Code by Seniya Senanayake
 * Program which allows to create player objects and deal randomly generated damage to each other
 */
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Player player1 = new Player("Superman", 15);
        Player player2 = new Player("Batman", 10);

        System.out.println(player1 + " " + player2);

        // while loop which keeps going while both players are alive (health > 0)
        while (player1.getHealth() > 0 && player2.getHealth() > 0) 
        {
            player1.dealDamage(player2);

            if (player2.getHealth() == 0) // if player 2 is dead exit the while loop
            {
                break;
            }

            player2.dealDamage(player1);
            System.out.println(player1 + " " + player2);
        }

        // if else loop to determine the winner
        if (player1.getHealth() > 0) 
        {
            System.out.println("Winner is " + player1);
        } 
        else 
        {
            System.out.println("Winner is " + player2);
        }
    }
}
