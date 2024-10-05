package Main;
//Ray Joy
//10/4/2024
//Check if a word is a palaindrome attempt 2
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String inputWord;
		String reverseWord = "";

		System.out.println("Enter a word: ");
		inputWord = sc.next();

		for (int i = 1; i <= inputWord.length(); ++i) {
			reverseWord += inputWord.charAt(inputWord.length() - i);
		}
		System.out.println((inputWord.equalsIgnoreCase(reverseWord) ? (inputWord + " is a palindrome.") : (inputWord + " is not a palindrome.")));
	}
}