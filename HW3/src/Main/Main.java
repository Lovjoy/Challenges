// Ray Hobbs
// 10/21/2024
// HW3
// Menu: Statistics, Vowel count, Asterisk design

package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char menu = 'e';

		// Variables for Statistics
		int n;
		double num;
		double sum; // used for ave
		double max;
		double min;
		double middle = 0;

		// Variables for Vowel count
		String word;
		int numOfAs = 0;
		int numOfEs = 0;
		int numOfIs = 0;
		int numOfOs = 0;
		int numOfUs = 0;
		int numOfYs = 0;
		int numOfVowels = 0;

		while (menu != 'd') {
			
			// Menu
			System.out.println("a) Statistics\nb) Vowel count\nc) Display asterisk design\nd) Exit");
			System.out.print("\nSelect one of the above options: ");
			menu = sc.next().charAt(0);

			switch (menu) {
			// Statistics: Ave, Max, Min, Middle
			case 'a':
			case 'A':
				System.out.print("\nn: ");
				n = sc.nextInt();
				System.out.println();
				
				// Resets values for new stats
				sum = 0;
				max = Double.MIN_VALUE;
				min = Double.MAX_VALUE;
				for (int i = 1; i <= n; i++) {
					System.out.print("Num " + i + ": ");
					num = sc.nextDouble();
					// Average
					sum += num;

					// Max
					if (num > max) {
						max = num;
					}

					// Min
					if (num < min) {
						min = num;
					}

					// Middle ((n + 1)/2)th value entered
					if (i == ((n + 1) / 2)) {
						middle = num;
					}
				}
				System.out.printf("\n%-15s %.1f\n%-15s %.1f\n%-15s %.1f\n%-15s %.1f\n", 
						"Average: ", (sum / n), "Max: ", max, "Min: ", min, "Middle: ", middle);

				break;
			// Vowel Count: How many total and how many of each vowel
			case 'b':
			case 'B':

				System.out.print("\nEnter a word: ");
				word = sc.next();
				// Resets all values back to zero
				numOfAs = 0;
				numOfEs = 0;
				numOfIs = 0;
				numOfOs = 0;
				numOfUs = 0;
				numOfYs = 0;
				numOfVowels = 0;

				
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == 'a' || word.charAt(i) == 'A') {
						numOfAs++;
					}
					if (word.charAt(i) == 'e' || word.charAt(i) == 'E') {
						numOfEs++;
					}
					if (word.charAt(i) == 'i' || word.charAt(i) == 'I') {
						numOfIs++;
					}
					if (word.charAt(i) == 'o' || word.charAt(i) == 'O') {
						numOfOs++;
					}
					if (word.charAt(i) == 'u' || word.charAt(i) == 'U') {
						numOfUs++;
					}
					if (word.charAt(i) == 'y' || word.charAt(i) == 'Y') {
						numOfYs++;
					}
				}
				numOfVowels = numOfAs + numOfEs + numOfIs + numOfOs + numOfUs + numOfYs;
				if (numOfVowels == 0) {
					System.out.print("\n" + word + " contains no vowels");
				} else {
					System.out.printf("\n%-20s%d", "Total Vowels: ", numOfVowels);
					System.out.println();
				}
				if (numOfAs != 0) {
					System.out.printf("\n%-20s%d", "A: ", numOfAs);
				}
				if (numOfEs != 0) {
					System.out.printf("\n%-20s%d", "E: ", numOfEs);
				}
				if (numOfIs != 0) {
					System.out.printf("\n%-20s%d", "I: ", numOfIs);
				}
				if (numOfOs != 0) {
					System.out.printf("\n%-20s%d", "O: ", numOfOs);
				}
				if (numOfUs != 0) {
					System.out.printf("\n%-20s%d", "U: ", numOfUs);
				}
				if (numOfYs != 0) {
					System.out.printf("\n%-20s%d", "Y: ", numOfYs);
				}
				System.out.println();
				break;
			// Display asterisk design
			case 'c':
			case 'C':
				for (int i = 0; i < 6; i++) {
					for (int k = 5; k > i; k--) {
						System.out.print(" ");
					}
					for (int j = 0; j < i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
				break;
			// Exit
			case 'd':
			case 'D':
				System.out.println("\nTerminated");
				break;
			default:
				System.out.println("\nPlease enter option a, b, c, or d.");
				break;

			}
			if (menu == 'd' || menu == 'D') {
				break;
			}
			System.out.println("\n------------------------------------------------\n");
		}
	}
}
