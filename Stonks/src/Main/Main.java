package Main;

import java.util.Random;
import java.util.Scanner;

//Ray Joy
//10/11/2024

//Challenge - Stonks
//
//You are put in charge of writing a game about playing stocks. There are 5 stocks the player can manipulate.
//
//jeff-azon 
//wally-marty
//blizz-craft
//sprin-kles
//temp-portals
//

//
//Each round, the player can choose to buy from any of the 5 stocks and buy as many shares as they like before ending the 
//turn. The next turn always causes the price of the stocks to fluctuate, gaining or losing anywhere from -5% to +5% value. 
//Stocks cannot go below 10 cents. Additionally, the player may end the turn without buying anything. The player must 
//accumulate 1000$ to win.
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		// Initially, the player will be given 20$. The stock prices for each stock will
		// be set at a random value from 1.00-3.00$.
		double priceJeff = rand.nextDouble(1, 3);
		double priceWally = rand.nextDouble(1, 3);
		double priceBlizz = rand.nextDouble(1, 3);
		double priceSprin = rand.nextDouble(1, 3);
		double priceTemp = rand.nextDouble(1, 3);
		double totalCash = 20;
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
		double percentChange; // Random gain or loss of 5%

		while (totalCash > 0) {

			System.out.printf("STONK PRICES: \n%-15s$%.2f \n%-15s$%.2f\n%-15s$%.2f\n%-15s$%.2f" + "\n%-15s$%.2f",
					"jeff-azon: ", priceJeff, "wally-marty: ", priceWally, "blizz-craft: ", priceBlizz, "sprin-kles: ",
					priceSprin, "temp-portals: ", priceTemp);
			System.out.printf("\n%-15s$%.2f", "TOTAL CASH: ", totalCash);

			System.out.println("\nSelect an option: \n1) Buy \n2) Sell\n3) Hold");
			menu = sc.nextInt();

			switch (menu) {
			// BUY
			case 1:
				System.out.println("\nSelect Stonk to purchase: \n1) jeff-azon\n2) wally-marty\n3 blizz-craft"
						+ "\n4) sprin-kles\n5) temp-portals");
				menu = sc.nextInt();
				System.out.println("How many shares of stock would you like to purchase?");
				numPurchased = sc.nextInt();
				switch (menu) {
				// jeff-azon
				case 1:
					totalCash -= numPurchased * priceJeff;
					numOfJeff += numPurchased;
					break;
				// wally-marty
				case 2:
					totalCash -= numPurchased * priceWally;
					numOfWally += numPurchased;
					break;
				// blizz-craft
				case 3:
					totalCash -= numPurchased * priceBlizz;
					numOfBlizz += numPurchased;
					break;
				// sprin-kles
				case 4:
					totalCash -= numPurchased * priceSprin;
					numOfSprin += numPurchased;
					break;
				// temp-portals
				case 5:
					totalCash -= numPurchased * priceTemp;
					numOfTemp += numPurchased;
					break;
				// back to main menu
				default:
					break;
				}
				break;
			// SELL
			case 2:
				System.out.printf("CURRENT HOLDINGS: \n%-15s%d \n%-15s%d\n%-15s%d\n%-15s%d" + "\n%-15s%d",
						"jeff-azon: ", numOfJeff, "wally-marty: ", numOfWally, "blizz-craft: ", numOfBlizz,
						"sprin-kles: ", numOfSprin, "temp-portals: ", numOfTemp);
				System.out.printf("\n%-15s$%.2f", "TOTAL CASH: ", totalCash);
				System.out.println("\nSelect Stonk to sell: \n1) jeff-azon\n2) wally-marty\n3) blizz-craft"
						+ "\n4) sprin-kles\n5) temp-portals");
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
			case 3:
				percentChange = rand.nextDouble(0.95, 1.05);
				priceJeff *= percentChange;
				percentChange = rand.nextDouble(0.95, 1.05);
				priceWally *= percentChange;
				percentChange = rand.nextDouble(0.95, 1.05);
				priceBlizz *= percentChange;
				percentChange = rand.nextDouble(0.95, 1.05);
				priceSprin *= percentChange;
				percentChange = rand.nextDouble(0.95, 1.05);
				priceTemp *= percentChange;
				break;
			}

		}
	}
}
