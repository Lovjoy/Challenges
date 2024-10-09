package Main;

import java.util.Scanner;

//Challenge - ransom note
// Ray Joy
// 10/08/2024

//You are given a magazine to cut letters from to make a ransom note. The magazine has the following 
//letters you can cut out "aaabbbcccdddeeeffffgggghhhhiiiijjjkklllmmmnnnoooopppqqqqrrrrrsssssstttuuuuvvvwwxxyyzz"
//
//The user inputs a string to represent the ransom note they want to write, and the program will check 
//if there are enough letters in the magazine to make the ransom note.
//
//If the user is able to write the ransom note given the letters, you will print out
//"We can write this message" and also print out the leftover letters you didn't use.
//
//If you can't, give an error message and end the program.

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String magLetters = "aaabbbcccdddeeeffffgggghhhhiiiijjjkklllmmmnnnoooopppqqqqrrrrrsssssstttuuuuvvvwwxxyyzz ";
		String ransomMessage;
		String cut = "";
		int messageLength;
		char letter;

		System.out.println("Welcome to the ransom note creater. We already cut the letters from a "
				+ "magazine for you. \nPlease enter your message: ");
		// Must include sc.nextLine() because sc.next returns the .length() of the first word
		ransomMessage = sc.nextLine();
		ransomMessage = ransomMessage.toLowerCase();
		messageLength = ransomMessage.length();

		for (int i = 0; i < messageLength; ++i) {
			letter = ransomMessage.charAt(i);
			if (letter == ' ') {
			} else if (magLetters.contains(String.valueOf(letter))) {
				magLetters = magLetters.replaceFirst(String.valueOf(letter), cut);
			} else {
				System.out.println("The magazine did not have enough letters to create your message.");
				i = messageLength;
			}
		}
		System.out.println("You have " + magLetters + " left over");
	}
}
