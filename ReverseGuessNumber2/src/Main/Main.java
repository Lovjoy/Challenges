package Main;

import java.util.Random;
import java.util.Scanner;

// Ray Joy
// 10/3/2024
// problem: inverted guessing game.
// The program will let you input a number between 1 and 1,000,000,000. The computer will then 
// try to figure out the number.
public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int userNum;
		int computerGuess = 500000000;
		int min = 1;
		int max = 1000000000;
		int count = 0;
		
		System.out.println("Enter a number between 1 and 1,000,000,000: ");
		userNum = sc.nextInt();
		
		while (computerGuess != userNum) {
			System.out.println("Computer guess is " + computerGuess + ".");
			if (computerGuess < userNum) {
				min = computerGuess;
			} else {
				max = computerGuess;
			}
			computerGuess = (max + min) / 2;
			count++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
		System.out.println("The computer guessed your number in " + count + " attemps.");
	}


}