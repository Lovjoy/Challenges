package Main;

import java.util.Random;
import java.util.Scanner;

//Ray Joy
//10/6/2024
//Mini RPG
//You are tasked with creating a small RPG game. The game will offer the player 
// a choice of what to do, and go into seperate types of gameplay depending on what happens.
//stats.
//The player is a warrior and has no magic. Their damage done with attacks is determined 
//by a random number * Strength.
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		// Player Starting Stats
		int playerStamina = 5;
		int playerMaxHp = playerStamina * 15;
		int playerCurrentHp = playerMaxHp;
		int playerStrength = 5;
		boolean playerRunAway = false;
		int boarCount = 0;
		// Their damage done with attacks is determined
		// by a random number (5 - 15) * Strength
		// starting attacks 25-75 hp per hit
		int playerGold = 0;

		// player attacks
		int playerAttack; 				// Attack Type either melee, special, or run away
		int meleeAttack; 				// 5-15 * strength
		int specialAttack; 				// 5-15 * strength
		int randText; 					// random int to pick text for combat

		// mob stats
		double mobStamina; 				// Player Stamina * random number (0.75-1.25)
		int mobMaxHp; 					// Mob Stamina * 15
		int mobCurrentHp; 				// Resets with each death
		double mobStrength; 			// Player Strength * random number (0.75-1.25)

		// mob attacks
		boolean exploreEnemy; 			// random if when exploring if player finds a boar or gold
		int mobAttackType; 				// random melee, special, or run away/cower
		int mobMelee;					// 1-15 * mob strength
		int mobSpecial; 				// 1-15 * mob strength
		boolean playerTurn = true;
		boolean mobRunAway = false;
		int newGold = 0; 				// gold per exploring is 5-10g // gold gained per kill is 5-15g

		int mainMenuOption = 3; 		// Main menu Explore, Visit town, or see stats. starts with showing stats
		int townMenuOption;				// choice between buying tombs and healing full hp

		System.out.println("Welcome to World of Boarcraft. You are a mighty warrior on a adventure. ");

		while (playerCurrentHp > 0) {
			switch (mainMenuOption) {
			case 1:
				/*
				 * Explore player is exploring, there is a chance they will find a monster to
				 * fight, or 5-10 gold coins. Monsters will have the roughly same stats like a
				 * player does (player stat * random number coefficient) and will always be the
				 * same for the type of monster. A player will always get 5-15g for killing a
				 * monster. They monster may run away and reward no gold. Once a monster is
				 * killed or runs away, the player will be returned to the menu where they can
				 * choose from the main game options again.
				 */
				exploreEnemy = rand.nextBoolean();
				if (exploreEnemy) {
					// Resets at the start of the loop
					playerRunAway = false;
					mobRunAway = false;
					playerTurn = true;

					// Monster stats are scaled with average of player stats with random coefficient
					// (0.75-1.10) or (0.75-1.25)
					mobStrength = ((playerStrength + playerStamina + 1) / 2) * rand.nextDouble(0.75, 1.10);
					mobStamina = ((playerStamina + playerStrength) / 2) * rand.nextDouble(0.75, 1.25);
					// Resets monsters max hp and current hp
					mobMaxHp = (int) (mobStamina * 15);
					mobCurrentHp = mobMaxHp;
					System.out.println("A wild boar appears.");

					while (mobCurrentHp > 0 && playerCurrentHp > 0 && playerRunAway == false && mobRunAway == false) {

						// Boar Attack random three options: Melee, Special, or runaway/cower
						if (playerTurn == false && mobRunAway == false) {

							mobAttackType = rand.nextInt(3);
							switch (mobAttackType) {
							// Random attack
							case 0:
								mobMelee = (int) (rand.nextInt(1, 14) * mobStrength);
								playerCurrentHp -= mobMelee;
								System.out.println("The boar attacks for " + mobMelee + " hp.");
								playerTurn = true;
								break;
							// Random attack
							case 1:
								mobSpecial = (int) (rand.nextInt(1, 14) * mobStrength);
								playerCurrentHp -= mobSpecial;
								System.out.println("The boar charges for " + mobSpecial + " hp.");
								playerTurn = true;
								break;
							// SUPER RUN AWAY! / Cower (0 damage)
							case 2:
								if (mobCurrentHp < (0.2 * mobMaxHp)) {
									//Boar runs away giving no gold
									System.out.println("The boar runs away in fear.");
									playerTurn = true;
									mobRunAway = true;
								} else {
									//Boar cowers in fear, giving player another turn
									System.out.println("The boar cowars in fear.");
									playerTurn = true;
								}
								break;
							}
							// PLAYER DIED
							if (playerCurrentHp <= 0) {
								System.out.println("\nMax HP: " + playerMaxHp + "\nCurrent HP: " + playerCurrentHp
										+ "\nPlayer Strength: " + playerStrength + "\nPlayer Stamina: " + playerStamina
										+ "\nPlayer Gold: " + playerGold + "\nBoar Current Hp: " + mobCurrentHp
										+ "\nBoars Killed: " + boarCount + "\n");
							}
							playerTurn = true;
							// Player Attack
						} else {

							System.out.println("\nChose an action: \n1) Melee Attack\n2) Special Attack\n3) Run Away ");
							playerAttack = sc.nextInt();
							switch (playerAttack) {
							case 1:
								
								//Melee Attack random number 5-15 * strength with 4 random text outputs
								meleeAttack = rand.nextInt(5, 16) * playerStrength;
								randText = rand.nextInt(4);
								switch (randText) {
								case 0:
									System.out.println("You swing your sword for a total of " + meleeAttack + " hp.");
									break;
								case 1:
									System.out.println("You stab the boar for a total of " + meleeAttack + " hp.");
									break;
								case 2:
									System.out.println("You thrust your sword for a total of " + meleeAttack + " hp.");
									break;
								case 3:
									System.out.println("You poke the boar for a total of " + meleeAttack + " hp.");
									break;
								}
								mobCurrentHp -= meleeAttack;

								break;
							case 2:
								//Special attack random number 5-15 * strength with 4 random text outputs
								specialAttack = rand.nextInt(5, 16) * playerStrength;
								randText = rand.nextInt(4);
								switch (randText) {
								case 0:
									System.out
											.println("You bodyslam the boar for a total of " + specialAttack + " hp.");
									break;
								case 1:
									System.out.println(
											"You spitroast the boar for a total of " + specialAttack + " hp.");
									break;
								case 2:
									System.out.println("You ambush the boar for a total of " + specialAttack + " hp.");
									break;
								case 3:
									System.out.println("Your not so special special move does a total of "
											+ specialAttack + " hp.");
									break;
								}
								mobCurrentHp -= specialAttack;
								break;
							case 3:
								// back to main menu
							default:
								playerRunAway = true;
								System.out.println("Main Menu");
								break;
							}
							playerTurn = false;
						}
					}
					// outside while loop
					if (mobCurrentHp <= 0) {
						// congrats you win
						newGold = rand.nextInt(5, 16);
						playerGold += newGold;
						boarCount++;
						System.out.println("You have defeated the boar and collected " + newGold + " gold.");
						mobCurrentHp = mobMaxHp;
					} else if (playerCurrentHp <= 0) {
						// better luck next time
						System.out.println("You have been defeated, better luck next time.");
					}
				} else {
					newGold = rand.nextInt(5, 11);
					System.out.println("You have discovered a small pile of " + newGold + " gold.");
					playerGold += newGold;
				}
				break;
			case 2:
				/*
				 * Go to Town Once a player is in town, they may do one of three things. 
				 * - visit the temple (heals to full hp) 
				 * - purchase a tome of strength (+1 strength for 100 gold) 
				 * - purchase a tome of stamina (+1 stamina for 100 gold)
				 */
				System.out.println("Choose an action:\n1) Visit the temple to restore health\n2) Purchase a Tome "
						+ "of Strength 100g\n3) Purchase a Tome of Stamina 100g\n4) Return to Main Menu");
				townMenuOption = sc.nextInt();
				switch (townMenuOption) {
				case 1:
					playerCurrentHp = playerMaxHp;
					System.out.println("Welcome to the temple, you now have max hp at " + playerCurrentHp
							+ " current health points.");
					break;
				case 2:
					if (playerGold >= 100) {
						playerStrength++;
						playerGold -= 100;
						System.out.println("You now have " + playerStrength + " strength and " + playerGold + " gold.");
					} else {
						System.out.println("You do not have enough gold.");
					}
					break;
				case 3:
					if (playerGold >= 100) {
						playerStamina++;
						playerGold -= 100;
						playerMaxHp = playerStamina * 15;
						playerCurrentHp = playerMaxHp;
						System.out.println("You now have " + playerStamina + " stamina and " + playerGold + " gold.");
					} else {
						System.out.println("You don't have enough gold.");
					}
					break;
				default:
					break;
				}
				break;
			// Player Stats
			case 3:
				System.out.println("\nMax HP: " + playerMaxHp + "\nCurrent HP: " + playerCurrentHp
						+ "\nPlayer Strength: " + playerStrength + "\nPlayer Stamina: " + playerStamina
						+ "\nPlayer Gold: " + playerGold + "\nBoars Killed: " + boarCount);
				break;
			default:
				break;
			}
			// Main Menu
			if (playerCurrentHp > 0) {
				playerRunAway = false;
				System.out.println("\nChoose an action:\n1) Explore the forest\n2) Travel to town\n3) See Stats");
				mainMenuOption = sc.nextInt();
			}

		}
	}

}
