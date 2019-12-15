package ru.geekbrains.java_one.homework_c;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	private static final char DOT_HUMAN = 'X';
	private static final char DOT_AI = '0';
	private static final char DOT_EMPTY = '.';
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Random RANDOM = new Random();
	private static char[][] field;
	private static int fieldSizeX;
	private static int fieldSizeY;
	private static int winLineSize;

	private static void initField(int fieldSizeXx, int fieldSizeYy, int winLineSizeW) {
		fieldSizeY = fieldSizeYy;
		fieldSizeX = fieldSizeXx;
		winLineSize = winLineSizeW;
		field = new char[fieldSizeY][fieldSizeX];
		for (int y = 0; y < fieldSizeY; y++) {
			for (int x = 0; x < fieldSizeX; x++) {
				field[y][x] = DOT_EMPTY;
			}
		}
	}

	private static void printField() {
		System.out.print("+");
		for (int i = 0; i < fieldSizeX * 2 + 1; i++)
			System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
		System.out.println();

		for (int i = 0; i < fieldSizeX; i++) {
			System.out.print(i + 1 + "|");
			for (int j = 0; j < fieldSizeX; j++) {
				System.out.print(field[i][j] + "|");
			}
			System.out.println();
		}

		for (int i = 0; i < fieldSizeX * 2 + 1; i++)
			System.out.print("-");
		System.out.println();
	}

	private static void humanTurn() {
		int x;
		int y;
		do {
			System.out.println("Введите, пожалуйста, координаты X от 1 до " + fieldSizeX + " и Y  от 1 до " + fieldSizeY + " через пробел");
			x = SCANNER.nextInt() - 1;
			y = SCANNER.nextInt() - 1;
		} while (!isValidCell(x, y) || !isEmtyCell(x, y));
		field[y][x] = DOT_HUMAN;
	}

	private static boolean isValidCell(int x, int y) {
		return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
	}

	private static boolean isEmtyCell(int x, int y) {
		return field[y][x] == DOT_EMPTY;
	}

	private static void aiTurn() {
		int x;
		int y;
		do {
			x = RANDOM.nextInt(fieldSizeX);
			y = RANDOM.nextInt(fieldSizeY);
		} while (!isValidCell(x, y) || !isEmtyCell(x, y));
		field[y][x] = DOT_AI;
	}

	private static boolean checkWin(char lastChar) {
		if (checkRows(lastChar)) return true;
		if (checkColumns(lastChar)) return true;
		if (checkDiagonals(lastChar)) return true;
		return false;
	}

	private static boolean checkDiagonals(char lastChar) {
		for (int i = 0; i < fieldSizeX; i++) {
			for (int j = 0; j < fieldSizeY; j++) {
				if (lastChar == field[i][j]) {
					if (i >= winLineSize && fieldSizeY - j >= winLineSize) {
						int lingthSubArray = 1;
						for (int k = 1; k < winLineSize; k++) {
							if (lastChar == field[i - k][j + k]) {
								lingthSubArray++;
							}
						}
						if(lingthSubArray == winLineSize){
							return true;
						}
					}
					if (fieldSizeX - i >= winLineSize && fieldSizeY - j >= winLineSize) {
						int lingthSubArray = 1;
						for (int k = 1; k < winLineSize; k++) {
							if (lastChar == field[i + k][j + k]) {
								lingthSubArray++;
							}
						}
						if(lingthSubArray == winLineSize){
							return true;
						}

					}
				}
			}
		}
		return false;
	}

	private static boolean checkColumns(char lastChar) {
		for (int j = 0; j < fieldSizeY; j++) {
			int lingthSubArray = 0;
			for (int i = 0; i < fieldSizeX; i++) {
				if (lastChar == field[i][j]) {
					lingthSubArray++;
					if (lingthSubArray == winLineSize)
						return true;
				} else {
					lingthSubArray = 0;
				}
			}
		}
		return false;
	}

	private static boolean checkRows(char lastChar) {
		for (int i = 0; i < fieldSizeX; i++) {
			int lingthSubArray = 0;
			for (int j = 0; j < fieldSizeY; j++) {
				if (lastChar == field[i][j]) {
					lingthSubArray++;
					if (lingthSubArray == winLineSize)
						return true;
				} else {
					lingthSubArray = 0;
				}
			}
		}
		return false;
	}

	private static boolean isDraw() {
		for (int y = 0; y < fieldSizeY; y++) {
			for (int x = 0; x < fieldSizeX; x++) {
				if (field[y][x] == DOT_EMPTY)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		initField(3, 3, 3);
		printField();
		while (true) {
			humanTurn();
			printField();
			if (checkWin(DOT_HUMAN)) {
				System.out.print("Human Win!");
				break;
			}
			if (isDraw()) {
				System.out.print("Draw!");
				break;
			}
			aiTurn();
			printField();
			if (checkWin(DOT_AI)) {
				System.out.print("Computer Win!");
				break;
			}
			if (isDraw()) {
				System.out.print("Draw!");
				break;
			}
		}
	}
}
