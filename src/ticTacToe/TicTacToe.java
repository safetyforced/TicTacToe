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

	public static char[][] addOh(char[][] board, int[] position) {

		board[position[0]-1][position[1]-1] = 'O';
		return gameBoard;
	}

	public static char[][] addEx(char[][] board, int[] position) {

		board[position[0]-1][position[1]-1] = 'X';
		return gameBoard;
	}

	public static int[] parsePosition(String[] position) {

		for (int i = 0; i < 2; i++) {
			parsedPosition[i] = Integer.parseInt(position[i]);
		}

		return parsedPosition;
	}

	public static boolean gameEnd(char[][] board) {
		if (board[0][0] != ' ' && board[0][0] == board[0][1]
				&& board[0][1] == board[0][2]) {
			gameOver = true;
		} else if (board[1][0] != ' ' && board[1][0] == board[1][1]
				&& board[1][1] == board[1][2]) {
			gameOver = true;
		} else if (board[2][0] != ' ' && board[2][0] == board[2][1]
				&& board[2][1] == board[0][2]) {
			gameOver = true;
		} else if (board[0][0] != ' ' && board[0][0] == board[1][0]
				&& board[1][0] == board[2][0]) {
			gameOver = true;
		} else if (board[0][1] != ' ' && board[0][1] == board[1][1]
				&& board[1][1] == board[2][1]) {
			gameOver = true;
		} else if (board[0][2] != ' ' && board[0][2] == board[1][2]
				&& board[1][2] == board[2][2]) {
			gameOver = true;
		} else if (board[0][0] != ' ' && board[0][0] == board[1][1]
				&& board[1][1] == board[2][2]) {
			gameOver = true;
		} else if (board[0][2] != ' ' && board[0][2] == board[1][1]
				&& board[1][1] == board[2][0]) {
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
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean xTurn = true;

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
