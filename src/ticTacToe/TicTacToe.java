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

	static char[][] gameBoard = new char[3][3];
	static int[] parsedPosition = new int[2];
	static String[] splitPosition;
	static String userPosition;
	static boolean gameOver = false;
	static char gameVictor;

	public static char[][] addOh(char[][] board, int[] position) {

		board[position[0] - 1][position[1] - 1] = 'O';
		return gameBoard;
	}

	public static char[][] addEx(char[][] board, int[] position) {

		board[position[0] - 1][position[1] - 1] = 'X';
		return gameBoard;
	}

	public static int[] parsePosition(String[] position) {

		for (int i = 0; i < 2; i++) {
			parsedPosition[i] = Integer.parseInt(position[i]);
		}

		return parsedPosition;
	}

	public static boolean gameEnd(char[][] board, int counter) {
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
		} else if (counter == 9) {
			gameVictor = 'T';
			gameOver = true;
		}
		return gameOver;
	}

	public static void printBoard(char[][] board) {
		System.out.println("  1   2   3");
		System.out.println("1 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println(" ---|---|---");
		System.out.println("2 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println(" ---|---|---");
		System.out.println("3 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}

	public static char declareWinner(char[][] board) {

		return gameVictor;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean xTurn = true;
		String userConsent = "n";
		int turnCounter = 0;

		do {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					gameBoard[i][j] = ' ';
				}
			}

			do {
				printBoard(gameBoard);

				if (xTurn) {
					System.out.print("Player X, enter a position on the board (x,y): ");
					userPosition = input.nextLine();
					splitPosition = userPosition.split(",");
					parsedPosition = parsePosition(splitPosition);
					gameBoard = addEx(gameBoard, parsedPosition);
					xTurn = false;
				} else {
					System.out.print("Player O, enter a position on the board (x,y): ");
					userPosition = input.nextLine();
					splitPosition = userPosition.split(",");
					parsedPosition = parsePosition(splitPosition);
					gameBoard = addOh(gameBoard, parsedPosition);
					xTurn = true;
				}
				turnCounter++;
				gameEnd(gameBoard, turnCounter);

			} while (!gameOver);

			System.out.print("Game over! ");
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
