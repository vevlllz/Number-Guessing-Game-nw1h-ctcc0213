import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;

        int userGuess;
        int attempts = 0;
        boolean gameEnded = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've chosen a number between 1 and 100. Can you guess it?");

        while (!gameEnded) {
            System.out.print("Enter your guess (or -1 to quit): ");

            if (inputScanner.hasNextInt()) {
                userGuess = inputScanner.nextInt();

                if (userGuess == -1) {
                    gameEnded = true;
                    System.out.println("Thanks for playing. The correct number was " + targetNumber + ".");
                } else if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else {
                    attempts++;
                    evaluateGuess(userGuess, targetNumber, attempts);
                    gameEnded = userGuess == targetNumber;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                inputScanner.next();
            }
        }

        inputScanner.close();
    }

    private static void evaluateGuess(int userGuess, int targetNumber, int attempts) {
        if (userGuess < targetNumber) {
            System.out.println("Too low! Try again.");
        } else if (userGuess > targetNumber) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Congratulations! You found the correct number in " + attempts + " attempts.");
        }
    }
}