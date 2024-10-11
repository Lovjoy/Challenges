package Main;

import java.util.Random;
import java.util.Scanner;

// Ray Joy
// 10/10/2024

/*Challenge - slots

Write your very own casino game. The user starts with a set amount of money (5000$), and is 
allowed to spin the slots until they run out of money. Additionally the user can change the bet 
amount from min (5$), med(10$), max(15$). the display is a 3X3 grid which looks like this.

X|X|X
X|X|X
X|X|X

on min bets, only the middle three rows will be counted when looking for winning matches.
on med bets, all 3 rows are active but only horizontally.
on max bets, all rows are active in all directions.

The following items are spun on the slots, and award these points

banana - 1 $ per banana. no matches required.
marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
Cat - 25$ for 3 in a row. 
Otter - 50$ for 3 in a row.
Tiger - 100$ for 3 in a row.
Sheep - 300$ for 3 in a row.
half moon - 500$ for 3 in a row
full moon - 1000$ for 3 in a row

Each of these items can appear on the wheel any number of times when stopped, but have a 
%chance to be what appears
banana - 25%
marshmallow - 21%
cat - 18%
otter - 10%
tiger - 8%
sheep - 7%
half moon - 6%
full moon - 5%*/


public class Main {

public enum Symbol {BANANA, MARSHMALLOW, CAT, OTTER, TIGER, SHEEP, HALF_MOON, FULL_MOON}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int cash = 5000;
		char bet;
		char top1, top2, top3, mid1, mid2, mid3, bot1, bot2, bot3;
		double randomNum;
		
