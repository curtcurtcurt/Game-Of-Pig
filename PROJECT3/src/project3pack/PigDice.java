package project3pack;
import java.util.Random;

public class PigDice {
    private int totalScore;   // Total score for the player
    private int roundScore;   // Score for the current round
    private Die die1;         // Die 1
    private Die die2;         // Die 2

    public PigDice() {
        totalScore = 0;
        roundScore = 0;
        die1 = new Die();
        die2 = new Die();
    }

    public int currentTotal() {
        return totalScore;
    }

    public int currentRound() {
        return roundScore;
    }

    public void rollDice() {
        die1.roll();
        die2.roll();
    }

    public void evaluate() {
        int value1 = die1.getFaceValue();
        int value2 = die2.getFaceValue();

        if (doubleOnesRolled(value1, value2)) {
            roundScore = 25; // Double ones score 25
        } else if (singleOneRolled(value1, value2)) {
            roundScore = 0; // Single one resets round score
        } else {
            roundScore += value1 + value2;
        }
    }

    public String lastRoll() {
        return "D1: " + "(" + die1.getFaceValue() + ")" + ", D2: " + "(" + die2.getFaceValue() + ")";
    }

    public boolean piggedOut() {
        int value1 = die1.getFaceValue();
        int value2 = die2.getFaceValue();
        return singleOneRolled(value1, value2);
    }

    public int save() {
        totalScore += roundScore;
        int roundScoreToReturn = roundScore;
        roundScore = 0;
        return roundScoreToReturn;
    }

    private boolean singleOneRolled(int value1, int value2) {
        return value1 == 1 || value2 == 1;
    }

    private boolean doubleOnesRolled(int value1, int value2) {
        return value1 == 1 && value2 == 1;
    }
}
