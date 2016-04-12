/**
 * 
 */
package ticTacToe;

import java.util.Scanner;

/**
 * @author Alex Marks
 *
 */
public class TicTacToe {

	static char[][] gameBoard = new char[3][3]; // array holding each player's
												// played positions
	static int[] parsedPosition = new int[2];
	static String[] splitPosition;
	static String userPosition;
	static boolean gameOver = false;
	static char gameVictor;
	static int turnCounter = 0;

	public static char[][] addOh(char[][] board, int[] position) {
		// Adds an O to the input position and returns the game board inputs.
		board[position[0] - 1][position[1] - 1] = 'O';
		return gameBoard;
	}

	public static char[][] addEx(char[][] board, int[] position) {
// Adds an X to the input position and returns the game board inputs.
		board[position[0] - 1][position[1] - 1] = 'X';
		return gameBoard;
	}

	public static int[] parsePosition(String position) {
// Takes user input string describing play position and parses it into an int array.
		splitPosition = position.split(",");
		for (int i = 0; i < 2; i++) {
			parsedPosition[i] = Integer.parseInt(splitPosition[i]);
		}

		return parsedPosition;
	}

	public static boolean gameEnd(char[][] board) {
		// Checks for various game ending conditions.
		if (board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
			gameVictor = board[0][0];
			gameOver = true;
		} else if (board[1][0] != ' ' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
			gameVictor = board[1][0];
			gameOver = true;
		} else if (board[2][0] != ' ' && board[2][0] == board[2][1] && board[2][1] == board[0][2]) {
			gameVictor = board[2][0];
			gameOver = true;
		} else if (board[0][0] != ' ' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
			gameVictor = board[0][0];
			gameOver = true;
		} else if (board[0][1] != ' ' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
			gameVictor = board[0][1];
			gameOver = true;
		} else if (board[0][2] != ' ' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
			gameVictor = board[0][2];
			gameOver = true;
		} else if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			gameVictor = board[0][0];
			gameOver = true;
		} else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			gameVictor = board[0][2];
			gameOver = true;
		} else if (turnCounter == 9) {
			gameVictor = 'T'; // Kinda janky tie switch.
			gameOver = true;
		}
		return gameOver;
	}

	public static void printBoard(char[][] board) {
		// Prints the game board.
		System.out.println("  1   2   3");
		System.out.println("1 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println(" ---|---|---");
		System.out.println("2 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println(" ---|---|---");
		System.out.println("3 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean xTurn = true;  // Kinda janky player switch.  When true, it's X's turn, when false it's O's.
		String userConsent = "n";

		do {
			for (int i = 0; i < 3; i++) {  //Clears game board.  Use method?
				for (int j = 0; j < 3; j++) {
					gameBoard[i][j] = ' ';
				}
			}

			do {
				printBoard(gameBoard);

				if (xTurn) {  //implementation of kinda janky player switch.
					System.out.print("Player X, enter a position on the board (x,y): ");
					userPosition = input.nextLine();
					parsedPosition = parsePosition(userPosition);
					gameBoard = addEx(gameBoard, parsedPosition);
					xTurn = false;
				} else {
					System.out.print("Player O, enter a position on the board (x,y): ");
					userPosition = input.nextLine();
					parsedPosition = parsePosition(userPosition);
					gameBoard = addOh(gameBoard, parsedPosition);
					xTurn = true;
				}
				turnCounter++;
				gameEnd(gameBoard);

			} while (!gameOver);

			System.out.print("Game over! ");
			turnCounter = 0;
			gameOver = false;

			if (gameVictor == 'T') {
				System.out.println("It's a tie!");
			} else {
				System.out.println("Player " + gameVictor + " wins.");
			}

			System.out.println("Play again? (y/n): ");
			userConsent = input.nextLine();
		} while (userConsent.equalsIgnoreCase("y"));
		input.close();
	}
}