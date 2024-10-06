package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int input;
		boolean prime = false;
		
		System.out.println("Enter a number greater than 2: ");
		input = sc.nextInt();
		
		for (int i = 1; i <= input; ++i) {
			for (int j = 1; j < i; ++j) {
				if (i % j != 0) {
					prime = true;
				} else {
					prime = false;
				}
			}	
			if (prime == true) {
					System.out.println(i + " is prime");
			} else {
				System.out.println(i);
				}
			
			}
		
		}

}
