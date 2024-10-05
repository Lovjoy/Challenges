package Main;
// Ray Joy
// 10/4/2024
// Check if a word is a palaindrome
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String inputWord;
		int charIndex;
		int lastIndex;
		char firstChar;
		char endChar;

		System.out.println("Enter a word: ");
		inputWord = sc.next();

		lastIndex = inputWord.length() - 1;
		charIndex = 0;
		firstChar = inputWord.toLowerCase().charAt(charIndex);
		endChar = inputWord.toLowerCase().charAt(lastIndex);

		while (charIndex <= lastIndex) {
			if (firstChar == endChar) {
				++charIndex;
				--lastIndex;
				firstChar = inputWord.charAt(charIndex);
				endChar = inputWord.charAt(lastIndex);
			} else {
				charIndex = 3;
				lastIndex = 2;
			}
		}
		if (firstChar == endChar) {
			System.out.println(inputWord + " is a palindrome.");
		} else {
			System.out.println(inputWord + " is not a palindrome.");
		}
	}
}