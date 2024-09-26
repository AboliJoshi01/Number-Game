import java.util.Random;
import java.util.Scanner;
public class numberGame {
    public static void main(String[] args) {
        Scanner game = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalScore = 0;
        System.out.println("Let's play Number Guessing Game!");
        while (playAgain) {
            totalRounds++; //First Round
            int attemptsLeft = 5; // Limit to 5 attempts
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            boolean hasWon = false;
            System.out.println("Round " + totalRounds + ": Try to guess the number between 1 and 100!");
            while (attemptsLeft > 0) {
                System.out.println("You have " + attemptsLeft + " attempts remaining. Enter your guess: ");
                int userGuess = game.nextInt();
                attemptsLeft--;
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasWon = true;
                    totalScore += attemptsLeft + 1; // Higher score for fewer attempts
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }
            if (!hasWon) {
                System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber);
            }
            System.out.println("Do you want to play another round? (yes/no)");
            String userResponse = game.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Game Over! You played " + totalRounds + " rounds.");
        System.out.println("Your total score is: " + totalScore);
        System.out.println("Thanks for playing!");
        game.close();
    }
}