		while (cash > 0) {
		
		System.out.println("Current cash is $" + cash);
		System.out.println("\nEnter bet about:\na) -$5 Middle Row\nb) -$10 All Rows\nc) -$15 All Bets");
		bet = sc.next().charAt(0);
		
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			top1 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			top1 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			top1 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			top1 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			top1 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			top1 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			top1 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			top1 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			top2 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			top2 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			top2 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			top2 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			top2 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			top2 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			top2 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			top2 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			top3 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			top3 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			top3 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			top3 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			top3 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			top3 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			top3 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			top3 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			mid1 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			mid1 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			mid1 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			mid1 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			mid1 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			mid1 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			mid1 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			mid1 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			mid2 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			mid2 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			mid2 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			mid2 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			mid2 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			mid2 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			mid2 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			mid2 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			mid3 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			mid3 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			mid3 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			mid3 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			mid3 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			mid3 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			mid3 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			mid3 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			bot1 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			bot1 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			bot1 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			bot1 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			bot1 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			bot1 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			bot1 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			bot1 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			bot2 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			bot2 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			bot2 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			bot2 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			bot2 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			bot2 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			bot2 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			bot2 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		randomNum = rand.nextDouble();
		if (randomNum <= 0.25) {
			bot3 = String.valueOf(Symbol.BANANA).charAt(0); 	//banana - 25%
		} else if (randomNum <= 0.46) {
			bot3 = String.valueOf(Symbol.MARSHMALLOW).charAt(0);//marshmallow - 21%
		} else if (randomNum <= 0.64) {
			bot3 = String.valueOf(Symbol.CAT).charAt(0);		//cat - 18%
		} else if (randomNum <= 0.74) {
			bot3 = String.valueOf(Symbol.OTTER).charAt(0);		//otter - 10%
		} else if (randomNum <= 0.82) {
			bot3 = String.valueOf(Symbol.TIGER).charAt(0);		//tiger - 8%
		} else if (randomNum <= 0.89) {
			bot3 = String.valueOf(Symbol.SHEEP).charAt(0);		//sheep - 7%
		} else if (randomNum <= 0.95) {
			bot3 = String.valueOf(Symbol.HALF_MOON).charAt(0);	//half moon - 6%
		} else {
			bot3 = String.valueOf(Symbol.FULL_MOON).charAt(0);	//full moon - 5%
		}
		System.out.println("| " + top1 + " | " + top2 + " | " + top3 + " |\n"
				+ "| " + mid1 + " | " + mid2 + " | " + mid3 + " |\n"
						+ "| " + bot1 + " | " + bot2 + " | " + bot3 + " |\n");
		
		switch (bet) {
		// min bet mid row only
		
		
//		Vertical Columns		
		case 'c': 
		case 'C':
		case '3':
//			Total Cost for ALL Bets $15
			cash -= 5;
//			FIRST COLUMN
//			triple banana total payout $5
			if (top1 == 'B' && top1 == mid1 && mid1 == bot1) {
				cash += 2;
				System.out.println("Triple Banana! +$2");
			}
//			marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
			if (top1 == 'M' && mid1 == 'M' && bot1 == 'M') {
				cash += 10;
				System.out.println("Triple Marshmallow! +$10");
			} else if (top1 == 'M' && mid1 == 'M' || mid1 == 'M' && bot1 == 'M') {
				cash += 5;
				System.out.println("Marshmallow Marshmallow Yum! +$5");
			}
//			Cat - 25$ for 3 in a row. 
			if (top1 == 'C' && top1 == mid1 && mid1 == bot1) {
				cash += 25;
				System.out.println("It's the Cat's meow! +$25");
			}
//			Otter - 50$ for 3 in a row.
			if (top1 == 'O' && top1 == mid1 && mid1 == bot1) {
				cash += 50;
				System.out.println("Let's hold hands like Otters. +$50");
			}
//			Tiger - 100$ for 3 in a row.
			if (top1 == 'T' && top1 == mid1 && mid1 == bot1) {
				cash += 100;
				System.out.println("Who is crazy enough to cuddle with a Tiger. +$100");
			}
//			Sheep - 300$ for 3 in a row.
			if (top1 == 'S' && top1 == mid1 && mid1 == bot1) {
				cash += 300;
				System.out.println("Are you feeling Sheepy yet? +$300");
			}
//			half moon - 500$ for 3 in a row
			if (top1 == 'H' && top1 == mid1 && mid1 == bot1) {
				cash += 500;
				System.out.println("You are Half way there! +$500");
			}
//			full moon - 1000$ for 3 in a row
			if (top1 == 'F' && top1 == mid1 && mid1 == bot1) {
				cash += 1000;
				System.out.println("You are over the Full Moon with this Jackpot!! +$1000");
			}
//			MIDDLE COLUMN
//			triple banana total payout $5
			if (top2 == 'B' && top2 == mid2 && mid2 == bot2) {
				cash += 2;
				System.out.println("Triple Banana! +$2");
			}
//			marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
			if (top2 == 'M' && mid2 == 'M' && bot2 == 'M') {
				cash += 10;
				System.out.println("Triple Marshmallow! +$10");
			} else if (top2 == 'M' && mid2 == 'M' || mid2 == 'M' && bot2 == 'M') {
				cash += 5;
				System.out.println("Marshmallow Marshmallow Yum! +$5");
			}
//			Cat - 25$ for 3 in a row. 
			if (top2 == 'C' && top2 == mid2 && mid2 == bot2) {
				cash += 25;
				System.out.println("It's the Cat's meow! +$25");
			}
//			Otter - 50$ for 3 in a row.
			if (top2 == 'O' && top2 == mid2 && mid2 == bot2) {
				cash += 50;
				System.out.println("Let's hold hands like Otters. +$50");
			}
//			Tiger - 100$ for 3 in a row.
			if (top2 == 'T' && top2 == mid2 && mid2 == bot2) {
				cash += 100;
				System.out.println("Who is crazy enough to cuddle with a Tiger. +$100");
			}
//			Sheep - 300$ for 3 in a row.
			if (top2 == 'S' && top2 == mid2 && mid2 == bot2) {
				cash += 300;
				System.out.println("Are you feeling Sheepy yet? +$300");
			}
//			half moon - 500$ for 3 in a row
			if (top2 == 'H' && top2 == mid2 && mid2 == bot2) {
				cash += 500;
				System.out.println("You are Half way there! +$500");
			}
//			full moon - 1000$ for 3 in a row
			if (top2 == 'F' && top2 == mid2 && mid2 == bot2) {
				cash += 1000;
				System.out.println("You are over the Full Moon with this Jackpot!! +$1000");
			}
//			LAST COLUMN
//			triple banana total payout $5
			if (top3 == 'B' && top3 == mid3 && mid3 == bot3) {
				cash += 2;
				System.out.println("Triple Banana! +$2");
			}
//			marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
			if (top3 == 'M' && mid3 == 'M' && bot3 == 'M') {
				cash += 10;
				System.out.println("Triple Marshmallow! +$10");
			} else if (top3 == 'M' && mid3 == 'M' || mid3 == 'M' && bot3 == 'M') {
				cash += 5;
				System.out.println("Marshmallow Marshmallow Yum! +$5");
			}
//			Cat - 25$ for 3 in a row. 
			if (top3 == 'C' && top3 == mid3 && mid3 == bot3) {
				cash += 25;
				System.out.println("It's the Cat's meow! +$25");
			}
//			Otter - 50$ for 3 in a row.
			if (top3 == 'O' && top3 == mid3 && mid3 == bot3) {
				cash += 50;
				System.out.println("Let's hold hands like Otters. +$50");
			}
//			Tiger - 100$ for 3 in a row.
			if (top3 == 'T' && top3 == mid3 && mid3 == bot3) {
				cash += 100;
				System.out.println("Who is crazy enough to cuddle with a Tiger. +$100");
			}
//			Sheep - 300$ for 3 in a row.
			if (top3 == 'S' && top3 == mid3 && mid3 == bot3) {
				cash += 300;
				System.out.println("Are you feeling Sheepy yet? +$300");
			}
//			half moon - 500$ for 3 in a row
			if (top3 == 'H' && top3 == mid3 && mid3 == bot3) {
				cash += 500;
				System.out.println("You are Half way there! +$500");
			}
//			full moon - 1000$ for 3 in a row
			if (top3 == 'F' && top3 == mid3 && mid3 == bot3) {
				cash += 1000;
				System.out.println("You are over the Full Moon with this Jackpot!! +$1000");
			}
			
			
//		Top and Bottom Rows
		case 'b': 
		case 'B':
		case '2':
//			Bet for 3 Rows is $10
			cash -= 5;
//			TOP ROW
//			banana - 1 $ per banana. no matches required.
			if (top1 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			} 
			if (top2 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			} 
			if (top3 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			}
//			triple banana total payout $5
			if (top1 == 'B' && top1 == top2 && top2 == top3) {
				cash += 2;
				System.out.println("Triple Banana! +$2");
			}
//			marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
			if (top1 == 'M' && top2 == 'M' && top3 == 'M') {
				cash += 10;
				System.out.println("Triple Marshmallow! +$10");
			} else if (top1 == 'M' && top2 == 'M' || top2 == 'M' && top3 == 'M') {
				cash += 5;
				System.out.println("Marshmallow Marshmallow Yum! +$5");
			}
//			Cat - 25$ for 3 in a row. 
			if (top1 == 'C' && top1 == top2 && top2 == top3) {
				cash += 25;
				System.out.println("It's the Cat's meow! +$25");
			}
//			Otter - 50$ for 3 in a row.
			if (top1 == 'O' && top1 == top2 && top2 == top3) {
				cash += 50;
				System.out.println("Let's hold hands like Otters. +$50");
			}
//			Tiger - 100$ for 3 in a row.
			if (top1 == 'T' && top1 == top2 && top2 == top3) {
				cash += 100;
				System.out.println("Who is crazy enough to cuddle with a Tiger. +$100");
			}
//			Sheep - 300$ for 3 in a row.
			if (top1 == 'S' && top1 == top2 && top2 == top3) {
				cash += 300;
				System.out.println("Are you feeling Sheepy yet? +$300");
			}
//			half moon - 500$ for 3 in a row
			if (top1 == 'H' && top1 == top2 && top2 == top3) {
				cash += 500;
				System.out.println("You are Half way there! +$500");
			}
//			full moon - 1000$ for 3 in a row
			if (top1 == 'F' && top1 == top2 && top2 == top3) {
				cash += 1000;
				System.out.println("You are over the Full Moon with this Jackpot!! +$1000");
			}
//			BOTTOM ROW
//			banana - 1 $ per banana. no matches required.
			if (bot1 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			} 
			if (bot2 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			} 
			if (bot3 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			}
//			triple banana total payout $5
			if (bot1 == 'B' && bot1 == bot2 && bot2 == bot3) {
				cash += 2;
				System.out.println("Triple Banana! +$2");
			}
//			marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
			if (bot1 == 'M' && bot2 == 'M' && bot3 == 'M') {
				cash += 10;
				System.out.println("Triple Marshmallow! +$10");
			} else if (bot1 == 'M' && bot2 == 'M' || bot2 == 'M' && bot3 == 'M') {
				cash += 5;
				System.out.println("Marshmallow Marshmallow Yum! +$5");
			}
//			Cat - 25$ for 3 in a row. 
			if (bot1 == 'C' && bot1 == bot2 && bot2 == bot3) {
				cash += 25;
				System.out.println("It's the Cat's meow! +$25");
			}
//			Otter - 50$ for 3 in a row.
			if (bot1 == 'O' && bot1 == bot2 && bot2 == bot3) {
				cash += 50;
				System.out.println("Let's hold hands like Otters. +$50");
			}
//			Tiger - 100$ for 3 in a row.
			if (bot1 == 'T' && bot1 == bot2 && bot2 == bot3) {
				cash += 100;
				System.out.println("Who is crazy enough to cuddle with a Tiger. +$100");
			}
//			Sheep - 300$ for 3 in a row.
			if (bot1 == 'S' && bot1 == bot2 && bot2 == bot3) {
				cash += 300;
				System.out.println("Are you feeling Sheepy yet? +$300");
			}
//			half moon - 500$ for 3 in a row
			if (bot1 == 'H' && bot1 == bot2 && bot2 == bot3) {
				cash += 500;
				System.out.println("You are Half way there! +$500");
			}
//			full moon - 1000$ for 3 in a row
			if (bot1 == 'F' && bot1 == bot2 && bot2 == bot3) {
				cash += 1000;
				System.out.println("You are over the Full Moon with this Jackpot!! +$1000");
			}

			
			
// 		Middle Row Only
		case 'a':
		case 'A':
		case '1':
//			bet for mid row only $5
			cash -= 5;
		
//			banana - 1 $ per banana. no matches required.
			if (mid1 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			} 
			if (mid2 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			} 
			if (mid3 == 'B') {
				cash++;
				System.out.println("Banana +$1");
			}
//			triple banana total payout $5
			if (mid1 == 'B' && mid1 == mid2 && mid2 == mid3) {
				cash += 2;
				System.out.println("Triple Banana! +$2");
			}
//			marshmallow - 5$ for 2 in a row. 10$ for 3 in a row.
			if (mid1 == 'M' && mid2 == 'M' && mid3 == 'M') {
				cash += 10;
				System.out.println("Triple Marshmallow! +$10");
			} else if (mid1 == 'M' && mid2 == 'M' || mid2 == 'M' && mid3 == 'M') {
				cash += 5;
				System.out.println("Marshmallow Marshmallow Yum! +$5");
			}
//			Cat - 25$ for 3 in a row. 
			if (mid1 == 'C' && mid1 == mid2 && mid2 == mid3) {
				cash += 25;
				System.out.println("It's the Cat's meow! +$25");
			}
//			Otter - 50$ for 3 in a row.
			if (mid1 == 'O' && mid1 == mid2 && mid2 == mid3) {
				cash += 50;
				System.out.println("Let's hold hands like Otters. +$50");
			}
//			Tiger - 100$ for 3 in a row.
			if (mid1 == 'T' && mid1 == mid2 && mid2 == mid3) {
				cash += 100;
				System.out.println("Who is crazy enough to cuddle with a Tiger. +$100");
			}
//			Sheep - 300$ for 3 in a row.
			if (mid1 == 'S' && mid1 == mid2 && mid2 == mid3) {
				cash += 300;
				System.out.println("Are you feeling Sheepy yet? +$300");
			}
//			half moon - 500$ for 3 in a row
			if (mid1 == 'H' && mid1 == mid2 && mid2 == mid3) {
				cash += 500;
				System.out.println("You are Half way there! +$500");
			}
//			full moon - 1000$ for 3 in a row
			if (mid1 == 'F' && mid1 == mid2 && mid2 == mid3) {
				cash += 1000;
				System.out.println("You are over the Full Moon with this Jackpot!! +$1000");
			}
			break;
		default:
			System.out.println("Please enter either a, b, or c to bet.");
		}
		
		}	
	}

}
