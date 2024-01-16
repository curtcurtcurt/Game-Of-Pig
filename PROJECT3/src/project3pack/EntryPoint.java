/* Curtis Johnson
 * project3pack
 * Project 3
 * These classes of code come together to play a classic game of pig, hope it gets a good grade Dr. Mahmud :)
 * 
 */



package project3pack;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController(scanner);

        char playAgain;
        do {
            gameController.play();

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase().charAt(0);
        } while (playAgain == 'y');

        scanner.close();
    }
}
