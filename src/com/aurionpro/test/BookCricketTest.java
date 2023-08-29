package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

public class BookCricketTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter 1 to start or 0 to exit:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            int totalPages = 300;

            System.out.println("Enter Player 1 Name:");
            String player1Name = scanner.next();
            System.out.println("Enter Player 2 Name:");
            String player2Name = scanner.next();

            int player1Score = playInnings(player1Name, random, totalPages);
            int player2Score = playInnings(player2Name, random, totalPages);

            printResult(player1Name, player1Score, player2Name, player2Score);
        } else if (choice == 0) {
            System.out.println("Exiting the game.");
        } else {
            System.out.println("Invalid input. Exiting the game.");
        }

        scanner.close();
    }

    private static int playInnings(String playerName, Random random, int totalPages) {
        int score = 0;
        int turns = 0;

        System.out.println("Player: " + playerName);
        do {
            System.out.println("Enter 1 to open the book for " + playerName + ":");
            int choice = new Scanner(System.in).nextInt();

            if (choice != 1) {
                break;
            }

            int page = random.nextInt(totalPages) + 1;
            int turnScore = page % 7;
            score += turnScore;
            turns++;

            System.out.println("Page Number: " + page + "   Point: " + turnScore + "   Score: " + score);
        } while (score % 7 != 0);

        System.out.println(playerName + " Total Score: " + score);
        System.out.println(playerName + " Takes " + turns + " Rounds");
        return score;
    }

    private static void printResult(String player1Name, int player1Score, String player2Name, int player2Score) {
        System.out.println(player1Name + " Score: " + player1Score);
        System.out.println(player2Name + " Score: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println(player1Name + " wins!");
        } else if (player2Score > player1Score) {
            System.out.println(player2Name + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
