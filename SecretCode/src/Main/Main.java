package Main;
//Ray Joy
//10/4/2024
//Creates and Decodes Secrets
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String message;
		String secret = "";
		int messageLegnth;
		char messageChar;
		char secretChar = ' ';
		int secretIndex;
		String alphabet;
		char menuOption;

		alphabet = " abcdefghijklmnopqrstuvwxyz";

		System.out.println("Did you want to: \na) Create a secret \nb) Decode a secret");
		menuOption = sc.next().charAt(0);

		switch (menuOption) {

		case 'a':
		case 'A':

			System.out.println("Enter your message you want to be coded as a secret: \n");
			sc.nextLine();
			message = sc.nextLine();
			messageLegnth = message.length();

			for (int i = 0; i < messageLegnth; ++i) {
				messageChar = message.toLowerCase().charAt(i);
				secretIndex = (alphabet.indexOf(messageChar) - 3);

				switch (secretIndex) {
				case -3: // space
					secretChar = ' ';
					break;
				case -2: // a >> x
					secretChar = 'x';
					break;
				case -1: // b >> y
					secretChar = 'y';
					break;
				case 0: // c >> z
					secretChar = 'z';
					break;
				default:
					secretChar = alphabet.charAt(secretIndex);
					break;
				}
				secret += secretChar;
			}
			System.out.println(secret);
			break;
		case 'b':
		case 'B':

			System.out.println("Enter your message you want to be decoded: \n");
			sc.nextLine();
			message = sc.nextLine();
			messageLegnth = message.length();

			for (int i = 0; i < messageLegnth; ++i) {
				messageChar = message.toLowerCase().charAt(i);
				secretIndex = (alphabet.indexOf(messageChar) + 3);

				switch (secretIndex) {
				case 3: // space
					secretChar = ' ';
					break;
				case 27: // x >> a
					secretChar = 'a';
					break;
				case 28: // y >> b
					secretChar = 'b';
					break;
				case 29: // z >> c
					secretChar = 'c';
					break;
				default:
					secretChar = alphabet.charAt(secretIndex);
					break;
				}
				secret += secretChar;
			}
			System.out.println(secret);

			break;

		default:
			System.out.println("Please select either the letter a or b");
			break;
		}
	}

}
