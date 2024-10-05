package Main;

import java.util.Random;
import java.util.Scanner;

// start 4:40
// Ray Joy
// 10/3/2024

//The program will generate a random number between 1 and 1,000,000,000. The player then 
//takes guesses to figure out the number. The program will give hints to the player, such 
//as "too high!" and "too low!"
public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int guess;
		int randomNum;
		
		System.out.println("Guess a number between 0 and 1,000,000,000: ");
		guess = sc.nextInt();
		randomNum = rand.nextInt(0, 1000000001);
		
		while (guess != randomNum) {
			if (guess < randomNum) {
				System.out.println("Too low! Guess again. ");
			} else {
				System.out.println("Too high! Guess again. ");
			}
			guess = sc.nextInt();
		}
		System.out.println("Congratulations! " + randomNum + " is the correct number.");
		
	}

}
