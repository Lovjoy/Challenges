package Main;

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
		
		alphabet = " abcdefghijklmnopqrstuvwxyz";
		
		System.out.println("Did you want to: \na) Create a secret \nb) Decode a secret");
		
		System.out.println("Enter your message you want to be coded as a secret: ");
		
		message = sc.next();
		messageLegnth = message.length();
		
		
		for (int i = 0; i < messageLegnth ; ++i) {
			messageChar = message.charAt(i);
			secretIndex = (alphabet.indexOf(messageChar) - 3);
		
				switch (secretIndex){
				case -3:				// space
					secretChar = ' ';
					break;
				case -2:				// a >> x
					secretChar = 'x';
					break;
				case -1:				// b >> y
					secretChar = 'y';
					break;
				case 0:					// c >> z
					secretChar = 'z';
					break;
				default:
					secretChar = alphabet.charAt(secretIndex);
					break;
				}
				
		
			
			secret += secretChar;
		}
		System.out.println(secret);
	}
}

