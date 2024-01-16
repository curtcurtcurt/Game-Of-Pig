package project3pack;

import java.util.Random;

import java.util.Random;

public class Die {
    private int faceValue;
    private Random random;

    public Die() {
        random = new Random();
        roll(); // Roll the die when it's created to initialize the face value.
    }

    public void roll() {
        faceValue = random.nextInt(6) + 1; // Generates a random number between 1 and 6.
    }

    public int getFaceValue() {
        return faceValue;
    }
}
