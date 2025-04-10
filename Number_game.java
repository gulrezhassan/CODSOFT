import java.util.Random;
import java.util.Scanner;

public class Number_game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int score = 0;
        int round = 1;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + min + " and " + max + ".");
        System.out.println("You have " + maxAttempts + " attempts per round.");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔄 Round " + round + " begins!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("⚠️ Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The correct number was: " + targetNumber);
            }

            System.out.println("🏆 Current score: " + score + " point(s)");

            System.out.print("Do you want to play another round? (y/n): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
                System.out.println("👋 Thanks for playing! Final score: " + score);
            }

            round++;
        }

        scanner.close();
    }
}
