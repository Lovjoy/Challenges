package Main;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
	int number = 1;	
	String one = "one ";
	String two = "two ";
	String three = "three ";
	String four = "four ";
	String five = "five ";
	String six = "six ";
	String seven = "seven ";
	String eight = "eight ";
	String nine = "nine ";
	String ten = "ten ";
	String eleven = "eleven ";
	String twelve = "twelve ";
	String thirteen = "thirteen ";
	String fourteen = "fourteen ";
	String fifthteen = "fifthteen ";
	String sixteen = "sixteen ";
	String seventeen = "seventeen ";
	String eighteen = "eighteen ";
	String nineteen = "nineteen ";
	String twenty = "twenty ";
	String thirty = "thirty ";
	String fourty = "fourty ";
	String fifty = "fifty ";
	String sixty = "sixty ";
	String seventy = "seventy ";
	String eighty = "eighty ";
	String ninety = "ninety ";
	String hundred = "hundred ";
	String thousand = "one thousand ";

		while (number < 1001) {
			if (number > 999) {
				System.out.print(thousand);
			}
			if (number > 899 && number < 1000) {
				System.out.print(nine + hundred);
			}
			if (number > 799 && number < 900) {
				System.out.print(eight + hundred);
			}
			if (number > 699 && number < 800) {
				System.out.print(seven + hundred);
			}
			if (number > 599 && number < 700) {
				System.out.print(six + hundred);
			}
			if (number > 499 && number < 600) {
				System.out.print(five + hundred);
			}
			if (number > 399 && number < 500) {
				System.out.print(four + hundred);
			}
			if (number > 299 && number < 400) {
				System.out.print(three + hundred);
			}
			if (number > 199 && number < 300) {
				System.out.print(two + hundred);
			}
			if (number > 99 && number < 200) {
				System.out.print(one + hundred);
			}
			if (number % 100 > 89 && number % 100 < 100) {
				System.out.print(ninety);
			}
			if (number % 100 > 79 && number % 100 < 90) {
				System.out.print(eighty);
			}
			if (number % 100 > 69 && number % 100 < 80) {
				System.out.print(seventy);
			}
			if (number % 100 > 59 && number % 100 < 70) {
				System.out.print(sixty);
			}
			if (number % 100 > 49 && number % 100 < 60) {
				System.out.print(fifty);
			}
			if (number % 100 > 39 && number % 100 < 50) {
				System.out.print(fourty);
			}
			if (number % 100 > 29 && number % 100 < 40) {
				System.out.print(thirty);
			}			
			if (number % 100 > 19 && number % 100 < 30) {
				System.out.print(twenty);
			}
			if (number % 100 == 19) {
				System.out.print(nineteen);
			}
			if (number % 100 == 18) {
				System.out.print(eighteen);
			}
			if (number % 100 == 17) {
				System.out.print(seventeen);
			}
			if (number % 100 == 16) {
				System.out.print(sixteen);
			}
			if (number % 100 == 15) {
				System.out.print(fifthteen);
			}
			if (number % 100 == 14) {
				System.out.print(fourteen);
			}
			if (number % 100 == 13) {
				System.out.print(thirteen);
			}
			if (number % 100 == 12) {
				System.out.print(twelve);
			}
			if (number % 100 == 11) {
				System.out.print(eleven);
			}
			if (number % 100 == 10) {
				System.out.print(ten);
			}
			if (number % 10 % 10 == 9 && number % 100 != 19) {
				System.out.print(nine);
			}
			if (number % 10 % 10 == 8 && number % 100 != 18) {
				System.out.print(eight);
			}
			if (number % 10 % 10 == 7 && number % 100 != 17) {
				System.out.print(seven);
			}
			if (number % 10 % 10 == 6 && number % 100 != 16) {
				System.out.print(six);
			}
			if (number % 10 % 10 == 5 && number % 100 != 15) {
				System.out.print(five);
			}
			if (number % 10 % 10 == 4 && number % 100 != 14) {
				System.out.print(four);
			}
			if (number % 10 % 10 == 3 && number % 100 != 13) {
				System.out.print(three);
			}
			if (number % 10 % 10 == 2 && number % 100 != 12) {
				System.out.print(two);
			}
			if (number % 10 % 10 == 1 && number % 100 != 11) {
				System.out.print(one);
			}
			System.out.println("");
			number++;
			}
		}
}
