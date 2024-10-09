package Main;
// Ray Joy

// 10/9/2024
// Challenge - email validation

//You are tasked with writing email validation for the company registration system. 
//You must analyze passwords and make sure they fit the following criteria 
//
//- has an @ sign
//- ends with .com, .org, or .edu
//- can't contain any of these characters: \ / - + $ # & * ( ) 
//- must be 9 digits long
//- can't be longer than 20 digits
//- can't contain only numbers.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String email;
		boolean valid = true;
		boolean letter = false;
		String specialChar = "/\\-+$#&*()";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email address: ");
		email = sc.nextLine();

		email = email.replace(" ", "");

		if (email.contains("@") == false) {
			valid = false;
		}
		if (email.contains(".com") == false && email.contains(".org") == false && email.contains(".edu") == false) {
			valid = false;
		}
		for (int i = 0; i < specialChar.length(); ++i) {
			if (email.contains(String.valueOf(specialChar.charAt(i)))) {
				valid = false;
			}
		}
		if (email.length() < 9) {
			valid = false;
		}
		if (email.length() > 20) {
			valid = false;
		}
		for (int i = 0; i < email.indexOf("@"); ++i) {
			if (Character.isLetter(email.charAt(i))) {
				letter = true;
			}
		}
		if (letter == false) {
			valid = false;
		}
		if (valid) {
			System.out.println("Valid email.");
		} else {
			System.out.println("Not a valid email.");
		}
	}
}