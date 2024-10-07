package Main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input;
		int stringLength;
		
		
		System.out.println("I don't ever forget anything ever.");
		input = sc.nextLine();
		
		stringLength = input.length();
		
		for (int i = 0; i < stringLength; ++i) {
			System.out.println(input.substring(0, (stringLength - i)));
		}
		
	}
}