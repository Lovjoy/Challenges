package Main;

//Ray Joy
//10/4/2024
//Tic-Tac-Toe
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();

		char top1 = '1';
		char top2 = '2';
		char top3 = '3';
		char mid4 = '4';
		char mid5 = '5';
		char mid6 = '6';
		char bot7 = '7';
		char bot8 = '8';
		char bot9 = '9';
		char playerMove;
		boolean winner = false;
		int random;
		boolean computerTurn = false;

		System.out.println("Welcome to Tic-Tac-Toe!\n");

		while (winner == false) {
			if (computerTurn == false) {
				System.out.println("\n|" + top1 + "|" + top2 + "|" + top3 + "|\n|" + mid4 + "|" + mid5 + "|" + mid6
						+ "|\n|" + bot7 + "|" + bot8 + "|" + bot9 + "|\n");

				System.out.print("Choose a number between 1-9 that isn't taken by an X or O: ");
				playerMove = scnr.next().charAt(0);

				switch (playerMove) {

				case '1':
					if (top1 != 'X' && top1 != 'O') {
						top1 = 'X';
						computerTurn = true;
					}
					break;
				case '2':
					if (top2 != 'X' && top2 != 'O') {
						top2 = 'X';
						computerTurn = true;
					}
					break;
				case '3':
					if (top3 != 'X' && top3 != 'O') {
						top3 = 'X';
						computerTurn = true;
					}
					break;
				case '4':
					if (mid4 != 'X' && mid4 != 'O') {
						mid4 = 'X';
						computerTurn = true;
					}
					break;
				case '5':
					if (mid5 != 'X' && mid5 != 'O') {
						mid5 = 'X';
						computerTurn = true;
					}
					break;
				case '6':
					if (mid6 != 'X' && mid6 != 'O') {
						mid6 = 'X';
						computerTurn = true;
					}
					break;
				case '7':
					if (bot7 != 'X' && bot7 != 'O') {
						bot7 = 'X';
						computerTurn = true;
					}
					break;
				case '8':
					if (bot8 != 'X' && bot8 != 'O') {
						bot8 = 'X';
						computerTurn = true;
					}
					break;
				case '9':
					if (bot9 != 'X' && bot9 != 'O') {
						bot9 = 'X';
						computerTurn = true;
					}
					break;
				default:
					System.out.println("Invalid Move, Computer's turn.");
					break;
				}

			} else {

				random = rand.nextInt(1, 10);
				switch (random) {

				case 1:
					if (top1 != 'X' && top1 != 'O') {
						top1 = 'O';
						computerTurn = false;
					}
					break;
				case 2:
					if (top2 != 'X' && top2 != 'O') {
						top2 = 'O';
						computerTurn = false;
					}
					break;
				case 3:
					if (top3 != 'X' && top3 != 'O') {
						top3 = 'O';
						computerTurn = false;
					}
					break;
				case 4:
					if (mid4 != 'X' && mid4 != 'O') {
						mid4 = 'O';
						computerTurn = false;
					}
					break;
				case 5:
					if (mid5 != 'X' && mid5 != 'O') {
						mid5 = 'O';
						computerTurn = false;
					}
					break;
				case 6:
					if (mid6 != 'X' && mid6 != 'O') {
						mid6 = 'O';
						computerTurn = false;
					}
					break;
				case 7:
					if (bot7 != 'X' && bot7 != 'O') {
						bot7 = 'O';
						computerTurn = false;
					}
					break;
				case 8:
					if (bot8 != 'X' && bot8 != 'O') {
						bot8 = 'O';
						computerTurn = false;
					}
					break;
				case 9:
					if (bot9 != 'X' && bot9 != 'O') {
						bot9 = 'O';
						computerTurn = false;
					}
					break;
				default:
					break;
				}
			}
			if (top1 == top2 && top2 == top3) {
				winner = true;
				if (top1 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (top1 == mid4 && mid4 == bot7) {
				winner = true;
				if (top1 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (top1 == mid5 && mid5 == bot9) {
				winner = true;
				if (top1 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (mid4 == mid5 && mid5 == mid6) {
				winner = true;
				if (mid4 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (bot7 == bot8 && bot8 == bot9) {
				winner = true;
				if (bot7 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (top3 == mid5 && mid5 == bot7) {
				winner = true;
				if (top3 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (top2 == mid5 && mid6 == bot8) {
				winner = true;
				if (top2 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			} else if (top3 == mid6 && mid6 == bot9) {
				winner = true;
				if (top3 == 'X') {
					System.out.println("\nCongratulations! You win Tic-Tac-Toe.");
				} else {
					System.out.println("\nSorry, you lose. Better luck next time.");
				}
			}
			else if (top1 != '1' && top2 != '2' && top3 != '3' && mid4 != '4' && mid5 != '5' && mid6 != '6'
					&& bot7 != '7' && bot8 != '8' && bot9 != '9') {
				System.out.println("CAT!!");
				winner = true;
			} else {
			}
		}
		if (winner = true) {
			System.out.println("\n|" + top1 + "|" + top2 + "|" + top3 + "|\n|" + mid4 + "|" + mid5 + "|" + mid6 + "|\n|"
					+ bot7 + "|" + bot8 + "|" + bot9 + "|\n");
		}
	}
}