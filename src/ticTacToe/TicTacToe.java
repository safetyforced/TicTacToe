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

	static String[][] gameBoard = new String[3][3];
	static int[] parsedPosition = new int[2];
	static String[] splitPosition;
	static String userPosition;
	static boolean gameOver = false;

	public static String[][] addOh(String[][] board, int[] position) {

		board[position[0]][position[1]] = "O";
		return gameBoard;
	}

	public static String[][] addEx(String[][] board, int[] position) {

		board[position[0]][position[1]] = "X";
		return gameBoard;
	}

	public static int[] parsePosition(String[] position) {

		for (int i = 0; i < 2; i++) {
			parsedPosition[i] = Integer.parseInt(position[i]);
		}

		return parsedPosition;
	}

	public static boolean gameEnd(String[][] board) {
		if (!gameBoard[0][0].equals(" ") && gameBoard[0][0].equals(gameBoard[0][1])
				&& gameBoard[0][1].equals(gameBoard[0][2])) {
			gameOver = true;
		} else if (!gameBoard[1][0].equals(" ") && gameBoard[1][0].equals(gameBoard[1][1])
				&& gameBoard[1][1].equals(gameBoard[1][2])) {
			gameOver = true;
		} else if (!gameBoard[2][0].equals(" ") && gameBoard[2][0].equals(gameBoard[2][1])
				&& gameBoard[2][1].equals(gameBoard[0][2])) {
			gameOver = true;
		} else if (!gameBoard[0][0].equals(" ") && gameBoard[0][0].equals(gameBoard[1][0])
				&& gameBoard[1][0].equals(gameBoard[2][0])) {
			gameOver = true;
		} else if (!gameBoard[0][1].equals(" ") && gameBoard[0][1].equals(gameBoard[1][1])
				&& gameBoard[1][1].equals(gameBoard[2][1])) {
			gameOver = true;
		} else if (!gameBoard[0][2].equals(" ") && gameBoard[0][2].equals(gameBoard[1][2])
				&& gameBoard[1][2].equals(gameBoard[2][2])) {
			gameOver = true;
		} else if (!gameBoard[0][0].equals(" ") && gameBoard[0][0].equals(gameBoard[1][1])
				&& gameBoard[1][1].equals(gameBoard[2][2])) {
			gameOver = true;
		} else if (!gameBoard[0][2].equals(" ") && gameBoard[0][2].equals(gameBoard[1][1])
				&& gameBoard[1][1].equals(gameBoard[2][0])) {
			gameOver = true;
		}
		return gameOver;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean xTurn = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = " ";
			}
		}

		do {
			System.out.println("  1   2   3");
			System.out.println("1 " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
			System.out.println(" ---|---|---");
			System.out.println("2 " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
			System.out.println(" ---|---|---");
			System.out.println("3 " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);

			if (xTurn) {
				System.out.print("Player X, enter a position on the board (x,y): ");
				userPosition = input.nextLine();
				splitPosition = userPosition.split(",");
				parsedPosition = parsePosition(splitPosition);
				gameBoard[parsedPosition[0] - 1][parsedPosition[1] - 1] = "X";
				xTurn = false;
			} else {
				System.out.print("Player O, enter a position on the board (x,y): ");
				userPosition = input.nextLine();
				splitPosition = userPosition.split(",");
				parsedPosition = parsePosition(splitPosition);
				gameBoard[parsedPosition[0] - 1][parsedPosition[1] - 1] = "O";
				xTurn = true;
			}

			gameEnd(gameBoard);

		} while (!gameOver);
		System.out.print("Game over! ");
		if (xTurn) {
			System.out.println("Player O wins.");
		} else {
			System.out.println("Player X wins.");
		}
		input.close();
	}

}
