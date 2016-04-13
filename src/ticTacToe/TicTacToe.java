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
	static char whichPlayer;
	static Scanner input = new Scanner(System.in);

	public static char[][] addToken(char[][] board, int[] position, char player) {
		// Enter the appropriate token for each player's input.

		board[position[1]][position[0]] = player;
		return gameBoard;
	}

	public static void declareWinner() {
		// Determines outcome of game and declares winner unless there is no
		// winner, in which case it declares a tie.

		if (gameVictor == 'T') {
			System.out.println("It's a tie!");
		} else {
			System.out.println("Player " + gameVictor + " wins.");
		}
	}

	public static void switchPlayer() {
		// Determines which player's turn it is and switches to other player's
		// turn.

		if (whichPlayer == 'O') {
			whichPlayer = 'X';
		} else if (whichPlayer == 'X') {
			whichPlayer = 'O';
		}
	}

	public static int[] getPosition(char player, char[][] board) {
		// Takes user input string describing play position and parses it into
		// an int array. All user validation and exception handling included in
		// method.

		while (true) {

			try {

				System.out.print("Player " + player + ", enter a position on the board (x,y): ");
				userPosition = input.nextLine();
				splitPosition = userPosition.split(",");

				if (splitPosition.length > 2) {
					System.out.println("Please only enter TWO positions in format (x,y).");
					continue;
				}

				for (int i = 0; i < 2; i++) {
					parsedPosition[i] = Integer.parseInt(splitPosition[i]);
					parsedPosition[i]--;
				}

				if (board[parsedPosition[1]][parsedPosition[0]] != ' ') {
					System.out.println("You cannot play over another player's position.");
					continue;
				}

				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Each axis position can only be 1-3.");
			} catch (Exception e) {
				System.out.println("Please enter position in format (x,y).");
			}
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
			gameVictor = 'T';
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
	

	public static void clearBoard() {
		// Clears game board for new game.

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = ' ';
			}
		}
	}

	public static void main(String[] args) {

		String userConsent = "n";

		do {

			whichPlayer = 'O';
			clearBoard();

			do {
				printBoard(gameBoard);

				switchPlayer();

				parsedPosition = getPosition(whichPlayer, gameBoard);
				gameBoard = addToken(gameBoard, parsedPosition, whichPlayer);
				turnCounter++;
				gameEnd(gameBoard);

			} while (!gameOver);

			turnCounter = 0; // Reset turn counter in case user(s) decide to
								// play a new game
			gameOver = false; // Reset gameOver condition for the same reason

			declareWinner();

			System.out.println("Play again? (y/n): ");
			userConsent = input.nextLine();

		} while (userConsent.equalsIgnoreCase("y"));
		input.close();
	}

}