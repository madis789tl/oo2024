

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate a random number of iterations (e.g., between 1 and 10)
        int iterations = random.nextInt(4) + 1; // Random number between 1 and 10
        System.out.println("Number of iterations: " + iterations);

        for (int i = 0; i < iterations; i++) {
            // Generate a random integer within a specific range (1 to 3)
            int randomIntRange = random.nextInt(6) + 1; // This generates a random number between 1 and 3

            // Check the value and print a specific message if it's 1 or 2
            if (randomIntRange == 1) {
                System.out.println("Tehnoloogia rike");
            } else if (randomIntRange == 2) {
                System.out.println("Meeskonna konflikt");
            } else if (randomIntRange == 3) {
                System.out.println("Turu muutus");
            } else if (randomIntRange == 4) {
                System.out.println("Regulatiivne uuendus");
            } else if (randomIntRange == 5){
                System.out.println("Huvipoolte muutus");
            } else {
                System.out.println("Eelarve ületamine");
            }
        }
    }
}