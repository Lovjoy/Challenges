package Main;

import java.util.Scanner;

/*Ray Joy
 * 10/3/2024
 * challenge - a basic calculator

You are tasked with the creation for a calculator that supports a few basic functions. The calculator runs until the user enters the exit option.

The calculator will perform these following operations
1 - add 2 numbers
2 - subtract from the entered 2 numbers
3 - multiply 2 entered numbers
4 - divide using the 2 entered numbers
5 - factorial the entered number
6 - power, raise the first number by the power of the second number
*/
public class Main {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		int num1;
		int num2;
		char operator;
		int sum;
		int diff;
		int prod;
		double quote;
		int power;
		int factorial;
		int n = 0;

		System.out.print("Enter Number1: ");
		num1 = scnr.nextInt();
		System.out.println("\nEnter Operation: \n+ addtion \n- subtraction \n* multiplication "
				+ "\n/ division \n! factorial \n^ power");
		operator = scnr.next().charAt(0);

		if (operator == '!') {
			factorial = num1;
			n = num1;
			while (n > 1) {
				factorial *= (n - 1);
				n--;
			}
			System.out.println(num1 + "! is equal to " + factorial);
		} else {
			System.out.println("Enter Number2: ");
			num2 = scnr.nextInt();

			switch (operator) {
			case '+':
				sum = num1 + num2;
				System.out.println(num1 + " + " + num2 + " is equal to " + sum);
				break;
			case '-':
				diff = num1 - num2;
				System.out.println(num1 + " - " + num2 + " is equal to " + diff);
				break;
			case '*':
				prod = num1 * num2;
				System.out.println(num1 + " * " + num2 + " is equal to " + prod);
				break;
			case '/':
				quote = (double)num1 / num2;
				System.out.println(num1 + " / " + num2 + " is equal to " + quote);
				break;
			case '^':
				power = 1;
				for (int i = 0; i < num2; ++i) {
					power *= num1;
				}
					System.out.println(num1 + " ^ " + num2 + " is equal to " + power);				
				break;
			default:
				System.out.println("ERROR: Enter a valid Operation + - * / ! ^");

			}
		}
	}
}
