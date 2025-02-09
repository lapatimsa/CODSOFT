import java.util.Scanner;
import java.util.Random;

public class NumberGame {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random rd = new Random();
            int totalRounds = 0;
            int totalAttempts = 0;


            String playAgain = "yes";
            while (playAgain.equalsIgnoreCase("yes")) {

                int generatedNumber = rd.nextInt(100) + 1;
                int attempts = 0;
                boolean guessedCorrectly = false;


                int maxAttempts = 10;

                System.out.println("Welcome to the Number Guessing Game!");
                System.out.println("I have generated a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");


                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    int userGuess = sc.nextInt();
                    attempts++;


                    if (userGuess == generatedNumber) {
                        guessedCorrectly = true;
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    } else if (userGuess < generatedNumber) {
                        System.out.println("Your guess is too low. Try again.");
                    } else {
                        System.out.println("Your guess is too high. Try again.");
                    }
                }


                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
                }


                if (guessedCorrectly) {
                    totalRounds++;
                }
                totalAttempts += attempts;


                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = sc.next();
            }


            System.out.println("\nGame Over! Here are your results:");
            System.out.println("Total rounds won: " + totalRounds);
            System.out.println("Total attempts made: " + totalAttempts);
            System.out.println("Average attempts per round: " + (totalRounds > 0 ? (double) totalAttempts / totalRounds : 0));

            sc.close();
        }


}
