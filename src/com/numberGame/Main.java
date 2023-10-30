package com.numberGame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Random randomNo = new Random();
    
    public static void main(String[] args) {
        int rounds = 1,totalPoints = 0;
        
        System.out.println("Number Guessing Game! ~ By Oasis Infobyte");
        
        while (rounds <= 3) {
            System.out.println("________________________________________________________________________________________________________________________________________________________");
            System.out.println("\nRound " + rounds );
            int random = randomGenerate(1, 100); 
            int points = playGame(random);
            
            if (points > 0) {
                System.out.println("Congratulations! You guessed the number in " + points + " attempts.");
                totalPoints += 5;
            } else {
                System.out.println("You ran out of attempts. The number was " + random);
            }
            
            rounds++;
        }
        
        System.err.println("\nGame Over!");
        if (totalPoints > 0) {
            System.out.println("Your total score is: " + totalPoints + " points");
        } else {
        	System.err.println("You Lose!");
            System.out.println("You did not score any points in this game.");
        }
    }

    private static int randomGenerate(int min, int max) {
        return randomNo.nextInt(max - min + 1) + min;
    }

    private static int playGame(int actualNumber) {
        int attempts = 5;
        
        System.out.println("Guess the number between 1 and 100.");
        
        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": ");
            int guess = sc.nextInt();
            
            if (guess < 1 || guess > 100) {
                System.err.println("Invalid guess! Please enter a number between 1 and 100");
                continue;
            }
            
            if (guess == actualNumber) {
                return i; 
            } else if (guess < actualNumber) {
                System.out.println("The number is higher.");
                if(guess>actualNumber-10) {
                	System.err.println("You were close!");
                }
                if(guess>actualNumber-3) {
                	System.err.println("You almost reached!");
                }
            } else {
                System.out.println("The number is lower.");
                if(guess<actualNumber+10) {
                	System.err.println("You were close!");
                }
                if(guess<actualNumber+3) {
                	System.err.println("You almost reached!");
                }
            }
        }
        
        return 0;
    }
}
