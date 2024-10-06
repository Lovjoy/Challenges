package Main;

import java.util.Random;
import java.util.Scanner;

//		Ray Joy
//		10/3/2024
// 		A video game about chopping down trees and need to use a while loop to represent every game tick. Every game tick, 
//		the player will swing their axe at a tree. Each swing, there is a % chance based on the tree to recieve a log from it, and for each log taken there 
//		is a 7% chance for the tree to fall early. Additionally, you need to track how much experience the player has gained by chopping these trees, which is awarded per log.

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
//		There are five different types of trees. These trees offer a different amount of maximum possible 
//		logs before the tree falls and must respawn again. 
//		Each tree also has its own success rate for recieving a log per game tick spent chopping.
//

		int regTree = 1;
		int oakTree = 15;
		int willowTree = 17;
		int mapleTree = 22;
		int yewTree = 32;
		int treeType;
		int logs = 0;
		int chop = 0;
		int playerXp = 0;
		double percent;
		double axeBonus;
		int axeType;

		String star = "";
		System.out
				.println("Select an axe: \n1) bronze axe\n2) iron axe\n3) steel axe\n4) enchanted axe\n5) orange axe");
		axeType = scnr.nextInt();
		switch (axeType) {
//		Players can also use different axes, the higher ranked axe, the higher chance per game 
//		tick to get the log		bronze axe - 1%	
//		iron axe - 3%		steel axe - 5%		enchanted axe - 7%		orange axe - 10%
		case 1:
			axeBonus = 0.01;
			break;
		case 2:
			axeBonus = 0.03;
			break;
		case 3:
			axeBonus = 0.05;
			break;
		case 4:
			axeBonus = 0.07;
			break;
		case 5:
			axeBonus = 0.10;
			break;
		default:
			axeBonus = 0;
		}

		System.out.println("Select a tree: \n1) regular\n2) oak\n3) willow\n4) maple\n5) yew");
		treeType = scnr.nextInt();

//		Every time a tree has a log taken from it, there is a 7% chance that the tree will fall 
//		before harvesting the maximum logs. 

//		Regular trees - 1 log, 60% chance per tick, 20XP per
		switch (treeType) {
		case 1:
			while (regTree > 0) {
				chop++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Chop");
				percent = rand.nextDouble();
				if (percent >= (0.4 - axeBonus)) {
					logs++;
					regTree--;
					playerXp = playerXp + 20;
					star += '*';
					System.out.println(star);
					percent = rand.nextDouble();
					if (percent <= 0.07) {
						regTree = 0;
						System.out.println("Crack");
						try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Timber!!!");
						try {
							Thread.sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("CRASH!!");
						
						System.out.println("The tree has fallen.");
					}
				}
			}
			break;
//		Oak trees - 15 logs, 55% chance per tick, 35XP per
		case 2:
			while (oakTree > 0) {
				chop++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Chop");
				percent = rand.nextDouble();
				if (percent >= (0.45 - axeBonus)) {
					logs++;
					oakTree--;
					playerXp = playerXp + 35;
					star += '*';
					System.out.println(star);
					percent = rand.nextDouble();
					if (percent <= 0.07) {
						oakTree = 0;
						System.out.println("Crack");
						try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Timber!!!");
						try {
							Thread.sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("CRASH!!");
						
						System.out.println("The tree has fallen.");
					}
				}
			}
			break;
//		Willow trees - 17 logs, 50% chance per tick, 40XP per
		case 3:
			while (willowTree > 0) {
				chop++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Chop");
				percent = rand.nextDouble();
				if (percent >= (0.5 - axeBonus)) {
					logs++;
					willowTree--;
					playerXp = playerXp + 40;
					star += '*';
					System.out.println(star);
					percent = rand.nextDouble();
					if (percent <= 0.07) {
						willowTree = 0;
						System.out.println("Crack");
						try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Timber!!!");
						try {
							Thread.sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("CRASH!!");
						
						System.out.println("The tree has fallen.");
					}
				}
			}
			break;
//		Maple trees -22 logs, 45% chance per tick, 50XP per
		case 4:
			while (mapleTree > 0) {
				chop++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Chop");
				percent = rand.nextDouble();
				if (percent >= (0.55 - axeBonus)) {
					logs++;
					mapleTree--;
					playerXp = playerXp + 60;
					star += '*';
					System.out.println(star);
					percent = rand.nextDouble();
					if (percent <= 0.07) {
						mapleTree = 0;
						System.out.println("Crack");
						try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Timber!!!");
						try {
							Thread.sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("CRASH!!");
						
						System.out.println("The tree has fallen.");
					}
				}
			}
			break;
//		Yew trees - 32 logs, 40% chance per tick, 60XP per
		case 5:
			while (yewTree > 0) {
				chop++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Chop");
				percent = rand.nextDouble();
				if (percent >= (0.6 - axeBonus)) {
					logs++;
					yewTree--;
					playerXp += 60;
					star += '*';
					System.out.println(star);
					percent = rand.nextDouble();
					if (percent <= 0.07) {
						yewTree = 0;
						System.out.println("Crack");
						try {
							Thread.sleep(600);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Timber!!!");
						try {
							Thread.sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("CRASH!!");
						
						System.out.println("The tree has fallen.");
					}
				}
			}
			break;

		default:
		}
		System.out.println("You have collected " + logs + " logs, gained " + playerXp + " XP" + " in a total of " + chop
				+ " chops.");
//		Trees always fall when the maximum amount of logs has been cut. 
//		After the tree is fully cut, state how many logs the player got, their XP, and how many chops (game ticks) it took
	}

}
