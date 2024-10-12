package Main;

import java.util.Random;
import java.util.Scanner;

//Ray Joy
//10/11/2024

//Challenge - Stonks
//You are put in charge of writing a game about playing stocks. There are 5 stocks the player can manipulate.
//jeff-azon 
//wally-marty
//blizz-craft
//sprin-kles
//temp-portals
//Each round, the player can choose to buy from any of the 5 stocks and buy as many shares as they like before ending the 
//turn. The next turn always causes the price of the stocks to fluctuate, gaining or losing anywhere from -5% to +5% value. 
//Stocks cannot go below 10 cents. Additionally, the player may end the turn without buying anything. The player must 
//accumulate 1000$ to win.
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		// Initially, the player will be given 100$. The stock prices for each stock
		// will
		// be set at a random value from 1.00-3.00$.
		double priceJeff = rand.nextDouble(1, 3);
		double priceWally = rand.nextDouble(1, 3);
		double priceBlizz = rand.nextDouble(1, 3);
		double priceSprin = rand.nextDouble(1, 3);
		double priceTemp = rand.nextDouble(1, 3);
		double totalCash = 100;
		int numOfJeff = 0;
		int numOfWally = 0;
		int numOfBlizz = 0;
		int numOfSprin = 0;
		int numOfTemp = 0;
		int numPurchased = 0;
		int numSold = 0;
		double totalValue = 0;
		int menu;
		int amountPurchased;
		double percentChange; // Random gain or loss of 5-15% depending on type of stock

		while (totalCash < 1000) {

			System.out.printf(
					"STONK PRICES: \n%-5d%-15s$%.2f \n%-5d%-15s$%.2f\n%-5d%-15s$%.2f\n%-5d%-15s$%.2f"
							+ "\n%-5d%-15s$%.2f",
					numOfJeff, "jeff-azon: ", priceJeff, numOfWally, "wally-marty: ", priceWally, numOfBlizz,
					"blizz-craft: ", priceBlizz, numOfSprin, "sprin-kles: ", priceSprin, numOfTemp, "temp-portals: ",
					priceTemp);
			System.out.printf("\n%-15s$%.2f", "TOTAL CASH: ", totalCash);

			System.out.println("\nSelect an option: \n1) Buy \n2) Sell\n3) Hold");
			menu = sc.nextInt();

			switch (menu) {
			// BUY
			case 1:
				System.out.printf("\n%-15s$%.2f", "TOTAL CASH: ", totalCash);
				System.out.printf(
						"\nSelect STONK to Buy: \n%-17s$%.2f\n%-17s$%.2f\n%-17s$%.2f\n%-17s$%.2f\n%-17s$%.2f",
						"1) jeff-azon: ", priceJeff, "2) wally-marty: ", priceWally, "3) blizz-craft: ", priceBlizz,
						"4) sprin-kles: ", priceSprin, "5) temp-portals: ", priceTemp);
				System.out.println();
				menu = sc.nextInt();
				System.out.println("How many shares of stock would you like to purchase?");
				numPurchased = sc.nextInt();
				switch (menu) {
				// jeff-azon
				case 1:
					if (totalCash >= numPurchased * priceJeff) {
						totalCash -= numPurchased * priceJeff;
						numOfJeff += numPurchased;
					} else {
						System.out.println("You do not have enough funds.");
					}
					break;
				// wally-marty
				case 2:
					if (totalCash >= numPurchased * priceWally) {
						totalCash -= numPurchased * priceWally;
						numOfWally += numPurchased;
					} else {
						System.out.println("You do not have enough funds.");
					}
					break;
				// blizz-craft
				case 3:
					if (totalCash >= numPurchased * priceBlizz) {
						totalCash -= numPurchased * priceBlizz;
						numOfBlizz += numPurchased;
					} else {
						System.out.println("You do not have enough funds.");
					}
					break;
				// sprin-kles
				case 4:
					if (totalCash >= numPurchased * priceSprin) {
						totalCash -= numPurchased * priceSprin;
						numOfSprin += numPurchased;
					} else {
						System.out.println("You do not have enough funds.");
					}
					break;
				// temp-portals
				case 5:
					if (totalCash >= numPurchased * priceTemp) {
						totalCash -= numPurchased * priceTemp;
						numOfTemp += numPurchased;
					} else {
						System.out.println("You do not have enough funds.");
					}
					break;
				// back to main menu
				default:
					break;
				}
				break;
			// SELL
			case 2:
				System.out.printf(
						"\nSelect STONK to SELL: \n%-5d%-17s$%.2f \n%-5d%-17s$%.2f\n%-5d%-17s$%.2f\n%-5d%-17s$%.2f"
								+ "\n%-5d%-17s$%.2f",
						numOfJeff, "1) jeff-azon: ", priceJeff, numOfWally, "2) wally-marty: ", priceWally, numOfBlizz,
						"3) blizz-craft: ", priceBlizz, numOfSprin, "4) sprin-kles: ", priceSprin, numOfTemp,
						"5) temp-portals: ", priceTemp);
				System.out.printf("\n%-15s$%.2f", "TOTAL CASH: ", totalCash);
				System.out.println();
				menu = sc.nextInt();
				System.out.println("How many shares of stock would you like to sell?");
				numSold = sc.nextInt();
				switch (menu) {
				// jeff-azon
				case 1:
					totalCash += numSold * priceJeff;
					numOfJeff -= numSold;
					break;
				// wally-marty
				case 2:
					totalCash += numSold * priceWally;
					numOfWally -= numSold;
					break;
				// blizz-craft
				case 3:
					totalCash += numSold * priceBlizz;
					numOfBlizz -= numSold;
					break;
				// sprin-kles
				case 4:
					totalCash += numSold * priceSprin;
					numOfSprin -= numSold;
					break;
				// temp-portals
				case 5:
					totalCash += numSold * priceTemp;
					numOfTemp -= numSold;
					break;
				// back to main menu
				default:
					break;
				}
				break;
			// NEW PRICES
			// each stock is changed by 0-15% each hold, vary with type of stock
			// less than 5 cents stock is set to $0
			case 3:
				// jeff-azon 90-105%
				percentChange = rand.nextDouble(0.90, 1.05);
				priceJeff *= percentChange;
				if (priceJeff < .05) {
					priceJeff = 0;
				}
				// wally-marty 95-105%
				percentChange = rand.nextDouble(0.95, 1.05);
				priceWally *= percentChange;
				if (priceWally < .05) {
					priceWally = 0;
				}
				// blizz-craft 90-105%
				percentChange = rand.nextDouble(0.90, 1.05);
				priceBlizz *= percentChange;
				if (priceBlizz < .05) {
					priceBlizz = 0;
				}
				// sprin-kles 90-110%
				percentChange = rand.nextDouble(0.90, 1.10);
				priceSprin *= percentChange;
				if (priceSprin < .05) {
					priceSprin = 0;
				}
				// temp-portals 85-115%
				percentChange = rand.nextDouble(0.85, 1.15);
				priceTemp *= percentChange;
				if (priceTemp < .05) {
					priceTemp = 0;
				}
				break;
			}

		}
		// Win when you have more than $1000
		System.out.println("Congratulations, you won! Total payout was $" + totalCash + ".");
	}
}
