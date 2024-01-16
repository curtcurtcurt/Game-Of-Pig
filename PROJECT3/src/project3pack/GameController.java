package project3pack;

import java.util.Scanner;

public class GameController {
    private Scanner scanner;
    private PigDice player1;
    private PigDice player2;
    private int goalScore;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
        player1 = new PigDice();
        player2 = new PigDice();
    }

    public void play() {
        // Gets the goal score
        System.out.print("Enter the goal score (1-100): ");
        goalScore = scanner.nextInt();
        scanner.nextLine();  

        while (player1.currentTotal() < goalScore && player2.currentTotal() < goalScore) {
            System.out.println("Player 1's turn:");
            takeTurn(player1);

            if (player1.currentTotal() >= goalScore) {
                break; // Player 1 reached the goal score
            }

            System.out.println("Player 2's turn:");
            takeTurn(player2);
        }

        // Determine the winner code:)
        if (player1.currentTotal() >= goalScore && player2.currentTotal() >= goalScore) {
            System.out.println("It's a tie!");
        } else if (player1.currentTotal() >= goalScore) {
            System.out.println("Player 1 wins with a score of " + player1.currentTotal());
        } else {
            System.out.println("Player 2 wins with a score of " + player2.currentTotal());
        }
    }

    private void takeTurn(PigDice player) {
        boolean continueTurn = true;

        while (continueTurn) {
            player.rollDice();
            System.out.println("Last roll: " + player.lastRoll());
            if (player.piggedOut()) {
                System.out.println("Pigged out! Round score reset to 0.");
                player.save(); 
                break;
            }

            System.out.print("Do you want to continue (y/n)? ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (!choice.equals("y")) {
                continueTurn = false;
            } else {
                player.evaluate();
                System.out.println("Round score: " + player.currentRound());
            }
        }

        int roundScore = player.save();
        System.out.println("Total score: " + player.currentTotal());
        System.out.println("Round score saved: " + roundScore);
    }
}
